<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详细信息</title>
   <link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
   <script src="./laydate/laydate.js"></script> <!-- 改成你的路径 -->
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<link rel="stylesheet" type="text/css" href="layui-v2.4.3/layui-v2.4.3/layui/css/layui.css"/>
<style type="text/css">

.layui-input{
	width:142px;

	text-align:center;
}

.layui-input{width: 150px;}
			.layui-form-item{display: inline-block;padding-left: 50px;}


}
.nva{
	margin-left:103px;
}
th{text-align: center !important;}
td{text-align: center !important;}
</style>
</head>
<body>
	<form class="layui-form layui-form-pane">
	<div class="nva">
	<%
		int aa = Integer.parseInt(request.getParameter("id"));//Indent_ID
		int bb = (Integer)request.getSession().getAttribute("id");//Wineshop_ID
		IndentDao dao4 = new IndentDao();
		List<Indent> list4 = dao4.findUserByID(aa);
		int zz = 0;
		for(Indent indent : list4){
			zz = indent.getIndent_ID();
			String yy = indent.getIndent_Time();
			String xx = indent.getIndent_Status();
			%>
			  <div class="layui-form-item">
		<label class="layui-form-label" style="background:rgb(126,126,126); ">订单编号</label>
			<div class="layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=zz %>">  		
		  	</div>
	</div>
		<div class="layui-form-item" >
		<label class=" layui-form-label" style="background:rgb(126,126,126); ">下单时间</label>
			<div class="layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=yy %>">  		
		  	</div>
	</div>
	<div class="layui-form-item" >
		<label class=" layui-form-label" style="background:rgb(126,126,126); ">订单状态</label>
			<div class="layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=xx %>">  		
		  	</div>
	</div>	
	<%
		}
		TotalDao dao5 = new TotalDao();
		List<Total> list5 = dao5.findUserByID1(zz);
		for(Total total : list5){
			Float vv = total.getTotal();
			float cn = total.getFare();
			float wn = total.getGreens();
	%>
	<div class="layui-form-item" >
		<label class=" layui-form-label" style="background:rgb(126,126,126);">蔬菜费用</label>
			<div class="layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=wn %>">  		
		  	</div>
	</div>
	<div class="layui-form-item" >
		<label class=" layui-form-label" style="background:rgb(126,126,126);">物流费用</label>
			<div class="layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=cn %>">  		
		  	</div>
	</div>
	
	<div class="layui-form-item" >
		<label class=" layui-form-label" style="background:rgb(126,126,126);">订单总价</label>
			<div class="layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=vv %>">  		
		  	</div>
	</div>
	<%	
		}
		%>
		
		<%
		WineshopDao dao = new WineshopDao();
		List<Wineshop> list = dao.findUserByID(bb);
		for(Wineshop wineshop : list){
			String cc = wineshop.getWineshop_Name();
			String dd = wineshop.getWineshop_Address();
			String ee = wineshop.getWineshop_Telephone();
			String ff = wineshop.getWineshop_Shift_Name();
	%>
	
	<div class="layui-form-item" >
		<label class="layui-form-label" style="background:rgb(126,126,126); ">酒店名称</label>
			<div class="layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=cc %>">  		
		  	</div>
	</div>	
	<div class="layui-form-item" >
		<label class="layui-form-label" style="background:rgb(126,126,126); ">酒店地址</label>
		  	<div class=" layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=dd %>">
			</div>
	</div>
	<div class="layui-form-item" >
		<label class=" layui-form-label" style="background:rgb(126,126,126);">联系电话</label>
		  	<div class=" layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=ee %>">
			</div>
	</div>
	
	<div class="layui-form-item" >
		<label class="layui-form-label" style="background:rgb(126,126,126); ">联系人</label>
		  	<div class=" layui-input-block">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=ff %>">
			</div>
	</div>
	
</div>
	
	<table style="margin-top:20px;" class="layui-table">
	<tr>
	<th>蔬菜名称</th>
	<th>速盟单价</th>
	<th>市场单价</th>
	<th>蔬菜数量</th>
	</tr>
	
	<%
		}
		IndentDao dao2 = new IndentDao();
		List<Indent> list2 = dao2.findUserByID(aa);
		for(Indent indent : list2){
			String ii = indent.getIndent_Status();
			String jj = indent.getIndent_Time();
			int kk = indent.getIndent_ID();
		}
		OrderDao dao1 = new OrderDao();
		List<Order> list1 = dao1.findUserByID1(aa);
		for(Order order : list1){
			int gg = order.getGreens_ID();
			int hh = order.getNumber();
			GreensDao dao3 = new GreensDao();
			List<Greens> list3 = dao3.findUserByID(gg);
			for(Greens greens : list3){
				String ll = greens.getGreens_Name();
				Float mm = greens.getGreens_Market_Price();
				Float nn = greens.getGreens_Price();
				String oo = greens.getGreens_Unit();
	%>
	<tr>
	<td><%=ll %></td>
	<td><%=nn %></td>
	<td><%=mm %></td>
	<td><%=hh %><%=oo %></td>
	

	<%
			}
		}
	%>
		</table>
		<div class="layui-form-item" >
		
		  	<div class=" layui-input-block"style="float:right">
		  		<a href = "DY.jsp?name=<%=bb %>&id=<%=aa %>" class="layui-btn" >打印</a>
			</div>
	</div>
		
	</form>
	
</body>
</html>