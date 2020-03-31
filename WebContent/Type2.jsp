
	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<title>Insert title here</title>

</head> 
<style type="text/css">
	.ss{width: 258px; border-right: 1px solid black;border-bottom: 1px solid black;display: block;float: left;height: 40px;font-size: 20px;line-height: 20px;white-space: pre-wrap;padding: 2px;}
</style>
<body >

 <button class="layui-btn" type="submit" style=" width:121px; background:#00adff; margin-left:136px;" onclick='javascript:window.print()'><i class="layui-icon"></i>打印</button>
<h3>葱姜蒜</h3>	
<div id="dd" style="width: 794px;border: 1px solid black;height:1060px;">
	
<%

XiaoJiDao dao = new XiaoJiDao();
List<GreensXiaoJi> list = dao.findAll("葱姜蒜");
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