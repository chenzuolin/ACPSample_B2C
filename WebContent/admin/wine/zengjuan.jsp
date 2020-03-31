<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.layui-form{margin:15px 5px}
</style>
</head>
<body>
<form class="layui-form" action="">
  <div class="layui-form-item">
    <label class="layui-form-label">限制金额</label>
    <div class="layui-input-block">
      <input type="number" name="xzmoney" id="xzmoney" lay-verify="title" autocomplete="off" placeholder="满多少元可用" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">赠送金额</label>
    <div class="layui-input-block">
      <input type="number" name="zsmoney" id="zsmoney" lay-verify="title" autocomplete="off" placeholder="请输入赠送金额" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">过期时间</label>
    <div class="layui-input-block">
      <input type="text" name="title" id="test1"  placeholder="请选择过期时间" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">赠券数量</label>
    <div class="layui-input-block">
      <input type="number" name="num"  id="num" lay-verify="num" autocomplete="off" placeholder="请输入个数" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">经办人</label>
    <div class="layui-input-block">
      <input type="text" name="username" id="username"  lay-verify="username" autocomplete="off" placeholder="请输入经办人" class="layui-input">
    </div>
  </div>
</form>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>   
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
var callbackdata = function (){
	 var data = {
		xzmoney : $("#xzmoney").val(),
		zsmoney : $("#zsmoney").val(),
		time : $("#test1").val(),
		num : $("#num").val(),
		username : $("#username").val()
  	}
	return data;
}
layui.use(['table','layer','jquery','laydate'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var laydate = layui.laydate;
  laydate.render({
	  elem: '#test1',
	  rigger: 'click'
  });
 
});
</script>
</body>
</html>