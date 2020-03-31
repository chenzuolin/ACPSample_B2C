package cn.itsource.pay.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayUserInfoAuthRequest;
import com.alipay.api.response.AlipayUserInfoAuthResponse;

/**
 * Servlet implementation class TiXianServlet2
 */
@WebServlet("/TiXianServlet2")
public class TiXianServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiXianServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",AlipayConfig.APPID,AlipayConfig.private_key,"json","GBK",AlipayConfig.ali_public_key,"RSA2");
		AlipayUserInfoAuthRequest request1 = new AlipayUserInfoAuthRequest();
		request1.setBizContent("{" +
		"      \"scopes\":[" +
		"        \"auth_base\"" +
		"      ]," +
		"\"state\":\"init\"," +
		"\"is_mobile\":\"true\"" +
		"  }");
		AlipayUserInfoAuthResponse response1 = null;
		try {
			response1 = alipayClient.execute(request1);
		} catch (AlipayApiException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(response1.isSuccess()){
		System.out.println("调用成功");
		} else {
		System.out.println("调用失败");
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
