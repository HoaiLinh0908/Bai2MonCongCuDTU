package com.hoclaptrinhweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoclaptrinh.utils.FormUtil;
import com.hoclaptrinh.utils.MessageUtil;
import com.hoclaptrinhweb.constant.SystemConstant;
import com.hoclaptrinhweb.model.NewsModel;
import com.hoclaptrinhweb.paging.IPageable;
import com.hoclaptrinhweb.paging.PageRequest;
import com.hoclaptrinhweb.service.ICategoryService;
import com.hoclaptrinhweb.service.INewsService;
import com.hoclaptrinhweb.sort.Sorter;

@WebServlet(urlPatterns = { "/admin-news" })
public class NewsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewsService newsService;
	
	@Inject
	private ICategoryService categoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Map parameters to news's properties
		NewsModel model = FormUtil.toModel(NewsModel.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			//Create a IPageable for findAll method
			IPageable pageable = new PageRequest(model.getPage(), model.getMaxPageItem(),
					 							new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newsService.findAll(pageable));
			
			//set the number of items in model from database
			model.setTotalItem(newsService.getTotalItems());
			//set the number of page
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem()/model.getMaxPageItem()));
			
			view = "/view/admin/news/list.jsp";
		}else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId() != null) {
				model = newsService.findOne(model.getId());
			}
			request.setAttribute("categories", categoryService.findAll());
			view = "/view/admin/news/edit.jsp";
		}
		MessageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
