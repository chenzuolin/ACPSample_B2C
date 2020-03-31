<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>APP更新</title>
<link href="css/layui.css" rel="stylesheet" media="all">
<link href="layui-v2.3.0/layui/css/layui.css" rel="stylesheet" >
<script src="layui/layui.js" charset="UTF-8"></script>
<style>
td{text-align:center;}
</style>
<script type="text/javascript">
	function changePage(){
		var page = document.getElementById("pageSel").value;;
		window.location.href="UappPageServlet?currentPage="+page;
	}
</script>
</head>
<body>
<form action="UpdateAppleServlet" method="post" class="layui-form layui-form-pane">
<fieldset>
   <legend>软件更新</legend>
	<div class="layui-inline" style="padding:0 20px">
	<label class="layui-btn" style="background:rgb(126,126,126); width:121px;"><strong>更新状态</strong></label>
		<div class="layui-input-inline" style="width:186px;">
			<select name="uname" lay-filter="interest">
		        <option value="酒店" disablid selected>酒店APP</option>
		        <option value="菜商">菜商APP</option>
		        <option value="快递员">快递员APP</option>
		     </select>
		</div>
	</div>
	<div class="layui-inline">
		<div class="layui-input-inline">
			<button class="layui-btn" type="submit" style="width:121px;">提交</button>
		</div>
	</div>
</fieldset>
</form>

<table class="layui-table" style=" width:90%; margin-left:5%; table-layout: fixed;">
		<tr class="one">
			<td>序号</td>
			<td>登录名称</td>
			<td>登录类型</td>
			<td>登录时间</td>
			<td>更新状态</td>
		</tr>
	
	<c:forEach items="${page.list }" var="app" varStatus="vs">
		<tr class="two">
			<td>${vs.count }</td>
			<td>${app.appusername }</td>
			<td>${app.uname }</td>
			<td>${app.udate }</td>
			<td>${app.utype==1?"未更新":"已更新" }</td>
		</tr>
	</c:forEach>
	<tr class="three">
		<td colspan="5">
			<c:if test="${page.currentPage!=1 }">
				<a href="UappPageServlet?currentPage=${page.currentPage-1 }">上一页</a>
			</c:if>
			<c:forEach varStatus="aaa" begin="1" end="${page.totalPage }"> 
				<c:choose>
					<c:when test="${page.currentPage==aaa.count }">
						<a href="UappPageServlet?currentPage=${aaa.count }" style="color:red;">${aaa.count }</a>&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<a href="UappPageServlet?currentPage=${aaa.count }">${aaa.count }</a>&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			<c:if test="${page.currentPage!=page.totalPage }">
				<a href="UappPageServlet?currentPage=${page.currentPage+1 }">下一页&nbsp;&nbsp;</a>
			</c:if>
			共<span style="color:red;">${page.totalPage }</span>页&nbsp;&nbsp;&nbsp;&nbsp;到
			<select id="pageSel" onchange="changePage();">
				<c:forEach begin="1" end="${page.totalPage }" varStatus="aaa">
					<option value="${aaa.count }">${aaa.count }</option>
				</c:forEach>
			</select>
			页
		</td>
	</tr>
</table>
<script src="layui-v2.3.0/layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
</body>
</html>