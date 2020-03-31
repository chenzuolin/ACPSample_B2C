<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蔬菜月报表</title>
<link rel="stylesheet" href="./layui/css/layui.css">
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
<table class="layui-table" style=" width:80%; margin-left:10%; table-layout: fixed;">
<tr>
	<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜名称</strong></th>
	<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜单价</strong></th>
	<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜数量</strong></th>
</tr>
<%
	float zz = 0;
int id=(Integer)request.getSession().getAttribute("id");

	IndentDao dao = new IndentDao();
	List<Indent> list = dao.findUserByIDmonth1(id);
	for(Indent indent : list){
		int aa = indent.getIndent_ID();
		TotalDao dao1 = new TotalDao();
		List<Total> list1 = dao1.findUserByID1(aa);
		for(Total total : list1){
			float bb = total.getTotal();
			zz += bb;
		}
		OrderDao dao2 = new OrderDao();
		List<Order> list2 = dao2.findUserByID1(aa);
		for(Order order : list2){
			int dd = order.getNumber();
			int cc = order.getGreens_ID();
			GreensDao dao3 = new GreensDao();
			List<Greens> list3 = dao3.findUserByID(cc);
			for(Greens greens : list3){
				String ee = greens.getGreens_Name();
				float hh = greens.getGreens_Price();
				String pp = greens.getGreens_Unit();
				%>
				<tr>
				<td style="text-align:center;"><%=ee %></td>
				<td style="text-align:center;"><%=hh %>元</td>
				<td style="text-align:center;"><%=dd %><%=pp %></td>
				</tr>
				<%
			}
		}
	}
%>
</table>
<div class="layui-inline">
		<div class="layui-input-inline">
			<button class="layui-btn" type="submit" style=" width:121px; background:#00adff; margin-left:136px;" onclick='javascript:window.print()'><i class="layui-icon"></i>打印</button>
		</div>
</div>
<div class="layui-inline" style="margin-top: 5px; padding-left: 6px;">
		<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:655px; width:121px;">金额总计</label>
			<div class="layui-input-inline">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="￥<%=zz %>">  		
		  	</div>
</div>
</body>
</html>