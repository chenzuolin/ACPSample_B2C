<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑</title>
 <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
<style>
	#layuiadmin-app-form-tags{padding:30px;}
</style>
</head>
<body>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<form class="layui-form layui-form-pane" action="" id="edit" style="padding:30px">

<div class="layui-form-item">
    <label class="layui-form-label">速盟价格</label>
    <div class="layui-input-inline">
      <input type="text" name="passwordtwo" id="price"  autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">市场价格</label>
    <div class="layui-input-inline">
      <input type="tel" name="tel" id="market" lay-verify="required|phone"  autocomplete="off" class="layui-input">
    </div>
</div>

</form>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script> 
<script>

	var callbackdata = function (){
		var price = document.getElementById("price").value;
		var market = document.getElementById("market").value;
		var data = {
				price: price,
				market: market
		}
		return data;
	}

</script>
</body>
</html>