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
<script type="text/javascript"  src="js/jquery.js"></script>
  <script src="./layui/layui.js" charset="UTF-8"></script>
<style>
	.layui-input{
		margin-left:-4px;
		width:203px;
	}
	legend{
		font-size:20px;
	}
	.nva{
		display:inline-block;
		margin-left:395px;
	}
</style>
</head>
<body>
<form action="QXServlet" method="get" class="layui-form">
		<%
		
		User_PermissionDao dao = new User_PermissionDao();
		int aa = Integer.parseInt(request.getParameter("aa"));
		String bb = request.getParameter("zz");
		%>
		<input style="display:none;" type="text" value="<%=aa %>" name="xx">
		<fieldset>
       	 	<legend>权限分配</legend>
      <div class="nva">
		<div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;margin-top:20px;">管理员名称</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" style="margin-left:-4px;text-align:center;background:skyblue;margin-top:20px;" readonly="readonly" required name="Greens_Name" id="firstname" class="layui-input" value="<%=bb %>">
			</div>
		</div>
		<br/>
		<div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;margin-top:30px;">分配权限</label>
				<div class="layui-input-inline" style="margin-top:29px;">
					<select  name="zz" class="layui-input"  >
						<%
							PermissionDao dao1 = new PermissionDao();
							List<Permission> list1 = dao1.findAll();
							for(Permission a : list1){
								String cc = a.getPermission_Remark();
							
						%>
					<option  style="text-align:center;" value="<%=cc %>"><%=cc %></option>
						<%
							}
						%>
					</select>
				</div>
		</div>
		<br/>
		<div class="layui-inline">
		<div class="layui-input-inline" style="">
			<button class="layui-btn" type="submit" style="width:121px;margin-left:168px;margin-top:30px;">分配权限</button>
		</div>
	</div>
</div>
</fieldset>
<script type="text/javascript">


//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('form', function(){
  var form = layui.form;
  
  //…
});
</script>
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
</script>
</form>
</body>
</html>