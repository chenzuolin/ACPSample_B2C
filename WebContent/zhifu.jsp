<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	ul{list-style:none;}
	a{text-decoration:none;}
	.dd{
		position:relative;
	}
	.nva{
		position:absolute;
		width:250px;
		height:250px;
		margin-left:360px;
		margin-top:100px;
	}
	.list{
		position:absolute;
		width:250px;
		height:250px;
		left:620px;
		top:100px;
	}
	.nva a img{
		margin-left:55px;
		margin-top:25px;
	}
	.list a img{
		margin-left:40px;
		margin-top:25px;
		width:176px;
		height:134px;
	}
</style>
</head>
<body>
<div class="dd">
	<div class="nva">
		<a href="order.jsp">
			<img src="./images/zhifubao.png" title="支付宝" alt="加载中">
		</a>
		<br/>
		<a href="order.jsp" style="display:inline-block;margin-top:40px; margin-left:76px;font-size:20px;color:#000;"><strong></strong></a>
	</div>
	
		<a href="WeiXinPay">
			<img src="./images/weixin.png" title="微信支付" alt="加载中">
		</a>
		<br/>
		<a href="order.jsp" style="display:inline-block;margin-top:40px; margin-left:76px;font-size:20px;color:#000;"><strong></strong></a>
	
	<div class="list">
		<a href="index.jsp">
			<img src="./images/zhifu2.png" title="银联" alt="加载中">
		</a>
		<br/>
		<a href="index.jsp"  style="display:inline-block;margin-top:28px; margin-left:76px;font-size:20px;color:#000;"><strong></strong></a>
	</div>
</div>
</body>
</html>