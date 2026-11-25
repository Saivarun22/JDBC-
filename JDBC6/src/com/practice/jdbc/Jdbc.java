package com.practice.jdbc;
import java.sql.*;


public class Jdbc {
	public static void main (String args[]){
		
		Connection connect=null;
	    PreparedStatement state= null;
		
		try {
			 connect = JdbcUtility.getDBConnection();
			 if(connect!=null) {
			 String query= "Update student set name=? where id=?";
			 state=connect.prepareStatement(query);
			 }
			 if(state!=null) {
				 
				 state.setInt(2,1);
				 state.setString(1,"ram");
				 state.addBatch();
				 
				 state.setInt(2,2);
				 state.setString(1,"shyam");
				 state.addBatch();
				 
				 state.setInt(2,3);
				 state.setString(1,"venkata");
				 state.addBatch();
				 
				 state.executeBatch();
				 System.out.println("check Db for updates");
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
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
		}
		
	}

}
