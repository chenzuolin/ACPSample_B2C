<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@ page import="com.sumeng.service.*"%>
<%@ page import="com.sumeng.web.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑用户</title>
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>

<body>

<form class="layui-form layui-form-pane" id="form-data" action="" style="margin-top:20px;margin-left:20px;">
  <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-inline">
      <input type="text" name="text" placeholder="请输入用户名" id="userName" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">请务必填写用户名</div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">新密码</label>
    <div class="layui-input-inline">
      <input type="text" name="password" placeholder="请输入密码" id="pwdOne" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">请务必填写密码</div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-inline">
      <input type="text" name="password" placeholder="请输入密码" id="pwdTwo" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">出生日期</label>
      <div class="layui-input-block">
        <input type="text" name="date" id="date1" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">角色权限</label>
    <div class="layui-input-inline">
      <select name="quiz1" id="rolePower">
        <option value="" selected="">请选择角色</option>
        <%
        	RoleDao dao = new RoleDao();
        	List<Role> role = dao.findAll();
        	for(Role r : role){
        		String roleName = r.getRole_Name();
        		int roleId = r.getRole_ID();
        	
        %>
        <option value="<%=roleId %>"><%=roleName %></option>
        <%
        	}
        %>
      </select>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">用户描述</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入描述内容" id="proFile" class="layui-textarea"></textarea>
    </div>
  </div>
</form>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script>
var callbackdata = function (){
	
	var userName = document.getElementById("userName").value;
	var pwdOne = document.getElementById("pwdOne").value;
	var pwdTwo = document.getElementById("pwdTwo").value;
	var birthday = document.getElementById("date1").value;
	var rolePower = document.getElementById("rolePower").value;
	var proFile = document.getElementById("proFile").value;
	var data = {
			userName1: userName,
			pwdOne1: pwdOne,
			pwdTwo1: pwdTwo,
			birthday1: birthday,
			rolePower1: rolePower,
			proFile1: proFile
	}
	return data;
}
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  laydate.render({
    elem: '#date1'
  });
  form.on('switch(switchTest)', function(data){
	    layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
	      offset: '6px'
	    });
	  });
});
</script>
</body>
</html>