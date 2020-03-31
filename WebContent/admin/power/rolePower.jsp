<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>角色权限</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<form class="layui-form" id="tp" action="" style="margin-top:15px;margin-left:15px;">
	<button type="button" class="layui-btn layui-btn-lg layui-btn-primary layui-btn-radius"><i class="layui-icon">&#xe654;</i>添加职位</button>
</form>
<table class="layui-hide" id="test" lay-filter="test"></table>


<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="detail">查看</a>
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
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/form.js"></script>
 
<script>
layui.use(['table','layer','jquery','laydate','form'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var laydate = layui.laydate;
  var layer = layui.layer;
  var index = layer.load(1);
 
  
  var form = layui.form;
  var exportData = '';
   var ins1 = table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/FindAllRole'
    ,toolbar: '#toolbarDemo'
    ,title: '角色权限'
    ,id: 'rolePower'
    ,totalRow: true 
    ,toolbar: '#toolbarDemo'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'role_ID', fixed: 'left',title:'职位编号',width:100,align:'center', sort: true}
      ,{field:'role_Name', title:'职位名称', fixed: 'left', unresize: true, sort: true, width:200}
      ,{field:'role_Remark', title:'职位描述'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', align:'center', width:150}
    ]],
    done: function (res, curr, count) {
        exportData=res.data; 
        layer.close(index);  
    }
  });
   table.on('toolbar(test)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    switch(obj.event){
	      case 'getCheckData':
	        var data = checkStatus.data;
	        if(data.length == 0){
	        	layer.msg('请选择需要打印的数据！');
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
    var roleId = obj.data.role_ID;
    var roleName = obj.data.role_Name;
    var roleRemark = obj.data.role_Remark;
    var data = {
    		roleName : roleName,
    		roleRemark : roleRemark
    }
    if(obj.event === 'detail'){
    	layer.open({
  	      type: 2,
  	      title: roleName,
  	      shadeClose: true,
  	      shade: 0.4,
  	      area: ['90%', '90%'],
  	      content: "${pageContext.request.contextPath}/admin/power/check.jsp?id="+roleId ,
  	      success: function (layero, index) {
  	    	var body = layer.getChildFrame('body', index);
            result = JSON.stringify(data);
            result = $.parseJSON(result);
            $.each(result, function (item) {
                body.find('#power' + item).val(result[item]);
                if (item == 'roleName') {
                    body.find('#roleName').val(result[item]);
                } 
                if (item == 'roleRemark') {
                    body.find('#roleRemark').val(result[item]);
                } 
            });
  	        }
  	  });
    } 
  });

});
</script>
</body>
</html>