<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="RTMAP Blog 后台管理">
<meta name="author" content="jack">
<link rel="shortcut icon" href="${baseUrlStatic}/icon/favicon.png">
<title>RTMAP Blog 后台管理</title>
<!-- Bootstrap core CSS -->
<link
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 我们自己的css样式文件放在这里 -->
<link href="${baseUrlStatic}/loginCss/adminia.css" rel="stylesheet">
<link href="${baseUrlStatic}/loginCss/adminia-responsive.css"
	rel="stylesheet">
<link href="${baseUrlStatic}/loginCss/dashboard.css" rel="stylesheet">
<link
	href="${baseUrlStatic}/Font-Awesome-3.2.1/css/font-awesome.min.css"
	rel="stylesheet">
<style type="text/css">
textarea {
	display: block;
}
</style>
</head>
<body>
	<jsp:include page="common/topSideBar.jsp" />
	<div id="content">

		<div class="container-fluid">


			<jsp:include page="common/leftSideBar.jsp" />

			<div class="col-lg-10">

				<div id="indexDiv" class="">
					<div id="mainDiv">
						<iframe id="mainframe" frameborder="0" width="100%" height="950"
							scrolling="no" src="./system/article" name="mainframe"></iframe>
					</div>
				</div>

			</div>
			<!-- /span9 -->



		</div>
		<!-- /container -->

	</div>
	<!-- /content -->


	<div id="footer">

		<div class="container">
			<hr />
			<p>&copy; 2015@ RTMAP.</p>
		</div>
		<!-- /container -->

	</div>
	<!-- /footer -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- 请首先引用jquery，再引用其他js文件 -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/js/common/commonFunc.js"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/js/system/index.js" charset="utf-8"></script>
</body>
</html>
