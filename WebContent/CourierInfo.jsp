<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.sec.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>快递员订单信息综合</title>
<style type="text/css">
body p {
	font-weight: bold;
}
</style>
</head>
<body>
<form action="CourierStatusServlet" method="post">

  <table width="1200px"  border="1" align = "center">
   <tr bgcolor = "yellow">
   <th>订单编号</th>
   <th>订单时间</th>
   <th>配送时间</th>
   <th>客户编号</th>
   <th>配送地址</th>
   <th>运费</th>
   <th>结账类型</th>
   <th>联系电话</th>
   <th>状态</th>
   <th>快递员编号</th>
   <th>快递员密码</th>
   <th>快递员姓名</th>
   <th>快递员电话</th>
   <th>快递员姓名</th>
   <th>区域编号</th>
   <th>交通工具</th>
   </tr>
   <%
List<Courier> list = (List<Courier>)request.getAttribute("list");
List<Indent> lis = (List<Indent>)request.getAttribute("lis");
if (list == null || list.size() < 1) {
	out.print("没有数据！");
} else {
	for(Courier courier : list){
if (lis == null || lis.size() < 1){
	out.print("没有数据！");
} else {
	for(Indent indent : lis){

%>
    	<tr bgcolor = "red" align="center" >
    	  <td><input type="text" name="Indent_ID" value="<%=indent.getIndent_ID() %>"></td>
    	  <td><input type="text" name="Indent_Time" value="<%=indent.getIndent_Time() %>"></td>
    	  <td><input type="text" name="Indent_Distribution_Time" value="<%=indent.getIndent_Distribution_Time() %>"></td>
    	  <td><input type="text" name="Wineshop_ID" value="<%=indent.getWineshop_ID() %>"></td>
    	  <td><input type="text" name="Wineshop_Address" value="<%=indent.getWineshop_Address() %>"></td>
    	  <td><input type="text" name="Indent_Fare" value="<%=indent.getIndent_Fare() %>"></td>
    	  <td><input type="text" name="Indent_Check_Type" value="<%=indent.getIndent_Check_Type() %>"></td>
    	  <td><input type="text" name="Wineshop_Telephone" value="<%=indent.getWineshop_Telephone() %>"></td>
    	  <td><input type="text" name="Indent_Status" value="<%=indent.getIndent_Status() %>"></td>

          <td><input type="text" name="Courier_ID" value="<%=courier.getCourier_ID() %>"></td>
    	  <td><input type="text" name="Courier_Password" value="<%=courier.getCourier_Password() %>"></td>
    	  <td><input type="text" name="Courier_Name" value="<%=courier.getCourier_Name() %>"></td>
    	  <td><input type="text" name="Courier_Telephone" value="<%=courier.getCourier_Telephone() %>"></td>
    	  <td><input type="text" name="Courier_Time" value="<%=courier.getCourier_Time() %>"></td>
    	  <td><input type="text" name="Regionality_ID" value="<%=courier.getRegionality_ID() %>"></td>
    	  <td><input type="text" name="Courier_Vehide" value="<%=courier.getCourier_Vehicle() %>"></td> 
    	</tr>  
     <%}
	
	
}
	}
	}%>


</table>
</form>
</body>
</html>