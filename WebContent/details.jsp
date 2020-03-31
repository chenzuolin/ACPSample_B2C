<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@ page import="com.sec.entity.*"%>
<%@ page import="com.sec.dao.*"%>
<%
      String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情页面</title>
<link href="layui/css/layui.css" rel="stylesheet" media="all">

<style type="text/css">
	*{margin:0 ;
	padding: 0;}
.layui-inline{
	margin-top:20px;
	
}
#firstname{
	text-align:center;
}
.layui-inline:hover{
	cursor:pointer;
}
.nva{
	margin:50px auto;
}
legend{
	font-size:20px;
]}
</style>
</head>
<body>
<form action="JoincartServlet" method="post" name="myForm">
<div class="nva">
          <% 
                 GreensDao dao = new GreensDao();
                 List<Greens> list = dao.findUserByID((Integer)request.getSession().getAttribute("yy"));
                 for(Greens greens : list){
          %>
         
          <input type="text" value="<%=greens.getGreens_ID() %>" style="display:none" name="x">
          	<fieldset>
 			<legend>蔬菜详情</legend>
 			<div> <img  src="http://211.149.232.210/ACPSample_B2C/img/<%=greens.getGreens_tupian() %>" style=" width: 120px;; height: 120px;display: block; margin-top: 100px;margin-left:20px; position: absolute;"></div>
          <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:200px;">蔬菜名称</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:-2px;" >
				<input type="text" lay-verify="required" required name="Greens_Name" id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Name() %>">
			</div>
		 </div>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">蔬菜单位</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:-2px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Unit() %>">
			</div>
		 </div>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">蔬菜单价</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:-2px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Price() %>">
			</div>
		 </div>
		 <br/>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:200px;">市场价</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required name="Greens_Name" id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Market_Price() %>">
			</div>
		 </div>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">蔬菜产地</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Class() %>">
			</div>
		 </div>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">保质期</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Preiod() %>">
			</div>
		 </div>
		 <br/>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:200px;">蔬菜品相</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required name="Greens_Name" id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Condition() %>">
			</div>
		 </div>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">蔬菜品质</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Character() %>">
			</div>
		 </div>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">最少采购</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Minnumber() %>">
			</div>
		 </div>
		 <br/>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:200px;">蔬菜规格</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required name="Greens_Name" id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Norms() %>">
			</div>
		 </div>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">库存量</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Number() %>">
			</div>
		 </div>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">季节性</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_characteristics() %>">
			</div>
		 </div>
		 <br/>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:200px;">蔬菜等级</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Grade() %>">
			</div>
		 </div>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">推荐</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Recommend() %>">
			</div>
		 </div>
		 <%
		 	DynamicDao dao2 = new DynamicDao();
		 	List<Dynamic> lists = dao2.findUserByID1((Integer)request.getSession().getAttribute("yy"));
		 	for(Dynamic dynamic : lists){
		 		
		 	
		 %>
		  <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">最新更新时间</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=dynamic.getDynamic_Time() %>">
			</div>
		 </div>
		 <%
		 	}
		 %>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:80px;">蔬菜备注</label>
			<div class="layui-input-inline" style="margin-left:-4px;margin-top:0px;" >
				<input type="text" lay-verify="required" required id="firstname" class="layui-input" readonly="readonly" value="<%=greens.getGreens_Remark() %>">
			</div>
		 </div>
		 <br/>
		 <div class="layui-inline">
			<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:200px;">购买数量</label>
			<div class="layui-input-inline" style="margin-left:px;margin-top:-30px;" >
				<div class="layui-inline" style="margin-left:-4px;margin-top:30px;width:182px;">
					<input type="text" lay-verify="required" style="text-align:center;" name="number"  id="number" class="layui-input"  >
				</div>
			</div>
		 </div>
		 <div class="layui-inline">
			<div class="layui-input-inline">
				<button class="layui-btn" type="submit" style="width:121px;margin-left:80px;" onclick="validateForm()">加入购物车</button>
			</div>
		</div>
		<div class="layui-inline">
			<div class="layui-input-inline">
				<br/>
				<button class="layui-btn" onclick="this.form.action='cart2Servlet'" style="width:121px;margin-left:59px;margin-top:-16px">查看购物车</button>
				
			</div>
			
		</div>
  
          <% 
                  
                 }
          %>  
          
          </fieldset>   
</div> 
<script>
function validateForm(){
var x=document.forms["myForm"]["number"].value;
if (x==null || x==""){
  alert("请填写数量");
  
  }
}
</script>
   </form>
</body>
</html>