<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.io.*,java.util.*,java.sql.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>function</title>
</head>
<body>
<%
response.setContentType("text/html;charset=utf-8");
response.setCharacterEncoding("utf-8");

String reply=request.getParameter("reply");
String title=request.getParameter("p2");
String articleid=request.getParameter("p1");
String usersid=request.getParameter("p3");
String username=request.getParameter("p4");
String replyid="R" +1;


%>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/no021_ychwsdpxt?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
	user="root" password="1025"/>
	<sql:update dataSource="${snapshot}" var="result">
	update reply set replyid="<%= replyid %>" reply="<%=reply%>",title="<%=title%>",articleid=<%=articleid%>,usersid=<%=usersid%>,username=<%=username%>
	</sql:update>


</body>
</html>
