package web.hoclaptrinhweb.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hoclaptrinhweb.model.NewsModel;
import com.hoclaptrinhweb.paging.IPageable;
import com.laptrinhweb.mapper.NewsMapper;

import web.hoclaptrinhweb.dao.INewsDAO;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news(title, content,");
		sql.append(" categoryid,shortdescription,thumbnail,createddate,createdby)");
		sql.append(" VALUES(?,?,?,?,?,?,?)");
		return insert(sql.toString(), newsModel.getTitle(),newsModel.getContent(),
				newsModel.getCategoryId(), newsModel.getShortDescription(),
				newsModel.getThumbnail(),newsModel.getCreatedDate(),newsModel.getCreatedBy());
	}

	@Override
	public void update(NewsModel updateNews) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNews.getTitle(), updateNews.getThumbnail(),
				updateNews.getShortDescription(), updateNews.getContent(),
				updateNews.getCategoryId(), updateNews.getCreatedDate(),
				updateNews.getCreatedBy(), updateNews.getModifiedDate(),
				updateNews.getModifiedBy(),updateNews.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql,id);
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public List<NewsModel> findAll(IPageable pageable) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if(pageable.getSorter() != null && StringUtils.isNotBlank(pageable.getSorter().getSortName()) && StringUtils.isNotBlank(pageable.getSorter().getSortName())) {
			sql.append(" ORDER BY " + pageable.getSorter().getSortName()
					+ " " + pageable.getSorter().getSortBy());
		}
		if(pageable.getOffset() != null && pageable.getLimit() != null) {
			sql.append(" LIMIT ?,?");
			return query(sql.toString(), new NewsMapper(),pageable.getOffset(),pageable.getLimit());
		}else {
			return query(sql.toString(), new NewsMapper());
		}
		
	}

	@Override
	public int getTotalItems() {
		String sql = "SELECT count(*) FROM news";
		return countItem(sql);
	}
}
