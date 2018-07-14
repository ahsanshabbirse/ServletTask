package com.test.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.dao.TaskDao;
import com.test.web.dao.TaskDaoDel;
import com.test.web.model.Task;

/**
 * Servlet implementation class GetDelTaskController
 */
public class GetDelTaskController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskDaoDel dao = new TaskDaoDel();
		int del = 0;
		String rdel = request.getParameter("del");
		if(rdel != null && !rdel.isEmpty())
		{
			del = Integer.parseInt(request.getParameter("del"));
		}
		else
		{
			del = -11000;
		}
		dao.getTask(del);
		String str = "Record DELETED from DataBase";
		request.setAttribute("message", str);
		getServletConfig().getServletContext().getRequestDispatcher("/Show.jsp").forward(request, response);

	}
}
