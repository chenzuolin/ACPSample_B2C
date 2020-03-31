<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<title>微信支付（PC）</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
<link href="layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
<script type="text/javascript" src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="//static.runoob.com/assets/qrcode/qrcode.min.js"></script>
<script src="js/layui.js"></script>
</head>
<body>
<%
 String URL = (String) request.getSession().getAttribute("urlCode");
 String order_price =(String)request.getSession().getAttribute("order_price");
 String out_trade_no = (String) request.getSession().getAttribute("out_trade_no");
 System.out.print(URL+"aa");
%>

<input id="text" type="text" value=<%=URL %> style="display:none;" /><br />
<b style="margin-left:650px;font-family: Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', Arial, sans-serif;">速盟快线微信收银台</b>
<input type="text" value=<%=order_price %> readonly="readonly" style="margin-left:650px" />元<br />
<input type="text" id="out_trade_no" value=<%=out_trade_no %> readonly="readonly" style="margin-left:650px;margin-top:20px" /><br />
<div id="qrcode" style="margin-left:650px;margin-top:20px"></div>
<b style="margin-left:650px;margin-top:40px;color:red;font-family: Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', Arial, sans-serif;">确认订单请扫此二维码支付</b>
<script src="js/jquery.js"></script>
<script>
var qrcode = new QRCode(document.getElementById("qrcode"), {
	width : 200,
	height : 200
});

function makeCode () {		
	var elText = document.getElementById("text");
	
	if (!elText.value) {
		alert("Input a text");
		elText.focus();
		return;
	}
	
	qrcode.makeCode(elText.value);
}

makeCode();

$("#text").
	on("blur", function () {
		makeCode();
	}).
	on("keydown", function (e) {
		if (e.keyCode == 13) {
			makeCode();
		}
	});
</script>


</body>
</html>