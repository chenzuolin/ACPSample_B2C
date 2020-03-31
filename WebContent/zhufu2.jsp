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
<link rel="stylesheet" href="./layui/css/layui.css">
<link href="./css/layui.css" rel="stylesheet" media="screen">
</head>
<body>
<table class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;">
	<tr>
		<th class="layui-table" style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>之前欠账</strong></th>
		<th class="layui-table" style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>本次金额</strong></th>
		<th class="layui-table" style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>金额总计</strong></th>
		<th class="layui-table" style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>功能操作</strong></th>
	</tr>

<%
	PriceDao dao = new PriceDao();
	WineshopDao dao1 = new WineshopDao();
	int aa = (Integer)request.getSession().getAttribute("id");//酒店ID
	float oo = (float)request.getSession().getAttribute("alltotal");//该订单金额
	List<Wineshop> list1 = dao1.findUserByID(aa);
	for(Wineshop wineshop : list1){
		String zz = wineshop.getWineshop_Name();//酒店名称
	List<Price> list = dao.findUserByID2(aa);
		System.out.print(list);
	float nn = 0;
		if(list.size()!=0){
	for(Price price : list){
		int xx = price.getPrice_ID();//
		Float bb = price.getPrice_num();
		float num = (float)(Math.round(bb*100))/100;
		 nn = oo+bb;
		 float num2 = (float)(Math.round(nn*100))/100;
%>
	<tr>
		<td style="text-align:center;"><%=num %></td>
		<td style="text-align:center;"><%=oo %></td>
		<td style="text-align:center;"><%=num2 %></td>
		<td style="text-align:center;">
			<a href="zhifuServlet?xx=<%=xx %>&nn=<%=nn %>" style="color:skyblue;"><i class="layui-icon">&#x1005;</i>确认购买</a>
		</td>
	</tr>

<%
	}
		}else{
		nn = oo;
%>
	<tr>
		<td style="text-align:center;">0</td>
		<td style="text-align:center;"><%=oo %></td>
		<td style="text-align:center;"><%=nn %></td>
		<td style="text-align:center;">
			<a href="zhifuServlet1?nn=<%=nn %>" style="color:skyblue;"><i class="layui-icon">&#x1005;</i>确认购买</a>
		</td>
	</tr>
	<%
		}
	}
	%>
</table>
</body>
</html>