package com.ecommerce.pharmacy.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.pharmacy.business.abstracts.CategoryService;
import com.ecommerce.pharmacy.core.utilities.results.DataResult;
import com.ecommerce.pharmacy.core.utilities.results.Result;
import com.ecommerce.pharmacy.core.utilities.results.SuccessDataResult;
import com.ecommerce.pharmacy.core.utilities.results.SuccessResult;
import com.ecommerce.pharmacy.dataAccess.abstracts.CategoryDao;
import com.ecommerce.pharmacy.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {
	private CategoryDao categoryDao;

	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public Result add(Category category) {
		this.categoryDao.save(category);
		return new SuccessResult("successed");
	}

	@Override
	public DataResult<List<Category>> getAll() {
		
		return new SuccessDataResult<List<Category>>(this.categoryDao.findAll(), "successed");
	}

}
