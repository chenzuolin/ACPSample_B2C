<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增快递员页面</title>
 <link rel="stylesheet" href="./css/layui.css">
 <link rel="stylesheet" href="./layui/css/layui.css">
 <style>
 	fieldset{
 		padding:15px 100px;
 	}
 	legend{
 		font-size:20px;
 	}
 	.layui-inline{
 		padding:15px 125px;
 	}
 	.item{
 		text-align:center;
 	}
 	.layui-table .one th{
 		text-align:center; 
 		background:rgb(0,150,136); 
 		color:#fff;
 	}
 	.layui-table .two td{
 		text-align:center;
 	}
 	.layui-table .two:hover{
 		background:rgb(0,150,136);
 	}
 </style>
</head>
<body>
  <div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;">
</div>
	<form action="KDYServlet" method="get">
 <fieldset>
   <legend>新增快递员</legend>
   	<div class="nav">
   		<div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; ">用户名</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="aa" id="firstname" class="layui-input" placeholder="请输入用户名称">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; ">密码</label>
			<div class="layui-input-inline">
				<input type="password" lay-verify="required" required name="bb" id="firstname" class="layui-input" placeholder="请输入用户密码">
			</div>
		</div>
		<br/>
		<div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px;">联系电话</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="cc" id="firstname" class="layui-input" placeholder="请输入联系电话">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px;">运送类型</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="dd" id="firstname" class="layui-input" placeholder="请输入运送类型">
			</div>
		</div>
		<br/>
		
   	</div>
 </fieldset>
 		<div class="item">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<button class="layui-btn" type="submit" style="width:121px;">提交</button>
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<button class="layui-btn" type="reset" style="width:121px;">重置</button>
				</div>
			</div>
		</div>
		</form>
	<fieldset>
	   <legend>已注册快递员</legend>
		<table  class="layui-table" style=" width:90%; margin-left:5%; table-layout: fixed;">
			<tr class="one">
				<th>登录名称</th>
				<th>联系电话</th>
				<th>注册时间</th>
				<th>运输类型</th>
			</tr>
			<%
				CourierDao dao = new CourierDao();
				List<Courier> list = dao.findAll();
				for(Courier courier : list){
					String name = courier.getCourier_Name();
					String tel = courier.getCourier_Telephone();
					String time = courier.getCourier_Time();
					String type = courier.getCourier_Vehicle();
			%>
			<tr class="two">
				<td><%=name %></td>
				<td><%=tel %></td>
				<td><%=time %></td>
				<td><%=type %></td>
			</tr>
			<%
				}
			%>
		</table>
	</fieldset>
</body>
</html>