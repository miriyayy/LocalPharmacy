package com.ecommerce.pharmacy.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.pharmacy.business.abstracts.ProductService;
import com.ecommerce.pharmacy.core.utilities.results.DataResult;
import com.ecommerce.pharmacy.core.utilities.results.Result;
import com.ecommerce.pharmacy.core.utilities.results.SuccessDataResult;
import com.ecommerce.pharmacy.core.utilities.results.SuccessResult;
import com.ecommerce.pharmacy.dataAccess.abstracts.ProductDao;
import com.ecommerce.pharmacy.entities.concretes.Product;

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
	
	
	
	
	
	

}
