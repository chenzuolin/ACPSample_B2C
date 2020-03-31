package WeiXin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itsource.pay.servlet.AlipayConfig;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.sec.dao.PriceDao;
import com.sec.entity.Price;

/**
 * Servlet implementation class NoServlet88
 */
@WebServlet("/NoServlet88")
public class NoServlet88 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoServlet88() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		 System.out.println("支付宝验证异步通知信息开始");
         //Response resp = this.getReponse();
         try {
         //----------------请求参数------------------//
              

               //获取支付宝POST过来反馈信息
               Map<String,String> params = new HashMap<String,String>();
               Map requestParams = request.getParameterMap();
               for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                   String name = (String) iter.next();
                   String[] values = (String[]) requestParams.get(name);
                   String valueStr = "";
                   for (int i = 0; i < values.length; i++) {
                       valueStr = (i == values.length - 1) ? valueStr + values[i]
                                   : valueStr + values[i] + ",";
                     }
                   //乱码解决，这段代码在出现乱码时使用。
                     //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                     params.put(name, valueStr);
               }
         //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
         //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
               boolean flag = AlipaySignature.rsaCheckV1(params, AlipayConfig.ali_public_key, "utf-8","RSA2");
               System.out.println("flag"+flag);
               if(flag) {
            	   System.out.println("1");
            	   String Indent_PayID = params.get("out_trade_no");
            	   PriceDao dao = new PriceDao();
            	   Price price = new Price();
            	   price.setPrice_num(0);
            	   price.setIndent_PayID(Indent_PayID);
            	   dao.update99(price);
                    
               }
               
               System.out.println("支付宝验证异步通知信息结束");
               PrintWriter out = response.getWriter();
       		   out.print("success");
               //return success();
         } catch (AlipayApiException e) {
               System.out.println("支付宝验证异步通知信息结束" + e.getMessage());
               //return resp.failure(e.getMessage());
         }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
