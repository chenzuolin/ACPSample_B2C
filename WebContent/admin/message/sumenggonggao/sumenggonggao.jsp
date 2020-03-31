<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>速盟公告</title>
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
    ,url:'${pageContext.request.contextPath}/ConsultCKServlet'
    ,toolbar: '#toolbarDemo'
    ,title: '速盟公告信息表'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:50}
      ,{field:'consult_ID', title:'ID', width:100, fixed: 'left', sort: true}
      ,{field:'user_Name', title:'通知人',width:200, sort: true}
      ,{field:'consult_Time', title:'通知时间', width:200, sort: true}
      ,{field:'content', title:'通知内容'}
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
    var id = obj.data.consult_ID;
    var name = obj.data.content;
    var data = {
    		name: name
    }
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
        $.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/ConsultDEServlet",
			data:{"id":id},
			success:function(data){
				if(data>0){
					layer.msg('删除成功了哦！');
					table.reload();
				}
			}
			
		});
      });
    } else if(obj.event === 'edit'){
    	  layer.open({
    	      type: 2,
    	      title: "编辑分类",
    	      shadeClose: true,
    	      shade: 0.4,
    	      area: ['50%', '50%'],
    	      content: "${pageContext.request.contextPath}/admin/message/sumenggonggao/editConsult.jsp" ,
    	      success: function (layero, index) {
    	            var body = layer.getChildFrame('body', index);
    	            result = JSON.stringify(data);
    	            result = $.parseJSON(result);
    	            $.each(result, function (item) {
    	                body.find('#layuiadmin-app-form-tags' + item).val(result[item]);
    	                if (item == 'name') {
    	                    body.find('#consult').val(result[item]);
    	                } 
    	            });
    	        },
    	      btn: ['确定'],
    	      yes: function(index,layero){
    	    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
    	    	  var content = arr.greendData;
    	    	  $.ajax({
    	  			type:"post",
    	  			url:"${pageContext.request.contextPath}/UpdateConsultById",
    	  			data:{
    	  				"name":content,
    	  				"id":id
    	  			},
    	  			success:function(data){
    	  				if(data==200){
    	  					layer.msg('修改成功了哦！');
        	  				table.reload();
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
	      title: "速盟公告",
	      shadeClose: true,
	      shade: 0.4,
	      area: ['50%', '50%'],
	      content: "${pageContext.request.contextPath}/admin/message/sumenggonggao/addConsult.jsp" ,
	      btn: ['确定'],
	      yes: function(index,layero){
	    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
	    	  var greenName = arr.greendData;
	    	  $.ajax({
	  			type:"post",
	  			url:"${pageContext.request.contextPath}/ConsultServlet",
	  			data:{"name":greenName},
	  			success:function(data){
	  				layer.msg('添加成功了哦！');
	  				table.reload();
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