package TuiKuan;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
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

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.sec.dao.sizeDao;
import com.sec.entity.TimeIndent;

/**
 * Servlet implementation class RefundServlet
 */
@WebServlet("/RefundServlet")
public class RefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
	 
	 public static String createSign(String characterEncoding, SortedMap<String, String> m, String API_KEY) {  
         StringBuffer sb = new StringBuffer();
         Set es = m.entrySet();  
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
     public static String getRequestXml(SortedMap<String, String> m) {  
         StringBuffer sb = new StringBuffer();  
         sb.append("<xml>");  
         Set es = m.entrySet();  
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
     * @see HttpServlet#HttpServlet()
     */
    public RefundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String appid = "wx7b0f2a75b9edb92b"; // appid
		String mch_id = "1528336491"; // 商业号
		String key = "d2fp6ugtfgp45wr453u6kvcibrdnq69a"; // key
		float total = Float.parseFloat(request.getParameter("total"));
		String PayID = request.getParameter("payID");
		float Refund = Float.parseFloat(request.getParameter("Refund"));
		float t = total*100;
	    float r = Refund*100;
		
		System.out.println(t+"aa");
		System.out.println(PayID+"bbbbbb");
		System.out.println(r+"cccccc");
		
		String currTime = getCurrTime();
		String strRandom = buildRandom(4) + "";
		String nonce_str = currTime + strRandom;//currTime + strRandom; // 随机字符串
		String out_trade_no =PayID;//申请退款的商户订单号

		String out_refund_no = out_trade_no + "1314";
		String op_user_id = mch_id; // 操作员默认为商户号

		SortedMap<String, String> m = new TreeMap<String, String>();
		m.put("appid", appid);
		m.put("mch_id", mch_id);
		m.put("nonce_str", nonce_str);
		m.put("out_trade_no",out_trade_no);
		m.put("out_refund_no", out_refund_no);
		m.put("total_fee",t+"");
		m.put("refund_fee",r+"");
		m.put("op_user_id", op_user_id);
		//签名算法
		String sign =createSign("UTF-8", m, key);
		m.put("sign", sign);
		//将集合转换成xml
		String requestXML =getRequestXml(m);
		//带证书的post
		String resXml = CertHttpUtil.postData("https://api.mch.weixin.qq.com/secapi/pay/refund", requestXML);
		//解析xml为集合，请打断点查看resXml详细信息
		Map<String, String> map;
		try {
			map = doXMLParse(resXml);
			PrintWriter out = response.getWriter();
			out.print(map.get("result_code"));
			String a = map.get("result_code");
			
			System.out.println(map.get("result_code"));
			if(a.equals("Success")) {
				sizeDao dao = new sizeDao();
				 TimeIndent t1 = new TimeIndent();
				 t1.setRefund_Status("退款关闭");
				 t1.setIndent_PayID(PayID);
				 dao.update4(t1);
				 PrintWriter out1 = response.getWriter();
					out1.print("<script language='javascript'>alert('退款成功！');window.location.href='/admin/caiwu/Refund.jsp'</script>");
			}else {
				PrintWriter out1 = response.getWriter();
				out1.print("<script language='javascript'>alert('退款失败！');window.location.href=/admin/caiwu/Refund.jsp'</script>");
			}
		} catch (JDOMException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//查看申请退款状态
	}

}
