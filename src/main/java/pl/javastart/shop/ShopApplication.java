package pl.javastart.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }


    // GET /products
    // GET /products/1
    // GET /products/1/producer/contact
    // POST /products
    // GET /products?orderBy=name,desc
}
