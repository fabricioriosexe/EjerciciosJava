package githubFabri.AppControlStockAlmacen.repositorio;

import githubFabri.AppControlStockAlmacen.modelo.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    // Obtiene todas las ventas relacionadas con una categoría específica
    List<Sale> findByProductCategory(String category);
}
