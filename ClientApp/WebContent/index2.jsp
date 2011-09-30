<%@page import="be.ac.fundp.webapp.controllers.Controller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
<%
	String name = "Click on the button";
%>
<form method="GET" action='Controller' name="index">
<table>
	<tr>
		<td><%=name %></td>
	</tr>
</table>
	<p>
		<input type="submit" name="actionInput" value="input">&nbsp; 
	</p>
</form>

</body>
</html>