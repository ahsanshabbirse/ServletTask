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

public class TaskDaoDel {
	public void getTask(int id)
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
			if(id != -11000)
			{
				String query = "delete from task where id = ?";
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setInt(1, id);
			      preparedStmt.execute();
			}
			else
			{
				String sql = "TRUNCATE task";
			    // Execute deletion
			    st.executeUpdate(sql);
			    // Use DELETE
			    sql = "DELETE FROM task";
			    // Execute deletion
			    st.executeUpdate(sql);
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
	}
}
