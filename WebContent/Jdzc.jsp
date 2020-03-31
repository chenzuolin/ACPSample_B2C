<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%
  String path=request.getContextPath();
  String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>酒店注册</title>
<link href="layui-v2.3.0/layui/css/layui.css" rel="stylesheet" >
<script language="javaScript">
function check(){
	var Wineshop_UserName = document.form1.Wineshop_UserName.value;
	var Wineshop_Password = document.form1.Wineshop_Password.value;
	var Wineshop_Password1 = document.form1.Wineshop_Password1.value;
	var Wineshop_Name = document.form1.Wineshop_Name.value;
	var Wineshop_Number = document.form1.Wineshop_Number.value;
	var Wineshop_Telephone = document.form1.Wineshop_Telephone.value;
	var Wineshop_Nature = document.form1.Wineshop_Nature.value;
	var Wineshop_Address = document.form1.Wineshop_Address.value;
	var Wineshop_QQ = document.form1.Wineshop_QQ.value;
	var Wineshop_WeChat = document.form1.Wineshop_WeChat.value;
	var Wineshop_Shift_Name = document.form1.Wineshop_Shift_Name.value;
	var file = document.form1.file.value;
	var checkbox = document.form1.checkbox.value;
	alert(checkbox);
	if(Wineshop_UserName==""||Wineshop_Password==""||Wineshop_Password1==""||Wineshop_Name==""||Wineshop_Number==""||Wineshop_Telephone==""||Wineshop_Nature==""||Wineshop_Address==""||Wineshop_QQ==""||Wineshop_WeChat==""||Wineshop_Shift_Name==""||file=="")
		{
			 layer.alert('任意信息不能为空，请重新填写！', {icon: 3});
			return false;
		}
		else if(Wineshop_UserName.length>20){
			 layer.alert('用户名不能超过20个字符，请重新输入！', {icon: 3});
			return false;
		}
		else if(Wineshop_Password.length<6){
			 layer.alert('密码不能小于6个字符，请重新输入！', {icon: 3});
			return false;
			}
		else if (Wineshop_Password!=Wineshop_Password1)
		{
			 layer.alert('2次密码输入不一致！', {icon: 3});
			return false;
		}
		else if(Wineshop_Name.length>20){
			 layer.alert('酒店名称不能超过20个字符，请重新输入！', {icon: 3});
			return false;
		}
		else if(Wineshop_Number.length>20){
			 layer.alert('证件编号不能超过20个字符，请重新输入！', {icon: 3});
			return false;
		}
		else if(isNaN(Wineshop_Telephone)){
			 layer.alert('联系电话必须是数字，请重新输入！', {icon: 3});
			return false;
		}
		else if(Wineshop_Nature.length>20){
			 layer.alert('酒店性质不能超过20个字符，请重新输入！', {icon: 3});
			return false;
		}
		else if(Wineshop_Address.length>30){
			 layer.alert('酒店地址不能超过20个字符，请重新输入！', {icon: 3});
			return false;
		}
		else if(Wineshop_QQ.length>11){
			 layer.alert('酒店qq不能超过10个字符，请重新输入！', {icon: 3});
			return false;
		}
		else if(Wineshop_WeChat.length>20){
			 layer.alert('酒店微信不能超过20个字符，请重新输入！', {icon: 3});
			return false;
		}
		else if(Wineshop_Shift_Name.length>30){
			 layer.alert('酒店负责人不能超过10个字符，请重新输入！', {icon: 3});
			return false;
		}
		else if(file.length>20){
			layer.alert('酒店资质不能超过10个字符，请重新输入！', {icon: 3});
			return false;
		}
		else if(checkbox == "on"){
			 layer.alert('请接受用户协议！', {icon: 3});
			return false;
		}
		else{
			true
		}
}
</script>
 <style>
 	.layui-inline{
 		margin-top:30px;
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
	form{position:relative;}
	.list{
		position:absolute;
		left:calc(50% - 130px);
	}
 </style>
</head>
<body>
   
 <form method="post" action="ServletFileUpLoad" enctype="multipart/form-data" class="layui-form layui-form-pane" id="form1" name="form1" onsubmit="return check()">
 <div class="line">
 <fieldset>
   <legend>酒店注册</legend>
 <div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>用 户 名</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_UserName" id="firstname" class="layui-input" placeholder="请输入用户名">
		</div>
</div>
 <div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>输入密码</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="password" lay-verify="required" required name="Wineshop_Password"  class="layui-input" placeholder="请输入密码">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>确认密码</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="password" lay-verify="required" required name="Wineshop_Password1" class="layui-input" placeholder="请确认密码"><span id="tishi" style="display:inline-block;"></span>
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>酒店名称</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Name" id="firstname" class="layui-input" placeholder="请输入酒店名称">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>证件编号</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Number" id="firstname" class="layui-input" placeholder="请输入证件编号">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>联系电话</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Telephone" id="firstname" class="layui-input" placeholder="请输入联系电话">
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>酒店性质</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;width:186px;">
			<select name="Wineshop_Nature" lay-filter="interest">
		        <option value="0" disablid selected>请选择</option>
		        <option value="私营酒店">私营酒店</option>
		        <option value="企事业单位">企事业单位</option>
		     </select>
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>酒店地址</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Address" id="firstname" class="layui-input" placeholder="请输入酒店地址">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>酒店QQ</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_QQ" id="firstname" class="layui-input" placeholder="请输入酒店QQ">
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>酒店微信</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_WeChat" id="firstname" class="layui-input" placeholder="请输入酒店微信">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>酒店负责人</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Shift_Name" id="firstname" class="layui-input" placeholder="请输入负责人姓名">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>资质上传</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="file" lay-verify="required" required name="file" style="width:186px;line-height:25px;" id="test1" multiple="multiple"  class="layui-input">
		</div>
</div>
<br/>
<div style="display:inline-block;margin-left:473px;">
	<input style="margin-left: 50px;width:15px;height:15px;"  type="checkbox" name="checkbox" id="checkbox" />已接受<a href="yonghuxieyi.jsp">《速盟快线用户协议》</a>
</div>
</fieldset>
<br/>
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