package com.test.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.web.model.Task;

public class TaskDaoModPost {
	public Task setTask(Task t)
	{
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/taskdb?allowPublicKeyRetrieval=true&useSSL=false";
			String username = "root";
			String password = "researcher";
			System.out.println(t.getId());
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
		    String query = "update task set name = ?, description = ?, start = ?, end = ? where id = ?";
		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString   (1, t.getName());
		    preparedStmt.setString   (2, t.getDescription());
		    preparedStmt.setString   (3, t.getStart());
		    preparedStmt.setString   (4, t.getEnd());
		    preparedStmt.setInt(5, t.getId());
		    preparedStmt.executeUpdate();

			con.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	      } catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }
		return t;
	}
}
