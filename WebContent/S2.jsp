<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
        <%@page import="java.util.List"%>
<%@ page import="com.sec.entity.*"%>
<%@ page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别</title>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>

 
 <script src="layui/layui.js" charset="UTF-8"></script>
 <script type="text/javascript">


//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('form', function(){
  var form = layui.form;
});
</script>
<script type="text/javascript">

<script language="JavaScript" type="text/javascript">
function check(aaa)
{
if(aaa.num.value == "")
	{
alert("内容不能为空！");
return false;
}
else return true;
}
</script>
<%
	int i=0;
%>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
 <SCRIPT LANGUAGE="JavaScript">

 function sub(cc){
 	
 	
     var tds = cc.parentElement.parentElement.children;
     var td = (tds[0]).innerHTML ;
		
     var p = (tds[1]).innerHTML;
     
     var c = document.getElementsByName("number")[p].value;
     var l = document.getElementsByName("remark")[p].value;
     console.log(p);
     if(l == null || l == "") {
         alert('请输入蔬菜数量!'); 
     }else{
     window.location.href="JoincartServlet?x="+td+"&v="+c+"&id="+l;
     }
 }
</SCRIPT>
<script src="../js/jquery.js"></script>
<link rel="stylesheet" href="css/basic.css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<link href="css/seastyle.css" rel="stylesheet" type="text/css" />
<link href="layui/css/layui.css" rel="stylesheet" media="all">
<style>
	th{
		background:#5fb878; 
		color:#fff;
		font-size:10px;
		height:35px;
		line-height:35px;
	}
	td{
		height:35px;
		line-height:35px;
	}
	td:hover{
		background:skyblue;
	}
	.dd{
		word-break:keep-all;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	a{
		padding-left:4px;
	}
</style>
</head>
<body>
<form action="UserControllerss4" class="layui-form layui-form-pane" method="get">
	 <div class="nva">
	 		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px; ">蔬菜名称</label>
	 
		<div class="layui-input-inline">
			<input type="text" required name="s1" lay-verify="required" placeholder="请输入蔬菜名称" class="layui-input">
		</div>
		<div class="layui-input-inline" >
			<button type="submit" class="layui-btn" ><i class="layui-icon">&#xe615;</i>搜索</button>
		</div>
		</div>
		</form>
		
		
<form name="form1" action="UserControllerss1" class="layui-form layui-form-pane" method="get" style="margin-top: 15px;">
 <div class="nva">
	
	<%
		String hhh = request.getSession().getAttribute("aa").toString();
	%>
	
	
	
		<label class="layui-btn" style="background:rgb(126,126,126); width:121px; margin-left:84px; ">蔬菜类型</label>
		<div class="layui-input-inline" style="width: 182px;">
			<select name="d" id="d" class="layui-input">
			<option value="<%=hhh %>"><%=hhh %></option>
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
		<div class="layui-input-inline" >
			<button type="submit" class="layui-btn" ><i class="layui-icon">&#xe615;</i>搜索</button>
		</div>
	</div>

</form>
      <table style="margin-top:20px;" class="layui-table">
      <tr>
      
      <th style="text-align:center; width:110px;"><strong>编号</strong></th>
      <th style="display:none;"><strong>编号1</strong></th>
      <th style="text-align:center; width:121px;"><strong>名称</strong></th>
      <th style="text-align:center; width:121px;"><strong>单位</strong></th>
      <th style="text-align:center; width:121px;"><strong>单价</strong></th>
      <th style="text-align:center; width:121px;"><strong>市场价</strong></th>
      <th style="text-align:center;width:121px;display:none;"><strong>产地</strong></th>
      <th style="text-align:center; width:121px;"><strong>保质期</strong></th>
      <th style="text-align:center; width:121px;"><strong>品质</strong></th>
      <th style="text-align:center; width:121px;"><strong>品相</strong></th>
      <th style="text-align:center; width:121px;"><strong>最少购买</strong></th>
      <th style="text-align:center; width:121px;"><strong>重量</strong></th>
      <th style="text-align:center; width:121px;"><strong>库存量</strong></th>
      <th style="text-align:center; width:121px;"><strong>产地</strong></th>
      <th style="text-align:center; width:121px;"><strong>季节性</strong></th>
      <th style="text-align:center;width:121px;display:none;"><strong>等级</strong></th>
      <th style="text-align:center; width:121px;"><strong>推荐</strong></th>
      <th style="text-align:center; width:100px;"><strong>备注</strong></th>
      <th style="text-align:center; width:100px;"><strong>要求</strong></th>
      <th style="text-align:center; width:70px;"><strong>数量</strong></th>
      <th style="text-align:center; width:220px;"><strong>功能操作</strong></th>
      </tr>

<c:forEach items="${page.showuser }" var="greens">
      <tr>
      <td style="text-align:center;">${greens.greens_ID }</td>
      <td style="display:none;"><%=i %></td>
      <td style="text-align:center;width:125px;">${greens.greens_Name }</td>
      <td style="text-align:center;">${greens.greens_Unit }</td>
	  <td style="text-align:center;">${greens.greens_Price }</td>
	  <td style="text-align:center;">${greens.greens_Market_Price }</td>
	  <td style="text-align:center;display:none;">${greens.greens_Class }</td>
	  <td style="text-align:center;">${greens.greens_Preiod }</td>
	  <td style="text-align:center;">${greens.greens_Character }</td>
	  <td style="text-align:center;">${greens.greens_Condition }</td>
	  <td style="text-align:center;">${greens.greens_Minnumber }${greens.greens_Norms }</td>
	  <td style="text-align:center;">${greens.greens_Norms }斤</td>
	  <td style="text-align:center;">${greens.greens_Number }</td>
	  <td style="text-align:center;">${greens.greens_Class }</td>
	  <td style="text-align:center;">${greens.greens_characteristics }</td>
	  <td style="text-align:center;display:none;">${greens.greens_Grade }</td>
	  <td style="text-align:center;">${greens.greens_Recommend }</td>
	  <td style="text-align:center;padding:4px 0px;line-height:26px;">
	  	<div style="margin-top:9px;">
	  		<input class="dd" readonly="readonly" value="${greens.greens_Remark }" style="width:70px;text-align:center;">
	  	</div>
	  </td>
	  <td style="width:70px;text-align:center;padding:4px 0px;line-height:26px;">
	  	<div >
			<input type="text"  name="number" style="width:70px;text-align:center;" id="firstname" placeholder="蔬菜要求">
		</div>
	  </td>
	  <td style="text-align:center;padding:4px 0px;line-height:26px;">
	  	 <div>
			<input type="text"  name="remark" style="width:70px;text-align:center;" id="remark" placeholder="蔬菜数量">
		</div>
	  </td>
	  
  <td style="text-align:center;padding:4px 0px;line-height:26px;width:130px;">
  	  <a href="cart2Servlet"  title="查看购物车"><i class="layui-icon">&#xe657;</i></a>
	  <a href="javascript:void(0)" name='cc' onclick="sub(this);" title="加入购物车"><i class="layui-icon">&#xe654;</i></a>
	  <a href="cart1Srevlet?id=${greens.greens_ID }"style="" title="查看蔬菜详情"><i class="layui-icon">&#xe642;</i></a>
	  
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
		
			<a href="UserControllerss2?currentPage=${page.prevPage}&d=<%=hhh %>" id="prevPage">上一页</a>
		</c:otherwise>
		</c:choose>
        <c:forEach items="${page.showPageNums}" var="pageNum">
            <a href="UserControllerss2?currentPage=${pageNum}" id="pageNum">${pageNum}</a>
        </c:forEach>
        <a href="UserControllerss2?currentPage=${page.nextPage}&d=<%=hhh %>" id="nextPage">下一页</a>
	</div>



</body>
</html>