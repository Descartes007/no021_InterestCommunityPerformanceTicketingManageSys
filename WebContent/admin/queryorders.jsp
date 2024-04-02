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
			<h1 class="page-title">订单信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">订单号</th>
						<th class="text-center">用户</th>
						<th class="text-center">演唱会</th>
						<th class="text-center">门票</th>
						<th class="text-center">单价</th>
						<th class="text-center">数量</th>
						<th class="text-center">总计</th>
						<th class="text-center">状态</th>
					</tr>
				</thead>
				<c:forEach items="${ordersList}" var="orders">
					<tr align="center">
						<td class="center">${orders.ordercode}</td>
						<td class="center">${orders.username}</td>
						<td class="center">${orders.title}</td>
						<td class="center">${orders.areaname}</td>
						<td class="center">${orders.price}</td>
						<td class="center">${orders.num}</td>
						<td class="center">${orders.total}</td>
						<td class="center">${orders.status}</td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination">
				<li>
					<form action="orders/queryOrdersByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="ordercode">按订单号查询</option>
								<option value="usersid">按用户查询</option>
								<option value="concertid">按演唱会查询</option>
								<option value="ticketid">按门票查询</option>
								<option value="price">按单价查询</option>
								<option value="num">按数量查询</option>
								<option value="total">按总计查询</option>
								<option value="status">按状态查询</option>
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
