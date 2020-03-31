<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sec.entity.*"%>
<%@ page import="com.sec.dao.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./layui/layui.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
       <title>酒店购物车</title>
<script src="https://cdn.bootcss.com/vue/2.5.17-beta.0/vue.js"></script>
<link href="https://cdn.bootcss.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="SuccessServlet" method="post">
    <div class="container" id="app">
        <div class="row" >
                <div class="panel panel-default">
            	  <div class="panel-heading" >
            			<h3 class="panel-title" style="color:#000; font-size:18px">购物车</h3>
            	  </div>
            	  <div class="panel-body">
            			<table class="table table-hover" style="background:white;">
            			
            					<tr >
            						
            						<th width="10%">商品编号</th>
                                    <th width="10%">商品名称</th>
            						<th width="10%">速盟单价</th>
            						<th width="10%">市场单价</th>
            						<th width="10%">节约金额</th>
            						<th width="10%">购买数量</th>
            						<th width="10%">商品单位</th>
            						<th width="10%">商品总价</th>
            						<th width="10%">功能操作</th>
            					</tr>
            				
                            <%
                            float total = 0;
                            float total1=0;
                            float ccc = 0;
                            float person = 0;
                            float gg = 0;
                            float person1 = 0;
                            CartDao dao = new CartDao();
                            int aa = (Integer)request.getSession().getAttribute("id");
                            List<Cart> list = dao.findUserByID(aa);
                            for(Cart cart : list){
                            	int bb = cart.getGreens_ID();
                            	GreensDao dao1 = new GreensDao();
                            	List<Greens> list1 = dao1.findUserByID(bb);
                            	for(Greens greens : list1){
                 					int id = cart.getCart_ID();
                            		String name = greens.getGreens_Name();//蔬菜名称
                            		String unit = greens.getGreens_Unit();//蔬菜单位
                            		float norm = Float.parseFloat(greens.getGreens_Norms());//蔬菜重量
                            		float price = greens.getGreens_Price();//蔬菜价格
                            		
                            		System.out.println("单价"+price);
                            		float dd = greens.getGreens_Market_Price();//蔬菜市场价
                            		float uu = dd-price;//节约金额
                            		int num = cart.getNumber();//加入购物车的数量
                            		System.out.println("数量"+num);
                            		float ee = num*norm;//小计重量
                            		float ff = (float)(Math.round(ee*100))/100;
                            		System.out.println("小计"+ff);
                            		gg += ff;
                            		System.out.println("总计"+gg);
                            		float money = price*num;//小计
                            		float num2 = (float)(Math.round(money*100))/100;//小计小数点后面保留一位
                            		
                            		total1 += num2;
                            		total = (float)(Math.round(total1*100))/100;
                            		ccc = price * num;
                            		float  num3 = (float)(Math.round(ccc*100))/100;//小计小数点后面保留一位
                            		person += num3;
                            		person1 = (float)(Math.round(person*100))/100;
                            	float	uuu = (float)(Math.round(uu*100))/100;
								 //float total=0;
									//for(int i=0;i<list1.size();i++){
										//Greens greens = list1.get(i);
										//int id = cart.getCart_ID();
										//String name = greens.getGreens_Name();
										//int num = cart.getNumber();
										//float price = greens.getGreens_Price();
										//float money  = greens.getGreens_Price()*cart.getNumber();
										//total+=money;
				%>
            				
                            
            					<tr>
            						
            						<td><input type="text" value="<%=id %>" name="Cart_ID" readonly="readonly" style="text-align:center; width:50px"></td>
            						<td><input type="text" value="<%=name %>" name="Greens_Name" readonly="readonly" style="text-align:center; width:60px"></td>
            						<td><input type="text" value="￥<%=price %>" name="Greens_Price" readonly="readonly" style="text-align:center; width:60px"></td>
            						<td><input type="text" value="￥<%=dd %>" name="" readonly="readonly" style="text-align:center; width:60px"></td>
            						<td><input type="text" value="￥<%=uuu %>" name="" readonly="readonly" style="text-align:center; width:60px"></td>
                                    <td><input type="text" value="<%=num %>" name="Greens_Number" readonly="readonly" style="text-align:center; width:60px"></td>
                                    <td><input type="text" value="<%=unit %>" name="" readonly="readonly" style="text-align:center; width:60px"></td>
                                    
                                    <td><input type="text" class="from-control inittextValue" readonly="readonly" value="￥<%=num2 %>" style="text-align:center; width:60px"></td>

                                    <td>
                                        <div class="btn-group btn-group-xs" style="text-align:centent;">
                                            <a href="CartDEServlet?id=<%=cart.getCart_ID() %>" class="btn btn-danger">删除</a>
                                        </div>
                                    </td>
            					</tr>
            				</tbody>
                            
                            
                            <%
					}
                            	}
                            
                            %>

            			</table>
            	  </div>
			 <%
			 	int a = Integer.parseInt(request.getParameter("fare"));
			 System.out.print("d"+gg);
			 	Fare_PriceDao daos = new Fare_PriceDao();
			 	List<Fare_Price> lists = daos.findAll();
			 	for(Fare_Price b : lists){
			 		float a1 = 0; 
			 		if(b.getBb()>=gg){//当实际斤数小于约定斤数时
			 			a1 = b.getAa();
			 		}else{
			 			System.out.print("hhhhhhhh");
			 		
			 			float a2 = gg-b.getBb();
			 			float a3 = a2/b.getFf();
			 			float a4 = a3*b.getGg();
			 			a1 = a4 + b.getAa();
			 			
			 		}
			 		System.out.print("c"+a1);
			 		if(b.getCc()>=a){//当实际路程小于约定路程时
			 			
			 		}else{
			 			float a5 = a-b.getCc();
			 			float a6 = a5/b.getDd();
			 			float a7 = a6*b.getEe();
			 			a1 = a1 + a7;
			 		}
            		float b1 = (float)(Math.round(a1*100))/100;//小计小数点后面保留一位
			 		float ss = b1 + total;
			 		%>
			 	<fieldset class="layui-elem-field">
            <legend>结账</legend>
            <div class="layui-field-box">
                <table class="layui-table">
                    <tbody>
                        <tr>
                            <th>应付金额</th>
                            <td><input name="" value="<%=person1 %>" readonly="readonly" style="border:none;"/></td></tr>
                        <tr>
                            <th>实付金额</th>
                            <td><input name="total" value="<%=total %>" readonly="readonly" style="border:none;"/></td></tr>
                        <tr>
                            <th>托运金额</th>
                            <td><input name="fare" value="<%=b1 %>" readonly="readonly" style="border:none;"/></td></tr>
                        <tr>
                            <th>总金额</th>
                            <td><input name="alltotal" value="<%=ss %>" readonly="readonly" style="border:none;"/></td></tr>
                           <tr>
                            <th>订单备注</th>
                            <td><input name="Indent_remark" type="text" style="width:300px; height:30px" ></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </fieldset>
			 		<%
			 	}
			 %>
			 
                    <div class="layui-input-block" style="float:right;">
				        <button class="layui-btn" id="btn" type="submit" style="width:121px;">立即购买</button>
      				</div>
                </div>
            </div>
        </div>
    </div>
  </form>
</body>
</html>

