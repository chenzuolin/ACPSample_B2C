<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div>
<%
	GiveDao dao = new GiveDao();
	List<Give> list = dao.findAll();
	for(Give a : list){
			String cc = null;
			int bb = a.getWineshop_ID();
			WineshopDao daos = new WineshopDao();
			List<Wineshop> lists = daos.findUserByID(bb);
			for(Wineshop w : lists){
				cc = w.getWineshop_Name();
			}
			String dd = a.getGive_Time();
			int ee = a.getGive_Money();
			int ff = a.getGive_Num();
			String gg = a.getGive_Shijian();
			String hh = a.getGive_FZ();
			%>
			酒店名称：<%=cc %><br>
			赠送券规格：消费满<%=ee %>赠送<%=ff %>元<br>
			赠送券过期时间：<%=dd %><br>
			赠送券发布时间：<%=gg %><br>
			发布人：<%=hh %><br>
			
			<%
		}
%>
</div>
</body>
</html>