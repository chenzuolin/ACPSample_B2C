<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.sec.dao.*" %>
    <%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<style>
	legend{
		font-size:17px;
	]}
	.nva{
		margin:20px auto;
	}
	.layui-input{
		width:340px;
	}
	.layui-btn{
		width:121px;
		margin-left:10px;
	}
</style>
<style>
	.layui-inline{
		margin-right:10px;
	}
	.layui-input{
		margin-left:-5px;
		text-align:center;
		background:orange;
		margin-top:-1px;
	}
</style>
</head>
<body>
<form action="Q3Servlet" class="layui-form layui-form-pane" method="get">
<div class="nva">
	 	<fieldset>
 			<legend>请输入查询蔬菜的名称</legend>
				<div class="layui-input-inline" style="margin-left:348px;">
					<input type="text" required name="a" lay-verify="required" placeholder="请输入蔬菜名称" class="layui-input">
				</div>
				<div class="layui-input-inline">
					<button type="submit" class="layui-btn" ><i class="layui-icon">&#xe615;</i>月销量查询</button>
				</div>
		</fieldset>
	 </div>
	 <table class="layui-table" style=" width:80%; margin-left:10%; table-layout: fixed;">
<tr>
	<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜名称</strong></th>
	<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜数量</strong></th>
	<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜单位</strong></th>
</tr>
				<%
				OrderDao dao = new OrderDao();
				List<Order> list = dao.find3();
				for(Order order : list){
					String greens_Name = order.getGreens_Name();
					int k = order.getNumber();
					String greens_Unit = order.getGreens_Unit();
				
%>
<tr>
				<td style="text-align:center;"><%=greens_Name %></td>
				<td style="text-align:center;"><%=k %></td>
				<td style="text-align:center;"><%=greens_Unit %></td>				
</tr>
<%
		}
	
%>
</table>
</form>
</body>
</html>