<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./layui/css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="layui-v2.3.0/layui/layui.js" charset="UTF-8"></script>
<title>新品需求</title>
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
<script type="text/javascript">
		
		function changePage(){
			var page = document.getElementById("pageSel").value;;
			window.location.href="NewPageServlet?currentPage="+page;
		}
		function delurl(new_id){
			var del = confirm("您确定要删除吗？");
			if(del){
				location.href="${pageContext.request.contextPath}/DeleteServlet?id="+new_id;
			}
		}
		function check(){
				location.href="${pageContext.request.contextPath}/NewCheckServlet";
		}
</script>
</head>
<body>
	<form id="Form1" class="layui-form layui-form-pane" name="Form1" action="${pageContext.request.contextPath}/SumServlet"
		method="post">
		 <div class="layui-form-item" style="margin:20px auto;width:90%;margin-left:5%;">
    		<div class="layui-inline">
     			 <label class="layui-form-label" style="background:#ccc;text-align:center;">蔬菜名称</label>
      				<div class="layui-input-inline">
       					 <input type="text" name="gname" id="gname" placeholder="请输入蔬菜名称" autocomplete="off" class="layui-input">
      				</div>
    		</div>
    		<div class="layui-inline">
    			<input class="layui-btn" style="width:121px;" type="submit" value="提交">
  			</div>
  			<div class="layui-inline">
    			<input class="layui-btn" style="width:121px;" onclick="check()" type="button" value="查看">
  			</div>
    	</div>
	<table class="layui-table" style=" width:90%; margin-left:5%; table-layout: fixed;">
		<tr class="one">
			<td>序号</td>
			<td>酒店名称</td>
			<td>蔬菜名称</td>
			<td>蔬菜描述</td>
			<td>时间</td>
			<td>操作内容</td>
		</tr>
	
	<c:forEach items="${page.list }" var="p" varStatus="vs">
		<tr class="two">
			<td>${vs.count }</td>
			<td>${p.wineshop_UserName }</td>
			<td>${p.greens_Name }</td>
			<td>${p.greens_miaoshu }</td>
			<td>${p.new_date }</td>
			<td ><a href="javascript:void(0);" onclick="delurl('${p.new_id }')"><i class="layui-icon">&#xe640;</i></a></td>
		</tr>
	</c:forEach>
	<tr class="three">
		<td colspan="6">
			<c:if test="${page.currentPage!=1 }">
				<a href="NewPageServlet?currentPage=${page.currentPage-1 }">上一页</a>
			</c:if>
			<c:forEach varStatus="aaa" begin="1" end="${page.totalPage }"> 
				<c:choose>
					<c:when test="${page.currentPage==aaa.count }">
						<a href="NewPageServlet?currentPage=${aaa.count }" style="color:red;">${aaa.count }</a>&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<a href="NewPageServlet?currentPage=${aaa.count }">${aaa.count }</a>&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			<c:if test="${page.currentPage!=page.totalPage }">
				<a href="NewPageServlet?currentPage=${page.currentPage+1 }">下一页&nbsp;&nbsp;</a>
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
</form>
</body>
</html>