package com.sec.Activity;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.sec.Activity.Activity;
import com.sec.Activity.ActivityDao;
import com.sec.dao.CartDao;
import com.sec.dao.IndentDao;
import com.sec.entity.Indent;

/**
 * Servlet implementation class AlipayNorServlet
 */
@WebServlet("/AlipayNorServlet")
public class AlipayNorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlipayNorServlet() {
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
            	   ActivityDao dao = new ActivityDao();

					SBDao dao1 = new SBDao();
					Activity A = new Activity();
					A.setActivity_Status("充值成功");
					A.setActivity_PayID(Indent_PayID);
					dao.update(A);
					List<Activity> list = dao.findUserByID(Indent_PayID);
					for(Activity a:list){
					    float Activity_Num = a.getActivity_Num();
					    String num = Activity_Num+"";
					    int Wineshop_ID = a.getWineshop_ID();
					    List<SB> list1 = dao1.findAll(Wineshop_ID);
					    	if(list1.size()==0){
					    		SB s = new SB();
					    		s.setWineshop_ID(Wineshop_ID);
					    		s.setLJ_Num(num);
					    		s.setSB_Num(num);
					    		s.setNum_one("");
					    		s.setNum_Two("");
					    		s.setNum_BS(0);
					    		s.setNum_OFF(0);
					    		dao1.add(s);
					    	}else{
					    		SB s = new SB();
					    		List<SB> list3 = dao1.findAll(Wineshop_ID);
					    		for(SB c : list3){
					    			String LJ_num = c.getLJ_Num();
					    			String SB_num = c.getSB_Num();
					    			float cc = Activity_Num+Float.parseFloat(SB_num);
					    			String dd = cc+"";
					    			float aa = Activity_Num+Float.parseFloat(LJ_num);
					    			String bb = aa+"";
					    			s.setLJ_Num(bb);
					    			s.setSB_Num(dd);
					    			s.setWineshop_ID(Wineshop_ID);
					    			dao1.update(s);
					    			
					    		}
					    	}
					    	
					    
					}
						
				
				
     				
     				 System.out.println("订单更新成功");
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
