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
		             Map<String, String> orderMap = new LinkedHashMap<String, String>(); // ����ʵ��
		                Map<String, String> bizModel = new LinkedHashMap<String, String>(); // ����ʵ��
		                /****** 2.��Ʒ������װ��ʼ *****/ // �ֻ�����
		                // �̻������ţ��̻���վ����ϵͳ��Ψһ�����ţ�����
		                orderMap.put("out_trade_no", String.valueOf(UUID.next())+date);
		                // �������ƣ�����
		                orderMap.put("subject",Wineshop_Name+"����ֵ���");
		                // ���������
		                orderMap.put("total_amount", String.valueOf(aa));
		                // ���۲�Ʒ�� ����
		                orderMap.put("product_code", "QUICK_WAP_PAY");
		                /****** --------------- 3.����������װ ��ʼ ------------------------ *****/ // ֧������
		                // 1.�̻�appid
		                bizModel.put("app_id", AlipayConfig.APPID);
		                // 2.�������ص�ַ
		                bizModel.put("method", AlipayConfig.URL);
		                // 3.�����ʽ
		                bizModel.put("format", AlipayConfig.FORMAT);
		                // 4.�ص���ַ
		                bizModel.put("return_url", AlipayConfig.url);
		                // 5.˽Կ
		                bizModel.put("private_key", AlipayConfig.private_key);
		                // 6.�̼�id
		                bizModel.put("seller_id", AlipayConfig.partner);
		                // 7.���ܸ�ʽ
		                bizModel.put("sign_type", AlipayConfig.sign_type);
		                /****** --------------- 3.����������װ ���� ------------------------ *****/
		                // ʵ�����ͻ���
		                AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
		                        AlipayConfig.private_key, AlipayConfig.FORMAT, AlipayConfig.input_charset,
		                        AlipayConfig.ali_public_key, AlipayConfig.sign_type);
		                // ʵ��������API��Ӧ��request��,�����ƺͽӿ����ƶ�Ӧ,��ǰ���ýӿ����ƣ�alipay.trade.app.pay
		                AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
		                // SDK�Ѿ���װ���˹�������������ֻ��Ҫ����ҵ����������·���Ϊsdk��model��η�ʽ(model��biz_contentͬʱ���ڵ������ȡbiz_content)��
		                AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		                // model.setPassbackParams(URLEncoder.encode((String)orderMap.get("body").toString()));;
		                // //������Ϣ ��Ӹ�������
		                // model.setBody(orderMap.get("body")); //��Ʒ��Ϣ
		                model.setSubject(orderMap.get("subject")); // ��Ʒ����
		                model.setOutTradeNo(orderMap.get("out_trade_no")); // �̻�������(�Զ�����)
		                
		                model.setTotalAmount(orderMap.get("total_amount")); // ֧�����
		                model.setProductCode(orderMap.get("product_code")); // ���۲�Ʒ��
		                //String out_trade_no = get
		               // model.setSellerId(AlipayConfig.partner); // �̼�id
		                ali_request.setBizModel(model);
		                ali_request.setNotifyUrl(AlipayConfig.url); // �ص���ַ
		                AlipayTradeAppPayResponse responses = client.sdkExecute(ali_request);
		                 orderStr = responses.getBody();
		                System.err.println(orderStr); // ����orderString ����ֱ�Ӹ��ͻ�������������������
		                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		                String date1 = df1.format(time);
						//System.out.println("name="+name);
						WineshopDao dao1 = new WineshopDao();
						int Wineshop_ID = dao1.findUserByID2(name);
						System.out.println("Wineshop_id="+Wineshop_ID);
						Activity A = new Activity();
						ActivityDao Y = new ActivityDao();
						A.setActivity_Time(date1);
						A.setActivity_Num(a);
						A.setActivity_Type("֧������ֵ");
						A.setWineshop_ID(Wineshop_ID);
						A.setActivity_PayID(orderMap.get("out_trade_no"));
						A.setActivity_Status("Ԥ��ֵ");
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
