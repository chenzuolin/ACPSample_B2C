<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
        <%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.CGDao"%>
<%@page import="com.sec.dao.XianZhiDao"%>
<%@page import="java.io.*" %>
<%@page import="com.sumeng.web.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./layui/css/layui.css">
<link href="./css/layui.css" rel="stylesheet" media="screen">
<style>
	th{color:black;}
	td{color:black;text-align:center}
</style>

</head>
<body>
<div class="layui-card">
  <div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;">已完成订单
  
</div>

<table  class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;">
	<tr>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单编号</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>下单时间</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>下单酒店</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>操作</strong></th>
	</tr>
		<%
		int sa = (Integer)request.getSession().getAttribute("GHS");
		CGDao daa = new CGDao();
		String db = daa.findUserByIDs(sa);
		IndentDao dao = new IndentDao();
		XianZhiDao da = new XianZhiDao();
		List<XianZhi> lis = da.findAll();
		String as = null;
		String bs = null;
		for(XianZhi x : lis){
			as = x.getTime_Star();
			bs = x.getTime_End(); 
		}
		
		List<Indent> list = dao.o2(as,bs,db,"速盟快线");
		for(Indent i : list){
			int aa = i.getIndent_ID();
			String bb = i.getIndent_Time();
			String cc = i.getCourier_Name();
		
		%>

<tr>
		<td style="text-align:center;"><%=aa %></td>
		<td style="text-align:center;"><%=bb %></td>
		<td style="text-align:center;"><%=cc %></td>
		<td style="text-align:center;">
		<a href="OLO2Servlet?id=<%=aa %>"  class="layui-btn"style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" > <i class="layui-icon">&#xe705;</i>查看订单</a>
		<a href="OLO3Servlet?id=<%=aa %>"  class="layui-btn"style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" > <i class="layui-icon">&#xe705;</i>配送完成</a>
		</td>
	</tr>
	<%
		}
	%>
</table>
</div>
</body>
</html>