<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>����ע��ҳ��</title>
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
			alert("������Ϣ����Ϊ�գ���������д��");
			return false;
		}
		else if(Greens_Jobber_UserName.length>20){
			alert("�û������ܳ���20���ַ������������룡");
			return false;
		}
		else if(Greens_Jobber_Password.length<6){
			alert("���벻��С��6���ַ������������룡");
			return false;
			}
		else if (Greens_Jobber_Password!=userconfirmpassword)
		{
			alert("2���������벻һ�£�");
			return false;
		}
		else if(isNaN(Greens_Jobber_Telephone)){
			alert("��ϵ�绰���������֣����������룡");
			return false;
		}
		else if(Greens_Jobber_Address.length>20){
			alert("���̵�ַ���ܳ���20���ַ������������룡");
			return false;
		}
		else if(Greens_Jobber_QQ.length>11){
			alert("QQ���벻�ܳ���10���ַ������������룡");
			return false;
		}
		else if(Greens_Jobber_WeChat.length>20){
			alert("΢�ź��벻�ܳ���20���ַ������������룡");
			return false;
		}
		
		else if(Greens_Jobber_Name.length>20){
			alert("�������Ʋ��ܳ���20���ַ������������룡");
			return false;
		}
		else if(Greens_Jobber_Shift_Name.length>30){
			alert("���̸����˲��ܳ���20���ַ������������룡");
			return false;
		}
		
		else if(Greens_Jobber_Aptitude.length>20){
			alert("���ʲ��ܳ���20���ַ������������룡");
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
   <legend>����ע��</legend>
 <div class="nva">
 <div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>�� �� ��</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Greens_Jobber_UserName" id="firstname" class="layui-input" placeholder="�������û���">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>��������</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="password" lay-verify="required" required name="Greens_Jobber_Password" class="layui-input" placeholder="����������">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>ȷ������</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="password" lay-verify="required" required name="userconfirmpassword" class="layui-input" placeholder="������ȷ������">
			<span id="tishi"></span>
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>��ϵ�绰</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_Telephone" class="layui-input" placeholder="��������ϵ�绰">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>���̵�ַ</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_Address" class="layui-input" placeholder="��������̵�ַ">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>Q Q����</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_QQ" class="layui-input" placeholder="������QQ����">
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>΢�ź���</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_WeChat" class="layui-input" placeholder="������΢�ź���">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>��������</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_Name" class="layui-input" placeholder="�������������">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>���̸�����</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required  name="Greens_Jobber_Shift_Name" class="layui-input" placeholder="�����븺��������">
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>�����ϴ�</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="file" lay-verify="required" required name="Greens_Jobber_Aptitude" style="width:186px;" id="test1" multiple="multiple"  class="layui-input" >
		</div>
</div>
<div style="display��inline-block;margin-left:590px;font-size:15px;margin-top:-32px;">
	<input style="margin-left: 50px;width:15px;height:15px;"  type="checkbox" checked/>���ѿ���������<a href="greensyhxy.html">���û�Э�顷</a>
</div>
</div>
</fieldset>
<div class="list">
 <div class="layui-inline">
	<div class="layui-input-inline">
		<button class="layui-btn" type="submit" style="width:121px;">ע��</button>
	</div>
</div>
<div class="layui-inline">
	<div class="layui-input-inline" style="margin-left:15px;">
		<button class="layui-btn" type="reset" style="width:121px;">����</button>
	</div>
</div>
</div>
</form>
<script src="layui-v2.3.0/layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //�����ύ
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>

</body>
</html>