package com.hoclaptrinhweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.hoclaptrinhweb.model.CategoryModel;
import com.hoclaptrinhweb.model.NewsModel;
import com.hoclaptrinhweb.paging.IPageable;
import com.hoclaptrinhweb.service.ICategoryService;
import com.hoclaptrinhweb.service.INewsService;

import web.hoclaptrinhweb.dao.ICategoryDAO;
import web.hoclaptrinhweb.dao.INewsDAO;
import web.hoclaptrinhweb.dao.impl.CategoryDAO;

public class NewsService implements INewsService{

	@Inject
	private INewsDAO newsDao;
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newsDao.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDAO.findOneByCode(newsModel.getCategoryCode());
		newsModel.setCategoryId(categoryModel.getId());
		Long newsId = newsDao.save(newsModel);
		return newsDao.findOne(newsId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDao.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDAO.findOneByCode(updateNews.getCategoryCode());
		updateNews.setCategoryId(categoryModel.getId());
		newsDao.update(updateNews);
		return newsDao.findOne(updateNews.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			//deletes comments before delete news
			newsDao.delete(id);
		}
	}

	@Override
	public List<NewsModel> findAll(IPageable pageable) {
		return newsDao.findAll(pageable);
	}

	@Override
	public int getTotalItems() {
		return newsDao.getTotalItems();
	}

	@Override
	public NewsModel findOne(Long id) {
		NewsModel newsModel = newsDao.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}

}
