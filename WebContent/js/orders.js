$(function() {

$("#ordercode").blur(
		function() {
			$("#ordercode_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ordercode").after("<span id='ordercode_msg' style='color: red'>订单号不能为空</span>");
			}
	});

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

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>单价不能为空</span>");
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

$("#total").blur(
		function() {
			$("#total_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#total").after("<span id='total_msg' style='color: red'>总计不能为空</span>");
			}
	});

$("#status").blur(
		function() {
			$("#status_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#status").after("<span id='status_msg' style='color: red'>状态不能为空</span>");
			}
	});







$('#sub').click(function(){
var ordercode = $("#ordercode").val();
var usersid = $("#usersid").val();
var concertid = $("#concertid").val();
var ticketid = $("#ticketid").val();
var price = $("#price").val();
var num = $("#num").val();
var total = $("#total").val();
var status = $("#status").val();
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#concertid_msg").empty();
$("#ticketid_msg").empty();
$("#price_msg").empty();
$("#num_msg").empty();
$("#total_msg").empty();
$("#status_msg").empty();
if (ordercode == "" || ordercode == null) {
	$("#ordercode").after("<span id='ordercode_msg' style='color: red'>订单号不能为空</span>");
	return false;
}
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
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>单价不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
	return false;
}
if (total == "" || total == null) {
	$("#total").after("<span id='total_msg' style='color: red'>总计不能为空</span>");
	return false;
}
if (status == "" || status == null) {
	$("#status").after("<span id='status_msg' style='color: red'>状态不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#concertid_msg").empty();
$("#ticketid_msg").empty();
$("#price_msg").empty();
$("#num_msg").empty();
$("#total_msg").empty();
$("#status_msg").empty();
});

});
