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
<title>�Ƶ�ע��</title>
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
			 layer.alert('������Ϣ����Ϊ�գ���������д��', {icon: 3});
			return false;
		}
		else if(Wineshop_UserName.length>20){
			 layer.alert('�û������ܳ���20���ַ������������룡', {icon: 3});
			return false;
		}
		else if(Wineshop_Password.length<6){
			 layer.alert('���벻��С��6���ַ������������룡', {icon: 3});
			return false;
			}
		else if (Wineshop_Password!=Wineshop_Password1)
		{
			 layer.alert('2���������벻һ�£�', {icon: 3});
			return false;
		}
		else if(Wineshop_Name.length>20){
			 layer.alert('�Ƶ����Ʋ��ܳ���20���ַ������������룡', {icon: 3});
			return false;
		}
		else if(Wineshop_Number.length>20){
			 layer.alert('֤����Ų��ܳ���20���ַ������������룡', {icon: 3});
			return false;
		}
		else if(isNaN(Wineshop_Telephone)){
			 layer.alert('��ϵ�绰���������֣����������룡', {icon: 3});
			return false;
		}
		else if(Wineshop_Nature.length>20){
			 layer.alert('�Ƶ����ʲ��ܳ���20���ַ������������룡', {icon: 3});
			return false;
		}
		else if(Wineshop_Address.length>30){
			 layer.alert('�Ƶ��ַ���ܳ���20���ַ������������룡', {icon: 3});
			return false;
		}
		else if(Wineshop_QQ.length>11){
			 layer.alert('�Ƶ�qq���ܳ���10���ַ������������룡', {icon: 3});
			return false;
		}
		else if(Wineshop_WeChat.length>20){
			 layer.alert('�Ƶ�΢�Ų��ܳ���20���ַ������������룡', {icon: 3});
			return false;
		}
		else if(Wineshop_Shift_Name.length>30){
			 layer.alert('�Ƶ긺���˲��ܳ���10���ַ������������룡', {icon: 3});
			return false;
		}
		else if(file.length>20){
			layer.alert('�Ƶ����ʲ��ܳ���10���ַ������������룡', {icon: 3});
			return false;
		}
		else if(checkbox == "on"){
			 layer.alert('������û�Э�飡', {icon: 3});
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
   <legend>�Ƶ�ע��</legend>
 <div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>�� �� ��</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_UserName" id="firstname" class="layui-input" placeholder="�������û���">
		</div>
</div>
 <div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>��������</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="password" lay-verify="required" required name="Wineshop_Password"  class="layui-input" placeholder="����������">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>ȷ������</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="password" lay-verify="required" required name="Wineshop_Password1" class="layui-input" placeholder="��ȷ������"><span id="tishi" style="display:inline-block;"></span>
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>�Ƶ�����</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Name" id="firstname" class="layui-input" placeholder="������Ƶ�����">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>֤�����</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Number" id="firstname" class="layui-input" placeholder="������֤�����">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>��ϵ�绰</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Telephone" id="firstname" class="layui-input" placeholder="��������ϵ�绰">
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>�Ƶ�����</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;width:186px;">
			<select name="Wineshop_Nature" lay-filter="interest">
		        <option value="0" disablid selected>��ѡ��</option>
		        <option value="˽Ӫ�Ƶ�">˽Ӫ�Ƶ�</option>
		        <option value="����ҵ��λ">����ҵ��λ</option>
		     </select>
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>�Ƶ��ַ</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Address" id="firstname" class="layui-input" placeholder="������Ƶ��ַ">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>�Ƶ�QQ</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_QQ" id="firstname" class="layui-input" placeholder="������Ƶ�QQ">
		</div>
</div>
<br/>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>�Ƶ�΢��</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_WeChat" id="firstname" class="layui-input" placeholder="������Ƶ�΢��">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>�Ƶ긺����</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" required name="Wineshop_Shift_Name" id="firstname" class="layui-input" placeholder="�����븺��������">
		</div>
</div>
<div class="layui-inline">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:70px;"><strong>�����ϴ�</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="file" lay-verify="required" required name="file" style="width:186px;line-height:25px;" id="test1" multiple="multiple"  class="layui-input">
		</div>
</div>
<br/>
<div style="display:inline-block;margin-left:473px;">
	<input style="margin-left: 50px;width:15px;height:15px;"  type="checkbox" name="checkbox" id="checkbox" />�ѽ���<a href="yonghuxieyi.jsp">�����˿����û�Э�顷</a>
</div>
</fieldset>
<br/>
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