package githubFabri.AppControlStockAlmacen.servicio;

import githubFabri.AppControlStockAlmacen.modelo.Sale;
import githubFabri.AppControlStockAlmacen.repositorio.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    // Registra una nueva venta
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    // Obtiene todas las ventas por categoría
    public List<Sale> getSalesByCategory(String category) {
        return saleRepository.findByProductCategory(category);
    }

    // Calcula el promedio de ventas por producto en una categoría
    public Map<String, Double> getAverageSalesByCategory(String category) {
        List<Sale> sales = saleRepository.findByProductCategory(category);

        // Agrupar por producto y calcular el promedio
        return sales.stream()
                .collect(Collectors.groupingBy(
                        sale -> sale.getProduct().getName(),
                        Collectors.averagingInt(Sale::getQuantitySold)
                ));
    }
}
