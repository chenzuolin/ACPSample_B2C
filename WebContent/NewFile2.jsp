<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="java.util.List"%>
<%@ page import="com.sec.entity.*"%>
<%@ page import="com.sec.dao.GreensDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别</title>
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
<script type="text/javascript" src="./js/jquery-3.1.1.min.js"></script>
 <SCRIPT LANGUAGE="JavaScript">

    function sub(cc){
        var tds = cc.parentElement.parentElement.children;
        var td = (tds[0]).innerHTML ;
 
        var p = (tds[1]).innerHTML;
        
        var c = document.getElementsByName("number")[p].value;
        var l = document.getElementsByName("remark")[p].value;
        window.location.href="JoincartServlet?x="+td+"&v="+c+"&id="+l;
    }
</SCRIPT>

<link rel="stylesheet" href="css/basic.css" />
    <link href="css/demo.css" rel="stylesheet" type="text/css" />
    <link href="css/seastyle.css" rel="stylesheet" type="text/css" />
    <link href="./layui/css/layui.css" rel="stylesheet" media="all">
<style>
	.layui-input{
		width:450px;
		margin-left:120px;
	}
	.layui-btn{
		width:140px;
	}
	.nva{
		width:1000px;
		height:50px;
		margin:10px auto 0;
	}
	th{
		background:#5fb878; 
		color:#fff;
		font-size:10px;
		height:35px;
		line-height:35px;
	}
	td{
		height:35px;
		line-height:15px;
		padding:4px 0;
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
		padding-left:6px;
	}
</style>
</head>
<body>
<form action="SSServlet" class="layui-form layui-form-pane" method="get">
	 <div class="nva">
		<div class="layui-input-inline" style="padding-top:7px;">
			<input type="text" required name="s1" lay-verify="required" placeholder="请输入蔬菜名称" class="layui-input">
		</div>
		<div class="layui-input-inline" style="padding-top:7px;">
			<button type="submit" class="layui-btn" ><i class="layui-icon">&#xe615;</i>搜索</button>
		</div>
	</div>
</form>


<table  style="margin-top:20px;" class="layui-table">
      <tr>
      <th style="text-align:center; width:110px;" ><strong>编号</strong></th>
      <th style="display:none;width:110px; position:fixed;"">编号1</th>
      <th style="text-align:center; width:121px;"><strong>名称</strong></th>
      <th style="text-align:center;width:110px;"><strong>单位</strong></th>
      <th style="text-align:center;width:121px;" ><strong>单价</strong></th>
      <th style="text-align:center;width:121px;" ><strong>市场价</strong></th>
      <th style="text-align:center;width:121px;display:none;" ><strong>产地</strong></th>
      <th style="text-align:center;width:121px;" ><strong>保质期</strong></th>
      <th style="text-align:center;width:121px;" ><strong>品质</strong></th>
      <th style="text-align:center;width:121px;" ><strong>品相</strong></th>
      <th style="text-align:center;width:110px;" ><strong>最少购买</strong></th>
      <th style="text-align:center;width:121px;" ><strong>规格</strong></th>
      <th style="text-align:center;width:121px;" ><strong>库存量</strong></th>
      <th style="text-align:center;width:121px;" ><strong>产地</strong></th>
      <th style="text-align:center;width:121px;" ><strong>季节性</strong></th>
      <th style="text-align:center;width:121px;display:none;" ><strong>等级</strong></th>
      <th style="text-align:center;width:121px;" ><strong>推荐</strong></th>
      <th style="text-align:center;width:100px;" ><strong>备注</strong></th>
      <th style="text-align:center;width:100px;" ><strong>要求</strong></th>
      <th style="text-align:center;width:70px;" ><strong>数量</strong></th>
      <th style="text-align:center; width:180px;" ><strong>功能操作</strong></th>
      </tr>

 <% 
               //防止中文乱码
               request.setCharacterEncoding("UTF-8");
            
               GreensDao dao = new GreensDao(); 
               List<Greens> list = dao.findAll();
               for(Greens greens : list){
	           int yy = greens.getGreens_ID();
	                 
           %>   

    
       <tr>
      <td style="text-align:center;"><%=yy %></td>
      <td style="display:none;"><%=i %></td>
      <td style="text-align:center;width:125px;"><%=greens.getGreens_Name() %></td>
      <td style="text-align:center;"><%=greens.getGreens_Unit() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Price() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Market_Price() %></td>
	  <td style="text-align:center;display:none;"><%=greens.getGreens_Class() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Preiod() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Character() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Condition() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Minnumber() %><%=greens.getGreens_Norms() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Norms() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Number() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Class() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_characteristics() %></td>
	  <td style="text-align:center;display:none;"><%=greens.getGreens_Grade() %></td>
	  <td style="text-align:center;"><%=greens.getGreens_Recommend() %></td>
	  <td style="text-align:center;padding:4px 0px;line-height:26px;">
	  	<div style="margin-top:9px;">
	  		<input class="dd" readonly="readonly" value="<%=greens.getGreens_Remark() %>" style="width:70px;text-align:center;">
	  	</div>
	  </td>
 <td style="width:70px;text-align:center;padding:4px 0px;line-height:26px;">
	  	<div >
			<input type="text"  name="number" style="width:70px;text-align:center;" id="firstname" placeholder="蔬菜要求">
		</div>
	  </td>
	<td>
	<div style="text-align:center;padding:4px 0px;line-height:26px;"><input type="text" name="remark"></div></td>
	  
  <td><input type='button' name='cc' onclick="javascript:sub(this);" value="加入购物车"></td>
  <td><a href="cart1Srevlet?id=<%=greens.getGreens_ID() %>"style="color:red; font-family:'Trebuchet MS', Arial, Helvetica, sans-serif">查看蔬菜详情</a></td>
  <td><a href="cart2Servlet" style="color:red; font-family:'Trebuchet MS', Arial, Helvetica, sans-serif">查看购物车</a></td>
</tr>

    
      
             <%
             i++;
	               }
    %>   

   


</table>

</body>
</html>