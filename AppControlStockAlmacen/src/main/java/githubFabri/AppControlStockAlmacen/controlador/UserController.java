package githubFabri.AppControlStockAlmacen.controlador;

import githubFabri.AppControlStockAlmacen.modelo.User;
import githubFabri.AppControlStockAlmacen.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Maneja la solicitud POST para el inicio de sesión.
     * @param userDTO Objeto User con el nombre de usuario y la contraseña.
     * @return Respuesta JSON con el resultado del intento de inicio de sesión.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User userDTO) {
        boolean authenticated = userService.verifyUser(userDTO.getUsername(), userDTO.getPassword());
        if (authenticated) {
            return ResponseEntity.ok().body("{\"success\": true}");
        } else {
            return ResponseEntity.ok().body("{\"success\": false}");
        }
    }

    /**
     * Maneja la solicitud POST para el registro de un nuevo usuario.
     * @param userDTO Objeto User con el nombre de usuario y la contraseña.
     * @return Respuesta JSON con el resultado del intento de registro.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User userDTO) {
        boolean registered = userService.registerUser(userDTO.getUsername(), userDTO.getPassword());
        if (registered) {
            return ResponseEntity.ok().body("{\"success\": true}");
        } else {
            return ResponseEntity.ok().body("{\"success\": false}");
        }
    }
}
