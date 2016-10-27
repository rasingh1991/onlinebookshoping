package com.tuto.pract.servlet.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class OnlineBookshopingListner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		
		/*ServletContext servletContext = contextEvent.getServletContext();
		String path = servletContext.getContextPath();
		System.out.println(path);
		String realPath = servletContext.getRealPath("/")+"logs\\"; 
		System.out.println(realPath);
		
		System.setProperty("onlinebookshoping.root.path", realPath);
	    String log4jPath = servletContext.getRealPath("/WEB-INF/com.tuto.pract.onlinebookshoping-log4j.properties");
	    System.out.println(log4jPath);
	    PropertyConfigurator.configure(log4jPath);
        Logger logg = Logger.getLogger(this.getClass());
        logg.info("Properties file :"+log4jPath);*/
		
        ServletContext servletContext = contextEvent.getServletContext();
		String log4jConfigFile = servletContext.getInitParameter("log4j-config-location");
		String fullPath = servletContext.getRealPath("") + File.separator + log4jConfigFile;
	    PropertyConfigurator.configure(fullPath);
        Logger logg = Logger.getLogger(this.getClass());
        logg.info("Properties file :"+fullPath);
     
	}

}
