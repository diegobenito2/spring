package com.example;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        var repository = context.getBean(ProductRepository.class);

//        List<Category> categories = List.of(
//                new Category("category1", "description1", "image1.jpg", true,new Date(), null),
//                new Category("category2", "description2", "image2.jpg", true,new Date(), null),
//                new Category("category3", "description3", "image3.jpg", true,new Date(), null)
//        );
//        repository.saveAll(categories);
//
//        List<Product> products = List.of(
//                new Product("product1", 5.99, 1, categories.get(0)),
//                new Product( "product2", 6.99, 2, categories.get(1)),
//                new Product( "product3", 7.99, 4, categories.get(2)),
//                new Product("product4", 8.99, 2, categories.get(0)),
//                new Product( "product5", 8.99, 2, categories.get(1)),
//                new Product( "product6", 8.99, 2, categories.get(2))
//        );
        List<Product> products = List.of(
                new Product("product1", 5.99, 1, null),
                new Product("product2", 6.99, 2, null),
                new Product("product3", 7.99, 4, null),
                new Product("product4", 8.99, 2, null),
                new Product("product5", 8.99, 2, null),
                new Product("product6", 8.99, 2, null)
        );
        repository.saveAll(products);
    }

}
