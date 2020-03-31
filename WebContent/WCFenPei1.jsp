<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.sec.dao.CourierDao" %>
<%@ page import="com.sec.dao.WineshopDao" %>
<%@ page import="com.sec.entity.Courier" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sec.entity.Wineshop" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="layui-v2.3.0/layui/css/layui.css"/>
<style>
	.layui-inline{
		margin-top:30px;
	}
	legend{
		font-size:20px;
	}
	fieldset{
		margin-top:50px;
	}
</style>
</head>
<body>
	<form name="form1" method="post" action="WCFenPeiServlet" class="layui-form">
	
<fieldset>
   <legend>酒店收货员分配</legend>
   <div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">酒店编号</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required"  style="text-align:center;" required name="wineshop_ID" id="firstname" class="layui-input" value="">
		</div>
	</div>
   
   
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">酒店名称</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required"  style="text-align:center;" required name="wineshop_Name" id="firstname" class="layui-input" value="">
		</div>
	</div>
	
	
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">酒店收货员登录名</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required"  style="text-align:center;" required name="fenpei_UserName" id="firstname" class="layui-input" value="">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">登录密码</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required"  style="text-align:center;" required name="fenpei_Password" id="firstname" class="layui-input" value="">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:131px;">收货员电话</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required"  style="text-align:center;" required name="fenpei_Telephone" id="firstname" class="layui-input" value="">
		</div>
	</div>
	
	
 <div class="layui-form-item">
      <div class="layui-input-block" style="margin-left:540px;margin-top:30px;">
        <button class="layui-btn" type="submit" style="width:121px;">确认提交</button>
        <button class="layui-btn" type="reset" style="width:121px;">重新填写</button> 
      </div>    
 </div>
 </fieldset>	   
		

		</table>
	</form>
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