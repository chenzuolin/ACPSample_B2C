<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加快递员</title>
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
<style>
	#layuiadmin-app-form-tags{padding:30px;}
</style>
</head>
<body>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<form class="layui-form layui-form-pane" action="" style="padding:30px">
<div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-inline">
      <input type="text" name="name" id="name" placeholder="请输入用户名" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">请务必填写用户名</div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">输入密码</label>
    <div class="layui-input-inline">
      <input type="password" name="passwordone" id="passwordone" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">请务必填写密码</div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-inline">
      <input type="password" name="passwordtwo" id="passwordtwo" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">请务必填写密码</div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-inline">
      <input type="tel" name="tel" id="tel" lay-verify="required|phone" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">请务必填写联系电话</div>
</div>
<div class="layui-form-item">
	 <label class="layui-form-label">运输类型</label>
	  <div class="layui-input-inline">
	      <select name="courierType" id="courierType">
	        <option value="">请选择运输类型</option>
	        <option value="小货车" selected="">小货车</option>
	        <option value="电动车">电动车</option>
	        <option value="金杯车">金杯车</option>
	        <option value="小汽车">小汽车</option>
	      </select>
    </div>
</div>
</form>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script> 
<script>

	var callbackdata = function (){
		var passwordtwo = document.getElementById("passwordtwo").value;
		var courerName = document.getElementById("name").value;
		var tel = document.getElementById("tel").value;
		var courierType = document.getElementById("courierType").value;
		var data = {
				username: courerName,
				pwd: passwordtwo,
				tel: tel,
				type: courierType
		}
		return data;
	}

</script>
</body>
</html>