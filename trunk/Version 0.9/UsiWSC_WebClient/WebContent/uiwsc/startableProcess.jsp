<%@page import="be.ac.fundp.precise.uiwsc.webClient.controller.jsp.StartableProcessAccess"%>
<%@page import="be.ac.fundp.precise.uiwsc.webClient.controller.ControllerConstants"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/main.css">
<%
	String user = (String) request.getSession().getAttribute(ControllerConstants.CONTROLLER_LOGIN);
%>
<!--[if lt IE 9]>
 	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<head>
<title>UsiWSC - Web Client</title>
<meta charset="utf-8" />
</head>

<body id="index" class="home" onload="getProcesses(); displayDate();">
	<header id="banner" class="body">
		<h1 class="logo">
			<img src="images/UsiWSCLogo.png" title="UsiWSC Logo"
				alt="UsiWSC Logo" align="left" /><span class="wsc">Usable
				User Interface for</span> Interactive Web Service Composition
		</h1>
		<nav>
			<ul>
				<li class="active"><a href="#">home</a></li>
				<li><a href="#">login</a></li>
				<li><a href="#">subscription</a></li>
				<li><a href="#">contact</a></li>
			</ul>
		</nav>
	</header>
	<!-- /#banner -->

	<aside id="featured" class="body">
		<article>
			<hgroup>
				<h2>The Web Client Demonstration</h2>
				<h3>
					<a href="#">UI-BPEL</a>
				</h3>
			</hgroup>
			<p>This tool is the concept prove for our proposition. The
				extension proposes a new type of interaction events that allow
				processing of the user interaction. The user interaction
				specification helps to generate a user interface for the Web service
				composition which is made by transforming the described user
				interactions to user interface components.</p>
		</article>
	</aside>
	<!-- /#featured -->
	<section id="content" class="body">

		<ol id="posts-list" class="hfeed">
			<li><article class="hentry">
					<footer class="post-info">
						<h1 class="entry-title">Processes</h1>
					</footer>
					<!-- /.post-info -->
					<div class="entry-content">
						<ul class="arrowlistmenu" id="processDesc">
							<%
								for (String process: StartableProcessAccess.getStartableProcesses(user)) {
							%>
							<li> <a href="../startingProcessActivity?process=<%=process%>"> <%=process%></a>
							</li>
							<%
								} 
							%>
						</ul>
					</div>
					
					<!-- /.entry-content -->
				</article>
			</li>
		</ol>
		<!-- /#posts-list -->
	</section>
	<!-- /#content -->

	<footer id="contentinfo" class="body">
		<img src="images/logo.png" title="UsiWSC Logo" alt="UsiWSC Logo"
			align="left" /> <img src="images/logo3.png" title="UsiWSC Logo"
			alt="UsiWSC Logo" align="right" />
		<p>&copy; 2012 UsiXML</p>
	</footer>
	<!-- /#contentinfo -->
</body>
</html>