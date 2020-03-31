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
<link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
   <script src="./laydate/laydate.js"></script> <!-- 改成你的路径 -->
<link rel="stylesheet" href="./layui/css/layui.css">
<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<style type="text/css">
th{text-align: center;float: inherit; color: black; height: 40px;}
table{}
td{}
</style
>
</head>
<body>
<table class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;">
	<tr >
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单编号</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单时间</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单状态</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单详情</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>功能操作</strong></th>
	</tr>
		<c:forEach items="${page.showuser }" var="indent">

<tr>
		<td style="text-align:center;">${indent.indent_ID }</td>
		<td style="text-align:center;">${indent.indent_Time }</td>
		<td style="text-align:center;">${indent.indent_Status }</td>
		<td style="text-align:center;"><a href="Indent2.jsp?id=${indent.indent_ID }" class="layui-btn"  style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" > <i class="layui-icon">&#xe705;</i>查看订单</a></td>
		<td style="text-align:center;"><a href="WineshopIndexServlet?id=${indent.indent_ID }" id="${indent.indent_ID }" class="layui-btn"  style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" > <i class="layui-icon">&#x1005;</i>确认收货</a>
		</td>
		</tr>
		<script type="text/javascript">
// 两秒后模拟点击
setTimeout(function() {
	// IE
	if(document.all) {
		document.getElementById("${indent.indent_ID }").click();
	}
	// 其它浏览器
	else {
		var e = document.createEvent("MouseEvents");
		e.initEvent("click", true, true);
		document.getElementById("${indent.indent_ID }").dispatchEvent(e);
	}
}, 86400000);
</script>
		</c:forEach>
</table>

<script src="./js/layui.js"></script> <!-- 改成你的路径 -->
<div style="margin-left:135px;margin-top:20px;">
	<c:choose>
		<c:when test="${page.currentPage==1}">
		上一页
		</c:when>
		<c:otherwise>
			<a href="UserController1?currentPage=${page.prevPage}" id="prevPage">上一页</a>
		</c:otherwise>
		</c:choose>
        <c:forEach items="${page.showPageNums}" var="pageNum">
            <a href="UserController1?currentPage=${pageNum}" id="pageNum">${pageNum}</a>
        </c:forEach>
        <a href="UserController1?currentPage=${page.nextPage}" id="nextPage">下一页</a>
	</div>
<script>
//执行一个laydate实例
laydate.render({
  elem: '#date1' //指定元素
});
laydate.render({
  elem: '#date2' //指定元素
});
</script>
</body>
</html>