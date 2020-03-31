package WeiXin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itsource.pay.servlet.AlipayConfig;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.sec.Activity.SB;
import com.sec.Activity.SBDao;
import com.sec.dao.CartDao;
import com.sec.dao.IndentDao;
import com.sec.dao.PointDao;
import com.sec.dao.RedDao;
import com.sec.entity.Indent;
import com.sec.entity.Point;

/**
 * Servlet implementation class NoServlet1
 */
@WebServlet("/NoServlet1")
public class NoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoServlet1() {
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
            	   String tradeStatus = request.getParameter("trade_status");//获取上个页面传过来的交易状态 
            	   if(tradeStatus.equals("TRADE_FINISHED")||tradeStatus.equals("TRADE_SUCCESS")) {
            	   String Indent_PayID = params.get("out_trade_no");
            	   System.out.println("Indent_PayID"+Indent_PayID);
            	   IndentDao dao = new IndentDao();
            	   int Wineshop_ID = dao.Select1(Indent_PayID);
            	   
            	   
    				int asd = dao.Select2(Indent_PayID);
    				int ad = dao.Select3(Indent_PayID);
    				if(ad==0){
    					Indent indent = new Indent();
         				indent.setIndent_PayType("支付成功");
         				indent.setIndent_Status("正在处理");
         				indent.setIndent_PayID(Indent_PayID);
         				dao.update100(indent);
         				
         				PointDao daos = new PointDao();
        				Point ps = new Point();
        				List<Point> lists = daos.findNumber(Wineshop_ID);
        				int asss = 0;
        				int ass = 0;
        				for(Point p : lists){
        					int as = p.getPoint_num();
        					ass = p.getPoint_last();
        					asss = as+ass;
        				}
        				
        				ps.setPoint_num(asss);
        				ps.setPoint_last(ass);
        				ps.setPoint_Status("支付完成");
        				ps.setWineshop_ID(Wineshop_ID);
        				daos.updatefinish(ps);

         				CartDao dao1 = new CartDao();
         				dao1.delete1(Wineshop_ID);
         				
         				 System.out.println("订单更新成功");
    				}else{
    				RedDao daoss = new RedDao();
    				daoss.delete(ad);
            	   
     				Indent indent = new Indent();
     				indent.setIndent_PayType("支付成功");
     				indent.setIndent_Status("正在处理");
     				indent.setIndent_PayID(Indent_PayID);
     				dao.update100(indent);
     				
     				
     				
     				PointDao daos = new PointDao();
    				Point ps = new Point();
    				List<Point> lists = daos.findNumber(Wineshop_ID);
    				int asss = 0;
    				int ass = 0;
    				for(Point p : lists){
    					int as = p.getPoint_num();
    					ass = p.getPoint_last();
    					asss = as+ass;
    				}
    				
    				ps.setPoint_num(asss);
    				ps.setPoint_last(ass);
    				ps.setPoint_Status("支付完成");
    				ps.setWineshop_ID(Wineshop_ID);
    				daos.updatefinish(ps);
    				
    				
     				CartDao dao1 = new CartDao();
     				dao1.delete1(Wineshop_ID);
     				
     				 System.out.println("订单更新成功");
    				}
            	   }
            	   PrintWriter out = response.getWriter();
           		   out.print("success");
                     }else {
                    	 PrintWriter out = response.getWriter();
                 		   out.print("fail");
                     }
               
               System.out.println("支付宝验证异步通知信息结束");
              
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
		doGet(request, response);
	}

}
