<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>全部订单</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="../layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="../layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<form class="layui-form" id="tp" action="${pageContext.request.contextPath}/FindAllByIdIndent" method="post">
<div class="demoTable" style="margin:10px 10px;">
  订单编号：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" placeholder="请输入订单编号" autocomplete="off">
  </div>
  <input class="layui-btn" data-type="reload" value="搜索" type="submit">
</div>
</form>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">是否全选</button>
  </div>
</script>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">查看</a>
</script>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
          
<script src="../layui-v2.5.2/layui/lay/modules/layer.js"></script>   
<script src="../layui-v2.5.2/layui/layui.all.js"></script>

 
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/FindAllIndent'
    ,toolbar: '#toolbarDemo'
    ,title: '订单信息表'
    ,totalRow: true 
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:50}
      ,{field:'indent_ID', title:'ID', width:80, fixed: 'left', unresize: true, sort: true, totalRowText: '合计：'}
      ,{field:'indent_Time', title:'下单时间', width:150}
      ,{field:'indent_Status', title:'订单状态', width:200, sort: true}
      ,{field:'wineshop_Name', title:'酒店名称', width:100}
      ,{field:'wineshop_address', title:'酒店地址', width:150}
      ,{field:'indent_Type', title:'支付类型', width:150, templet: '#typeTpl',align:'center'}
      ,{field:'indent_PayID', title:'支付编号', width:200}
      ,{field:'indent_remark', title:'订单备注', width:150,align:'center'}
      ,{field:'wineshop_shift_name', title:'负责人', width:150, sort: true,align:'center'}
      ,{field:'wienshop_telephone', title:'联系电话',width:200,align:'center'}
      ,{field:'wienshop_Time', title:'最早收货时间',width:150,align:'center'}
      ,{field:'wienshop_nightTime', title:'最晚收货时间',width:150,align:'center'}
      ,{field:'wienshop_tuijian', title:'推荐人',width:150,align:'center'}
      ,{field:'cg_Name', title:'采购人员',width:200,align:'center'}
      ,{field:'cg_time', title:'采购时间',width:200,align:'center'}
      ,{field:'fj_Name', title:'分拣人员',width:200,align:'center'}
      ,{field:'fj_Time', title:'分拣时间',width:200,align:'center'}
      ,{field:'courier_Name', title:'快递人员',width:200}
      ,{field:'ps_time', title:'接单时间',width:200,sort: true,align:'center'}
      ,{field:'totalPrice', title:'金额',fixed: 'right',align:'center',sort: true,width:130, totalRow: true, templet: '#totalPriceTpl'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150,align:'center'}
    ]]
    ,page: {
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100,500,1000,2000,5000,10000,20000,50000,100000],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
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
  table.on('tool(test)', function(obj){
    var data = obj.data;
    var id = obj.data.indent_ID;
    console.log(obj.data.wineshop_ID)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
        $.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/DelByIdIndent",
			data:{"id":id},
			success:function(data){
				layer.msg('删除成功了哦！');
			}
			
		});
      });
    } else if(obj.event === 'edit'){
    	 window.location.href="${pageContext.request.contextPath}/CheckIndent?id="+id;
    	//openDetial(wName,['75%','70%'],['关闭当前页','取消'],'${pageContext.request.contextPath}/Detail?id='+id,function(index, layero){
    	//	layer.closeAll('iframe');
    	//},function(index, layero){
    	//	layer.closeAll('iframe');
    	//});
    	
    	
    }
  });
});
</script>

<script type="text/html" id="typeTpl">
  {{#  if(d.indent_Type === '微信支付'){ }}
  	 <a href="${pageContext.request.contextPath}/admin/indent/indentType.jsp?table-demo-name={{d.indent_Type}}" ><span style="color: #5FB878;">{{ d.indent_Type }}</span></a>
  {{#  } else if(d.indent_Type === '支付宝支付'){ }}
     <a href="${pageContext.request.contextPath}/admin/indent/indentType.jsp?table-demo-name={{d.indent_Type}}" ><span style="color: #01AAED;">{{ d.indent_Type }}</span></a>
  {{#  }else{ }}
	 <a href="${pageContext.request.contextPath}/admin/indent/indentType.jsp?table-demo-name={{d.indent_Type}}" ><span style="color: #FF5722;">{{ d.indent_Type }}</span></a>
  {{#  } }}
</script>

<script type="text/html" id="totalPriceTpl">
  {{#  if(d.totalPrice > 0 && d.totalPrice <=200){ }}
  	 <span style="color: #00FFCC;">{{ d.totalPrice }}</span>
  {{#  } else if(d.totalPrice > 200 && d.totalPrice <=400){ }}
     <span style="color: #00FF99;">{{ d.totalPrice }}</span>
  {{#  } else if(d.totalPrice > 400 && d.totalPrice <=600){ }}
     <span style="color: #00FF66;">{{ d.totalPrice }}</span>
  {{#  } else if(d.totalPrice > 600 && d.totalPrice <=800){ }}
     <span style="color: #00FF33;">{{ d.totalPrice }}</span>
  {{#  }else{ }}
	 <span style="color: #00FF00;">{{ d.totalPrice }}</span>
  {{#  } }}
</script>
</body>
</html>