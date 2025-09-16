package com.mtd.EcomApp.service;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtd.EcomApp.entity.Product;
import com.mtd.EcomApp.repository.Productrepository;

@Service
public class ProductService {
	@Autowired
	private Productrepository productRepository;
	//save
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	//get by id
	public Product getProductbyId(String id) {
		return productRepository.findById(id).get();
	}
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	//delete product from database
	public boolean deleteProduct(String id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isEmpty()) {
			return false;
		}
		productRepository.deleteById(id);
		return true;
	}
	
	//update
	public Product updateProduct(Product product, String id) {
		Product existingProduct = productRepository.findById(id).get();
		
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setTags(product.getTags());
		existingProduct.setStock(product.getStock());
		return productRepository.save(existingProduct);
	}
	
}
