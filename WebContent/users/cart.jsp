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
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			购物车
		</div>
	</div>
	<div class="blank"></div>
	<div class="block table">
		<div class="flowBox">
			<h6>
				<span>购物车</span>
			</h6>
			<form action="index/deletecart.action" method="post">
				<table width="99%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
					<tr>
						<th bgcolor="#ffffff">演唱会</th>
						<th bgcolor="#ffffff">区域</th>
						<th bgcolor="#ffffff">数量</th>
						<th bgcolor="#ffffff">票价</th>
						<th bgcolor="#ffffff">日期</th>
						<th bgcolor="#ffffff">操作</th>
					</tr>
					<c:forEach items="${cartList}" var="cart">
						<tr>
							<td bgcolor="#ffffff" align="center" style="width: 300px;"><a
								href="index/detail.action?id=${cart.concertid }" target="_blank" class="f6">${cart.title }</a></td>
							<td align="center" bgcolor="#ffffff">${cart.areaname }</td>
							<td align="center" bgcolor="#ffffff">￥${cart.price }元</td>
							<td align="center" bgcolor="#ffffff">${cart.num }</td>
							<td align="center" bgcolor="#ffffff">${cart.addtime }</td>
							<td align="center" bgcolor="#ffffff"><a
								href="javascript:if (confirm('您确实要把该车辆移出购物车吗？')) location.href='<%=basePath%>index/deletecart.action?id=${cart.cartid}'; "
								class="f6">移除</a></td>
						</tr>
					</c:forEach>
				</table>


				<table width="99%" align="center" border="0" cellpadding="5" cellspacing="0" bgcolor="#dddddd">
					<tr>
						<td bgcolor="#ffffff"><a href="index.jsp"><img src="themes/xecmoban_haier2015/images/continue.gif"
								alt="continue" /> </a></td>
						<td bgcolor="#ffffff" align="right"><a href="index/checkout.action"><img
								src="themes/xecmoban_haier2015/images/checkout.gif" alt="checkout" /> </a></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="blank"></div>

		<div class="blank5"></div>
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
