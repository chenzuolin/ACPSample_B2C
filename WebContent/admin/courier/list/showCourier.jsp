<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>快递管理</title>
  <meta name="renderer" content="webkit">
  <link rel="shortcut icon" href="../../index.ico" type="image/x-icon" />
   <link rel="shortcut icon" href="${pageContext.request.contextPath}/index.ico" type="image/x-icon" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
  <div class="layui-fluid">
    <div class="layui-card">
      <div class="layui-card-header layuiadmin-card-header-auto">
        <button class="layui-btn layuiadmin-btn-tags" id="rechar_btn"><i class="layui-icon">&#xe654;</i></button>
      </div>
      <div class="layui-card-body">    
        <table class="layui-hide" id="test" lay-filter="test"></table> 
        <script type="text/html" id="barDemo">
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
      </div>
    </div>
  </div>


<script type="text/html" id="toolbarDemo">
</script>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>

<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/lay/modules/layer.js"></script>
 <script src="${pageContext.request.contextPath}/js/common.js"></script>    
<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/layui.all.js"></script>
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/ShowCourierList'
    ,toolbar: '#toolbarDemo'
    ,id: 'courier'
    ,title: '快递员信息表'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:50}
      ,{field:'courier_ID', title:'ID', width:100, fixed: 'left', sort: true,align:'center'}
      ,{field:'courier_Name', title:'用户名',width:200, sort: true}
      ,{field:'courier_Password', title:'密码', width:200, sort: true}
      ,{field:'courier_Time', title:'注册时间', width:200, sort: true}
      ,{field:'courier_Telephone', title:'联系电话', width:200}
      ,{field:'courier_Vehicle', title:'运输类型'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:180,align:"center"}
    ]]
    ,page: {
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
  });
  
  
  table.on('tool(test)', function(obj){
    var data = obj.data
    ,layEvent = obj.event;
    var id = obj.data.courier_ID;
    var name = obj.data.courier_Name;
    var pwd = obj.data.courier_Password;
    var tel = obj.data.courier_Telephone;
    var type = obj.data.courier_Vehicle;
    var data = {
    		name: name,
    		pwd: pwd,
    		tel: tel,
    		type: type
    }
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
        $.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/DelCourierById",
			data:{"id":id},
			success:function(data){
				if(data == 200){
					layer.msg('删除成功了哦！');
					var recodePage = $(".layui-laypage-skip .layui-input").val();
  					var recodeLimit = $(".layui-laypage-limits").find("option:selected").val();
  					table.reload('courier',{
  						page:{
  							curr: recodePage,
  							size: recodeLimit
  						}
  					});
				}
			}
			
		});
      });
    } else if(obj.event === 'edit'){
    	  layer.open({
    	      type: 2,
    	      title: "编辑",
    	      shadeClose: true,
    	      shade: 0.4,
    	      area: ['30%', '60%'],
    	      content: "${pageContext.request.contextPath}/admin/courier/list/edit.jsp" ,
    	      success: function (layero, index) {
    	            var body = layer.getChildFrame('body', index);
    	            result = JSON.stringify(data);
    	            result = $.parseJSON(result);
    	            $.each(result, function (item) {
    	                body.find('#edit' + item).val(result[item]);
    	                if (item == 'name') {
    	                    body.find('#name').val(result[item]);
    	                } 
    	                if (item == 'pwd') {
    	                    body.find('#passwordtwo').val(result[item]);
    	                } 
    	                if (item == 'tel') {
    	                    body.find('#tel').val(result[item]);
    	                } 
    	                if (item == 'type') {
    	                    body.find('#courierType').val(result[item]);
    	                } 
    	            });
    	        },
    	      btn: ['确定'],
    	      yes: function(index,layero){
    	    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
    	    	  var username = arr.username;
    	    	  var pwd = arr.pwd;
    	    	  var tel = arr.tel;
    	    	  var type = arr.type;
    	    	  $.ajax({
    	  			type:"post",
    	  			url:"${pageContext.request.contextPath}/UpdateCourierById",
    	  			data:{
    	  				"name":username,
    	  				"id":id,
    	  				"tel":tel,
    	  				"pwd":pwd,
    	  				"type":type
    	  			},
    	  			success:function(data){
    	  				if(data == 200){
    	  					layer.msg('修改成功了哦！');
    	  					var recodePage = $(".layui-laypage-skip .layui-input").val();
    	  					var recodeLimit = $(".layui-laypage-limits").find("option:selected").val();
    	  					table.reload('courier',{
    	  						page:{
    	  							curr: recodePage,
    	  							size: recodeLimit
    	  						}
    	  					});
    	  				}
    	  			}
    	  			
    	  		});
    	          layer.close(index);
    	      }
              
    	  });
    	
    	
    }
  });

  $('#rechar_btn').on('click', function(){
	  layer.open({
	      type: 2,
	      title: "新增快递员",
	      shadeClose: true,
	      shade: 0.4,
	      area: ['40%', '70%'],
	      content: "${pageContext.request.contextPath}/admin/courier/list/add.jsp" ,
	      btn: ['确定'],
	      yes: function(index,layero){
	    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
	    	  var name = arr.username;
	    	  var pwd = arr.pwd;
	    	  var tel = arr.tel;
	    	  var type = arr.type;
	    	  $.ajax({
	  			type:"post",
	  			url:"${pageContext.request.contextPath}/KDYServlet",
	  			data:{
	  				"name":name,
	  				"pwd":pwd,
	  				"tel":tel,
	  				"type":type
	  			},
	  			success:function(data){
	  				layer.msg('添加成功了哦！');
	  				var recodePage = $(".layui-laypage-skip .layui-input").val();
  					var recodeLimit = $(".layui-laypage-limits").find("option:selected").val();
  					table.reload('courier',{
  						page:{
  							curr: recodePage,
  							size: recodeLimit
  						}
  					});
	  			}
	  			
	  		});
	          layer.close(index);
	      }
          
	  });
  });
});
</script>

</body>
</html>