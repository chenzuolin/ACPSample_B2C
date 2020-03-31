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
<form action="TJYHJServlet" method="post">
使用<input type="text" name="Point">积分兑换
<input type="text" name="num">元
<input type="submit" value="提交" >
</form>
已有的优惠卷：<br>
<%
	CouponDao dao = new CouponDao();
	List<Coupon> list = dao.findAll();
	for(Coupon c : list){
		int aa = c.getCoupon_Point();
		int bb = c.getCoupon_num();
%>

	使用<%=aa %>积分兑换<%=bb %>元
<%
	}
%>
</body>
</html>