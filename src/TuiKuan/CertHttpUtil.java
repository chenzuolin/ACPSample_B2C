package TuiKuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CertHttpUtil {

	private static int socketTimeout = 10000;// 连接超时时间，默认10秒
	private static int connectTimeout = 30000;// 传输超时时间，默认30秒
	private static RequestConfig requestConfig;// 请求器的配置
	private static CloseableHttpClient httpClient;// HTTP请求器

	/**
	 * 通过Https往API post xml数据
	 * @param url	API地址
	 * @param xmlObj	要提交的XML数据对象
	 * @return
	 */
	public static String postData(String url, String xmlObj) {
		// 加载证书
		try {
			initCert();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result = null;
		HttpPost httpPost = new HttpPost(url);
		// 得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
		StringEntity postEntity = new StringEntity(xmlObj, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);
		// 根据默认超时限制初始化requestConfig
		requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeout)
				.setConnectTimeout(connectTimeout)
				.build();
		// 设置请求器的配置
		httpPost.setConfig(requestConfig);
		try {
			HttpResponse response = null;
			try {
				response = httpClient.execute(httpPost);
			}  catch (IOException e) {
				e.printStackTrace();
			}
			HttpEntity entity = response.getEntity();
			try {
				result = EntityUtils.toString(entity, "UTF-8");
			}  catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			httpPost.abort();
		}
		return result;
	}

	/**
	 * 加载证书
	 * 
	 */
	private static void initCert() throws Exception {
		// 证书密码，默认为商户ID
		String key = "1528336491";
		// 证书的路径
		String path = "C:\\Users\\Administrator\\Desktop";
		// 指定读取证书格式为PKCS12
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		// 读取本机存放的PKCS12证书文件
		FileInputStream instream = new FileInputStream(new File(path));
		try {
			// 指定PKCS12的密码(商户ID)
			keyStore.load(instream, key.toCharArray());
		} finally {
			instream.close();
		}
		SSLContext sslcontext = SSLContexts
				.custom()
				.loadKeyMaterial(keyStore, key.toCharArray())
				.build();
		// 指定TLS版本
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		// 设置httpclient的SSLSocketFactory
		httpClient = HttpClients
				.custom()
				.setSSLSocketFactory(sslsf)
				.build();
	}
}