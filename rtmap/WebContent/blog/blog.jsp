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

<title>RTMAP_ANDROID</title>

<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/bootstrap-theme.css" rel="stylesheet">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.js"></script>
<link href="<%=basePath%>lib/codemirror.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>lib/codemirror.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/xml.js"></script>
<script type="text/javascript" src="js/jquery.zclip.min.js"></script>
<link
	href="${baseUrlStatic}/Font-Awesome-3.2.1/css/font-awesome.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${baseUrlStatic}/css/blog/blog.css?version=${version}"
	rel="stylesheet">
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

#msg {
	margin-left: 10px;
	color: green;
	border: 1px solid #3c3;
	background: url(img/checkmark.png) no-repeat 2px 3px;
	padding: 3px 6px 3px 20px
}
</style>
</head>
<body>
	<jsp:include page="/common/head.jsp" />
	<div class="container-fluid" role="main">
		<div class="container">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="col-md-12">
						<div class="col-sm-8 blog-main">
							<form id="courseListForm" action="./blog">
								<c:forEach var="article" items="${articleList}"
									varStatus="status">
									<div class="blog-post">
										<div
											style="display: inline-block; vertical-align: top; margin-top: 18px; margin-right: 5px;">
											<a href='./category/${article.category}'
												style="color: #4c4c4c;">
												<div class="tooltip-inner" style="padding: 3px 10px;">
													${article.categoryName }</div>
											</a>
										</div>
										<div style="display: inline-block; vertical-align: top;">
											<h3 class="blog-post-title">
												<a  href='./article/${article.id}.html'
													style="color: #4c4c4c;"><span id="article-title">${article.title}</span></a>
											</h3>
										</div>
										<fmt:formatDate var="publishTime"
											value="${article.publishTime}" pattern="yyyy-MM-dd HH:mm" />
										<p class="blog-post-meta" style="color: #ca0000;">
											<i class="icon-calendar"></i> <span id="publishTime"
												style="margin-right: 10px;">${publishTime}</span> | <i
												class="icon-user"></i> <span id="author"
												style="margin-right: 10px;">${article.author} </span> | <i
												class="icon-book"></i> <span id="userReadCount"
												style="margin-right: 10px;">${article.userReadCount}次阅读</span>
											| <i class="icon-comments"></i> <span class="ds-thread-count"
												data-thread-key="${article.id}"></span>
										</p>
										<div id="content">${article.contentDesc}</div>
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
											<a class="pull-right" style="font-size: 18px;"
												 href='./article/${article.id}.html#6'>阅读全文...</a>
										</div>
									</div>
									<!-- /.blog-post -->
								</c:forEach>
								<!-- google ads -->
								<!-- google ads end-->
								<jsp:include page="/common/blogPage.jsp" />
							</form>

						</div>

					</div>
					<!-- 	<div class="col-sm-7">
						<input type="text" class="form-control" id="inputUrl"
							placeholder="URL">
					</div>
					<input type="button" value="GET" id="btnPost"
						class="btn btn-primary btn-success" /> -->
				</div>
			</div>

			<div class="container-fluid">
				<div class="row-fluid">
					<div class="col-md-6"></div>
					<div class="col-md-6"></div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

$(function() {
		$('#btnCopy').zclip({
			path : 'js/ZeroClipboard.swf',
			copy : function() {//复制内容 
				return $('#javacode').val();
			},
			afterCopy : function() {//复制成功 
				$("<span id='msg'/>").insertAfter($('#btnCopy')).text('复制成功').fadeOut(2000);;
			}
		});
	});
	$(document).ready(function() {
		$("#btnSubmit").click(function() {
         $.post('ios/getJson',{json : $("#contentXml").val(),
				classprefix : $("#className").val(),
				nscoding:$("#nscoding").is(':checked'),
				description:$("#toString").is(':checked')
			}, function(data, status) {
				/* alert("Data: " + data + "\nStatus: " + status
						+ data.data); */
				if (status == "success") {
					$("#javacode").val(data.data);
				} else {
					$("#javacode").val("生成错误");
				}
			});
		});
		$("#btnSubmit1").click(function() {
         $.post('ios/getJson',{json : $("#contentXml").val(),
				classprefix : $("#className").val(),
				nscoding:$("#nscoding").is(':checked'),
				description:$("#toString").is(':checked')
			}, function(data, status) {
				/* alert("Data: " + data + "\nStatus: " + status
						+ data.data); */
				if (status == "success") {
					$("#javacode").val(data.data);
				} else {
					$("#javacode").val("生成错误");
				}
			});
		});
		
		
		
		/* $("#btnCopy").click(function() {
			var Url = $("#javacode").val();
			copyToClipboard(Url);
		}); */

		$("#btnClear").click(function() {
			$("#contentXml").val('');
			$("#javacode").val('');
		});

		$("#btnFomat").click(function() {
			format($("#contentXml").val(),false);
			alert('ddd');
		});

		/* myTextarea = document.getElementById("contentXml");
			var editor = CodeMirror.fromTextArea(myTextarea, {
				mode : "text/xml"
			}); */

	});
<%-- 
	function getJson(str) {
		$.post("<%=basePath%>
	android/getJson", {
			name : str,
			packageName : $("#packageName").val(),
			className : $("#className").val()
		}, function(data, status) {
			/* alert("Data: " + data + "\nStatus: " + status
					+ data.data); */
			if (status == "success") {
				$("#javacode").val(data.data);
			} else {
				$("#javacode").val("生成错误");
			}

		});
	}
 --%>
	function copyToClipboard(maintext) {
		if (window.clipboardData) {
			window.clipboardData.setData("Text", maintext);
		} else if (window.netscape) {
			try {
				netscape.security.PrivilegeManager
						.enablePrivilege("UniversalXPConnect");
			} catch (e) {
				alert("该浏览器不支持一键复制！请手工复制JavaCode～");
			}

			var clip = Components.classes['@mozilla.org/widget/clipboard;1']
					.createInstance(Components.interfaces.nsIClipboard);
			if (!clip)
				return;
			var trans = Components.classes['@mozilla.org/widget/transferable;1']
					.createInstance(Components.interfaces.nsITransferable);
			if (!trans)
				return;
			trans.addDataFlavor('text/unicode');
			var str = new Object();
			var len = new Object();
			var str = Components.classes["@mozilla.org/supports-string;1"]
					.createInstance(Components.interfaces.nsISupportsString);
			var copytext = maintext;
			str.data = copytext;
			trans.setTransferData("text/unicode", str, copytext.length * 2);
			var clipid = Components.interfaces.nsIClipboard;
			if (!clip)
				return false;
			clip.setData(trans, null, clipid.kGlobalClipboard);
		}
		alert("复制成功" + maintext);
	}
	
</script>
<!-- 请首先引用jquery，再引用其他js文件 -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript"
	src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${baseUrlStatic}/js/common/commonFunc.js"></script>
<script type="text/javascript" src="${baseUrlStatic}/js/system/index.js"></script>
<script type="text/javascript"
	src="${baseUrlStatic}/js/blog/article.js?ver=${version}"></script>
</html>
