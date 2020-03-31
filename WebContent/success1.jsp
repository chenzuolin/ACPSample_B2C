<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="layui/css/layui.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买成功页面</title>
<style>
.nva{
 		position:relative;
 		width:100%;
 		height:5px;
 		background:rgb(0,150,136);
 	}
.list{
 		position:absolute;
 		top:0px;
 		left:0px;
 		width:5px;
 		height:100%;
 		background:rgb(0,150,136);
 	}

 	.item p{
 		font-size:20px;
 		text-align:center;
 		color:red;
 		margin-top:150px;
 	}
 	a{
 		text-decoration:none;
 		color:skyblue;
 		font-size:15px;
 	}
</style>
</head>
<body>

 
      

    <%
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	IndentDao dao2 = new IndentDao();
	Indent indent = new Indent();
	CartDao dao = new CartDao();
	int d = 0;
	WineshopDao dao3 = new WineshopDao();
	int cc = (Integer)request.getSession().getAttribute("id");//酒店编号
	List<Cart> list = dao.findUserByID(cc);//查看购物车
	for(Cart cart : list){
		int a1 = cart.getGreens_ID();
		int a3 = cart.getNumber();
		GreensDao dao11 = new GreensDao();
		List<Greens> list11 = dao11.findUserByID(a1);
		for(Greens greens1 : list11){
			int a2 = greens1.getGreens_Number();
			if(a3>a2){
				out.print("<script langage='javascript'>alert('库存不够了，请耐心等待，我们将尽快补货！！');window.location.href='UserControllerss'</script>");
			}else{
			}
		}
	}
				List<Wineshop> list2 = dao3.findUserByID(cc);//酒店信息
				   for(int j =0;j<list2.size();j++){
				
					   Float oo = (float)request.getSession().getAttribute("alltotal");//总价
						Float o1 = (float)request.getSession().getAttribute("total");//蔬菜价格
						Float o2 = (float)request.getSession().getAttribute("fare");//运费
						String Indent_remark = request.getSession().getAttribute("Indent_remark").toString();//订单备注
			indent.setIndent_Time(df.format(new Date()));
			indent.setIndent_Distribution_Time("");
			indent.setWineshop_ID(cc);
			indent.setWineshop_Address(list2.get(j).getWineshop_Address());
			indent.setIndent_Fare("");
			indent.setIndent_Check_Type("0");
			indent.setWineshop_Telephone(list2.get(j).getWineshop_Telephone());
			indent.setIndent_Status("正在处理");
			indent.setIndent_Type("周结记账(PC)");
			indent.setIndent_PayType("支付成功");
			indent.setIndent_remark(Indent_remark);
			indent.setIndent_TuiKuan("");
			indent.setIndent_Why("");
			indent.setIndent_PayID("");
			indent.setIndent_PayType("");
			dao2.add100(indent);//添加一条订单信息
			System.out.println("添加一条订单信息");
			d = dao2.findID();//刚刚生成的订单的编号
			System.out.println("刚刚生成的订单的编号");
			
			TotalDao dao5 = new TotalDao();
			Total total = new Total();
			total.setIndent_ID(d);
			total.setTotal(oo);
			total.setFare(o2);
			total.setGreens(o1);
			dao5.add(total);//添加一条价格信息
			FZDao dao7 = new FZDao();
			  FZ fz = new FZ();
			  fz.setIndent_ID(d);
			  fz.setCG_Name(null);
			  fz.setFJ_Name(null);
			  fz.setCourier_Name(null);
			  fz.setXD_Time(df.format(new Date()));
			  fz.setCG_Time(null);
			  fz.setFJ_Time(null);
			  fz.setPS_Time(null);
			  dao7.add(fz);
			 System.out.println("添加一条价格信息");
				   }
				
			
	
	
	int ccc = list.get(0).getCart_ID();
	
		
	GreensDao dao11 = new GreensDao();
	List<Cart> list01 = dao.findUserByID(cc);//查看购物车
	for(Cart cart : list01){
    request.getSession().setAttribute("d", d);
			int bb = cart.getNumber();
			String zz = cart.getRemark(); 
			List<Greens> list9 = dao11.findUserByID(cart.getGreens_ID());
			for(Greens greens : list9){
				String b1 = greens.getGreens_Name();
				String b2 = greens.getGreens_Unit();
				float greens_Price =greens.getGreens_Price();
			
            Order order = new Order();
            OrderDao dao4 = new OrderDao();
            order.setIndent_ID(d);
            order.setGreens_ID(cart.getGreens_ID());
            order.setNumber(cart.getNumber());
            order.setOrder_Requirement("");
            order.setIndent_Status("正在处理");
            order.setOrder_Remark(zz);
            order.setGreens_Name(b1);
            order.setGreens_Unit(b2);
            order.setIndent_Time(df.format(new Date()));
            order.setWineshop_ID(cc);
            order.setGreens_Price(greens_Price);
            dao4.add(order);//添加一条订单详细信息
       		System.out.println("添加一条订单详细信息");
			}
       		GreensDao dao1 = new GreensDao();
       		String bbb = dao1.findUserByID1(cart.getGreens_ID());
            TJDao dao21 = new TJDao();
            List<TJ> list21 = dao21.findAll();
        	List<String> lists1 = new ArrayList<String>();
            for(TJ tj : list21){
            	String aaa = tj.getTJ_Name();
            	lists1.add(aaa);
            }
            if(lists1.contains(bbb)){
            	
            }else{
            	TJ t = new TJ();
            	t.setTJ_Name(bbb);
            	t.setWineshop_ID(cc);
            	dao21.add(t);
            }
        	
			List<Greens> list1 = dao1.findUserByID(cart.getGreens_ID());
			for(Greens greens : list1) {
				int aa = greens.getGreens_Number();//蔬菜的中数量
				int dd = aa-bb;//之后的数量
				greens.setGreens_Number(dd);
	       		greens.setGreens_ID(cart.getGreens_ID());
	       		int aaa = dao1.update1(greens);//更新蔬菜数量
	       		
	       	 System.out.println("更新蔬菜数量");
		}
			
	}
		
			dao.delete1(cc);//删除购物车
			 System.out.println(cc);
			 System.out.println("删除购物车");
		

			

	
		
	
    %>
    <a class="layui-btn"  style="position:absolute;left:45%;top:50%;"  href="jiudianshouye.jsp">返回首页</a>
</body>
<script src="layui/layui.js"></script>
<script>
//一般直接写在一个js文件中
layui.use(['layer', 'form'], function(){
  var layer = layui.layer
  ,form = layui.form;
  
  layer.alert('购买成功，点击确认', 
  {
  skin: 'layui-layer-molv' //样式类名
  ,closeBtn: 0
  
  
},  
);
});
</script> 
</html>