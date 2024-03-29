<%@page import="be.ac.fundp.usiwsc.webapp.model.UserInteraction"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="be.ac.fundp.usiwsc.webapp.manager.UiManager"%>
<%@page import="java.util.Set"%>
<%@page import="be.ac.fundp.usiwsc.webapp.model.Process"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html xmlns:v="urn:schemas-microsoft-com:vml"
	xmlns:o="urn:schemas-microsoft-com:office:office"
	xmlns="http://www.w3.org/TR/REC-html40">
<head>
<title>UsiWSC project</title>
<link rel="stylesheet" type="text/css" href="./style.css">
<script language="JavaScript">
<!--
	function FP_swapImg() {//v1.0
		var doc = document, args = arguments, elm, n;
		doc.$imgSwaps = new Array();
		for (n = 2; n < args.length; n += 2) {
			elm = FP_getObjectByID(args[n]);
			if (elm) {
				doc.$imgSwaps[doc.$imgSwaps.length] = elm;
				elm.$src = elm.src;
				elm.src = args[n + 1];
			}
		}
	}

	function FP_preloadImgs() {//v1.0
		var d = document, a = arguments;
		if (!d.FP_imgs)
			d.FP_imgs = new Array();
		for ( var i = 0; i < a.length; i++) {
			d.FP_imgs[i] = new Image;
			d.FP_imgs[i].src = a[i];
		}
	}

	function FP_getObjectByID(id, o) {//v1.0
		var c, el, els, f, m, n;
		if (!o)
			o = document;
		if (o.getElementById)
			el = o.getElementById(id);
		else if (o.layers)
			c = o.layers;
		else if (o.all)
			el = o.all[id];
		if (el)
			return el;
		if (o.id == id || o.name == id)
			return o;
		if (o.childNodes)
			c = o.childNodes;
		if (c)
			for (n = 0; n < c.length; n++) {
				el = FP_getObjectByID(id, c[n]);
				if (el)
					return el;
			}
		f = o.forms;
		if (f)
			for (n = 0; n < f.length; n++) {
				els = f[n].elements;
				for (m = 0; m < els.length; m++) {
					el = FP_getObjectByID(id, els[n]);
					if (el)
						return el;
				}
			}
		return null;
	}
// -->
</script>

<%
	UiManager r = UiManager.getInstance();
	//response.setIntHeader("Refresh", 5);
	String role = (String) request.getSession().getAttribute("role");
	String processId = (String) request.getParameter("processId");
	String cuiId = (String) request.getParameter("cuiId");
	UserInteraction cui = r.getProcess(role,processId).getUserInteraction(cuiId);
	Set<String> l = cui.getAvailableItemIds();
	
	String name = "";
	String surname = "";
	String hotel = "";
	String car = "";
	String travel = "";
	
	for (String dt: l){
		if (dt.equals("missionaryFirsName")){
			name = cui.getAvailableItemContent(dt).toString();
		} else if (dt.equals("missionaryLastName")){
			surname = cui.getAvailableItemContent(dt).toString();
		} else if (dt.equals("missionarySelectedHotel")){
			hotel = cui.getAvailableItemContent(dt).toString();
		} else if (dt.equals("missionarySelectedMean")){
			travel = cui.getAvailableItemContent(dt).toString();
		} else if (dt.equals("missionarySelectedCar")){
			car = cui.getAvailableItemContent(dt).toString();
		}
	}
%>
</head>

