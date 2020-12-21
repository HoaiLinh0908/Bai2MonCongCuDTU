package web.hoclaptrinhweb.dao.impl;

import java.util.List;

import com.hoclaptrinhweb.model.CategoryModel;
import com.hoclaptrinhweb.model.NewsModel;
import com.laptrinhweb.mapper.CategoryMapper;
import com.laptrinhweb.mapper.NewsMapper;

import web.hoclaptrinhweb.dao.ICategoryDAO;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> news = query(sql, new CategoryMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> news = query(sql, new CategoryMapper(), code);
		return news.isEmpty() ? null : news.get(0);
	}
	
}
