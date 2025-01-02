package com.springBoot.pharmacy.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.pharmacy.business.abstracts.ProductService;
import com.springBoot.pharmacy.dataAccess.ProductDao;
import com.springBoot.pharmacy.entities.Product;

import core.utilities.results.DataResult;
import core.utilities.results.Result;
import core.utilities.results.SuccessDataResult;
import core.utilities.results.SuccessResult;

@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "listed");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("saved");
	}

	@Override
	public Result update(int id ,Product updateProduct) {
		Product updatedProduct=this.productDao.getById(id);
		updatedProduct.setImageUrl(updateProduct.getImageUrl());
		this.productDao.save(updatedProduct);
		return new SuccessResult("updated");
	}
	

	
	
	
	
	
	

}
