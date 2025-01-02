package com.springBoot.pharmacy.business.abstracts;
import java.util.List;

import com.springBoot.pharmacy.entities.Product;

import core.utilities.results.DataResult;
import core.utilities.results.Result;

public interface ProductService {

	DataResult<List<Product>>getAll();
	Result add(Product product);
	Result update(int id,Product updateProduct);
}
