<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.net.InetAddress"
    pageEncoding="UTF-8"%>
<%@page import="java.net.InetAddress"%>
<%
	InetAddress addr = InetAddress.getLocalHost();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>速盟快线登陆页面</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="shortcut icon" href="index.ico" type="image/x-icon" />
<script src="js/jquery.js"></script>
<script src="js/layer-v3.1.1/layer/layer.js"></script>
<script src="js/verificationNumbers.js"></script>
<script src="js/Particleground.js"></script>
<style>
	body{height:100%;background:#16a085;overflow:hidden;}
	canvas{z-index:-1;position:absolute;}
</style>
<script>
	$(document).ready(function() {
	  //粒子背景特效
	  $('body').particleground({
	    dotColor: '#5cbdaa',
	    lineColor: '#5cbdaa'
	  });
	  //验证码
	  createCode();
	  //测试提交，对接程序删除即可
	  $(".submit_btn").click(function(){
		  
		  });
	});
</script>
<script type="text/javascript">
history.pushState(null, null, document.URL);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.URL);
});
	function check(){
		var userName = document.form1.userName.value;
		var password = document.form1.password.value;
		var J_codetext = document.form1.J_codetext.value;
		if(userName == 0 || password == 0){
			layer.alert('请输入用户名或密码！', {icon: 6});
			return false;
		}else if(J_codetext == 0 ){
			layer.alert('请输入验证码！', {icon: 6});
			return false;
		}else if(val != J_codetext){
			layer.alert('验证码错误！', {icon: 3});
			return false;
		}else{
			true;
		}
	}
	function zhuce(){
		window.location.href="Jdzc.jsp";
	}
</script>
</head>
<body>
<form  method="post" action="WineshopLoginServlet" id="form1" name="form1" onsubmit="return check();">
	<dl class="admin_login">
 		<dt>
  			<strong>速盟快线登录系统</strong>
	    </dt>
 			<dd class="user_icon">
  				<input type="text" name="userName" id="userName" placeholder="请输入账号" class="login_txtbx">
 			</dd>
 			<dd class="pwd_icon">
  				<input type="password" name="password" id="password" placeholder="请输入密码" class="login_txtbx">
 			</dd>
  			<input type="text" name="ip" value="<%=addr.getHostAddress() %>" style="display:none;">
			<input type="text" name="ip_name" value="<%=addr.getHostName() %>" style="display:none;">
 			<dd class="val_icon">
  				<div class="checkcode">
    				<input type="text" id="J_codetext" name="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
    					<canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  				</div>
  				<input type="button" value="验证码核验" class="ver_btn" onclick="validate();">
 			</dd>
 			<dd>
				<input type="submit" value="登录" class="submit_btn" style="width:100%;" id="btn1" />
 			</dd>
			<dd>
				<input type="button" value="注册" class="submit_btn" style="width:100%;" id="btn2" onclick="zhuce();" />
			</dd>
 			<dd>
				<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
 			</dd>
	</dl>
</form>
</body>
</html>