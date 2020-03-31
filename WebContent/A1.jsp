<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="./css/layui.css">
 <link rel="stylesheet" href="./layui/css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="layui-table" style=" width:80%; margin-left:10%; table-layout: fixed;">
		<tr>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>酒店名称</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>酒店地址</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>酒店性质</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>功能操作</strong></th>
		</tr>
<%
	WineshopDao dao = new WineshopDao();
	List<Wineshop> list = dao.findAll1();
	for(Wineshop wineshop : list){
		int aa = wineshop.getWineshop_ID();
		String bb = wineshop.getWineshop_Name();
		String cc = wineshop.getWineshop_Shift_Name();
		String dd = wineshop.getWineshop_Address();
		String ee = wineshop.getWineshop_Nature();
	
%>
	
		<tr>
			<td style="text-align:center;"><%=bb %></td>
			<td style="text-align:center;"><%=dd %></td>
			<td style="text-align:center;"><%=ee %></td>
			<td style="text-align:center;"><a href="A2.jsp?aa=<%=aa %>" style="color:skyblue;"><i class="layui-icon">&#xe642;</i>修改</a></td>
		</tr>
		<%		
	}
%>
	</table>


</body>
</html>