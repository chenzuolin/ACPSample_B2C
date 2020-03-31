package com.sumeng.PC;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.JDOMException;

import com.sec.dao.CartDao;
import com.sec.dao.IndentDao;
import com.sec.entity.Indent;

import WeiXin.XMLUtil;

/**
 * Servlet implementation class NotifyServlet
 */
@WebServlet(name = "NotifyServlets", urlPatterns = { "/NotifyServlets" })
public class NotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static boolean createSign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {  
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
         return true;  
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
	 private static String byteToHexString(byte b) {
         int n = b;
         if (n < 0)
             n += 256;
         int d1 = n / 16;
         int d2 = n % 16;
         return hexDigits[d1] + hexDigits[d2];
     }
	 private static final String hexDigits[] = { 
			 "0", "1", "2", "3", "4", "5","6", "7", "8", "9", "a", "b", "c", "d", "e", "f" 
		 };
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("΢��֧���ص�");
				InputStream inputStream;
				try {
					StringBuffer sb = new StringBuffer();
					inputStream = request.getInputStream();
					String s;
					BufferedReader in = new BufferedReader(new InputStreamReader(
							inputStream, "UTF-8"));
					while ((s = in.readLine()) != null) {
						sb.append(s);
					}
					in.close();
					inputStream.close();
		 
					// ����xml��map
					Map<String, String> m = new HashMap<String, String>();
					m = XMLUtil.doXMLParse(sb.toString());
		 
					// ���˿� ���� TreeMap
					SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
					Iterator it = m.keySet().iterator();
					while (it.hasNext()) {
						String parameter = (String) it.next();
						String parameterValue = m.get(parameter);
		 
						String v = "";
						if (null != parameterValue) {
							v = parameterValue.trim();
						}
						packageParams.put(parameter, v);
					}
		 
					// �˺���Ϣ
					String key = "d2fp6ugtfgp45wr453u6kvcibrdnq69a"; // key
		 
					// �ж�ǩ���Ƿ���ȷ
					if (createSign("UTF-8", packageParams, key)) {
						// ------------------------------
						// ����ҵ��ʼ
						// ------------------------------
						String resXml = "";
						if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
							// ������֧���ɹ�
							// ////////ִ���Լ���ҵ���߼�////////////////
							//String mch_id = (String) packageParams.get("mch_id");
							//String openid = (String) packageParams.get("openid");
							//String is_subscribe = (String) packageParams.get("is_subscribe");
							String out_trade_no = (String) packageParams.get("out_trade_no");
							System.out.println(out_trade_no+"out_trade_no");
							String total_fee = (String) packageParams.get("total_fee");
							System.out.println(total_fee+"total_fee");
							String spbill_create_ip = (String) packageParams.get("spbill_create_ip");
							System.out.println(spbill_create_ip+"spbill_create_ip");


							IndentDao dao = new IndentDao();
							Indent indent = new Indent();
							indent.setIndent_PayType("֧���ɹ�");
							indent.setIndent_Status("���ڴ���");
							indent.setIndent_PayID(out_trade_no);
							dao.update100(indent);
							int Wineshop_ID = dao.Select1(out_trade_no);
					
			 				CartDao dao1 = new CartDao();
			 				dao1.delete1(Wineshop_ID);
							
							// ֪ͨ΢��.�첽ȷ�ϳɹ�.��д.��Ȼ��һֱ֪ͨ��̨.�˴�֮�����Ϊ����ʧ����.
							resXml = "<xml>"
									+ "<return_code><![CDATA[SUCCESS]]></return_code>"
									+ "<return_msg><![CDATA[OK]]></return_msg>"
									+ "</xml> ";
							System.out.println(resXml);
		 
						} else {
							resXml = "<xml>"
									+ "<return_code><![CDATA[FAIL]]></return_code>"
									+ "<return_msg><![CDATA[����Ϊ��]]></return_msg>"
									+ "</xml> ";
						}
						// ------------------------------
						// ����ҵ�����
						// ------------------------------
						try {
							BufferedOutputStream out = new BufferedOutputStream(
									response.getOutputStream());
							out.write(resXml.getBytes());
							out.flush();
							out.close();
							System.out.println("΢�Żص��ɹ��ˣ���");
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println("֪ͨǩ����֤ʧ��");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
