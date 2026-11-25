package com.practice.jdbcutil;
import java.sql.*;

public class jdbcExecute {
	
	public static void main (String args[]) {
		
		Connection connect = null;
		Statement state = null;
		ResultSet rs = null;
		
		
		try {
			
			 connect =JDBCUTIL.getDBConnection();
			if(connect != null) {
				 state = connect.createStatement();
				if(state!=null) {
					String Query = "Update  student SET email='venkat@gmail.com' where id='2'";
					boolean status=state.execute(Query);
					if(status){
						rs=state.getResultSet();
						if(rs!=null) {
						System.out.println("We have got result set");
						System.out.println("id \t email \t name ");
						
						while(rs.next()) {
							System.out.println(rs.getInt(1)+" \t "+rs.getString(2)+" \t  "+rs.getString(3));
						}
					}
						
						
					}
					else {
						  int RowsAffected = state.getUpdateCount();
						  if(RowsAffected>0) {
						  System.out.println("No of rows Affected : " +RowsAffected);
						  }
						  else {
							  System.out.println("Data not updated");
						  }
						  
			
							
						}
					}
				
//					String Query = "Select * from student";
//				     rs =state.executeQuery(Query);
//					
//					System.out.println("We have got result set");
//					System.out.println("id \t email \t name ");
//					
//					while(rs.next()) {
//						System.out.println(rs.getInt(1)+" \t "+rs.getString(2)+" \t  "+rs.getString(3));
//					}
				}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			try {
			
			JDBCUTIL.closeResources(connect, state, rs);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
