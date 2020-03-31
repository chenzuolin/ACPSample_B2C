<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="./css/layui.css">
 <link rel="stylesheet" href="./layui/css/layui.css">
<title>Insert title here</title>
</head>
<body>


<table class="layui-table" style=" width:80%; margin-left:10%; table-layout: fixed;">
<tr>
	<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>酒店名称</strong></th>
	<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>所欠金额</strong></th>
	<th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>功能操作</strong></th>
</tr>




<%
	PriceDao dao = new PriceDao();
	WineshopDao dao1 = new WineshopDao();
	List<Price> list = dao.findAll();
	for(Price price : list){
		int aa = price.getWineshop_ID();
		float bb = price.getPrice_num();
		int cc= price.getPrice_ID();
		List<Wineshop> list1 = dao1.findUserByID(aa);
		for(Wineshop wineshop : list1){
			String name = wineshop.getWineshop_Name();
		
%>
<input type="text"  value="<%=aa %>" style="display:none;" />
<input type="text"  value="<%=cc %>" style="display:none;" />

	<tr>
		<td style="text-align:center;"><%=name %></td>
		<td style="text-align:center;">￥<%=bb %>元</td>
		<td style="text-align:center;">
			<a href="CW1.jsp?id=<%=cc %>&aa=<%=name %>&kk=<%=aa %>" style="color:red;"><i class="layui-icon">&#xe605;</i>确认还款</a>
		</td>
	</tr>
	<%
	}
	}
%>
</table>



</body>
</html>