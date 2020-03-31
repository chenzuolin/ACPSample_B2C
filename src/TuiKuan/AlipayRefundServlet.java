package TuiKuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.sec.dao.sizeDao;
import com.sec.entity.TimeIndent;

import cn.itsource.pay.servlet.AlipayConfig;

/**
 * Servlet implementation class AlipayRefundServlet
 */
@WebServlet("/AlipayRefundServlet")
public class AlipayRefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlipayRefundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8"); 
		float total = Float.parseFloat(request.getParameter("total"));
		String PayID = request.getParameter("payID");
		float Refund = Float.parseFloat(request.getParameter("Refund"));
		
		 AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",AlipayConfig.APPID,AlipayConfig.private_key,"json","GBK",AlipayConfig.ali_public_key,"RSA2");
		    AlipayTradeRefundModel model = new AlipayTradeRefundModel();
		    
		    model.setOutTradeNo(PayID); //与预 授权转支付商户订单号相同，代表对该笔交易退款
		    model.setRefundAmount(Refund+"");
		    model.setRefundReason("速盟快线退款系统");    
		    model.setOutRequestNo("refund0000001");//标识一次退款请求，同一笔交易多次退款需要保证唯一，如部分退款则此参数必传。
		    AlipayTradeRefundRequest request1 = new AlipayTradeRefundRequest();
		    request1.setBizModel(model);
		    AlipayTradeRefundResponse response1;
			try {
				response1 = alipayClient.execute(request1);
				 System.out.println("response: {}"+response1.getBody());
				 System.out.println(response1.getMsg());
				 if(response1.getMsg().equals("Success")) {
					 System.out.println("aa");
					 sizeDao dao = new sizeDao();
					 TimeIndent t = new TimeIndent();
					 t.setRefund_Status("退款关闭");
					 t.setIndent_PayID(PayID);
					 dao.update4(t);
					 PrintWriter out = response.getWriter();
						out.print("<script language='javascript'>alert('退款成功！');window.location.href='Refund.jsp'</script>");
					
				 }else {
					 PrintWriter out = response.getWriter();
						out.print("<script language='javascript'>alert('退款失败！');window.location.href='Refund.jsp'</script>");

					 
				 }
			} catch (AlipayApiException e) {
				// TODO 自动生成的 catch 块
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
