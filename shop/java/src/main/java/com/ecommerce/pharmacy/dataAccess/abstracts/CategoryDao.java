package com.ecommerce.pharmacy.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.pharmacy.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
