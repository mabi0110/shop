package pl.javastart.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public List<Product> getProducts(@RequestParam(required = false) String name) {
        if (name != null) {
            return productRepository.findAllByName(name);
        } else {
            return productRepository.findAll();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/producer")
    ResponseEntity<Producer> getProducerByProduct(@PathVariable Integer id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            Producer producer = product.getProducer();
            if (producer != null) {
                return ResponseEntity.ok(producer);
            }
        }
        return ResponseEntity.notFound().build();
    }


}
