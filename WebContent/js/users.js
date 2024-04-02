$(function() {

$("#username").blur(
		function() {
			$("#username_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#username").after("<span id='username_msg' style='color: red'>用户名不能为空</span>");
			}
	});

$("#password").blur(
		function() {
			$("#password_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#password").after("<span id='password_msg' style='color: red'>密码不能为空</span>");
			}
	});

$("#realname").blur(
		function() {
			$("#realname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#realname").after("<span id='realname_msg' style='color: red'>姓名不能为空</span>");
			}
	});

$("#sex").blur(
		function() {
			$("#sex_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#sex").after("<span id='sex_msg' style='color: red'>性别不能为空</span>");
			}
	});

$("#birthday").blur(
		function() {
			$("#birthday_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#birthday").after("<span id='birthday_msg' style='color: red'>出生日期不能为空</span>");
			}
	});

$("#contact").blur(
		function() {
			$("#contact_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contact").after("<span id='contact_msg' style='color: red'>联系方式不能为空</span>");
			}
	});

$("#address").blur(
		function() {
			$("#address_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#address").after("<span id='address_msg' style='color: red'>联系地址不能为空</span>");
			}
	});

$("#regdate").blur(
		function() {
			$("#regdate_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#regdate").after("<span id='regdate_msg' style='color: red'>注册日期不能为空</span>");
			}
	});







$('#sub').click(function(){
var username = $("#username").val();
var password = $("#password").val();
var realname = $("#realname").val();
var sex = $("#sex").val();
var birthday = $("#birthday").val();
var contact = $("#contact").val();
var address = $("#address").val();
var regdate = $("#regdate").val();
$("#username_msg").empty();
$("#password_msg").empty();
$("#realname_msg").empty();
$("#sex_msg").empty();
$("#birthday_msg").empty();
$("#contact_msg").empty();
$("#address_msg").empty();
$("#regdate_msg").empty();
if (username == "" || username == null) {
	$("#username").after("<span id='username_msg' style='color: red'>用户名不能为空</span>");
	return false;
}
if (password == "" || password == null) {
	$("#password").after("<span id='password_msg' style='color: red'>密码不能为空</span>");
	return false;
}
if (realname == "" || realname == null) {
	$("#realname").after("<span id='realname_msg' style='color: red'>姓名不能为空</span>");
	return false;
}
if (sex == "" || sex == null) {
	$("#sex").after("<span id='sex_msg' style='color: red'>性别不能为空</span>");
	return false;
}
if (birthday == "" || birthday == null) {
	$("#birthday").after("<span id='birthday_msg' style='color: red'>出生日期不能为空</span>");
	return false;
}
if (contact == "" || contact == null) {
	$("#contact").after("<span id='contact_msg' style='color: red'>联系方式不能为空</span>");
	return false;
}
if (address == "" || address == null) {
	$("#address").after("<span id='address_msg' style='color: red'>联系地址不能为空</span>");
	return false;
}
if (regdate == "" || regdate == null) {
	$("#regdate").after("<span id='regdate_msg' style='color: red'>注册日期不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#username_msg").empty();
$("#password_msg").empty();
$("#realname_msg").empty();
$("#sex_msg").empty();
$("#birthday_msg").empty();
$("#contact_msg").empty();
$("#address_msg").empty();
$("#regdate_msg").empty();
});

});
