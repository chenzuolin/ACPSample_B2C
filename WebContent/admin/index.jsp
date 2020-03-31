<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page language="java" import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%
	WineshopDao w = new WineshopDao();
	int w_number = w.W_Number();
	CourierDao c = new CourierDao();
	int c_number = c.C_Number();
	GreensDao g = new GreensDao();
	int g_number = g.findAllNum();
	int t_number = g.findTuijianAllNum();
	IndentDao i = new IndentDao();
	int i_number = i.finIndentNumber();
	int threeNumber = i.findThreeIndent();
	int weekNumber = i.findWeekIndent();
	int monthNumber = i.findMonthIndent();
	int yearNumber = i.findYearIndent();
	double dayMoney = i.findMoneyDayIndent();
	double weekMoney = i.findMoneyWeekIndent();
	double monthMoney = i.findMoneyMonthIndent();
	double yearMoney = i.findMoneyYearIndent();
	ConsultDao o = new ConsultDao();
	int o_number = o.C_Number();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/font.css">
<link rel="stylesheet" href="../css/xadmin.css">
<script type="text/javascript" src="../layui-v2.4.5/layui/layui.js"></script>
<script type="text/javascript" src="../js/xadmin.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<style>
.layui-icon{color:red;}
</style>
<title>首页</title>
</head>
<body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">数据统计</div>
                        <div class="layui-card-body ">
                            <ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>已注册酒店</h3>
                                        <p>
                                            <cite><%=w_number %></cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>已注册快递员</h3>
                                        <p>
                                            <cite><%=c_number %></cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>当前菜品总数</h3>
                                        <p>
                                            <cite><%=g_number %></cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>推荐菜品总数</h3>
                                        <p>
                                            <cite><%=t_number %></cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>未确认收货</h3>
                                        <p>
                                            <cite><%=i_number %></cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6 ">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>已发送公告</h3>
                                        <p>
                                            <cite><%=o_number %></cite></p>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm6 layui-col-md3">
                    <div class="layui-card">
                        <div class="layui-card-header">订单
                            <span class="layui-badge">三日</span></div>
                        <div class="layui-card-body  ">
                            <p class="layuiadmin-big-font"><%=threeNumber %>条</p>
                            <p>收入
                                <span class="layuiadmin-span-color">金额：<%=dayMoney %>
                                    <i class="layui-inline layui-icon layui-icon-rmb"></i></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm6 layui-col-md3">
                    <div class="layui-card">
                        <div class="layui-card-header">订单
                            <span class="layui-badge layui-bg-orange">周</span></div>
                        <div class="layui-card-body ">
                            <p class="layuiadmin-big-font"><%=weekNumber %>条</p>
                            <p>收入
                                <span class="layuiadmin-span-color">金额：<%=weekMoney %>
                                    <i class="layui-inline layui-icon layui-icon-rmb"></i></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm6 layui-col-md3">
                    <div class="layui-card">
                        <div class="layui-card-header">订单
                            <span class="layui-badge layui-bg-green">月</span></div>
                        <div class="layui-card-body ">
                            <p class="layuiadmin-big-font"><%=monthNumber %>条</p>
                            <p>收入
                                <span class="layuiadmin-span-color">金额：<%=monthMoney %>
                                    <i class="layui-inline layui-icon layui-icon-rmb"></i></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm6 layui-col-md3">
                    <div class="layui-card">
                        <div class="layui-card-header">订单
                            <span class="layui-badge layui-bg-blue">年</span></div>
                        <div class="layui-card-body ">
                            <p class="layuiadmin-big-font"><%=yearNumber %>条</p>
                            <p>收入
                                <span class="layuiadmin-span-color">金额：<%=yearMoney %>
                                    <i class="layui-inline layui-icon layui-icon-rmb"></i></span>
                            </p>
                        </div>
                    </div>
                </div>
        </div>
        </div>
        		 <div id="main" style="width: 47%;height:400px;float:left;"></div>
                <div id="right" style="width: 47%;height:400px;float:right;"></div>
               <div id="option" style="width: 100%;height:400px;"></div>
 <script>
    var myChart_left = echarts.init(document.getElementById('main'));
    var myChart_right = echarts.init(document.getElementById('option'));
    var year = echarts.init(document.getElementById('right'));
    var arr = new Array();
    var month = new Array();
    var yearCount = new Array();
    $.ajax({
   		type:"post",
   		url:"${pageContext.request.contextPath}/WeekCountIndent",
   		dataType:"json",
   		success:function(obj){
   			var time = [];
   			var count = [];
   			for(var i=0;i<obj.length;i++){
   				time.push(obj[i].wdate);
   				count.push(obj[i].count);
   			}
   			 arr.push(time);
   			 arr.push(count);
   			 option = {
   				 title: {
   			         text: '本周订单趋势'
   			     },
   			    legend: {
   			        data:['数量']
   			    },
   			    xAxis: {
   			        type: 'category',
   			        data: arr[0]
   			    },
   			    yAxis: {
   			        type: 'value'
   			    },
   			    series: [{
   			    	name:'数量',
   			        data: arr[1],
   			        type: 'line',
   			        smooth: true
   			    }]
   			};
   			myChart_left.setOption(option);
   		}
   	});
    $.ajax({
   		type:"post",
   		url:"${pageContext.request.contextPath}/YearCountIndent",
   		dataType:"json",
   		success:function(obj){
   			var time = [];
   			var count = [];
   			for(var i=0;i<obj.length;i++){
   				time.push(obj[i].ydate);
   				count.push(obj[i].count);
   			}
   			yearCount.push(time);
   			yearCount.push(count);
   			 option = {
   				 title: {
   			         text: '每月订单趋势'
   			     },
   			    legend: {
   			        data:['数量']
   			    },
   			    xAxis: {
   			        type: 'category',
   			        data: yearCount[0]
   			    },
   			    yAxis: {
   			        type: 'value'
   			    },
   			    series: [{
   			    	name:'数量',
   			        data: yearCount[1],
   			        type: 'line',
   			        smooth: true
   			    }]
   			};
   			year.setOption(option);
   		}
   	});
    $.ajax({
   		type:"post",
   		url:"${pageContext.request.contextPath}/MonthCountIndent",
   		dataType:"json",
   		success:function(obj){
   			var time = [];
   			var count = [];
   			for(var i=0;i<obj.length;i++){
   				time.push(obj[i].mdate);
   				count.push(obj[i].count);
   			}
   			month.push(time);
   			month.push(count);
   			 option = {
   				 title: {
   			         text: '本月每日订单趋势'
   			     },
   			    legend: {
   			        data:['数量']
   			    },
   			    xAxis: {
   			        type: 'category',
   			        data: month[0]
   			    },
   			    yAxis: {
   			        type: 'value'
   			    },
   			    series: [{
   			    	name:'数量',
   			        data: month[1],
   			        type: 'line',
   			        smooth: true
   			    }]
   			};
   			myChart_right.setOption(option);
   		}
   	});
    
    </script>
    </body>
</html>