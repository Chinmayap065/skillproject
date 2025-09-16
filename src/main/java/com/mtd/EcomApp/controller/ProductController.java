package com.mtd.EcomApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.mtd.EcomApp.entity.Product;
import com.mtd.EcomApp.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	@GetMapping("/{id}")
	public Product findById(String id) {
		return productService.getProductbyId(id);
	}
	
	@GetMapping("/all")
	public List<Product> findAll(){
		return productService.getProducts();
	}
	@PutMapping("/{id}")
	public Product updateProduct(Product product,String id) {
		return productService.updateProduct(product, id);
	}
	@DeleteMapping("/{id}")
	public boolean deleteProduct(String id) {
		return productService.deleteProduct(id);
	}
	

	

}
