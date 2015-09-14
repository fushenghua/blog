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
<%-- <head>
<base href="<%=basePath%>">

<title>RTMAP_ANDROID</title>

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<link href="lib/codemirror.css" rel="stylesheet">
<script type="text/javascript" src="lib/codemirror.js"></script>
<script type="text/javascript" src="lib/xml.js"></script>
<script type="text/javascript" src="js/jquery.zclip.min.js"></script>

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

.center {
	width: auto;
	display: table;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head> --%>
<style>
body {
	height: 100%;
	background-color: #333;
}

body {
	color: #fff;
	text-align: center;
	text-shadow: 0 1px 3px rgba(0, 0, 0, .5);
}

.site-wrapper {
	display: table;
	width: 100%;
	height: 100%; /* For at least Firefox */
	min-height: 100%;
	-webkit-box-shadow: inset 0 0 0px rgba(0, 0, 0, .5);
	box-shadow: inset 0 0 200px rgba(0, 0, 0, .5);
}
</style>
<body>
	<jsp:include page="common/head.jsp" />
	<div class="container-fluid" role="main">
		<!-- <div class="container">
			<div class="container-fluid"> -->
		<!-- 				<div class="blog-header">
					<h1 class="blog-title">RTMAP ANDROID</h1>
				</div>
 -->
		<!-- 	<div class="row-fluid">
					<div class="col-md-6">
						<legend>LayoutXML</legend>
						<article>
						<textarea rows="16" cols="80" name="name" id="contentXml"
							placeholder="请在这里粘贴布局XML" class="form-control"></textarea></article>
						<p></p>
						<input type="button" value="生成" id="btnSubmit"
							class="btn btn-primary btn-success" /> <input type="button"
							value="清空" class="btn btn-info " id="btnClear" />
					</div>
					<div class="col-md-6">
						<legend>Java Code</legend>
						<form action="user/layout" method="post">
							<textarea rows="16" cols="80" name="name" placeholder="从这里复制代码"
								id="javacode" class="form-control"></textarea>
							<p></p>
							<input type="button" value="复制" class="btn btn-primary "
								id="btnCopy" />
						</form>
					</div>
				</div>
			</div> -->
		<!-- 		</div>
		</div>
		-->
	</div>
	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="cover-container">
				<div class="inner cover">
					<h1 class="cover-heading">RTMAP ANDROID Page.</h1>
					<p class="lead">Coding/></p>
					<p>让开发更简单</p>
					<p class="lead">
						<a href="blog#7" class="btn btn-info btn-default">Go Bolg</a>
					</p>
				<!-- 	<li class="dropdown"><a href="javascript:void(0);">功能</a>
						<ul class="menu">
							<li><a href="https://coding.net/git"><i class="git icon"></i>
									代码托管</a></li>
							<li><a href="https://coding.net/pm"><i
									class="icon collaboration"></i> 项目管理</a></li>
							<li><a href="https://ide.coding.net/"><i
									class="ide icon"></i> WebIDE</a></li>
							<li><a href="https://coding.net/app"><i class="app icon"></i>
									APP</a></li>
						</ul></li> -->
				</div>
				<!-- 
          <div class="mastfoot">
            <div class="inner">
              <p>RTMAP　Bolg for <a href="http://getbootstrap.com">ANDROID</a>, by <a href="http://weibo.com/3743327644/profile?topnav=1&wvr=6">@SANILOV</a>.</p>
            </div>
          </div> -->
			</div>
		</div>

	</div>

	<jsp:include page="common/footer.jsp" />
</body>
<link href="cover/cover.css" rel="stylesheet" type="text/css" />
</html>
