<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="java.sql.*"%>
<%
	response.setCharacterEncoding("utf-8");
	int id = (Integer)session.getAttribute("id");
	System.out.print("id="+id);
	if(id == 0){
		response.sendRedirect("login1.jsp");
	}
		IndentDao dao11 = new IndentDao();
		List<Indent> list1 = dao11.findUserByID666(id);
		int zhengzaichuli = list1.size();
		List<Indent> list2 = dao11.findUserByID667(id);
		int zhengzaifenjian = list2.size();
		List<Indent> list3 = dao11.findUserByID668(id);
		int dengdaikuaidiyuan = list3.size();
		List<Indent> list4 = dao11.findUserByID669(id);
		int peisongzhong = list4.size();
		List<Indent> list5 = dao11.findUserByID670(id);
		int yiwancheng = list5.size();
		List<Indent> list = dao11.findUserByID10(id);
		int zongdingdan = list.size();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
<link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
<script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script type="text/javascript">
            var goEasy = new GoEasy({appkey: 'BC-8a96434d730f45de9a73cdfe101b398f'});
                               goEasy.subscribe({
                        channel: 'GoEasy',
                        onMessage: function(message){
                            alert('接收到消息:'+message.content);
                        }
              });
 </script>
 <style>
 	.www{
 		width:100%;
 		height:200px;
 		overflow-x: scroll;
		overflow-y: hidden;
		white-space: nowrap;
 	}
 	#hrader{
 		display: inline-block;
 		width:150px;
 		height:200px;
 		background:#fff;
 		border:2px solid #eee;
 		margin-top:20px;
 		
 	}
 	.imglist img{
 		width:100%;
 		height:100%;
 	}
 	.imglist{
 		width:100%;
 		height:100px;
 	}
 	.numberlist{
 		background:#ccc;
 	}
 	.laber{
 		width:200px;
 		height:20px;
 		position: fixed;
 		left:0;
 		top:0;
 		text-align:center;
 		border:1px solid #ccc;
		background: -webkit-linear-gradient(left top,#fff,#ccc,#fff);
		box-shadow: 0px 0px 5px #000;
 	}
 	.a_icon{
 		background-color:#ccc;
 	}
 	.a_icon a:nth-child(1) i{
 		color:green;
 	}
 	.a_icon a:nth-child(2) i{
 		color:#fff;
 	}
 	.a_icon a:nth-child(3) i{
 		color:skyblue;
 	}
 	.banner_content{
 		width:100%;
 		height:300px;
 		background:white;
 		padding:5px 5px;
 	}
 	#banner_one{
 		display:inline;
 		float:left;
 		width:78%;
 		height:300px;
 		background:white;
 	}
 	#banner_one #banner_one_list{
 		height:250px;
 		width:100%;
 		margin-top:32px;
 	}
 	#banner_one .layui-inline{
 		height:50px;
 		width:100%;
 		line-height:50px;
 		text-align: center;
 	}
 	.banner_hander{
 		display: inline;
 		width:20%;
 		height:50px;
 		background:#ccc;
 		float:left;
 		line-height: 50px;
 	}
 	.banner_hander p{
 		padding:0 15px;
 	}
 	.banner_content .banner_list{
 		display: inline;
 		width:20%;
 		height:250px;
 		background:#fff;
 		float:left;
 		overflow:hidden
 	}
 	.banner_ul{
 		margin-top:2px;
 	}
 	.banner_li a p{
 		padding-left:5px;
 		overflow:hidden; 
		text-overflow:ellipsis;
		white-space:nowrap;
 	}
 	.banner_div{
 		padding:10px 15px;
 	}
 	.floor{
 		width:100%;
 		height:200px;
 	}
 *{ margin:0; padding:0; list-style:none;}
