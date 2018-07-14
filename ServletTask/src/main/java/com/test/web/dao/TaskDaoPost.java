package com.test.web.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.test.web.model.Task;

public class TaskDaoPost {

	public boolean check = false;
	
	public Task setTask(Task t)
	{
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/taskdb?allowPublicKeyRetrieval=true&useSSL=false";
			String username = "root";
			String password = "researcher";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(id) from task");
			rs.next();
		    int rowcount = rs.getInt(1);
		    if(rowcount < 5)
		    {
		    	String query = "INSERT INTO task (name, description, start, end)" + "VALUES(?, ?, ?, ?)";
		    	PreparedStatement preparedStmt = con.prepareStatement(query);
		    	preparedStmt.setString (1, t.getName());
		    	preparedStmt.setString (2, t.getDescription());
		   	    preparedStmt.setString   (3, t.getStart());
		    	preparedStmt.setString(4, t.getEnd());
		    	preparedStmt.execute();
		    	con.close();
		    }
		    else
		    	check = true;
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
