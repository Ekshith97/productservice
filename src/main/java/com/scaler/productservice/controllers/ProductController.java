package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public List<Product> getAllProducts()
    {
        return new ArrayList<Product>();
    }


    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id)
    {
        return new Product();
    }
    @PostMapping()
    public Product addNewProduct(@RequestBody Product product)
    {
       Product p= new Product();
       p.setTitle("First Product");
       return p;
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
