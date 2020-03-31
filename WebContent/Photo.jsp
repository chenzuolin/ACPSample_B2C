<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="com.sec.entity.*"%>
<%@ page import="com.sec.dao.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>酒店首页图片上传</title>
<style>
	fieldset{
		padding:10px 10%;
	}
	legend{
		font-size:20px;
	}
	form{
		position: relative;
	}
</style>
</head>
<body>
<form name="form1" action="${pageContext.request.contextPath }/PhotoServlet"  method="post" enctype="multipart/form-data" class="layui-form layui-form-pane">
	<div class="layui-card" >
  		<div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;">酒店首页轮播图片上传 </div>
  			<div style="margin:25px auto;">
  				<fieldset>
       	 			<legend>酒店首页轮播图片上传</legend>
       	 				<div class="layui-inline">
							<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:73px;"><strong>图片上传</strong></label>
								<div class="layui-input-inline" style="margin-left:-4px;">
									<input type="file" lay-verify="required" required name="file" style="width:186px;" id="test1" multiple="multiple"  class="layui-input" >
								</div>
						</div>
						<div class="layui-inline" style="margin-top: 5px; ">
								<div class="layui-input-inline">
									<button class="layui-btn" type="submit" style="margin-left:60px;width:120px;background:rgb(126,126,126);"><i class="layui-icon">&#xe62f;</i>提交</button>
								</div>
						</div>
				</fieldset>
			</div>
	</div>
 </form>
</body>
</html>