<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	$(function() {
		var uls = $('.sidebar-nav > ul > *').clone();
		uls.addClass('visible-xs');
		$('#main-menu').append(uls.clone());
	});
</script>
<script src="lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function() {
			return false;
		});
	});
</script>
<div class="sidebar-nav">
	<ul>

		<li><a data-target=".legal-menu1" class="nav-header collapsed" data-toggle="collapse">管理员信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu1 nav nav-list collapse">
				<li><a href="admin/createAdmin.action"><span class="fa fa-caret-right"></span>新增管理员信息</a></li>
				<li><a href="admin/getAllAdmin.action"><span class="fa fa-caret-right"></span>管理员信息列表</a></li>
				<li><a href="admin/queryAdminByCond.action"><span class="fa fa-caret-right"></span>管理员信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu2" class="nav-header collapsed" data-toggle="collapse">网站用户信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu2 nav nav-list collapse">
				<li><a href="users/getAllUsers.action"><span class="fa fa-caret-right"></span>网站用户信息列表</a></li>
				<li><a href="users/queryUsersByCond.action"><span class="fa fa-caret-right"></span>网站用户信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu3" class="nav-header collapsed" data-toggle="collapse">新闻公告信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu3 nav nav-list collapse">
				<li><a href="article/createArticle.action"><span class="fa fa-caret-right"></span>新增新闻公告信息</a></li>
				<li><a href="article/getAllArticle.action"><span class="fa fa-caret-right"></span>新闻公告信息列表</a></li>
				<li><a href="article/queryArticleByCond.action"><span class="fa fa-caret-right"></span>新闻公告信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu4" class="nav-header collapsed" data-toggle="collapse">演唱会类型信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu4 nav nav-list collapse">
				<li><a href="cate/createCate.action"><span class="fa fa-caret-right"></span>新增演唱会类型信息</a></li>
				<li><a href="cate/getAllCate.action"><span class="fa fa-caret-right"></span>演唱会类型信息列表</a></li>
				<li><a href="cate/queryCateByCond.action"><span class="fa fa-caret-right"></span>演唱会类型信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu5" class="nav-header collapsed" data-toggle="collapse">演唱会信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu5 nav nav-list collapse">
				<li><a href="concert/createConcert.action"><span class="fa fa-caret-right"></span>新增演唱会信息</a></li>
				<li><a href="concert/getAllConcert.action"><span class="fa fa-caret-right"></span>演唱会信息列表</a></li>
				<li><a href="concert/queryConcertByCond.action"><span class="fa fa-caret-right"></span>演唱会信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu6" class="nav-header collapsed" data-toggle="collapse">票务信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu6 nav nav-list collapse">
				<li><a href="ticket/createTicket.action"><span class="fa fa-caret-right"></span>新增票务信息</a></li>
				<li><a href="ticket/getAllTicket.action"><span class="fa fa-caret-right"></span>票务信息列表</a></li>
				<li><a href="ticket/queryTicketByCond.action"><span class="fa fa-caret-right"></span>票务信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu8" class="nav-header collapsed" data-toggle="collapse">订单信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu8 nav nav-list collapse">
				<li><a href="orders/getAllOrders.action"><span class="fa fa-caret-right"></span>订单信息列表</a></li>
				<li><a href="orders/queryOrdersByCond.action"><span class="fa fa-caret-right"></span>订单信息查询</a></li>
			</ul></li>

	</ul>
</div>

