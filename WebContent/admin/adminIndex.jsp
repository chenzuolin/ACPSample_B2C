<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="com.sumeng.service.*"%>
<%@page import="com.sumeng.web.*"%>
<%
	List<MenuPath> list = (List<MenuPath>)session.getAttribute("path");
	MenuDao dao = new MenuDao();
	int uid = (int)session.getAttribute("w");
	Role role = dao.getUid(uid);
	String roleName = role.getRole_Name();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>速盟快线后台管理系统</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="shortcut icon" href="../index.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
	<link rel="stylesheet" href="../css/xadmin.css">
	<link rel="stylesheet" href="../css/theme137.min.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>
	<style>
		.left-nav #nav li {border-bottom:none;}
		.weather{display:inline-block;line-height:46px;}
		#tp-weather-widget{display:inline-block;float:left;line-height:36px;}
		.time{display:inline-block;float:left;}
		.foot{line-height:47px;}
	</style>
</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="javascript:;">后台管理系统</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav left fast-add" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">查看</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('业务数据','${pageContext.request.contextPath}/admin/header/businessData.jsp')"><i class="iconfont">&#xe6a2;</i>业务数据</a></dd>
              <dd><a onclick="x_admin_show('商品统计','${pageContext.request.contextPath}/admin/header/greensCount.jsp')"><i class="iconfont">&#xe6a8;</i>商品统计</a></dd>
               <dd><a onclick="x_admin_show('协议','javascript:;')"><i class="iconfont">&#xe6b8;</i>协议</a></dd>
            </dl>
          </li>
        </ul>
        <ul class="layui-nav left fast-add" lay-filter="">
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
					<div class="time" id="now_date"></div>
				</div>
        </ul>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">用户信息</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','javascript:;')">个人信息</a></dd>
              <dd><a onclick="x_admin_show('酒店资质','javascript:;')">酒店资质</a></dd>
              <dd><a href="${pageContext.request.contextPath}/login1.jsp">退出</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a href="${pageContext.request.contextPath}/login1.jsp">切换账号</a></li>
        </ul>
         <ul class="layui-nav right" lay-filter="">
         	<div class="foot">
          		<marquee direction="left"  align="bottom" onmouseout="this.start()" onmouseover="this.stop()" scrollamount="5" scrolldelay="1"> <i class="layui-icon" style="font-size:15px;">&#xe645;</i>欢迎&nbsp;<span style="color:#ccc;"><%=roleName %></span>&nbsp;登录到酒店管理平台</marquee>
          	</div>
        </ul>
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
        <%
        	for(MenuPath c : list){ 
    			String menuName = c.getMenuName();
    			int roleId = c.getRole_ID();
    			int mid = c.getId();
    			int menu = c.getStarts();
    			if(menu == 1){
        %>
        	 
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite><%=menuName %></cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                <%
                	List<PareMenu> pareMenu = dao.getPareMenu(mid,roleId);
                	for(PareMenu p : pareMenu){
                		int starts = p.getStarts();
                		int code = p.getCode();
                		if(starts == 1 && code == 1){
               				String pareMenuName = p.getPare_menu_name();
                       		String pareMenuPath = p.getPare_menu_path();
                %>
                    <li>
                        <a _href="<%=pareMenuPath %>">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite><%=pareMenuName %></cite>
                            
                        </a>
                    </li >
                    <%
                			}
                		}
                    %>
                </ul>
            </li>
            <%
    				}
    			}
            %>
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的首页</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='./index.jsp' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright">甘肃速盟快线智能科技有限公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陇ICP备19001292号</div>  
    </div>
    <!-- 底部结束 -->
    <script>
   
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })();
    </script>
</body>
</html>