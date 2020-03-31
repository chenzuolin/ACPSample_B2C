<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="java.sql.*"%>
<%
		int Wineshop_Id = (Integer)request.getSession().getAttribute("id");
		WineshopDao dao = new WineshopDao();
		List<Wineshop> list = dao.findUserByID(Wineshop_Id);
		for(Wineshop wineshop : list){
			String username = wineshop.getWineshop_UserName();
			String name = wineshop.getWineshop_Name();
			String number = wineshop.getWineshop_Number();
			String photo = wineshop.getWineshop_Aptitude();
		
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	.idea{width:100%;height:auto;position: relative;}
	.idea img{width:800px;height:auto;text-align:center;position: absolute;left: calc(50% - 400px);}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/layui.css">
<link rel="stylesheet" href="css/xadmin.css">
</head>
<body>
	 <fieldset class="layui-elem-field">
            <legend>基本信息</legend>
            <div class="layui-field-box">
                <table class="layui-table">
                    <tbody>
                        <tr>
                            <th>登录账号</th>
                            <td><%=username %></td></tr>
                        <tr>
                            <th>店铺名称</th>
                            <td><%=name %></td></tr>
                        <tr>
                            <th>证件编号</th>
                            <td><%=number %></td></tr>
                    </tbody>
                </table>
            </div>
        </fieldset>
         <fieldset class="layui-elem-field">
            <legend>酒店资质</legend>
            	<div class="idea">
            		<img src="http://211.149.232.210/app/jiudianzizhi/<%=photo %>" title="酒店资质" alt="加载中"/>
            	</div>
         </fieldset>
         <%
			}
         %>
</body>
</html>