package com.example.hatrongnghia.service;

import com.example.hatrongnghia.entity.Product;
import com.example.hatrongnghia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    public Product sellProduct(Product product) {
        return productRepository.save(product);
    }
}
