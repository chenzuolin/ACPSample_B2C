<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	.ss{width:158.5px; border-right: 1px solid black;border-bottom: 1px solid black;display: block;float: left;height: 40px;font-size: 20px;line-height: 20px;white-space: pre-wrap;padding: 2px;}
</style>
<link rel="stylesheet" href="./layui/css/layui.css">
<title>Insert title here</title>
</head>
<body>
<form action="">
	<div class="layui-card">
  <div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;">待分蔬菜小计
  </div>
</div>

	
	
	<div class="layui-inline">
		<div class="layui-input-inline">
			<button class="layui-btn" type="submit" style=" width:121px; background:#00adff; margin-left:136px;" onclick='javascript:window.print()'><i class="layui-icon"></i>打印</button>
		</div>	
		<div class="layui-input-inline">
			<a class="layui-btn" type="submit" style=" width:121px; background:red; margin-left:136px;" href="Type1.jsp"><i class="layui-icon"></i>根茎类</a>
		</div>	
		<div class="layui-input-inline">
			<a class="layui-btn" type="submit" style=" width:121px; background:red; margin-left:136px;" href="Type2.jsp"><i class="layui-icon"></i>葱姜蒜</a>
		</div>	
		<div class="layui-input-inline">
			<a class="layui-btn" type="submit" style=" width:121px; background:red; margin-left:136px;" href="Type3.jsp"><i class="layui-icon"></i>豆质类</a>
		</div>	
		<div class="layui-input-inline">
			<a class="layui-btn" type="submit" style=" width:121px; background:red; margin-left:136px;" href="Type4.jsp"><i class="layui-icon"></i>海产品</a>
		</div>	
	</div>
	<div class="layui-inline" style="margin-top:15px">
		<div class="layui-input-inline">
		<a class="layui-btn" type="submit" style=" width:121px; background:red; margin-left:136px;" href="Type5.jsp"><i class="layui-icon"></i>菌菇类</a>
		</div>	
		
		<div class="layui-input-inline">
			<a class="layui-btn" type="submit" style=" width:121px; background:red; margin-left:136px;" href="Type6.jsp"><i class="layui-icon"></i>辣椒类</a>
		</div>	
		<div class="layui-input-inline">
			<a class="layui-btn" type="submit" style=" width:121px; background:red; margin-left:136px;" href="Type7.jsp"><i class="layui-icon"></i>茄果类</a>
		</div>	
		<div class="layui-input-inline">
			<a class="layui-btn" type="submit" style=" width:121px; background:red; margin-left:136px;" href="Type8.jsp"><i class="layui-icon"></i>鲜花类</a>
		</div>
		<div class="layui-input-inline">
			<a class="layui-btn" type="submit" style=" width:121px; background:red; margin-left:136px;" href="Type9.jsp"><i class="layui-icon"></i>叶菜类</a>
		</div>	
	</div>
</table>
</form>

<div id="dd" style="width: 794px;border: 1px solid black;height:1060px;">
	
<%

XiaoJiDao dao = new XiaoJiDao();
List<GreensXiaoJi> list = dao.findAll1();
for(GreensXiaoJi xj : list){
	String name = xj.getGreens_Name();
	int num = xj.getNumber();
	String bb = xj.getGreens_Unit();
	%>
	
	
<span class="ss"><%=name %>&nbsp<%=num %><%=bb %><input type="checkbox" name="" id="" value="" /></span>




		
		
	
		
	

	
   <%
   
		}
	
	%>
	
	</div>
		
</body>
</html>