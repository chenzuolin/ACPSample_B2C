<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>登录日志</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
 
<table class="layui-hide" id="test" lay-filter="test"></table>
 
 <script src="js/common.js"></script>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
           
          
<script src="layui-v2.4.5/layui/layui.all.js"></script>
<script src="layui-v2.4.5/layui/lay/modules/layer.js"></script>
 
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/LogServlet'
    ,toolbar: '#toolbarDemo'
    ,title: '登录信息表'

    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'rownum', fixed: 'left',templet: '#xuhao', title:'序号',width:80}
      ,{field:'log_Id', title:'ID', width:200, fixed: 'left', unresize: true, sort: true}
      ,{field:'log_Time', title:'登录时间', width:200,sort: true}
      ,{field:'log_Name', title:'登录名称'}
      ,{field:'log_Ip', title:'设备型号', width:200}
      ,{field:'log_Ip_Name', title:'设备名称', width:200}
      ,{field:'log_Type', title:'操作类型'}
      ,{field:'log_Content', title:'操作内容'}
    ]]
  	 
    ,page: {
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,30,40,50],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
  });
});
</script>

</body>
</html>