package com.hoclaptrinhweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hoclaptrinhweb.model.CategoryModel;
import com.hoclaptrinhweb.service.ICategoryService;

import web.hoclaptrinhweb.dao.ICategoryDAO;

public class CategoryService implements ICategoryService{
//	private ICategoryDAO categoryDao;
//	
//	public CategoryService() {
//		categoryDao = new CategoryDAO();
//	}
//	
	@Inject
	private ICategoryDAO categoryDao;
	
	public List<CategoryModel> findAll(){
		return categoryDao.findAll();
	}
}
