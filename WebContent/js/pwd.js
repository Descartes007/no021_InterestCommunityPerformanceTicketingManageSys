$(function() {

$("#password").blur(
		function() {
			$("#password_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#password").after("<span id='password_msg' style='color: red'>密码不能为空</span>");
			}
	});

$("#newpassword").blur(
		function() {
			$("#newpassword_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#newpassword").after("<span id='newpassword_msg' style='color: red'> 新密码不能为空</span>");
			}
	});

$("#repassword").blur(
		function() {
			$("#repassword_msg").empty();
			var name = $(this).val();
			var newpassword = $("#newpassword").val();
			var repassword = $("#repassword").val();
			if (name == "" || name == null) {
				$("#repassword").after("<span id='repassword_msg' style='color: red'>确认密码不能为空</span>");
			}else if (repassword != newpassword){
				$("#repassword").after("<span id='repassword_msg' style='color: red'>校验失败</span>");
			}
	});







$('#sub').click(function(){
var password = $("#password").val();
var newpassword = $("#newpassword").val();
var repassword = $("#repassword").val();
$("#password_msg").empty();
$("#newpassword_msg").empty();
$("#repassword_msg").empty();
if (password == "" || password == null) {
	$("#password").after("<span id='password_msg' style='color: red'>密码不能为空</span>");
	return false;
}
if (newpassword == "" || newpassword == null) {
	$("#newpassword").after("<span id='newpassword_msg' style='color: red'> 新密码不能为空</span>");
	return false;
}
if (repassword == "" || repassword == null) {
	$("#repassword").after("<span id='repassword_msg' style='color: red'>确认密码不能为空</span>");
	return false;
}

if (repassword != newpassword) {
	$("#repassword").after("<span id='repassword_msg' style='color: red'>校验失败</span>");
	return false;
}
});

$('#res').click(function(){
	$("#password_msg").empty();
	$("#newpassword_msg").empty();
	$("#repassword_msg").empty();
});

});
