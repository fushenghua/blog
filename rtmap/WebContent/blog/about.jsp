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
		<div class="page-header">
			<h2>
				关于我们<small>   RTMAP_DEPARTMENT</small>
			</h2>
		</div>
		<img src="img/thumb_IMG_0045_1024.jpg" class="img-circle"
			width="200px" height="200px">
		<h3>
			RTMAP_DEPARTMENT<span class="label label-info">v1.0</span>
		</h3>
		<br/>
		<div>
			<blockquote>
				<h3>更新日志：</h3>
				<ul>
				<li>2015.6.01 RMTAP_DEPARTMENT Start</li>
			</ul>
			</blockquote>
	</div>
	</div>
	
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
