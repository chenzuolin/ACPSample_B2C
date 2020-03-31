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
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<style>
	fieldset{
		padding:15px 0;
	}
	legend{
		font-size:20px;
	}
	th{text-align:center !important;background:#009688;color:white;}
	td{text-align:center !important;width:20%}
</style>
</head>
<body>

 <fieldset>
   <legend>按时间查询采购量</legend>
<div class="layui-inline">
	<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:295px;width:121px;"><strong>按时间查询</strong></label>
			<div class="layui-input-inline" style="width: 150px;">
				  <input required    name="Greens_characteristics" style="width: 200px;text-align: center;margin-left:-4px;" lay-verify="required" placeholder="请选择开始日期" autocomplete="off" class="layui-input" type="text" id="date1">
 
			</div>
			
			<div class="layui-input-inline" style="width: 150px;">
				  <input required  name="Greens_characteristics1" style="width: 200px;text-align: center; margin-left:50px; " lay-verify="required" placeholder="请选择结束日期" autocomplete="off" class="layui-input" type="text" id="date2">
 
			</div>
		</div> 
		<div class="layui-inline">
			<div class="layui-input-inline">
				<button id="reg_btn" class="layui-btn" type="button"  onclick="loginAdmin();" style="width:121px;margin-left:150px;" ><i class="layui-icon">&#xe615;</i>查询</button>
			</div>
		</div>
 </fieldset>
 <%
	 int aa = (Integer)request.getSession().getAttribute("GHS");
 %>
 <div id="did"><%=aa %></div>
 <div id="content"></div>


</body>
 <script src="./laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script>
//执行一个laydate实例
laydate.render({
  elem: '#date1' //指定元素
		  ,type: 'datetime'
});
laydate.render({
  elem: '#date2' //指定元素
		  ,type: 'datetime'
});
</script>
  


<script src="layui/layui.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/jquery.js"></script> 
<script src="js/jquery.min.js"></script>
<script>
 

document.getElementById("reg_btn").addEventListener("tap",function(){
	loginAdmin();
});
	

	 
	  //var bb = document.getElementsByName('#date2').value;
function loginAdmin(){
	 var aa = document.getElementsByName("Greens_characteristics")[0].value
	   var bb = document.getElementsByName("Greens_characteristics1")[0].value
	   var cc = document.getElementById("did").innerHTML;
	$.ajax("http://www.sumengkx.com/ACPSample_B2C/POP6Servlet",{
		dataType: "json",
		//processData:false,
		data:{
			"time1":aa,
			"time2":bb,
			"name":cc
		},   
		type:"get",
		success:function(obj){
			$("#content").html();
			var html="";
			html +='<table class="layui-table">';
			html +='<tr>';
			html +='<th>蔬菜名称</th>';
			html +='<th>蔬菜数量</th>';
			html +='</tr>';
			html +='</table>';
			for(var i=0;i<obj.length;i++){
				
			

				
				
				
				html +='<table class="layui-table">';
				html +='<tr>';
				 html += '<td>' +  obj[i].greens_Name+ '</td>';
                 html += '<td>' + "" +  obj[i].greens_Number+ '' + "" +  obj[i].greens_Unit+ '</td>';

				html +='</tr>';

				html +='</table>';
			}
			$("#content").append(html);
		},
		error:function(obj){
			window.location.href="404.jsp";

		}
	
		
	
	})
}



</script>
</html>