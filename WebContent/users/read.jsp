<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			${article.title }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block">
		<div class="box">
			<div class="box_1">
				<h3>
					<span>${article.title}</span>
				</h3>
				<div class="boxCenterList">
					<center>
						<img src="${article.image }" alt="" width="300" height="200" />
					</center>
				<center>	${article.contents } </center>
				</div>
			</div>
		</div>
		<div class="blank5"></div>
	</div>
	


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
