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
</head>
<body>
<form action="CW1Servlet" method="get" class="layui-form layui-form-pane" >


	<div class="layui-card" style="margin:15px 0;">
		<div class="layui-inline">
<%
	int aa = Integer.parseInt(request.getParameter("id"));
	int zz = Integer.parseInt(request.getParameter("kk"));
	String bb = request.getParameter("aa");

	PriceDao dao = new PriceDao();
	List<Price> list = dao.findUserByID(aa);

	for(Price price : list){
		float cc = price.getPrice_num();
%>
<input type="text" name="yy" value="<%=aa %>" style="display:none;" >
<input type="text" name="cc" value="<%=zz %>" style="display:none;" >
  			<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:30px;width:121px;"><strong>酒店名称</strong></label>
				<div class="layui-input-inline" style="margin-left:-4px;width:280px;">
					<input type="text" required name="aa" lay-verify="required" value="<%=bb %>" class="layui-input">
				</div>
			<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:30px;width:121px;"><strong>修改所欠金额</strong></label>
				<div class="layui-input-inline" style="margin-left:-4px;width:280px;">
					<input type="text" required name="bb" lay-verify="required" value="<%=cc %>" class="layui-input">
				</div>
				<div class="layui-input-inline">
			<button type="submit" class="layui-btn" style="width:121px;margin-left:30px;"><i class="layui-icon"></i>确认修改</button>
		</div>
		</div>
		</div>
	
				
				

<%
	}
%>
</form>
</body>
</html>