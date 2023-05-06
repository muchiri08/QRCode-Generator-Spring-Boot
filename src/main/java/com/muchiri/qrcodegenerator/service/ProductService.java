package com.muchiri.qrcodegenerator.service;

import com.muchiri.qrcodegenerator.entity.Product;
import com.muchiri.qrcodegenerator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(String name, Integer cost){
        Product product = new Product();
        product.setName(name);
        product.setCost(cost);

        productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products;
    }
}
