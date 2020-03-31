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
float aa = 0;//总价
List<Indent> list = (List<Indent>)request.getAttribute("list");//当天的所有订单
int bb = (Integer)request.getSession().getAttribute("bb");//酒店ID
for(Indent indent : list){
	int cc = indent.getWineshop_ID();
	if(cc==bb){
		int ee = indent.getIndent_ID();
		TotalDao dao = new TotalDao();
		List<Total> list1 = dao.findUserByID1(ee);
		for(Total total : list1){
			float ff = total.getTotal();
			aa += ff;
%>	
<%
}
	}
}

%>
<script src="layui/layui.js"></script>
 <script>
 layui.use('layer', function(){
     var layer = layui.layer;

     layer.open({
         type: 1, 
         area: ['400px', '200px'],
         maxmin: true ,
         title:'<h style="color:skyblue;">当天酒店销售额</h>',
         anim: 1,
         skin: 'demo-class',//允许全屏最小化
         content: '<div style="width:400px;height:157px;background:rgb(95,184,120);text-align:center;line-height:154px;font-size:20px;">该酒店今日消费了：<span style="color:red;">￥<%=aa %><span>元</div>' 
       });
   }); 
</script>
</body>
</html>