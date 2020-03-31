<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@page import="java.util.List"%>
<%@ page import="com.sec.entity.*"%>
<%@ page import="com.sec.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
 <SCRIPT LANGUAGE="JavaScript">

 function sub(cc){
     var tds = cc.parentElement.parentElement.children;
     var td = (tds[0]).innerHTML ;
     var p = (tds[1]).innerHTML;
     var c = document.getElementsByName("number")[p].value;
     var l = document.getElementsByName("remark")[p].value;//采购数量
     var num = 0;
     var xhr = new XMLHttpRequest();
		xhr.open('GET','http://211.149.232.210/ACPSample_B2C/GG1Servlet?id='+td);
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
		     	  $.ajax("http://211.149.232.210/ACPSample_B2C/JoincartServlet", {
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

<script src="js/jquery.js"></script>


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
	

     <table  style="margin-top:20px;" class="layui-table">
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
<%
int aa = (Integer)request.getSession().getAttribute("id");
		GreensDao dao = new GreensDao();
		List<Greens> list1 = dao.findAll1();
		   
		List<Greens> list3 = dao.sortIntMethod(list1);
		for(Greens greens : list3){
			int dd = greens.getGreens_ID();
			String ee = greens.getGreens_Name();
			String ff = greens.getGreens_Unit();
			float gg = greens.getGreens_Price();
			float hh = greens.getGreens_Market_Price();
			String ii = greens.getGreens_Class();
			String jj = greens.getGreens_Preiod();
			String kk = greens.getGreens_Character();
			String ll = greens.getGreens_Condition();
			int mm = greens.getGreens_Minnumber();
			String nn = greens.getGreens_Norms();
			int oo = greens.getGreens_Number();
			String pp = greens.getGreens_Class();
			String qq = greens.getGreens_characteristics();
			int rr = greens.getGreens_Grade();
			String ss = greens.getGreens_Recommend();
			String tt = greens.getGreens_Remark();
		
				
			
	%>
      <tr>
      <td style="text-align:center;display:none;"><%=dd %></td>
      <td style="display:none;"><%=i %></td>
      <td style="text-align:center;width:125px;"><%=ee %></td>
      <td style="text-align:center;"><%=ff %></td>
	  <td style="text-align:center;"><%=gg %>元</td>
	  <td style="text-align:center;"><%=hh %>元</td>
	  <td style="text-align:center;display:none;"><%=ii %></td>
	  <td style="text-align:center;"><%=jj %></td>
	  <td style="text-align:center;"><%=kk %></td>
	  <td style="text-align:center;"><%=ll %></td>
	  <td style="text-align:center;"><%=mm %><%=ff %></td>
	  <td style="text-align:center;"><%=nn %>斤</td>
	  <td style="text-align:center;"><%=oo %></td>
	  <td style="text-align:center;"><%=pp %></td>
	  <td style="text-align:center;"><%=qq %></td>
	  <td style="text-align:center;display:none;"><%=rr %></td>
	  <td style="text-align:center;"><%=ss %></td>
	  <td style="text-align:center;padding:4px 0px;line-height:26px;">
	  	<div style="margin-top:9px;">
	  		<input class="dd" lay-verify="required" readonly="readonly" value="<%=tt %>" style="width:70px;text-align:center;boeder:none;">
	  	</div>
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
	  <a href="cart1Srevlet?id=<%=dd %>"style="" title="查看蔬菜详情"><i class="layui-icon">&#xe642;</i></a>
	  <a href ="RR2?id1=<%=dd %>"style="" title="添加到常用菜"><i class="layui-icon">&#xe61f;</i></a>
  </td>
</tr>

     <%
   	i++;
			}
		
   %>
      
  


</table>


</body>
</html>

</body>
</html>