<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>快递员首页</title>
  <link rel="stylesheet" href="../css/layui.css" />
  <link href="https://cdn.bootcss.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
        table
        {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }
        table td, table th
        {
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
            text-align: center;
        }
        table thead th
        {
            background-color: #CCE8EB;
            width: 100px;
        }
        table tr:nth-child(odd)
        {
            background: #fff;
        }
        table tr:nth-child(even)
        {
            background: #F5FAFA;
        }
         .button{background-image: linear-gradient(#808080, #d3d3d3);
        color: white; font-size:10px; line-height: 20px; width: 70px; height:30px}
    </style>

</head>
<body>
	<form action="GreensJobberServlet" method="post">
		
	

 
   	  <%
		IndentDao dao1 = new IndentDao();
		OrderDao dao3 = new OrderDao();
		List<Indent> list1 = dao1.findAll();
		for(int i=0;i<list1.size();i++){
			Indent indent = list1.get(i);
			if(list1.get(i).getIndent_Status().contains("分拣完毕等待快递员接收")){
		
		WineshopDao dao = new WineshopDao();
		//System.out.print(list1.get(i).getWineshop_ID());
		String name = dao.findUserByID1(list1.get(i).getWineshop_ID());
		//System.out.print(name);
		int id = indent.getIndent_ID();
		String status = indent.getIndent_Status();
		
		List<Order> list2 = dao3.findUserByID1(id);
		%>
        
        
        
             
            	 
            			<table class="table" style="width: 50%;" >
            			<thead><tr>
				<th>订单编号</th>
				<th>酒店名称</th>
				<th>物流状态</th>
		 		<th></th>
				
				</tr>
				</thead>

  			<tr>
  				<td><%=id %></td>
  				<td><%=name %></td>
  				<td><%=status %></td>
  				<td></td>
   				
  				
  			</tr>
<tr>   <%
		for(Order order : list2){
			int GreensID = order.getGreens_ID();
			GreensDao dao2 = new GreensDao();
			String GreensName = dao2.findUserByID1(GreensID);
			int num = order.getNumber();
			%>
			<thead><tr>
			<th>蔬菜名称</th>
				<th>商品数量</th>
				<th></th>
				<th></th>
</tr></thead>
  			<tr>
  			<td><%=GreensName %></td>
  				<td><%=num%></td>
  				<td></td>
  				<td></td>
  			</tr>
  			<thead>
  			<tr> 			<%
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
  				
  				<th>下单时间</th>
	         	<th>配送地址</th>
				<th>联系电话</th>
				<th>操作</th>
  				
  			</tr>
  			</thead>
  			<tr>
  			
  				<td><%=time %></td>
  				<td><%=address %></td>
  				<td><%=tel %></td>
				<td><input type="button"  value="接收订单" onclick="window.location.href='CourierIndent1Servlet?id=<%=id %>'" class="button"></td>
  		<%
			}
else{
			
		}
}
  		%>
  			</tr>
  			</table>
  		</form>
  		</body>
</html>
