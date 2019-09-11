package com.example.restapi.rest;

import com.example.restapi.rest.model.Product;
import com.example.restapi.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

    private ProductRepository productRepository;

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Product product= new Product();

        product.setName("AAA");
        product.setCategory("Special");
        product.setType("CUSTOM");
        product.setDescription("This is tester product");
        productRepository.save(product);

    }

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

}
