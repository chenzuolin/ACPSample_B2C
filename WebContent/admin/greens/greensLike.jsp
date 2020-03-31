<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蔬菜信息</title>
 <meta name="renderer" content="webkit">
  <link rel="shortcut icon" href="index.ico" type="image/x-icon" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="${pageContext.request.contextPath}/css/layui.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/layui-v2.3.0/layui/css/layui.css" rel="stylesheet" >
<style>
td{text-align:center;}
</style>
</head>
<body>
<table class="layui-table" style=" width:90%; margin-left:5%; table-layout: fixed;">
		<tr class="one">
			<td>序号</td>
			<td>ID</td>
			<td>蔬菜名称</td>
			<td>类型名称</td>
			<td>蔬菜单位</td>
			<td>蔬菜库存</td>
			<td>操作</td>
		</tr>
	
	<c:forEach items="${gg }" var="aa" varStatus="vs">
		<tr class="two">
			<td>${vs.count }</td>
			<td>${aa.greens_ID }</td>
			<td>${aa.greens_Name }</td>
			<td>${aa.greens_Type_Name }</td>
			<td>${aa.greens_Unit }</td>
			<td>${aa.greens_Number }</td>
			<td><a href="EditByIdGreens?id=${aa.greens_ID }" class="layui-btn"> <i class="layui-icon">&#x1005;</i>编辑</a></td>
		</tr>
	</c:forEach>
</table>
<script src="../../layui-v2.3.0/layui/layui.js" charset="UTF-8"></script>
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