<body leftmargin=0 topmargin=0 marginheight="0" marginwidth="0"
	bgcolor="#ffffff"
	onload="FP_preloadImgs(/*url*/'button38.jpg', /*url*/'button39.jpg')">

	<table border="0" cellspacing="0" cellpadding="0" width="100%"
		height="100%">
		<tr>
			<td width="50%" background="/UsiXML-WebClient/uibpel/images/bg.gif" valign="top"><img
				src="/UsiXML-WebClient/uibpel/images/px1.gif" width="1" height="1" alt="" border="0">
			</td>
			<td valign="bottom" background="/UsiXML-WebClient/uibpel/images/bg_left.gif"><img
				src="/UsiXML-WebClient/uibpel/images/bg_left.gif" alt="" width="17" height="16" border="0">
			</td>
			<td valign="top">
				<table border="0" cellspacing="0" cellpadding="0" width="780"
					align="center">
					<tr>
						<td background="/UsiXML-WebClient/uibpel/images/fon_top.gif" height="22">
							<div align="right" style="margin-right: 25px;">
								&nbsp;&nbsp;</div></td>
					</tr>
					<tr>
						<td>
							<table width="728" border="0" cellspacing="0" cellpadding="0"
								id="table1">
								<tr>
									<td width="728"><img border="0"
										src="/UsiXML-WebClient/uibpel/images/usiwsc-bannier.png" width="829" height="93">
									</td>
								</tr>
								<tr>
									<td height="14" valign="top" bgcolor="#23A5E2"></td>
								</tr>
							</table></td>
					</tr>
				</table>
				<table width="100%" height="80%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table height="100%" border="0" width="100%" id="table200">
								<tr>
									<td width="165" valign="top" bgcolor="#23A5E2">
										<table border="0" width="100%" id="table201" cellspacing="0"
											cellpadding="0">
											<tr>
												<td>
													<table border="0" width="100%" id="table202"
														cellspacing="0" cellpadding="0">
														<tr>
															<th bgcolor="#23A5E2">
																<table border="0" width="100%" id="table203"
																	bgcolor="#7FA3D7" cellspacing="0" cellpadding="0">
																	<tr>
																		<th bgcolor="#23A5E2" valign="top" align="left">
																			<span lang="en-us"> <img
																				src="../../Mes%20Documents/Projets/Projet%20Djamel/SiteWeb/Site%20de%20Mohammadia/Site/transparent.gif"
																				height="10" width="1">
																		</span>
																		<p>&nbsp;</p>
																			<table border="0" width="100%" id="table204"
																				height="100" align="left">
																				<tr>
																					<td>
																						<!--<table border="0" width="100%" cellspacing="0"
																							cellpadding="0" bgcolor="#336699" id="table220">
																							<tr>
																								<td width="13" align="center"><span
																									lang="en-us"> <font face="Verdana"
																										style="font-size: 8pt"> <img
																											src="/UsiXML-WebClient/uibpel/images/Puce_carre.gif" align="bottom">
																									</font>
																								</span>
																								</td>
																								<td align="left">
																									<p align="left">
																										<span lang="en-us"><b> <font
																												face="Verdana" style="font-size: 14pt"
																												color="#FFFFFF"> PUT HERE ORDERS </font>
																										</b>
																										</span>
																								</td>
																							</tr>
																						</table>-->
																					</td>
																				</tr>
																				<tr>
																					<td>
																						<table border="0" width="100%" id="table205">
																							<% //for (Order o : r.getOrders()){
																								for (int i = 0; i< 0; i++) {%>
																							<tr>
																								<td>
																									<table border="0" width="100%" id="table219">
																										<tr>
																											<td width="13" align="center"><span
																												lang="en-us"> <font face="Verdana">
																														<span style="font-size: 8pt"> <img
																															src="/UsiXML-WebClient/uibpel/images/Puce.gif" height="12"
																															width="12">
																													</span>
																												</font>
																											</span>
																											</td>
																											<td><span lang="en-us"> <font
																													face="Verdana" style="font-size: 16pt; font-weight: 700"
																													color="FFFFFFFF"> <a
																														style="text-decoration: none"
																														> <font
																															color="AAAAAAA">Process</font>
																													</a>
																												</font>
																											</span>
																											</td>
																										</tr>
																									</table></td>
																							</tr>
																							<% } %>
																						</table></td>
																				</tr>
																				<tr>
																					<td>&nbsp;</td>
																				</tr>
																			</table></th>
																	</tr>
																</table></th>
														</tr>
													</table></td>
											</tr>
										</table></td>
									<td ALIGN="left"  VALIGN="top">
										<table border="0" width="100%" id="table215" cellpadding="3">
											<tr>
												<td>
													<h1>User Interaction</h1> 
													<form action='/UsiXML-WebClient/interactionManager' method="get">
														<input type="hidden" name="processId" value="<%=processId%>">
														<input type="hidden" name="cuiId" value="<%=cuiId%>">
													 
													 		
													 
													        <p>The following trip was approved by the manager to the employee <%=surname%>, <%=name%>:
																	<ul TYPE="CIRCLE" STYLE="margin-left:30px;">
																		<li> Journey: <%=travel%> </li>
																		<li> Hotel: <%=hotel%> </li>
																		<li> Renting Car: <%=car%> </li>														
																	</ul>
															</p>
														<input type="submit" value="Send" id="sendbutton" name="sendbutton"/>
													</form>
												</td>
												<td width="4">&nbsp;</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>
				</td>
			<td valign="bottom" background="/UsiXML-WebClient/uibpel/images/bg_right.gif"><img
				src="/UsiXML-WebClient/uibpel/images/bg_right.gif" alt="" width="17" height="16" border="0">
			</td>
			<td width="50%" background="/UsiXML-WebClient/uibpel/images/bg.gif" valign="top"><img
				src="/UsiXML-WebClient/uibpel/images/px1.gif" width="1" height="1" alt="" border="0">
			</td>
		</tr>
	</table>

</body>
</html>