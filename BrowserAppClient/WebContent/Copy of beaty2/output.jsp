<%@page import="be.ac.fundp.webapp.resources.ResourceManager"%>
<%@page import="be.ac.fundp.webapp.DataItemType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
  
  <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Language" content="en-GB" />
    <meta name="author" content="Your Name" />
    <meta name="abstract" content="A one-liner describing your site." />
    <meta name="description" content="A longer description of your site." />
    <meta name="keywords" content="some, words, characterising, your, web, site" />
    <meta name="distribution" content="global" />
    <meta name="revisit-after" content="1 days" />	
    <meta name="copyright" content="All content (c) Your Name" />
    
    <title>BPEL-UI</title>
    
    <style type="text/css" title="The shiny, Web 2.0 version of 'Simplicity,' a pseudo-professional style-sheet." media="all">
      @import "/BrowserAppClient/beaty2/layout/simplicity-two-oh-three.css";
    </style>
    <!--[if IE]>
    <style type="text/css" media="all">
      @import "layout/ie-diff.css";
    </style> 
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="layout/print.css" media="print" />
    <link rel="shortcut icon" href="http://wherever-your-favicon-is.org/favicon.png"  />
    <link rel="icon" href="http://wherever-your-favicon-is.org/favicon.png" />
    
<%
	ResourceManager r = ResourceManager.getInstance();
	String role = (String) request.getSession().getAttribute("role");
	DataItemType[] d =  r.getRequiredDataByUi(r.getCurrentCuiId(role));
	if (d == null)
		d = new DataItemType[0];
%>
    
  </head>
  
  <body>
    
    <div id="window">
      <div id="container">
	
	<div id="navigation">
	  <ul>
	    <!-- The link you call "active" will show up as a darker tab -->
	    <!--[if IE 6]><li></li><![endif]-->
	    <li class="active"><span>User Interaction</span></li>
	    <li><a href="index.html">Status</a></li>
	  </ul>
	</div>
	
	<div id="main">
	  <div id="outer-prettification">
	    <div id="inner-prettification">
	      
	      <div id="header">
		<h1 id="title"><a href="index.html">Output Interaction</a></h1>
	      </div>
	      
	      <div id="contents">
			<form action='/BrowserAppClient/UiController' method="get">
				<ol>
				<% for (int i = 0; i< d.length; i++){ %>
					<li>
						<h2><%=d[i].getData()%></h2>
					</li>
				<% } %>
			        
			        <li id="send">
			        	<button type="submit">Send</button>
			        </li>
			
			    </ol>
			</form>
	      </div>

              <div id="footer">
		<p><a href="index.html" title="Perhaps link to your copyright notice?">UI-BPEL 0.5</a></p>
		<!-- You can do whatever you like here -->
	      </div>
	      
	    </div>
	  </div>
	</div>

      </div>
    </div>

  </body>

</html>
