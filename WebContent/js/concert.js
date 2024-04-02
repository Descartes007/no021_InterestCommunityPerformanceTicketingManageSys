$(function() {

$("#title").blur(
		function() {
			$("#title_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>封面不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>演唱会类型不能为空</span>");
			}
	});

$("#actor").blur(
		function() {
			$("#actor_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#actor").after("<span id='actor_msg' style='color: red'>主演不能为空</span>");
			}
	});

$("#address").blur(
		function() {
			$("#address_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#address").after("<span id='address_msg' style='color: red'>演出地址不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>演出时间不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var title = $("#title").val();
var image = $("#image").val();
var cateid = $("#cateid").val();
var actor = $("#actor").val();
var address = $("#address").val();
var addtime = $("#addtime").val();
var contents = $("#contents").val();
$("#title_msg").empty();
$("#image_msg").empty();
$("#cateid_msg").empty();
$("#actor_msg").empty();
$("#address_msg").empty();
$("#addtime_msg").empty();
$("#contents_msg").empty();
if (title == "" || title == null) {
	$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>封面不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>演唱会类型不能为空</span>");
	return false;
}
if (actor == "" || actor == null) {
	$("#actor").after("<span id='actor_msg' style='color: red'>主演不能为空</span>");
	return false;
}
if (address == "" || address == null) {
	$("#address").after("<span id='address_msg' style='color: red'>演出地址不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>演出时间不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#title_msg").empty();
$("#image_msg").empty();
$("#cateid_msg").empty();
$("#actor_msg").empty();
$("#address_msg").empty();
$("#addtime_msg").empty();
$("#contents_msg").empty();
});

});
