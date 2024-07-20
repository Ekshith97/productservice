package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private Productrepository productrepository;
    private CategoryRepository categoryRepository;
    @Autowired
    public SelfProductService(Productrepository productrepository,CategoryRepository categoryRepository) {
        this.productrepository = productrepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
