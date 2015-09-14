<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="zh-cn">
<base href="<%=basePath%>">
  <body>
  	<div id="addArticle">
       <form id="updateArticleForm" method="post" action="./system/article/updateArticle" class="form-horizontal" enctype="multipart/form-data" target="hidden_frame">  
       		<input type="hidden" name="id" id="articleId">
       		<div class="form-group">
			    <label for="inputEmail3" class="col-sm-1 control-label">标题</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" id="updateTitle" name="title" placeholder="文章标题">
			    </div>
			     <label for="inputPassword3" class="col-sm-1 control-label">分类</label>
			    <div class="col-sm-2">
			      <select id="updateCategory" class="form-control" name="category">
					  <option value="1" selected>java</option>
                      <option value="2">HTML5</option>
                      <option value="3">iOS</option>
                      <option value="4">Android</option>
				  </select>
			    </div>
		    </div>
		    <div class="form-group">
			    <label for="inputEmail3" class="col-sm-1 control-label">关键字</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" id="updateKeyWords" name="keyWords" placeholder="关键字">
			    </div>
			    <label for="inputPassword3" class="col-sm-1 control-label">是否展示</label>
			    <div class="col-sm-2">
			      <select id="updateShowFlag" class="form-control" name="showFlag">
					  <option value="1" selected>展示</option>
                      <option value="2">不展示</option>
				  </select>
			    </div>
		    </div>
		    <div class="form-group">
			    <label for="inputEmail3" class="col-sm-1 control-label">tag标签</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" id="updateTag" name="tag" placeholder="以逗号分隔的tag" value="java">
			    </div>
		    </div>
		    <div class="form-group">
			    <label for="inputEmail3" class="col-sm-1 control-label">网页描述</label>
			    <div class="col-sm-6">
			    	<textarea class="form-control" id="updateDescription" name="description" placeholder="网页主要内容" rows="2"></textarea>
			    </div>
		    </div>
			<div class="form-group">
			    <label for="inputEmail3" class="col-sm-1 control-label">文章内容</label>
			    <div class="col-sm-6">
		    		<textarea id="updateArticle" style="visibility:hidden;"></textarea>
					<textarea id="updateHtmlContent" name="content" style="display:none" align="center"></textarea>
			    </div>
		    </div>
			<div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button id="updateArticleBtn" type="submit" class="btn btn-primary">保存</button>
			    </div>
			</div>
        </form> 
        <iframe name='hidden_frame' id ="hidden_frame" style='display:none'></iframe>
  	</div>
  </body>
</html>
