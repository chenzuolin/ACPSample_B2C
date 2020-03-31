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
<link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
<style>
	th{ color:black}
	td{color:black;text-align: center;}
</style>
</head>
<body>
		<div class="layui-card">
  <div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;">已接收订单
  </div>
</div>
<table  class="layui-table"  style="table-layout: fixed; width: 80% ;margin-left: 10%;">
	<tr background="red">
		<th>订单编号</th>
		<th>订单时间</th>
		<th>订单状态</th>
		<th>订单详情</th>
		<th>操作</th>
	</tr>
		
	<%
	IndentDao dao = new IndentDao();
	List<Indent> list1 = dao.findAll();
	for(Indent indent : list1){
		if(indent.getIndent_Status().contains("正在分拣")){
		int aa = indent.getIndent_ID();
		String bb = indent.getIndent_Time();
		String cc = indent.getIndent_Status();		
%>
	<tr>
		<td><%=aa %></td>
		<td><%=bb %></td>
		<td><%=cc %></td>
		<td><a href="Greens_JobberIndent5.jsp?id=<%=aa %>"  class="layui-btn" style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;"  >查看订单</a></td>
		<td><a href="GreensJobberIndexServlet1?id=<%=aa %>"  class="layui-btn" style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" >分拣完毕</a>
		<%
}else{
}
	}
	
%>
</table>
</body>
</html>