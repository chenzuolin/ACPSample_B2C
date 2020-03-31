<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.net.InetAddress"%>
<%
	request.setCharacterEncoding("utf-8");
	Integer id = (Integer)session.getAttribute("w");
	InetAddress address = InetAddress.getLocalHost();  
	String ip=address .getHostAddress().toString();  
	pageContext.setAttribute("ip",ip);
	if(id == null){
		response.sendRedirect("login1.jsp");
	}else{
		UserDao dao = new UserDao();
		List<User> list = dao.findUserByID1(id);
		for(User cc : list){
			String name = cc.getUser_Name();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<link rel="stylesheet" href="css/layui.css">
<script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
</head>
<body>
	 <div class="x-body layui-anim layui-anim-up">
	 	<blockquote class="layui-elem-quote">欢迎管理员：
            <span class="x-red"><%=name %></span>！本地IP: <span class="x-red"><%=ip %></span></blockquote>
	            <%
						}
					}
				%>
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
                                                <h3>已注册酒店</h3>
                                                <p>
                                                    <cite>0</cite>
                                                </p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>已注册快递员</h3>
                                                <p>
                                                    <cite>0</cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>已推送消息</h3>
                                                <p>
                                                    <cite>0</cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>已发送公告</h3>
                                                <p>
                                                    <cite>0</cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>未确认收获</h3>
                                                <p>
                                                    <cite>0</cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs2">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3>推荐菜品数</h3>
                                                <p>
                                                    <cite>0</cite></p>
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
</body>

</html>