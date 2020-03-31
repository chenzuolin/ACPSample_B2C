<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%
	int id = (Integer)request.getSession().getAttribute("id");
	WineshopDao Dao = new WineshopDao();
	List<Wineshop> list = Dao.findUserByID(id);
	for(Wineshop cc : list){
		String username = cc.getWineshop_UserName();
		String name = cc.getWineshop_Name();
		String address = cc.getWineshop_Address();
		String fname = cc.getWineshop_Shift_Name();
		String Tel = cc.getWineshop_Telephone();
		String nature = cc.getWineshop_Nature();
		String qq = cc.getWineshop_QQ();
		String weixin = cc.getWineshop_WeChat();
		String sum = cc.getWineshop_Number();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/layui.css">
<link rel="stylesheet" href="css/xadmin.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>酒店基本信息</title>
<style type="text/css">
	.layui-table tbody tr:hover{
		background:rgb(0,150,136);
	}
	fieldset{
		margin:10px 10px;
	}
</style>
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
                            <th>店铺地址</th>
                            <td><%=address %></td></tr>
                        <tr>
                            <th>负责人</th>
                            <td><%=fname %></td></tr>
                        <tr>
                            <th>联系电话</th>
                            <td><%=Tel %></td></tr>
                        <tr>
                            <th>酒店性质</th>
                            <td><%=nature %></td></tr>
                        <tr>
                            <th>酒店&nbsp;Q&nbsp;Q</th>
                            <td><%=qq %></td></tr>
                        <tr>
                            <th>酒店微信</th>
                            <td><%=weixin %></td></tr>
                        <tr>
                            <th>证件编号</th>
                            <td><%=sum %></td></tr>
                    </tbody>
                </table>
            </div>
        </fieldset>
        <%
      		  }
        %>
</body>
</html>