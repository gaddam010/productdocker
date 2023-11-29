package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;
 
@RestController
@RequestMapping("/api")
 
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	
	
	@GetMapping("/products")
	public List<Product>viewProductList() {
		List<Product> listproducts = service.listAll();
		return listproducts;
	}
	@GetMapping("/products/{pid}")
	public Optional<Product> findByProduct(@PathVariable int pid) {
		return service.getProduct(pid);
	}
	@PostMapping("/products")
	public Product createEmployee(@Valid @RequestBody Product newProduct) {
		return service.createProduct(newProduct);
	}
	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id")Integer productId){
		return service.deleteProduct(productId);
	}
	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable(value="id") Integer id, @Valid @RequestBody Product newProduct) {
		return service.updateProduct(id, newProduct);

	}
}

	