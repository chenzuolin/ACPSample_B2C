<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="com.sec.entity.*"%>
<%@ page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<link rel="stylesheet" href="http://at.alicdn.com/t/font_926734_l9addzq8hgo.css"> 
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
</head>
<body>
<form action="V3Servlet" class="layui-form layui-form-pane" method="get">
<div class="nva">
	 	<fieldset>
 			<legend>请输入查询蔬菜的名称</legend>
				<div class="layui-input-inline" style="margin-left:348px;">
					<input type="text" required name="a" lay-verify="required" placeholder="请输入蔬菜名称" class="layui-input">
				</div>
				<div class="layui-input-inline">
					<button type="submit" class="layui-btn" ><i class="layui-icon">&#xe615;</i>查询</button>
				</div>
		</fieldset>
</div>
</form>
<table  class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;">
	<tr>
		<th style="text-align:center;  background:rgb(238,238,238);  color:#000;" >蔬菜名称</th>
		<th style="text-align:center;  background:rgb(238,238,238);  color:#000;" >速盟单价</th>
		<th style="text-align:center;  background:rgb(238,238,238);  color:#000;" >市场单价</th>
	</tr>
<%
		GreensDao dao1 = new GreensDao();
		List<Greens> list1 = dao1.findAll();
		for(Greens dd : list1){
			String name = dd.getGreens_Name();
			float Price = dd.getGreens_Price();
			float m_price = dd.getGreens_Market_Price();
			String unit = dd.getGreens_Unit();
		
%>
	
		<tr>
			<td style="text-align:center;"><%=name %></td>
			<td style="text-align:center;"><%=Price %>元/<%=unit %> <i class="iconfont icon-xiangxiajiantou" style="color:green;"></i></td>
			<td style="text-align:center;"><%=m_price %>元/<%=unit %><i class="iconfont icon-xiangshangjiantou" style="color:red;"></td>
			</td>
		</tr>
	
	<%
		}
	%>
	</table>
</body>
</html>