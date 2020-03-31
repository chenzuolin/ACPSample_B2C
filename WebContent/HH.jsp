<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<style>
	.nva{
		margin:15px 0;
	}
	.layui-input{
		margin-top:-4px;
		width:225px;
		margin-left:-5px;
	}
	legend{
		font-size:20px;
	}
</style>
</head>
<body>
<form action="HHServlet" method="get">
	<fieldset>
  <legend>添加管理员</legend>
  <div class="nva">
<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px; margin-top:-4px;">登录名</label>
		<div class="layui-input-inline">
			<input type="text" requrred name="a" lay-verify="requried" placeholder="请输入登录名" style="width:300px;" class="layui-input">
		</div>
	</div>
	<div class="layui-input-inline" style="margin-left:65px;">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:-18px; margin-top:-4px;">密码</label>
	<div class="layui-input-inline">
		<input type="text" required name="b" lay-verify="required" placeholder="请输入密码" style="width:300px;" class="layui-input">
		</div>
	</div>
	<div class="layui-input-inline">
		<button type="submit" class="layui-btn" style="margin-top:-4px; margin-left:51px; width:121px;"><i class="layui-icon">&#xe654;</i>添加</button>
	</div>
	</div>
</fieldset>
 <script src="./layui/layui.js" charset="UTF-8"></script>
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
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
</script>
</form>
</body>
</html>