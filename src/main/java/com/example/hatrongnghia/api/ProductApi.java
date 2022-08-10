package com.example.hatrongnghia.api;

import com.example.hatrongnghia.entity.Product;
import com.example.hatrongnghia.repository.ProductRepository;
import com.example.hatrongnghia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
@CrossOrigin("*")
public class ProductApi {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @RequestMapping(method = RequestMethod.POST, path = "{id}/{quantity}")
    public ResponseEntity<?> sellProduct(@PathVariable int id,
                                         @PathVariable int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setQuantity(product.getQuantity() - quantity);
            return ResponseEntity.ok(productService.sellProduct(product));
        }
        return ResponseEntity.badRequest().build();
    }
}
