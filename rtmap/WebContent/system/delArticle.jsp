<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!-- 删除教室弹出框提示 -->
<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
	<div class="modal-dialog" style="">
		<div class="modal-content">
			<form id="delArticleForm" class="form-horizontal">
				<input type="hidden" name="id" id="delArticleId" value="" />
				<div class="modal-header" style="background-color: #da4f49;">
					<span class="modal-title" id="delModalTitle" style="font-size: 16px;">警告</span>
				</div>
				<div class="modal-body">
					<span class="modal-title" style="font-size: 16px;">确认删除吗？</span>
				</div>
				<div class="modal-footer" style="margin-top: 0px;">
					<div id="delAlert" class="alert alert-danger pull-left" style="display: none;">
				    	<strong>Sorry!</strong> 修改失败.
					</div>
				    <button id="cancleDelArticleBtn" type="button" class="btn btn-default">取消 </button>
				    <button id="delArticleBtn" type="button" class="btn btn-danger">确定 </button>
				</div>
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div>
					
					