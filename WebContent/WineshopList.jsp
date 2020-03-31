<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
        <%@page import="java.util.List"%>
<%@ page import="com.sec.entity.*"%>
<%@ page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别</title>

<%
	int i=0;
%>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>

 <script src="layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">


//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('form', function(){
  var form = layui.form;
  
  //…
});
</script>
<script src="js/jquery.js"></script>
 <SCRIPT LANGUAGE="JavaScript">

 function sub(cc){
     var tds = cc.parentElement.parentElement.children;
     var td = (tds[0]).innerHTML ;
     var p = (tds[1]).innerHTML;
     var c = document.getElementsByName("number")[p].value;
     var l = document.getElementsByName("remark")[p].value;//采购数量
     var num = 0;
     var xhr = new XMLHttpRequest();
		xhr.open('GET','http://www.sumengkx.com/ACPSample_B2C/GG1Servlet?id='+td);
		xhr.send(null);
		xhr.onreadystatechange = function(){
		if(this.readyState != 4) return;
			num = this.responseText;
			 if(l != null || l == "") {
			 }else{
		    	 alert('请输入蔬菜数量!');
		    	 window.location.reload();
		     }
			 
				 if(parseInt(l)<parseInt(num)){
		    		 alert("您购买的数量小于最少购买量");
		    	 }else{
		     	  $.ajax("http://www.sumengkx.com/ACPSample_B2C/JoincartServlet", {
							dataType: "text",
							type: "get", 
							data: {
								"x":td,
								"v":c,
								"id":l
							}, 
							//headers:{'Content-Type':'application/json'},
							success: function(data) {
									alert("添加成功!");
							},
							error: function(data){
								 alert('请输入蔬菜数量!');
								//plus.ui.toast(); 
								//return false;
							}
						});
		    	 }
		}
 }
</SCRIPT>




