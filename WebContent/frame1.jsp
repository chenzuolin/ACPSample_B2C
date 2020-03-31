<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Integer id = (Integer)session.getAttribute("id");
	if(id != null){
		Greens_JobberDao dao = new Greens_JobberDao();
		List<Greens_Jobber> list = dao.findUserByID1(id);
		for(Greens_Jobber cc : list){
			String name = cc.getGreens_Jobber_UserName();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>top</title>
<link rel="stylesheet" href="./layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="css/layui.css">
<link rel="stylesheet" type="text/css" href="tubiao/iconfont.css">
    <script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
            var goEasy = new GoEasy({appkey: 'BC-8a96434d730f45de9a73cdfe101b398f'});
                               goEasy.subscribe({
                        channel: 'GoEasy',
                        onMessage: function(message){
                            alert('接收到消息:'+message.content);
                        }
              });
 </script>
<style type="text/css">		
	.weather {
		color: #fff;
		float: left;
		margin: 15px 0 0 50px;
	}
	
	.time {
		float: left;
		margin: 15px 15px 0 0;
		font-size: 14px;
		text-align: center;
		padding: 4px 5px;
		color: #ffffff;
	}
	.item{
		font-size:15px;
	}
	.layui-logo span:hover{
		color:rgb(0,150,136);
	}
	marquee{
			color:#fff;;
		}
</style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo" style="color:#fff;"><span>菜商管理系统</span></div>
    	<ul class="layui-nav layui-layout-left">
			<div class="weather">
					<div id="tp-weather-widget"></div>
						<script>
							(function(T, h, i, n, k, P, a, g, e) {
								g = function() {
									P = h.createElement(i);
									a = h.getElementsByTagName(i)[0];
									P.src = k;
									P.charset = "utf-8";
									P.async = 1;
									a.parentNode.insertBefore(P, a)
								};
								T["ThinkPageWeatherWidgetObject"] = n;
								T[n] || (T[n] = function() {
									(T[n].q = T[n].q || []).push(arguments)
								});
								T[n].l = +new Date();
								if(T.attachEvent) {
									T.attachEvent("onload", g)
								} else {
									T.addEventListener("load", g, false)
								}
							}(window, document, "script", "tpwidget", "//widget.seniverse.com/widget/chameleon.js"))
						</script>
						<script>
							tpwidget("init", {
								"flavor": "slim",
								"location": "WX4FBXXFKE4F",
								"geolocation": "enabled",
								"language": "zh-chs",
								"unit": "c",
								"theme": "chameleon",
								"container": "tp-weather-widget",
								"bubble": "disabled",
								"alarmType": "badge",
								"color": "#FFFFFF",
								"uid": "U9EC08A15F",
								"hash": "039da28f5581f4bcb5c799fb4cdfb673"
							});
							tpwidget("show");
						</script>

					</div>
			<div class="time" id="now_date"></div>
    </ul>
    <ul class="layui-nav layui-layout-right" style="margin-right:200px;">
    	<li class="layui-nav-item" >
    		<marquee direction="left" width="300px" align="bottom" onmouseout="this.start()" onmouseover="this.stop()" scrollamount="5" scrolldelay="1"><i class="layui-icon" style="font-size:15px;">&#xe645;</i>欢迎&nbsp;<span style="color:rgb(0,150,136);"><%=name %></span>&nbsp;登录到菜商管理平台</marquee>
    	</li>
    	<%
	}
	}else{
		response.sendRedirect("login1.jsp");
	}
%>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item"><a href="login1.jsp" target="_blank" class="item iconfont icon-tuichu">退出登录</a></li>
    </ul>
  </div>
  <script src="js/layui.all.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
<script src="../js/layui.js"></script>
		<script src="../js/jquery-1.8.3.min.js"></script>

		<script>
			function getNowFormatDate() {
				var date = new Date();
				var seperator1 = "-";
				var seperator2 = ":";
				var month = date.getMonth() + 1;
				var strDate = date.getDate();
				var day = date.getDay();
				if(month >= 1 && month <= 9) {
					month = "0" + month;
				}
				if(strDate >= 0 && strDate <= 9) {
					strDate = "0" + strDate;
				}

				var shi = date.getHours();
				if(parseInt(date.getHours()) < 10) {
					shi = "0" + date.getHours();
				}
				var fen = date.getMinutes();
				if(parseInt(date.getMinutes()) < 10) {
					fen = "0" + date.getMinutes();
				}
				var miao = date.getSeconds();
				if(parseInt(date.getSeconds()) < 10) {
					miao = "0" + date.getSeconds();
				}

				var currentdate = date.getFullYear() + "年" + month + "月" + strDate + "日 " +
					shi + "时" + fen + "分" + miao + "秒";

				var days = "";
				switch(day) {
					case 1:
						days = "星期一";
						break;
					case 2:
						days = "星期二";
						break;
					case 3:
						days = "星期三";
						break;
					case 4:
						days = "星期四";
						break;
					case 5:
						days = "星期五";
						break;
					case 6:
						days = "星期六";
						break;
					case 0:
						days = "星期日";
						break;
				}
				document.getElementById("now_date").innerHTML = currentdate + " " + days;
			}

			setInterval("getNowFormatDate()", 1000);
		</script>


</body>
</html>
