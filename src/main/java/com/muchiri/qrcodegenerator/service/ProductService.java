package com.muchiri.qrcodegenerator.service;

import com.google.zxing.WriterException;
import com.muchiri.qrcodegenerator.entity.Product;
import com.muchiri.qrcodegenerator.repository.ProductRepository;
import com.muchiri.qrcodegenerator.util.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

        //Generate and store barcode for each product
        if(!products.isEmpty()){
            products.forEach(product -> {
                try {
                    QRCodeGenerator.GenerateQRCode(product);
                } catch (WriterException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        return products;
    }
}
