<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@ page import="com.sumeng.service.*"%>
<%@ page import="com.sumeng.web.*"%>
<%
	int roleId = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看</title>
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>

<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend></legend>
</fieldset>
<form class="layui-form" action="" id="power">
 <div class="layui-form-item">
    <label class="layui-form-label">职位名称</label>
    <div class="layui-input-block">
      <input type="text" name="title" lay-verify="title" id="roleName" autocomplete="off" placeholder="请输入职位名称" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">职位描述</label>
    <div class="layui-input-block">
      <input type="text" name="username" lay-verify="required" id="roleRemark"  placeholder="请输入职位描述" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-tab" lay-filter="demo" style="padding-left:20px;">
  <ul class="layui-tab-title">
    <li class="layui-this">权限管理</li>
    <li>财务管理</li>
    <li>消息管理</li>
    <li>酒店管理</li>
    <li>订单管理</li>
    <li>蔬菜管理</li>
    <li>投诉反馈</li>
    <li>快递管理</li>
    <li>积分管理</li>
    <li>系统设置</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=权限管理&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}"></th>
		      <th lay-data="{field:'pare_menu_name'}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		      <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
    <div class="layui-tab-item">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=财务管理&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}">授权</th>
		      <th lay-data="{field:'pare_menu_name', sort: true}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		      <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
    <div class="layui-tab-item">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=消息管理&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}">授权</th>
		      <th lay-data="{field:'pare_menu_name', sort: true}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		     <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
    <div class="layui-tab-item">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=酒店管理&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}">授权</th>
		      <th lay-data="{field:'pare_menu_name', sort: true}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		      <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
    <div class="layui-tab-item">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=订单管理&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}">授权</th>
		      <th lay-data="{field:'pare_menu_name', sort: true}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		     <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
    <div class="layui-tab-item">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=蔬菜管理&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}">授权</th>
		      <th lay-data="{field:'pare_menu_name', sort: true}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		      <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
    <div class="layui-tab-item">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=投诉反馈&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}">授权</th>
		      <th lay-data="{field:'pare_menu_name', sort: true}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		     <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
    <div class="layui-tab-item">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=快递管理&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}">授权</th>
		      <th lay-data="{field:'pare_menu_name', sort: true}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		     <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
    <div class="layui-tab-item">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=积分管理&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}">授权</th>
		      <th lay-data="{field:'pare_menu_name', sort: true}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		   	  <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
    <div class="layui-tab-item">
    	<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/RolePower?name=系统设置&roleId=<%=roleId %>', page:true, id:'test'}" lay-filter="test">
		  <thead>
		    <tr>
		      <th lay-data="{type:'checkbox',LAY_CHECKED:true}">授权</th>
		      <th lay-data="{field:'pare_menu_name', sort: true}">分栏名称</th>
		      <th lay-data="{field:'pare_menu_path'}">分栏路径</th>
		      <th lay-data="{field:'starts',templet: function(d){return d.starts==1 ? '已开通':'未开通'}}">分栏状态</th>
		    </tr>
		  </thead>
		</table>
    </div>
  </div>
</div>
</form>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
</body>
</html>