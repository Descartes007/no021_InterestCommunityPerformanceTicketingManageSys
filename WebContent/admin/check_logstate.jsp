<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String adminid = (String) session.getAttribute("adminid");
	if (adminid == null) {
		response.getWriter().println("<script>top.location.href='" + basePath + "admin/index.jsp';</script>");
	}
%>