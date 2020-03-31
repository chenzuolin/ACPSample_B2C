<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>条件查询</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<form class="layui-form" id="tp" action="" style="margin-top:15px;margin-left:15px;">
<div class="layui-form-item" style="display: inline;">
	<div class="layui-inline">
	      <div class="layui-input-inline">
	        <input type="text" name="wineshopName" id="wineshopName" placeholder="酒店名称"  class="layui-input">
	      </div>
	</div>
	<div class="layui-inline">
	   <div class="layui-input-inline">
	     <select name="indentType" id="indentType">
	       <option value="">请选择支付类型</option>
	       <option value="微信支付">微信支付</option>
	       <option value="支付宝支付">支付宝支付</option>
	       <option value="记帐支付">记帐支付</option>
	     </select>
	   </div>
	</div>
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
	<div class="layui-inline">
	  <div class="layui-input-inline" style="width: 100px;">
	    <input type="text" name="price_min" id="price_min" placeholder="￥ 小" autocomplete="off" class="layui-input">
	  </div>
	  <div class="layui-form-mid">-</div>
	  <div class="layui-input-inline" style="width: 100px;">
	    <input type="text" name="price_max" id="price_max" placeholder="￥ 大" autocomplete="off" class="layui-input">
	  </div>
	</div>
	<div class="layui-btn" data-type="reload"  lay-filter="rechar_btn" id="rechar_btn" >搜索</div>
</div>
</form>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
	<button class="layui-btn layui-btn-radius layui-btn-normal" lay-event="getCheckData"><i class="layui-icon">&#xe601;</i>导出</button>
    <button class="layui-btn layui-btn-radius layui-btn-warm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-radius layui-btn-danger" lay-event="isAll">是否全选</button>
  </div>
</script>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">查看</a>
</script>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
          
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>   
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
  var ins1 = table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/AllIndentServlet'
    ,toolbar: '#toolbarDemo'
    ,title: '订单信息表'
    ,id: 'indent'
    ,height:700
    ,even:true
    ,totalRow: true 
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:50}
      ,{field:'indent_ID', title:'ID', width:80, fixed: 'left', unresize: true, sort: true, totalRowText: '合计：'}
      ,{field:'indent_Time', title:'下单时间', width:150}
      ,{field:'indent_Status', title:'订单状态', width:200, sort: true}
      ,{field:'wineshop_Name', title:'酒店名称', width:100}
      ,{field:'wineshop_Address', title:'酒店地址', width:150}
      ,{field:'indent_Type', title:'支付类型', width:150, templet: '#typeTpl',align:'center'}
      ,{field:'indent_PayID', title:'支付编号', width:200}
      ,{field:'indent_remark', title:'订单备注', width:150,align:'center'}
      ,{field:'wineshop_Shift_Name', title:'负责人', width:150, sort: true,align:'center'}
      ,{field:'wineshop_Telephone', title:'联系电话',width:200,align:'center'}
      ,{field:'wineshop_Time', title:'最早收货时间',width:150,align:'center'}
      ,{field:'wineshop_TimeNight', title:'最晚收货时间',width:150,align:'center'}
      ,{field:'wineshop_TuiJian', title:'推荐人',width:150,align:'center'}
      ,{field:'cG_Name', title:'采购人员',width:200,align:'center'}
      ,{field:'cG_Time', title:'采购时间',width:200,align:'center'}
      ,{field:'fJ_Name', title:'分拣人员',width:200,align:'center'}
      ,{field:'fJ_Time', title:'分拣时间',width:200,align:'center'}
      ,{field:'courier_Name', title:'快递人员',width:200}
      ,{field:'ps_time', title:'接单时间',width:200,sort: true}
      ,{field:'total', title:'金额',fixed: 'right',align: 'center', sort: true,width:130, totalRow: true, templet: '#totalPriceTpl'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100,align:'center'}
    ]]
    ,page: {
    	limit: 20,
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100,500,1000,2500,5000,10000,25000,50000,100000],curr:1,groups:10,first:'首页',last:'尾页'
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
        if(data.length == 0){
        	layer.msg('请选择需要导出的数据！');
        	return false;
        }
        table.exportFile(ins1.config.id,data, 'xls');
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
    var wName = obj.data.wineshop_Name;
    if(obj.event === 'edit'){
    	layer.open({
  	      type: 2,
  	      title: wName,
  	      shadeClose: true,
  	      shade: 0.4,
  	      maxmin: true,
  	      area: ['90%', '90%'],
  	      content: "${pageContext.request.contextPath}/admin/indent/indentXiangQing.jsp?id="+id
  	  });
    }
  });
  var active = {
      reload: function(){
          var wineshopName = $('#wineshopName').val(); 
          var indentType = $('#indentType').val(); 
          var dateOne = $('#test1').val() ;
          var dateTwo = $('#test2').val() ;
          var price_min = $('#price_min').val();
          var price_max = $('#price_max').val();
          //执行重载
          table.reload('indent', {
              url : '${pageContext.request.contextPath}/MaxWhereSelect',
              method:'post',
              page: {
                  curr: 1 
              }
              ,where: { 
            	  wineshopName: wineshopName,
            	  indentType: indentType,
            	  startTime: dateOne,
            	  endTime: dateTwo,
                  minPrice: price_min,
                  maxPrice: price_max
              }
          });
      }
  };
  $('#rechar_btn').on('click', function(){
      var type = $(this).data('type');
      
      if($('#demoReload').val()=="" && $('#test1').val()=="" && $('#test2').val()=="" && $('#indentType').val()=="" && $('#wineshopName').val()==""){
          layer.msg('查询条件不能为空');
          return false;
      }
      
      active[type] ? active[type].call(this) : '';
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