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
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<c:forEach items="${concertList}" var="concert">
					<tr align="center">
						<td>${concert.title}</td>
						<td>${concert.catename}</td>
						<td>${concert.actor}</td>
						<td>${concert.recommend}</td>
						<td>${concert.address}</td>
						<td>${concert.addtime}</td>
						<td>${concert.hits}</td>
						<td>${concert.sellnum}</td>
						<td><a href="concert/getConcertById.action?id=${concert.concertid}"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;<a
							href="concert/deleteConcert.action?id=${concert.concertid}"
							onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pagination">${html }</div>
		</div>
	</div>
</body>
</html>
