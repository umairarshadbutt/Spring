package com.example.repository.repository;

import com.example.repository.repository.model.Product;
import com.example.repository.repository.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {


    private ProductRepository productRepository;
    private Logger LOG= LoggerFactory.getLogger(RepositoryApplication.class);

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

        Product product2 = new Product();
        product2.setName("Another Tester Product");
        product2.setDescription("This is tester product");
        product2.setCategory("Test");
        product2.setType("Custom");
        product2.setPrice(15.0);
        productRepository.save(product2);

//        List<Product> products= productRepository.findAll();
//        for (Product product: products){
//            LOG.info("Products found: "+ product.toString());
//        }


//        Product resultProduct = productRepository.findByType("Custom");
//        LOG.info("CUSTOM type of product found "+ resultProduct.toString());



//        List<Product> results = productRepository.findByDescriptionAndCategory("This is tester product","Test");
//        for (Product product: results){
//            LOG.info("Matching results are: "+ product.toString());
//        }


        List<String> names = new ArrayList<>();
        names.add("Tester Product");
        // names.add("Another Tester Product");

        List<Product> resultProducts = productRepository.findByCategoryAndNameIn("Test",names);

        for(Product product: resultProducts){
            LOG.info("Matching results for findByCategoryAndNameIn: "+ product.toString());
        }
    }
}
