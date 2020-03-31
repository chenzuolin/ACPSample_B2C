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
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜编号</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜名称</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜等级</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>功能操作</strong></th>
		</tr>
<%
	GreensDao dao = new GreensDao();
	List<Greens> list = dao.findAll();
	for(Greens greens : list){
		int bb = greens.getGreens_ID();
		String dd = greens.getGreens_Name();
		int ee = greens.getGreens_Grade();
	
%>
	
		<tr>
			<td style="text-align:center;"><%=bb %></td>
			<td style="text-align:center;"><%=dd %></td>
			<td style="text-align:center;"><%=ee %></td>
			<td style="text-align:center;"><a href="text.jsp?bb=<%=bb %>" style="color:skyblue;"><i class="layui-icon">&#xe642;</i>修改</a></td>
		</tr>
		<%		
	}
%>
	</table>


</body>
</html>