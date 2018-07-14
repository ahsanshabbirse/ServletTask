<%@page import="com.test.web.model.Task"%>
<%@page import="java.text.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan" >

	<% 		
	List<Task> list = (ArrayList<Task>) request.getAttribute("task");
	if(list != null)
	{
		for(Task t: list)
		{
			if(t == null)
				out.print("Record is Inserted");
			else
			{
				out.print(t);
			}
			%><br/><%
		}
	}	
	
	String str = (String)request.getAttribute("message");
	if(str != null)
		out.print(str);
	%>  
	<br/>
	<br/>
	<table>
	<tbody>
	<tr>
	<td>
		<h2>DELETE TASK</h2>
	</td>
	<td>
			<h2>MODIFY TASK</h2>
	</td>
	</tr>
	<tr>
	<td>
	<h3>Delete A Task</h3>
	<form action="getDelTask">
		<table>
			<tbody>
				<tr>
					<label>Please Enter ID to Delete Task</label>
				</tr>
				<tr>
					<input type="text" name = "del"/>
				</tr>
			</tbody>
		</table>
		<input type="submit"/>
	</form>
	<h3>Click To Delete ALL Task</h3>
		<form action="getDelTask">
		<input type="submit"/>
	</form>
	</td>
	<td>
	<form action="setModTask" method = "post">
		<table>
		<tbody>
			<tr>
				<td>
				 	<label>Task ID</label>
				</td>
				<td>
				    <input type="text" name="id"/>
				</td>
			</tr>
			<tr>
				<td>
				 	<label>Task Name</label>
				</td>
				<td>
				    <input type="text" name="name"/>
				</td>
			</tr>
			<tr>
				<td>
				    <label>Task Details</label>
				</td>
				<td>
				    <input type="text" name="description"/>
				</td>
			</tr>
			<tr>
				<td>
				    <label>Start Date</label>
				</td>
				<td>
				    <input type="date" name="start" placeholder="2000-12-31"/>
				</td>
			</tr>
			<tr>
				<td>
				    <label>DeadLine</label>
				</td>
				<td>
				    <input type="date" name="end" placeholder="2000-12-31"/>
				</td>
			</tr>
		</tbody>
	</table>
		<input type="submit"/>
	</form>
	</td>
	</tr>
	</tbody>
	</table>
		
</body>
</html>