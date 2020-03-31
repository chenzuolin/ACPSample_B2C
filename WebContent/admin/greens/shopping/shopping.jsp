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
                            <input name="greensName" type="text" placeholder="请勿输入特殊字符" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜大类</label>
                         <div class="layui-input-block">
                            <select name="bigTypeName" id="bigType" lay-verType="tips" lay-filter="bigType" >
                                <option value="">请选择蔬菜大类</option>
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
                    <div class="layui-inline layui-col-md4">
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
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜单位</label>
                       <div class="layui-input-block">
                            <select name="unit" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择蔬菜单位</option>
                                <%
                                	Greens_UnitDao unit = new Greens_UnitDao();
                                	List<Greens_Unit> unitList = unit.findAll();
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
                            <input name="price" type="text" placeholder="请输入速盟单价" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">市场单价</label>
                         <div class="layui-input-block">
                            <input name="markPrice" type="text" placeholder="请输入市场单价" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    
                     <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜品质</label>
                       <div class="layui-input-block">
                            <select name="pinzhi" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择蔬菜品质</option>
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
                            <select name="pinxiang" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择蔬菜品相</option>
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
                            <input name="minNumber" type="number" placeholder="请输入最少采购量" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜重量</label>
                       <div class="layui-input-block">
                            <input name="weight" type="number" placeholder="请输入蔬菜重量(斤)" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">库存量</label>
                       <div class="layui-input-block">
                            <input name="kucun" type="number" placeholder="请输入蔬菜库存量" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜产地</label>
                        <div class="layui-input-block">
                            <input name="addr" type="text" placeholder="请输入蔬菜产地" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    
                     <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">推荐状态</label>
                         <div class="layui-input-block">
                            <select name="tuijian" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择推荐状态</option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">季节状态</label>
                         <div class="layui-input-block">
                            <select name="jijie" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择季节状态</option>
                                <option value="是">是</option>
                                <option value="否">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜备注</label>
                        <div class="layui-input-block">
                            <input name="remark" type="text" placeholder="请输入蔬菜备注" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜保质期</label>
                        <div class="layui-input-block">
                            <select name="day" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择保质期天数</option>
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
                            <select name="up" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择上架状态</option>
                                <option value="0">是</option>
                                <option value="1">否</option>
                            </select>
                        </div>
                    </div>
                     <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">蔬菜图片</label>
                      	<input type="file" name="file" />
                    </div>
                    
                </div>
              </div>
             </div>
            </div>
        </div>
    </div>

    <div class="form-group-bottom text-right">
        <button type="reset" class="layui-btn layui-btn-primary">&emsp;重置&emsp;</button>
        <button class="layui-btn" lay-filter="" id="btn" lay-submit>&emsp;提交&emsp;</button>
    </div>

</form>
<!-- js部分 -->
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$("#btn").click(function(){
	var from = new FormData(document.getElementById("tp"));
	var code;
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/Shopping",
		data:from,
		async : false,
		processData:false,
        contentType:false,
        success:function(data){
        	code = data;
        }
	});
	if(code == 200){
		alert("添加成功了哦！！");
	}else{
		alert("添加失败了哦！！");
	}
	
})
</script>
</body>

</html>