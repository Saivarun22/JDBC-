
package com.practice.jdbc;

import java.sql.*;

public class jdbc2 {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        // 1. Load and register JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver is Registered");

        // 2. Establish connection
        String url = "jdbc:mysql://localhost:3306/varun";
        String userName = "root";
        String password = "root";

        Connection connect = DriverManager.getConnection(url, userName, password);

        System.out.println("Connection Established");

        // 3. Create statement
        Statement state = connect.createStatement();
        System.out.println("Statement object is ready");

        // 4. Write SQL query
        String query =
                "INSERT INTO student(id,email,name) " +
                "VALUES (4,'samudrala@gmail.com','samudrala')";

        // 5. Execute query
        int rowAffected = state.executeUpdate(query);

        // 6. Check result
        if (rowAffected > 0) {
            System.out.println("Data has been added successfully");
        } else {
            System.out.println("Failed to add data");
        }

        // 7. Close resources
        state.close();
        connect.close();
    }
}
