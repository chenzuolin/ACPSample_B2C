package WeiXin;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.sec.dao.CartDao;
import com.sec.dao.CouponDao;
import com.sec.dao.FZDao;
import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.PointDao;
import com.sec.dao.RedDao;
import com.sec.dao.TotalDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.FZ;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.Point;
import com.sec.entity.Red;
import com.sec.entity.Total;
import com.sec.entity.Wineshop;

/*
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
*/
/**
 * Servlet implementation class WinxinPay
 */
@WebServlet("/WinxinPay")
public class WinxinPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WinxinPay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//    private WxPayService wxPayService;
	public void doPost(HttpServletRequest request2, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		request2.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		int yyy = Integer.parseInt(request2.getParameter("yyy"));//red_ID
		RedDao daoa = new RedDao();
		String op = daoa.find(yyy);
		if(op==null){
			
			float zzz = 0;
			if(request2.getParameter("zzz")==null){
				
			}else{
				 zzz = Float.parseFloat(request2.getParameter("zzz"));//充值活动额度
			}
			int xxx = Integer.parseInt(request2.getParameter("xxx"));//优惠券面值
			
			float a = Float.parseFloat(request2.getParameter("total"));//总价
			System.out.println(a);
			int b = (int) (Float.valueOf(a)*100);
				String total_fee = b+"" ;
				
				float Greens_Price = Float.parseFloat(request2.getParameter("SC"));//蔬菜价格
				String Indent_Remark = request2.getParameter("Indent_Remark");//订单备注
				float Fare = Float.parseFloat(request2.getParameter("Fare"));//运费
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				String name = request2.getParameter("Wineshop_Name");
				
				String body = "蔬菜购买微信支付系统";  //商品描述
				String mch_id = "1528336491"; //微信支付商户号 
				String currTime = getCurrTime();
				String strTime = currTime.substring(8, currTime.length());
				String strRandom = buildRandom(4) + "";
				String nonce_str = strTime + strRandom;
				String notify_url = "http://www.sumengkx.com/ACPSample_B2C/NoServlet";// 回调地址 必须能直接访问 不是二级域名也可以
				String out_trade_no = String.valueOf(UUID.next()); // 订单号
				String timestamp = getTimeStamp();
				SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
				packageParams.put("appid", "wx7b0f2a75b9edb92b");  // 微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
				packageParams.put("mch_id", mch_id);
				packageParams.put("nonce_str", nonce_str);
				packageParams.put("body", body);//商品标题
				packageParams.put("out_trade_no", out_trade_no);// 商户订单号
				packageParams.put("total_fee", total_fee);// 总金额
				String addr = "192.168.1.105";
				packageParams.put("spbill_create_ip", addr);// 发起人IP地址
				packageParams.put("notify_url", notify_url);// 回调地址
				packageParams.put("trade_type", "APP");// 交易类型
				packageParams.put("time_start", timestamp);
				String sign = createSign("UTF-8", packageParams, "d2fp6ugtfgp45wr453u6kvcibrdnq69a"); //应用对应的密钥
				packageParams.put("sign", sign);// 签名
				String requestXML = getRequestXml(packageParams);
				String resXml = postData("https://api.mch.weixin.qq.com/pay/unifiedorder", requestXML);
				Map map;
				try {
					map = doXMLParse(resXml);
					String returnCode = (String) map.get("return_code");
					String returnMsg = (String) map.get("return_msg");
					if ("SUCCESS".equals(returnCode)) {
						String resultCode = (String) map.get("result_code");
						String prepay_id = (String) map.get("prepay_id");
						String noncestr = (String) map.get("nonce_str");
						if ("SUCCESS".equals(resultCode)) {
						
							System.out.println("name="+name);
							WineshopDao dao1 = new WineshopDao();
							int Wineshop_ID = dao1.findUserByID2(name);
							System.out.println("Wineshop_id="+Wineshop_ID);
							int number1 = 0;
							
							/*CouponDao da = new CouponDao();
							int asd = da.find(xxx);
							RedDao daoss = new RedDao();
							Red r = new Red();
							r.setRed_Status("预使用");
							r.setWineshop_ID(Wineshop_ID);
							r.setCoupon_ID(asd);
							daoss.updatefinish(r);
							int ad = daoss.findNumberss(asd);*/
							
							List<Wineshop> list4 = dao1.findUserByID(Wineshop_ID);
							for(Wineshop wineshop : list4){
								String wineshop_Address = wineshop.getWineshop_Address();
								String wineshop_Telephone = wineshop.getWineshop_Telephone();
								String QY = wineshop.getWineshop_QY();
							IndentDao dao3 = new IndentDao();
							Indent indent = new Indent();
							indent.setIndent_Time(df.format(new Date()));
							indent.setIndent_Distribution_Time("");
							indent.setWineshop_ID(Wineshop_ID);
							indent.setWineshop_Address(wineshop_Address);
							indent.setIndent_Fare("");   
							indent.setIndent_Check_Type("");
							indent.setWineshop_Telephone(wineshop_Telephone);
							indent.setIndent_Status("正在支付");
							indent.setIndent_Type("微信支付");
							indent.setIndent_remark(Indent_Remark);
							indent.setIndent_TuiKuan("");
							indent.setIndent_Why("");
							indent.setIndent_PayID(out_trade_no);
							indent.setIndent_PayType("预支付");
							indent.setIndent_QY(QY);
							
							indent.setIndent_ZZZ(zzz);
							/*indent.setIndent_XXX("使用" + xxx + "元优惠卷");
							indent.setIndent_Coupon(asd);
							indent.setIndent_Red(ad);
							dao3.add1000(indent);*/
							dao3.add100(indent);
							PointDao daos = new PointDao();
							Point p = new Point();
							int as = daos.count(Wineshop_ID);
							if(as==0){
								p.setWineshop_ID(Wineshop_ID);
								p.setPoint_num(0);
								p.setPoint_last((int)(a));
								p.setPoint_Status("预支付");
								daos.add(p);
							}else{
								p.setPoint_last((int)(a));
								p.setPoint_Status("预支付");
								p.setWineshop_ID(Wineshop_ID);
								daos.updatefinishes(p);
							}
							
							
							  int Indent_ID = dao3.findID(Wineshop_ID);
							  
							  
				 				
				 			
							  TotalDao dao5 = new TotalDao();
							  Total total = new Total();
							  total.setIndent_ID(Indent_ID);
							  total.setTotal(a);
							  total.setFare(Fare);
							  total.setGreens(Greens_Price);
							  total.setTotal_QY(QY);
							  dao5.add(total);
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
									  float greens_price = greens.getGreens_Price();
									  String Greens_Type_Name = greens.getGreens_Type_Name();
									  
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
							 order.setGreens_Price(greens_price);
							 order.setGreens_BiaoJi(0);
							 order.setGreens_Type_Name(Greens_Type_Name);
							 dao9.add(order);
							 
							 
							  }
								List<Greens> list12 = dao10.findUserByID(greens_ID);
								/*System.out.println("list12="+list12);
								for(Greens green : list12){
									int Number = number1-number;
									green.setGreens_Number(Number);
									green.setGreens_ID(greens_ID);
									dao10.update1(green);
								}*/
							  }  
							  
							  }
							 
							SortedMap<Object, Object> packageParam = new TreeMap<Object, Object>();
							packageParam.put("appid", "wx7b0f2a75b9edb92b"); //微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
							packageParam.put("partnerid", mch_id);
							packageParam.put("prepayid", prepay_id);// 商品描述
							packageParam.put("package", "Sign=WXPay");// 商户订单号
							packageParam.put("noncestr", noncestr);
							packageParam.put("timestamp", timestamp);
							String sign1 = createSign("UTF-8", packageParam, "d2fp6ugtfgp45wr453u6kvcibrdnq69a");// 这里是二次签名    //应用对应的密钥
							// 处理交易订单信息 // 前台要拿到去调起微信支付，如果这个错了的话会在前台报签名错误
							Map<String, Object> jsonMap = new TreeMap<String, Object>();
							jsonMap.put("appid", "wx7b0f2a75b9edb92b");//微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
							jsonMap.put("noncestr", noncestr);
							jsonMap.put("package", "Sign=WXPay");
							jsonMap.put("partnerid", mch_id);
							jsonMap.put("prepayid", prepay_id);
							jsonMap.put("timestamp", timestamp);
							jsonMap.put("sign", sign1);
							System.out.println("jsonMap==="+jsonMap);
							JSONArray json = JSONArray.fromObject(jsonMap);
							PrintWriter out = response.getWriter();
							out.print(json);
							out.flush();
							out.close();
//							jsonBack = new JsonBack(true, "success", jsonMap);
						}
					}
				} catch (JDOMException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
//				return jsonBack;
		
			
		}else{
		if(op.contains("优惠券")){
		int xxx = Integer.parseInt(request2.getParameter("xxx"));
		float zzz = 0;
		if(request2.getParameter("zzz")==null){
			
		}else{
			 zzz = Float.parseFloat(request2.getParameter("zzz"));
		}
		float a = Float.parseFloat(request2.getParameter("total"));
		System.out.println(a);
		int b = (int) (Float.valueOf(a)*100);
			String total_fee = b+"" ;
			
			float Greens_Price = Float.parseFloat(request2.getParameter("SC"));
			String Indent_Remark = request2.getParameter("Indent_Remark");
			float Fare = Float.parseFloat(request2.getParameter("Fare"));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String name = request2.getParameter("Wineshop_Name");
			
			String body = "蔬菜购买微信支付系统";  //商品描述
			String mch_id = "1528336491"; //微信支付商户号 
			String currTime = getCurrTime();
			String strTime = currTime.substring(8, currTime.length());
			String strRandom = buildRandom(4) + "";
			String nonce_str = strTime + strRandom;
			String notify_url = "http://www.sumengkx.com/ACPSample_B2C/NoServlet";// 回调地址 必须能直接访问 不是二级域名也可以
			String out_trade_no = String.valueOf(UUID.next()); // 订单号
			String timestamp = getTimeStamp();
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			packageParams.put("appid", "wx7b0f2a75b9edb92b");  // 微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
			packageParams.put("mch_id", mch_id);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("body", body);//商品标题
			packageParams.put("out_trade_no", out_trade_no);// 商户订单号
			packageParams.put("total_fee", total_fee);// 总金额
			String addr = "192.168.1.105";
			packageParams.put("spbill_create_ip", addr);// 发起人IP地址
			packageParams.put("notify_url", notify_url);// 回调地址
			packageParams.put("trade_type", "APP");// 交易类型
			packageParams.put("time_start", timestamp);
			String sign = createSign("UTF-8", packageParams, "d2fp6ugtfgp45wr453u6kvcibrdnq69a"); //应用对应的密钥
			packageParams.put("sign", sign);// 签名
			String requestXML = getRequestXml(packageParams);
			String resXml = postData("https://api.mch.weixin.qq.com/pay/unifiedorder", requestXML);
			Map map;
			try {
				map = doXMLParse(resXml);
				String returnCode = (String) map.get("return_code");
				String returnMsg = (String) map.get("return_msg");
				if ("SUCCESS".equals(returnCode)) {
					String resultCode = (String) map.get("result_code");
					String prepay_id = (String) map.get("prepay_id");
					String noncestr = (String) map.get("nonce_str");
					if ("SUCCESS".equals(resultCode)) {
					
						System.out.println("name="+name);
						WineshopDao dao1 = new WineshopDao();
						int Wineshop_ID = dao1.findUserByID2(name);
						System.out.println("Wineshop_id="+Wineshop_ID);
						int number1 = 0;
						
						CouponDao da = new CouponDao();
						int asd = da.find(xxx);
						RedDao daoss = new RedDao();
						Red r = new Red();
						r.setRed_Status("预使用");
						r.setWineshop_ID(Wineshop_ID);
						r.setCoupon_ID(asd);
						daoss.updatefinish(r);
						int ad = daoss.findNumberss(asd);
						
						List<Wineshop> list4 = dao1.findUserByID(Wineshop_ID);
						for(Wineshop wineshop : list4){
							String wineshop_Address = wineshop.getWineshop_Address();
							String wineshop_Telephone = wineshop.getWineshop_Telephone();
							String QY = wineshop.getWineshop_QY();
						IndentDao dao3 = new IndentDao();
						Indent indent = new Indent();
						indent.setIndent_Time(df.format(new Date()));
						indent.setIndent_Distribution_Time("");
						indent.setWineshop_ID(Wineshop_ID);
						indent.setWineshop_Address(wineshop_Address);
						indent.setIndent_Fare("");   
						indent.setIndent_Check_Type("");
						indent.setWineshop_Telephone(wineshop_Telephone);
						indent.setIndent_Status("正在支付");
						indent.setIndent_Type("微信支付");
						indent.setIndent_remark(Indent_Remark);
						indent.setIndent_TuiKuan("");
						indent.setIndent_Why("");
						indent.setIndent_PayID(out_trade_no);
						indent.setIndent_PayType("预支付");
						indent.setIndent_XXX("使用" + xxx + "元优惠卷");
						indent.setIndent_Coupon(asd);
						indent.setIndent_Red(ad);
						indent.setIndent_QY(QY);
						
						indent.setIndent_ZZZ(zzz);
						
						dao3.add1000(indent);
						//dao3.add100(indent);
						
						PointDao daos = new PointDao();
						Point p = new Point();
						int as = daos.count(Wineshop_ID);
						if(as==0){
							p.setWineshop_ID(Wineshop_ID);
							p.setPoint_num(0);
							p.setPoint_last((int)(a));
							p.setPoint_Status("预支付");
							daos.add(p);
						}else{
							p.setPoint_last((int)(a));
							p.setPoint_Status("预支付");
							p.setWineshop_ID(Wineshop_ID);
							daos.updatefinishes(p);
						}
						
						
						  int Indent_ID = dao3.findID(Wineshop_ID);
						  
						  
			 				
			 			
						  TotalDao dao5 = new TotalDao();
						  Total total = new Total();
						  total.setIndent_ID(Indent_ID);
						  total.setTotal(a);
						  total.setFare(Fare);
						  total.setGreens(Greens_Price);
						  dao5.add(total);
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
								  float greens_price = greens.getGreens_Price();
								  String Greens_Type_Name = greens.getGreens_Type_Name();
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
						 order.setGreens_Price(greens_price);
						 order.setGreens_Type_Name(Greens_Type_Name);
						 dao9.add(order);
						 
						 
						  }
							List<Greens> list12 = dao10.findUserByID(greens_ID);
							System.out.println("list12="+list12);
							/*for(Greens green : list12){
								int Number = number1-number;
								green.setGreens_Number(Number);
								green.setGreens_ID(greens_ID);
								dao10.update1(green);
							}*/
						  }  
						  
						  }
						
						SortedMap<Object, Object> packageParam = new TreeMap<Object, Object>();
						packageParam.put("appid", "wx7b0f2a75b9edb92b"); //微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
						packageParam.put("partnerid", mch_id);
						packageParam.put("prepayid", prepay_id);// 商品描述
						packageParam.put("package", "Sign=WXPay");// 商户订单号
						packageParam.put("noncestr", noncestr);
						packageParam.put("timestamp", timestamp);
						String sign1 = createSign("UTF-8", packageParam, "d2fp6ugtfgp45wr453u6kvcibrdnq69a");// 这里是二次签名    //应用对应的密钥
						// 处理交易订单信息 // 前台要拿到去调起微信支付，如果这个错了的话会在前台报签名错误
						Map<String, Object> jsonMap = new TreeMap<String, Object>();
						jsonMap.put("appid", "wx7b0f2a75b9edb92b");//微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
						jsonMap.put("noncestr", noncestr);
						jsonMap.put("package", "Sign=WXPay");
						jsonMap.put("partnerid", mch_id);
						jsonMap.put("prepayid", prepay_id);
						jsonMap.put("timestamp", timestamp);
						jsonMap.put("sign", sign1);
						System.out.println("jsonMap==="+jsonMap);
						JSONArray json = JSONArray.fromObject(jsonMap);
						PrintWriter out = response.getWriter();
						out.print(json);
						out.flush();
						out.close();
//						jsonBack = new JsonBack(true, "success", jsonMap);
					}
				}
			} catch (JDOMException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
//			return jsonBack;
	
		
	}else{

		float zzz = 0;
		if(request2.getParameter("zzz")==null){
			
		}else{
			 zzz = Float.parseFloat(request2.getParameter("zzz"));
		}
		float a = Float.parseFloat(request2.getParameter("total"));
		System.out.println(a);
		int b = (int) (Float.valueOf(a)*100);
			String total_fee = b+"" ;
			
			float Greens_Price = Float.parseFloat(request2.getParameter("SC"));
			String Indent_Remark = request2.getParameter("Indent_Remark");
			float Fare = Float.parseFloat(request2.getParameter("Fare"));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String name = request2.getParameter("Wineshop_Name");
			
			String body = "蔬菜购买微信支付系统";  //商品描述
			String mch_id = "1528336491"; //微信支付商户号 
			String currTime = getCurrTime();
			String strTime = currTime.substring(8, currTime.length());
			String strRandom = buildRandom(4) + "";
			String nonce_str = strTime + strRandom;
			String notify_url = "http://www.sumengkx.com/ACPSample_B2C/NoServlet";// 回调地址 必须能直接访问 不是二级域名也可以
			String out_trade_no = String.valueOf(UUID.next()); // 订单号
			String timestamp = getTimeStamp();
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			packageParams.put("appid", "wx7b0f2a75b9edb92b");  // 微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
			packageParams.put("mch_id", mch_id);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("body", body);//商品标题
			packageParams.put("out_trade_no", out_trade_no);// 商户订单号
			packageParams.put("total_fee", total_fee);// 总金额
			String addr = "192.168.1.105";
			packageParams.put("spbill_create_ip", addr);// 发起人IP地址
			packageParams.put("notify_url", notify_url);// 回调地址
			packageParams.put("trade_type", "APP");// 交易类型
			packageParams.put("time_start", timestamp);
			String sign = createSign("UTF-8", packageParams, "d2fp6ugtfgp45wr453u6kvcibrdnq69a"); //应用对应的密钥
			packageParams.put("sign", sign);// 签名
			String requestXML = getRequestXml(packageParams);
			String resXml = postData("https://api.mch.weixin.qq.com/pay/unifiedorder", requestXML);
			Map map;
			try {
				map = doXMLParse(resXml);
				String returnCode = (String) map.get("return_code");
				String returnMsg = (String) map.get("return_msg");
				if ("SUCCESS".equals(returnCode)) {
					String resultCode = (String) map.get("result_code");
					String prepay_id = (String) map.get("prepay_id");
					String noncestr = (String) map.get("nonce_str");
					if ("SUCCESS".equals(resultCode)) {
						
						
						
						
						
						
					
						System.out.println("name="+name);
						WineshopDao dao1 = new WineshopDao();
						int Wineshop_ID = dao1.findUserByID2(name);
						System.out.println("Wineshop_id="+Wineshop_ID);
						int number1 = 0;
						
						CouponDao da = new CouponDao();
						RedDao daoss = new RedDao();
						Red r = new Red();
						r.setRed_Status("预使用");
						r.setRed_ID(yyy);
						daoss.update(r);
						List<Red> list = daoss.findas(yyy);
						int oa = 0;
						int ob = 0;
						for(Red pl : list){
							oa = pl.getGive_Money();
							ob = pl.getGive_Num();
						}
						
						List<Wineshop> list4 = dao1.findUserByID(Wineshop_ID);
						for(Wineshop wineshop : list4){
							String wineshop_Address = wineshop.getWineshop_Address();
							String wineshop_Telephone = wineshop.getWineshop_Telephone();
							String QY = wineshop.getWineshop_QY();
						IndentDao dao3 = new IndentDao();
						Indent indent = new Indent();
						indent.setIndent_Time(df.format(new Date()));
						indent.setIndent_Distribution_Time("");
						indent.setWineshop_ID(Wineshop_ID);
						indent.setWineshop_Address(wineshop_Address);
						indent.setIndent_Fare("");   
						indent.setIndent_Check_Type("");
						indent.setWineshop_Telephone(wineshop_Telephone);
						indent.setIndent_Status("正在支付");
						indent.setIndent_Type("微信支付");
						indent.setIndent_remark(Indent_Remark);
						indent.setIndent_TuiKuan("");
						indent.setIndent_Why("");
						indent.setIndent_PayID(out_trade_no);
						indent.setIndent_PayType("预支付");
						indent.setIndent_XXX("使用满" + oa + "返" + ob + "元赠送卷");
						indent.setIndent_Coupon(0);
						indent.setIndent_Red(yyy);
						indent.setIndent_QY(QY);
						indent.setIndent_ZZZ(zzz);
						dao3.add1000(indent);
						
						PointDao daos = new PointDao();
						Point p = new Point();
						int as = daos.count(Wineshop_ID);
						if(as==0){
							p.setWineshop_ID(Wineshop_ID);
							p.setPoint_num(0);
							p.setPoint_last((int)(a));
							p.setPoint_Status("预支付");
							daos.add(p);
						}else{
							p.setPoint_last((int)(a));
							p.setPoint_Status("预支付");
							p.setWineshop_ID(Wineshop_ID);
							daos.updatefinishes(p);
						}
						
						
						  int Indent_ID = dao3.findID(Wineshop_ID);
						  
						  
			 				
			 			
						  TotalDao dao5 = new TotalDao();
						  Total total = new Total();
						  total.setIndent_ID(Indent_ID);
						  total.setTotal(a);
						  total.setFare(Fare);
						  total.setGreens(Greens_Price);
						  dao5.add(total);
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
								  float greens_price = greens.getGreens_Price();
								  String Greens_Type_Name = greens.getGreens_Type_Name();
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
						 order.setGreens_Price(greens_price);
						 order.setGreens_Type_Name(Greens_Type_Name);
						 dao9.add(order);
						 
						 
						  }
							List<Greens> list12 = dao10.findUserByID(greens_ID);
							System.out.println("list12="+list12);
							/*for(Greens green : list12){
								int Number = number1-number;
								green.setGreens_Number(Number);
								green.setGreens_ID(greens_ID);
								dao10.update1(green);
							}*/
						  }  
						  
							//dao11.delete1(Wineshop_ID);
						  }
						
						SortedMap<Object, Object> packageParam = new TreeMap<Object, Object>();
						packageParam.put("appid", "wx7b0f2a75b9edb92b"); //微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
						packageParam.put("partnerid", mch_id);
						packageParam.put("prepayid", prepay_id);// 商品描述
						packageParam.put("package", "Sign=WXPay");// 商户订单号
						packageParam.put("noncestr", noncestr);
						packageParam.put("timestamp", timestamp);
						String sign1 = createSign("UTF-8", packageParam, "d2fp6ugtfgp45wr453u6kvcibrdnq69a");// 这里是二次签名    //应用对应的密钥
						// 处理交易订单信息 // 前台要拿到去调起微信支付，如果这个错了的话会在前台报签名错误
						Map<String, Object> jsonMap = new TreeMap<String, Object>();
						jsonMap.put("appid", "wx7b0f2a75b9edb92b");//微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
						jsonMap.put("noncestr", noncestr);
						jsonMap.put("package", "Sign=WXPay");
						jsonMap.put("partnerid", mch_id);
						jsonMap.put("prepayid", prepay_id);
						jsonMap.put("timestamp", timestamp);
						jsonMap.put("sign", sign1);
						System.out.println("jsonMap==="+jsonMap);
						JSONArray json = JSONArray.fromObject(jsonMap);
						PrintWriter out = response.getWriter();
						out.print(json);
						out.flush();
						out.close();
//						jsonBack = new JsonBack(true, "success", jsonMap);
					}
				}
			} catch (JDOMException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
//			return jsonBack;
	
			
	
	}
		}
		}
		
		// 支付回调通知
			public void getnotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
				System.out.println("微信支付回调");
				PrintWriter writer = response.getWriter();
				InputStream inStream = request.getInputStream();
				ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = inStream.read(buffer)) != -1) {
					outSteam.write(buffer, 0, len);
				}
				outSteam.close();
				inStream.close();
				String result = new String(outSteam.toByteArray(), "utf-8");
				System.out.println("微信支付通知结果：" + result);
				Map<String, String> map = null;
				try {
					/**
					 * 解析微信通知返回的信息
					 */
					map = doXMLParse(result);
				} catch (JDOMException e) {
					e.printStackTrace();
				}
				System.out.println("=========:" + result);
				// 若支付成功，则告知微信服务器收到通知
				if (map.get("return_code").equals("SUCCESS")) {
					if (map.get("result_code").equals("SUCCESS")) {
						System.out.println("成功支付后获得的订单号："+map.get("out_trade_no"));
						Map<String,Object> rechargeRecord = null;
//						Map<String,Object> rechargeRecord = appUserService.getByTradeNo(map.get("out_trade_no"));
						// 判断通知是否已处理，若已处理，则不予处理
						if (rechargeRecord.get("pay_time")==null) {
							Map<String,Object> mapParams = new HashMap<String,Object>();
							mapParams.put("pay_time", new Date());
							float balance = Float.valueOf(map.get("total_fee"))/100;
							mapParams.put("balance", String.valueOf(balance));
							mapParams.put("out_trade_no", map.get("out_trade_no"));
							mapParams.put("pay_state", "1");//支付成功状态
//							appUserService.updateBytradeNo(mapParams);
							String notifyStr = setXML("SUCCESS", "支付成功");
							writer.write(notifyStr);
							writer.flush();
						}
					}
				}
			}
		
		 /** 
	     * 获取当前时间 yyyyMMddHHmmss 
	     *  
	     * @return String 
	     */  
	    public static String getCurrTime() {  
	        Date now = new Date();  
	        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
	        String s = outFormat.format(now);  
	        return s;  
	    }
		
	    /**
	     * 取出一个指定长度大小的随机正整数. 
	     * @Author  japhet_jiu
	     * @param length
	     * @return  int
	     * @Date    2017年7月31日
	     * 
	     */
	     public static int buildRandom(int length) {  
	         int num = 1;  
	         double random = Math.random();  
	         if (random < 0.1) {  
	             random = random + 0.1;  
	         }  
	         for (int i = 0; i < length; i++) {  
	             num = num * 10;  
	         }  
	         return (int) ((random * num));  
	     }
	     
	     /**
	      * 获取时间戳
	      * @return
	      */
	     public static String getTimeStamp() {
	         return String.valueOf(System.currentTimeMillis() / 1000);
	     }
	     
	     /**
	      * 获取IP地址
	      * @Author japhet_jiu
	      * @param request
	      * @return  String
	      * @Date    2017年7月31日
	      *
	      */
	     public static String getIpAddr(HttpServletRequest request)
	     {
	         String ip = request.getHeader("X-Real-IP");
	         if(!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip))
	             return ip;
	         ip = request.getHeader("X-Forwarded-For");
	         if(!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip))
	         {
	             int index = ip.indexOf(',');
	             if(index != -1)
	                return ip.substring(0, index);
	             else
	                 return ip;
	         }
	         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	             ip = request.getHeader("Proxy-Client-IP");
	         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	             ip = request.getHeader("WL-Proxy-Client-IP");
	         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	             ip = request.getHeader("HTTP_CLIENT_IP");
	         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	             ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	             ip = request.getRemoteAddr();
	         if(ip==null||ip!=null&&ip.indexOf("0:0:0:0:0:0:0")!=-1){
	             return "127.0.0.1";
	         }
	         return ip;
	     }
	     
	     /** 
	      * @author japhet_jiu
	      * @Description：sign签名 
	      * @param characterEncoding 
	      *            编码格式 
	      * @param parameters 
	      *            请求参数 
	      * @return 
	      */  
	     @SuppressWarnings({ "rawtypes"})
	     public static String createSign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {  
	         StringBuffer sb = new StringBuffer();
	         Set es = packageParams.entrySet();  
	         Iterator it = es.iterator();  
	         while (it.hasNext()) {  
	             Map.Entry entry = (Map.Entry) it.next();  
	             String k = (String) entry.getKey();  
	             String v = (String) entry.getValue();  
	             if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {  
	                 sb.append(k + "=" + v + "&");  
	             }  
	         }  
	         sb.append("key=" + API_KEY);  
	         String sign = MD5Encode(sb.toString(), characterEncoding).toUpperCase();  
	         return sign;  
	     }
	     /**
	      *  MD5Encode
	      * @param origin
	      * @param charsetname
	      * @return
	      */
	     public static String MD5Encode(String origin, String charsetname) {
	         String resultString = null;
	         try {
	             resultString = new String(origin);
	             MessageDigest md = MessageDigest.getInstance("MD5");
	             if (charsetname == null || "".equals(charsetname))
	                 resultString = byteArrayToHexString(md.digest(resultString
	                         .getBytes()));
	             else
	                 resultString = byteArrayToHexString(md.digest(resultString
	                         .getBytes(charsetname)));
	         } catch (Exception exception) {
	         }
	         return resultString;
	     }
	     
	     /**
	      * MD5加密
	      * @param b
	      * @return
	      */
	     private static String byteArrayToHexString(byte b[]) {
	         StringBuffer resultSb = new StringBuffer();
	         for (int i = 0; i < b.length; i++)
	             resultSb.append(byteToHexString(b[i]));
	 
	         return resultSb.toString();
	     }
	     /**
	      * byteToHexString
	      * @param b
	      * @return
	      */
	     private static String byteToHexString(byte b) {
	         int n = b;
	         if (n < 0)
	             n += 256;
	         int d1 = n / 16;
	         int d2 = n % 16;
	         return hexDigits[d1] + hexDigits[d2];
	     }
	     
	     /**
	      * hexDigits
	      */
	     private static final String hexDigits[] = { 
			 "0", "1", "2", "3", "4", "5","6", "7", "8", "9", "a", "b", "c", "d", "e", "f" 
		 };
	     
	     /**
	      * 将请求参数转换为xml格式的string
	      * @Author  japhet_jiu
	      * @param parameters
	      * @return  String
	      * @Date   
	      *
	      */
	      @SuppressWarnings({ "rawtypes"})
	      public static String getRequestXml(SortedMap<Object, Object> parameters) {  
	          StringBuffer sb = new StringBuffer();  
	          sb.append("<xml>");  
	          Set es = parameters.entrySet();  
	          Iterator it = es.iterator();  
	          while (it.hasNext()) {  
	              Map.Entry entry = (Map.Entry) it.next();  
	              String k = (String) entry.getKey();  
	              String v = (String) entry.getValue();  
	              if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {  
	                  sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");  
	              } else {  
	                  sb.append("<" + k + ">" + v + "</" + k + ">");  
	              }  
	          }  
	          sb.append("</xml>");  
	          return sb.toString();  
	      }
	      
	      /**
	       * postData
	       * @param urlStr
	       * @param data
	       * @return
	       */
	      public static String postData(String urlStr, String data) {
	         String postData  = postData2(urlStr, data, null);
	         return postData;
	      }
	      
	      /**
	       * postData2
	       */
	      private final static int CONNECT_TIMEOUT = 5000; // in milliseconds
	      private final static String DEFAULT_ENCODING = "UTF-8";
	      public static String postData2(String urlStr, String data, String contentType) {
	          BufferedReader reader = null;  
	          try {  
	              URL url = new URL(urlStr);  
	              URLConnection conn = url.openConnection();  
	              conn.setDoOutput(true);  
	              conn.setConnectTimeout(CONNECT_TIMEOUT);  
	              conn.setReadTimeout(CONNECT_TIMEOUT);  
	              if(contentType != null)  
	                  conn.setRequestProperty("content-type", contentType);  
	              OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);  
	              if(data == null)  
	                  data = "";  
	              writer.write(data);   
	              writer.flush();  
	              writer.close();    
	    
	              reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));  
	              StringBuilder sb = new StringBuilder();  
	              String line = null;  
	              while ((line = reader.readLine()) != null) {  
	                  sb.append(line);  
	                  sb.append("\r\n");  
	              }  
	              return sb.toString();  
	          } catch (IOException e) {  
	              e.printStackTrace();
	          } finally {  
	              try {  
	                  if (reader != null)  
	                      reader.close();  
	              } catch (IOException e) {  
	              }  
	          }  
	          return null;  
	      }
	      
	      /**
	       * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	       * 
	       * @param strxml
	       * @return
	       * @throws JDOMException
	       * @throws IOException
	       */
	      @SuppressWarnings({ "rawtypes", "unchecked" })
	      public static Map doXMLParse(String strxml) throws JDOMException, IOException {
	          strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
	 
	          if (null == strxml || "".equals(strxml)) {
	              return null;
	          }
	 
	          Map m = new HashMap();
	 
	          InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
	          SAXBuilder builder = new SAXBuilder();
	          Document doc = builder.build(in);
	          Element root = doc.getRootElement();
	          List list = root.getChildren();
	          Iterator it = list.iterator();
	          while (it.hasNext()) {
	              Element e = (Element) it.next();
	              String k = e.getName();
	              String v = "";
	              List children = e.getChildren();
	              if (children.isEmpty()) {
	                  v = e.getTextNormalize();
	              } else {
	                  v = getChildrenText(children);
	              }
	              m.put(k, v);
	          }
	          // 关闭流
	          in.close();
	          return m;
	      }
	      
	 
	      /**
	       * 获取子结点的xml
	       * 
	       * @param children
	       * @return String
	       */
	      @SuppressWarnings({ "rawtypes" })
	      public static String getChildrenText(List children) {
	          StringBuffer sb = new StringBuffer();
	          if (!children.isEmpty()) {
	              Iterator it = children.iterator();
	              while (it.hasNext()) {
	                  Element e = (Element) it.next();
	                  String name = e.getName();
	                  String value = e.getTextNormalize();
	                  List list = e.getChildren();
	                  sb.append("<" + name + ">");
	                  if (!list.isEmpty()) {
	                      sb.append(getChildrenText(list));
	                  }
	                  sb.append(value);
	                  sb.append("</" + name + ">");
	              }
	          }
	          return sb.toString();
	      }
	      
			/** 
			* 时间戳转换成日期格式字符串 
			* @param seconds 精确到秒的字符串 
			* @param formatStr 
			* @return 
			*/  
		     public static String timeStamp2Date(String seconds,String format) {  
		         if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
		             return "";  
		         }  
		         if(format == null || format.isEmpty()){
		             format = "yyyy-MM-dd HH:mm:ss";
		         }   
		         SimpleDateFormat sdf = new SimpleDateFormat(format);  
		         return sdf.format(new Date(Long.valueOf(seconds+"000")));  
		     }
	      
		     /**
		      * 支付成功，返回微信那服务器
		      * @param return_code
		      * @param return_msg
		      * @return
		      */
		     public static String setXML(String return_code, String return_msg) {
		         return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
		     }
	
		/* WxPayUnifiedOrderRequest request = WxPayUnifiedOrderRequest.newBuilder()
	            .body("app 微信支付2")
	            .totalFee(1)
	            .spbillCreateIp("192.168.0.24")
	            .notifyUrl(ConfigUtil.UNIFIED_ORDER_URL)
	            .tradeType(WxPayConstants.TradeType.APP)
	            .outTradeNo(String.valueOf(UUID.next()))
	            .build();
	    request.setSignType(WxPayConstants.SignType.MD5);
	    Object result;
		try {
			result = wxPayService.createOrder(request);
		    System.out.println("result=="+result);
		    PrintWriter out = response.getWriter();
			out.print(request);
			out.flush();
			out.close();
		} catch (WxPayException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
//	    return  result;
*/	
	}
	
	
//}

