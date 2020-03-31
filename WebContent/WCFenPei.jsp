<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>分配酒店收货员</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<div class="demoTable" style="margin:10px 10px;">
 酒店名称：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" placeholder="请输入酒店名称" autocomplete="off">
  </div>
  
  
  <input class="layui-btn" data-type="reload" value="搜索" type="button" id="sousuo">
</div>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">是否全选</button>
  </div>
</script>
<script type="text/html" id="barDemo">
 
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">分配</a>
<a class="layui-btn layui-btn-xs" lay-event="edit">查看</a>
</script>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">分配</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
          
<script src="layui-v2.4.5/layui/lay/modules/layer.js"></script>   
 <script src="js/common.js"></script>    
<script src="layui-v2.4.5/layui/layui.all.js"></script>

 
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/ShouHuoServlet'
    ,toolbar: '#toolbarDemo'
    ,title: '分配酒店收货员'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'wineshop_Name', title:'酒店名称', width:300, fixed: 'left', unresize: true, sort: true,align:'center'}
      ,{field:'wineshop_ID', title:'酒店编号', width:100, fixed: 'left', unresize: true, sort: true,align:'center'}
      ,{field:'wineshop_Telephone', title:'联系电话', width:300,align:'center'}
      ,{field:'wineshop_Address', title:'酒店地址', width:300,align:'center'}
      ,{field:'wineshop_UserName', title:'酒店登录名', width:300,align:'center'}
     
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:300,align:'center'}
    ]]
    ,page: {
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
  });
  //搜索查询
  var active = {
		  reload:function(){
			  var name = $('#demoReload').val();//传入酒店名称
			  alert(name);
			  //执行重载
			  table.reload('test',{
				  url:'./WCFenPei3Servlet',
				  method:'get',
				  page:{
					  curr:1//重第一页开始
				  }
			  ,where:{
				  Wineshop_Name:name
			  },
			  });
		  }
  };
  $('#sousuo').on('click', function(){
      var type = $(this).data('type');
      //不能为空验证
      
      active[type] ? active[type].call(this) : '';
  });
  
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        console.log(data);
        layer.alert(JSON.stringify(data));
      break;
      case 'getCheckLength':
        var data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选');
      break;
    };
  });
  
  //监听行工具事件
  //监听行工具事件
  table.on('tool(test)', function(obj){//传入indent_ID
    var data = obj.data;
    var id = obj.data.wineshop_ID;
    
   // console.log(obj.data.wineshop_ID)
   if(obj.event === 'detail'){
    	 window.location.href="${pageContext.request.contextPath}/WCFenPei1.jsp?";
    	
    	
    }else if(obj.event === 'edit'){
    	window.location.href="${pageContext.request.contextPath}/WCFenPei2.jsp?id="+id;
    }
    
  });
});
</script>

</body>
</html>