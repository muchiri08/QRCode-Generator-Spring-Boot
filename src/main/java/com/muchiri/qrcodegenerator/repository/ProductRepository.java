package com.muchiri.qrcodegenerator.repository;

import com.muchiri.qrcodegenerator.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
