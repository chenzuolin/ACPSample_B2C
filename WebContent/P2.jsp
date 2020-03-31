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
	String aa = request.getSession().getAttribute("bb").toString();
	String uu = request.getSession().getAttribute("zz").toString();
	GreensDao dao = new GreensDao();
	int bb = dao.findUserByID2(aa);

	List<Indent> list = (List<Indent>)request.getAttribute("list");
	for(Indent indent : list){
		int cc = indent.getIndent_ID();
		OrderDao dao1 = new OrderDao();
		List<Order> list1 = dao1.findUserByID1(cc);
		for(Order order : list1){
			int dd = order.getGreens_ID();
			if(dd==bb){
				int ee = order.getNumber();
				zz += ee;
			}
		}
	}
	List<Greens> list0 = dao.findUserByID(bb);
	for(Greens greens : list0){
		String  yy = greens.getGreens_Unit();
%>
<script src="layui/layui.js"></script>
 <script>
 layui.use('layer', function(){
     var layer = layui.layer;

     layer.open({
         type: 1, 
         area: ['400px', '200px'],
         maxmin: true ,
         title:'<h style="color:skyblue;"><strong>酒店采购量</strong></h>',
         anim: 1,
         content: '<div style="width:500px;height:200px;background:rgb(95,184,120);text-align:center;line-height:120px;font-size:20px;"><strong>酒店名称为:<span style="color:#009688;"><%=uu %></span>共购买了<span style="color:green;"><%=aa %><%=zz %><%=yy %></span></strong></div>' 
       });
   }); 
</script>
		
<%
	}
%>

</body>
</html>