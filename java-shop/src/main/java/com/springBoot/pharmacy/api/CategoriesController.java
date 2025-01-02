package com.springBoot.pharmacy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.pharmacy.business.abstracts.CategoryService;
import com.springBoot.pharmacy.entities.Category;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

		
		private CategoryService categoryService;
		
		@Autowired
		public CategoriesController(CategoryService categoryService) {
			super();
			this.categoryService = categoryService;
		}
		
		@GetMapping("/getAll")
		public  ResponseEntity<?>getAll(){
			return ResponseEntity.ok(this.categoryService.getAll());
		}
		
		@PostMapping("/add")
		public ResponseEntity<?> add(@RequestBody Category category) {
			return ResponseEntity.ok(this.categoryService.add(category));
		}
		


}
