package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts()
    {
        ResponseEntity<List<Product>> responseEntity=new ResponseEntity<>(productService.getAllProducts(), HttpStatus.NOT_FOUND);
       return  responseEntity;

    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id)
    {
        ResponseEntity<Product> response=new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.NOT_FOUND);
        return  response;

    }
    @PostMapping()
    public Product addNewProduct(@RequestBody Product product)
    {
     // return productService.addNewProduct(product);
        return new Product();

    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product)
    {
        return new Product();
    }
    @PutMapping("/{id}")
    public Product replaceproduct(@PathVariable("id") Long id, @RequestBody Product product)
    {
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {

    }



}
