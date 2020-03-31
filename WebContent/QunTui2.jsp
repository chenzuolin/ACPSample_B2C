<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<%
String a = request.getParameter("Wineshop_CID");//穿过来的CID
System.out.print(a+"a");
%>
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

	
  	<div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;text-align:center">查看已推送消息</div>
  	<table class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;" >
    <tr>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>酒店名称</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>推送标题</strong></th>
      
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>推送内容</strong></th> 
       <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>推送地址</strong></th>
       
     
    </tr>
    	<%
    	
   		QunTuiDao dao = new QunTuiDao();
   		WineshopDao dao1 = new WineshopDao();
    	List<QunTui> list = dao.findUserByID2(a);
    	for(QunTui quntui : list){
    		String b = quntui.getWineshop_UserName();
    		int c = dao1.findUserByID2(b);
    		String e = quntui.getQunTui_Title();//消息的标题
    		String f = quntui.getQunTui_Text();//消息的内容
    		String g = quntui.getQunTui_Adress();//消息的地址
    		List<Wineshop> list1 = dao1.findUserByID(c);
    		for(Wineshop wineshop : list1){
    			String d = wineshop.getWineshop_Name();//查出酒店名称
    		
    		
    	
    		
    			
    		
    	%>
		    <tr>
		          <td style="text-align:center;"><%=d %></td>
			      <td style="text-align:center;"><%=e %></td>
			      <td style="text-align:center;"><%=f %></td>
			      <td style="text-align:center;overflow:auto" ><%=g %></td>
			      
			      
			      
		    </tr>
		<%	
    		}
    		}
    	
		%>
  </table>

</body>
</html>