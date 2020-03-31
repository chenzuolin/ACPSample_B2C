<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./layui/css/layui.css">
<title>Insert title here</title>
</head>
<body>
<form action="">
	<table class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;">
		<tr>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>快递员编号</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>快递员名称</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>所属酒店</strong></th>
			<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>功能操作</strong></th>
		</tr>
		<%
			List<Courier_Wineshop> list=(List<Courier_Wineshop>)request.getAttribute("list");
			List<Courier> list1=(List<Courier>)request.getAttribute("list1");
			if(list == null || list.size()<1){
				out.print("<script language='javascript'>alert('暂无分配！');window.location.href='fenpei.jsp'</script>");
			}else{
				for(Courier_Wineshop courier_wineshop : list){
					if(list1 == null || list1.size()<1){
						out.print("<script language='javascript'>alert('暂无分配！');window.location.href='fenpei.jsp'</script>");
					}else{
						for(int i=0;i<list1.size();i++){
							Courier courier=list1.get(i);
							int ID=courier_wineshop.getCourier_Wineshop_ID();
							String name1=courier.getCourier_Name();
							String name=courier_wineshop.getAllot();
			
			%>
		<tr>
			<td style="text-align:center;"><%=ID %></td>
			<td style="text-align:center;"><%=name1 %></td>
			<td style="text-align:center;"><%=name %></td>
			<td style="text-align:center;">
				<a href="Fenpei2Servlet?id=<%=ID%>" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>
			</td>
		</tr>
		<%		}
			}
		}
	}
		%>
	</table>
</form>

</body>
</html>