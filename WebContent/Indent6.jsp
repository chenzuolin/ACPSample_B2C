<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="./laydate/laydate.js"></script> <!-- 改成你的路径 -->
<link rel="stylesheet" href="./layui/css/layui.css">
<style type="text/css">
th{text-align: center;float: inherit; color: black; height: 40px;}
</style>
</head>
<body>
<table class="layui-table"  style=" width:80%; margin-left:10%; table-layout: fixed;">
	<tr>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单编号</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单时间</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单状态</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>酒店名称</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>订单详情</strong></th>
		<th style="text-align:center; background:rgb(0,150,136); color:#fff;" ><strong>功能操作</strong></th>
	</tr>
		
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	IndentDao dao = new IndentDao();
	List<Indent> list = dao.findAll();
	System.out.print(list);
	for(Indent indent : list){
		String jj = indent.getIndent_Status();
		if(jj.contains("配送中")){
			int aa = indent.getIndent_ID();
			String bb = indent.getIndent_Time();
			String cc = indent.getIndent_Status();
			List<Indent> list2 = dao.findUserByID(aa);
			for(Indent dd : list2){
				int Wineshop_ID = dd.getWineshop_ID();
				WineshopDao dao1 = new WineshopDao();
				List<Wineshop> list3 = dao1.findUserByID(Wineshop_ID);
				for(Wineshop wineshop : list3){
					String name = wineshop.getWineshop_Name();
	
%>
<tr>
		<td style="text-align:center;"><%=aa %></td>
		<td style="text-align:center;"><%=bb %></td>
		<td style="text-align:center;"><%=cc %></td>
		<td style="text-align:center;"><%=name %></td>
		<td style="text-align:center;"><a href="Indent2.jsp?id=<%=aa %>" class="layui-btn"  style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" > <i class="layui-icon">&#xe705;</i>查看订单</a></td>
		<td style="text-align:center;"><a href="WineshopIndexServlet?id=<%=aa %>" id="<%=aa %>" class="layui-btn"  style="padding: 0; margin: 0px ; width: 80px; font-size: 7px; height:25px; line-height: 25px ;" > <i class="layui-icon">&#x1005;</i>确认收货</a>
		<script type="text/javascript">
// 两秒后模拟点击
setTimeout(function() {
	// IE
	if(document.all) {
		document.getElementById("<%=aa %>").click();
	}
	// 其它浏览器
	else {
		var e = document.createEvent("MouseEvents");
		e.initEvent("click", true, true);
		document.getElementById("<%=aa %>").dispatchEvent(e);
	}
}, 86400000);
</script>
		<%
				}
				}
	}
} 
%>
</table>
<script src="./js/layui.js"></script> <!-- 改成你的路径 -->

<script>
//执行一个laydate实例
laydate.render({
  elem: '#date1' //指定元素
});
laydate.render({
  elem: '#date2' //指定元素
});
</script>
</body>
</html>