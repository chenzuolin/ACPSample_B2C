<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="css/layui.css" rel="stylesheet" media="all">

<title>蔬菜上传</title>
<style>
	.nva{
		margin-top:13px;
	}
	.layui-input{
		margin-left:-4px;
		width:203px;
		word-break:keep-all;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	.layui-inline{
		margin-bottom:20px;
	}
	.layui-input:hover{
		background:skyblue;
	}
	fieldset{
		margin-top:50px;
	}
	legend{
		font-size:20px;
	}
	.aa:hover{
		color:skyblue !important;
	}
</style>
</head>
<body>
<div style="background: #009688;  text-align: center; font-size: 20px; font: system; color:white; margin-bottom: 5px; height: 32px; line-height: 32px; ">
	<h>商品上传</h>
</div>
<form action="GreensServlet" method="post" enctype="multipart/form-data">
 <fieldset>
   <legend>请输入蔬菜属性</legend>
    <div class="nva">
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜名称</label>
		<div class="layui-input-inline">
			<input type="text" lay-verify="required" required name="Greens_Name" id="firstname" class="layui-input" placeholder="请输入商品名称">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜单位</label>
		<div class="layui-input-inline">
			<select  name="Greens_Unit" class="layui-input">
					<option value="">请选择</option>
					<%
						Greens_UnitDao dao = new Greens_UnitDao();
						List<Greens_Unit> list = dao.findAll();
						for(Greens_Unit greens_Unit : list){
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
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜单价</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Price" id="firstname" class="layui-input" placeholder="请输入商品单价">
			</div>
	</div>

	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">市场单价</label>
		<div class="layui-input-inline">
			<input type="text" lay-verify="required" required name="Greens_Market_Price" id="firstname" class="layui-input" placeholder="请输入商品市场单价">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜品质</label>
		<div class="layui-input-inline">
			<select name="Greens_Character" class="layui-input">
				<option selected>请选择</option>
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
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜类型</label>
		<div class="layui-input-inline">
			<select name="Greens_Type_Name" class="layui-input">
			<option selected>请选择</option>
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
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">保质期</label>
		<div class="layui-input-inline">
			<select name="Greens_Period1" class="layui-input">
				<option selected>请选择</option>
				<option>日</option>
			    <option>周</option>
			    <option>月</option>
			    <option>年</option>
		    </select>
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">保质期具体天数</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Period2" id="firstname" class="layui-input" placeholder="请输入保质期具体天数">
			</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜品相</label>
			<div class="layui-input-inline">
				<select name="Greens_Condition" class="layui-input">
					<option selected>请选择</option>
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
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">最少采购量</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Minnumber" id="firstname" class="layui-input" placeholder="请输入蔬菜最少采购量">
			</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜重量</label>
			<div class="layui-input-inline">
								<input type="text" lay-verify="required" required name="Greens_Norms" id="firstname" class="layui-input" placeholder="请输入蔬菜重量(斤)">
				
			</div>
	</div>

	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">库存量</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Number" id="firstname" class="layui-input" placeholder="请输入蔬菜库存量">
			</div>
	</div>
	<br/>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜产地</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Class" id="firstname" class="layui-input" placeholder="请输入蔬菜产地">
			</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜推荐</label>
			<div class="layui-input-inline">
				<select name="Greens_Recommend" class="layui-input">
					<option selected>请选择</option>
					<option value="是">是</option>
					<option value="否">否</option>
				</select>
			</div>
	</div>
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜备注</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required" required name="Greens_Remark" id="firstname" class="layui-input" placeholder="请输入蔬菜备注">
			</div>
	</div>
	
	<script type="text/javascript"  src="js/jquery.js" ></script>

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
	<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜季节</label>
			<div class="layui-input-inline">
				<select name="Greens_characteristics" class="layui-input" id="select">
					<option selected>请选择</option>
					<option value="是">是</option>
					<option value="否" >否</option>
				</select>
			</div>
	</div>
		<div class="layui-inline">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">蔬菜图片</label>
			<div class="layui-input-inline">
				<input type="file" lay-verify="required"  name="Greens_tupian" class="layui-input">
			</div>
			<br>
			<span class="aa" style="margin-left:215px;color:#ccc;">图片名称与蔬菜名称必须一致</span>
	</div>
	<div class="layui-inline" id="start" style="display:none">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">开始时间</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required"  name="Greens_characteristics" id="date1" class="layui-input"  placeholder="请输入开始时间">
			</div>
	</div>
	<br/>
	<div class="layui-inline" id="stop" style="display:none">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">结束时间</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required"  name="Greens_characteristics" id="date2" class="layui-input"  placeholder="请输入结束时间">
			</div>
	</div>
   </div>
</fieldset>

	<br/>
	<div class="layui-inline">
		<div class="layui-input-inline">
			<button class="layui-btn" type="submit" style="width:121px;margin-left:543px;">提交</button>
		</div>
	</div>
	<div class="layui-inline">
		<div class="layui-input-inline">
			<button class="layui-btn" type="reset" style="width:121px;margin-left:10px;">重置</button>
		</div>
	</div>
</form>
 <script src="layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">


//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('form', function(){
  var form = layui.form;
  
  //…
});
</script>

<script>
//执行一个laydate实例

layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#date1'
    //指定元素
  });
});
</script>
<script>
//执行一个laydate实例

layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#date2'
    //指定元素
  });
});
</script>
</body>
</html>