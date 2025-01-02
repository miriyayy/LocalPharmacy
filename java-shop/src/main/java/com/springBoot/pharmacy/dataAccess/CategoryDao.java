package com.springBoot.pharmacy.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.pharmacy.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
