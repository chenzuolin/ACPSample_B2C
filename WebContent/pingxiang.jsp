<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<title>Insert title here</title>
<style>
	legend{
		font-size:20px;
	}
</style>
</head>
<body>
<form action="pingxiangServlet" method="post">
<fieldset>
   <legend>新增品相</legend>
<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:335px;margin-top:3px;"><strong>添加品相</strong></label>
		<div class="layui-input-inline" style="margin-left:-4px;width:300px;margin-top:3px;">
			<input type="text" lay-verify="required" required name="pingxiang" id="firstname" class="layui-input" style="text-align:center;" placeholder="请输入品相名称">
		</div>
</div>
<div class="layui-form-item">
      <div class="layui-input-block" style="margin-left:800px;margin-top:-39px;">
        <button class="layui-btn" type="submit" style="width:121px;">提交</button>
      </div>    
 </div>
 </fieldset>
<div class="layui-inline">
		<label class="layui-btn" style="background:skyblue; width:309px;height:50px; margin-left:487px;margin-top:30px;line-height:50px;font-size:15px;"><strong>已添加的品相</strong></label>
 </div>
<br/>
<%
	Greens_ConditionDao dao = new Greens_ConditionDao();
	List<Greens_Condition> list = dao.findAll();
	for(Greens_Condition greens_Condition : list){
		String pingxiang = greens_Condition.getGreens_Condition();
%>
<div class="layui-input-inline" style="margin-left:487px;width:300px;height:50px;margin-top:15px;line-height:50px;font-size:13px;">
	<strong><input type="text" lay-verify="required" required name="leixin" readonly="readonly" id="firstname" class="layui-input" style="text-align:center;background:orange;" value="<%=pingxiang %>"></strong></strong>
</div>

<br/>
<%
	}
%>

</form>
</body>
</html>