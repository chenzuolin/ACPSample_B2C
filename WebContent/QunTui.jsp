<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>指定酒店推送</title>
  <link rel="stylesheet" href="layui/layui.css" media="all">
   <link href="layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
 
<table id="demo" lay-filter="test"></table>
 
<script src="./layui-v2.4.5/layui/layui.js"></script>
<script type="text/javascript" id="TK"> 

	
</script>
<script type="text/html" id="barDemo">
  <a href="${pageContext.request.contextPath}/QunTui1.jsp?Wineshop_CID={{d.wineshop_CID}}" class="layui-btn layui-btn-xs" lay-event="edit">推送</a>
 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">查看</a>
</script>
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  //第一个实例
  table.render({
    elem: '#demo'
    ,url: './ChaKanQunTuiServlet' //数据接口
    ,title:'指定酒店推送'
    ,type: 'get'
    ,cols: [[ //表头
      {field: 'qunTui_ID', title: '推送编号', width:400, sort: true, fixed: 'left',align:'center'}
      ,{field: 'wineshop_CID', title: '酒店CID', width:400,align:'center', fixed: 'left'}
      ,{field: 'wineshop_UserName', title: '酒店登录名', width:400,align:'center'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:200,align:'center'}
    ]]
    ,page: {
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
  });
  
  	
  
});
</script>

</body>
</html>