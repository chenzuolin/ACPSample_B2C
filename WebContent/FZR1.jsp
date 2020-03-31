<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./layui/css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changePage(){
		var page = document.getElementById("pageSel").value;;
		window.location.href="FZRServlet?currentPage="+page;
	}
</script>
<style>
	.layui-table .one td{
		text-align: center;
		background:rgb(0,150,136);
		color: white;
		width:90%;
	}
	.layui-table .two td{
		text-align: center;
	}
	.layui-table .three td{
		text-align: center;
	}
	.layui-table .two:hover{
		text-align: center;
		background:rgb(0,150,136);
		color: white;
	}
</style>
</head>
<body>
	<table class="layui-table" style=" width:90%; margin-left:5%; table-layout: fixed;">
		<tr class="one">
			<td>订单编号</td>
			<td>订单时间</td>
			<td>订单状态</td>
			<td>订单详情</td>
			<td>订单负责人</td>
		</tr>
	
	<c:forEach items="${page.list }" var="p">
		<tr class="two">
			<td>${p.indent_ID }</td>
			<td>${p.indent_Time }</td>
			<td>${p.indent_Status }</td>
			<td><a href="FZR2.jsp?id=${p.indent_ID }" class="layui-btn"  style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" > <i class="layui-icon">&#xe705;</i>查看订单</a></td>
			<td><a href="FZR3.jsp?id=${p.indent_ID }" id="${indent.indent_ID }" class="layui-btn"  style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" > <i class="layui-icon">&#x1005;</i>负责人</a></td>
		</tr>
	</c:forEach>
	<tr class="three">
		<td colspan="7">
			<c:if test="${page.currentPage!=1 }">
				<a href="FZRServlet?currentPage=${page.currentPage-1 }">上一页</a>
			</c:if>
			<c:forEach varStatus="aaa" begin="1" end="${page.totalPage }"> 
				<c:choose>
					<c:when test="${page.currentPage==aaa.count }">
						<a href="FZRServlet?currentPage=${aaa.count }" style="color:red;">${aaa.count }</a>&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<a href="FZRServlet?currentPage=${aaa.count }">${aaa.count }</a>&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			<c:if test="${page.currentPage!=page.totalPage }">
				<a href="FZRServlet?currentPage=${page.currentPage+1 }">下一页&nbsp;&nbsp;</a>
			</c:if>
			共<span style="color:red;">${page.totalPage }</span>页&nbsp;&nbsp;&nbsp;&nbsp;到
			<select id="pageSel" onchange="changePage();">
				<c:forEach begin="1" end="${page.totalPage }" varStatus="aaa">
					<option value="${aaa.count }">${aaa.count }</option>
				</c:forEach>
			</select>
			页
		</td>
	</tr>
	</table>
</body>
</html>