package com.ecommerce.pharmacy.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.pharmacy.entities.concretes.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}
