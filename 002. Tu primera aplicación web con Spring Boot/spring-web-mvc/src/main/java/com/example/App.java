package com.example;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.CategoryRepository;
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
        var repositoryproc = context.getBean(ProductRepository.class);
        var repositorycat = context.getBean(CategoryRepository.class);

        String imagen = "https://img.freepik.com/foto-gratis/seccion-baja-mano-hombre-negocios-atar-cordones-zapatos_23-2147937473.jpg?t=st=1739437682~exp=1739441282~hmac=5dae8eee2d1b649904e8fed178cd0975a91a0e53a6479c7d1015c0fbd808eb88&w=360";
        List<Category> categories = List.of(
                new Category("category1", "description1", imagen, true, new Date()),
                new Category("category2", "description2", imagen, false, new Date()),
                new Category("category3", "description3", imagen, true, new Date()),
                new Category("category4", "description4", null, true, new Date()),
                new Category("category5", "description5", null, false, new Date()),
                new Category("category6", "description6", imagen, true, new Date())

        );
        repositorycat.saveAll(categories);

        List<Product> products = List.of(
                new Product("product1", 5.99, 1),
                new Product("product2", 6.99, 2),
                new Product("product3", 7.99, 4),
                new Product("product4", 8.99, 2),
                new Product("product5", 8.99, 2),
                new Product("product6", 8.99, 2)
        );
        repositoryproc.saveAll(products);

    }

}
