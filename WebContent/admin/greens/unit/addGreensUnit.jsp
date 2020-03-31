<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单位添加</title>
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<div class="layui-form" lay-filter="layuiadmin-form-tags" id="layuiadmin-app-form-tags" style="padding-top: 30px; text-align: center;">
    <div class="layui-form-item">
      <label class="layui-form-label">单位名称</label>
      <div class="layui-input-inline">
        <input type="text" name="greensUnit" id="greensUnit" lay-verify="required" placeholder="请输入单位名称" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
<script>
var callbackdata = function (){
	var greensUnit = document.getElementById("greensUnit").value;
	var data = {
			greendData: greensUnit
	}
	return data;
}
</script>
</body>
</html>