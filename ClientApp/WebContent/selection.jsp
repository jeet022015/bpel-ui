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
	DataItem[] d =  r.getOutputUIData(Controller.getCurrent()).getItens();
%>
<h2>Select Languages:</h2>

<form ACTION="SelectionController">
<% for (int i = 0; i< d.length; i++){ %>
<% System.out.println("the data"+d[i].getData());%>
<input type="checkbox" name="id" value="<%=d[i].getData()%>"><%=d[i].getData()%><BR>
<% } %>
<input type="submit" name="SendInput" value="SendInput">
</form>
</body>
</html>