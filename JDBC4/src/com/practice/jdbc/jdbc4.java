package com.practice.jdbc;
import java.sql.*;
public class jdbc4 {
	public static void main (String args[]) throws ClassNotFoundException,SQLException {
		
		//1.Load and Registered Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is Registered");
		
		//Establish Connection
		String url ="jdbc:mysql://localhost:3306/varun";
		String username ="root";
		String password ="root";
		
		Connection connect =DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established Succesfully");
		
		//3.Create Statement
		Statement state =connect.createStatement();
		System.out.println("statement object is ready");
		
		
		//4.Write SQL Query
		String Query="Delete from  student where id='4'";
		
		//5.Execute Query
		int RowsAffected = state.executeUpdate(Query);
		//6.check Result
		
		if(RowsAffected !=0) {
			System.out.println("Data has been Deleted Succesfully");
		}
		else {
			System.out.println("Failed to Delete query");
		}
		
		//7.close Resources
		state.close();
		connect.close();
		
		 
		
		
	}

}
