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
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			用户中心
		</div>
	</div>
	<div class="blank"></div>

	<div class="blank"></div>
	<div class="block clearfix">

		<div class="AreaL">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox">
						<jsp:include page="usermenu.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>


		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">
						<h5>
							<span>个人资料</span>
						</h5>
						<div class="blank"></div>
						<form name="formEdit" action="index/personal.action" method="post" onsubmit="return userEdit()">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">用户名：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">${sessionScope.users.username }<input type="hidden"
										name="username" id="username" value="${sessionScope.users.username }" /> <input type="hidden" name="password"
										id="password" value="${sessionScope.users.password }" /> <input type="hidden" name="usersid" id="usersid"
										value="${sessionScope.users.usersid }" /><input type="hidden" name="regdate" id="usersid"
										value="${sessionScope.users.regdate }" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">姓名：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><input name="realname" type="text" size="25"
										class="inputBg" id="realname" value="${sessionScope.users.realname }" /></td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">性别：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><select name="sex" id="sex">
											<option value="男">男</option>
											<option value="女">女</option>
									</select></td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">出生日期：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><input name="birthday" type="text" size="25"
										class="inputBg" id="birthday" readonly="readonly" onclick="WdatePicker()"
										value="${sessionScope.users.birthday }" /></td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">联系方式：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><input name="contact" type="text" size="25" class="inputBg"
										id="contact" value="${sessionScope.users.contact }" /></td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">联系地址：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><input name="address" type="text" size="25" class="inputBg"
										id="address" value="${sessionScope.users.address }" /></td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="submit" class="bnt_blue_1"
										style="border: none;" value="确认修改" /></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="blank"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
