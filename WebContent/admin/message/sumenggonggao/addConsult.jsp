<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告添加</title>
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
<style>
	#layuiadmin-app-form-tags{padding:30px;}
</style>
</head>
<body>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<div class="layui-form" lay-filter="layuiadmin-form-tags" id="layuiadmin-app-form-tags" style="padding-top: 30px; text-align: center;">
     <div class="layui-form-item layui-form-text">
    	<label class="layui-form-label">公告内容</label>
    		<div class="layui-input-block">
      			<textarea placeholder="请输入公告内容" name="consult" id="consult" class="layui-textarea"></textarea>
    		</div>
  	</div>
  </div>
<script>
var callbackdata = function (){
	var consult = document.getElementById("consult").value;
	var data = {
			greendData: consult
	}
	return data;
}
</script>
</body>
</html>