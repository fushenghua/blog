<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<div class="container">
		<div class="alert">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>Warning!</strong> 找不到页面哦……
			<h1>404</h1>
		</div>
		<p>
			通过这里来<a href="#" class="btn btn-large ">返回首页</a>
		</p>
	</div>

	<jsp:include page="common/footer.jsp" />
</body>
</html>