<link rel="stylesheet" href="css/basic.css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<link href="css/seastyle.css" rel="stylesheet" type="text/css" />
<link href="layui/css/layui.css" rel="stylesheet" media="all">
<style>
	.layui-input{
		width:200px;
		
	}
	.layui-btn{
		width:140px;
	}
	.nva{margin:5px auto;padding-left:100px;}
	th{
		background:rgb(238,238,238); 
		color:#000;
		font-size:10px;
		height:35px;
		line-height:35px;
	}
	td{
		height:35px;
		line-height:15px;
		padding:4px 0;
	}
	.dd{
		word-break:keep-all;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	a{
		padding-left:6px;
	}
</style>
</head>
<body>
<form name="form1" action="UserControllerss4" class="layui-form layui-form-pane" method="get">
	  <fieldset class="layui-elem-field">
            <legend style="font-size:15px;">蔬菜名称</legend>
				 <div class="nva">
				 	<label class="layui-btn" style="background:rgb(126,126,126); width:121px;">蔬菜名称</label>
					<div class="layui-input-inline" >
						<input type="text" required name="s1" lay-verify="required" placeholder="请输入蔬菜名称" class="layui-input">
					</div>
					<div class="layui-input-inline" style="padding-left:100px;">
						<button type="submit" class="layui-btn" ><i class="layui-icon">&#xe615;</i>搜索</button>
					</div>
					<div class="layui-input-inline" style="padding-left:100px;">
						<a class="layui-btn" href="CY.jsp">常用菜列表</a>
					</div>
				</div>
	</fieldset>
</form>
<form name="form1" action="UserControllerss1" class="layui-form layui-form-pane" method="get">
	 <fieldset class="layui-elem-field">
            <legend style="font-size:15px;">蔬菜类型</legend>
            	<div class="nva">
					<label class="layui-btn" style="background:rgb(126,126,126); width:121px; ">蔬菜类型</label>
					<div class="layui-input-inline">
						<select name="d" id="d" class="layui-input">
							<option value="全部">全部</option>
							<%
								Greens_TypeDao dao1 = new Greens_TypeDao();
								List<Greens_Type> list1 = dao1.findAll();
								for(Greens_Type greens_Type : list1){
								String zz = greens_Type.getGreens_Type_Name();
							%>
							<option  value="<%=zz %>"><%=zz %></option>
				       		
				       		<%
								}
							%>
		       			</select>
				 	</div>
				<div class="layui-input-inline" style="padding-left:100px;">
					<button  class="layui-btn" ><i class="layui-icon">&#xe615;</i>搜索</button>
				</div>
				<div class="layui-input-inline" style="padding-left:100px;">
					<a class="layui-btn" href="TJ.jsp">推荐菜列表</a>
				</div>
			</div>
	</fieldset>
</form>     <table  style="margin-top:20px;" class="layui-table">
      <tr>
      <th style="text-align:center; width:110px; display:none;"><strong>编号</strong></th>
      <th style="display:none;width:110px; position:fixed;">编号1</th>
      <th style="text-align:center; width:140px;"><strong>名称</strong></th>
      <th style="text-align:center;width:80px;"><strong>单位</strong></th>
      <th style="text-align:center;width:90px;" ><strong>单价</strong></th>
      <th style="text-align:center;width:100px;" ><strong>市场价</strong></th>
      <th style="text-align:center;width:121px;display:none;" ><strong>产地</strong></th>
      <th style="text-align:center;width:121px;" ><strong>保质期</strong></th>
      <th style="text-align:center;width:121px;" ><strong>品质</strong></th>
      <th style="text-align:center;width:121px;" ><strong>品相</strong></th>
      <th style="text-align:center;width:150px;" ><strong>最少购买</strong></th>
      <th style="text-align:center;width:121px;" ><strong>重量</strong></th>
      <th style="text-align:center;width:121px;" ><strong>库存</strong></th>
      <th style="text-align:center;width:121px;" ><strong>产地</strong></th>
      <th style="text-align:center;width:121px;" ><strong>季节性</strong></th>
      <th style="text-align:center;width:121px;display:none;" ><strong>等级</strong></th>
      <th style="text-align:center;width:121px;" ><strong>推荐</strong></th>
      <th style="text-align:center;width:100px;" ><strong>备注</strong></th>
      <th style="text-align:center;width:100px;" ><strong>要求</strong></th>
      <th style="text-align:center;width:70px;" ><strong>数量</strong></th>
      <th style="text-align:center; width:180px;" ><strong>功能操作</strong></th>
      </tr>

<c:forEach items="${page.showuser }" var="greens">
      <tr>
      <td style="text-align:center;display:none;">${greens.greens_ID }</td>
      <td style="display:none;"><%=i %></td>
      <td style="text-align:center;width:125px;">${greens.greens_Name }</td>
      <td style="text-align:center;">${greens.greens_Unit }</td>
	  <td style="text-align:center;">${greens.greens_Price }元</td>
	  <td style="text-align:center;">${greens.greens_Market_Price }元</td>
	  <td style="text-align:center;display:none;">${greens.greens_Class }</td>
	  <td style="text-align:center;">${greens.greens_Preiod }</td>
	  <td style="text-align:center;">${greens.greens_Character }</td>
	  <td style="text-align:center;">${greens.greens_Condition }</td>
	  <td style="text-align:center;">${greens.greens_Minnumber }${greens.greens_Unit }</td>
	  <td style="text-align:center;">${greens.greens_Norms }斤</td>
	  <td style="text-align:center;">${greens.greens_Number }</td>
	  <td style="text-align:center;">${greens.greens_Class }</td>
	  <td style="text-align:center;">${greens.greens_characteristics }</td>
	  <td style="text-align:center;display:none;">${greens.greens_Grade }</td>
	  <td style="text-align:center;">${greens.greens_Recommend }</td>
	  <td style="text-align:center;padding:4px 0px;line-height:26px;">
	  	${greens.greens_Remark }
	  </td>
	  <td style="width:70px;text-align:center;padding:4px 0px;line-height:26px;">
	  	<div >
			<input type="text"  name="number" style="width:70px;text-align:center;" id="firstname" placeholder="蔬菜要求">
		</div>
	  </td>
	  <td style="text-align:center;padding:4px 0px;line-height:26px;">
	  	 <div>
			<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" name="remark" style="width:70px;text-align:center;" id="remark" placeholder="蔬菜数量">
		</div>
	  </td>
	  
  <td style="text-align:center;padding:4px 0px;line-height:26px;width:130px;">
  	  <a href="cart2Servlet"  title="查看购物车"><i class="layui-icon">&#xe657;</i></a>
	  <a href="javascript:void(0)" name='cc' onclick="sub(this);" title="加入购物车"><i class="layui-icon">&#xe654;</i></a>
	  <a href="cart1Srevlet?id=${greens.greens_ID }"style="" title="查看蔬菜详情"><i class="layui-icon">&#xe642;</i></a>
	  <a href ="RR2?id1=${greens.greens_ID }"style="" title="添加到常用菜"><i class="layui-icon">&#xe61f;</i></a>
  </td>
</tr>

     <%
   	i++;
   %>
      
        </c:forEach>
  


</table>
<div style="margin-left:135px;margin-top:20px;">
	<c:choose>
		<c:when test="${page.currentPage==1}">
		上一页
		</c:when>
		<c:otherwise>
		
			<a href="UserControllerss?currentPage=${page.prevPage}" id="prevPage">上一页</a>
		</c:otherwise>
		</c:choose>
        <c:forEach items="${page.showPageNums}" var="pageNum">
            <a href="UserControllerss?currentPage=${pageNum}" id="pageNum">${pageNum}</a>
        </c:forEach>
        <a href="UserControllerss?currentPage=${page.nextPage}" id="nextPage">下一页</a>
	</div>

</body>
</html>