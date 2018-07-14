package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.dao.TaskDao;
import com.test.web.model.Task;

/**
 * Servlet implementation class GetTaskController
 */
@WebServlet({"/"})
public class GetTaskController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TaskDao dao = new TaskDao();
		int id = 0;
		String rid = request.getParameter("id");
		if(rid != null && !rid.isEmpty())
			id = Integer.parseInt(request.getParameter("id"));
		else
			id = -11000;
		List<Task> lt = dao.getTask(id);
		request.setAttribute("task", lt);
		getServletConfig().getServletContext().getRequestDispatcher("/Show.jsp").forward(request, response);

	}
}
