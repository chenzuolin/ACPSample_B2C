<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<style>
	fieldset{
		padding:0 90px 14px 90px;
	}
	legend{
		font-size:20px;
	}
</style>
    <script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
            var goEasy = new GoEasy({appkey: 'BC-8a96434d730f45de9a73cdfe101b398f'});
                               goEasy.subscribe({
                        channel: 'GoEasy',
                        onMessage: function(message){
                            alert('接收到消息:'+message.content);
                        }
              });
 </script>
 </head>

 <body>
<form class="layui-form layui-form-pane"  action="IndentServlet1" method="post" >
<div class="layui-card">
       <div style="margin:15px auto;">
       	 <fieldset>
       	 	<legend>订单查询</legend>
			<div class="layui-inline" style="margin-top: 5px; padding-left: 10px;">
				<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:-65px;"><strong>按物流状态查询</strong></label>
				    <div class="layui-input-inline">
				        <select  name="Indent_Status" id="Indent_Status">
					        <option value="正在处理"  selected>正在处理</option>
					        <option value="正在分拣" >正在分拣</option>
					        <option value="分拣完毕等待快递员接收" >分拣完毕等待快递员接收</option>
					        <option value="配送中" >配送中</option>
					        <option value="已完成" >已完成</option>
				 	    </select>
			       </div>
	       </div>
			<div class="layui-inline" style="margin-top: 5px; padding-left: 10px;">
				<label class="layui-btn" style="background:rgb(126,126,126); margin-left:20px;"><strong>按下单日期查询</strong></label>
				<div class="layui-input-inline" style="width: 150px;">
					  <input required    name="Greens_characteristics" style="width: 150px;text-align: center;" lay-verify="required" placeholder="请选择开始日期" autocomplete="off" class="layui-input" type="text" id="date1">
				</div>
				<div class="layui-input-inline" style="width: 150px;">
					  <input required  name="Greens_characteristics1" style="width: 150px;text-align: center; " lay-verify="required" placeholder="请选择结束日期" autocomplete="off" class="layui-input" type="text" id="date2">
				</div>
			</div>
			<div class="layui-inline" style="margin-top: 5px; ">
				<div class="layui-input-inline">
					<button class="layui-btn" type="submit" style="margin-left:60px;"><i class="layui-icon">&#xe615;</i>查询</button>
				</div>
			</div>
		 </fieldset>
	 </div>
</div>
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
  
  <script src="./layui/layui.js" charset="UTF-8"></script>
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
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
</script>
</body>
</html>