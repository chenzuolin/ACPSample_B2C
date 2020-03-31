<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>更新状态</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<form class="layui-form" id="tp" action="${pageContext.request.contextPath}/UpdateAppleServlet" method="post">
<div class="demoTable" style="margin:10px 10px;">
 更新状态：
  <div class="layui-input-inline" >
			<select name="uname" lay-filter="interest">
				<option value="" disablid selected>请选择需要更新的APP</option>
		        <option value="酒店" >酒店APP</option>
		        <option value="菜商">菜商APP</option>
		        <option value="快递员">快递员APP</option>
		     </select>
		</div>
  <input class="layui-btn" data-type="reload" value="搜索" type="submit">
</div>
</form>
<div class="demoTable" style="margin:10px 10px;">
  登录名称：
  <div class="layui-inline">
    <input class="layui-input" name="name" id="demoReload" placeholder="请输入登录名称" autocomplete="off">
  </div>
 <div class="layui-btn layui-btn-primary layui-btn-radius" data-type="reload"  lay-filter="rechar_btn" id="rechar" ><i class="layui-icon">&#xe615;</i></div>
</div>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="switchTpl">
  <input type="checkbox" name="sex" data-id="{{d.uid}}" lay-skin="switch" lay-text="已更新|未更新" lay-filter="sexDemo" {{ d.utype == 0 ? 'checked' : '' }}>
</script>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
          
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>   
 <script src="${pageContext.request.contextPath}/js/common.js"></script>    
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/form.js"></script>

<script>
layui.use(['table','layer','jquery','form'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var form = layui.form;
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/UappPageServlet'
    ,title: '更新状态'
    ,id: 'log'
    ,even: true
    ,height: 500
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:50,align:'center'}
      ,{field:'uid', title:'ID', width:80, fixed: 'left', unresize: true, sort: true,align:'center'}
      ,{field:'appusername', title:'登录名称'}
      ,{field:'uname', title:'登录类型'}
      ,{field:'udate', title:'最近更新时间', sort: true}
      ,{field:'utype', title:'更新状态', width:150, templet: '#switchTpl', unresize: true,align:'center'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo',align:'center'}
    ]]
    ,page: {
    	limit: 20,
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
  });
  form.on('switch(sexDemo)', function(obj){
  		var uid = $(this).attr('data-id');
  		var valid = this.checked ? '0' : '1' ;
	  	$.ajax({
	  		type:'POST',
	  		url: '${pageContext.request.contextPath}/UpdateUappConduct',
	  		data:{id: uid,valid: valid},
	  		dataType:'json',
	  		success:function(data){
	  			var code = parseInt(data);
	  			if(code == 200){
	  				layer.msg('修改成功了哦！',{icon:6, time:2000});
	  				var recodePage = $(".layui-laypage-skip .layui-input").val();
  					var recodeLimit = $(".layui-laypage-limits").find("option:selected").val();
  					table.reload('log',{
  						page:{
  							curr: recodePage,
  							size: recodeLimit
  						}
  					});
	  			}
	  		},
	  		error:function(data){
	  			layur.msg('修改失败！',{icon:5,time:3000});
	  		}
	  	});
	  });

  table.on('tool(test)', function(obj){
    var id = obj.data.uid;
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
        $.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/DeleteUapp",
			data:{"id":id},
			success:function(data){
				var code = parseInt(data);
				if(code == 200){
					layer.msg('删除成功了哦！',{icon:6, time:2000});
					var recodePage = $(".layui-laypage-skip .layui-input").val();
  					var recodeLimit = $(".layui-laypage-limits").find("option:selected").val();
  					table.reload('log',{
  						page:{
  							curr: recodePage,
  							size: recodeLimit
  						}
  					});
				}
			}
		});
      });
    } 
  });
  
  var active = {
	      reload: function(){
	          var logName = $('#demoReload').val(); 
	          table.reload('log', {
	              url : '${pageContext.request.contextPath}/SerachAPP',
	              method:'post',
	              page: {
	                  curr: 1 
	              }
	              ,where: { 
	            	  logName: logName
	              }
	          });
	      }
	  };
	  $('#rechar').on('click', function(){
	      var type = $(this).data('type');
	      
	      if($('#demoReload').val()==""){
	          layer.msg('登录名称不能为空哦！！！');
	          return false;
	      }
	      
	      active[type] ? active[type].call(this) : '';
	  });
});
</script>

</body>
</html>