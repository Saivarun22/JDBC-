package com.practice.jdbc;

import java.sql.*;

public class jdbc3 {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException{
		
		//1.Load and Register JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is Registered");
		
		//2.Establish Connection
		String url = "jdbc:mysql://localhost:3306/varun";
		String username = "root";
		String password = "root";
		Connection connect =DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established");
		
		//3.Create Statement
		Statement state = connect.createStatement();
		System.out.println("Statment object is ready");
		
		//4.Write SQL Query
		String Query = "Update student set name='Venkata' where id = '2' " ;
		
		//5.Execute Query
		int RowsAffected =state.executeUpdate(Query);
		
		//6.Check Result 
		if(RowsAffected !=0) {
			System.out.println("Data has been Updated Sucessfully");
		}else {
			System.out.println("Failed to update data");
		}
		
		//7.close Resources
		state.close();
		connect.close();
		

	}

}
