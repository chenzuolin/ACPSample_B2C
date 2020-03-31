<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>蔬菜信息</title>
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
         <div class="layui-btn layui-btn-primary layui-btn-radius" data-type="reload"  lay-filter="rechar_btn" id="rechar_btn" ><i class="layui-icon">&#xe654;</i>添加小类</div>
         <div class="layui-btn layui-btn-primary layui-btn-radius" data-type="reload"  lay-filter="rechar_btn" id="btnAuto" ><i class="layui-icon">&#xe654;</i>添加大类</div>
      </div>
      <div class="layui-card-body">    
        <table class="layui-hide" id="test" lay-filter="test"></table> 
        <script type="text/html" id="barDemo">
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
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
<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/layui.all.js"></script>
<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/EditGreensType'
    ,toolbar: '#toolbarDemo'
    ,title: '蔬菜信息表'
    ,height: 550
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',templet: '#xuhao',width:50}
      ,{field:'greens_Type_ID', title:'ID', width:200, fixed: 'left', sort: true}
      ,{field:'bigTypeName', title:'大类名称'}
      ,{field:'greens_Type_Name', title:'小类名称'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:180,align:"center"}
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
  
  
  table.on('tool(test)', function(obj){
    var data = obj.data
    ,layEvent = obj.event;
    var id = obj.data.greens_Type_ID;
    var name = obj.data.greens_Type_Name;
    var bigName = obj.data.bigTypeName;
    var data = {
    		name: name,
    		bigName: bigName
    }
    if(obj.event === 'edit'){
    	  layer.open({
    	      type: 2,
    	      title: "编辑分类",
    	      shadeClose: true,
    	      shade: 0.4,
    	      area: ['30%', '50%'],
    	      content: "${pageContext.request.contextPath}/admin/greens/type/editGreensType.jsp" ,
    	      success: function (layero, index) {
    	            var body = layer.getChildFrame('body', index);
    	            result = JSON.stringify(data);
    	            result = $.parseJSON(result);
    	            $.each(result, function (item) {
    	                body.find('#layui_form' + item).val(result[item]);
    	                if (item == 'name') {
    	                    body.find('#greensType').val(result[item]);
    	                } 
    	                if (item == 'bigName') {
    	                    body.find('#bigType').val(result[item]);
    	                } 
    	            });
    	        },
    	      btn: ['确定'],
    	      yes: function(index,layero){
    	    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
    	    	  var greenName = arr.greendData;
    	    	  var bigName = arr.bigName;
    	    	  $.ajax({
    	  			type:"post",
    	  			url:"${pageContext.request.contextPath}/EditGreens",
    	  			data:{
    	  				"name":greenName,
    	  				"bigName":bigName,
    	  				"id":id
    	  			},
    	  			success:function(data){
    	  				layer.msg('修改成功了哦！');
    	  			}
    	  			
    	  		});
    	          layer.close(index);
    	      },
	  	      end:function(){
		          	$('.layui-laypage-btn').click();
		          }
              
    	  });
    }
  });

  $('#rechar_btn').on('click', function(){
	  layer.open({
	      type: 2,
	      title: "添加小类",
	      shadeClose: true,
	      shade: 0.4,
	      area: ['30%', '50%'],
	      content: "${pageContext.request.contextPath}/admin/greens/type/addGreensType.jsp" ,
	      btn: ['确定'],
	      yes: function(index,layero){
	    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
	    	  var greenName = arr.greendData;
	    	  var bigType = arr.greensBigName;
	    	  if(greenName == '' || bigType == ''){
	    		  layer.msg('类型不能为空哦！');
	    		  return false;
	    	  }
	    	  $.ajax({
	  			type:"post",
	  			url:"${pageContext.request.contextPath}/leixinServlet",
	  			data:{"name":greenName,"bigName":bigType},
	  			success:function(data){
	  				layer.msg('添加成功了哦！');
	  			}
	  			
	  		});
	          layer.close(index);
	      },
  	      end:function(){
	          	$('.layui-laypage-btn').click();
	          }
          
	  });
  });
  $('#btnAuto').on('click', function(){
	  layer.open({
	      type: 2,
	      title: "添加大类",
	      shadeClose: true,
	      shade: 0.4,
	      area: ['30%', '75%'],
	      content: "${pageContext.request.contextPath}/admin/greens/type/maxBigType.jsp" ,
	      btn: ['确定'],
	      yes: function(index,layero){
	    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
	    	  var bigTypeName = arr.bigtypename;
	    	  if(bigTypeName == '' ){
	    		  layer.msg('类型不能为空哦！');
	    		  return false;
	    	  }
	    	  $.ajax({
	  			type:"post",
	  			url:"${pageContext.request.contextPath}/AddBigType",
	  			data:{"bigName":bigTypeName},
	  			success:function(data){
	  				if(data == 200){
	  					layer.msg('添加成功了哦！');
	  				}
	  			}
	  			
	  		});
	          layer.close(index);
	      },
  	      end:function(){
	          	$('.layui-laypage-btn').click();
	          }
          
	  });
  });
});
</script>

</body>
</html>