<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>价格修改</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>

<table id="demo" lay-filter="test"></table>
 


<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/lay/modules/layer.js"></script>
 <script src="${pageContext.request.contextPath}/js/common.js"></script>    
<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/layui.all.js"></script>
<script type="text/html" id="barDemo">
 
 <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">是否全选</button>
<a class="btn-refresh" style="display: none;" href="javascript:;" onclick="javascript:location.replace(location.href);" title="刷新" ></a>
  </div>
</script>

<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  //第一个实例
  table.render({
    elem: '#demo'
    ,url: './FindAllGreensServlet' //数据接口
    ,toolbar: '#toolbarDemo'
    ,title:'价格修改'
    ,type: 'get'
    ,cols: [[ //表头
     {type: 'checkbox', fixed: 'left'}
     ,{field: 'greens_ID', title: 'ID', width:80, sort: true, fixed: 'left',align:'center',}
      ,{field: 'greens_Name', title: '蔬菜名称', width:200, sort: true, fixed: 'left',align:'center', style:'background-color: #009688; color: #fff;'}
      ,{field:'greens_Unit', title:'蔬菜单位', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field: 'greens_Price', title: '速盟价格', width:200,align:'center'}
      ,{field: 'greens_Market_Price', title: '市场价格', width:200,align:'center'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:200,align:'center'}
    ]]
  
    ,page: {
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
  });
  


  
  //监听行工具事件
  table.on('tool(test)', function(obj){//传入indent_ID
    var data = obj.data;
    var name = obj.data.greens_Name;
    var price = obj.data.greens_Price;
    var market = obj.data.greens_Market_Price;
    var unit = obj.data.greens_Unit;
    var ID = data.greens_ID;
    
    var data = {
    		Greens_Name:name,
    		Greens_price:price,
    		Greens_market:market,
    		Greens_Unit:unit
    };
   // console.log(obj.data.wineshop_ID)
   if(obj.event === 'edit'){
	   layer.open({
           type: 2,
           title:name ,
           maxmin: true,
           area: ['420px', '330px'],
           shadeClose: true, //点击遮罩关闭
           shade:0.4,
           content: './Greens.jsp',
           end:function(){
        	   $('.layui-laypage-btn').click();//模拟点击
           },
           success:function(layero,index){
               var body = layer.getChildFrame('body', index);
	            result = JSON.stringify(data);
	            result = $.parseJSON(result);
	            $.each(result, function (item) {
	                body.find('#edit' + item).val(result[item]);
	                if (item == 'Greens_price') {
	                    body.find('#price').val(result[item]);
	                } 
	                if (item == 'Greens_market') {
	                    body.find('#market').val(result[item]);
	                } 
	            });
           },
           btn: ['确定'],
 	      yes: function(index,layero){
 	    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
 	    	  var price = arr.price;
 	    	  var market = arr.market;
 	    	  $.ajax({
 	    		  type:"get",
 	    		  url:"./UpdateGreens",
 	    		  data:{
 	    			  "ID":ID,
 	    			  "price":price,
 	    			  "market":market
 	    		  },
 	    		
 	    		  success:function(data){
 	    			
 	    			 
 	    		  }
 	    		  
 	    	  
 	    	  });
 	    	
 	          layer.close(index);
 	      }
    	
      
           
       });

    	
    	
    }
  });

  	
  
});
</script>

</body>
</html>