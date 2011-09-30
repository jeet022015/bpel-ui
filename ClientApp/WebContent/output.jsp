<%@page import="be.ac.fundp.webapp.resources.ResourceManager"%>
<%@page import="be.ac.fundp.webapp.resources.UIDataCapsule"%>
<%@page import="be.ac.fundp.webapp.controllers.Controller"%>
<%@page import="be.ac.fundp.webapp.resources.DataItem"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	ResourceManager r = ResourceManager.getInstance();
	System.out.println("It is a shiiiiiitt = "+Controller.getCurrent());
	DataItem[] d =  r.getOutputUIData(Controller.getCurrent()).getItens();
%>
<form method="GET" action='Controller' name="edit">
<table>
<% for (int i = 0; i< d.length; i++){ %>
	<tr>
		<td><%=d[i].getKey()%><br></td>
		<td><%=d[i].getData()%></td>
	</tr>
<% } %>
	<tr>
		<td><input type="submit" value="Ok">
		</td>
	</tr>
</table>
</form>

</body>
</html>