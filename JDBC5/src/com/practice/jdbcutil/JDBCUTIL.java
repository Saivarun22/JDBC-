package com.practice.jdbcutil;
import java.sql.*;
import java.sql.DriverManager;

public class JDBCUTIL {
	

	static{
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		
	    }
    }
	
	public static Connection getDBConnection() throws SQLException  {
		
		String url ="jdbc:mysql://localhost:3306/varun";
		String username="root";
		String password ="root";
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void closeResources( Connection connect,Statement state,ResultSet rs)throws SQLException{
		
		if(connect!=null) {
			connect.close();
		}
		if(state!=null) {
			state.close();
		}
		if(rs!=null) {
			rs.close();
			
		}
		
	}

}
