package WeiXin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itsource.pay.servlet.AlipayConfig;
import cn.itsource.pay.servlet.HAlipayConfig;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.sec.dao.PriceDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Price;

/**
 * Servlet implementation class Alipay1Servlets
 */
@WebServlet("/Alipay1Servlets")
public class Alipay1Servlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alipay1Servlets() {
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
		String name = request.getParameter("Wineshop_Name");
		
		
		
		String aa = request.getParameter("total");
		Date time  = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = df.format(time);
		 String orderStr="";
         try {
             Map<String, String> orderMap = new LinkedHashMap<String, String>(); // 订单实体
                Map<String, String> bizModel = new LinkedHashMap<String, String>(); // 公共实体
                /****** 2.商品参数封装开始 *****/ // 手机端用
                // 商户订单号，商户网站订单系统中唯一订单号，必填
                orderMap.put("out_trade_no", String.valueOf(UUID.next())+date);
                // 订单名称，必填
                orderMap.put("subject","记帐还款系统");
                // 付款金额，必填
                orderMap.put("total_amount", String.valueOf(aa));
                // 销售产品码 必填
                orderMap.put("product_code", "QUICK_WAP_PAY");
                /****** --------------- 3.公共参数封装 开始 ------------------------ *****/ // 支付宝用
                // 1.商户appid
                bizModel.put("app_id", HAlipayConfig.APPID);
                // 2.请求网关地址
                bizModel.put("method", HAlipayConfig.URL);
                // 3.请求格式
                bizModel.put("format", HAlipayConfig.FORMAT);
                // 4.回调地址
                bizModel.put("return_url", HAlipayConfig.notify_url);
                // 5.私钥
                bizModel.put("private_key", HAlipayConfig.private_key);
                // 6.商家id
                bizModel.put("seller_id", HAlipayConfig.partner);
                // 7.加密格式
                bizModel.put("sign_type", HAlipayConfig.sign_type);
                /****** --------------- 3.公共参数封装 结束 ------------------------ *****/
                // 实例化客户端
                AlipayClient client = new DefaultAlipayClient(HAlipayConfig.URL, HAlipayConfig.APPID,
                        HAlipayConfig.private_key, HAlipayConfig.FORMAT, HAlipayConfig.input_charset,
                        HAlipayConfig.ali_public_key, HAlipayConfig.sign_type);
                // 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
                AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
                // SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
                AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
                // model.setPassbackParams(URLEncoder.encode((String)orderMap.get("body").toString()));;
                // //描述信息 添加附加数据
                // model.setBody(orderMap.get("body")); //商品信息
                model.setSubject(orderMap.get("subject")); // 商品名称
                model.setOutTradeNo(orderMap.get("out_trade_no")); // 商户订单号(自动生成)
                
                model.setTotalAmount(orderMap.get("total_amount")); // 支付金额
                model.setProductCode(orderMap.get("product_code")); // 销售产品码
                //String out_trade_no = get
               // model.setSellerId(AlipayConfig.partner); // 商家id
                ali_request.setBizModel(model);
                ali_request.setNotifyUrl(AlipayConfig.notify_url); // 回调地址
                AlipayTradeAppPayResponse responses = client.sdkExecute(ali_request);
                 orderStr = responses.getBody();
                System.err.println(orderStr); // 就是orderString 可以直接给客户端请求，无需再做处理
				
				//System.out.println("name="+name);
                
                PriceDao dao = new PriceDao();
                Price price = new Price();
                WineshopDao dao1 = new WineshopDao();
                int Wineshop_ID = dao1.findUserByID2(name);
               
                
                price.setIndent_PayID(String.valueOf(UUID.next())+date);
                price.setWineshop_ID(Wineshop_ID);
                dao.update66(price);
				
				
				  
        } catch (Exception e) {
            e.printStackTrace();
        }
         PrintWriter out = response.getWriter();
         out.print(orderStr);
 		out.flush();
 		out.close();

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
