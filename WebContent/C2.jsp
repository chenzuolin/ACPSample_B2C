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
	TotalDao dao = new TotalDao();
	float zz = 0;
	float z = 0;
	float xx = 0;
	float x = 0;
	List<Indent> list = (List<Indent>)request.getAttribute("list");
	List<Indent> list1 = (List<Indent>)request.getAttribute("list1");
	float aa = Float.parseFloat(request.getSession().getAttribute("aa").toString());
	float a = 0;
	a = aa / 100;
	System.out.print(a);
	for(Indent indent : list){
		int bb = indent.getIndent_ID();
		List<Total> list2 = dao.findUserByID1(bb);
		for(Total total : list2){
			float cc = total.getTotal();
			zz += cc;
		}
	}
	z = zz*a;
	for(Indent indent : list1){
		int bb = indent.getIndent_ID();
		List<Total> list2 = dao.findUserByID1(bb);
		for(Total total : list2){
			float cc = total.getTotal();
			xx += cc;
		}
	}
	x = xx*a;
%>
<script src="layui/layui.js"></script>
 <script>
 layui.use('layer', function(){
     var layer = layui.layer;

     layer.open({
         type: 1, 
         area: ['500px', '186px'],
         maxmin: true ,
         title:'<h style="color:skyblue;font-size:15px;"><strong>利润分配</strong></h>',
         anim: 1,
         content: '<div style="width:500px;height:143px;background:rgb(95,184,120);text-align:center;line-height:62px;font-size:15px;"><span style="color:#009688;">当天</span>营业总额为:<span style="color:red;">￥<%=zz %></span>元,分润为:<span style="color:orange;"">￥<%=z %></span><br/><span style="color:#009688;">本月</span>营业总额为:<span style="color:red;"">￥<%=xx %></span>,分润为:<span style="color:orange;">￥<%=x %></span></div>' 
       });
   }); 
</script>
</body>
</html>