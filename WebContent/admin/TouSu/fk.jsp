<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link rel="stylesheet" href="./layui/layui.css" />
<style>
	.layui-input{
		word-break:keep-all;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	fieldset{
		margin-left:200px;
		margin-right:200px;
		margin-top:140px;
		
	}
	legend{
		font-size:20px;
	}
</style>
</head>
<body>
<form  class="layui-form-pane" name="form1" method="post" action="FKServlet1" >
		<%
			WineshopDao dao = new WineshopDao();
		String name = request.getParameter("name");
			
			int id1 = Integer.parseInt(request.getParameter("id"));
			System.out.println(id1+"id1");
			System.out.println(name+"name");
	    %>
	     <input type="text" style="display:none" value="<%=id1 %>" name="bb">
<fieldset>
   <legend>反馈信息</legend>
<div class="layui-inline">
	<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:300px;width:121px;margin-top:15px;"><strong>反馈名称</strong></label>
    	<div class="layui-input-inline" style="margin-left:-4px; width:247px;margin-top:15px;">
		  	<input type="text" required name="s1" lay-verify="required" style="text-align:center;" readonly="readonly" class="layui-input" value="<%=name %>">  		
	    </div>
</div>
<br/>
<div class="layui-inline">
	<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:300px;width:121px;margin-top:30px;"><strong>反馈内容</strong></label>
    	<div class="layui-input-inline" style="margin-left:-4px; width:247px;margin-top:30px;">
		  	<input type="text"  name="cc" required name="desc" lay-verify="required" style="text-align:center;" placeholder="请输入反馈内容" class="layui-input">  		
	    </div>
</div>
  <div class="layui-form-item">
      <div class="layui-input-block" style="margin-left:355px;margin-top:30px;">
        <button class="layui-btn" type="submit" style="width:121px;">确认提交</button>
        <button class="layui-btn" type="reset" style="width:121px;">重新填写</button> 
      </div>    
  </div>
 </fieldset>

</form>
</body>
</html>