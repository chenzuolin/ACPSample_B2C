<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@ page import="com.sumeng.service.*"%>
<%@ page import="com.sumeng.web.*"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>蔬菜销量查询</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopping.css"/>
</head>
<body> 
<div class="demoTable" style="margin:10px 10px;">
蔬菜名称：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" placeholder="请输入蔬菜名称" autocomplete="off">
  </div>
 
 <div class="layui-inline">
                        <label class="layui-form-label">蔬菜小类</label>
                        <div class="layui-input-block"  >
                           <select name="typeName" id="typeName"  required>
                           	  <option value="">请选择蔬菜小类</option>
                           	  <%
                           			Greens_TypeDao green = new Greens_TypeDao();
                           	  		List<Greens_Type> greenList = green.findAll();
                           	  		for(Greens_Type type : greenList){
                           	  			String bigName = type.getGreens_BigTypeName();
                           	  			String typeName = type.getGreens_Type_Name();
                           	  %>
                           	   <optgroup label="<%=bigName %>">
            						<option value="<%=typeName %>"><%=typeName %></option>
          					   </optgroup>
          					   <%
          					   		}
          					   %>
                           </select>
                        </div>
                    </div>
 
 
 
  <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
  <input type="text" class="layui-input" placeholder="请输入开始日期" id="test1">
</div>
 <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
  <input type="text" class="layui-input" placeholder="请输入结束日期" id="test2">
</div>
  
  <input class="layui-btn" data-type="reload" value="搜索" type="button" id="sousuo">
</div>
<table id="demo" lay-filter="test"></table>
 
<script src="layui-v2.5.2/layui/layui.all.js"></script>


 
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#test1' //指定元素
  });
});
</script>
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#test2' //指定元素
  });
});
</script>
<script type="text/html" id="barDemo">
 
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">是否全选</button>
  </div>
</script>

<script>
layui.use(['table','layer','jquery'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  //第一个实例
  table.render({
    elem: '#demo'
    ,url: './GreensNumberServlet' //数据接口
    ,toolbar: '#toolbarDemo'
    ,title:'蔬菜销量查询'
    ,type: 'get'
    
    ,cols: [[ //表头
     {type: 'checkbox', fixed: 'left'}
      ,{field: 'greens_Name', title: '蔬菜名称', width:200, sort: true, fixed: 'left',align:'center',style:'background-color:#009688;color:#fff'}
      ,{field:'nN', title:'总销量', width:120, fixed: 'left', unresize: true, sort: true,style:'background-color:#eee',align:'center'}
      ,{field: 'greens_Unit', title: '蔬菜单位', width:200,align:'center'}
      ,{field: 'greens_Type_Name', title: '蔬菜类型', width:200,align:'center', templet: '#typeTpl'}
      
    ]]
    ,page: {
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    }
  });
  
//搜索查询
  var active = {
      reload: function(){
    	  var name = $('#demoReload').val();//蔬菜名称
          var date_s = $('#test1').val(); 
          var date_s1 = $('#test2').val();//传入搜索的日期值 
         var Greens_Type = $('#typeName').val();//类别
          //执行重载
          table.reload('demo', {
              url : './GreensNumberServlet1',
              method:'get',
              page: {
                  curr: 1 //重新从第 1 页开始
              }
              ,where: { //类似于 data
            	  Greens_Name:name,
                  Time1:date_s,
                  Time2:date_s1,
                  Greens_Type_Name:Greens_Type						
              }
          });
      }
  };
  $('#sousuo').on('click', function(){
      var type = $(this).data('type');
      //不能为空验证
      if( $('#test1'||'#test2').val()==""){
          layer.msg('查询日期不能为空');
          return false;
          console.log("aa");
      }
      active[type] ? active[type].call(this) : '';
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){//传入indent_ID
    var data = obj.data;
    var id = obj.data.indent_ID;
    var name = obj.data.wineshop_Name;
   // alert(id);
   // console.log(obj.data.wineshop_ID)
   if(obj.event === 'detail'){
	   window.location.href="${pageContext.request.contextPath}/DY.jsp?id="+id+"&name="+name;
    }
  });
});
</script>
<script type="text/html" id="typeTpl">
   {{#  if(d.greens_Type_Name === '叶菜类'){ }}
  	 <span style="color: #5FB878;">{{ d.greens_Type_Name }}</span></a>
  {{#  } else if(d.greens_Type_Name === '根茎类'){ }}
     <span style="color: #01AAED;">{{ d.greens_Type_Name }}</span></a>
  {{#  }else{ }}
	<span style="color: #FF5722;">{{ d.greens_Type_Name }}</span></a>
  {{#  } }}
	
	
</script>

</body>
</html>