<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
<title>Insert title here</title>
</head>
<body>
 <div class="layui-form-item" style="padding:25px;">
      <label class="layui-form-label">大类名称</label>
      <div class="layui-input-inline">
        <input type="text" name="greensType" id="bigTypeName" lay-verify="required" placeholder="请输入小类名称" autocomplete="off" class="layui-input">
      </div>
</div>
<table class="layui-hide" id="test" lay-filter="test"></table> 
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script>
var callbackdata = function (){
	var bigTypeName = document.getElementById("bigTypeName").value;
	var data = {
			bigtypename: bigTypeName
	}
	return data;
}
layui.use(['table','layer','jquery','laydate'], function(){
	  var table = layui.table;
	  var $ = layui.jquery;
	  var laydate = layui.laydate;
	  table.render({
	    elem: '#test'
	    ,url:'${pageContext.request.contextPath}/BigTypeNameAll'
	    ,toolbar: '#toolbarDemo'
	    ,title: '大类信息'
	    ,id: 'green'
	    ,totalRow: true 
	    ,cols: [[
	      {type: 'checkbox', fixed: 'left'}
	      ,{field:'bigId', title:'ID', fixed: 'left', unresize: true, sort: true}
	      ,{field:'bigTypeName', title:'下单时间', width:200}
	    ]]
	  });
	});
</script>
</body>
</html>