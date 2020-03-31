<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="java.sql.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/layui.css" />

</head>
<body>
<form action="GreensJobberIndexServlet" method="post">
	<%
		IndentDao dao1 = new IndentDao();
		OrderDao dao3 = new OrderDao();
		List<Indent> list1 = dao1.findAll();
		for(int i=0;i<list1.size();i++){
			Indent indent = list1.get(i);
			if(list1.get(i).getIndent_Status().contains("正在分拣")){
		
		WineshopDao dao = new WineshopDao();
		//System.out.print(list1.get(i).getWineshop_ID());
		String name = dao.findUserByID1(list1.get(i).getWineshop_ID());
		//System.out.print(name);
		int id = indent.getIndent_ID();
		String status = indent.getIndent_Status();
		
		List<Order> list2 = dao3.findUserByID1(id);
		%>
		<table class="layui-table">
		<tr><th>订单编号</th>
		<th>酒店名称</th>
		<th>物流状态</th></tr>
		<tr><td><%=id %></td><td><%=name %></td><td><%=status %></td></tr>
		
		
		
		<br/>
		<%
		for(Order order : list2){
			int GreensID = order.getGreens_ID();
			GreensDao dao2 = new GreensDao();
			String GreensName = dao2.findUserByID1(GreensID);
			int num = order.getNumber();
			%>
			<tr><th>蔬菜名称</th>
			<th>商品数量</th></tr>
			<tr><td><%=GreensName %></td><td><%=num %></td></tr>
		
			<br/>
			<%
		}
			%>
			<%
			for(int j=0;j<list2.size();j++){
				String address = indent.getWineshop_Address();
				String tel = indent.getWineshop_Telephone();
				String time = indent.getIndent_Time();
		request.getSession().setAttribute("time", time);
		request.getSession().setAttribute("address", address);
		request.getSession().setAttribute("tel", tel);
		}
	%>
	
	<%
		String time = (String)request.getSession().getAttribute("time");
		String address = (String)request.getSession().getAttribute("address");
		String tel = (String)request.getSession().getAttribute("tel");
	%>
	<tr><th>下单时间</th>
	<th>配送地址</th>
	<th>联系电话</th></tr>
	<tr><td><%=time %></td>
	<td><%=address %></td>
	<td><%=tel %></td></tr>

	<br/>
	<td></td>
		<td></td>
	<td>
	<INPUT TYPE="button"  class="layui-btn"  style="margin: 0; padding: 0; height: 30px; width: 60px; line-height: 30px;"   value="分拣完毕" onclick="window.location.href='GreensJobberIndexServlet?id=<%=id %>'" id="<%=id %>" >
</td>
		</table>
	<br/>
	<%
			}
		}
	%>
	
</form>
</body>
</html>
