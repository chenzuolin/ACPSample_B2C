<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>加入到常用菜</title>
<link href="css/layui.css" rel="stylesheet" media="all">
<style>
	label{
		margin-top:10px;
		width:165%;
	}
	.layui-input{
		width:165%;
		margin-top:10px;
	}
	#tijiao{
		margin-top:20px;
		width:300px;
	}
	#quxiao{
		margin-top:20px;
		width:300px;
		background-color:#ccc;
	}
</style>
</head>
<body>
<script src="layui/layui.js"></script>
<script src="js/layer-v3.1.1/layer/layer.js"></script>
<script src="js/layer.js"></script>
<script src="js/jquery.js"></script>
<script src="js/jquery.2.1.4.js"></script> 

<script>
		function getUrlParam(name) {
		    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		    if (r != null) return unescape(r[2]); return null; //返回参数值
		}
		var id = getUrlParam('id');
	 layui.use('layer', function(){
     var layer = layui.layer;

     layer.open({
         type: 1, 
         area: ['300px', '400px'],
         maxmin: true ,
         title:'<h>加入常用菜</h>',
         anim: 1,
         content: '<div class="layui-inline"><label class="layui-btn" style="background:rgb(126,126,126);">购买数量</label><br/><div class="layui-input-inline"><input type="text" lay-verify="required" required name="number" id="number" class="layui-input" placeholder="请输入购买数量"></div></div><div class="layui-inline"><label class="layui-btn" style="background:rgb(126,126,126);">蔬菜要求</label><br/><div class="layui-input-inline"><input type="text" lay-verify="required" required name="yaoqiu" id="yaoqiu" class="layui-input" placeholder="请输入蔬菜要求"></div></div><br/><div class="layui-inline"><div class="layui-input-inline"><button class="layui-btn" id="tijiao" onclick="tijiao();">提交</button></div></div><br/><div class="layui-inline"><div class="layui-input-inline"><button class="layui-btn" id="quxiao" onclick="quxiao();">取消</button></div></div>' 
       });
		
   });
	 function tijiao(){
		 var number = document.getElementById("number").value;
		 if(number == 0)	 {
			 layer.alert('请输入数量！', {icon: 3});
			 return;
		 }
		 $.ajax("http://211.149.232.210/ACPSample_B2C/SouyetuijainServlet", {
				dataType: "text",
				type: "get", 
				data:{
					"id":id
				},
				success: function(obj) {
					if(obj == 1){
						 layer.alert('添加成功！', {icon: 1});
						 setTimeout(function(){
							 window.location.href="lunbo.jsp";
						 },3000);
					}else if(obj == 2){
						 layer.alert('请勿重复添加！', {icon: 2});
						 setTimeout(function(){
							 window.location.href="lunbo.jsp";
						 },3000);
					}
				}, 
				error: function(data){ 
					window.location.href="error.jsp";
				}
			});
	}
	 function quxiao(){
		 window.location.href="lunbo.jsp"; 
	 }
</script>
</body>
</html>