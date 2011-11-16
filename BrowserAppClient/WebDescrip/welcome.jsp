<%@page import="be.ac.fundp.webapp.resources.ResourceManager"%>
<%@page import="be.ac.fundp.webapp.DataItemType"%>
<%@page import="be.ac.fundp.webapp.representation.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html xmlns:v="urn:schemas-microsoft-com:vml"
	xmlns:o="urn:schemas-microsoft-com:office:office"
	xmlns="http://www.w3.org/TR/REC-html40">
<head>
<title>UsiWSC project</title>
<link rel="stylesheet" type="text/css" href="style.css">
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
	ResourceManager r = ResourceManager.getInstance();
	response.setIntHeader("Refresh", 5);
%>
</head>

<body leftmargin=0 topmargin=0 marginheight="0" marginwidth="0"
	bgcolor="#ffffff"
	onload="FP_preloadImgs(/*url*/'button38.jpg', /*url*/'button39.jpg')">

	<table border="0" cellspacing="0" cellpadding="0" width="100%"
		height="100%">
		<tr>
			<td width="50%" background="/BrowserAppClient/beaty2/images/bg.gif" valign="top"><img
				src="/BrowserAppClient/beaty2/images/px1.gif" width="1" height="1" alt="" border="0">
			</td>
			<td valign="bottom" background="/BrowserAppClient/beaty2/images/bg_left.gif"><img
				src="/BrowserAppClient/beaty2/images/bg_left.gif" alt="" width="17" height="16" border="0">
			</td>
			<td valign="top">
				<table border="0" cellspacing="0" cellpadding="0" width="780"
					align="center">
					<tr>
						<td background="/BrowserAppClient/beaty2/images/fon_top.gif" height="22">
							<div align="right" style="margin-right: 25px;">
								&nbsp;&nbsp;</div></td>
					</tr>
					<tr>
						<td>
							<table width="728" border="0" cellspacing="0" cellpadding="0"
								id="table1">
								<tr>
									<td width="728"><img border="0"
										src="/BrowserAppClient/beaty2/images/usiwsc-bannier.png" width="829" height="93">
									</td>
								</tr>
								<tr>
									<td height="14" valign="top" bgcolor="#23A5E2">
										<table width="780" border="0" cellspacing="0" cellpadding="0"
											id="table2">
											<tr>
												<td width="176" bgcolor="#23A5E2">&nbsp;</td>
												<td bgcolor="#23A5E2">
													<table border="0" width="100%" id="table173"
														bgcolor="#23A5E2" cellspacing="0" cellpadding="0">
														<tr>
															<td width="252" bgcolor="#23A5E2">
																<div align="center">
																	<table border="0" width="118" id="table174"
																		align="left">
																		<tr>
																			<td><span lang="en-us"><img
																					src="/BrowserAppClient/beaty2/images/Puce_carre.gif" align="bottom">
																			</span>
																			</td>
																			<td width="103"><font face="Verdana"
																				color="#FFFFFF"> <span
																					style="font-size: 9pt; font-weight: 700"> <a
																						style="font-size: 9pt; font-weight: 700; text-decoration: none"
																						href="UsiWSC_index.html"> <font
																							color="#FFFFFF">Project</font>
																					</a>
																				</span>
																			</font>
																			</td>
																		</tr>
																	</table>
																	<div align="center">
																		<table border="0" width="78" id="table175"
																			align="left">
																			<tr>
																				<td><span lang="en-us"><img
																						src="/BrowserAppClient/beaty2/images/Puce_carre.gif" align="bottom">
																				</span>
																				</td>
																				<td width="63"><span lang="en-us"><font
																						face="Verdana" color="#FFFFFF"> <span
																							style="font-size: 9pt; font-weight: 700">
																								<a style="text-decoration: none"
																								href="UsiWSC_Members.html"> <font
																									color="#FFFFFF">Members</font>
																							</a>
																						</span>
																					</font>
																				</span>
																				</td>
																			</tr>
																		</table>
																	</div>
																</div></td>
															<td width="112" bgcolor="#23A5E2">
																<div align="center">
																	<table border="0" width="98" id="table176" align="left">
																		<tr>
																			<td><span lang="en-us"><img
																					src="/BrowserAppClient/beaty2/images/Puce_carre.gif" align="bottom">
																			</span>
																			</td>
																			<td width="81"><span lang="en-us"><font
																					face="Verdana" color="#FFFFFF"> <span
																						style="font-size: 9pt; font-weight: 700"> <a
																							style="text-decoration: none"
																							href="UsiWSC_Publications.html"> <font
																								color="#FFFFFF">Papers</font>
																						</a>
																					</span>
																				</font>
																			</span>
																			</td>
																		</tr>
																	</table>
																</div> &nbsp;</td>
															<td width="93" bgcolor="#23A5E2">
																<div align="center">
																	<table border="0" width="70" id="table177" align="left">
																		<tr>
																			<td><span lang="en-us"><img
																					src="/BrowserAppClient/beaty2/images/Puce_carre.gif" align="bottom">
																			</span>
																			</td>
																			<td width="53"><span lang="en-us"><font
																					face="Verdana" color="#FFFFFF"> <span
																						style="font-size: 9pt; font-weight: 700"> <a
																							style="text-decoration: none"
																							href="UsiWSC_Demos.html"> <font
																								color="#FFFFFF">Demos</font>
																						</a>
																					</span>
																				</font>
																			</span>
																			</td>
																		</tr>
																	</table>
																</div> &nbsp;</td>
															<td width="150" bgcolor="#23A5E2">
																<div align="center">
																	<table border="0" width="74" id="table178" align="left">
																		<tr>
																			<td><span lang="en-us"><font
																					face="Verdana" color="#FFFFFF"> <span
																						style="font-size: 9pt; font-weight: 700"><img
																							src="/BrowserAppClient/beaty2/images/Puce_carre.gif" align="bottom">
																					</span>
																				</font>
																			</span>
																			</td>
																			<td width="57"><span lang="en-us"><font
																					face="Verdana" color="#FFFFFF"> <span
																						style="font-size: 9pt; font-weight: 700"> <a
																							style="text-decoration: none"
																							href="UsiWSC_Aboutus.html"> <font
																								color="#FFFFFF">About us</font>
																						</a>
																					</span>
																				</font>
																			</span>
																			</td>
																		</tr>
																	</table>
																</div> &nbsp;</td>
															<td width="16" bgcolor="#23A5E2">&nbsp;</td>
														</tr>
													</table></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table border="0" width="100%" id="table200">
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
																						<table border="0" width="100%" cellspacing="0"
																							cellpadding="0" bgcolor="#336699" id="table220">
																							<tr>
																								<td width="13" align="center"><span
																									lang="en-us"> <font face="Verdana"
																										style="font-size: 8pt"> <img
																											src="/BrowserAppClient/beaty2/images/Puce_carre.gif" align="bottom">
																									</font>
																								</span>
																								</td>
																								<td align="left">
																									<p align="left">
																										<span lang="en-us"><b> <font
																												face="Verdana" style="font-size: 8pt"
																												color="#FFFFFF"> Your Orders</font>
																										</b>
																										</span>
																								</td>
																							</tr>
																						</table></td>
																				</tr>
																				<tr>
																					<td>
																						<table border="0" width="100%" id="table205">
																							<% for (Order o : r.getOrders()){ %>
																							<tr>
																								<td>
																									<table border="0" width="100%" id="table219">
																										<tr>
																											<td width="13" align="center"><span
																												lang="en-us"> <font face="Verdana">
																														<span style="font-size: 8pt"> <img
																															src="/BrowserAppClient/beaty2/images/Puce.gif" height="12"
																															width="12">
																													</span>
																												</font>
																											</span>
																											</td>
																											<td><span lang="en-us"> <font
																													face="Verdana" style="font-size: 9pt; font-weight: 700"
																													color="<%=o.getUiColor()%>"> <a
																														style="text-decoration: none"
																														> <font
																															color="<%=o.getUiColor()%>"><%=o.getName()%></font>
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
												<td ALIGN="left"  VALIGN="top">
													<p>&nbsp;</p>
													<p>&nbsp;</p>
													<% String userName = (String)session.getAttribute("role"); 
													   if (userName == null){
														   userName = "Default User";
													   }
													%>
													<p class="MsoNormal" style="text-align: justify">
														<span style="font-size: 14pt" lang="en-us"><b>
																<span style="font-family: Arial">Hi, <%=userName%></span>
														</b>
														</span>
													</p>
													<%
														if (r.getCurrentOrder() == null ||  r.getCurrentOrder().isPerformed()) {
													%>
													
													<p class="MsoNormal" style="text-indent: 0cm" align="justify">
														<font size="2" face="Arial">
															You haven't any pending action.
														</font>
                									</p>
													 
													<% } else { %>
													<form action="/BrowserAppClient/UiController" method="get">
														<p class="MsoNormal" style="text-indent: 0cm" align="justify">
															<font size="2" face="Arial">
																You have a new user interaction for the
																<%=r.getCurrentOrder().getName()%>.	
															</font>
                										</p>
														<button type="submit">Perform the Interaction</button>
													</form> 
													<% } %>
												</td>
												<td width="4">&nbsp;</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>
				<table border="0" width="100%" id="table217" bgcolor="#D7D9DE">
					<tr>
						<td width="32">&nbsp;</td>
						<td width="732"><font face="Arial" style="font-size: 90%"
							color="#FFFFFF">Last modification 31st of October 2011 </font> <font
							face="Arial"><span style="font-size: 90%"> <a
									href="../MaPage/index.htm" style="text-decoration: none"> <font
										color="#006699">&nbsp;</font>
								</a>
							</span>
						</font>
						</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
			<td valign="bottom" background="/BrowserAppClient/beaty2/images/bg_right.gif"><img
				src="/BrowserAppClient/beaty2/images/bg_right.gif" alt="" width="17" height="16" border="0">
			</td>
			<td width="50%" background="/BrowserAppClient/beaty2/images/bg.gif" valign="top"><img
				src="/BrowserAppClient/beaty2/images/px1.gif" width="1" height="1" alt="" border="0">
			</td>
		</tr>
	</table>

</body>
</html>