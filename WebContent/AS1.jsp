<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>订单查询</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<div class="demoTable" style="margin:10px 10px;">
 
</div>
<table id="demo" lay-filter="test"></table>
 
<script src="./layui-v2.4.5/layui/layui.js"></script>
<script src="/static/build/layui.js"></script>
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
<script type="text/html" id="barDemo">
 
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">查看详情</a>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">是否全选</button>
  </div>
</script>

<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  //第一个实例
  table.render({
    elem: '#demo'
    ,url: './ASS1Servlet' //数据接口
    ,toolbar: '#toolbarDemo'
    ,title:'订单查询'
    ,type: 'get'
    
    ,cols: [[ //表头
     {type: 'checkbox', fixed: 'left'}
      ,{field: 'wineshop_Name', title: '酒店名称', width:200, sort: true, fixed: 'left',align:'center'}
      ,{field:'indent_ID', title:'订单编号', width:120, fixed: 'left', unresize: true, sort: true,style:'background-color:#eee'}
      ,{field: 'indent_Time', title: '下单时间', width:200,align:'center'}
      ,{field: 'indent_XXX', title: '优惠券', width:200,align:'center'}
      ,{field: 'indent_Status', title: '订单状态', width:200,align:'center'}
      ,{field:'indent_Type', title:'支付类型', width:150,align:'center', templet: '#typeTpl'}
      ,{field: 'indent_PayID', title: '支付交易号', width:350}
      ,{field: 'wineshop_Address', title: '酒店地址', width:200,align:'center'}
      ,{field: 'wineshop_Telephone', title: '联系电话', width:200,align:'center'}
      ,{field: 'indent_remark', title: '订单备注', width:200,align:'center'}
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
  
//搜索查询
  var active = {
      reload: function(){
    	  var name = $('#demoReload').val();
          var date_s = $('#test1').val(); 
          var date_s1 = $('#test2').val();//传入搜索的日期值 
         
          //执行重载
          table.reload('demo', {
              url : './TimeIndentServlet1',
              method:'get',
              page: {
                  curr: 1 //重新从第 1 页开始
              }
              ,where: { //类似于 data
            	  Wineshop_Name:name,
                  Time1:date_s,
                  Time2:date_s1//传入日期参数
              }
          });
      }
  };
  $('#sousuo').on('click', function(){
      var type = $(this).data('type');
      //不能为空验证
      if( $('#test1'||'#test2').val()==""){
          layer.msg('查询日期不能为空');
          return false;
          console.log("aa");
      }
      active[type] ? active[type].call(this) : '';
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){//传入indent_ID
    var data = obj.data;
    var id = obj.data.indent_ID;
    var name = obj.data.wineshop_Name;
   // alert(id);
   // console.log(obj.data.wineshop_ID)
   if(obj.event === 'detail'){
	   window.location.href="${pageContext.request.contextPath}/DY.jsp?id="+id+"&name="+name;
    	
    	
    }
  });

  	
  
});
</script>
<script type="text/html" id="typeTpl">
  {{#  if(d.indent_Type === '微信支付'){ }}
  	 <a href="${pageContext.request.contextPath}/admin/indent/indentType.jsp?table-demo-name={{d.indent_Type}}" ><span style="color: green;">{{ d.indent_Type }}</span></a>
  {{#  } else if(d.indent_Type === '支付宝支付'){ }}
     <a href="${pageContext.request.contextPath}/admin/indent/indentType.jsp?table-demo-name={{d.indent_Type}}" ><span style="color: blue;">{{ d.indent_Type }}</span></a>
  {{#  }else{ }}
	 <a href="${pageContext.request.contextPath}/admin/indent/indentType.jsp?table-demo-name={{d.indent_Type}}" ><span style="color: red;">{{ d.indent_Type }}</span></a>
  {{#  } }}
</script>
</body>
</html>