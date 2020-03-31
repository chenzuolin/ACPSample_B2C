<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String Wineshop_CID = request.getParameter("Wineshop_CID");
    	System.out.print(Wineshop_CID);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="layui-v2.3.0/layui/css/layui.css" rel="stylesheet" media="all">
  <script src="layui-v2.3.0/layui/layui.all.js"></script>
<title>Insert title here</title>
<style>

	legend{
		font-size:20px;
	}
</style>
</head>
<body>
<form action="getuiServelt1" method="Get" class="layui-form">
<fieldset>
   <legend>通知栏消息推送</legend>
   
   <div class="layui-form-item">
    <label class="layui-form-label">推送标题</label>
    <div class="layui-input-block">
      <input type="text" name="GeTuiTitle" required  lay-verify="required" placeholder="请输入推送标题" autocomplete="off" class="layui-input">
      <input type="text" name="Wineshop_CID" value="<%=Wineshop_CID %>" style="display:none;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">推送内容</label>
    <div class="layui-input-block">
      <input type="text" name="GeTuiText" required  lay-verify="required" placeholder="请输入推送内容" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">推送地址</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入推送地址" name="GeTuiAdress" class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" type="submit">立即提交</button>
      
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
     <a href="GeTuixiangqing.jsp?" class="layui-btn layui-btn-primary">查看已推送消息</a>
    </div>
  </div>
</fieldset>
</form>
</body>
</html>