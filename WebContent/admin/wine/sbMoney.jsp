<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>预存金管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
	<button class="layui-btn layui-btn-radius layui-btn-normal" lay-event="getCheckData"><i class="layui-icon">&#xe601;</i>导出</button>
    <button class="layui-btn layui-btn-radius layui-btn-warm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-radius layui-btn-danger" lay-event="isAll">是否全选</button>
  </div>
</script>
<script type="text/html" id="switchTpl">
  <input type="checkbox" name="num_OFF" data-id="{{d.Wineshop_ID}}" lay-skin="switch" lay-text="已开启|已关闭" lay-filter="sexDemo" {{ d.Num_OFF == 0 ? 'checked' : '' }}>
</script>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
          
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>   
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script>
layui.use(['table','layer','jquery','laydate','form'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var laydate = layui.laydate;
  var form = layui.form;
  var ins1 = table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/getSbMoney'
    ,toolbar: '#toolbarDemo'
    ,title: '预存金信息'
    ,id: 'sb'
    ,height:800
    ,even:true
    ,totalRow: true 
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:50}
      ,{field:'Wineshop_Name', title:'酒店名称', width:180, fixed: 'left', unresize: true, sort: true, totalRowText: '合计：'}
      ,{field:'Wineshop_TuiJian', title:'推荐人'}
      ,{field:'Wineshop_ID', title:'ID'}
      ,{field:'LJ_Num', title:'累计充值',  sort: true}
      ,{field:'SB_Num', title:'剩余金额',  sort: true, totalRow: true}
      ,{field:'Num_one', title:'日扣除金额',  sort: true}
      ,{field:'Num_Three', title:'金额限制',  sort: true}
      ,{field:'Num_BS', title:'状态',  templet: function(d){
    	  return d.num_BS==0?'未扣除	':'已扣除';
    	}
      }
      ,{field:'Num_OFF', title:'控制',fixed: 'right',align: 'center',width:130,templet: '#switchTpl'}
      ,{field:'Wineshop_Telephone', title:'联系电话',fixed: 'right',align: 'center',width:130}
    ]]
    ,page: {
    	limit: 20,
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100,500,1000,2500,5000,10000,25000,50000,100000],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
    ,done:function(){
    	$("[data-field='Wineshop_ID']").css("display","none");
    }
  });
  
  form.on('switch(sexDemo)', function(obj){
		var wid = $(this).attr('data-id');
		var soff = this.checked ? '0' : '1' ;
		console.log("============wid>"+wid);
		console.log("===soff>"+soff);
	  	$.ajax({
	  		type:'POST',
	  		url: '${pageContext.request.contextPath}/updateOff',
	  		data:{id: wid,soff: soff},
	  		dataType:'json',
	  		success:function(data){
	  			var code = parseInt(data);
	  			if(code == 200){
	  				layer.msg('修改成功了哦！',{icon:6, time:2000});
	  			}
	  		},
	  		error:function(data){
	  			layur.msg('修改失败了哦！',{icon:5,time:3000});
	  		}
	  	});
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
</body>
</html>