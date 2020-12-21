package com.hoclaptrinhweb.service;

import java.util.List;

import com.hoclaptrinhweb.model.NewsModel;
import com.hoclaptrinhweb.paging.IPageable;

public interface INewsService {
	public List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel newsModel);
	void delete(long[] ids);
	List<NewsModel> findAll(IPageable pageable);
	int getTotalItems();
	NewsModel findOne(Long id);
}
