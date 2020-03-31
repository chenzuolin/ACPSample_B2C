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
 <link rel="stylesheet" href="./css/layui.css">
 <link rel="stylesheet" href="./layui/css/layui.css">
 <style>
 	.layui-inline{
 		margin-top:30px;
 	}
 </style>
</head>
<body>
<form action="RecommendServlet" method="post" class="layui-form">
<%
	int bb = Integer.parseInt(request.getParameter("bb"));
	GreensDao dao = new GreensDao();
	List<Greens> list = dao.findUserByID(bb);
	for(Greens greens : list){
		
		String aa = greens.getGreens_Name();
		String cc = greens.getGreens_Recommend();
		
		
%>
	<input type="text" name="bb" value="<%=bb %>" style="display:none">
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:109px;">蔬菜名称</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" style="text-align:center;" required name="xx" id="firstname" class="layui-input" value="<%=aa %>">
		</div>
	</div>	
	
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:98px;">是否推荐</label>
		<div class="layui-input-inline" style="margin-left:-4px;width:182px;">
			<select name="zz">
				<option value="" selected="selected">--请选择--</option>
				<option value="是">是</option>
				<option value="否">否</option>
				
			</select>
		</div>
	</div>
		
				<%		
					}
				%>
<div class="layui-form-item">
      <div class="layui-input-block" style="margin-left:535px;margin-top:30px;">
        <button class="layui-btn" type="submit" style="width:121px;">确认修改</button>
        <button class="layui-btn" type="reset" style="width:121px;">重新填写</button> 
      </div>    
</div>
<script src="layui-v2.3.0/layui/layui.js" charset="UTF-8"></script>
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
</form>
</body>
</html>