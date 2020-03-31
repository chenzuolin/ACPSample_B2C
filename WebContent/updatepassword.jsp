<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
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
 <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header">修改密码</div>
          <div class="layui-card-body" pad15="">
            
            <div class="layui-form" lay-filter="">
              <div class="layui-form-item">
                <label class="layui-form-label">当前密码</label>
                <div class="layui-input-inline">
                  <input name="oldPassword" lay-verify="required" lay-vertype="tips" class="layui-input" type="password">
                </div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">新密码</label>
                <div class="layui-input-inline">
                  <input name="password" lay-verify="pass" lay-vertype="tips" autocomplete="off" id="pw1" class="layui-input" type="password">
                </div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">确认新密码</label>
                <div class="layui-input-inline">
                  <input name="repassword" lay-verify="repass" lay-vertype="tips" autocomplete="off" id="pw2" class="layui-input" type="password" onkeyup="validate()"/><span id="tishi"></span></p>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-input-block">
                  <button class="layui-btn" lay-submit="" lay-filter="setmypass">确认修改</button>
                </div>
              </div>
            </div>
            
          </div>
        </div>
      </div>
</body>
</html>