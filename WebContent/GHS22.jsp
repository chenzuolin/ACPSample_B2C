<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
<link href="layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
<title>订单详情</title>
<style>
.layui-form-label{width:100px;}
</style>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>订单详细信息</legend>
</fieldset>
<form class="layui-form" id="tp" >
<c:forEach items="${d }" var = "pp">
<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">ID</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_UserName" value='${pp.indent_ID }' readonly="readonly" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">下单时间</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_Password" value="${pp.indent_Time }" readonly="readonly" lay-verify="pass" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">订单状态</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_Name" value="${pp.indent_Status }" readonly="readonly" lay-verify="required" autocomplete="off"  class="layui-input">
      </div>
    </div>
</div>

<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">支付类型</label>
      <div class="layui-input-inline">
        <input type="text" name="indent_Type" value="${pp.indent_Type }" readonly="readonly" lay-verify="required"  autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">支付编号</label>
      <div class="layui-input-inline">
        <input type="tel" name="indent_PayID" value="${pp.indent_PayID }" readonly="readonly" lay-verify="required|phone" autocomplete="off"  class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">订单备注</label>
      <div class="layui-input-inline">
        <input type="tel" name="indent_remark" value="${pp.indent_remark }" readonly="readonly" lay-verify="required|phone" autocomplete="off"  class="layui-input">
      </div>
    </div>
</div>
</c:forEach>




<table class="layui-table" >
		<tr class="one" style="text-align:center;">
			<td>序号</td>
			<td>蔬菜名称</td>
			<td>购买数量</td>
		</tr>
		<c:forEach items="${gr }" var="tt" varStatus="vs">
		<tr class="two" style="text-align:center;">
			<td>${vs.count }</td>
			<td>${tt.bb }</td>
			<td>${tt.aa }${tt.cc }</td>
		</tr>
		</c:forEach>
	</table>	
	<button class="layui-btn" type="submit" style=" width:121px; background:#CCCCCC; margin-left:136px;" onclick='javascript:window.print()'><i class="layui-icon"></i>打印</button>
</form>
<script src="layui-v2.4.5/layui/layui.all.js"></script>
<script src="layui-v2.4.5/layui/lay/modules/layer.js"></script>
<script src="layui-v2.4.5/layui/lay/modules/laydate.js"></script>
<script>
layui.use(['form', 'layedit', 'laydate','jquery'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  var $ = layui.jquery;
 
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '用户名至少得5个字符啊';
      }
    }
    ,pass: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ]
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
});
</script>
</body>
</html>