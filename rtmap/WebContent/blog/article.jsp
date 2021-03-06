<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn" xmlns:wb="http://open.weibo.com/wb">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="${article.description }">
<meta name="keywords" content="${article.keyWords }" />
<meta name="author" content="RTMAP Blog ">
<!-- 微博的赞 -->
<!--必填-->
<meta property="og:type" content="article" />
<meta property="og:title" content="${article.htmlTitle}" />
<meta property="og:description" content="${article.description }" />
<!--选填-->
<!-- 	<meta property="og:image" content="文章的显示图片" /> -->
<!-- 	<meta name="weibo: article:create_at" content="文章的创建时间" /> -->
<!-- 	<meta name="weibo: article:update_at" content="文章的更新时间" /> -->

<link rel="icon" href="../../favicon.ico">

<title>${article.htmlTitle}</title>

<!-- Bootstrap core CSS -->
<link
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${baseUrlStatic}/Font-Awesome-3.2.1/css/font-awesome.min.css"
	rel="stylesheet">
<!-- 新浪微博评论箱 -->
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey=17994897"
	type="text/javascript" charset="utf-8"></script>
<!-- Custom styles for this template -->
<link href="${baseUrlStatic}/css/blog/blog.css?version=${version}"
	rel="stylesheet">
<%--     <link href="${baseUrlStatic}/syntaxhighlighter_3.0.83/styles/shCore.css" rel="stylesheet" type="text/css"> --%>
<link
	href="${baseUrlStatic}/syntaxhighlighter_3.0.83/styles/shCoreRDark.css?version=${version}"
	rel="stylesheet" type="text/css">
<style type="text/css">
pre {
	margin: 0;
	padding: 0;
}

blockquote {
	font-size: 15px;
}

body {
	padding-top: 100px;
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

</head>

<body>

	<jsp:include page="/common/head.jsp" />
	<div class="container">


		<div class="row">
			<div class="col-sm-8 blog-main">

				<div class="blog-post">
					<div
						style="display: inline-block; vertical-align: top; margin-top: 2px; margin-right: 5px;">
						<a href='./category/${article.category}' style="color: #4c4c4c;">
							<div class="tooltip-inner" style="padding: 3px 15px;">
								${article.categoryName }</div>
						</a>
					</div>
					<div style="display: inline-block; vertical-align: top;">
						<h3 class="blog-post-title">${article.title}</h3>
					</div>
					<fmt:formatDate var="publishTime" value="${article.publishTime}"
						pattern="yyyy-MM-dd HH:mm" />
					<p class="blog-post-meta">
						<i class="icon-calendar"></i> <span id="publishTime"
							style="margin-right: 10px;">${publishTime}</span> | <i
							class="icon-user"></i> <span id="author"
							style="margin-right: 10px;">${article.author} </span> | <i
							class="icon-book"></i> <span id="userReadCount"
							style="margin-right: 10px;">${article.userReadCount}次阅读</span> |
						<a href="#tagArticle"><i class="icon-comments"></i> <span
							class="ds-thread-count" data-thread-key="${article.id}"></span></a>
					</p>

					<!-- 百度 ads -->
					<script type="text/javascript">
						/*728*15 创建于 2014-10-21*/
						var cpro_id = "u1769646";
					</script>
					<script src="http://cpro.baidustatic.com/cpro/ui/c.js"
						type="text/javascript"></script>
					<!-- 百度 ads end-->

					<div id="content" style="margin-top: 20px; margin-bottom: 20px;">
						${article.content}</div>
					<div class="clickforWhole"
						style="font-size: 12px; border-bottom: 1px solid #ddd; padding-bottom: 25px; padding-top: 10px;">
						<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
						<c:forEach var="tagName" items="${article.tagList }"
							varStatus="statusTag">
							<a href='/tag/${tagName}'>${tagName }</a>
							<c:if test="${statusTag.last == false}">
             			,
             		</c:if>
						</c:forEach>
					</div>



					<!-- baidu ads -->
					<script type="text/javascript">
						/*760*90 文章下方 2014-10-22*/
						var cpro_id = "u1770423";
					</script>
					<script src="http://cpro.baidustatic.com/cpro/ui/c.js"
						type="text/javascript"></script>
					<!-- baidu ads end-->


				</div>
				<!-- /.blog-post -->


				<!-- 相关文章 -->
				<div id="tagArticle">
					<div class="panel panel-primary">
						<!-- Default panel contents -->
						<div class="panel-heading">
							<h3 class="panel-title">相关文章</h3>
						</div>
						<!-- List group -->
						<div class="list-group">
							<c:forEach var="article" items="${categoryArticleList}"
								varStatus="status">
								<fmt:formatDate var="publishDate" value="${article.publishTime}"
									pattern="yyyy年MM月dd日" />
								<a href='./article/${article.id}.html#6'
									class="list-group-item ">
									<div class="col-md-3">
										<span style="margin-right: 10px;">${publishDate}</span>
									</div>
									<div>${article.title}</div>
								</a>
							</c:forEach>
						</div>
					</div>
				</div>
				<!-- /.相关文章 -->

			</div>
			<!-- /.blog-main -->



		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
	<!-- google ads -->
	<!-- google ads end-->

	<jsp:include page="/common/footer.jsp" />
	<!-- 百度ad -->
	<script src="http://cpro.baidustatic.com/cpro/ui/s.js"
		type="text/javascript"></script>
	<!-- 百度ad -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- 请首先引用jquery，再引用其他js文件 -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="${baseUrlStatic}/js/blog/article.js?ver=${version}"></script>
	<script
		src="${baseUrlStatic}/syntaxhighlighter_3.0.83/scripts/shCore.js"
		type="text/javascript"></script>
	<script
		src="${baseUrlStatic}/syntaxhighlighter_3.0.83/scripts/shBrushJava.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		SyntaxHighlighter.all();
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#blog-masthead").find('a').removeClass('active');
			$("#blog-masthead .blog-nav .blog").addClass('active');
		});
	</script>
</body>
</html>

