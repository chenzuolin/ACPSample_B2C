package com.sec.Activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
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

import WeiXin.UUID;
import cn.itsource.pay.servlet.AlipayConfig;

/**
 * Servlet implementation class AlipayServlet
 */
@WebServlet("/AlipayServlet")
public class AlipayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlipayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET,POST");
				
				
				
				float a = Float.parseFloat(request.getParameter("total"));
				String name = request.getParameter("Wineshop_Name");
				WineshopDao dao8 = new WineshopDao();
				String Wineshop_Name = dao8.findUserByID8(name);
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
		                orderMap.put("subject",Wineshop_Name+"（充值活动）");
		                // 付款金额，必填
		                orderMap.put("total_amount", String.valueOf(aa));
		                // 销售产品码 必填
		                orderMap.put("product_code", "QUICK_WAP_PAY");
		                /****** --------------- 3.公共参数封装 开始 ------------------------ *****/ // 支付宝用
		                // 1.商户appid
		                bizModel.put("app_id", AlipayConfig.APPID);
		                // 2.请求网关地址
		                bizModel.put("method", AlipayConfig.URL);
		                // 3.请求格式
		                bizModel.put("format", AlipayConfig.FORMAT);
		                // 4.回调地址
		                bizModel.put("return_url", AlipayConfig.url);
		                // 5.私钥
		                bizModel.put("private_key", AlipayConfig.private_key);
		                // 6.商家id
		                bizModel.put("seller_id", AlipayConfig.partner);
		                // 7.加密格式
		                bizModel.put("sign_type", AlipayConfig.sign_type);
		                /****** --------------- 3.公共参数封装 结束 ------------------------ *****/
		                // 实例化客户端
		                AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
		                        AlipayConfig.private_key, AlipayConfig.FORMAT, AlipayConfig.input_charset,
		                        AlipayConfig.ali_public_key, AlipayConfig.sign_type);
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
		                ali_request.setNotifyUrl(AlipayConfig.url); // 回调地址
		                AlipayTradeAppPayResponse responses = client.sdkExecute(ali_request);
		                 orderStr = responses.getBody();
		                System.err.println(orderStr); // 就是orderString 可以直接给客户端请求，无需再做处理
		                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		                String date1 = df1.format(time);
						//System.out.println("name="+name);
						WineshopDao dao1 = new WineshopDao();
						int Wineshop_ID = dao1.findUserByID2(name);
						System.out.println("Wineshop_id="+Wineshop_ID);
						Activity A = new Activity();
						ActivityDao Y = new ActivityDao();
						A.setActivity_Time(date1);
						A.setActivity_Num(a);
						A.setActivity_Type("支付宝充值");
						A.setWineshop_ID(Wineshop_ID);
						A.setActivity_PayID(orderMap.get("out_trade_no"));
						A.setActivity_Status("预充值");
						Y.add(A);
		       
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
		doGet(request, response);
	}

}
