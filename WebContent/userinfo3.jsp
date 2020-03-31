<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<form name="form1" method="post" action="TSS2revlet">
<div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header"style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;">设置我的资料</div>
          <div class="layui-card-body" pad15="">
            
            <div class="layui-form" lay-filter="">
              <div class="layui-form-item">
                <label class="layui-form-label">我的角色</label>
                <div class="layui-input-inline">
                  <select name="role" lay-verify="">
                    <option value="1" disabled="">菜商</option>
                    <option value="2" disabled="">酒店</option>
                  	<option value="3" selected="">管理员</option>
                  </select>
                  <div class="layui-unselect layui-form-select">
                  <div class="layui-select-title">
                  <input placeholder="请选择" value="普通管理员" readonly="" class="layui-input layui-unselect" type="text">
                  <i class="layui-edge"></i>
                  </div><dl class="layui-anim layui-anim-upbit"><dd lay-value="1" class="layui-this">超级管理员</dd><dd lay-value="2" class=" layui-disabled">普通管理员</dd><dd lay-value="3" class=" layui-disabled">审核员</dd><dd lay-value="4" class=" layui-disabled">编辑人员</dd></dl></div> 
                </div>
                <div class="layui-form-mid layui-word-aux">当前角色不可更改为其它角色</div>
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
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                  <input name="username" value="" readonly=""placeholder="请输入用户名" class="layui-input" type="text">
                </div>
                <div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                  <input name="sex" value="男" title="男" type="radio"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><div>男</div></div>
                  <input name="sex" value="女" title="女" checked="" type="radio"><div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i><div>女</div></div>
                </div>
              </div>
              
          
              <div class="layui-form-item">
                <div class="layui-input-block">
                  <button class="layui-btn" type="submit">确认修改</button>
                  <button class="layui-btn" type="reset">重新填写</button>
                </div>
              </div>
            </div>
            
          </div>
        </div>
        </div>
        </form>
      </div>
      <script src="layui/layui.all.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
<div style="background-color:#009688; height:35px; width:100%; padding-bottom:0px">

</div>
</body>
</html>