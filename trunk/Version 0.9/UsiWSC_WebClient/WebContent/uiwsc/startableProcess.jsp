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
				<li><a href="http://webapps.fundp.ac.be/usiwsc/index.html">Overview</a></li>
				<li><a href="http://webapps.fundp.ac.be/usiwsc/Features.html">Features</a></li>
				<li><a href="http://webapps.fundp.ac.be/usiwsc/Dowload.html">Download</a></li>
				<li><a href="http://webapps.fundp.ac.be/usiwsc/Support.html">Support</a></li>
				<li><a href="http://webapps.fundp.ac.be/usiwsc/AboutUs.html">About us</a></li>
				<li class="active"><a href="http://localhost:8050/UsiWSC_WebClient/uiwsc/">Web Sign In
				</a></li>
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
			<p> This demonstration presents the designing, deploying and execution of a Web service
			 composition with user interactions based on UsiWSC Framework. The Web service composition
			 on the UsiWSC framework are defined based on an
			 extension of the BPEL: the UI-BPEL. For deployment, the framework allows the
			 derivation of the UI based on the <a href="http://www.usixml.com">UsiXML standard</a>. Besides,
			 the framework allows the derivation of an executable BPEL
			 compositions for a specific user context. Finally, the UsiWSC framework allows the
			 execution of the Web service composition, keeping the coordination of the
			 control and data flows between the involved Web services and user interfaces.</p>
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
						<FORM><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
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
		<p>&copy; 2012 FUNDP</p>
	</footer>
	<!-- /#contentinfo -->
</body>
</html>