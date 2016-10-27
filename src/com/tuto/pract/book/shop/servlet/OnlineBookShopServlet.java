package com.tuto.pract.book.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tuto.pract.book.shop.servlet.action.ChangePasswordAction;
import com.tuto.pract.book.shop.servlet.action.ForgetPasswordAction;
import com.tuto.pract.book.shop.servlet.action.LoginAction;
import com.tuto.pract.book.shop.servlet.action.LogoutAction;
import com.tuto.pract.book.shop.servlet.action.RegisterAction;

public class OnlineBookShopServlet extends HttpServlet{

	LoginAction loginAction = null;
	LogoutAction logoutAction = null;
	ChangePasswordAction changePasswordAction = null;
	ForgetPasswordAction forgetPasswordAction = null;
	RegisterAction registerAction = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		loginAction = new LoginAction();
		logoutAction = new LogoutAction();
		changePasswordAction = new ChangePasswordAction();
		forgetPasswordAction = new ForgetPasswordAction();
		registerAction = new RegisterAction();
	}
	
	@Override
	protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		String uri =httpServletRequest.getRequestURI();
		String page = "";
		if(uri.endsWith("login.do")){
			page = loginAction.verifyUser(httpServletRequest, httpServletResponse);
		}
		
		httpServletRequest.getRequestDispatcher(page).forward(httpServletRequest, httpServletResponse);
	}
}
