<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<title>Insert title here</title>
<style>
	.layui-input{
		word-break:keep-all;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	legend{
		font-size:20px;
	}
</style>
</head>
<body>
<form action="PublishMessageInGoEasy" method="post">
<fieldset>
   <legend>推送信息</legend>
<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:335px;margin-top:3px;"><strong>推送消息</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;width:300px;margin-top:3px;">
			<input type="text" lay-verify="required" required name="xiaoxi" id="firstname" class="layui-input" style="text-align:center;" placeholder="请输入推送内容">
		</div>
</div>
<div class="layui-form-item">
      <div class="layui-input-block" style="margin-left:800px;margin-top:-39px;">
        <button class="layui-btn" type="submit" style="width:121px;">发送</button>
      </div>    
 </div>
</fieldset>
</form>
</body>
</html>