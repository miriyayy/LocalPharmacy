package com.springBoot.pharmacy.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.pharmacy.business.abstracts.CategoryService;
import com.springBoot.pharmacy.dataAccess.CategoryDao;
import com.springBoot.pharmacy.entities.Category;

import core.utilities.results.DataResult;
import core.utilities.results.Result;
import core.utilities.results.SuccessDataResult;
import core.utilities.results.SuccessResult;
@Service
public class CategoryManager implements CategoryService{
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
