<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <link rel="stylesheet" href="./css/layui.css">
 <link rel="stylesheet" href="./layui/css/layui.css">
<style>
	td{
		word-break:keep-all;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
</style>
</head>
<body>
<table class="layui-table" style=" width:80%; margin-left:10%; table-layout: fixed;">
		<tr>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>投诉名称</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>投诉内容</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>投诉时间</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>功能操作</strong></th>
		</tr>
<%
	ComplainantDao dao = new ComplainantDao();
	List<Complainant> list = dao.findAll();
	for(Complainant complainant :list){
		if(complainant.getComplainant_Type().contains("商品")){
			WineshopDao dao1 = new WineshopDao();
			String name = dao1.findUserByID1(complainant.getWineshop_ID());
			int id = complainant.getWineshop_ID();
			int zz = complainant.getComplainant_ID();
			String con = complainant.getComplainant_Content();
			String time = complainant.getComplainant_Time();
%>
	
		<tr>
			<td style="text-align:center;"><%=name %></td>
			<td style="text-align:center;"><%=con %></td>
			<td style="text-align:center;"><%=time %></td>
			<td style="text-align:center;">
				<a href="fk.jsp?id=<%=id %>" title="回复"style="color:skyblue;" ><i class="layui-icon">&#xe611;</i>回复</a>
				
				<a href="csfkServlet?id=<%=zz %>" title="删除" style="margin-left:10px;color:red;"><i class="layui-icon">&#xe640;</i>删除</a>
			</td>
		</tr>
		
	


<%
		}
	}
%>

</table>

</body>
</html>