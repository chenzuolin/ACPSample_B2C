<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/layui.css">
</head>
<style>
	th{color: black;}
	td{color:black}
</style>
<body>
	<%
		int n = (Integer)request.getSession().getAttribute("id");
		IndentDao dao1 = new IndentDao();
		OrderDao dao2 = new OrderDao();
		List<Indent> list1 = dao1.findAll();
		for(int i=0;i<list1.size();i++){
			if(list1.get(i).getIndent_Status().contains("已完成")){
				
			}else{
			if(list1.get(i).getWineshop_ID() == n){
			int c = list1.get(i).getIndent_ID();
			//System.out.print(c);
			%>
	<table  class="layui-table"   style="table-layout: fixed; width: 100% ;">
	<tr >
			<tr ><th >订单编号：<%=c %></th>
				<th></th>
			</tr>
			
			<%
		List<Order> list2 = dao2.findUserByID1(c);
		
			
				for(Order order : list2){
				int indent_ID = order.getIndent_ID();
				int Greens_ID = order.getGreens_ID();
				int number = order.getNumber();
				
				GreensDao dao3 = new GreensDao();
				String name = dao3.findUserByID1(Greens_ID);
				%>
				<tr ><th  width="400px"  >蔬菜名称：</th>
				<th  id="th">数量：</th></tr>
				<tr>
				<td><%=name %></td>
				
			
				<td ><%=number %></td></tr>
				<br/>
				
				
				<%
				}
				%>
				<%
				for(int j=0;j<list2.size();j++){
					Order order = list2.get(j);
					String status = list2.get(j).getIndent_Status();
					request.getSession().setAttribute("status", status);
				}
					%>
					<%
						String status = (String)request.getSession().getAttribute("status");
					%>
				<tr><th>物流状态：</th><th>操作</th></tr><tr><td><%=status %></td><td height="20px" ><input class="layui-btn" style="height: 30px;padding: 0;margin: 0;font-size: 8px; line-height: 30px;width: 60px;" type="button"  value="确认收货" onclick="window.location.href='WineshopIndexServlet?id=<%=c %>'"></td></tr>
				</tr>
				
	
					
					<%
				}
			}
		}
	%>
	</table>
		
</body>
</html>