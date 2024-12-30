package com.ecommerce.pharmacy.business.abstracts;

import java.util.List;

import com.ecommerce.pharmacy.core.utilities.results.DataResult;
import com.ecommerce.pharmacy.core.utilities.results.Result;
import com.ecommerce.pharmacy.entities.concretes.Product;

public interface ProductService {
	
	DataResult<List<Product>>getAll();
	Result add(Product product);

}
