package pl.javastart.shop;

import org.springframework.http.HttpStatus;
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
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/producer")
    ResponseEntity<Producer> getProducerByProduct(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(Product::getProducer)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/example")
    @ResponseStatus(HttpStatus.CREATED)
    void example() {

    }

}
