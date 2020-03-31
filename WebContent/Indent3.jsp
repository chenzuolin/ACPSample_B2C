<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
        <%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="java.io.*" %>
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
  <div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;">正在处理订单
  
</div>
<table  class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;">
	<tr>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单编号</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单时间</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单状态</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单详情</strong></th>
	</tr>
		
<c:forEach items="${page.showuser }" var="indent">

<tr>
		<td style="text-align:center;">${indent.indent_ID }</td>
		<td style="text-align:center;">${indent.indent_Time }</td>
		<td style="text-align:center;">${indent.indent_Status }</td>
		<td style="text-align:center;"><a href="Indent2.jsp?id=${indent.indent_ID }"  class="layui-btn"style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" > <i class="layui-icon">&#xe705;</i>查看订单</a></td>
	</tr>
	</c:forEach>
</table>
<div style="margin-left:135px;margin-top:20px;">
	<c:choose>
		<c:when test="${page.currentPage==1}">
		上一页
		</c:when>
		<c:otherwise>
			<a href="UserController2?currentPage=${page.prevPage}" id="prevPage">上一页</a>
		</c:otherwise>
		</c:choose>
        <c:forEach items="${page.showPageNums}" var="pageNum">
            <a href="UserController2?currentPage=${pageNum}" id="pageNum">${pageNum}</a>
        </c:forEach>
        <a href="UserController2?currentPage=${page.nextPage}" id="nextPage">下一页</a>
	</div>
</body>
</html>