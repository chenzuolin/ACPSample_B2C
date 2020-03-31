<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>退款查询</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="../../layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="../..layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<div class="demoTable" style="margin:10px 10px;">
 
 
  
</div>
<table id="demo" lay-filter="test"></table>
 
<script src="../../layui-v2.4.5/layui/layui.js"></script>
<script src="../../static/build/layui.js"></script>

<script type="text/html" id="barDemo">
 
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">退款</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="dd">票据</a>
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
    ,url: '${pageContext.request.contextPath}/RefundKJServlet' //数据接口
    ,toolbar: '#toolbarDemo'
    ,title:'订单查询'
    ,type: 'get'
    
    ,cols: [[ //表头
     {type: 'checkbox', fixed: 'left'}
      ,{field: 'wineshop_Name', title: '酒店名称', width:200, sort: true, fixed: 'left',align:'center'}
      ,{field:'indent_ID', title:'订单编号', width:120, unresize: true, sort: true,style:'background-color:#eee'}
      ,{field: 'indent_Time', title: '下单时间', width:200,align:'center'}
      ,{field: 'indent_Why', title: '退款原因', width:200,align:'center'}
      ,{field:'indent_Type', title:'支付类型', width:150,align:'center', templet: '#typeTpl'}
      ,{field: 'indent_PayID', title: '支付交易号', width:350}
      ,{field: 'wineshop_Address', title: '酒店地址', width:200,align:'center'}
      ,{field: 'wineshop_Telephone', title: '联系电话', width:200,align:'center'}   
      ,{field: 'indent_TKprice', title: '退款金额', width:120,align:'center',style:'background-color:#009688;color:#fff'}
      ,{field:'total', title:'金额', width:120,style:'background-color:#009688;color:#fff',align:'center'}
      ,{field: 'wineshop_TuiJian', title: '推荐人', width:200,align:'center'}
      ,{field: 'refund_Status', title: '退款状态', width:200,align:'center'}
      ,{field: 'refund_Time', title: '退款时间', width:200,align:'center'}
      
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
  

 
  //监听行工具事件
  table.on('tool(test)', function(obj){//传入indent_ID
    var data = obj.data;
    var id = obj.data.indent_ID;
    var name = obj.data.wineshop_Name;
    var payID = obj.data.indent_PayID;
    var total = obj.data.total;
    var Refund = obj.data.indent_TKprice;
    var type = obj.data.indent_Type;
   // alert(id);
   // console.log(obj.data.wineshop_ID)
   switch (obj.event){
   case 'detail':
   window.location.href="${pageContext.request.contextPath}/CheckIndent?id="+id;  
   break;
   
   case 'edit':
	   if(type=="微信支付"){
		   layer.confirm('确定退款吗', function(index){
			   window.location.href="${pageContext.request.contextPath}/RefundServlet?Refund="+Refund+"&payID="+payID+"&total="+total;    
		        layer.close(index);
		      });
	   }else{
		   layer.confirm('确定退款吗', function(index){
			   window.location.href="${pageContext.request.contextPath}/AlipayRefundServlet?Refund="+Refund+"&payID="+payID+"&total="+total;    
		        layer.close(index);
		      }); 
	   }
	  
	break;
	
   case 'dd':
	   window.location.href="${pageContext.request.contextPath}/PJ?id="+id;
	   break;
   }
   
  //if(obj.event === 'detail'){
	//   window.location.href="${pageContext.request.contextPath}/CheckIndent?id="+id;
    	
    	
  //  }
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