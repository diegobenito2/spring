package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    List<Product> findAllByQuantityBetween(Integer min, Integer max);
    List<Product> findAllByNameContaining(String name);
    List<Product> findAllByPrice(Double price);
}
