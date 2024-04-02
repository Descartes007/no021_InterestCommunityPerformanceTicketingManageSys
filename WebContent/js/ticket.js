$(function() {

$("#concertid").blur(
		function() {
			$("#concertid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#concertid").after("<span id='concertid_msg' style='color: red'>演唱会不能为空</span>");
			}
	});

$("#areaname").blur(
		function() {
			$("#areaname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#areaname").after("<span id='areaname_msg' style='color: red'>区域名称不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>价格不能为空</span>");
			}
	});

$("#storage").blur(
		function() {
			$("#storage_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#storage").after("<span id='storage_msg' style='color: red'>总数不能为空</span>");
			}
	});







$('#sub').click(function(){
var concertid = $("#concertid").val();
var areaname = $("#areaname").val();
var price = $("#price").val();
var storage = $("#storage").val();
$("#concertid_msg").empty();
$("#areaname_msg").empty();
$("#price_msg").empty();
$("#storage_msg").empty();
if (concertid == "" || concertid == null) {
	$("#concertid").after("<span id='concertid_msg' style='color: red'>演唱会不能为空</span>");
	return false;
}
if (areaname == "" || areaname == null) {
	$("#areaname").after("<span id='areaname_msg' style='color: red'>区域名称不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>价格不能为空</span>");
	return false;
}
if (storage == "" || storage == null) {
	$("#storage").after("<span id='storage_msg' style='color: red'>总数不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#concertid_msg").empty();
$("#areaname_msg").empty();
$("#price_msg").empty();
$("#storage_msg").empty();
});

});
