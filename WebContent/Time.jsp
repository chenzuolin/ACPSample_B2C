<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/layui.css" rel="stylesheet" media="all">
<style>
.nva{
	margin:20px auto;
}
legend{
	font-size:20px;
}
fieldset{
	padding:15px 0;
}
</style>
</head>
<body>
<form action="TimeServlet" method="get">
<div class="nva">
<fieldset>
   <legend>设置蔬菜发布时间</legend>
		<div class="layui-inline">
				<label class="layui-btn" style="background:rgb(126,126,126); width:160px; margin-left:84px;">设置蔬菜发布时间</label>
				<div class="layui-input-inline">
					<input type="text" lay-verify="required" required name="time1" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="firstname" class="layui-input" placeholder="请输入起始时间(单位小时)">
				</div>
				<div class="layui-input-inline">
					<input type="text" lay-verify="required" required name="time2" id="firstname" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="layui-input" placeholder="请输入结束时间(单位小时)">
				</div>
		</div>
		<div class="layui-inline" style="margin-left:30px;">
				<div class="layui-input-inline">
					<button class="layui-btn" id="button" type="submit" style="width:121px;">确定</button>
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<button class="layui-btn" type="reset" style="width:121px;margin-left:10px;">重置</button>
				</div>
			</div>
		</div>
</fieldset>
</div>

</form>
</body>
</html>