<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.sec.dao.CourierDao" %>
<%@ page import="com.sec.dao.WineshopDao" %>
<%@ page import="com.sec.entity.Courier" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sec.entity.Wineshop" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="layui-v2.3.0/layui/css/layui.css"/>
<style>
	.layui-inline{
		margin-top:30px;
	}
	legend{
		font-size:20px;
	}
	fieldset{
		margin-top:50px;
	}
</style>
</head>
<body>
	<form name="form1" method="post" action="FenpeiServlet" class="layui-form">
	<%
		int id=Integer.parseInt(request.getParameter("id"));
		
		CourierDao Dao=new CourierDao();
		WineshopDao Dao1=new WineshopDao();
		List<Courier> list=Dao.findUserByID2(id);
		
		List<Wineshop> list1=Dao1.findAll1();
		System.out.print(list1);
		if(list == null || list.size()<1){
			
			out.print("<script language='javascript'>alert('数据错误！');</script>");
		}else{
			for(Courier courier:list){
				String name=courier.getCourier_Name();
    			String telephone=courier.getCourier_Telephone();
    			String date=courier.getCourier_Time();
    			String type=courier.getCourier_Vehicle();
		
	%>
<fieldset>
   <legend>快递员分配</legend>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:131px;">分配编号</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" readonly="readonly" style="text-align:center;" required name="id" id="firstname" class="layui-input" value="<%=id %>">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">快递员名称</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" readonly="readonly" style="text-align:center;" required name="Courier_Name" id="firstname" class="layui-input" value="<%=name %>">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">联系电话</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" readonly="readonly" style="text-align:center;" required name="telephone" id="firstname" class="layui-input" value="<%=telephone %>">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:131px;">注册时间</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" readonly="readonly" style="text-align:center;" required name="date" id="firstname" class="layui-input" value="<%=date %>">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">运输类型</label>
		<div class="layui-input-inline" style="margin-left:-4px;">
			<input type="text" lay-verify="required" readonly="readonly" style="text-align:center;" required name="type" id="firstname" class="layui-input" value="<%=type %>">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">分配酒店</label>
		<div class="layui-input-inline" style="margin-left:-4px;width:183px;">
			<select name="Wineshop_Name"">
				<option value="请选择" selected="selected">--请选择--</option>
					<%	
		      			for(int i=0;i<list1.size();i++){
   						Wineshop wineshop=list1.get(i);
   		    			String wineshop_name=wineshop.getWineshop_Name();
		      		%>
				<option value="<%=wineshop_name %>"><%=wineshop_name %></option>
				<%
				     }
				 %>
		</select>
		</div>
	</div>		
 <div class="layui-form-item">
      <div class="layui-input-block" style="margin-left:540px;margin-top:30px;">
        <button class="layui-btn" type="submit" style="width:121px;">确认提交</button>
        <button class="layui-btn" type="reset" style="width:121px;">重新填写</button> 
      </div>    
 </div>
 </fieldset>	   
		

			<%
						}
				}
			%>
		</table>
	</form>
	<script src="layui-v2.3.0/layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
   return false;
  });
});
</script>
</body>
</html>