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
	<%
		XLFPDao dao = new XLFPDao();
		List<XLFP> list = dao.findAll();
		for(XLFP x : list){
			String aa = x.getGreens_Type_Name();
			String bb = x.getCG_Name();
	%>
	<%=aa %><%=bb %><a href="GHS1.jsp?name=<%=aa %>">编辑</a><br/>
	
	<%
		}
	%>
</body> 
</html>