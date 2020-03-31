<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.sec.dao.CourierDao" %>
<%@ page import="com.sec.dao.WineshopDao" %>
<%@ page import="com.sec.entity.Courier" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sec.entity.Wineshop" %>
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
  	<div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;text-align:center">快递员分配</div>
  	<table class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;" >
    <tr>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>分配编号</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>快递员名称</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>联系电话</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>注册时间</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>运输类型</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>分配</strong></th> 
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>分配管理</strong></th>
    </tr>
    	<%
    		CourierDao Dao=new CourierDao();
    		WineshopDao Dao1=new WineshopDao();
    		List<Courier> list=Dao.findAll();
    		List<Wineshop> list1=Dao1.findAll1();
    		System.out.print(list);
    		System.out.print(list1);
    		if(list == null || list.size()<1){
    			out.print("集合为空");
    		}else{
    			for(Courier courier:list){
    				int id=courier.getCourier_ID();
    				String name=courier.getCourier_Name();
	    			String telephone=courier.getCourier_Telephone();
	    			String date=courier.getCourier_Time();
	    			String type=courier.getCourier_Vehicle();
    	%>
		    <tr>
		          <td style="text-align:center;"><%=id %></td>
			      <td style="text-align:center;"><%=name %></td>
			      <td style="text-align:center;"><%=telephone %></td>
			      <td style="text-align:center;"><%=date %></td>
			      <td style="text-align:center;"><%=type %></td>
			      <td style="text-align:center;"><a href="fenpei1.jsp?id=<%=id %>" class="layui-btn"style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;"><i class="layui-icon">&#xe631;</i>分配</a></td>
			      <td style="text-align:center;"><a href="Fenpei1Servlet?id=<%=id %>" class="layui-btn"style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;"><i class="layui-icon">&#xe631;</i>查看分配</a></td>
		    </tr>
		<%	
				}
			}
		%>
  </table>
</form>
</body>
</html>