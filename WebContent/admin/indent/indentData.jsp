<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String type = request.getParameter("name");
 %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>业绩</title>
  <meta name="renderer" content="webkit">
   <link rel="shortcut icon" href="${pageContext.request.contextPath}/index.ico" type="image/x-icon" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
	<button class="layui-btn layui-btn-radius layui-btn-normal" lay-event="getCheckData"><i class="layui-icon">&#xe601;</i>导出</button>
    <button class="layui-btn layui-btn-radius layui-btn-warm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-radius layui-btn-danger" lay-event="isAll">是否全选</button>
  </div>
</script>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var ins1 = table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/TotalCountData'
    ,toolbar: '#toolbarDemo'
    ,title: '业绩信息表'
    ,totalRow: true
    ,height:550
    ,where:{
    	name : '<%=type %>'
    }
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:50}
      ,{field:'wineshop_ID', title:'ID', width:80, fixed: 'left', unresize: true, sort: true, totalRowText: '合计：'}
      ,{field:'wineshop_UserName', title:'用户名', width:200}
      ,{field:'wineshop_Name', title:'酒店名称', width:200}
      ,{field:'wineshop_TuiJian', title:'推荐人', width:100}
      ,{field:'telephone', title:'联系电话', width:150}
      ,{field:'wineshop_Address', title:'酒店地址'}
      ,{field:'wineshop_Native', title:'酒店性质',width:150, templet: '#wineshop_NatureTpl'}
      ,{field:'wienshop_Shift_Name', title:'负责人',width:150}
      ,{field:'sum', title:'下单次数',fixed: 'right',width:100, sort: true, unresize: true, totalRow: true, templet: '#totalPriceTpl'}
    ]]
    ,page: {
    	limit:20,
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100,500,1000,2500,5000,100000],curr:1,groups:10,first:'首页',last:'尾页'
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
  
});
</script>
<script type="text/html" id="wineshop_NatureTpl">
  {{#  if(d.wineshop_Native === '普通酒店'){ }}
 	<span style="color: #5FB878;">{{ d.wineshop_Native }}</span>
  {{#  } else { }}
     <span style="color: #FF5722;">{{ d.wineshop_Native }}</span>
  {{#  } }}
</script>
<script type="text/html" id="totalPriceTpl">
  {{#  if(d.sum >= 0 && d.sum <=20){ }}
  	 <span style="color: #66FFFF;">{{ d.sum }}</span>
  {{#  } else if(d.sum > 20 && d.sum <=40){ }}
     <span style="color: #66FFCC;">{{ d.sum }}</span>
  {{#  } else if(d.sum > 40 && d.sum <=60){ }}
     <span style="color: #66FF99;">{{ d.sum }}</span>
  {{#  } else if(d.sum > 60 && d.sum <=80){ }}
     <span style="color: #66FF66;">{{ d.sum }}</span>
  {{#  } else if(d.sum > 80 && d.sum <=100){ }}
	 <span style="color: #66FF33;">{{ d.sum }}</span>
  {{#  }else { }}
	 <span style="color: #66FF00;">{{ d.sum }}</span>
  {{#  } }}
</script>
</body>
</html>