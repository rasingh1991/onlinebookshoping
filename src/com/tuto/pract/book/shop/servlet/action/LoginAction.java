package com.tuto.pract.book.shop.servlet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuto.pract.book.shop.validator.DataValidator;

public class LoginAction {

	public String verifyUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		
		String page = "index.jsp";
		String uname = httpServletRequest.getParameter("username");
		String pwd =   httpServletRequest.getParameter("password");
		
		boolean interactWithDB = true;
		if(!DataValidator.validateRequired(uname)){
			httpServletRequest.setAttribute("username", "User Name is Mandatory");
			interactWithDB = false;
		}
		
		if(!DataValidator.validateRequired(pwd)){
			httpServletRequest.setAttribute("password", "Password is Mandatory");
			interactWithDB = false;
		}
		
		return page;
		
	}
}
