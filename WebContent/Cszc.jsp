<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>菜商注册页面</title>
<link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css"  media="all">
<script language="javaScript">
function check(){
	var Greens_Jobber_UserName = document.form1.Greens_Jobber_UserName.value;
	var Greens_Jobber_Password = document.form1.Greens_Jobber_Password.value;
	var userconfirmpassword = document.form1.userconfirmpassword.value;
	var Greens_Jobber_Telephone = document.form1.Greens_Jobber_Telephone.value;
	var Greens_Jobber_Address = document.form1.Greens_Jobber_Address.value;
	var Greens_Jobber_QQ = document.form1.Greens_Jobber_QQ.value;
	var Greens_Jobber_WeChat = document.form1.Greens_Jobber_WeChat.value;
	var Greens_Jobber_Name = document.form1.Greens_Jobber_Name.value;
	var Greens_Jobber_Shift_Name = document.form1.Greens_Jobber_Shift_Name.value;
	var Greens_Jobber_Aptitude = document.form1.Greens_Jobber_Aptitude.value;
	if(Greens_Jobber_UserName==""||Greens_Jobber_Password==""||userconfirmpassword==""||Greens_Jobber_Telephone==""||Greens_Jobber_Address==""||Greens_Jobber_QQ==""||Greens_Jobber_WeChat==""||Greens_Jobber_Name==""||Greens_Jobber_Shift_Name==""||Greens_Jobber_Aptitude=="")
		{
			alert("任意信息不能为空，请重新填写！");
			return false;
		}
		else if(Greens_Jobber_UserName.length>20){
			alert("用户名不能超过20个字符，请重新输入！");
			return false;
		}
		else if(Greens_Jobber_Password.length<6){
			alert("密码不能小于6个字符，请重新输入！");
			return false;
			}
		else if (Greens_Jobber_Password!=userconfirmpassword)
		{
			alert("2次密码输入不一致！");
			return false;
		}
		else if(isNaN(Greens_Jobber_Telephone)){
			alert("联系电话必须是数字，请重新输入！");
			return false;
		}
		else if(Greens_Jobber_Address.length>20){
			alert("店铺地址不能超过20个字符，请重新输入！");
			return false;
		}
		else if(Greens_Jobber_QQ.length>11){
			alert("QQ号码不能超过10个字符，请重新输入！");
			return false;
		}
		else if(Greens_Jobber_WeChat.length>20){
			alert("微信号码不能超过20个字符，请重新输入！");
			return false;
		}
		
		else if(Greens_Jobber_Name.length>20){
			alert("店铺名称不能超过20个字符，请重新输入！");
			return false;
		}
		else if(Greens_Jobber_Shift_Name.length>30){
			alert("店铺负责人不能超过20个字符，请重新输入！");
			return false;
		}
		
		else if(Greens_Jobber_Aptitude.length>20){
			alert("资质不能超过20个字符，请重新输入！");
			return false;
		}
		else{
			true
		}
}
</script>
<style>
	.layui-inline{
 		margin-top:20px;
	 }
	  legend{
		font-size:20px;
	}
	fieldset{
		margin:30px auto;
		width:1200px;
	}
	.layui-input{
		text-align:center;
		word-break:keep-all;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	.nva{
		padding:20px 0;
	}
	form{position:relative;}
	.list{
		position:absolute;
		left:calc(50% - 130px);
	}
</style>
</head>
<body>  
 <form  method="post" action="Greens_JobberServlet1" enctype="multipart/form-data" class="lanyui-form" id="form1" name="form1" onsubmit="return check()">
  <fieldset>
   <legend>菜商注册</legend>
 <div class="nva">
 <div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>用 户 名</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Greens_Jobber_UserName" id="firstname" class="layui-input" placeholder="请输入用户名">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>输入密码</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="password" lay-verify="required" required name="Greens_Jobber_Password" class="layui-input" placeholder="请输入密码">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>确认密码</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="password" lay-verify="required" required name="userconfirmpassword" class="layui-input" placeholder="请输入确认密码">
			<span id="tishi"></span>
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>联系电话</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_Telephone" class="layui-input" placeholder="请输入联系电话">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>店铺地址</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_Address" class="layui-input" placeholder="请输入店铺地址">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>Q Q号码</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_QQ" class="layui-input" placeholder="请输入QQ号码">
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>微信号码</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_WeChat" class="layui-input" placeholder="请输入微信号码">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>店铺名称</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_Name" class="layui-input" placeholder="请输入店铺名称">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>店铺负责人</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_Shift_Name" class="layui-input" placeholder="请输入负责人姓名">
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>资质上传</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="file" lay-verify="required" required name="Greens_Jobber_Aptitude" style="width:186px;" id="test1" multiple="multiple"  class="layui-input" >
		</div>
</div>
<div style="display；inline-block;margin-left:590px;font-size:15px;margin-top:-32px;">
	<input style="margin-left: 50px;width:15px;height:15px;"  type="checkbox" checked/>我已看过并接受<a href="greensyhxy.html">《用户协议》</a>
</div>
</div>
</fieldset>
<div class="list">
 <div class="layui-inline">
	<div class="layui-input-inline">
		<button class="layui-btn" type="submit" style="width:121px;">注册</button>
	</div>
</div>
<div class="layui-inline">
	<div class="layui-input-inline" style="margin-left:15px;">
		<button class="layui-btn" type="reset" style="width:121px;">重置</button>
	</div>
</div>
</div>
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