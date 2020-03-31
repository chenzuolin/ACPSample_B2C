<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./layui/css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function delurl(sum_id){
	var del = confirm("您确定要删除吗？");
	if(del){
		location.href="${pageContext.request.contextPath}/DelSumServlet?id="+sum_id;
	}
}
</script>
<body>
	<table class="layui-table" style=" width:90%; margin-left:5%; table-layout: fixed;">
		<tr class="one">
			<td>序号</td>
			<td>商品名称</td>
			<td>加入时间</td>
			<td>商品数量</td>
			<td>功能操作</td>
		</tr>
	
	<c:forEach items="${findAll }" var="p" varStatus="vs">
		<tr class="two">
			<td>${vs.count }</td>
			<td>${p.greens_Name }</td>
			<td>${p.sum_date }</td>
			<td>${p.sum_number }</td>
			<td ><a href="javascript:void(0);" onclick="delurl('${p.sum_id }')"><i class="layui-icon">&#xe640;</i></a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>