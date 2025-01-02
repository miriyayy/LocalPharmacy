package com.springBoot.pharmacy.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.pharmacy.entities.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
