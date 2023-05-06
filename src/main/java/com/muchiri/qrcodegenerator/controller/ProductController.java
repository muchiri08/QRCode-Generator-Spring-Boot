package com.muchiri.qrcodegenerator.controller;

import com.muchiri.qrcodegenerator.entity.Product;
import com.muchiri.qrcodegenerator.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestParam String name, @RequestParam Integer cost){
        productService.createProduct(name, cost);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }
}
