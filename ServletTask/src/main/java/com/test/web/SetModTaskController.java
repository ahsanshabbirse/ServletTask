package com.test.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.dao.TaskDaoModPost;
import com.test.web.dao.TaskDaoPost;
import com.test.web.model.Task;

/**
 * Servlet implementation class SetModTaskController
 */
public class SetModTaskController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task t = new Task();
		int id = Integer.parseInt(request.getParameter("id"));
		t.setId(id);
		t.setName(request.getParameter("name"));
		t.setDescription(request.getParameter("description"));
		t.setStart(request.getParameter("start"));
		t.setEnd(request.getParameter("end"));
		TaskDaoModPost daop = new TaskDaoModPost();
		daop.setTask(t);
		String str = "Record UPDATED INTO DataBase";
		request.setAttribute("message", str);
		getServletConfig().getServletContext().getRequestDispatcher("/Show.jsp").forward(request, response);
	}

}
