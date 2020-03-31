package WeiXin;

import java.io.BufferedOutputStream;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.sec.Activity.SB;
import com.sec.Activity.SBDao;
import com.sec.dao.CartDao;
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
import com.sec.entity.Total;
import com.sec.entity.Wineshop;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class NoServlet
 */
@WebServlet("/NoServlet")
public class NoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		// ֧���ص�֪ͨ
		System.out.println("΢��֧���ص�");
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
		System.out.println("΢��֧��֪ͨ�����" + result);
		Map<String, String> map = null;
		try {
			/**
			 * ����΢��֪ͨ���ص���Ϣ
			 */
			map = doXMLParse(result);
		} catch (JDOMException e) {
			e.printStackTrace();
		}     
		System.out.println("=========:" + result);
		// ��֧���ɹ������֪΢�ŷ������յ�֪ͨ
		if (map.get("return_code").equals("SUCCESS")) {
			if (map.get("result_code").equals("SUCCESS")) {
				System.out.println("�ɹ�֧�����õĶ����ţ�"+map.get("out_trade_no"));
					String Indent_PayID = map.get("out_trade_no");
					System.out.println(Indent_PayID+"Indent_PayID");
				   //������������������������������������������������������������������������������������������������������������
				IndentDao dao = new IndentDao();
				Indent indent = new Indent();
				indent.setIndent_PayType("֧���ɹ�");
				indent.setIndent_Status("���ڴ���");
				indent.setIndent_PayID(Indent_PayID);
				dao.update100(indent);
				int Wineshop_ID = dao.Select1(Indent_PayID);
				
          	   
				int asd = dao.Select2(Indent_PayID);
				int ad = dao.Select3(Indent_PayID);
				if(ad==0){
					PointDao daos = new PointDao();
					Point ps = new Point();
					List<Point> lists = daos.findNumber(Wineshop_ID);
					int asss = 0;
					int ass = 0;
					for(Point p : lists){
						int as = p.getPoint_num();
						ass = p.getPoint_last();
						asss = as+ass;
					}
					
					ps.setPoint_num(asss);
					ps.setPoint_last(ass);
					ps.setPoint_Status("֧�����");
					ps.setWineshop_ID(Wineshop_ID);
					daos.updatefinish(ps);
					CartDao dao1 = new CartDao();
	 				dao1.delete1(Wineshop_ID);
String notifyStr = setXML("SUCCESS", "OK");
					
					System.out.println("notifyStr"+notifyStr);
					writer.write(notifyStr);
					writer.flush();
				}else{
				PointDao daos = new PointDao();
				Point ps = new Point();
				List<Point> lists = daos.findNumber(Wineshop_ID);
				int asss = 0;
				int ass = 0;
				for(Point p : lists){
					int as = p.getPoint_num();
					ass = p.getPoint_last();
					asss = as+ass;
				}
				
				ps.setPoint_num(asss);
				ps.setPoint_last(ass);
				ps.setPoint_Status("֧�����");
				ps.setWineshop_ID(Wineshop_ID);
				daos.updatefinish(ps);
				
 				CartDao dao1 = new CartDao();
 				dao1.delete1(Wineshop_ID);
 				
 				RedDao daoss = new RedDao();
 				daoss.delete(ad);
				
				
					String notifyStr = setXML("SUCCESS", "OK");
					
					System.out.println("notifyStr"+notifyStr);
					writer.write(notifyStr);
					writer.flush();
					
					//--------------------------------
					
					
					
				}
				
			}
		}
	}

	 
	    /**
	     * ��֤ǩ��
	     * 
	     * @param map
	     * @return
	     */
	 
			/** 
		     * �Ƿ�ǩ����ȷ,������:����������a-z����,������ֵ�Ĳ������μ�ǩ���� 
		     * @return boolean 
		     */  
	
	
	 private String returnXML(String return_code) {
		 
	        return "<xml><return_code><![CDATA["
	 
	                + return_code
	 
	                + "]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	    }
	 
	 
	 
	 
		    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams) {  
		        StringBuffer sb = new StringBuffer();  
		        Set es = packageParams.entrySet();  
		        Iterator it = es.iterator();  
		        while(it.hasNext()) {  
		            Map.Entry entry = (Map.Entry)it.next();  
		            String k = (String)entry.getKey();  
		            String v = (String)entry.getValue();  
		            if(!"sign".equals(k) && null != v && !"".equals(v)) {  
		                sb.append(k + "=" + v + "&");  
		            }  
		        }  

		        sb.append("key=" + ConfigUtil.API_KEY);  

		        //���ժҪ  
		        String mysign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();  
		        String tenpaySign = ((String)packageParams.get("sign")).toUpperCase();  

		        return tenpaySign.equals(mysign);  
		    }  
		
		 /** 
	     * ��ȡ��ǰʱ�� yyyyMMddHHmmss 
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
	     * ȡ��һ��ָ�����ȴ�С�����������. 
	     * @Author  japhet_jiu
	     * @param length
	     * @return  int
	     * @Date    2017��7��31��
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
	      * ��ȡʱ���
	      * @return
	      */
	     public static String getTimeStamp() {
	         return String.valueOf(System.currentTimeMillis() / 1000);
	     }
	     
	     /**
	      * ��ȡIP��ַ
	      * @Author japhet_jiu
	      * @param request
	      * @return  String
	      * @Date    2017��7��31��
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
	      * @Description��signǩ�� 
	      * @param characterEncoding 
	      *            �����ʽ 
	      * @param parameters 
	      *            ������� 
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
	      * MD5����
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
	      * ���������ת��Ϊxml��ʽ��string
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
	       * ����xml,���ص�һ��Ԫ�ؼ�ֵ�ԡ������һ��Ԫ�����ӽڵ㣬��˽ڵ��ֵ���ӽڵ��xml���ݡ�
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
	          // �ر���
	          in.close();
	          return m;
	      }
	      
	 
	      /**
	       * ��ȡ�ӽ���xml
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
			* ʱ���ת�������ڸ�ʽ�ַ��� 
			* @param seconds ��ȷ������ַ��� 
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
		      * ֧���ɹ�������΢���Ƿ�����
		      * @param return_code
		      * @param return_msg
		      * @return
		      */
		     public static String setXML(String return_code, String return_msg) {
		         return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
		     }
	
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
