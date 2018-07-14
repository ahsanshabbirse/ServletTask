<!DOCTYPE html>
<html>

<table>
<tbody>
<tr>
<td>
 <h2>Please Insert Tasks</h1>
 </td>
 <td>
 <h2>View Tasks in TODO List</h1>
 </td>
 </tr>
 <tr>
 <td>
 <form action="setTask" method="post">
	<table>
		<tbody>
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
    <input type="submit" name="Submit Task"/>
</form>
</td>

 <td>
 <h4>Search Individual TASK</h4>
<form action="getTask">
 <table>
 	<tbody>
 		<tr>
 			<td>
 				<label>Enter ID to Search Task</label>
 			</td>
 			<td>
 				<input type="text" name="id"/>
 			</td>
 		</tr>
 	</tbody>
 </table>
    <input type="submit"/>
</form>

 <h4>Search ALL TASKS</h4>
<form action="getTask">
    <input type="submit"/>
</form>
</td>
</tr>
</tbody>
</table>
</html>