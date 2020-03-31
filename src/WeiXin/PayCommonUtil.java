package WeiXin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

public class PayCommonUtil {
	public static String CreateNoncestr(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.indexOf(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    public static String CreateNoncestr() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }


    /** 
     * �Ƿ�ǩ����ȷ,������:����������a-z����,������ֵ�Ĳ������μ�ǩ���� 
     * @return boolean 
     */  
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
        String mysign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toLowerCase();  
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();  

        //System.out.println(tenpaySign + "    " + mysign);  
        return tenpaySign.equals(mysign);  
    }  


    /**
     * @Description��signǩ��
     * @param characterEncoding �����ʽ
     * @param parameters �������
     * @return
     */
    public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v) 
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key="+ConfigUtil.API_KEY);
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }
    /**
     * @Description�����������ת��Ϊxml��ʽ��string
     * @param parameters  �������
     * @return
     */
    public static String getRequestXml(SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue().toString();
            if ("attach".equalsIgnoreCase(k)||"body".equalsIgnoreCase(k)) {
                sb.append("<"+k+">"+"<![CDATA["+v+"]]></"+k+">");
            }else {
                sb.append("<"+k+">"+v+"</"+k+">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }
    /**
     * @Description�����ظ�΢�ŵĲ���
     * @param return_code ���ر���
     * @param return_msg  ������Ϣ
     * @return
     */
    public static String setXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code
                + "]]></return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
    }


    /**
     * ����https����
     * @param requestUrl �����ַ
     * @param requestMethod ����ʽ��GET��POST��
     * @param outputStr �ύ������
     * @return ����΢�ŷ�������Ӧ����Ϣ
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        try {
            // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // ������SSLContext�����еõ�SSLSocketFactory����
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            //conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // ��������ʽ��GET/POST��
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded"); 
            // ��outputStr��Ϊnullʱ�������д����
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // ע������ʽ
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // ����������ȡ��������
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // �ͷ���Դ
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
//          log.error("���ӳ�ʱ��{}", ce);
        } catch (Exception e) {
//          log.error("https�����쳣��{}", e);
        }
        return null;
    }

    /**
     * ����https����
     * 
     * @param requestUrl �����ַ
     * @param requestMethod ����ʽ��GET��POST��
     * @param outputStr �ύ������
     * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)
     */
     public static JSONObject httpsRequest(String requestUrl, String requestMethod) {
            JSONObject jsonObject = null;
            try {
                    // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
                    TrustManager[] tm = { new MyX509TrustManager() };
                    SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
                    sslContext.init(null, tm, new java.security.SecureRandom());
                    // ������SSLContext�����еõ�SSLSocketFactory����
                    SSLSocketFactory ssf = sslContext.getSocketFactory();
                    URL url = new URL(requestUrl);
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    //conn.setSSLSocketFactory(ssf);
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    conn.setUseCaches(false);
                    conn.setConnectTimeout(3000);
                    // ��������ʽ��GET/POST��
                    conn.setRequestMethod(requestMethod);
                    //conn.setRequestProperty("content-type", "application/x-www-form-urlencoded"); 
                    // ��outputStr��Ϊnullʱ�������д����
                    // ����������ȡ��������
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String str = null;
                    StringBuffer buffer = new StringBuffer();
                    while ((str = bufferedReader.readLine()) != null) {
                            buffer.append(str);
                    }
                    // �ͷ���Դ
                    bufferedReader.close();
                    inputStreamReader.close();
                    inputStream.close();
                    inputStream = null;
                    conn.disconnect();
                    //jsonObject = JSONObject.parseObject(buffer.toString());
            } catch (ConnectException ce) {
//                    log.error("���ӳ�ʱ��{}", ce);
            } catch (Exception e) {
                    System.out.println(e);
//                    log.error("https�����쳣��{}", e);
            }
            return jsonObject;
}

    public static String urlEncodeUTF8(String source){
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
