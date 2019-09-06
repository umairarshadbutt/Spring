package com.example.repository.repository;

import com.example.repository.repository.model.Product;
import com.example.repository.repository.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {


    private ProductRepository productRepository;

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product();
        product1.setName("Tester Product");
        product1.setDescription("This is tester product");
        product1.setCategory("Test");
        product1.setType("General");
        product1.setPrice(0.0);
        productRepository.save(product1);

    }
}
