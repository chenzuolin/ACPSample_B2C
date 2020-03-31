<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page language="java" import="com.sec.dao.*"%>
<%@page language="java" import="com.sec.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
<title>蔬菜详情</title>
<style>
.layui-form-label{width:100px;}
</style>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>蔬菜信息</legend>
</fieldset>
 <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">蔬菜名称</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Name" value='${obj.greens_Name }' lay-verify="title" readonly="readonly" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">蔬菜类型</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Name" value='${obj.greens_Type_Name }' lay-verify="title" readonly="readonly" placeholder="请输入蔬菜名称" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">蔬菜单位</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Number" value="${obj.greens_Unit }" lay-verify="required" readonly="readonly" placeholder="请输入酒店负责人" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">蔬菜库存</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Number" value="${obj.greens_Number }" lay-verify="required" readonly="readonly" placeholder="请输入酒店负责人" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">速盟单价</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Price" value="${obj.greens_Price }" lay-verify="required|phone" readonly="readonly" autocomplete="off" placeholder="请输入联系电话" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">市场单价</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Market_Price" value="${obj.greens_Market_Price }" lay-verify="required|phone" readonly="readonly" autocomplete="off" placeholder="请输入联系电话" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">蔬菜产地</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Class" value="${obj.greens_Class }" lay-verify="required" placeholder="请输入酒店QQ" readonly="readonly" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">蔬菜等级</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Preiod" value="${obj.greens_Grade }" lay-verify="required" autocomplete="off" readonly="readonly" placeholder="请输入证件编号" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">保质期</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Preiod" value="${obj.greens_Preiod }" lay-verify="required" autocomplete="off" readonly="readonly" placeholder="请输入证件编号" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item" >
    <div class="layui-inline">
      <label class="layui-form-label">是否推荐</label>
      <div class="layui-input-inline"> 
        <input type="text" name="greens_Preiod" value="${obj.greens_Recommend }" lay-verify="required" autocomplete="off" readonly="readonly" placeholder="请输入证件编号" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">蔬菜品相</label>
       <div class="layui-input-inline">
        <input type="text" name="greens_Preiod" value="${obj.greens_Condition }" lay-verify="required" autocomplete="off" readonly="readonly" placeholder="请输入证件编号" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">蔬菜品质</label>
      <div class="layui-input-inline">
        <input type="text" name="greens_Preiod" value="${obj.greens_Character }" lay-verify="required" autocomplete="off" readonly="readonly" placeholder="请输入证件编号" class="layui-input">
      </div>
    </div>
  </div>
    <div class="layui-form-item" >
	    <div class="layui-inline">
	      <label class="layui-form-label">ID</label>
	      <div class="layui-input-inline">
	        <input type="text" name="greens_ID" value="${obj.greens_ID }" readonly="readonly" lay-verify="required" readonly="readonly" placeholder="请输入最早收货时间" autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
		    <label class="layui-form-label">蔬菜备注</label>
		    <div class="layui-input-inline">
		      <input type="text" name="greens_Remark" value="${obj.greens_Remark }"  lay-verify="title" autocomplete="off" readonly="readonly" placeholder="请输入酒店地址" class="layui-input" style="width:534px;">
		    </div>
  		</div>
  	</div>
<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/lay/modules/layer.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/lay/modules/laydate.js"></script>
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