package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;

@RestController
public class ProductController {
	
	public List <Product> products;
	public ProductController() {
		
		this.products = new ArrayList<Product>();
		for (int i=0; i<5; i++) {
			Product p = new Product();
			p.id = i;
			p.name = "toto"+i;
			p.price = 0.1;
			this.products.add(p);
		}
			
		
	}
	@PostMapping(path="/order")
	public TransactionResp order(@RequestBody List<ProductItem>items) {
		return new TransactionResp("1");
	}
	@GetMapping(path="/products")
	public List<Product>getProducts(){
		return this.products;
	}
}
