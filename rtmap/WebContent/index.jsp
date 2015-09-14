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
	</div>
	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="cover-container">
				<div class="inner cover">
					<h1 class="cover-heading">RTMAP Blog Page.</h1>
					<p class="lead">Coding/></p>
					<p>让开发更简单……</p>
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
