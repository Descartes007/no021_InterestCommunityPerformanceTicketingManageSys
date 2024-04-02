$(function() {

$("#catename").blur(
		function() {
			$("#catename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#catename").after("<span id='catename_msg' style='color: red'>类型名称不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var catename = $("#catename").val();
var memo = $("#memo").val();
$("#catename_msg").empty();
$("#memo_msg").empty();
if (catename == "" || catename == null) {
	$("#catename").after("<span id='catename_msg' style='color: red'>类型名称不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#catename_msg").empty();
$("#memo_msg").empty();
});

});
