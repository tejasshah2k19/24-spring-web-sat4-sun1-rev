<%@page import="com.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h2>List User</h2>

	<%
	List<UserBean> users = (List<UserBean>) request.getAttribute("users");
	%>

	<table border="1">
		<tr>
			<th>FirstName</th>
			<th>Email</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
		<%
		for (UserBean u : users) {
			out.print("<tr>");
			out.print("<td>" + u.getFirstName() + "</td>");
			out.print("<td>" + u.getEmail() + "</td>");
			out.print("<td><a href=deleteuser?userId="+u.getUserId()+">Delete</a></td>");
			out.print("<td><a href=edituser?userId="+u.getUserId()+">Edit</a></td>");
			
			out.print("</tr>");

		}
		%>


	</table>

</body>
</html>