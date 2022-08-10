package com.example.hatrongnghia.seeder;

import com.example.hatrongnghia.entity.Product;
import com.example.hatrongnghia.repository.ProductRepository;
import com.example.hatrongnghia.util.NumberUtil;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductSeeder {

    @Autowired
    ProductRepository productRepository;

    public static List<Product> products;
    Faker faker = new Faker();
    public void productSeeder() {
        products = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            products.add(Product.builder()
                    .name(faker.food().sushi())
                    .price(NumberUtil.getRandomNumber(100, 9999) * 1000)
                    .quantity(NumberUtil.getRandomNumber(1,100))
                    .build());
        }
        productRepository.saveAll(products);
    }
}
