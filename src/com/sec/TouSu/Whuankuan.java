package com.sec.TouSu;

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

import WeiXin.UUID;

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

/**
 * Servlet implementation class Whuankuan
 */
@WebServlet("/Whuankuan")
public class Whuankuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Whuankuan() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request2, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request2.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
//		private static final Logger logger = LoggerFactory.getLogger(WinxinPay.class);
		
//			JsonBack jsonBack = null ;
//			int x = Integer.parseInt(tradeMoney);
			//float a = Float.parseFloat(request2.getParameter("total"));
			//int x=(int) (Float.valueOf(a)*100);
			//int cc = x*100;// 微信以分为单位，如果数据库里面的价格没扩大100的话这里要乘以100
			//int cc = x;
		
		float a = Float.parseFloat(request2.getParameter("total"));
		System.out.println(a);
		int b = (int) (Float.valueOf(a)*100);
			String total_fee = b+"" ;
			
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			
			String body = "蔬菜购买微信支付系统";  //商品描述
			String mch_id = "1528336491"; //微信支付商户号 
			String currTime = getCurrTime();
			String strTime = currTime.substring(8, currTime.length());
			String strRandom = buildRandom(4) + "";
			String nonce_str = strTime + strRandom;
			String notify_url = "http://www.sumengkx.com/ACPSample_B2C/NourServlet";// 回调地址 必须能直接访问 不是二级域名也可以
			String out_trade_no = String.valueOf(UUID.next()); // 订单号
			String timestamp = getTimeStamp();
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			packageParams.put("appid", "wx7b0f2a75b9edb92b");  // 微信开发平台应用ID 下面参数都不完整  需要写入自己的参数
			packageParams.put("mch_id", mch_id);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("body", body);//商品标题
			packageParams.put("out_trade_no", out_trade_no);// 商户订单号
			packageParams.put("total_fee", total_fee);// 总金额
//			String addr = AddressUtils.getIpAddr(request);
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
//				logger.info("result:" + returnMsg);
				if ("SUCCESS".equals(returnCode)) {
					String resultCode = (String) map.get("result_code");
					String prepay_id = (String) map.get("prepay_id");
					String noncestr = (String) map.get("nonce_str");
					if ("SUCCESS".equals(resultCode)) {
						
						
						
						
						
						
					
						
						
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
}

