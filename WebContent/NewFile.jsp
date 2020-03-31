<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
  String path=request.getContextPath();
  String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
function validate() {
var pw1 = document.getElementById("pw1").value;
var pw2 = document.getElementById("pw2").value;
if(pw1 == pw2) {
document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
document.getElementById("submit").disabled = false;
}
else {
document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
document.getElementById("submit").disabled = true;
}
}
</script>
</head>
<body>
<form action="aaa" method="post" enctype="multipart/form-data">   
用户昵称：<input type="text" name="Wineshop_UserName"/><br/>
输入密码： <input type="password" name="Wineshop_Password" id="pw1"/><br/>
确认密码： <input type="password" name="Wineshop_Password1" id="pw2" onkeyup="validate()"/><span id="tishi"></span><br/>
酒店名称：<input type="text" name="Wineshop_Name" /><br/>
证件号：<input type="text" name="Wineshop_Number" /> <br/>
<!--资质附件： <input type="file" name="file" /><input type="submit" id="file" value="开始上传" onclick="this.form.action='ServletFileUpLoad'"><br/>  -->
联系电话：<input type="text" name="Wineshop_Telephone" /> <br/>  
酒店性质：<input type="text" name="Wineshop_Nature" />  <br/>
酒店地址：<input type="text" name="Wineshop_Address"><br/>
酒店QQ：<input type="text" name="Wineshop_QQ" /><br/>
酒店微信:<input type="text" name="Wineshop_WeChat" /><br/>
负责人:<input type="text" name="Wineshop_Shift_Name" /><br/>
<input type="checkbox" checked/>我已看过并接受<a href="#">《用户协议》</a><br/>
<input type="submit" id="zhuce" value="立即注册" />  
                   
</form>
<!-- <script type="text/javascript">
const one= document.getElementById('file');
const two= document.getElementById('zhuce');
//给按钮2添加点击事件
two.addEventListener('click',() => {
	one.onclick(); //按钮2点击后触发按钮1的onclick
    //one.click(); //按钮2点击后触发按钮1的click 效果一样
});
</script> -->
</body>
</html>