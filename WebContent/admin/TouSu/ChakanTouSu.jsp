<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>投诉反馈</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>

<table id="demo" lay-filter="test"></table>
 


<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/lay/modules/layer.js"></script>
 <script src="${pageContext.request.contextPath}/js/common.js"></script>    
<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/layui.all.js"></script>

<script type="text/html" id="barDemo">
 
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">反馈</a>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">是否全选</button>
  </div>
</script>

<script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 312
    ,url: '${pageContext.request.contextPath}/TouSuServlet' //数据接口
    ,page: false //开启分页
    ,cols: [[ //表头
      {field: 'touSu_ID', title: '投诉编号', width:200, sort: true, fixed: 'left', width:200,align:'center'}
      ,{field: 'wineshop_Name', title: '酒店名称', width:200, width:200,align:'center'}
      ,{field: 'touSu_Type', title: '投诉类型', width:200, sort: true, width:200,align:'center'}
      ,{field: 'touSu_Time', title: '投诉时间', width:200, width:200,align:'center'} 
      ,{field: 'touSu_Text', title: '投诉内容', width: 400, width:200,align:'center'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:200,align:'center'}
     
    ]]
  });
  table.on('tool(test)', function(obj){//传入TouSu_ID
	    var data = obj.data;
	    var id = obj.data.touSu_ID;
	    var name = obj.data.wineshop_Name;
	   // console.log(obj.data.wineshop_ID)
	   if(obj.event === 'detail'){
		   window.location.href="${pageContext.request.contextPath}/fk.jsp?id="+id+"&name="+name;
	    	
	    	
	    }
	  });
  
});
</script>

</body>
</html>