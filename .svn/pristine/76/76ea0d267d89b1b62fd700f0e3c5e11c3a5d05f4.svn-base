package web.hoclaptrinhweb.dao;

import java.util.List;

import com.hoclaptrinhweb.model.NewsModel;
import com.hoclaptrinhweb.paging.IPageable;

public interface INewsDAO extends IGenericDAO<NewsModel>{
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	void update(NewsModel updateNews);
	void delete(long id);
	List<NewsModel> findAll(IPageable pageable);
	int getTotalItems();
}
