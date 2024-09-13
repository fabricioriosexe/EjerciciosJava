package githubFabri.AppControlStockAlmacen.repositorio;

import githubFabri.AppControlStockAlmacen.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Método para encontrar productos por categoría
    List<Product> findByCategory(String category);
}
