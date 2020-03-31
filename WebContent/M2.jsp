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
</style>
</head>
<body>
<form action="M2Servlet" class="layui-form layui-form-pane" method="get">
 <fieldset>
   <legend>销售额查询</legend>
<div class="layui-inline">
	<label class=" layui-btn" style="background:rgb(126,126,126); margin-left:295px;width:121px;"><strong>按时间查询</strong></label>
			<div class="layui-input-inline" style="width: 150px;">
				  <input required    name="Time1" style="width: 200px;text-align: center;margin-left:-4px;" lay-verify="required" placeholder="请选择开始日期" autocomplete="off" class="layui-input" type="text" id="date1">
 
			</div>
			
			<div class="layui-input-inline" style="width: 150px;">
				  <input required  name="Time2" style="width: 200px;text-align: center; margin-left:50px; " lay-verify="required" placeholder="请选择结束日期" autocomplete="off" class="layui-input" type="text" id="date2">
 
			</div>
		</div>
		<div class="layui-form-item">
    <label class="layui-form-label">承包商</label>
    <div class="layui-input-block">
      <select id="t" name="QY">
        <option value="">请选择</option>
        <%
        	QYDao dao = new QYDao();
        	List<QY> list = dao.findAll();
        	for(QY q : list){
        		String aa = q.getQY_ShiftName();
        		%>
        		
        		<option value="<%=aa %>"><%=aa %></option>
        		<%
        	}
        %>
      </select>
    </div>
  </div>
		<div class="layui-inline">
			<div class="layui-input-inline">
				<button class="layui-btn" type="submit" style="width:121px;margin-left:150px;" ><i class="layui-icon">&#xe615;</i>查询</button>
			</div>
		</div>
 </fieldset>
</form>
<div>
<%	if(request.getParameter("total") == null){
	
}else{
	int as = Integer.parseInt(request.getParameter("total"));

	%>
	<span><%=as %></span>
</div>
<%
}
%>
</body>
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
</html>