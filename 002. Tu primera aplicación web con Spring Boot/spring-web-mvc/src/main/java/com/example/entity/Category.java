package com.example.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.Date;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String imageUrl;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private Timestamp creationDate;

    @OneToMany(mappedBy = "category",orphanRemoval = false)
    private Set<Product> products;

    public Category() {
        this.creationDate = new Timestamp(System.currentTimeMillis());
    }

    public Category(String name, String description, String imageUrl, boolean active, Date creationDate) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.active = active;
        this.creationDate = new Timestamp(creationDate.getTime());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", active=" + active +
                ", creationDate=" + creationDate +
                ", products=" + products +
                '}';
    }
}
