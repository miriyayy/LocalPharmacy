package com.springBoot.pharmacy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.pharmacy.business.abstracts.ProductService;
import com.springBoot.pharmacy.entities.Product;
@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
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
	
	@PutMapping("/api/update/{id}")
	public ResponseEntity<?>update(@PathVariable int id,@RequestBody Product product){
		return ResponseEntity.ok(this.productService.update(id, product));
	}

}
