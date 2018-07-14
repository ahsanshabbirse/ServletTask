package com.test.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.dao.TaskDaoPost;
import com.test.web.model.Task;

/**
 * Servlet implementation class SetTaskController
 */
public class SetTaskController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Task t = new Task();
		String str = "";
		t.setName(request.getParameter("name"));
		t.setDescription(request.getParameter("description"));
		t.setStart(request.getParameter("start"));
		t.setEnd(request.getParameter("end"));
		TaskDaoPost daop = new TaskDaoPost();
		daop.setTask(t);
		if(daop.check != true)
			str = "Record INSTERTED into DataBase";
		else	
			str = "Record Insertion Limit Exceeded by 5";
		request.setAttribute("message", str);
		getServletConfig().getServletContext().getRequestDispatcher("/Show.jsp").forward(request, response);
	//	doGet(request, response);
	}

}
