<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.List"%>
<%@ page import="com.sec.entity.*"%>
<%@ page import="com.sec.dao.GreensDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 <link rel="stylesheet" href="layui/css/layui.css">

</head>
<body style="padding-left:25px;">
              
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px; width:1350px; text-align:center; ">
  <legend>采购商品</legend>
</fieldset>
 
<div class="layui-tab" style="width:1320px; text-align:center ;margin-top: 20px;">
  <ul class="layui-tab-title">
    <li class="layui-this">综合排序</li>
    <li>销量排序</li>
    <li>绿盟优惠</li>

  </ul>
  <table width="1320" border="1" style="margin-top:5px; border-color:#999">
  <tr>
    <th width="220" height="220" scope="col"><img src="../404/404-01.jpg" width="220" height="220"></th>
    <th width="220" scope="col"><img src="../404/404-01.jpg" width="220" height="220"></th>
    <th width="220" scope="col"><img src="../404/404-01.jpg" width="220" height="220"></th>
    <th width="220" scope="col"><img src="../404/404-01.jpg" width="220" height="220"></th>
    <th width="220" scope="col"><img src="../404/404-01.jpg" width="220" height="220"></th>
    <th width="220" scope="col"><img src="../404/404-01.jpg" width="220" height="220"></th>
    </tr>
    <% 
               //防止中文乱码
               request.setCharacterEncoding("UTF-8");
            
               GreensDao dao = new GreensDao(); 
               List<Greens> list = dao.findAll();
               if(list!=null&&list.size()>0){
	               for(int i=0;i<list.size();i++){
	                  Greens greens = list.get(i);
           %>   
  <tr>
    <td width="220" height="110">&nbsp;

    </td>
    <td width="220px" height="110px">名称:<%=greens.getGreens_Name() %>;单价:<%=greens.getGreens_Price() %>;单价：<%=greens.getGreens_Price() %>;市场价：<%=greens.getGreens_Market_Price() %>;
                产地:<%=greens.getGreens_Class() %>; 保质期:<%=greens.getGreens_Preiod() %>;品质：<%=greens.getGreens_Character() %>;品相：<%=greens.getGreens_Condition() %>;
    最少采购量：<%=greens.getGreens_Minnumber() %>;规格：<%=greens.getGreens_Norms() %>;库存量：<%=greens.getGreens_Number() %>;产地：<%=greens.getGreens_Class() %>;
                季节性蔬菜:<%=greens.getGreens_characteristics() %>;等级：<%=greens.getGreens_Grade() %>;是否推荐：<%=greens.getGreens_Recommend() %>;备注：<%=greens.getGreens_Remark() %>;</td>
               <a href="cart1.jsp" style="color:red; font-family:'Trebuchet MS', Arial, Helvetica, sans-serif">查看购物车</a>
                <a href="cart1.jsp" style="color:red; font-family:'Trebuchet MS', Arial, Helvetica, sans-serif; float:right">加入购物车</a></td>

  </tr>
</table>
<%
	               }
               }
%>
  
    </div>
   

</body>

</html>
