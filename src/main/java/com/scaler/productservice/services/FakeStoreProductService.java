package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public  class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        return product;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        //int a=1/0;
        FakeStoreProductDto productDto=restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);
        if(productDto==null)
        {
            throw new ProductNotFoundException("product with id"+id+"not found");
        }

        return convertFakeStoreProductDtoToProduct(productDto);
    }
    public FakeStoreProductDto convertproductDtoToFakeStoreProductDto(Product product)
    {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        return fakeStoreProductDto;
    }
    @Override
    public Product addNewProduct(Product product) {
        FakeStoreProductDto dto=convertproductDtoToFakeStoreProductDto(product);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(dto, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fdto= restTemplate.execute("https://fakestoreapi.com/products", HttpMethod.POST, requestCallback, responseExtractor);

              return convertFakeStoreProductDtoToProduct(fdto);

    }


    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] response=restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products=new ArrayList<>();
        for(FakeStoreProductDto dto:response)
        {
            products.add(convertFakeStoreProductDtoToProduct(dto));

        }
        return products;
    }
}
