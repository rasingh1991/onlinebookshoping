package com.tuto.pract.book.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class JDBCUtil {

	static Logger logger = Logger.getLogger(JDBCUtil.class);
	private static Connection conn = null;
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			logger.error("Error in Loding Driver Class \n", e);
		}
	}
	
	public static Connection getOracleConnection(){
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:onlineshopingdb","system","rahul");
		} catch (SQLException e) {
			
			logger.error("Error in creating Connection \n", e);
		}
		return conn;
		
	}
	
	public static void closeDBConnection(ResultSet rs, Statement st, Connection conn){
		try {
			if(rs != null)
				rs.close();
			if(st != null)
				st.close();
			if(conn != null)
				conn.close();
				
		} catch (Exception e) {
			logger.error("Error in closing the resources \n", e);
		}
	}
}
