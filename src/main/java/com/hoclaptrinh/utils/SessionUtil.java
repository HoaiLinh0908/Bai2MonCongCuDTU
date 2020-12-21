package com.hoclaptrinh.utils;

import javax.servlet.http.HttpServletRequest;

//To create a session when a user login
public class SessionUtil {
	
	private static SessionUtil sessionUtil = null;
	
	//Just create only one SessionUltil instance(if you don't do this you have to create
	//more SessionUltil instance for each of user-logging) and then use this instance to
	//get session objects.
	public static SessionUtil getInstance() {
		if( sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}
	
	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
