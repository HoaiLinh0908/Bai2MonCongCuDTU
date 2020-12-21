package com.hoclaptrinh.utils;

import javax.servlet.http.HttpServletRequest;

//Set message for an action that is made by a user, such as add, update or delete.
//Whether it's failed or successful.
public class MessageUtil {

	public static void showMessage(HttpServletRequest request) {
		if(request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if(message.equals("insert_success")) {
				messageResponse = "Insert Successfully";
				alert = "success";
			}else if(message.equals("update_success")) {
				messageResponse = "Update Successfully";
				alert = "success";
			}else if(message.equals("delete_success")) {
				messageResponse = "Delete Successfully";
				alert = "success";
			}else if(message.equals("error_system")) {
				messageResponse = "Error System";
				alert = "danger";
			}
			request.setAttribute("messageResponse", messageResponse);
			request.setAttribute("alert", alert);
		}
	}
}
