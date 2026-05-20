package pl.javastart.shop;

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
    public Product getProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @GetMapping("/{id}/producer")
    public Producer getProducerByProduct(@PathVariable Integer id) {
        return productRepository.findById(id).getProducer();
    }


}
