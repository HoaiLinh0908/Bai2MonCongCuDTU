package com.hoclaptrinhweb.service.impl;

import javax.inject.Inject;

import com.hoclaptrinhweb.model.UserModel;
import com.hoclaptrinhweb.service.IUserService;

import web.hoclaptrinhweb.dao.IUserDAO;

public class UserService implements IUserService{

	@Inject
	IUserDAO userDAO;
	
	@Override
	public UserModel findUserByNameAndPasswordAndStatus(String userName, String password, Integer status) {
		
		return userDAO.findUserByNameAndPasswordAndStatus(userName, password, status);
	}

}
