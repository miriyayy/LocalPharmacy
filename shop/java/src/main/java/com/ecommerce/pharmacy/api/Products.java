package com.ecommerce.pharmacy.api;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.pharmacy.business.abstracts.ProductService;

import com.ecommerce.pharmacy.entities.concretes.Product;


@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class Products {
	
	private ProductService productService;

	@Autowired
	public Products(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?>getAll(){
		return ResponseEntity.ok(this.productService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Product product) {
		return ResponseEntity.ok(productService.add(product));
	}
	

	
	

}
