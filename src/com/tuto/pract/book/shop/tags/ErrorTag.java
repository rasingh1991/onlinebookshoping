package com.tuto.pract.book.shop.tags;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

public class ErrorTag extends TagSupport{

	private String property;
	
	Logger logger = Logger.getLogger(this.getClass());

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public int doEndTag() throws JspException {
		Writer out = pageContext.getOut();
		Object obj =pageContext.getAttribute(property, PageContext.REQUEST_SCOPE);
		if(obj != null){
			try {
				out.write(obj.toString());
			} catch (IOException e) {
				
			//	e.printStackTrace();
				logger.error("Exception in ErrorTag \n", e);
			}
		}
		return EVAL_PAGE;
		
	}
}
