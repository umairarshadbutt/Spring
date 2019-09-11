package com.example.restapi.rest.controller;


import com.example.restapi.rest.model.Product;
import com.example.restapi.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/products/")
public class ProductsController {

    private  ProductRepository productRepository;

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(path = "{id", method = RequestMethod.GET)
    public Product getProduct(@PathVariable(name = "id") String id){
    return productRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody Product productToSave){

        return productRepository.save(productToSave);
    }
}
