<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>酒店信息</title>
<link href="css/layui.css" rel="stylesheet" media="all">
<link href="layui-v2.3.0/layui/css/layui.css" rel="stylesheet" >
<script src="layui/layui.js" charset="UTF-8"></script>
<style>
td{text-align:center;}
</style>
</head>
<body>
<table class="layui-table" style=" width:90%; margin-left:5%; table-layout: fixed;">
		<tr class="one">
			<td>序号</td>
			<td>ID</td>
			<td>登录名称</td>
			<td>登录密码</td>
			<td>酒店名称</td>
			<td>联系电话</td>
			<td>操作</td>
		</tr>
	
	<c:forEach items="${f }" var="aa" varStatus="vs">
		<tr class="two">
			<td>${vs.count }</td>
			<td>${aa.wineshop_ID }</td>
			<td>${aa.wineshop_UserName }</td>
			<td>${aa.wineshop_Password }</td>
			<td>${aa.wineshop_Name }</td>
			<td>${aa.wineshop_Telephone }</td>
			<td><a href="SelectWineshopById?id=${aa.wineshop_ID }" class="layui-btn"> <i class="layui-icon">&#x1005;</i>编辑</a></td>
		</tr>
	</c:forEach>
</table>
<script src="layui-v2.3.0/layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
</body>
</html>