<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.sec.dao.QuYuDao" %>
<%@ page import="com.sec.entity.QuYu" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <title>销售额统计</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>

<form action="QuYuServlet" class="layui-form layui-form-pane" method="get">
<div class="layui-inline">
                        <label class="layui-form-label">选择区域</label>
                        <div class="layui-input-block"  >
                           <select name="QY_Name" id="QY_Name"  required>
                           	  <option value="">请选择区域</option>
                           	  <%
                           	 QuYuDao dao = new QuYuDao();
                           	  List<QuYu> list = dao.findAll();
                           	  for(QuYu q : list){
                           		  String aa = q.getQY_Name();
                           	  %>
            						<option value="<%=aa %>"></option>
          					   <%
                           	  }
          					   %>
                           </select>
                        </div>
                    </div>
 

 <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
  <input type="text" class="layui-input" placeholder="请输入开始日期" id="test1">
       </div>
到

 <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
  <input type="text" class="layui-input" placeholder="请输入结束日期" id="test2">
</div>


</form>
</body>
<script type="text/javascript">
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#test1' //指定元素
  });
});
</script>
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#test2' //指定元素
  });
});
</script>
</html>