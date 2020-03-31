<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<form action="ASS2Servlet" method="post" enctype="multipart/form-data">
<div class="layui-inline">
消耗<input type="text" name="Coupon_Point">积分兑换<input type="text" name="Coupon_Mode">商品
<br>
商品类型：<input type="text" name="Coupon_Type">
<br>
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">商品图片</label>
			<div class="layui-input-inline">
				<input type="file" lay-verify="required"  name="Greens_tupian" class="layui-input">
			</div>
			<br>
			<span class="aa" style="margin-left:215px;color:#ccc;">图片名称与商品名称必须一致</span>
	</div>
	<input type="submit" value="提交" >
	</form>
	已有商品：
	<br>
	<%
		CouponDao dao = new CouponDao();
		List<Coupon> list = dao.findAll();
		for(Coupon c : list){
			String aa = c.getCoupon_Type();
			if(aa.contains("优惠券")){
				int bb = c.getCoupon_Point();
				int ee = c.getCoupon_num();
				%>
				优惠券：
				<br>
				满<%=bb %>积分兑换<%=ee %>元优惠券<br>
				<%
			}else{
				int ff = c.getCoupon_Point();
				String gg = c.getCoupon_Mode();
				String hh = c.getCoupon_Tupian();
				%>
				物品：
				<br>
				满<%=ff %>积分兑换<%=gg %>
				<img src = "http://www.sumengkx.com/app/SHOP/<%=hh %>">
				<br>
				<%
			}
			
		}
	%>
	<div>
		
	</div>
</body>
</html>