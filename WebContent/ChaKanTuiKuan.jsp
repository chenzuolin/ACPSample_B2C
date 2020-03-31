<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.sec.dao.WineshopDao" %>
<%@ page import="com.sec.dao.IndentDao" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sec.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css" />
<style type="text/css">
	th{color: black;}
</style>
</head>
<body>
<form name="form1" method="post" action="">
	<div class="layui-card">
  	<div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;text-align:center">订单退款查询</div>
  	<table class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;" >
    <tr>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单编号</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>购买时间</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>酒店名称</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>酒店地址</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>联系电话</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>支付类型</strong></th> 
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>商户订单号</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>退款原因</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>退款管理</strong></th>
    </tr>
    
    
   
    	<%
    	IndentDao dao =  new IndentDao();
    	List<Indent> list = dao.findAll8();  
    	for(Indent indent : list){
    		int Indent_Id  = indent.getIndent_ID();
    		String Indent_Time = indent.getIndent_Time();
    		int Wineshop_ID = indent.getWineshop_ID();
    		String Wineshop_Address = indent.getWineshop_Address();
    		String Wineshop_Telephone = indent.getWineshop_Telephone();
    		String Indent_Type = indent.getIndent_Type();
    		String Indent_PayID = indent.getIndent_PayID();
    		String Indent_Why = indent.getIndent_Why();
    		WineshopDao dao1 = new WineshopDao();
    		String Wineshop_Name = dao1.findUserByID1(Wineshop_ID);
    		
    		
    	
    		
    	%>
		    <tr>
		          <td style="text-align:center;"><%=Indent_Id %></td>
			      <td style="text-align:center;"><%=Indent_Time %></td>
			      <td style="text-align:center;"><%=Wineshop_Name %></td>
			      <td style="text-align:center;"><%=Wineshop_Address %></td>
			      <td style="text-align:center;"><%=Wineshop_Telephone %></td>
			      <td style="text-align:center;"><%=Indent_Type %></td>
			      <td style="text-align:center;overflow:auto"><%=Indent_PayID %></td>
			      <td style="text-align:center;overflow:auto"><%=Indent_Why %></td>
			       <td style="text-align:center;"><a href="ChaXunTuiKuanServlet?id=<%=Indent_Id %>" class="layui-btn"style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;"><i class="layui-icon">&#xe631;</i>退款完毕</a></td>
		    </tr>
		<%
    	}
		%>
  </table>
</form>
</body>
</html>