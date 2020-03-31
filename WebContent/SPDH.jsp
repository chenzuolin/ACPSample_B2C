<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
			<%
	ShopDao dao = new ShopDao();
	List<Shop> list	 =  dao.findAll();
	for(Shop s : list){
		String aa = s.getShop_Name();
		String bb = s.getShop_Time();
		String cc = s.getShop_Status();
		int dd = s.getWineshop_ID();
		WineshopDao da = new WineshopDao();
		List<Wineshop> lists = da.findUserByID(dd);
		for(Wineshop w : lists){
			String gg = w.getWineshop_Name();
			String ee = w.getWineshop_Address();
			String ff = w.getWineshop_Telephone();
			%>
			酒店名称：<%=gg %><br>
			酒店地址：<%=ee %><br>
			联系电话：<%=ff %><br>
			兑换商品：<%=aa %><br>
			兑换时间：<%=bb %><br>
			状态：<%=cc %><br>
			
<%
		}
	}
%>
</body>
</html>