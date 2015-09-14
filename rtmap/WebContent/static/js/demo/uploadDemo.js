/*=======================================*/
/*	uploadDemo功能的js                           */
/*	@author fushenghua                         */
/*	2014年9月1日21:36:07                          */
/*=======================================*/
$(document).ready(function(){
	
});

//表单提交新增失败后,返回回调函数,传回错误信息
function uploadSucced(msg){
//	var btn = $("#createPeriadBtn");
//	btn.button('reset');
	$("#firstUploadSucceedMsg").html(msg);
	$("#firstUploadSucceed").show();
	$("#firstUploadFailed").hide();
}
//表单提交修改失败后，传回提示信息
function uploadFailed(msg){
//	var btn = $("#updateperiadBtn");
//	btn.button('reset');
	$("#firstUploadFailedMsg").html(msg);
	$("#firstUploadFailed").show();
	$("#firstUploadSucceed").hide();
}