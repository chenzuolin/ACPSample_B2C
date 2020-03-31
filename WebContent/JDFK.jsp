<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%@page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="./css/layui.css">
 <link rel="stylesheet" href="./layui/css/layui.css">
 <style type="text/css">
td{
	word-break:keep-all;
	white-space:nowrap;
	overflow:hidden;
	text-overflow:ellipsis;
}


 
 </style>
</head>
<body  >
<form action="">
<table class="layui-table" style=" width:80%; margin-left:10%; table-layout: fixed;" >
	<tr>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>投诉编号</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>回复内容</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>回复时间</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>功能操作</strong></th>
	</tr>
<%
	FedbackDao dao = new FedbackDao();
	List<Fedback> list = dao.findAll();
	for(Fedback fedback : list){
		int aa = fedback.getFedback_ID();
%>
	<tr>
		<td style="text-align:center;"><%=fedback.getFedback_ID() %></td>
		<td style="text-align:center;"><%=fedback.getFedback_Content() %></td>
		<td style="text-align:center;"><%=fedback.getFedback_Time() %></td>
		<td style="text-align:center;"><a href="jdfkServlet?id=<%=aa %>"style="color:red;" ><i class="layui-icon">&#xe640;</i>删除</a></td>
	</tr>		
			
	<%
	}
	%>
	</table>
</form>
</body>
</html>