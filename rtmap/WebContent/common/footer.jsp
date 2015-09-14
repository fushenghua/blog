<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%-- <head>
<base href="<%=basePath%>">

<title>RTMAP_ANDROID_LAYOUT</title>

<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/bootstrap-theme.css" rel="stylesheet">
<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
}

.theme-dropdown .dropdown-menu {
	position: static;
	display: block;
	margin-bottom: 20px;
}

.theme-showcase>p>.btn {
	margin: 5px 0;
}

.theme-showcase .navbar .container {
	width: auto;
}
</style>
</head> --%>
	
	<nav class="navbar-fixed-bottom">
	<hr>
	<footer>
		<a href="#" style="text-align: right; margin-left: 100px;">当前在线： <span
			class="badge"><%=application.getAttribute("count")%></span> </a>
		<p align="center">&copy; Company 2015 RTMAP_ANDROID</p>
	</footer>
</nav>
