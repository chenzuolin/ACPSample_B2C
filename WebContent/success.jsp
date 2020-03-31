<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="layui/css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买成功页面</title>
<style>
.nva{
 		position:relative;
 		width:100%;
 		height:5px;
 		background:rgb(0,150,136);
 	}
.list{
 		position:absolute;
 		top:0px;
 		left:0px;
 		width:5px;
 		height:100%;
 		background:rgb(0,150,136);
 	}

 	.item p{
 		font-size:20px;
 		text-align:center;
 		color:red;
 		margin-top:150px;
 	}
 	a{
 		text-decoration:none;
 		color:skyblue;
 		font-size:15px;
 	}
</style>
</head>
<body>

 
      

    <a class="layui-btn"  style="position:absolute;left:45%;top:50%;"  href="./jiudianshouye.jsp">返回首页</a>
</body>
<script src="layui/layui.js"></script>
<script>
//一般直接写在一个js文件中
layui.use(['layer', 'form'], function(){
  var layer = layui.layer
  ,form = layui.form;
  
  layer.alert('购买成功，点击确认', 
  {
  skin: 'layui-layer-molv' //样式类名
  ,closeBtn: 0
  
  
},  
);
});
</script> 
</html>