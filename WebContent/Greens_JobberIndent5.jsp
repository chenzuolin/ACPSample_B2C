<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="java.util.*"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="layui/css/layui.css">
<style type="text/css">

.layui-input{
	width:142px;
	margin-top:-1px;
	margin-left:-4px;
	text-align:center;
}
.layui-btn{padding:0px;
margin:0px;
width:60px;


text-align:center;
margin-top:5px;
}

}
.nva{
	margin-left:103px;
}

</style>
</head>
<body>
<%
	IndentDao dao = new IndentDao();
	OrderDao dao1 = new OrderDao();
	TotalDao dao5 = new TotalDao();
	GreensDao daoo = new GreensDao();
	WineshopDao dao6 = new WineshopDao();
	int aa = Integer.parseInt(request.getParameter("id"));//订单编号
	System.out.print(aa);
	List<Total> list5 = dao5.findUserByID1(aa);
	List<Indent> list = dao.findUserByID(aa);
	List<Order> list1 = dao1.findUserByID1(aa);
	for(Total total : list5){
		float zz = total.getTotal();//订单总价
	for(Indent indent : list){
		String bb = indent.getIndent_Time();//订单时间
		String cc = indent.getIndent_Status();//订单状态
		System.out.print(bb);
		System.out.print(cc);
		int a = indent.getWineshop_ID();//蔬菜编号
		List<Wineshop> list11 = dao6.findUserByID(a);
		for(Wineshop wineshop : list11){
			String b = wineshop.getWineshop_Name();//酒店名称
			String c = wineshop.getWineshop_Address();//酒店地址
			
			
		
			
			
			
			
			
			
			
					%>
				
	
	
			
		

<div class="layui-card">
  <div class="layui-card-header" style="background-color:#009688;color: white;font-size:15px;height: 30px ; line-height: 30px;">订单详情
  </div>
</div>

<div class="nva">
	<div class="layui-inline" style="margin-top: 5px; margin-left: 100px;">
		<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:-65px; width:121px;">订单编号</label>
			<div class="layui-input-inline">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=aa %>">  		
		  	</div>
	</div>	
	<div class="layui-inline" style="margin-top: 5px; padding-left: 10px;">
		<label class=" layui-btn" style="background:rgb(126,126,126); color:#fff; width:121px;">订单时间</label>
		  	<div class=" layui-input-inline">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=bb %>">
			</div>
	</div>
	<div class="layui-inline" style="margin-top: 5px; padding-left: 10px;">
		<label class=" layui-btn" style="background:rgb(126,126,126); color:#fff; width:121px;">订单状态</label>
		  	<div class=" layui-input-inline">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=cc %>">
			</div>
	</div>
	<br/>
	<div class="layui-inline" style="margin-top: 15px; margin-left: 35px;">
		<label class=" layui-btn" style="background:rgb(126,126,126); color:#fff; width:121px;">订单总价</label>
		  	<div class=" layui-input-inline">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="￥<%=zz %>">
			</div>
	</div>
	<div class="layui-inline" style="margin-top: 15px; padding-left: 10px;">
		<label class=" layui-btn" style="background:rgb(126,126,126); color:#fff; width:121px;">酒店名称</label>
		  	<div class=" layui-input-inline">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=b %>">
			</div>
	</div>
	<div class="layui-inline" style="margin-top: 15px; padding-left: 10px;">
		<label class=" layui-btn" style="background:rgb(126,126,126); color:#fff; width:121px;">酒店地址</label>
		  	<div class=" layui-input-inline">
		  		<input type="text" required name="s1" lay-verify="required" readonly="readonly" class="layui-input" value="<%=c %>">
			</div>
	</div>
</div>

				
		
		<label class="layui-btn layui-btn-primary" style="margin-left:30px;font-werght:normal;!important" >名称</label>
		<label class="layui-btn layui-btn-primary" style="margin-left:30px" >数量</label>
			<label class="layui-btn layui-btn-primary" style="margin-left:30px"  >单位</label>
				<label class="layui-btn layui-btn-primary" style="margin-left:30px">类型</label>
				<label class="layui-btn layui-btn-primary" style="margin-left:30px" >价格</label>
			
					<label class="layui-btn layui-btn-primary" style="margin-left:30px">市场价</label>
						<label class="layui-btn layui-btn-primary" style="margin-left:30px" >品质</label>
							<label class="layui-btn layui-btn-primary" style="margin-left:30px" >品相</label>
								<label class="layui-btn layui-btn-primary" style="margin-left:30px" >备注</label>
							<label class="layui-btn layui-btn-primary" style="margin-left:30px">客户需求</label>
		
		<br/>
	
	<% 
	
		}
	}
	}
	 

		%>
		<%
		
		String bbb = null;
		List list0 = new ArrayList();
		HashSet set = new HashSet();
		System.out.print(list0);
		for(Order order : list1){
			int aaa = order.getGreens_ID();
			
			List<Greens> listt = daoo.findUserByID(aaa);
			for(Greens greens : listt){
		String ppp = greens.getGreens_Type_Name();
				list0.add(ppp);
					
				}
			}
	for(int i=0; i<list0.size();i++){
		set.add(list0.get(i));
	}
	List kj = new ArrayList();
	kj.addAll(set);
	for(int i=0;i<kj.size();i++){
		String jjj = kj.get(i).toString();
		
		%>
		<%=jjj %>:<br/>
		<%
			for(Order order : list1){
				String zz1 = order.getOrder_Remark();
				int ee = order.getNumber();
				int ccc = order.getGreens_ID();
				List<Greens> list01 = daoo.findUserByID(ccc);
				for(Greens cccc : list01){
					String c1 = cccc.getGreens_Type_Name();
					if(jjj.contains(c1)){
						String ff = cccc.getGreens_Name();
						float gg = cccc.getGreens_Price();
						float hh = cccc.getGreens_Market_Price();
						String ii = cccc.getGreens_Type_Name();
						String ll = cccc.getGreens_Unit();
						String mm = cccc.getGreens_Character();
						String nn = cccc.getGreens_Remark();
						String oo = cccc.getGreens_Condition();
						%>
						
						<label class="layui-btn layui-btn-primary" style="margin-left:30px"  ><%=ff %></label>
		<label class="layui-btn layui-btn-primary" style="margin-left:30px"  ><%=ee %></label>
			<label class="layui-btn layui-btn-primary" style="margin-left:30px"  ><%=ll %></label>
				<label class="layui-btn layui-btn-primary" style="margin-left:30px"  ><%=ii %></label>
				<label class="layui-btn layui-btn-primary" style="margin-left:30px" ><%=gg %></label>
					<label class="layui-btn layui-btn-primary" style="margin-left:30px"><%=hh %></label>
						<label class="layui-btn layui-btn-primary" style="margin-left:30px" ><%=mm %></label>
							<label class="layui-btn layui-btn-primary" style="margin-left:30px"><%=oo %></label>
								<label class="layui-btn layui-btn-primary"  style="margin-left:30px"><%=nn %></label>
							<label class="layui-btn layui-btn-primary" style="margin-left:30px" ><%=zz1 %></label>
							
							<br/>
							
						<%
					}
				}
				
			}
		%>
		<%
		}

	%>

	
	<div class="layui-inline">
		<div class="layui-input-inline">
			<button class="layui-btn" type="submit" style="margin-left:1108px; width:121px; background:#00adff;" onclick='javascript:window.print()'><i class="layui-icon"></i>打印</button>
		</div>
	</div>
</body>
</html>