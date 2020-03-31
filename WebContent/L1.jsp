<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<style>
	.nva{
		margin:15px 0;
	}
	.layui-input{
		margin-top:-4px;
		width:225px;
		margin-left:-5px;
	}
	legend{
		font-size:20px;
	}
</style>
</head>
<body>
<form action="L1Srevlet" class="layui-form layui-form-pane" method="get" >
 <fieldset>
  <legend>蔬菜月销售量</legend>
  <div class="nva">
<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px; margin-top:-4px;">时间</label>
		<div class="layui-input-inline">
			<select name="a" class="layui-input">
					<option selected value="2018">2018</option>
       				<option value="2019">2019</option>
       		</select>
		</div>
	</div>
	<div class="layui-input-inline" style="margin-left:65px;">
		<input type="text" required name="b" lay-verify="required" placeholder="请输入蔬菜名称" style="width:300px;" class="layui-input">
	</div>
	<div class="layui-input-inline">
		<button type="submit" class="layui-btn" style="margin-top:-4px; margin-left:-4px; width:121px;"><i class="layui-icon">&#xe615;</i>查询</button>
	</div>
	</div>
</fieldset>
	 <script src="./layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
</script>
</form>
</body>
</html>