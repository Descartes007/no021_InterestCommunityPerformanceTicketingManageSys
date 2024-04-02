<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
</head>
<body class=" theme-blue">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="content">
		<div class="header">
			<h1 class="page-title">网站用户信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">用户名</th>
						<th class="text-center">姓名</th>
						<th class="text-center">性别</th>
						<th class="text-center">出生日期</th>
						<th class="text-center">联系方式</th>
						<th class="text-center">联系地址</th>
						<th class="text-center">注册日期</th>
					</tr>
				</thead>
				<c:forEach items="${usersList}" var="users">
					<tr align="center">
						<td class="center">${users.username}</td>
						<td class="center">${users.realname}</td>
						<td class="center">${users.sex}</td>
						<td class="center">${users.birthday}</td>
						<td class="center">${users.contact}</td>
						<td class="center">${users.address}</td>
						<td class="center">${users.regdate}</td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination">
				<li>
					<form action="users/queryUsersByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="username">按用户名查询</option>
								<option value="password">按密码查询</option>
								<option value="realname">按姓名查询</option>
								<option value="sex">按性别查询</option>
								<option value="birthday">按出生日期查询</option>
								<option value="contact">按联系方式查询</option>
								<option value="address">按联系地址查询</option>
								<option value="regdate">按注册日期查询</option>
						</select>
						</label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp;
						<label><input type="submit" value="查询" class="mws-button green" /> </label>${html }
					</form>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
