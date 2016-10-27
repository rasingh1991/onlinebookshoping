package com.tuto.pract.book.shop.tags;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

public class DisplayUserPasswordTag extends TagSupport{

	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public int doEndTag() throws JspException {
		try {
			
		HttpSession httpSession = (HttpSession)pageContext.getSession();
		Object obj = httpSession.getAttribute("USER_TO");
			
		} catch (Exception e) {
			
		}
		return super.doEndTag();
	}
}
