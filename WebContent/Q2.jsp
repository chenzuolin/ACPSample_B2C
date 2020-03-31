<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int zz = 0;
	List<Indent> list = (List<Indent>)request.getAttribute("list");//订单本周信息
	int aa = (Integer)request.getSession().getAttribute("bb");//蔬菜编号

	
	for(Indent indent : list){
		int bb = indent.getIndent_ID();
		OrderDao dao = new OrderDao();
		List<Order> list1 = dao.findUserByID1(bb);
		for(Order order : list1){
			int cc = order.getGreens_ID();
			if(aa==cc){
				int dd = order.getNumber();
				zz += dd;
			}
		}
	}
	GreensDao dao1 = new GreensDao();
	List<Greens> list2 = dao1.findUserByID(aa);
	for(Greens greens : list2){
		String dd = greens.getGreens_Name();
		String ff = greens.getGreens_Unit();
%>
<script src="layui/layui.js"></script>
 <script>
 layui.use('layer', function(){
     var layer = layui.layer;

     layer.open({
         type: 1, 
         area: ['400px', '200px'],
         maxmin: true ,
         title:'<h style="color:#000;font-size:15px;"><strong>本周蔬菜周销量</strong></h>',
         anim: 1,
         content: '<div style="width:400px;height:157px;background:rgb(95,184,120);text-align:center;line-height:154px;font-size:20px;">本周<span style="color:#009688;"><%=dd %></span>的采购量为：<span style="color:red;"><%=zz %><%=ff %></span></div>' 
       });
   }); 
 
</script>

<%
	}
%>

</body>
</html>