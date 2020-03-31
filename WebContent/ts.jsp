<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ts</title>
<link rel="stylesheet" href="./css/layui.css" media="all">
<style>
	.list{
		width:600px;
		height:300px;
		margin:50px auto;
	}
	fieldset{
		padding-top:20px;
	}
	legend{
		font-size:20px;
	}
</style>
</head>
<body    >
<form class="layui-form" method="post" action="TSSServlet" style="background-color:white;"> 
	<div class="list">
		<fieldset>
       	 	<legend>投诉信息</legend>
			  <div class="layui-form-item">
			    <label class="layui-btn" style="background:rgb(126,126,126);"><strong>投诉类型</strong></label>
			    <div class="layui-input-block" style="margin-top:-38px">
			      <select name="Complainant_Type" id="Complainant_Type">
			        <option value="软件">软件</option>
			        <option value="商品">商品</option>
			        <option value="物流">物流</option>
			      </select>
			    </div>
			  </div>
			<div class="layui-form-item">
			  <label class="layui-btn" style="background:rgb(126,126,126); "><strong>投诉信息</strong></label>
			    <div class="layui-input-block">
			      <textarea placeholder="请输入内容" class="layui-textarea"  style="margin-top:-38px"  name="remarks"></textarea>
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" >立即提交</button>
			      <button type="reset"class="layui-btn" style="width:100px">重置</button>
			    </div>
			  </div>
		</fieldset>
  </div>
  <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
</form>
<script src="./js/layui.all.js"></script>
<script>
layui.use('form', function(){
  var form = layui.form;
  
  //各种基于事件的操作，下面会有进一步介绍
});
</script>
      