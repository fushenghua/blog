/*=======================================*/
/*	blogArticle功能的js                           */
/*	2014年6月5日18:58:00                          */
/*=======================================*/
$(document).ready(function(){
	$("#new_article_tab").hide();
	$("#addDiv").hide();
	$("#update_article_tab").hide();
	$("#updateDiv").hide();
	
	$("#md5Button").on('click',function(){
		var md5Input = $("#md5_input").val();
		var md5_output = CryptoJS.MD5(md5Input);
		$("#md5_output").html(md5_output.toString());
    });
});


function setUpdateEditor(articleHtml){
	updateEditor.html(articleHtml.toString());//修改讲义时，将讲义的html代码回显到文本编辑器中
}

function toUpdateArticle(articleId){
	$("#articleId").val(articleId);
	var datasent = {"id":articleId};
	params = JSON.stringify(datasent); 
	$.ajax({
		type : "POST",
		url : "./system/article/getArticleByArticleId",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		data : params,
		async : false,
		success : function(data) {
			$("#updateTitle").val(data.data.title);
			$("#updateKeyWords").val(data.data.keyWords);
			$("#updateDescription").val(data.data.description);
			setUpdateEditor(data.data.content);
			//清空下拉框，仅留提示选项
			$("#updateShowFlag").empty();
			$("#updateShowFlag").append("<option value='1'>展示</option>");  //添加一项option
			$("#updateShowFlag").append("<option value='2'>不展示</option>");  //添加一项option
			$("#updateShowFlag option[value='"+ data.data.showFlag +"']").attr("selected", true);
		}
	});
	$("#update_article_tab").show();
	$("#updateDiv").show();
	$("#contentUl").find('li').removeClass('active');
	$("#contentUl .update_article_tab").addClass('active');
	$("#listDiv").hide();
}

//删除教室
function delArticleById(id){
	$("#delArticleId").val(id);
	$("#delModal").modal('show');
	$("#delAlert").hide();
}

$('#delArticleBtn').on('click',function () {
	delArticle();
});

$('#cancleDelArticleBtn').on('click',function () {
	$("#delModal").modal('hide');
});
