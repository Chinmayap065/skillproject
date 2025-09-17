package com.mtd.EcomApp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtd.EcomApp.entity.Product;
import com.mtd.EcomApp.repository.Productrepository;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private Productrepository productRepository;

    // Create
    public Product saveProduct(Product product) {
        log.info("Creating product: {}", product.getName());
        product.setId(null);
        validate(product);
        return productRepository.save(product);
    }

    // Get by id
    public Product getProductById(String id) {
        log.info("Finding product by id: {}", id);
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            log.error("Product not found: {}", id);
            throw new RuntimeException("Product not found: " + id); // replace with custom exception
        }
        return optionalProduct.get();
    }

    // Get all
    public List<Product> getProducts() {
        log.info("Finding all products");
        return productRepository.findAll();
    }

    // Delete
    public boolean deleteProduct(String id) {
        log.info("Deleting product by id: {}", id);
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            log.error("Product not found: {}", id);
            throw new RuntimeException("Product not found: " + id); // replace with custom exception
        }
        productRepository.deleteById(id);
        return true;
    }

    // Update
    public Product updateProduct(Product product, String id) {
        log.info("Updating product by id: {}", id);
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            log.error("Product not found: {}", id);
            throw new RuntimeException("Product not found: " + id); // replace with custom exception
        }

        Product existingProduct = optionalProduct.get();
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setTags(product.getTags());
        existingProduct.setStock(product.getStock());

        validate(existingProduct);
        return productRepository.save(existingProduct);
    }

    // Validation
    private void validate(Product product) {
        if (product.getPrice() < 0) {
            log.error("Price cannot be negative");
            throw new RuntimeException("Price cannot be negative");
        }
        if (product.getStock() < 0) {
            log.error("Stock cannot be negative");
            throw new RuntimeException("Stock cannot be negative");
        }
    }
}

	
