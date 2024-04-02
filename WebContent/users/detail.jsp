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
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			<a href="index/all.action">全部演唱会</a>
			<code> &gt; </code>
			<a href="index/cate.action?id=${concert.cateid }">${concert.catename }</a>
			<code> &gt; </code>
			${concert.title }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree">
				<div class="tit">所有演唱会分类</div>
				<dl class="clearfix" style="overflow: hidden;">
					<c:forEach items="${cateList}" var="cate">
						<div class="box1 cate" id="cate">
							<h1 style="border-top: none">
								<a href="index/cate.action?id=${cate.cateid }" class="  f_l">${cate.catename }</a>
							</h1>
						</div>
						<div style="clear: both"></div>
					</c:forEach>
				</dl>
			</div>
			<div class="blank"></div>
			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>热门演唱会</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<c:forEach items="${hotList}" var="concert">
							<ul class="clearfix">
								<li class="goodsimg"><a href="index/detail.action?id=${concert.concertid }" target="_blank"><img
										src="${concert.image }" alt="${concert.title }" class="B_blue" /> </a></li>
								<li><a href="index/detail.action?id=${concert.concertid }" target="_blank" title="${concert.title }">${concert.title }</a>
								</li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
		<div class="AreaR">

			<div id="goodsInfo" class="clearfix">
				<div class="imgInfo">
					<img src="${concert.image}" alt="${concert.title }" width="360px;" height="360px" />
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>
				<div class="textInfo">
					<form action="index/addcart.action" method="post" name="ECS_FORMBUY" id="ECS_FORMBUY">
						<h1 class="clearfix">${concert.title }</h1>
						<ul class="ul2 clearfix">
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>演唱会类型：</strong><a href="index/cate.action?id=${concert.cateid }">${concert.catename }</a>
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>演出时间：</strong>${concert.addtime}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>主演：</strong>${concert.actor}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>演出地址：</strong>${concert.address}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>销售数：</strong>${concert.sellnum}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>点击数：</strong>${concert.hits}
								</dd>
							</li>
						</ul>
						<ul class="bnt_ul">
							<li class="clearfix" style="width: 100%">
								<table>
									<tr>
										<c:forEach items="${ticketList}" var="ticket">
											<td><input type="radio" name="ticketid" value="${ticket.ticketid }" checked="checked">${ticket.areaname }&nbsp;(￥${ticket.price }元)&nbsp;</td>
										</c:forEach>
									</tr>
								</table>
							</li>
							<li class="clearfix">
								<dd>
									<strong>购买数量：</strong> <input name="num" type="text" id="number" value="1" size="4"
										style="border: 1px solid #ccc;" /> <input type="hidden" name="concertid" value="${concert.concertid }" />
								</dd>
							</li>
							<li class="padd"><input type="image" src="themes/xecmoban_haier2015/images/goumai2.png" /></li>
						</ul>
					</form>
				</div>
			</div>
			<div class="blank"></div>
			<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>演唱会描述</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_v" class="  " style="padding: 6px;"></div>
					<div id="com_h">
						<blockquote>${concert.contents}</blockquote>
					</div>
				</div>
			</div>
			<div class="blank"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
