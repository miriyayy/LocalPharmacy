package com.springBoot.pharmacy.business.abstracts;

import java.util.List;

import com.springBoot.pharmacy.entities.Category;

import core.utilities.results.DataResult;
import core.utilities.results.Result;

public interface CategoryService {
	DataResult<List<Category>>getAll();
	Result add(Category category);

}
