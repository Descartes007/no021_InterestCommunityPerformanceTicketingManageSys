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
			<h1 class="page-title">演唱会信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">标题</th>
						<th class="text-center">演唱会类型</th>
						<th class="text-center">主演</th>
						<th class="text-center">是否推荐</th>
						<th class="text-center">演出地址</th>
						<th class="text-center">演出时间</th>
						<th class="text-center">点击数</th>
						<th class="text-center">销售数</th>
					</tr>
				</thead>
				<c:forEach items="${concertList}" var="concert">
					<tr align="center">
						<td class="center">${concert.title}</td>
						<td class="center">${concert.catename}</td>
						<td class="center">${concert.actor}</td>
						<td class="center">${concert.recommend}</td>
						<td class="center">${concert.address}</td>
						<td class="center">${concert.addtime}</td>
						<td class="center">${concert.hits}</td>
						<td class="center">${concert.sellnum}</td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination">
				<li>
					<form action="concert/queryConcertByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="title">按标题查询</option>
								<option value="image">按封面查询</option>
								<option value="cateid">按演唱会类型查询</option>
								<option value="actor">按主演查询</option>
								<option value="recommend">按是否推荐查询</option>
								<option value="address">按演出地址查询</option>
								<option value="addtime">按演出时间查询</option>
								<option value="hits">按点击数查询</option>
								<option value="sellnum">按销售数查询</option>
								<option value="contents">按介绍查询</option>
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
