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
	List<Indent> list = (List<Indent>)request.getAttribute("list");
	for(Indent indent : list){
			int dd = indent.getIndent_ID();
			TotalDao dao1 = new TotalDao();
			List<Total> list1 = dao1.findUserByID1(dd);
			for(Total total : list1){
				float ee = total.getTotal();
				zz += ee;
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
         title:'<h style="color:skyblue;font-size:15px;"><strong>本店总营业额</strong></h>',
         anim: 1,
         content: '<div style="width:400px;height:157px;background:rgb(95,184,120);text-align:center;line-height:154px;font-size:20px;"><strong>本店的总营业额为:<span style="color:red;">￥<%=zz %></span>元</strong></div>' 
       });
   }); 
</script>
</body>
</html>