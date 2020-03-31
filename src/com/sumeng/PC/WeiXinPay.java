package com.sumeng.PC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.AddressingFeature.Responses;

import com.sec.dao.CartDao;
import com.sec.dao.FZDao;
import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.TotalDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.FZ;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.Total;
import com.sec.entity.Wineshop;

import WeiXin.PayCommonUtil;
import WeiXin.UUID;
import WeiXin.XMLUtil;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class WeiXinPay
 */
@WebServlet("/WeiXinPay")
public class WeiXinPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String APPID = "wx7b0f2a75b9edb92b";
	private static String MCHID= "1528336491";
	private static String KEY= "d2fp6ugtfgp45wr453u6kvcibrdnq69a";
	private static String APPSECRET= "6b44a317fdfe02e1057fd84c73caeb94";
	private static String body= "速盟快线微信支付系统";
	private static String notify_url= "http://www.sumengkx.com/ACPSample_B2C/NotifyServlets";//回调地址
	
	
	public static String getLocalHostAddress() {//获取电脑IP
		InetAddress addr = null;
		try {
			// 获取本机的相关信息并保存在addr
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addr.getHostAddress().toString();
	}

	public static String CREATE_IP = getLocalHostAddress();
	
	 public static String getCurrTime() {  
	        Date now = new Date();  
	        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
	        String s = outFormat.format(now);  
	        return s;  
	    }
	 
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
     
	 
	 public static String postData(String urlStr, String data) {
         String postData  = postData2(urlStr, data, null);
         return postData;
      }
	  
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
     * @see HttpServlet#HttpServlet()
     */
    public WeiXinPay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		 JSONObject retJson = new JSONObject();
	        try {

	            String currTime = getCurrTime();
	            String strTime = currTime.substring(8, currTime.length());
	            String strRandom = buildRandom(4) + "";
	            String nonce_str = strTime + strRandom;//生成随机字符串
	            String spbill_create_ip = CREATE_IP;
	            System.out.println(spbill_create_ip);//获取设备IP
	            
	            // 正式上线的时候价格根据订单id查询
	            int b = (int) (Float.valueOf(total+"")*100);
				String order_price = b+"" ; // 价格 注意：价格的单位是分
	            
	            String out_trade_no = String.valueOf(UUID.next()); // 订单号

	            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
	            packageParams.put("appid", APPID);
	            packageParams.put("mch_id", MCHID);
	            packageParams.put("nonce_str", nonce_str);
	            packageParams.put("body", body);
	            packageParams.put("out_trade_no", out_trade_no);
	            packageParams.put("total_fee", order_price);
	            packageParams.put("spbill_create_ip", spbill_create_ip);
	            packageParams.put("notify_url", notify_url);
	            packageParams.put("trade_type", "NATIVE");
	            packageParams.put("product_id", "2222");

	            String sign = createSign("UTF-8",packageParams, KEY);// 这里是二次签名    //应用对应的密钥
	            packageParams.put("sign", sign);//加密

	            String requestXML = PayCommonUtil.getRequestXml(packageParams);
	            System.out.println(requestXML+"requestXML");
	            long startTime=System.currentTimeMillis();
	            String resXml = postData("https://api.mch.weixin.qq.com/pay/unifiedorder", requestXML);
	            long endTime=System.currentTimeMillis();
	            
	            Integer execute_time = (int) ((endTime-startTime)/1000);
	            System.out.println(resXml+"resXml");
	            Map map = XMLUtil.doXMLParse(resXml);
	            
	            JSONObject reportParams = new JSONObject();
	            reportParams.put("url", "https://api.mch.weixin.qq.com/pay/unifiedorder");
	            reportParams.put("execute_time", execute_time);
	            reportParams.put("return_code", map.get("return_code").toString());
	            reportParams.put("return_msg", map.get("return_msg").toString());
	            reportParams.put("result_code", map.get("result_code").toString());
	            System.out.println(map.get("result_code").toString()+"result_code");
	            if (map.get("err_code") != null) {
	                reportParams.put("err_code", map.get("err_code").toString());
	                reportParams.put("err_code_des", map.get("err_code_des").toString());
	            }
	            reportParams.put("out_trade_no", out_trade_no);
	            //交易保障
	            if (map.get("return_code").toString().equals("SUCCESS") && map.get("result_code").toString().equals("SUCCESS")) {
	                String urlCode = (String) map.get("code_url");//微信二维码短链接
	                retJson.put("code", 0);
	                retJson.put("message", "下单成功.");
	                retJson.put("data", urlCode);
	                System.out.println(urlCode+"urlCode");
	        		WineshopDao dao1 = new WineshopDao();
					System.out.println("Wineshop_id="+Wineshop_ID);
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
					indent.setIndent_Type("微信支付(PC)");
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
					fz.setXD_Time(df1.format(new Date()));
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
					 order.setIndent_Time(df1.format(new Date()));
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

	                HttpSession s = request.getSession();
	                s.setAttribute("urlCode", urlCode);
	                s.setAttribute("order_price", order_price);
	                s.setAttribute("out_trade_no", out_trade_no);
	                request.getRequestDispatcher("./PCWeiXin.jsp").forward(request, response);
	                System.out.println("order_price"+order_price);
	                
	                System.out.println("out_trade_no"+out_trade_no);
	            } else {
	                retJson.put("code", 1);
	                retJson.put("message", map.get("err_code_des").toString());
	                retJson.put("data", "");
	            }
	         
	           
	           
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	}

}
