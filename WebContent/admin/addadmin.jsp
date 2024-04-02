<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
<script type="text/javascript" src="js/admin.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body class=" theme-blue">
<jsp:include page="top.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="content">
	<div class="header">
		<h1 class="page-title">新增管理员信息</h1>
	</div>
	<div class="main-content">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div id="myTabContent" class="tab-content">
<form action="admin/addAdmin.action" name="myform" method="post" onsubmit="return check()" class="form">
 <div class="tab-pane active in" id="home"><div class="form-group"><label>用户名</label> <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名" /></div></div>
<div class="tab-pane active in" id="home"><div class="form-group"><label>密码</label> <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码" /></div></div>
<div class="tab-pane active in" id="home"><div class="form-group"><label>姓名</label> <input type="text" name="realname" class="form-control" id="realname" placeholder="请输入姓名" /></div></div>
<div class="tab-pane active in" id="home"><div class="form-group"><label>联系方式</label> <input type="text" name="contact" class="form-control" id="contact" placeholder="请输入联系方式" /></div></div>

<div>
<button type="submit" id="sub" class="btn btn-primary">提交保存</button>
&nbsp;&nbsp;&nbsp;
<button type="reset" id="res" class="btn btn-primary">取消重置</button>
</div>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>

