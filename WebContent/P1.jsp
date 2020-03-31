<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<style>
	legend{
		font-size:20px;
	}
</style>
</head>
<body>
<form action="P1Servlet"  method="get" class="layui-form layui-form-pane" >
  <fieldset>
   <legend>查询酒店采购量</legend>
	<div class="layui-card" style="margin:15px 0;">
		<div class="layui-inline">
			<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:180px;width:121px;"><strong>酒店名称</strong></label>
				   <div class="layui-input-inline" style="margin-left:-4px;">
				        <select  name="a" id="Indent_Status">
				        	<option value="">请选择</option>
				        	<%
								WineshopDao dao = new WineshopDao();
									List<Wineshop> list = dao.findAll1();
									for(Wineshop wineshop : list){
										String aa = wineshop.getWineshop_Name();
							%>
					       <option value="<%=aa %>"><%=aa %></option>
					       <%
								}
					       %>
					  </select>
  				   </div>
  		</div>
  		<div class="layui-inline">
  			<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:30px;width:121px;"><strong>请输入蔬菜名称</strong></label>
  				<div class="layui-input-inline" style="margin-left:-4px;width:280px;">
					<input type="text" required name="b" lay-verify="required" placeholder="请输入蔬菜名称" class="layui-input">
				</div>
		</div>
		<div class="layui-input-inline">
			<button type="submit" class="layui-btn" style="width:121px;margin-left:30px;"><i class="layui-icon">&#xe615;</i>查询</button>
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
