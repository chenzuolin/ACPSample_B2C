<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title></title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
          
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>   
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>

 
<script>
function child(d){
layui.use(['table','layer','jquery','laydate'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var laydate = layui.laydate;

  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/WineshopAllIndent'
    ,toolbar: '#toolbarDemo'
    ,title: '订单信息表'
    ,id: 'indent'
    ,height: 400
    ,where:{
    	id: d
    }
    ,totalRow: true 
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'left',title:'序号',templet: '#xuhao',width:75,align:'center'}
      ,{field:'greens_Name', title:'蔬菜名称', align: 'center'}
      ,{field:'greens_Price', title:'速盟单价', align: 'center',templet:function(d){
    	  return d.greens_Price+'/'+d.greens_Unit;
      }}
      ,{field:'number', title:'购买数量',  align: 'center',templet:function(d){
    	  return d.number + '/' + d.greens_Unit;
      }}
      ,{field:'total', title:'小计',fixed: 'right',align: 'center', sort: true, templet:function(d){
    	  return '￥'+Math.round(d.greens_Price*d.number* 100) / 100;
      }}
    ]]
  });
});
}
</script>

</body>
</html>