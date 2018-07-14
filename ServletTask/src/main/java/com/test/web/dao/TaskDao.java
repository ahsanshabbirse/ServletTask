package com.test.web.dao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.test.web.model.Task;

public class TaskDao {

	public List<Task> getTask(int id)
	{
		List<Task> list = new ArrayList<Task>();
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/taskdb?allowPublicKeyRetrieval=true&useSSL=false";
			String username = "root";
			String password = "researcher";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			if(id != -11000)
			{
				ResultSet rs = st.executeQuery("select * from task where id =" + id);
				if(rs.next())
				{
					Task task = new Task();
					list.add(task);
					task.setId(rs.getInt("id"));
					task.setName(rs.getString("name"));
					task.setDescription(rs.getString("description"));
					task.setStart(rs.getString("start"));
					task.setEnd(rs.getString("end"));
				}
			}
			else
			{
				ResultSet rs = st.executeQuery("select * from task");
				while(rs.next()){
					Task task = new Task();
					list.add(task);
					task.setId(rs.getInt("id"));
					task.setName(rs.getString("name"));
					task.setDescription(rs.getString("description"));
					task.setStart(rs.getString("start"));
					task.setEnd(rs.getString("end"));
				}
			}
			con.close();
		}
		catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	      } catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }
		return list;
	}
}
