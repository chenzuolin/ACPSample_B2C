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
	float zz = 0;
	IndentDao dao1 = new IndentDao();
	List<Indent> list = dao1.findUserByID0();
	for(Indent indent : list){
		int aa = indent.getIndent_ID();
		TotalDao dao = new TotalDao();
		List<Total> list1 = dao.findUserByID1(aa);
		for(Total total : list1){
			float bb = total.getTotal();
			zz += bb ;
%>
<%
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
         title:'<h style="color:skyblue;">当天总销售额</h>',
         anim: 1,
         skin: 'demo-class',//允许全屏最小化
         content: '<div style="width:400px;height:157px;background:rgb(95,184,120);text-align:center;line-height:154px;font-size:20px;">该酒店今日消费了：<span style="color:red;">￥<%=zz %><span>元</div>' 
       });
   }); 
</script>
</body>
</html>