<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <title>订单查询</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>


 酒店名称：
 
 
 
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" placeholder="请输入酒店名称" autocomplete="off">
  </div>
  <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
  <input type="text" class="layui-input" placeholder="请输入开始日期" id="test1">
       </div>
到

 <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
  <input type="text" class="layui-input" placeholder="请输入结束日期" id="test2">
</div>


  <button onclick="sousuo()">打印</button>
 
<script src="./layui-v2.4.5/layui/layui.js"></script>
<script src="/static/build/layui.js"></script>
<script src="js/jquery-1.11.3.min.js" type="text/javascript">

</script>

<script>
layui.use('laydate', function(){
	  var laydate = layui.laydate;
laydate.render({
    elem: '#test1'
    ,type: 'datetime'
  });
});

layui.use('laydate', function(){
	  var laydate = layui.laydate;
laydate.render({
  elem: '#test2'
  ,type: 'datetime'
});
});
  //执行一个laydate实例
  

</script>
<script type="text/javascript">
	function sousuo(){
		var name = $('#demoReload').val();
		
        var time1 = $('#test1').val(); 
        var time2 = $('#test2').val();//传入搜索的日期值 
        window.location.href="PL.jsp?name="+name+"&time1="+time1+"&time2="+time2;
	}

</script>

</body>
</html>