package githubFabri.AppControlStockAlmacen.repositorio;

import githubFabri.AppControlStockAlmacen.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     * @param username Nombre de usuario.
     * @return Usuario encontrado o null si no se encuentra.
     */
    User findByUsername(String username);
}
