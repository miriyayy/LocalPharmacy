package com.ecommerce.pharmacy.business.abstracts;

import java.util.List;

import com.ecommerce.pharmacy.core.utilities.results.DataResult;
import com.ecommerce.pharmacy.core.utilities.results.Result;
import com.ecommerce.pharmacy.entities.concretes.Category;

public interface CategoryService {
	DataResult<List<Category>>getAll();
	Result add(Category category);
	

}
