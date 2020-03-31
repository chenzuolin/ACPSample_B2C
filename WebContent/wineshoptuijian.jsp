<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./layui/css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>酒店推荐人</title>
<script type="text/javascript">
	function changePage(){
		var page = document.getElementById("pageSel").value;;
		window.location.href="WineshopTuijianServlet?currentPage="+page;
	}
</script>
<style>
	.layui-table .one td{
		text-align: center;
		background:rgb(0,150,136);
		color: white;
	}
	.layui-table .two td{
		text-align: center;
	}
	.layui-table .three td{
		text-align: center;
	}
</style>
</head>
<body>
	<table class="layui-table" style=" width:90%; margin-left:5%; table-layout: fixed;">
		<tr class="one">
			<td>序号</td>
			<td>登录名称</td>
			<td>酒店名称</td>
			<td>联系电话</td>
			<td>酒店地址</td>
			<td>邀请人</td>
		</tr>
	
	<c:forEach items="${page.list }" var="p" varStatus="vs">
		<tr class="two">
			<td>${vs.count }</td>
			<td>${p.wineshop_UserName }</td>
			<td>${p.wineshop_Name }</td>
			<td>${p.wineshop_Telephone }</td>
			<td>${p.wineshop_Address }</td>
			<td>${p.wineshop_TuiJian }</td>
		</tr>
	</c:forEach>
	<tr class="three">
		<td colspan="6">
			<c:if test="${page.currentPage!=1 }">
				<a href="WineshopTuijianServlet?currentPage=${page.currentPage-1 }">上一页</a>
			</c:if>
			<c:forEach varStatus="aaa" begin="1" end="${page.totalPage }"> 
				<c:choose>
					<c:when test="${page.currentPage==aaa.count }">
						<a href="WineshopTuijianServlet?currentPage=${aaa.count }" style="color:red;">${aaa.count }</a>&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<a href="WineshopTuijianServlet?currentPage=${aaa.count }">${aaa.count }</a>&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			<c:if test="${page.currentPage!=page.totalPage }">
				<a href="WineshopTuijianServlet?currentPage=${page.currentPage+1 }">下一页&nbsp;&nbsp;</a>
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