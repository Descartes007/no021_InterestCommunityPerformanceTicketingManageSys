$(function() {

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
			}
	});

$("#concertid").blur(
		function() {
			$("#concertid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#concertid").after("<span id='concertid_msg' style='color: red'>演唱会不能为空</span>");
			}
	});

$("#ticketid").blur(
		function() {
			$("#ticketid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ticketid").after("<span id='ticketid_msg' style='color: red'>门票不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>单价不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>加入日期不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var concertid = $("#concertid").val();
var ticketid = $("#ticketid").val();
var num = $("#num").val();
var price = $("#price").val();
var addtime = $("#addtime").val();
$("#usersid_msg").empty();
$("#concertid_msg").empty();
$("#ticketid_msg").empty();
$("#num_msg").empty();
$("#price_msg").empty();
$("#addtime_msg").empty();
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (concertid == "" || concertid == null) {
	$("#concertid").after("<span id='concertid_msg' style='color: red'>演唱会不能为空</span>");
	return false;
}
if (ticketid == "" || ticketid == null) {
	$("#ticketid").after("<span id='ticketid_msg' style='color: red'>门票不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>单价不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>加入日期不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#concertid_msg").empty();
$("#ticketid_msg").empty();
$("#num_msg").empty();
$("#price_msg").empty();
$("#addtime_msg").empty();
});

});
