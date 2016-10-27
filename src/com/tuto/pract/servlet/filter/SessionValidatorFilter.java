package com.tuto.pract.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionValidatorFilter implements Filter{

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		    HttpServletRequest httpServletRequest =  (HttpServletRequest)servletRequest;
		    String uri = httpServletRequest.getRequestURI();
		    System.out.println("URI :-"+uri);
		    
		    if(uri.endsWith("login.do") || uri.endsWith("register.do") || uri.endsWith("forgetPassword.do")){
		    	filterChain.doFilter(servletRequest, servletResponse);
		    }else{
		    	HttpSession httpSession = httpServletRequest.getSession();
		    	if(httpSession == null){
		    		servletRequest.setAttribute("loginError", "Session TimeOut. Please Login Again");
		    		servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
		    	}else{
		    		filterChain.doFilter(servletRequest, servletResponse);
		    	}
		    }
		   
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
