package com.bookonline.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
	public static DB conn=null;
	public static DB newInstance(){
		if(conn==null){
			conn=new DB();
		}
		return conn;
	}
	
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.238:1433;databasename=train","sa", "123");
			return conn;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection conn){		
		try {
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
