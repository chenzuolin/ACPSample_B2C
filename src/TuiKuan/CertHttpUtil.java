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

	private static int socketTimeout = 10000;// ���ӳ�ʱʱ�䣬Ĭ��10��
	private static int connectTimeout = 30000;// ���䳬ʱʱ�䣬Ĭ��30��
	private static RequestConfig requestConfig;// ������������
	private static CloseableHttpClient httpClient;// HTTP������

	/**
	 * ͨ��Https��API post xml����
	 * @param url	API��ַ
	 * @param xmlObj	Ҫ�ύ��XML���ݶ���
	 * @return
	 */
	public static String postData(String url, String xmlObj) {
		// ����֤��
		try {
			initCert();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result = null;
		HttpPost httpPost = new HttpPost(url);
		// ��ָ��ʹ��UTF-8���룬����API������XML�����Ĳ��ܱ��ɹ�ʶ��
		StringEntity postEntity = new StringEntity(xmlObj, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);
		// ����Ĭ�ϳ�ʱ���Ƴ�ʼ��requestConfig
		requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeout)
				.setConnectTimeout(connectTimeout)
				.build();
		// ����������������
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
	 * ����֤��
	 * 
	 */
	private static void initCert() throws Exception {
		// ֤�����룬Ĭ��Ϊ�̻�ID
		String key = "1528336491";
		// ֤���·��
		String path = "C:\\Users\\Administrator\\Desktop";
		// ָ����ȡ֤���ʽΪPKCS12
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		// ��ȡ������ŵ�PKCS12֤���ļ�
		FileInputStream instream = new FileInputStream(new File(path));
		try {
			// ָ��PKCS12������(�̻�ID)
			keyStore.load(instream, key.toCharArray());
		} finally {
			instream.close();
		}
		SSLContext sslcontext = SSLContexts
				.custom()
				.loadKeyMaterial(keyStore, key.toCharArray())
				.build();
		// ָ��TLS�汾
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		// ����httpclient��SSLSocketFactory
		httpClient = HttpClients
				.custom()
				.setSSLSocketFactory(sslsf)
				.build();
	}
}