.slide_box img{ border:0;}
.lanren{ position:absolute; right:0; top:150px;}
.lanren .slide_min{ width:28px; height:112px; background:url(./images/slide_min.jpg) no-repeat; cursor:pointer;}
.lanren .slide_box{ width:154px; height:auto; overflow:hidden; background:url(./images/slide_box_bg.jpg) repeat-y; font-size:12px; text-align:center; line-height:130%; color:#666; border-bottom:2px solid #76A20D;}
.lanren .slide_box .weixin{ margin-bottom:5px;}
.lanren .slide_box img{ cursor:pointer;}
.lanren .slide_box p{ text-align:center; padding:5px; margin:5px;border-bottom:1px solid #ddd;}
.lanren .slide_box span{ padding:5px 10px; display:block;}
.lanren .slide_box span a{ color:#76A20C;}
 </style>
</head>
<body>
<div class="lanren">
	<div class="slide_min"></div>
    <div class="slide_box" style="display:none;">
    	<h2><img src="./images/slide_box.jpg" /></h2>
        <p><a title="点击这里给我发消息" href="http://wpa.qq.com/msgrd?v=3&amp;uin=2946678611&amp;site=www.cactussoft.cn&amp;menu=yes" target="_blank"><img src="http://wpa.qq.com/pa?p=2:2946678611:41"></a></p>
        <p>
        	<img id="www" src="./images/weixin.jpg" class="weixin" /><br />
        	<b>客户服务热线</b><br />
        	0931-8555019
        </p>
        <span><a href="words.jsp">给我们留言</a></span>
    </div>
</div>
<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
<script>
$(function(){
	var thisBox = $('.lanren');
	var defaultTop = thisBox.offset().top;
	var slide_min = $('.lanren .slide_min');
	var slide_box = $('.lanren .slide_box');
	var closed = $('.lanren .slide_box h2 img');
	slide_min.on('click',function(){$(this).hide();	slide_box.show();});
	closed.on('click',function(){slide_box.hide().hide();slide_min.show();});
	// 页面滚动的同时，悬浮框也跟着滚动
	$(window).on('scroll',function(){scro();});
	$(window).onload = scro();
	function scro(){
		var offsetTop = defaultTop + $(window).scrollTop()+'px';
		thisBox.animate({top:offsetTop},
		{	duration: 600,	//滑动速度
	     	queue: false    //此动画将不进入动画队列
	     });
	}
});
</script>
<form action="VV5Servlet" method="get">
<div class="www">
	<fieldset class="layui-elem-field">
            <legend style="font-size:15px;">蔬菜推荐</legend>
				<div id="content" style="margin-top:-20px;"></div>
	</fieldset>
</div>
<div class="banner_content">
	<div id="banner_one">
		
		<div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:150px; "><strong>蔬菜名称</strong></label>
				<div class="layui-input-inline" >
						<input type="text" lay-verify="required" style="width:250px;" required name="a"  class="layui-input" placeholder="请输入蔬菜名称">
				</div>
				<div class="layui-input-inline" >
						<input type="submit" class="layui-btn" style="width:150px;" value="提交">
				</div>
		</div>
		<div id="banner_one_list"></div>
	</div>
	<div class="banner_hander">
		<p>速盟公告<a href="javascript:;"><span style="float:right;">更多>>></span></a></p>
	</div>
	<div class="banner_list">
	</div>
</div>
 <div class="x-body layui-anim layui-anim-up">
		<fieldset class="layui-elem-field">
            <legend>数据统计</legend>
            <div class="layui-field-box">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body">
                            <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 90px;">
                                <div carousel-item="">
                                    <ul class="layui-row layui-col-space10 layui-this">
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>全部订单</h3>
                                                <p>
                                                    <cite><%=zongdingdan %></cite>
                                                </p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>正在处理订单</h3>
                                                <p>
                                                    <cite><%=zhengzaichuli %></cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>正在分拣订单</h3>
                                                <p>
                                                    <cite><%=zhengzaifenjian %></cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>等待快递员接受</h3>
                                                <p>
                                                    <cite><%=dengdaikuaidiyuan %></cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>正在配送中订单</h3>
                                                <p>
                                                    <cite><%=peisongzhong %></cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>已完成订单</h3>
                                                <p>
                                                    <cite><%=yiwancheng %></cite></p>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>
    </form>
<script src="layui/layui.js"></script>
<script src="js/layer-v3.1.1/layer/layer.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/jquery.js"></script> 
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	var greens_id = 0;
	$.ajax("http://www.sumengkx.com/ACPSample_B2C/TJ99Servlet", {
		dataType: "json",
		type: "get", 
		success: function(obj) {
			var html = "";
			for(var i=0;i<obj.length;i++){
				html +='<div id="hrader">';
					html +='<a href="javascript:;">';
						html +='<div class="imglist">'
							html +='<img src="http://www.sumengkx.com/app/GreensShop/'+obj[i].zz+'">';
						html +='</div>';
						html +='<div class="numberlist">';
							html +='<p style="text-align:center;">'+obj[i].bb+'</p>';
							html +='<p style="text-align:center;">'+"￥"+obj[i].dd+"/"+obj[i].cc+'<del style="font-size:10px;color:red;">'+"￥"+obj[i].ee+"/"+obj[i].cc+'</del>'+'</p>';
							greens_id = obj[i].aa;
						html +='</div>';
					html +='</a>';
					html +='<div class="a_icon">';
						html +='<a href="one.jsp?id='+greens_id+'" title="加入到常用菜">';
							html +='<i class="layui-icon" style="padding-left:20px;line-height:20px;">'+"&#xe654;"+'</i>';
						html +='</a>';
						html +='<a href="cart2Servlet" title="查看购物车">';
							html +='<i class="layui-icon" style="padding-left:34px;line-height:20px;">'+"&#xe642;"+'</i>';
						html +='</a>';
						html +='<a href="two.jsp?id='+greens_id+'" title="加入到购物车">';
							html +='<i class="layui-icon" style="float:right;padding-right:20px;line-height:20px;" >'+"&#xe657;"+'</i>';
						html +='</a>';
					html +='</div>';
				html +='</div>';
			}
			$("#content").append(html);
		}, 
		error: function(obj){ 
			window.location.href="error.jsp";
		}
	});
	$.ajax("http://www.sumengkx.com/ACPSample_B2C/Consult1Servlet", {
		dataType: "json",
		type: "get", 
		success: function(obj) {
			var html = "";
			for(var i=0;i<obj.length;i++){
				html +='<ul class="banner_ul">';
					html +='<div class="banner_div">';
						html +='<li class="banner_li">';
							html +='<a href="javascript:;">';
								html +='<p>'+'<i class="layui-icon" >&#xe645;</i>'+'&nbsp;&nbsp;'+obj[i].content+'</p>';
							html +='</a>';
						html +='</li>';
					html +='<div>';
				html +='</ul>';
			}
			$(".banner_list").append(html);
		}, 
		error: function(obj){ 
			window.location.href="error.jsp";
		}
	});
	
<%
	int aa = 0;
	if(request.getSession().getAttribute("aa")==null){
		aa = 1;
	}else{
		aa = (Integer)request.getSession().getAttribute("aa");
	}
	DynamicDao dao = new DynamicDao(); 
	float a = 0;
	float a1 = 0;
	float cc1 = 0;
	float dd1 = 0;
	List<Dynamic> list111 = dao.findUserByID5("2019-01-01", "2019-02-01");
	for(Dynamic dynamic : list111){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc1 = dynamic.getDynamic_Price();
			 dd1 = dynamic.getDynamic_Market_Price();
			a += cc1;
			a1 += dd1;
			
		}
		
	}
	a = a/31;
	a1 = a1/31;
	float b = 0;
	float b1 = 0;
	float cc2 = 0;
	float dd2 = 0;
	List<Dynamic> list112 = dao.findUserByID5("2019-02-01", "2019-03-01");
	for(Dynamic dynamic : list112){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc2 = dynamic.getDynamic_Price();
			 dd2 = dynamic.getDynamic_Market_Price();
			b += cc2;
			b1 += dd2;
		}
		
	}
	b = b/28;
	b1 = b1/28;
	
	float c = 0;
	float c1 = 0;
	float cc3 = 0;
	float dd3 = 0;
	List<Dynamic> list13 = dao.findUserByID5("2019-03-01", "2019-04-01");
	for(Dynamic dynamic : list13){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			cc3 = dynamic.getDynamic_Price();
			dd3 = dynamic.getDynamic_Market_Price();
			c += cc3;
			c1 += dd3;
		}
		
	}
	c = c/31;
	c1 = c1/31;
	float d = 0;
	float d1 = 0;
	float cc4 = 0;
	float dd4 = 0;
	List<Dynamic> list14 = dao.findUserByID5("2019-04-01", "2019-05-01");
	for(Dynamic dynamic : list14){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc4 = dynamic.getDynamic_Price();
			 dd4 = dynamic.getDynamic_Market_Price();
			d += cc4;
			d1 += dd4;
		}
		
	}
	d = d/30;
	d1 = d1/30;
	float e = 0;
	float e1 = 0;
	float cc5 = 0;
	float dd5 = 0;
	List<Dynamic> list15 = dao.findUserByID5("2019-05-01", "2019-06-01");
	for(Dynamic dynamic : list15){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc5 = dynamic.getDynamic_Price();
			 dd5 = dynamic.getDynamic_Market_Price();
			e += cc5;
			e1 += dd5;
		}
		
	}
	e = e/31;
	e1 = e1/31;
	
	float f = 0;
	float f1 = 0;
	float cc6 = 0;
	float dd6 = 0;
	List<Dynamic> list6 = dao.findUserByID5("2019-06-01", "2019-07-01");
	for(Dynamic dynamic : list6){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc6 = dynamic.getDynamic_Price();
			 dd6 = dynamic.getDynamic_Market_Price();
			f += cc6;
			f1 += dd6;
		}
		
	}
	f = f/30;
	f1 = f1/30;
	float g = 0;
	float g1 = 0;
	float cc7 = 0;
	float dd7 = 0;
	List<Dynamic> list7 = dao.findUserByID5("2019-07-01", "2019-08-01");
	for(Dynamic dynamic : list7){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc7 = dynamic.getDynamic_Price();
			 dd7 = dynamic.getDynamic_Market_Price();
			g += cc7;
			g1 += dd7;
		}
			}
	g = g/31;
	g1 = g/31;

	float h = 0;
	float h1 = 0;
	float cc8 = 0;
	float dd8 = 0;
	List<Dynamic> list8 = dao.findUserByID5("2019-08-01", "2019-09-01");
	for(Dynamic dynamic : list8){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc8 = dynamic.getDynamic_Price();
			 dd8 = dynamic.getDynamic_Market_Price();
			System.out.println(cc8);
			h += cc8;
			h1 += dd8;
		}
		
		
	}
	h = h/31;
	h1 = h1/31;
	System.out.print(h);
	float i = 0;
	float i1 = 0;
	float cc9 = 0;
	float dd9 = 0;
	List<Dynamic> list9 = dao.findUserByID5("2019-09-01", "2019-10-01");
	for(Dynamic dynamic : list9){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc9 = dynamic.getDynamic_Price();
			 dd9 = dynamic.getDynamic_Market_Price();
			i += cc9;
			i1 += dd9;
		}
		
	}
	i = i/30;
	i1 = i1/30;
	float j = 0;
	float j1 = 0;
	float cc10 = 0;
	float dd10 = 0;
	List<Dynamic> list10 = dao.findUserByID5("2019-10-01", "2019-11-01");
	for(Dynamic dynamic : list10){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc10 = dynamic.getDynamic_Price();
			 dd10 = dynamic.getDynamic_Market_Price();
			j += cc10;
			j1 += dd10;
		}
		
	}
	j = j/31;
	j1 = j1/31;
	float k = 0;
	float k1 = 0;
	float cc11 = 0;
	float dd11 = 0;
	List<Dynamic> list11 = dao.findUserByID5("2019-11-01", "2019-12-01");
	for(Dynamic dynamic : list11){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc11 = dynamic.getDynamic_Price();
			 dd11 = dynamic.getDynamic_Market_Price();
			k += cc11;
			k1 += dd11;
		}
		
	}
	k = k/30;
	k1 = k1/30;
	float l = 0;
	float l1 = 0;
	float cc12 = 0;
	float dd12 = 0;
	List<Dynamic> list12 = dao.findUserByID5("2019-12-01", "2020-01-01");
	for(Dynamic dynamic : list12){
		int bb = dynamic.getGreens_ID();
		if(aa==bb){
			 cc12 = dynamic.getDynamic_Price();
			 dd12 = dynamic.getDynamic_Market_Price();
			l += cc12;
			l1 += dd12;
		}
			}
	l = l/31;
	l1 = l1/31;
	float a2 =(float)(Math.round(a*100))/100;
	float b2 =(float)(Math.round(b*100))/100;
	float c2 =(float)(Math.round(c*100))/100;
	float d2 =(float)(Math.round(d*100))/100;
	float e2 =(float)(Math.round(e*100))/100;
	float f2 =(float)(Math.round(f*100))/100;
	float g2 =(float)(Math.round(g*100))/100;
	float h2 =(float)(Math.round(h*100))/100;
	float i2 =(float)(Math.round(i*100))/100;
	float j2 =(float)(Math.round(j*100))/100;
	float k2 =(float)(Math.round(k*100))/100;
	float l2 =(float)(Math.round(l*100))/100;
	float a3 =(float)(Math.round(a1*100))/100;
	float b3 =(float)(Math.round(b1*100))/100;
	float c3 =(float)(Math.round(c1*100))/100;
	float d3 =(float)(Math.round(d1*100))/100;
	float e3 =(float)(Math.round(e1*100))/100;
	float f3 =(float)(Math.round(f1*100))/100;
	float g3 =(float)(Math.round(g1*100))/100;
	float h3 =(float)(Math.round(h1*100))/100;
	float i3 =(float)(Math.round(i1*100))/100;
	float j3 =(float)(Math.round(j1*100))/100;
	float k3 =(float)(Math.round(k1*100))/100;
	float l3 =(float)(Math.round(l1*100))/100;

%>

	var myChart = echarts.init(document.getElementById('banner_one_list'));

	option = {
		    title : {
		        text: '速盟每月蔬菜价格变动表',
		        subtext: ''
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['市场单价','速盟单价']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'市场单价',
		            type:'bar',
		            data:[<%=a2 %>,<%=b2 %>,<%=c2 %>,<%=d2 %>,<%=e2 %>,<%=f2 %>,<%=g2 %>,<%=h2 %>,<%=i2 %>,<%=j2 %>,<%=k2 %>,<%=l2 %>],
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        },
		        {
		            name:'速盟单价',
		            type:'bar',
		            data:[<%=a3 %>,<%=b3 %>,<%=c3 %>,<%=d3 %>,<%=e3 %>,<%=f3 %>,<%=g3 %>,<%=h3 %>,<%=i3 %>,<%=j3 %>,<%=k3 %>,<%=l3 %>],
		            markPoint : {
		                data : [
		                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
		                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name : '平均值'}
		                ]
		            }
		        }
		    ]
		};
 myChart.setOption(option);
</script>
</body>
</html>