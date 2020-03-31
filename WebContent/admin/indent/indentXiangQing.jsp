<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@ page import="com.sumeng.service.*"%>
<%@ page import="com.sumeng.web.*"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	IndentDao dao = new IndentDao();
	AllIndent dd = dao.findAllIndent(id);
	int indentId = dd.getIndent_ID();
	String indentTime = dd.getIndent_Time();
	String indentType = dd.getIndent_Status();
	String indentRemark = dd.getIndent_remark();
	String cgName = dd.getCg_Name();
	String cgTime = dd.getCg_time();
	String fjName = dd.getFj_Name();
	String fjTime = dd.getFj_Time();
	String kdName = dd.getCourier_Name();
	String kdTime = dd.getPs_time();
	String wineshopName = dd.getWineshop_Name();
	String wineshopTel = dd.getWienshop_telephone();
	String wienshopTuiJian = dd.getWienshop_tuijian();
	String wienshopFZ = dd.getWineshop_shift_name();
	String wineshopStartTime = dd.getWienshop_Time();
	String wineshopEndTime = dd.getWienshop_nightTime();
	String wineshopAddr = dd.getWineshop_address();
	String weiType = dd.getIndent_Type();
	String weiPayID = dd.getIndent_PayID();
	String weiMoney = dd.getTotalPrice();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>订单详情</title>
    <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopping.css"/>
    <style>
        .layui-form-item {
            margin-bottom: 0;
            margin-top: 20px;
        }

        .layui-form-item .layui-inline {
            margin-bottom: 25px;
            margin-right: 0;
        }

        .form-group-bottom {
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
            background-color: #fff;
            padding: 10px 20px;
            box-shadow: 0 -1px 2px 0 rgba(0, 0, 0, .05);
        }
    </style>

</head>
<body>



<!-- 正文开始 -->
<form class="layui-form" id="tp" enctype="multipart/form-data" method="post">
    <div class="layui-fluid" style="padding-bottom: 25px;">
        <div class="layui-card">
            <div class="layui-card-header">订单详情</div>
            <div class="layui-card-body">

                <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">订单编号</label>
                        <div class="layui-input-block">
                            <input name="greensName" type="text" value="<%=indentId %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">下单时间</label>
                         <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=indentTime %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">订单状态</label>
                        <div class="layui-input-block"  >
                        	<input name="greensName" type="text" value="<%=indentType %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                   
                      <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">采购人员</label>
                       <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=cgName %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                      <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">采购时间</label>
                       <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=cgTime %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                      <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">分拣人员</label>
                       <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=fjName %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                      <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">分拣时间</label>
                       <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=fjTime %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                      <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">快递人员</label>
                       <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=kdName %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                      <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">接单时间</label>
                       <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=kdTime %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                     <div class="layui-form-item">
                        <label class="layui-form-label">订单备注</label>
                       <div class="layui-input-block" >
                           <input name="greensName" type="text" value="<%=indentRemark %>" readonly="readonly"  class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                </div>
              </div>
             </div>
             <div class="layui-card">
            <div class="layui-card-header">酒店详情</div>
            <div class="layui-card-body">

                <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">酒店名称</label>
                        <div class="layui-input-block">
                            <input name="greensName" type="text" value="<%=wineshopName %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">联系电话</label>
                         <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=wineshopTel %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">推荐人</label>
                        <div class="layui-input-block"  >
                        	<input name="greensName" type="text" value="<%=wienshopTuiJian %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">负责人</label>
                       <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=wienshopFZ %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                     <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">最早时间</label>
                       <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=wineshopStartTime %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                     <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">最晚时间</label>
                       <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=wineshopEndTime %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">酒店地址</label>
                       <div class="layui-input-block" >
                           <input name="greensName" type="text" value="<%=wineshopAddr %>" readonly="readonly"  class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    
                </div>
              </div>
             </div>
             <div class="layui-card">
            <div class="layui-card-header">支付详情</div>
            <div class="layui-card-body">

                <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">支付类型</label>
                        <div class="layui-input-block">
                            <input name="greensName" type="text" value="<%=weiType %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">支付编号</label>
                         <div class="layui-input-block">
                           <input name="greensName" type="text" value="<%=weiPayID %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">支付金额</label>
                        <div class="layui-input-block"  >
                        	<input name="greensName" type="text" value="<%=weiMoney %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                </div>
             </div>
          </div>
            <div class="layui-card">
            <div class="layui-card-header">蔬菜详情</div>
            <div class="layui-card-body">
				<table class="layui-hide" id="test" lay-filter="test"></table>
             </div>
          </div>
     </div>
</form>
</body>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>   
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script>
layui.use(['table','layer','jquery','form'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var form = layui.form;
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/ShuCaiXiangQing'
    ,title: '蔬菜信息'
    ,where:{
    	id: '<%=id %>'
    }
    ,cols: [[
   	  {field:'rownum', fixed: 'left',templet: '#xuhao',width:100,align:'center',title:'序号'}
      ,{field:'greens_Name', title:'蔬菜名称'}
      ,{field:'greens_Price', title:'速盟单价',align:'center',templet:function(d){
      		return d.greens_Price+'元/'+d.greens_Unit;
      }}
      ,{field:'number', title:'购买数量', sort: true,align:'center',templet:function(d){
      		return d.number + d.greens_Unit;
      }}
      ,{field:'utype', title:'小计', width:150,align:'center', templet: function(d){
      		 return Math.round(d.greens_Price*d.number* 100) / 100+'元';
      }}
    ]]
  });

  
});
</script>
</html>