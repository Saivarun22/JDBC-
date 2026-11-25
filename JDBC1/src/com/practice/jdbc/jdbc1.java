package com.practice.jdbc;

import java.sql.*;

public class jdbc1 {
	public static void main (String args[])throws ClassNotFoundException ,SQLException{
		
		//load and Register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is Registered");
		
		//Establish the Connection
		String url="jdbc:mysql://localhost:3306/varun";
		String userName="root";
		String password ="root";
		Connection connect = DriverManager.getConnection(url, userName, password);
		System.out.println("connection Established");
		
		
		Statement state=connect.createStatement();
		System.out.println("statment Object is ready");
		
		String query="select * from student";
		ResultSet rs= state.executeQuery(query);
		
		System.out.println("We have got result set");
		System.out.println("id \t email \t name ");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" \t "+rs.getString(2)+" \t  b"+rs.getString(3));
		}
		
		rs.close();
		state.close();
		connect.close();
		
		
		
		
	}
;
}
