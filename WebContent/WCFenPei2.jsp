<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.sec.dao.FenPeiDao" %>
<%@ page import="com.sec.entity.FenPei" %>
<%@ page import="java.util.*" %>

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
  	<div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;text-align:center">酒店收货员分配</div>
  	<table class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;" >
    <tr>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>酒店编号</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>酒店名称</strong></th>
      
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>酒店收货员登录名</strong></th> 
       <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>登录密码</strong></th>
       <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>联系电话</strong></th>
     
    </tr>
    	<%
    	
    	
    String Wineshop_ID = request.getParameter("id");
    	int aa = Integer.parseInt(Wineshop_ID);
    	
    		FenPeiDao dao = new FenPeiDao();
    		List<FenPei> list = dao.Select(aa);
    		if(list.size() == 0){
    			out.print("<script>alert('该酒店还没有分配收货员那！！！！');window.location='WCFenPei.jsp' </script>");
    			
    		}
    		for(FenPei fenpei : list){
    			int a = fenpei.getWineshop_ID();
    			String b = fenpei.getWineshop_Name();
    			String c = fenpei.getFenPei_UserName();
    			String d = fenpei.getFenPei_Password();
    			String e = fenpei.getFenPei_Telephone();
    			
    			
    		
    	%>
		    <tr>
		          <td style="text-align:center;"><%=a %></td>
			      <td style="text-align:center;"><%=b %></td>
			      <td style="text-align:center;"><%=c %></td>
			      <td style="text-align:center;"><%=d %></td>
			      <td style="text-align:center;"><%=e %></td>
			      
			      
		    </tr>
		<%	
    		}
		%>
  </table>
</form>
</body>
</html>