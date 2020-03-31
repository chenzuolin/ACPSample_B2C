<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<link href="js/jquery.js" rel="stylesheet">
<title>Insert title here</title>
<style>
	.layui-inline{
		margin-right:10px;
	}
	.layui-input{
		margin-left:-5px;
		text-align:center;
		background:orange;
		margin-top:-1px;
	}
</style>
</head>
<body>
<table class="layui-table" style=" width:80%; margin-left:10%; table-layout: fixed;">
<tr>
	<th style="text-align:center; background:rgb(238,238,238);  color:#000;">蔬菜名称</th>
	<th style="text-align:center; background:rgb(238,238,238);  color:#000;">蔬菜数量</th>
		<th style="text-align:center;background:rgb(238,238,238);  color:#000;">蔬菜单位</th>
	
</tr>

<%
IndentDao dao=new IndentDao();
List<Indent> list=dao.findUserByIDweek();
System.out.print(list);
int id=(Integer)request.getSession().getAttribute("id");
WineshopDao WDao = new WineshopDao();
List<Wineshop> WList = WDao.findUserByID(id);
String username = null;
for(Wineshop wineshop : WList){
	username = wineshop.getWineshop_Name();
}
float total=0;
float Total = 0;
for(Indent indent:list){
	int Wineshop=indent.getWineshop_ID();
	if(Wineshop == id){
		int ID=indent.getIndent_ID();
		System.out.print(ID);
		OrderDao dao1=new OrderDao();
		List<Order> list1=dao1.findUserByID1(ID);
		System.out.print(list1);
		for(Order order:list1){
			int Greens_ID=order.getGreens_ID();
			int Number=order.getNumber();
			System.out.print(Greens_ID);
			GreensDao dao2=new GreensDao();
			List<Greens> list2=dao2.findUserByID(Greens_ID);
			System.out.print(list2);
			for(Greens greens:list2){
				float Greens_Market_Price=greens.getGreens_Market_Price();
				float aa=Greens_Market_Price*Number;
				float Greens_Price=greens.getGreens_Price();
				float bb=Greens_Price*Number;
				float totle=aa-bb;
				total+=totle;
				 Total = (float)(Math.round(total*100))/100;
			}
		}
	}
	else{
		PrintWriter out1 = response.getWriter();
		
	}
}

int Wineshop_ID=(Integer)request.getSession().getAttribute("id");
OrderDao dao88= new OrderDao();
List<shuliang> list88 = dao88.findAll10(Wineshop_ID);
for(shuliang s : list88){
	String aa = s.getGreens_Name();
	int value = s.getNumber();
	String bb = s.getGreens_Unit();
%>

<tr>
				<td style="text-align:center;"><%=aa %></td>
				<td style="text-align:center;"><%=value %></td>
				<td style="text-align:center;"><%=bb %></td>
</tr>
<%
		}
	
	
%>
</table>   
<script src="layui/layui.js"></script>
 <script>
 layui.use('layer', function(){
     var layer = layui.layer;

     layer.open({
         type: 1, 
         area: ['400px', '200px'],
         maxmin: true ,
         title:'周数据分析',
         anim: 1,
         content: '<fieldset class="layui-elem-field"><legend>数据分析</legend><div class="layui-field-box"><table class="layui-table"><tbody><tr><th>店铺名称</th><td><%=username %></td></tr><tr> <th>节约金额</th><td><%=total %></td></tr></tbody></table></div></fieldset>' 
       });
   }); 
        </script>

</body>
</html>