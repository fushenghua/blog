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
<meta name="author" content="jack">
<link rel="shortcut icon" href="${baseUrlStatic}/icon/favicon.png">
<title>RTMAP Blog </title>
<!-- Bootstrap core CSS -->
<link
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 我们自己的css样式文件放在这里 -->
<%--     <link href="${baseUrlStatic}/css/system/dashboard.css" rel="stylesheet"> --%>
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

.sub-header {
	border-bottom: 1px solid #eee;
	padding-bottom: 10px;
	padding-top: 20px;
}

.btn-primary {
	background-color: #113355;
	background-image: -moz-linear-gradient(center top, #446688, #113355);
}

.btn-primary:hover {
	background-color: #113355;
}
</style>
</head>
<body>
	<div id="contentDiv" class="container-fluid">
		<!--   		<h1 class="page-title" style="line-height: 36px;"> -->
		<!-- 			<i class="icon-home"></i> -->
		<!-- 			文章管理					 -->
		<!-- 		</h1> -->
		<div class="widget">
			<div class="widget-header">
				<h3 style="margin-top: 0px;">文章管理</h3>
			</div>
			<!-- /widget-header -->
			<div class="widget-content">
				<ul id="contentUl" class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active firstLi"><a href="#">文章列表</a></li>
					<li id="new_article_tab" role="presentation"
						class="new_article_tab"><a href="#">新增文章</a></li>
					<li id="update_article_tab" role="presentation"
						class="update_article_tab"><a href="#">修改文章</a></li>
				</ul>
				<div id="listDiv" class="listDiv">
					<div class="sub-header">
						<span id="periodTitle" class="title h2">&nbsp;</span>
						<button id="newArticleBtn" class="btn btn-primary btn-xs"
							type="button" style="float: right; margin-top: 4px;">
							<span style="font-size: 15px; padding: 5px;"><i
								class="icon-plus-sign-alt"></i> 新增文章</span>
						</button>
					</div>
					<form id="courseListForm" action="/system/article">
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>文章title</th>
										<th>阅读次数</th>
										<th>分类</th>
										<th>发表时间</th>
										<th>作者</th>
										<th class="text-center">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="data" items="${articleList}" varStatus="status">
										<tr>
											<td style="width: 20%;"><span class="ellipsis"
												title="test">${data.title}</span></td>
											<td style="width: 15%;">${data.userReadCount}</td>
											<td style="whdth: 15%;">${data.category}</td>
											<fmt:formatDate var="publishTime" value="${data.publishTime}"
												pattern="yyyy-MM-dd " />
											<td style="width: 15%;">${publishTime}</td>
											<td style="width: 15%;">${data.author}</td>
											<td class="text-center" style="width: 20%;"><a
												href="javascript:" onclick="toUpdateArticle(${data.id})"><i
													class="icon-edit"></i> 修改</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
												href="javascript:" onclick="delArticleById(${data.id})"><i
													class="icon-trash"></i> 删除</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<jsp:include page="/common/page.jsp" />
					</form>
				</div>
				<div id="addDiv" class="addDiv" style="padding-top: 30px;">
					<jsp:include page="addArticle.jsp" />
				</div>
				<div id="updateDiv" class="updateDiv" style="padding-top: 30px;">
					<jsp:include page="updateArticle.jsp" />
				</div>
			</div>
		</div>


		<jsp:include page="delArticle.jsp" />
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- 请首先引用jquery，再引用其他js文件 -->
	<!-- Placed at the end of the document so the pages load faster -->
	<%--     <script type="text/javascript" src="${baseUrlStatic}/js/common/jquery-1.11.1.min.js"></script> --%>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/js/common/commonFunc.js"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/kindeditor-4.1.7/kindeditor.js?ver=${version}"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/kindeditor-4.1.7/lang/zh_CN.js?ver=${version}"></script>
	<script type="text/javascript"
		src="${baseUrlStatic}/js/system/blogArticle.js?ver=${version}"></script>
</body>
</html>
