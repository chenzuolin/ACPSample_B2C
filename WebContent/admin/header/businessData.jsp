<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>业务信息</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <link rel="shortcut icon" href="${pageContext.request.contextPath}/index.ico" type="image/x-icon" />
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
          
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>   
 <script src="${pageContext.request.contextPath}/js/common.js"></script>    
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>

 
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/BusinessData'
    ,toolbar: '#toolbarDemo'
    ,title: '业务信息'
    ,totalRow: true 
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:100, totalRowText: '合计：'}
      ,{field:'bname', title:'推荐人', width:200}
      ,{field:'num', title:'业务数据', sort: true, totalRow: true}
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