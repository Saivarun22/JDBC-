package com.practice.jdbc;
import java.sql.*;
import java.util.*;
public class jdbcPrepared {
	
	public static void main (String args[]) {
		
		Connection connect = null;
		PreparedStatement state = null;
		Scanner scan = null;
		
		
		try {
			connect =JdbcUtility.getDBConnection();
			if(connect != null) {
				String query ="Insert into student(id,email,name)"+"Values (?,?,?)";
				state=connect.prepareStatement(query);
					if(state!=null) {
						
						System.out.println("Welcome to school");
						scan =new Scanner(System.in);
						System.out.println("Enter Student id");
						Integer id =scan.nextInt();
						System.out.println("Enter Email of student");
						String email = scan.next();
						System.out.println("Enter name of Student");
						String name =scan.next();
						
						state.setInt(1, id);
						state.setString(2,email);
						state.setString(3, name);
						
						int RowsAffected=state.executeUpdate();
						if(RowsAffected !=0) {
							System.out.println("Student Registered Sucessfully");
						}else {
							System.out.println("Enter details again");
						}
					}
				}
			
		}
						
						
						
				
			catch(SQLException e) {
				
				e.printStackTrace();
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			finally {
				
				try {
					
				 JdbcUtility.closeResources(connect, state);
				 
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
	
		
		
	

