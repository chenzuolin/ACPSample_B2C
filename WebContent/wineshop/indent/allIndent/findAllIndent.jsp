<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>全部订单</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<form class="layui-form" id="tp" action="" style="margin-top:15px;margin-left:15px;">
<div class="layui-form-item" style="display: inline;">
	<div class="layui-inline">
	      <div class="layui-input-inline">
	        <input type="text" class="layui-input" id="test1" placeholder="起始时间">
	      </div>
	</div>
	<div class="layui-inline">
	      <div class="layui-input-inline">
	        <input type="text" class="layui-input" id="test2" placeholder="终止时间">
	      </div>
	</div>
	<div class="layui-btn" data-type="reload"  lay-filter="rechar_btn" id="rechar_btn" ><i class="layui-icon">&#xe615;</i></div>
</div>
</form>
<table class="layui-hide" id="test" lay-filter="test"></table>


<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs layui-bg-cyan" lay-event="detail">查看</a>
</script>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
          
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>   
<script src="${pageContext.request.contextPath}/js/common.js"></script>    
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>

 
<script>
layui.use(['table','layer','jquery','laydate'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var laydate = layui.laydate;
  laydate.render({
	    elem: '#test1'
	});
  laydate.render({
	    elem: '#test2'
	});
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/FindAllWineshop'
    ,toolbar: '#toolbarDemo'
    ,title: '订单信息表'
    ,id: 'indent'
    ,height: 550
    ,totalRow: true 
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',title:'序号',templet: '#xuhao',width:75,align:'center', totalRowText: '合计：'}
      ,{field:'indent_ID', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'indent_Time', title:'下单时间', width:200}
      ,{field:'indent_Status', title:'订单状态', width:200, sort: true}
      ,{field:'indent_Type', title:'支付类型', width:150,align:'center'}
      ,{field:'indent_PayID', title:'支付编号', width:200}
      ,{field:'indent_remark', title:'订单备注', width:150,align:'center'}
      ,{field:'total', title:'金额',fixed: 'right',align: 'center', sort: true, totalRow: true, templet: '#totalPriceTpl'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', align:'center'}
    ]]
    ,page: {
    	limit: 20,
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[20,40,60,80,100],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
  });
  
  
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    var id = obj.data.indent_ID;
    if(obj.event === 'detail'){
    	layer.open({
  	      type: 2,
  	      title: id,
  	      shadeClose: true,
  	      shade: 0.4,
  	      area: ['60%', '80%'],
  	      content: "${pageContext.request.contextPath}/wineshop/indent/allIndent/detail.jsp" ,
  	      success: function (layero, index) {
              var iframe = window['layui-layer-iframe' + index];
              iframe.child(id);
  	        }
  	  });
    } 
  });
  
  var active = {
      reload: function(){
          var dateOne = $('#test1').val() ;
          var dateTwo = $('#test2').val() ;
          //执行重载
          table.reload('indent', {
              url : '${pageContext.request.contextPath}/TimeWineshopIndent',
              method:'post',
              page: {
                  curr: 1 
              }
              ,where: { 
            	  startTime: dateOne,
            	  endTime: dateTwo
              }
          });
      }
  };
  $('#rechar_btn').on('click', function(){
      var type = $(this).data('type');
      
      if($('#test1').val()=="" && $('#test2').val()==""){
          layer.msg('查询条件不能为空哦！');
          return false;
      }
      if($('#test1').val()==""){
          layer.msg('初始时间不能为空哦！');
          return false;
      }
      if($('#test2').val()==""){
          layer.msg('终止时间不能为空哦！');
          return false;
      }      
      active[type] ? active[type].call(this) : '';
  });

});
</script>


<script type="text/html" id="totalPriceTpl">
  {{#  if(d.total > 0 && d.total <=200){ }}
  	 <span style="color: #00FFCC;">{{ d.total }}</span>
  {{#  } else if(d.total > 200 && d.total <=400){ }}
     <span style="color: #00FF99;">{{ d.total }}</span>
  {{#  } else if(d.total > 400 && d.total <=600){ }}
     <span style="color: #00FF66;">{{ d.total }}</span>
  {{#  } else if(d.total > 600 && d.total <=800){ }}
     <span style="color: #00FF33;">{{ d.total }}</span>
  {{#  }else{ }}
	 <span style="color: #00FF00;">{{ d.total }}</span>
  {{#  } }}
</script>
</body>
</html>