<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<style>
th{text-align:center !important;}
td{text-align:center}

</style>


</head>
<body>
<table class="layui-table">
<tr>
<th colspan="7" style="font-size:20px;color:black;border:none"><strong>速盟快线配送平台销售订单</strong></th>
</tr>
	<%
				String name = request.getParameter("name");
    		//	int aa = Integer.parseInt(request.getParameter("name"));//酒店ID
    			int bb = Integer.parseInt(request.getParameter("id"));//订单ID
    			System.out.print(name+"name");
    			System.out.print(bb+"bb");
    			
    			WineshopDao dao = new WineshopDao();
    			int aa = dao.findUserByID100(name);
    			List<Wineshop> list = dao.findUserByID(aa);
    			for(Wineshop wineshop : list){
    				String cc = wineshop.getWineshop_Name();//酒店名称
    				String dd = wineshop.getWineshop_Address();//酒店地址
    				String ee = wineshop.getWineshop_Telephone();//联系电话
    				String ff = wineshop.getWineshop_Shift_Name();//负责人
    %>
  <tr>
  <th style="border:none">酒店名称:<%=cc %></th>
  <th style="border:none">酒店地址:<%=dd %></th>
  <th style="border:none">  联系电话:<%=ee %></th>
  <th style="border:none">  负责人:<%=ff %></th>
  <%
    			}
    			IndentDao dao3 = new IndentDao();
    			List<Indent> list3 = dao3.findUserByID(bb);
    			for(Indent indent : list3){
    				String hh = indent.getIndent_Status();//订单状态
    				String oo = indent.getIndent_Time();//下单时间
    				%>
    				<th style="display:none">订单状态:<%=hh %></th> 
    				 <th style="border:none"> 下单时间:<%=oo %> </th> 
    				 </tr>
    				<%
    			}
    			
    			
    			
    %>

    <table class="layui-table">
    						<tr>
    						<th style="color:black;font-size:16px;"><strong>序号</strong></th>
    							<th  style="color:black;font-size:16px;"><strong>蔬菜名称</strong></th>
    							<th  style="color:black;font-size:16px;"><strong>市场价</strong></th>
    							<th  style="color:black;font-size:16px;"><strong>速盟价</strong></th>
    							<th  style="color:black;font-size:16px;"><strong>蔬菜数量</strong></th>
    							<th  style="color:black;font-size:16px;"><strong>小计</strong></th>
    							<th  style="color:black;font-size:16px;"><strong>备注</strong></th>
    						</tr>
    <%
    			
    			
    			
    			OrderDao dao5 = new OrderDao();
    			List<Order> list5 = dao5.findUserByID1(bb);
    			for(int i=0;i<list5.size();i++){
    				int ii = list5.get(i).getGreens_ID();//蔬菜ID
    				float nn = list5.get(i).getGreens_Price();
    		String numb = list5.get(i).getOrder_Remark();
    				int k = 0;
    				k = i + 1;
    				if(numb ==null){
    					numb = "";
    				}
    				int jj = list5.get(i).getNumber();//蔬菜数量
    				GreensDao dao6 = new GreensDao();
    				List<Greens> list6 = dao6.findUserByID(ii);
    				for(Greens greens : list6){
    					String kk = greens.getGreens_Name();//蔬菜名称
    					String ll = greens.getGreens_Unit();//蔬菜单位
    					float mm = greens.getGreens_Market_Price();//
    					float num = jj*nn;
    					
    					
    					%>
    					
    						<tr>
    						<td><%=k %></td>
    							<td><%=kk %></td>
    							<td><%=mm %>元</td>
    							<td><%=nn %>元</td>
    							<td><%=jj %><%=ll %></td>
    							<td><%=num %>元</td>
    							<td><%=numb %></td>
    						</tr>
    					
    						  
    					
    					<%
    					
    				}
    				
    			}
    			
    			
    			
    	
    %>
   	<tr><td></td>
    						<td></td>
    						<td></td>
    						<td></td>
    						<td></td>
    						<td></td>
    						<td></td>
    						</tr>
    						
    									<tr>
    							
    						<td>蔬菜费用</td>
    						<td colspan="4"> </td> 
    						<%
    						TotalDao dao2 = new TotalDao();
    		    			List<Total> list2 = dao2.findUserByID1(bb);
    		    			for(Total total : list2){
    		    				Float gg = total.getGreens();//订单总价
    						%>
    						<td><%=gg %>元</td>
    						<%
    		    			}
    						%>
    						<td ></td>
    					
    						
    						</tr>
    									<tr>
    							
    						<td>物流费用</td>
    						<td colspan="4"> </td> 
    						<%
    						
    		    			List<Total> list8 = dao2.findUserByID1(bb);
    		    			for(Total total : list8){
    		    				Float gg = total.getFare();//订单总价
    						%>
    						<td><%=gg %>元</td>
    						<%
    		    			}
    						%>
    						<td ></td>
    					
    						
    						</tr>
    						
    							<tr>
    							
    						<td>订单总计</td>
    						<td colspan="4"> </td> 
    						<%
    						
    		    			List<Total> list9 = dao2.findUserByID1(bb);
    		    			for(Total total : list9){
    		    				Float gg = total.getTotal();//订单总价
    						%>
    						<td><%=gg %>元</td>
    						<%
    		    			}
    						%>
    						<td ></td>
    					
    						
    						</tr>
    						<tr>
    						<td >注：</td>
    						<td  colspan="6" ></td>
    					
    						</tr>
    						<tr>
    						<td  colspan="4" style="height:40px;border:none;color:#009688">送货单位及<br/>（经手人签章）</td>
    							<td  colspan="3" style="height:40px;border:none;color:#009688">收货单位及 <br/>（经手人签章）</td>
    					
    						</tr>
</table>
 </table>
 			<button class="layui-btn" type="submit" style=" width:121px; background:#00adff; margin-left:136px;" onclick='javascript:window.print()'><i class="layui-icon"></i>打印</button>
 
</body>
</html>