<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/layui.css" rel="stylesheet" media="all">
<title>Insert title here</title>
</head>
<body>
<form action="ASS3Servlet">
赠送酒店ID：<input type="text" name="Wineshop_ID" ><br/>
满<input type="text" name="Give_Money" >元可使用<br/>
赠送券金额：<input type="text" name="Give_Num" ><br/>
<div class="layui-inline" id="start">
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px;">过期时间</label>
			<div class="layui-input-inline">
				<input type="text" lay-verify="required"  name="Give_Time" id="date1" class="layui-input"  placeholder="请输入过期时间">
			</div>
	</div>

经办人：<input type="text" name="Give_FZ" ><br/>
<input type="submit" value="提交">
</form>
<script src="layui/layui.js" charset="UTF-8"></script>
<script>
//执行一个laydate实例

layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#date1'
    //指定元素
  });
});
</script>
</body>
</html>