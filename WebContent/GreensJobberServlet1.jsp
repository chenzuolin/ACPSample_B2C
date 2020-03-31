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


</head>
<body>
<form action="GreensJobberServlet" method="post">
	<%
		IndentDao dao1 = new IndentDao();
		OrderDao dao3 = new OrderDao();
		List<Indent> list1 = dao1.findAll();
		for(int i=0;i<list1.size();i++){
			Indent indent = list1.get(i);
		
		WineshopDao dao = new WineshopDao();
		//System.out.print(list1.get(i).getWineshop_ID());
		String name = dao.findUserByID1(list1.get(i).getWineshop_ID());
		//System.out.print(name);
		int id = indent.getIndent_ID();
		String status = indent.getIndent_Status();
		
		List<Order> list2 = dao3.findUserByID1(id);
		%>
		订单编号：<%=id %>
		酒店名称：<%=name %>
		物流状态：<%=status %>
		<br/>
		<%
		for(Order order : list2){
			int GreensID = order.getGreens_ID();
			GreensDao dao2 = new GreensDao();
			String GreensName = dao2.findUserByID1(GreensID);
			int num = order.getNumber();
			%>
			蔬菜名称：<%=GreensName %>
			商品数量：<%=num %>
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
	下单时间：<%=time %>
	配送地址：<%=address %>
	联系电话：<%=tel %>
	<br/>

	<INPUT TYPE="button" value="接收订单" disabled="true">
	<input type="button" id="btn2" value="完成分拣" onclick="window.location.href='GreensJobberIndexServlet?id=<%=id %>'">
	<br/>
	<%
		}
	%>
	
</form>
</body>
</html>
