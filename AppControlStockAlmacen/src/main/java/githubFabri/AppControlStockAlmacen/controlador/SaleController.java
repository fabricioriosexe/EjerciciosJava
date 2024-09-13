package githubFabri.AppControlStockAlmacen.controlador;

import githubFabri.AppControlStockAlmacen.modelo.Sale;
import githubFabri.AppControlStockAlmacen.servicio.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    // Registra una nueva venta
    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        Sale createdSale = saleService.createSale(sale);
        return ResponseEntity.ok(createdSale);
    }

    // Obtiene el promedio de ventas por producto en una categoría
    @GetMapping("/average/category/{category}")
    public ResponseEntity<Map<String, Double>> getAverageSalesByCategory(@PathVariable String category) {
        Map<String, Double> averageSales = saleService.getAverageSalesByCategory(category);
        return ResponseEntity.ok(averageSales);
    }
}
