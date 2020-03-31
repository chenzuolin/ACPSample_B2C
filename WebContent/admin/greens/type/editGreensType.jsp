<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@ page import="com.sumeng.service.*"%>
<%@ page import="com.sumeng.web.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑分类</title>
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>

<div class="layui-form" id="layui_form" style="padding:25px;" >
  <div class="layui-form-item">
    <label class="layui-form-label">大类名称</label>
	    <div class="layui-input-inline">
	      <select name="bigType" id="bigType">
	        <%
	        	BigDao big = new BigDao();
	        	List<BigType> bigList = big.getFindAll();
	        	for(BigType bb : bigList){
	        		String bigName = bb.getBigTypeName();
	        %>
	        <option value="<%=bigName %>"><%=bigName %></option>
	        <%
	        	}
	        %>
	      </select>
	    </div>
  </div>

    <div class="layui-form-item">
      <label class="layui-form-label">小类名称</label>
      <div class="layui-input-inline">
        <input type="text" name="greensType" id="greensType" lay-verify="required" placeholder="请输入小类名称" autocomplete="off" class="layui-input">
      </div>
    </div>
    
</div>
  <script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script>
var callbackdata = function (){
	var greensType = document.getElementById("greensType").value;
	var bigname = document.getElementById("bigType").value;
	var data = {
			greendData: greensType,
			bigName: bigname
	}
	return data;
}
</script>
</body>
</html>