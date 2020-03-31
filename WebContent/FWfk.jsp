<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*"%>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/layui.css">
 <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<table class="layui-table" style=" width:80%; margin-left:10%; table-layout: fixed;">
		<tr>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>投诉名称</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>投诉内容</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>投诉类型</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>投诉时间</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>功能操作</strong></th>
		</tr>
<%
	ComplainantDao dao = new ComplainantDao();
	List<Complainant> list = dao.findAll();
	for(Complainant complainant :list){
		if(complainant.getComplainant_Type().contains("商品")){
		}else{
			WineshopDao dao1 = new WineshopDao();
			String name = dao1.findUserByID1(complainant.getWineshop_ID());
			int id = complainant.getWineshop_ID();
			int zz = complainant.getComplainant_ID();
			String aa = complainant.getComplainant_Type();
			String con = complainant.getComplainant_Content();
			String time = complainant.getComplainant_Time();
%>
	
		<tr>
			<td style="text-align:center;"><%=name %></td>
			<td style="text-align:center;"><%=con %></td>
			<td style="text-align:center;"><%=aa %></td>
			<td style="text-align:center;"><%=time %></td>
			<td style="text-align:center;">
				<a href="fk.jsp?id=<%=id %>" title="回复" style="color:skyblue;" ><i class="layui-icon">&#xe611;</i>回复</a>
				<a href="fkdeServlet?id=<%=zz %>" title="删除" style="margin-left:10px;color:red;"><i class="layui-icon">&#xe640;</i>删除</a>
		</tr>
<%
		}
	}
%>

</table>
</body>
</html>