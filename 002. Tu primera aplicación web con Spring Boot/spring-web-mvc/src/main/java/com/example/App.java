package com.example;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        var repository = context.getBean(ProductRepository.class);

        List<Product> products = List.of(
                new Product(null, "Pantalón", 5.99, 1),
                new Product(null, "Sudadera", 6.99, 2),
                new Product(null, "Zapatos", 7.99, 4),
                new Product(null, "Mancuerna", 8.99, 2),
                new Product(null, "Rodillera", 8.99, 2),
                new Product(null, "Balón", 8.99, 2),
                new Product(null, "Zapatillas", 69.99, 20)
        );
        repository.saveAll(products);

        List<Product> products2 = repository.findAllByPrice(8.99);
        products2.forEach(System.out::println);

    }

}
