package githubFabri.AppControlStockAlmacen.servicio;

import githubFabri.AppControlStockAlmacen.modelo.Product;
import githubFabri.AppControlStockAlmacen.repositorio.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Obtiene todos los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtiene un producto por ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Crea un nuevo producto
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Actualiza un producto existente
    public Product updateProduct(Long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    // Elimina un producto por ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Obtiene productos por categoría
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}
