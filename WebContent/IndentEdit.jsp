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
<c:forEach items="${IndentAll }" var="it">
<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">ID</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_UserName" value='${it.indent_ID }' readonly="readonly" lay-verify="title" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">下单时间</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_Password" value="${it.indent_Time }" readonly="readonly" lay-verify="pass" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">订单状态</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_Name" value="${it.indent_Status }" readonly="readonly" lay-verify="required" autocomplete="off"  class="layui-input">
      </div>
    </div>
</div>

<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">支付类型</label>
      <div class="layui-input-inline">
        <input type="text" name="indent_Type" value="${it.indent_Type }" readonly="readonly" lay-verify="required"  autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">支付编号</label>
      <div class="layui-input-inline">
        <input type="tel" name="indent_PayID" value="${it.indent_PayID }" readonly="readonly" lay-verify="required|phone" autocomplete="off"  class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">订单备注</label>
      <div class="layui-input-inline">
        <input type="tel" name="indent_remark" value="${it.indent_remark }" readonly="readonly" lay-verify="required|phone" autocomplete="off"  class="layui-input">
      </div>
    </div>
</div>

<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">酒店名称</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_Shift_Name" value="${it.wineshop_Name }" readonly="readonly" lay-verify="required"  autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">负责人</label>
      <div class="layui-input-inline">
        <input type="tel" name="wineshop_Telephone" value="${it.wineshop_shift_name }" readonly="readonly" lay-verify="required|phone" autocomplete="off"  class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">联系电话</label>
      <div class="layui-input-inline">
        <input type="tel" name="wineshop_Telephone" value="${it.wienshop_telephone }" readonly="readonly" lay-verify="required|phone" autocomplete="off"  class="layui-input">
      </div>
    </div>
</div>

<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">最早收货时间</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_QQ" value="${it.wienshop_Time }" readonly="readonly" lay-verify="required"  autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">最晚收货时间</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_WeChat" value="${it.wienshop_nightTime }" readonly="readonly" lay-verify="required" autocomplete="off"  class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">推荐人</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_Number" value="${it.wienshop_tuijian }" readonly="readonly" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
</div>

<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">采购人员</label>
      <div class="layui-input-inline"> 
        <input type="text" id="test1" name="wineshop_Time" value="${it.cg_Name }" readonly="readonly" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">采购时间</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_TimeNight" value="${it.cg_time }" readonly="readonly" lay-verify="required" autocomplete="off"  class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">分拣人员</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_TuiJian" value="${it.fj_Name }" readonly="readonly" lay-verify="required" autocomplete="off"  class="layui-input">
      </div>
    </div>
</div>

<div class="layui-form-item">
	    <div class="layui-inline">
	      <label class="layui-form-label">分拣时间</label>
	      <div class="layui-input-inline">
	        <input type="text" name="wineshop_ID" value="${it.fj_Time }" readonly="readonly" readonly="readonly" lay-verify="required"  autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
		    <label class="layui-form-label">快递人员</label>
		    <div class="layui-input-inline">
		      <input type="text" name="addr" value="${it.courier_Name }" readonly="readonly"  lay-verify="title" autocomplete="off" class="layui-input">
		    </div>
  		</div>
  		 <div class="layui-inline">
		    <label class="layui-form-label">接单时间</label>
		    <div class="layui-input-inline">
		      <input type="text" name="addr" value="${it.ps_time }" readonly="readonly"  lay-verify="title" autocomplete="off"  class="layui-input">
		    </div>
  		</div>
</div>

<div class="layui-form-item">
	    <div class="layui-inline">
	      <label class="layui-form-label">金额</label>
	      <div class="layui-input-inline">
	        <input type="text" name="wineshop_ID" value="${it.totalPrice }" readonly="readonly" lay-verify="required"  autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
		    <label class="layui-form-label">酒店地址</label>
		    <div class="layui-input-inline">
		      <input type="text" name="addr" value="${it.wineshop_address }" readonly="readonly"  lay-verify="title" autocomplete="off"  class="layui-input" style="width:536px;">
		    </div>
  		</div>
</div>
</c:forEach>
<table class="layui-table" >
		<tr class="one" style="text-align:center;">
			<td>序号</td>
			<td>蔬菜名称</td>
			<td>购买数量</td>
			<td>蔬菜单价</td>
		</tr>
		<c:forEach items="${g }" var="tt" varStatus="vs">
		<tr class="two" style="text-align:center;">
			<td>${vs.count }</td>
			<td>${tt.greens_Name }</td>
			<td>${tt.number }/${tt.greens_Unit }</td>
			<td>${tt.greens_Price }元/${tt.greens_Unit }</td>
		</tr>
		</c:forEach>
	</table>	
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