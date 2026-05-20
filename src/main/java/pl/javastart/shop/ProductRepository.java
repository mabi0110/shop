package pl.javastart.shop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(
                new Product(1, "mleko", 3.60, new Producer("Łaciate", new Address("Warszawa", "01-200", "Kwiatowa 42/4"))));
        products.add(
                new Product(2, "czekolada", 5.50, new Producer("Wedel", new Address("Kraków", "00-500", "Ratuszowa 44/67"))));
        products.add(
                new Product(3, "kawa", 22.50, new Producer("Tchibo", new Address("Warszawa", "01-964", "Piękna 3/56"))));
    }

    List<Product> findAll() {
        return products;
    }

    List<Product> findAllByName(String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .toList();
    }

    Product findById(int id) {
        if (id > products.size()) {
            return null;
        } else {
            return products.get(id - 1);
        }
    }
}
