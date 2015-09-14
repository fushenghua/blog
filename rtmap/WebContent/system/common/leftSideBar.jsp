<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:if test="${!empty sysUser}">
</c:if>
<div class="col-lg-2">
	<div class="account-container">
		<div class="account-avatar">
		</div> <!-- /account-avatar -->
	
		<div class="account-details">
		
			<span class="account-name">${sysUser.userName}</span>
			
			<span class="account-role">系统管理员</span>
			
			<span class="account-actions">
				<a href="javascript:;">资料</a> |
				
				<a href="javascript:;">编辑</a>
			</span>
		
		</div> <!-- /account-details -->
	
	</div> <!-- /account-container -->
	
	<hr />
	
	<ul id="main-nav" class="nav nav-tabs nav-stacked">
		<li class="active"><a href="<%=basePath %>system/article" target="mainframe"><i class="icon-home"></i>文章管理</a></li>
	</ul>	
	
	<hr />
	
	<div class="sidebar-extra">
		<p>RTMAP_ANDROID Blog</p>
	</div> <!-- .sidebar-extra -->
	
	<br />

</div> <!-- /col-lg-2 -->
