<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录日志</title>
</head>
<body onLoad="goPage(1,10)">
	<table  class="layui-table" style=" width:90%; margin-left:5%; table-layout: fixed;">
		<tr>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" >
				<strong>日志编号</strong>
			</th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" >
				<strong>登录时间</strong>
			</th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" >
				<strong>登录名称</strong>
			</th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" >
				<strong>设备型号</strong>
			</th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" >
				<strong>设备名称</strong>
			</th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" >
				<strong>操作类型</strong>
			</th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" >
				<strong>操作内容</strong>
			</th>
		</tr>
			<% 
			LogDao dao = new LogDao();
			List<Log> list = dao.findAll();
			for(Log log : list){
				String Log_Id = log.getLog_Id();
				String Log_Time = log.getLog_Time();
				String Log_Name = log.getLog_Name();
				String Log_Ip = log.getLog_Ip();
				String Log_Ip_Name = log.getLog_Ip_Name();
				String Log_Type = log.getLog_Type();
				String Log_Content = log.getLog_Content();
			
			%>
			 <tr>
		 		<td style="text-align:center;"><%=Log_Id %></td>
		 		<td style="text-align:center;"><%=Log_Time %></td>
		 		<td style="text-align:center;"><%=Log_Name %></td>
		 		<td style="text-align:center;"><%=Log_Ip %></td>
		 		<td style="text-align:center;"><%=Log_Ip_Name %></td>
		 		<td style="text-align:center;"><%=Log_Type %></td>
		 		<td style="text-align:center;"><%=Log_Content %></td>
		 	</tr>
			 <%
				}
			 %>
		</table>
</body>
</html>