<%@ page language="java" import="com.sec.dao.*" import="com.sec.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.List"%>
     <%@page import="com.sec.entity.*"%>
     <%@page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="renderer" content="webkit">
<link href="css/layui.css" rel="stylesheet" media="all">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
<script>
function choose(Greens_characteristics){
if(Greens_characteristics.value=='1')
{
document.getElementById('div1').style.display='block';
}
else if(Greens_characteristics.value=='2')
{
document.getElementById('div1').style.display='none';
}
};
</script>
<style>
.layui-input{
		margin-left:-4px;
		width:203px;
		margin-top:-2px;
		word-break:keep-all;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	.layui-inline{
		margin:20px auto;
	}
</style>
</head>

<body>
<div style="background: #009688;  text-align: center; font-size: 20px; font: system; color:white; margin-bottom: 5px; height: 32px; line-height: 32px; width:100% ">
<h>修改商品</h>
</div>
<form action="GreensUPServlet" method="post"  >
<table>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	GreensDao dao = new GreensDao();
	List<Greens> list = dao.findUserByID(id);
	for(Greens greens : list){
	
%>

	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px;margin-top:6px;margin-left:100px;">蔬菜名称</label>
		<div class="layui-input-inline">
			<input type="text" lay-verify="required" required name="Greens_Name" id="firstname" class="layui-input" value="<%=greens.getGreens_Name() %>">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">蔬菜单位</label>
		<div class="layui-input-inline" >
			<select  name="Greens_Unit" class="layui-input" style="text-align:center;">
					<option value="<%=greens.getGreens_Unit() %>"><%=greens.getGreens_Unit() %></option>
					<%
						Greens_UnitDao dao6 = new Greens_UnitDao();
						List<Greens_Unit> list6 = dao6.findAll();
						for(Greens_Unit greens_Unit : list6){
							String danwei = greens_Unit.getGreens_Unit();
					%>
					 <option value="<%=danwei %>"><%=danwei %></option>
			       <%
						}
			       %>
			</select>
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">蔬菜单价</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Price" id="firstname" class="layui-input" value="<%=greens.getGreens_Price() %>">
			</div>
	</div>
  <br/>
  <div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px;margin-left:100px;">市场单价</label>
		<div class="layui-input-inline">
			<input type="text" lay-verify="required" required name="Greens_Market_Price" id="firstname" class="layui-input" value="<%=greens.getGreens_Market_Price() %>">
		</div>
  </div>
  <div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">蔬菜品质</label>
		<div class="layui-input-inline">
			<select name="Greens_Character" class="layui-input">
				<option value="<%=greens.getGreens_Character() %>"><%=greens.getGreens_Character() %></option>
					<%
						Greens_CharacterDao dao1 = new Greens_CharacterDao();
						List<Greens_Character> list1 = dao1.findAll();
						for(Greens_Character greens_Character : list1){
							String pingzhi = greens_Character.getGreens_Character();
					%>
				<option value="<%=pingzhi %>" ><%=pingzhi %></option>
					<%
						}
					%>
			</select>
		</div>
	</div>
  	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">蔬菜类型</label>
		<div class="layui-input-inline">
			<select name="Greens_Type_Name" class="layui-input">
			<option value="<%=greens.getGreens_Type_Name() %>"><%=greens.getGreens_Type_Name() %></option>
				 <%
					Greens_TypeDao dao5 = new Greens_TypeDao();
					List<Greens_Type> list5 = dao5.findAll();
					for(Greens_Type greens_Type : list5){
						String leixin = greens_Type.getGreens_Type_Name();
				%>
			<option value="<%=leixin %>"><%=leixin %></option>
		       <%
					}
		       %>
			</select>
		</div>
	</div>
	<br/>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px;margin-left:100px;">保质期</label>
		<div class="layui-input-inline">
			<input type="text" lay-verify="required" required name="Greens_Preiod" id="firstname" class="layui-input" value="<%=greens.getGreens_Preiod() %>">
		</div>
	</div>	
  	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">蔬菜品相</label>
			<div class="layui-input-inline">
				<select name="Greens_Condition" class="layui-input">
					<option value="<%=greens.getGreens_Condition() %>" ><%=greens.getGreens_Condition() %></option>
						 <%
							Greens_ConditionDao dao3 = new Greens_ConditionDao();
							List<Greens_Condition> list3 = dao3.findAll();
							for(Greens_Condition greens_Condition : list3){
								String pingxiang = greens_Condition.getGreens_Condition();
						%>
					<option value="<%=pingxiang %>"><%=pingxiang %></option>
				       <%
							}
				       %>
				</select>
			</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">最少采购量</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Minnumber" id="firstname" class="layui-input" value="<%=greens.getGreens_Minnumber() %>">
			</div>
	</div>
	<br/>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px;margin-left:100px;margin-left:100px;">蔬菜重量</label>
			<div class="layui-input-inline">
							<input type="text" lay-verify="required" required name="Greens_Norms" id="firstname" class="layui-input" value="<%=greens.getGreens_Norms() %>">
			
			</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">库存量</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Number" id="firstname" class="layui-input" value="<%=greens.getGreens_Number() %>">
			</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">蔬菜产地</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Class" id="firstname" class="layui-input" value="<%=greens.getGreens_Class() %>">
			</div>
	</div>
	<br/>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px;margin-left:100px;">蔬菜等级</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Grade" id="firstname" class="layui-input" value="<%=greens.getGreens_Grade() %>">
			</div>
	</div>
 	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">蔬菜推荐</label>
			<div class="layui-input-inline">
				<select name="Greens_Recommend" class="layui-input">
					<option value="<%=greens.getGreens_Recommend() %>" ><%=greens.getGreens_Recommend() %></option>
					<option value="是">是</option>
					<option value="否">否</option>
				</select>
			</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;margin-top:4px;">蔬菜备注</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Remark" id="firstname" class="layui-input" value="<%=greens.getGreens_Remark() %>">
			</div>
	</div>
	<br/>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px;margin-left:100px;">蔬菜季节</label>
			<div class="layui-input-inline">
				<select name="Greens_characteristics" class="layui-input" id="select">
					<option  value="<%=greens.getGreens_characteristics() %>"><%=greens.getGreens_characteristics() %></option>
					<option value="是">是</option>
					<option value="否" >否</option>
				</select>
			</div>
	</div>
	<div class="layui-inline" id="start" style="display:none">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">开始时间</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required"  name="Greens_characteristics" id="date1" class="layui-input"  placeholder="请输入开始时间">
			</div>
	</div>
	<div class="layui-inline" id="stop" style="display:none">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:50px;">结束时间</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required"  name="Greens_characteristics" id="date2" class="layui-input"  placeholder="请输入结束时间">
			</div>
	</div>
	<br/>

<script type="text/javascript"  src="./js/jquery.js" ></script>
<script>
	   
$(function(){
$('#select').click(function(){
var val = $('#select option:selected').val();
switch(val){
    case '否':
$('#start,#stop,#1').hide();
break;
case '是':
$('#start,#stop,#1').show();
break;
default:
break;
}
});

});



</script>

<tr>
<td>
<div  style="margin-left:-125px">
<input type="hidden"  class="btn btn-primary" name="id" value="<%=greens.getGreens_ID() %>"/>
<div class="layui-inline">
		<div class="layui-input-inline">
			<button class="layui-btn" id="button" type="submit" style="width:121px;margin-left:543px;">确定</button>
		</div>
	</div>
	<div class="layui-inline">
		<div class="layui-input-inline">
			<button class="layui-btn" type="reset" style="width:121px;margin-left:10px;">重置</button>
		</div>
	</div>
</div>
</td>
</table>
<%
	TimeDao dao11 = new TimeDao();
	List<Time> list11 = dao11.findAll();
	for(Time time : list11){
		int a = Integer.parseInt(time.getTime1());
		int b = Integer.parseInt(time.getTime2());
	

	
%>
<script type="text/javascript"></script>
<script>
 var button = document.getElementById('button');
 window.onload = function () {
     let date = new Date();
     let h = date.getHours();
     if (h == 1) {
         button.disabled = false;
     } else {
         button.disabled = true;
     }
     setInterval(function () {
         console.log(h);
         if (h >= <%=a %> && h< <%=b %>) {
             button.disabled = false;
         } else {
             button.disabled = true;
         }
     }, 1000)
 }
</script>

<%
	}
	}
%>
</form>
<script src="./laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script>
//执行一个laydate实例
laydate.render({
  elem: '#date1' //指定元素
});
laydate.render({
  elem: '#date2' //指定元素
});
</script>

</body>
</html>