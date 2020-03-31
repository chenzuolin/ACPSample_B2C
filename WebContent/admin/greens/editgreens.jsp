<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@ page import="com.sumeng.service.*"%>
<%@ page import="com.sumeng.web.BigDao"%>
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
<form class="layui-form" id="tp"  method="post">
    <div class="layui-fluid" style="padding-bottom: 75px;">
        <div class="layui-card">
            <div class="layui-card-header">蔬菜属性</div>
            <div class="layui-card-body">

                <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜名称</label>
                        <div class="layui-input-block">
                            <input name="greensName" type="text" value="<%=name %>" id="greenName" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜大类</label>
                         <div class="layui-input-block">
                            <select name="bigTypeName" id="bigType" lay-verType="tips" lay-filter="bigType" >
                                <option value="<%=bigName %>"><%=bigName %></option>
                                 <%
                                	BigDao big = new BigDao();
                                	List<BigType> bigList = big.getFindAll();
                                	for(BigType bb : bigList){
                                		String bigMaxName = bb.getBigTypeName();
                                %>
                                <option value="<%=bigMaxName %>"><%=bigMaxName %></option>
                                <%
                                	}
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜小类</label>
                        <div class="layui-input-block"  >
                           <select name="typeName" id="typeName"  required>
                           	  <option value="<%=typeName %>"><%=typeName %></option>
                           	    <%
                           			Greens_TypeDao greenType = new Greens_TypeDao();
                           	  		List<Greens_Type> greenList = greenType.findAll();
                           	  		for(Greens_Type type : greenList){
                           	  			String bigMaxName = type.getGreens_BigTypeName();
                           	  			String typeOneName = type.getGreens_Type_Name();
                           	  %>
                           	   <optgroup label="<%=bigMaxName %>">
            						<option value="<%=typeOneName %>"><%=typeOneName %></option>
          					   </optgroup>
          					   <%
          					   		}
          					   %>
                           </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜单位</label>
                       <div class="layui-input-block">
                            <select name="unit" lay-verType="tips" id="unit" lay-verify="required" required>
                                <option value="<%=unit %>"><%=unit %></option>
                                 <%
                                	Greens_UnitDao unitOne = new Greens_UnitDao();
                                	List<Greens_Unit> unitList = unitOne.findAll();
                                	for(Greens_Unit uu : unitList){
                                		String unitname = uu.getGreens_Unit();
                                %>
                                <option value="<%=unitname %>"><%=unitname %></option>
                                <%
                                	}
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">速盟单价</label>
                          <div class="layui-input-block">
                            <input name="price" type="text" id="price" value="<%=price %>" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">市场单价</label>
                         <div class="layui-input-block">
                            <input name="markPrice" type="text" id="mPrice" value="<%=mPrice %>" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    
                     <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜品质</label>
                       <div class="layui-input-block">
                            <select name="pinzhi" lay-verType="tips" id="pinzhi" lay-verify="required" required>
                                <option value="<%=pinzhi %>"><%=pinzhi %></option>
                                 <%
                                Greens_CharacterDao charact = new Greens_CharacterDao();
                                List<Greens_Character> charList = charact.findAll();
                                for(Greens_Character cc : charList){
                                	String charName = cc.getGreens_Character();
                                %>
                                <option value="<%=charName %>"><%=charName %></option>
                                <%
                                	}
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜品相</label>
                       <div class="layui-input-block">
                            <select name="pinxiang" lay-verType="tips" id="pinxiang" lay-verify="required" required>
                                <option value="<%=pinxiang %>"><%=pinxiang %></option>
                                 <%
                                Greens_ConditionDao cond = new Greens_ConditionDao();
                                List<Greens_Condition> condList = cond.findAll();
                                for(Greens_Condition con : condList){
                                		String conName = con.getGreens_Condition();
                                %>
                                <option value="<%=conName %>"><%=conName %></option>
                                <%
                                	}
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">最少采购量</label>
                       <div class="layui-input-block">
                            <input name="minNumber" type="number" id="minNumber" value="<%=minNumber %>"  class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜重量</label>
                       <div class="layui-input-block">
                            <input name="weight" type="number" id="weight" value="<%=weight %>" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">库存量</label>
                       <div class="layui-input-block">
                            <input name="kucun" type="number" id="kucun" value="<%=kucun %>" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜产地</label>
                        <div class="layui-input-block">
                            <input name="addr" type="text" id="addr" value="<%=addr %>" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    
                     <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">推荐状态</label>
                         <div class="layui-input-block">
                            <select name="tuijian" lay-verType="tips" id="tuijian" lay-verify="required" required>
                                <option value="<%=tuijian %>"><%=tuijian %></option>
                                <option value="否">否</option>
                                 <option value="是">是</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">季节状态</label>
                         <div class="layui-input-block">
                            <select name="jijie" lay-verType="tips" id="jijie" lay-verify="required" required>
                                <option value="<%=jijie %>"><%=jijie %></option>
                                <option value="否">否</option>
                                 <option value="是">是</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜备注</label>
                        <div class="layui-input-block">
                            <input name="remark" type="text" id="remark" value="<%=remark %>" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜保质期</label>
                        <div class="layui-input-block">
                            <select name="day" lay-verType="tips" id="day" lay-verify="required" required>
                                <option value="<%=day %>"><%=day %></option>
                                 <option value="1日">一日</option>
                                <option value="2日">二日</option>
                                <option value="3日">三日</option>
                                <option value="1周">一周</option>
                                <option value="2周">二周</option>
                            </select>
                        </div>
                    </div>
                     <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">上架状态</label>
                        <div class="layui-input-block">
                            <select name="up" lay-verType="tips" id="up" lay-verify="required" required>
                            	<option value="<%=stop %>"><%=stop == 0 ? "已上架" : "已下架" %></option>
                                <option value="1">下架</option>
                                <option value="0">上架</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                     	<label class="layui-form-label">蔬菜ID</label>
                        <div class="layui-input-block">
                            <input name="id" type="text" id="gid" value="<%=gid %>" readonly="readonly" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-form-item layui-form-text">
					    <label class="layui-form-label">蔬菜描述</label>
					    <div class="layui-input-block">
					      <textarea placeholder="请输入商品描述" id="greensRemark" class="layui-textarea"><%=greensRemark %></textarea>
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
var callbackdata = function (){
	var greenName = document.getElementById("greenName").value;
	var bigType = document.getElementById("bigType").value;
	var typeName = document.getElementById("typeName").value;
	var unit = document.getElementById("unit").value;
	var price = document.getElementById("price").value;
	var mPrice = document.getElementById("mPrice").value;
	var pinzhi = document.getElementById("pinzhi").value;
	var pinxiiang = document.getElementById("pinxiang").value;
	var minNumber = document.getElementById("minNumber").value;
	var weight = document.getElementById("weight").value;
	var kucun = document.getElementById("kucun").value;
	var addr = document.getElementById("addr").value;
	var tuijian = document.getElementById("tuijian").value;
	var jijie = document.getElementById("jijie").value;
	var remark = document.getElementById("remark").value;
	var day = document.getElementById("day").value;
	var up = document.getElementById("up").value;
	var gid = document.getElementById("gid").value;
	var gRemark = document.getElementById("greensRemark").value;
	var data = {
			gname: greenName,
			gbigName: bigType,
			gTypeName: typeName,
			gUnit: unit,
			gPrice: price,
			gmPrice: mPrice,
			gpinzhi: pinzhi,
			gpinxiang: pinxiiang,
			gminNumber: minNumber,
			gweight: minNumber,
			gkucun: kucun,
			gaddr: addr,
			gtuijian: tuijian,
			gjijie: jijie,
			gremark: remark,
			gday: day,
			gup: up,
			gid: gid,
			gRemark:gRemark
	};
	return data;
}
</script>

</body>

</html>