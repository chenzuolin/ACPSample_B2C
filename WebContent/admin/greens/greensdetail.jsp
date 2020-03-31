<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@ page import="com.sumeng.service.*"%>

<%
 	int gid = Integer.parseInt(request.getParameter("id"));
	GreensDao green = new GreensDao();
	Greens greens = green.findObjectByID(gid);
	String name = greens.getGreens_Name();
	String bigName = greens.getBigName();
	String typeName = greens.getGreens_Type_Name();
	String unit = greens.getGreens_Unit();
	float price = greens.getGreens_Price();
	float mPrice = greens.getGreens_Market_Price();
	String pinzhi = greens.getGreens_Character();
	String pinxiang = greens.getGreens_Condition();
	int minNumber = greens.getGreens_Minnumber();
	String weight = greens.getGreens_Norms();
	int kucun = greens.getGreens_Number();
	String addr = greens.getGreens_Class();
	String jijie = greens.getGreens_characteristics();
	String remark = greens.getGreens_Remark();
	String tuijian = greens.getGreens_Recommend();
	String tupian = greens.getGreens_tupian();
	int stop = greens.getGreens_Stop();
	String day = greens.getGreens_Preiod();
	String greensRemark = greens.getGreens_Remark();
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>蔬菜上传</title>
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
    <div class="layui-fluid" style="padding-bottom: 75px;">
        <div class="layui-card">
            <div class="layui-card-header">蔬菜属性</div>
            <div class="layui-card-body">

                <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜名称</label>
                        <div class="layui-input-block">
                            <input name="greensName" type="text" value="<%=name %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜大类</label>
                         <div class="layui-input-block">
                            <select name="bigTypeName" id="bigType" lay-verType="tips" lay-filter="bigType" >
                                <option value="<%=bigName %>"><%=bigName %></option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜小类</label>
                        <div class="layui-input-block"  >
                           <select name="typeName" id="typeName"  required>
                           	  <option value=""><%=typeName %></option>
                           	   <optgroup label="<%=bigName %>">
            						<option value="<%=typeName %>"><%=typeName %></option>
          					   </optgroup>
                           </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜单位</label>
                       <div class="layui-input-block">
                            <select name="unit" lay-verType="tips" lay-verify="required" required>
                                <option value="<%=unit %>"><%=unit %></option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">速盟单价</label>
                          <div class="layui-input-block">
                            <input name="price" type="text" value="<%=price %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">市场单价</label>
                         <div class="layui-input-block">
                            <input name="markPrice" type="text" value="<%=mPrice %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    
                     <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜品质</label>
                       <div class="layui-input-block">
                            <select name="pinzhi" lay-verType="tips" lay-verify="required" required>
                                <option value="<%=pinzhi %>"><%=pinzhi %></option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜品相</label>
                       <div class="layui-input-block">
                            <select name="pinxiang" lay-verType="tips" lay-verify="required" required>
                                <option value="<%=pinxiang %>"><%=pinxiang %></option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">最少采购量</label>
                       <div class="layui-input-block">
                            <input name="minNumber" type="number" value="<%=minNumber %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜重量</label>
                       <div class="layui-input-block">
                            <input name="weight" type="number" value="<%=weight %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">库存量</label>
                       <div class="layui-input-block">
                            <input name="kucun" type="number" value="<%=kucun %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜产地</label>
                        <div class="layui-input-block">
                            <input name="addr" type="text" value="<%=addr %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    
                     <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">推荐状态</label>
                         <div class="layui-input-block">
                            <select name="tuijian" lay-verType="tips" lay-verify="required" required>
                                <option value="<%=tuijian %>"><%=tuijian %></option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">季节状态</label>
                         <div class="layui-input-block">
                            <select name="jijie" lay-verType="tips" lay-verify="required" required>
                                <option value="<%=jijie %>"><%=jijie %></option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜备注</label>
                        <div class="layui-input-block">
                            <input name="remark" type="text" value="<%=remark %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜保质期</label>
                        <div class="layui-input-block">
                            <select name="day" lay-verType="tips" lay-verify="required" required>
                                <option value="<%=day %>"><%=day %></option>
                            </select>
                        </div>
                    </div>
                     <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">上架状态</label>
                        <div class="layui-input-block">
                            <select name="up" lay-verType="tips" lay-verify="required" required>
                            <option value=""><%=stop == 0 ? "已上架" : "已下架" %></option>
                            </select>
                        </div>
                    </div>
                     <div class="layui-inline layui-col-md4">
                     	<label class="layui-form-label">蔬菜图片</label>
                        <div class="layui-input-block">
                            <input name="file" type="text" value="http://www.sumengkx.com/app/GreensShop/<%=tupian %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                     <div class="layui-form-item layui-form-text">
					    <label class="layui-form-label">蔬菜描述</label>
					    <div class="layui-input-block">
					      <textarea placeholder="<%=greensRemark %>" readonly="readonly" class="layui-textarea"></textarea>
					    </div>
				  </div>
                </div>
              </div>
             </div>
            </div>
        </div>
    </div>
</form>
<!-- js部分 -->
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

</body>

</html>