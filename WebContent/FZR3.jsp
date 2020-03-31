<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@page import="java.util.*"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./layui/css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int aaa = Integer.parseInt(request.getParameter("id"));
		String bbb = null;
		IndentDao daos = new IndentDao();
		List<Indent> lists = daos.findUserByID(aaa);
		for(Indent indent : lists){
			String b = indent.getIndent_Status();
			String c = indent.getWineshop_Address();
			String d = indent.getWineshop_Telephone();
		%>
		订单编号：<%=aaa %>
		订单状态：<%=b %>
		酒店地址：<%=c %>
		酒店电话：<%=d %>
		<%
			int e = indent.getWineshop_ID();
			WineshopDao daoo = new WineshopDao();
			List<Wineshop> list5 = daoo.findUserByID(e);
			for(Wineshop wineshop : list5){
				bbb = wineshop.getWineshop_Name();
			}
		}
		FZDao dao = new FZDao();
		List<FZ> list = dao.findUserByID(aaa);
		for(FZ fz :list){
			String aa = fz.getXD_Time();
			String bb = fz.getCG_Name();
			String cc = fz.getCG_Time();
			String dd = fz.getFJ_Name();
			String ee = fz.getFJ_Time();
			String ff = fz.getCourier_Name();
			String gg = fz.getPS_Time();
			String hh = fz.getFinish_time();
			String ii = fz.getFenPei_UserName();
			String oo = fz.getFenPei_Time();
			String pp = fz.getAddress();
	%>
	下单酒店：<%=bbb %>
	下单时间：<%=aa %>
	采购员：<%=bb %>
	采购时间：<%=cc %>
	分拣员：<%=dd %>
	分拣时间：<%=ee %>
	快递员：<%=ff %>
	配送时间：<%=gg %>
	收货人：<%=ii %>
	收货时间：<%=oo %>
	收货地点：<%=pp %>
	<%
		}
	%>
	
</body>
</html>