<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript">
	function selok() {
		opener.document.getElementById("image").value = myform.p.value;
		window.close();
	}
</script>
</head>
<body class=" theme-blue">
	<div class="content">
		<div class="header">
			<h1 class="page-title">上传图片</h1>
		</div>
		<div class="main-content">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div id="myTabContent" class="tab-content">
						<form action="upload/image.action" name="myform" method="post" class="form" enctype="multipart/form-data">
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>图片</label> <input type="file" name="image" class="form-control" id="image" />
								</div>
							</div>
							<div>
								<c:if test="${imageFileName ne null }">
						${imageFileName } <input type="hidden" name="p" value="upfiles/${imageFileName }" id="p">
									<input type="button" class="btn btn-primary" value=" 确定 " onclick="selok();" />
								</c:if>
								<c:if test="${imageFileName eq null }">
									<input type="submit" class="btn btn-primary" value="上传图片" />
								</c:if>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

