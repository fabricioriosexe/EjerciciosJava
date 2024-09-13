package githubFabri.AppControlStockAlmacen.servicio;

import githubFabri.AppControlStockAlmacen.modelo.User;
import githubFabri.AppControlStockAlmacen.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Verifica si las credenciales del usuario son correctas.
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public boolean verifyUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    /**
     * Registra un nuevo usuario si el nombre de usuario no está en uso.
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     * @return true si el usuario fue registrado con éxito, false si el nombre de usuario ya está en uso.
     */
    public boolean registerUser(String username, String password) {
        if (userRepository.findByUsername(username) == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password); // Recuerda usar encriptación en producción
            userRepository.save(newUser);
            return true;
        }
        return false;
    }
}
