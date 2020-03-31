<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*"%>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看推送消息</title>
<link rel="stylesheet" href="./css/layui.css">
 <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<table class="layui-table" style=" width:80%; margin-left:10%; table-layout: fixed;">
		<tr>
			<th style="text-align:center;background:rgb(238,238,238);  color:#000;">推送内容</th>
			<th style="text-align:center;background:rgb(238,238,238);  color:#000;">推送时间</th>
		</tr>
<%
		GTDao dao = new GTDao();
		List<GT> list = dao.findAll();
		for(GT gt : list){
			String aa = gt.getTime();
			String bb = gt.getGT_Name();
			int cc = gt.getAdmin();
			UserDao dao1 = new UserDao();
			List<User> list1 = dao1.findUserByID33(cc);
			for(User user : list1){
				String dd = user.getUser_Name();
	
%>
	
		<tr>
			<td style="text-align:center;"><%=bb %></td>
			<td style="text-align:center;"><%=aa %></td>
		</tr>
<%
		}
	}
%>
</table>
</body>
</html>