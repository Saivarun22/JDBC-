package com.practice.jdbc;

	import java.sql.*;
	import java.util.*;
	public class jdbcPrepared2 {
		
		public static void main (String args[]) {
			
			Connection connect = null;
			PreparedStatement state = null;
			Scanner scan = null;
			
			
			try {
				connect =JdbcUtility.getDBConnection();
				if(connect != null) {
					String query ="Update student set email=? where name=?";
					state=connect.prepareStatement(query);
						if(state!=null) {
							
							System.out.println("Welcome to school");
							scan = new Scanner(System.in);
							
							
							System.out.println("Enter Updated Email of student");
							String email = scan.next();
							System.out.println("Enter name of Student");
							String name =scan.next();
							
							
							state.setString(1,email);
							state.setString(2, name);
							
							int RowsAffected=state.executeUpdate();
							if(RowsAffected !=0) {
								System.out.println("Student Updated Sucessfully");
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


