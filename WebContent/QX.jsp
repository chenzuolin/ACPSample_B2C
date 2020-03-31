<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./layui/css/layui.css">
<link href="./css/layui.css" rel="stylesheet" media="screen">
<title>Insert title here</title>
</head>
<body>
<table  class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;">
	<tr>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>管理员名称</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>分配权限</strong></th>
	</tr>
<%
	UserDao dao1 = new UserDao();
	List<User> list = dao1.findAll();
	for(User user : list){
		String aa = user.getUser_Name();
		int bb = user.getUser_ID();
%>

	<tr>
		<td style="text-align:center;"><%=aa %></td>
		<td style="text-align:center;">
			<a href="QX1.jsp?aa=<%=bb %>&zz=<%=aa %>"><i class="layui-icon">&#xe61f;</i>分配权限</a>
		</td>
	</tr>
<%
	}
%>
</table>
</body>
</html>