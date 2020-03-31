<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>酒店信息</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<form class="layui-form" id="tp" action="${pageContext.request.contextPath}/SelectWineshopLikeName" method="post">
<div class="demoTable" style="margin:10px 10px;">
  酒店名称：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" placeholder="请输入酒店名称" autocomplete="off">
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
<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">赠券</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
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
    ,url:'${pageContext.request.contextPath}/WineshopMessage'
    ,toolbar: '#toolbarDemo'
    ,id: 'wineshop'
    ,title: '酒店信息表'
    ,height:700
    ,even:true
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:50}
      ,{field:'wineshop_ID', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'wineshop_UserName', title:'用户名', width:120}
      ,{field:'wineshop_Name', title:'酒店名称', width:200, sort: true}
      ,{field:'wineshop_Date', title:'注册时间', width:200, sort: true}
      ,{field:'wineshop_Nature', title:'性质', width:100, templet: '#wineshop_NatureTpl'}
      ,{field:'wineshop_Telephone', title:'联系电话', width:150, sort: true}
      ,{field:'wineshop_TuiJian', title:'推荐人', width:125}
      ,{field:'logout', title:'状态', width:125,templet:function(d){
    	  return d.logout==1?'已注销':'未注销';
      }}
      ,{field:'wineshop_Address', title:'地址'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:250,align:'center'}
    ]]
    ,page: {
    	limit:20,
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,100,1000,5000],curr:1,groups:10,first:'首页',last:'尾页'
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
    var wName = obj.data.wineshop_Name;
    var id = obj.data.wineshop_ID;
    console.log(obj.data.wineshop_ID)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
        $.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/DelWineshopServlet",
			data:{"id":id},
			success:function(data){
				layer.msg('删除成功了哦！');
				var recodePage = $(".layui-laypage-skip .layui-input").val();
					var recodeLimit = $(".layui-laypage-limits").find("option:selected").val();
					table.reload('wineshop',{
						page:{
							curr: recodePage,
							size: recodeLimit
						}
					});
			}
			
		});
      });
    } else if(obj.event === 'edit'){
    	 window.location.href="${pageContext.request.contextPath}/DetailServlet?id="+id;
    }else if(obj.event === 'detail'){
	 layer.open({
 	      type: 2,
 	      title: wName,
 	      shadeClose: true,
 	      shade: 0.4,
 	      maxmin: true,
 	      area: ['40%', '60%'],
 	      content: "${pageContext.request.contextPath}/admin/wine/zengjuan.jsp",
 	      btn: ['确定'],
	      	  yes: function(index,layero){
	      		 var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
	      		 var xzmoney = arr.xzmoney;
	      		 var zsmoney = arr.zsmoney;
	      		 var time = arr.time;
	      		 var num = arr.num;
	      		 var username = arr.username;
	      		 if(xzmoney == '' || zsmoney == '' ||  time == '' || num == '' || username == ''){
	      			layer.msg('信息不能为空哦！');
	      			return ;
	      		 }
	      		 var params = {
	      				id : id,
	      				xzmoney : xzmoney,
	      				zsmoney : zsmoney,
	      				time : time,
	      				num : num,
	      				username : username
	      		 }
	      		 var url = "${pageContext.request.contextPath}/QWEServlet";
	      		 $.post(url,params,function(result){
	      			 if(result == "success"){
	      				layer.msg('赠券赠送成功了哦！');
	      			 }else{
	      				layer.msg('赠券正在赠送的路上哦！！');
	      			 }
	      		 });
	      		layer.close(index);
	      	  }
 	  });
}
  });
});
</script>
<script type="text/html" id="wineshop_NatureTpl">
  {{#  if(d.wineshop_Nature === '普通酒店'){ }}
 	<span style="color: #5FB878;">{{ d.wineshop_Nature }}</span>
  {{#  } else { }}
     <span style="color: #FF5722;">{{ d.wineshop_Nature }}</span>
  {{#  } }}
</script>
</body>
</html>