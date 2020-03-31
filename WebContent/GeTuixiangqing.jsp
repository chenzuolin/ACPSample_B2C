<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="com.sec.dao.GeTuiDao" %>
<%@ page import="com.sec.entity.GeTui" %>
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

	
  	<div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;text-align:center">查看已推送消息</div>
  	<table class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;" >
    <tr>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>推送编号</strong></th>
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>推送标题</strong></th>
      
      <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>推送内容</strong></th> 
       <th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>推送地址</strong></th>
       
     
    </tr>
    	<%
    	
   GeTuiDao dao = new GeTuiDao();
    	List<GeTui> list  = dao.findAll();
    	for(GeTui getui : list){
    		int  a = getui.getGeTui_ID();
    		String b = getui.getGeTui_Title();
    		String c = getui.getGeTui_Text();
    		String d = getui.getGeTui_Adress();
    		
    			
    		
    	%>
		    <tr>
		          <td style="text-align:center;"><%=a %></td>
			      <td style="text-align:center;"><%=b %></td>
			      <td style="text-align:center;"><%=c %></td>
			      <td style="text-align:center;overflow:auto" ><%=d %></td>
			      
			      
			      
		    </tr>
		<%	
    		}
		%>
  </table>

</body>
</html>