<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cn.itsource.pay.servlet.AlipayConfigs"%>
<%@ page import="java.util.*"%>
<%@ page import="com.alipay.api.*"%>
<%@ page import="com.sec.entity.*" %>
<%@ page import="com.alipay.api.request.*"%>
<%@ page import="com.sec.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<%


	int Wineshop_ID = (Integer)request.getSession().getAttribute("id");//酒店ID
	WineshopDao dao = new WineshopDao();
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//int Wineshop_ID = 200;
	String Wineshop_Name = dao.findUserByID1(Wineshop_ID);//酒店名称

	Float total = (float)request.getSession().getAttribute("alltotal");//总价
	Float Greens_Price =(float)request.getSession().getAttribute("total");//蔬菜价格
	Float Fare = (float)request.getSession().getAttribute("fare");//运费
	String Indent_remark = request.getSession().getAttribute("Indent_remark").toString();//订单备注
	
	
			

	AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfigs.gatewayUrl, AlipayConfigs.app_id, AlipayConfigs.merchant_private_key, "json", AlipayConfigs.charset, AlipayConfigs.alipay_public_key, AlipayConfigs.sign_type);

	//设置请求参数
	AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	alipayRequest.setReturnUrl(AlipayConfigs.return_url);
	alipayRequest.setNotifyUrl(AlipayConfigs.notify_url);
	String orderSn = df.format(Calendar.getInstance().getTime());
	//商户订单号，商户网站订单系统中唯一订单号，必填
	String out_trade_no = orderSn + "";
	//付款金额，必填
	String total_amount = total + "";
	//订单名称，必填
	String subject = Wineshop_Name;
	//商品描述，可空
	String body = Wineshop_Name+"(PC端支付)" ;
	int number1 = 0;
	List<Wineshop> list4 = dao.findUserByID(Wineshop_ID);
    for(Wineshop wineshop : list4){
	String wineshop_Address = wineshop.getWineshop_Address();
	String wineshop_Telephone = wineshop.getWineshop_Telephone();
	IndentDao dao3 = new IndentDao();
	Indent indent = new Indent();
	indent.setIndent_Time(df1.format(new Date()));
	indent.setIndent_Distribution_Time("");
	indent.setWineshop_ID(Wineshop_ID);
	indent.setWineshop_Address(wineshop_Address);
	indent.setIndent_Fare("");
	indent.setIndent_Check_Type("");
	indent.setWineshop_Telephone(wineshop_Telephone);
	indent.setIndent_Status("正在支付");
	indent.setIndent_Type("支付宝支付(PC)");
	indent.setIndent_remark(Indent_remark);
	indent.setIndent_TuiKuan("");
	indent.setIndent_Why("");
	indent.setIndent_PayID(out_trade_no);
	indent.setIndent_PayType("预支付");
	dao3.add100(indent);
	int Indent_ID = dao3.findID(Wineshop_ID);
	TotalDao dao5 = new TotalDao();
	Total total1 = new Total();
	total1.setIndent_ID(Indent_ID);
	total1.setTotal(total);
	total1.setFare(Fare);
	total1.setGreens(Greens_Price);
	dao5.add(total1);
	FZDao dao7 = new FZDao();
	FZ fz = new FZ();
	fz.setIndent_ID(Indent_ID);
	fz.setCG_Name(null);
	fz.setFJ_Name(null);
	fz.setCourier_Name(null);
	fz.setXD_Time(df.format(new Date()));
	fz.setCG_Time(null);
	fz.setFJ_Time(null);
	fz.setPS_Time(null);
	dao7.add(fz);
	  
	GreensDao dao10 = new GreensDao();
	CartDao dao11 = new CartDao();
	int cart_ID = 0;
	List<Cart> list11 = dao11.findUserByID(Wineshop_ID);
	for(Cart cart : list11){
		  cart_ID = cart.getCart_ID();
		  int greens_ID = cart.getGreens_ID();
		  int number = cart.getNumber();
		  String order_Remark = cart.getRemark();
		  List<Greens> list10 = dao10.findUserByID(greens_ID);
		  for(Greens greens :list10){
			  String greens_Name = greens.getGreens_Name();
			  String greens_Unit = greens.getGreens_Unit();
			  
	 Order order = new Order();
	 OrderDao dao9 = new OrderDao(); 
	 order.setIndent_ID(Indent_ID);
	 order.setGreens_ID(greens_ID);
	 order.setNumber(number);
	 order.setOrder_Requirement("");
	 order.setIndent_Status("正在处理");
	 order.setOrder_Remark(order_Remark);
	 order.setGreens_Name(greens_Name);
	 order.setGreens_Unit(greens_Unit);
	 order.setIndent_Time(df.format(new Date()));
	 order.setWineshop_ID(Wineshop_ID);
	 dao9.add(order);
	 
	 
	  }
		List<Greens> list12 = dao10.findUserByID(greens_ID);
		System.out.println("list12="+list12);
		for(Greens green : list12){
			int Number = number1-number;
			green.setGreens_Number(Number);
			green.setGreens_ID(greens_ID);
			dao10.update1(green);
		}
	  }  
	  
		//dao11.delete1(Wineshop_ID);
	  }
	
	alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
		+ "\"total_amount\":\""+ total_amount +"\"," 
		+ "\"subject\":\""+ subject +"\"," 
		+ "\"body\":\""+ body +"\"," 
		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

	//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
	//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
	//		+ "\"total_amount\":\""+ total_amount +"\"," 
	//		+ "\"subject\":\""+ subject +"\"," 
	//		+ "\"body\":\""+ body +"\"," 
	//		+ "\"timeout_express\":\"10m\"," 
	//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
	//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

	//请求
	String result = "";
	try {
	result = alipayClient.pageExecute(alipayRequest).getBody();
	} catch (AlipayApiException e) {
	// TODO 自动生成的 catch 块
	e.printStackTrace();
	}

	//输出
	out.print(result);
	%>
</body>
</html>