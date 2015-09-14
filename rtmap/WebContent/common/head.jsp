<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<base href="<%=basePath%>">

<title>RTMAP_ANDROID</title>
<link rel="icon" href="/favicon.ico">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.zclip.min.js"></script>
<style>
 body {
	font-family: Helvetica, sans-serif;
    line-height: 1.6;
    font-weight: 300;
    background-image: url("static/img/body-bg.png");
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

#msg {
	margin-left: 10px;
	color: green;
	border: 1px solid #3c3;
	background: url(img/checkmark.png) no-repeat 2px 3px;
	padding: 3px 6px 3px 20px
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		var url = document.location.href;
		var menuId = url.split('#')[1];
		if (menuId == null) {
			menuId = 1;
			/* location.href = "#1"; */
		}
		var num = 0;
		$("ul").find("li").each(function() {
			num++;
			if (num == menuId) {
				$(this).addClass("active");
			}
		});

		/* $("ul").each(function() {
				num++;
				if (eval(num) == eval(menuId)) {
					alert(num + menuId);
					$(this).addClass("active");
				}
			}); */

		/* $('.nav li a').click(function() {
				$('.nav li').removeClass('active');
				alert('dddd');
				$(this).parent().addClass('active');
		j
			});*/

	});
</script>
</head>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#1">RTMAP_Blog</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav" id="navID">
				<li><a href="#1">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/blog#2">Blog
				</a></li>
				<li><a href="${pageContext.request.contextPath}/about#3">
						About </a></li>
			</ul>

			<div class="pull-right">
				<c:if test="${!empty loginUser}">
					<p style="padding-top: 10px; color: #777;">
						<span class="glyphicon glyphicon-user"></span> 欢迎您， <a href="user/"
							class="navbar-link">${loginUser.userName}</a>&nbsp;&nbsp;
						<button id="sysAdminLogout" type="button"
							class="btn btn-danger btn-sm logout" onfocus="this.blur()">退出</button>
					</p>
				</c:if>
				<c:if test="${empty loginUser}">
					<p style="padding-top: 10px; color: #777;">
						<span class="glyphicon glyphicon-user"></span> 游客<a href="#"
							class="navbar-link">${loginUser.userName}</a>&nbsp;&nbsp;
						<a id="teacherLogout" type="button" 
							class="btn btn-info btn-sm logout" href="user/login">登录</a>
					</p>
				</c:if>
			</div>

		</div>
	</div>
</nav>

<%-- <script type="text/javascript">
	$(document).ready(function() {
		 $("#navID li").click(function(){
		 alert("ddd");
 $(this).addClass("active").siblings().removeClass("active");
 });
      $.post("<%=basePath%>user/layout", {
								name : $("#contentXml").val(),
							}, function(data, status) {
								alert("Data: " + data + "\nStatus: " + status
										+ data.data);
								if (status == "success") {
									$("#javacode").val(data.data);
								} else {
									$("#javacode").val("生成错误");
								}

							});
						});
				$("#btnCopy").click(function() {
					var Url = $("#javacode").val();
					copyToClipboard(Url);
				});

				$("#btnClear").click(function() {
					$("#contentXml").val('');
				});

	

		function json(obj) {
			alert(obj);
			obj.addClass("active");
		}  
	</script> --%>
