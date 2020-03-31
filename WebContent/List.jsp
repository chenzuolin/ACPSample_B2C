<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="com.sec.entity.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="./css/layui.css">
 <link rel="stylesheet" href="./layui/css/layui.css">
<style>
th{color:black;
text-align:center}
.layui-input-inline{
	text-align:center;
}
.layui-input{
		text-align:center;
		word-break:keep-all;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
}
.layui-input:hover{
	background:skyblue;
}
.layui-table td{
	padding:0px;
}
</style>
<script type="text/javascript">
 $('#btn').on('onclick',function(){
	 $id = $("#Greens_ID").text();
	 window.location.href=contextPath+"/GreensUPServlet?id="+$id;
 })
 </script>

</head>
<body >
<form action="LLServlet" method="post">
	 <script type="text/javascript">
	 setInterval(function() {
	// IE
	
	if(document.all) {
		document.getElementById("a").click();
	}
	// 其它浏览器
	else {
		var e = document.createEvent("MouseEvents");
		e.initEvent("click", true, true);
		document.getElementById("a").dispatchEvent(e);
	}
},1000)

	
	
</script>
<table class="layui-table" style=" table-layout: fixed;">
<thead>
 <tr >
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>编号</strong></th>
    <th style="display:none">类型</th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>名称</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>单位</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>品质</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>保质期</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>重量</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>库存量</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>单价</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>市场价</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>品向</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>最少购买</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>蔬菜产地</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>等级</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>季节性</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>推荐</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;"><strong>备注</strong></th>
    <th style="text-align:center; background:rgb(0,150,136); color:#fff;width:121px;"><strong>功能操作</strong></th>
    </tr>
    </thead>
<%
List<Greens> list = (List<Greens>)request.getAttribute("list");
if (list == null || list.size() < 1) {
	out.print("没有数据！");
} else {
	for(Greens greens : list){

%>


    <tr>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="a" id="firstname" class="layui-input" value="<%=greens.getGreens_ID() %>">
		</div>
    </td>
    <td style="display:none">
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="q" id="firstname" class="layui-input" value="<%=greens.getGreens_Type_Name() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="b" id="firstname" class="layui-input" value="<%=greens.getGreens_Name() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="c" id="firstname" class="layui-input" value="<%=greens.getGreens_Unit() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="d" id="firstname" class="layui-input" value="<%=greens.getGreens_Character() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="e" id="firstname" class="layui-input" value="<%=greens.getGreens_Preiod() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="f" id="firstname" class="layui-input" value="<%=greens.getGreens_Norms() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="g" id="firstname" class="layui-input" value="<%=greens.getGreens_Number() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="h" id="firstname" class="layui-input" value="<%=greens.getGreens_Price() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="i" id="firstname" class="layui-input" value="<%=greens.getGreens_Market_Price() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="j" id="firstname" class="layui-input" value="<%=greens.getGreens_Condition() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="k" id="firstname" class="layui-input" value="<%=greens.getGreens_Minnumber() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="l" id="firstname" class="layui-input" value="<%=greens.getGreens_Class() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="m" id="firstname" class="layui-input" value="<%=greens.getGreens_Grade() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="n" id="firstname" class="layui-input" value="<%=greens.getGreens_characteristics() %>">
		</div>
   	</td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="o" id="firstname" class="layui-input" value="<%=greens.getGreens_Recommend() %>">
		</div>
    </td>
    <td>
    	<div class="layui-input-inline">
			<input type="text" lay-verify="required" readonly="readonly" required name="p" id="firstname" class="layui-input" value="<%=greens.getGreens_Remark() %>">
		</div>
   </td>
    <td style="width:121px;">
    	<div class="layui-input-inline">
		    <a href="GreensUP1.jsp?id=<%=greens.getGreens_ID() %>" style="color:skyblue;margin-left:25px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
			<a href="DEservlet?id=<%=greens.getGreens_ID() %>" style="color:red;" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>
		</div>
	</td>
    </tr>
    <%
	    	}
		}
	%>
    
   
    </table>
    <input style="display: none;" type="submit" value="提交" id="a">
</form>
</body>
</html>