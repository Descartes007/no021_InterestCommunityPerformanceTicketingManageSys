<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<div class="all-help bgc-f2">
	<div class="container clearfix" style="overflow: hidden;"></div>
</div>
<div class="all-footer">
	<div class="container clearfix">
		<p class="footer-links"></p>
		<p class="p-icp">ICP备案证书号：wll</p>
		<p class="p-copyright">&copy; 2022 ${title } 版权所有，并保留所有权利。</p>
		<p class="p-icp">
			<a href="admin/index.jsp" target="_blank">管理员入口</a>
		</p>
	</div>
</div>
