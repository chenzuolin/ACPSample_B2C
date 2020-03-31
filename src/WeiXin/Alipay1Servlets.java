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
             Map<String, String> orderMap = new LinkedHashMap<String, String>(); // ����ʵ��
                Map<String, String> bizModel = new LinkedHashMap<String, String>(); // ����ʵ��
                /****** 2.��Ʒ������װ��ʼ *****/ // �ֻ�����
                // �̻������ţ��̻���վ����ϵͳ��Ψһ�����ţ�����
                orderMap.put("out_trade_no", String.valueOf(UUID.next())+date);
                // �������ƣ�����
                orderMap.put("subject","���ʻ���ϵͳ");
                // ���������
                orderMap.put("total_amount", String.valueOf(aa));
                // ���۲�Ʒ�� ����
                orderMap.put("product_code", "QUICK_WAP_PAY");
                /****** --------------- 3.����������װ ��ʼ ------------------------ *****/ // ֧������
                // 1.�̻�appid
                bizModel.put("app_id", HAlipayConfig.APPID);
                // 2.�������ص�ַ
                bizModel.put("method", HAlipayConfig.URL);
                // 3.�����ʽ
                bizModel.put("format", HAlipayConfig.FORMAT);
                // 4.�ص���ַ
                bizModel.put("return_url", HAlipayConfig.notify_url);
                // 5.˽Կ
                bizModel.put("private_key", HAlipayConfig.private_key);
                // 6.�̼�id
                bizModel.put("seller_id", HAlipayConfig.partner);
                // 7.���ܸ�ʽ
                bizModel.put("sign_type", HAlipayConfig.sign_type);
                /****** --------------- 3.����������װ ���� ------------------------ *****/
                // ʵ�����ͻ���
                AlipayClient client = new DefaultAlipayClient(HAlipayConfig.URL, HAlipayConfig.APPID,
                        HAlipayConfig.private_key, HAlipayConfig.FORMAT, HAlipayConfig.input_charset,
                        HAlipayConfig.ali_public_key, HAlipayConfig.sign_type);
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
                ali_request.setNotifyUrl(AlipayConfig.notify_url); // �ص���ַ
                AlipayTradeAppPayResponse responses = client.sdkExecute(ali_request);
                 orderStr = responses.getBody();
                System.err.println(orderStr); // ����orderString ����ֱ�Ӹ��ͻ�������������������
				
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
