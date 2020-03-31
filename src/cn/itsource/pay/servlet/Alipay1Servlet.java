package cn.itsource.pay.servlet;

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

import WeiXin.UUID;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.sec.dao.CartDao;
import com.sec.dao.CouponDao;
import com.sec.dao.FZDao;
import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.PointDao;
import com.sec.dao.RedDao;
import com.sec.dao.TotalDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.FZ;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.Point;
import com.sec.entity.Red;
import com.sec.entity.Total;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class Alipay1Servlet
 */
@WebServlet("/Alipay1Servlet")
public class Alipay1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alipay1Servlet() {
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
		
		int yyy = Integer.parseInt(request.getParameter("yyy"));
		RedDao daoa = new RedDao();
		String op = daoa.find(yyy);
		if(op==null){
			
			int xxx = Integer.parseInt(request.getParameter("xxx"));
			float zzz = 0;
			if(request.getParameter("zzz")==null){
				
			}else{
				 zzz = Float.parseFloat(request.getParameter("zzz"));
			}
			
			
			String name = request.getParameter("Wineshop_Name");
			WineshopDao dao8 = new WineshopDao();
			String Wineshop_Name = dao8.findUserByID8(name);
			float Greens_Price = Float.parseFloat(request.getParameter("SC"));
			float Fare = Float.parseFloat(request.getParameter("Fare"));
			String Indent_Remark = request.getParameter("Indent_Remark");//�������Ķ�����ע
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
	                orderMap.put("subject",Wineshop_Name);
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
	                bizModel.put("return_url", AlipayConfig.notify_url);
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
	                ali_request.setNotifyUrl(AlipayConfig.notify_url); // �ص���ַ
	                AlipayTradeAppPayResponse responses = client.sdkExecute(ali_request);
	                 orderStr = responses.getBody();
	                System.err.println(orderStr); // ����orderString ����ֱ�Ӹ��ͻ�������������������
	                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
					//System.out.println("name="+name);
					WineshopDao dao1 = new WineshopDao();
					int Wineshop_ID = dao1.findUserByID2(name);
					System.out.println("Wineshop_id="+Wineshop_ID);
					int number1 = 0;
					
					/*CouponDao da = new CouponDao();
					int asd = da.find(xxx);
					RedDao daoss = new RedDao();
					Red r = new Red();
					r.setRed_Status("Ԥʹ��");
					r.setWineshop_ID(Wineshop_ID);
					r.setCoupon_ID(asd);
					daoss.updatefinish(r);
					int ad = daoss.findNumberss(asd);*/
					
					List<Wineshop> list4 = dao1.findUserByID(Wineshop_ID);
					for(Wineshop wineshop : list4){
						String wineshop_Address = wineshop.getWineshop_Address();
						String wineshop_Telephone = wineshop.getWineshop_Telephone();
						String QY = wineshop.getWineshop_QY();
					IndentDao dao3 = new IndentDao();
					Indent indent = new Indent();
					indent.setIndent_Time(df1.format(new Date()));
					indent.setIndent_Distribution_Time("");
					indent.setWineshop_ID(Wineshop_ID);
					indent.setWineshop_Address(wineshop_Address);
					indent.setIndent_Fare("");
					indent.setIndent_Check_Type("");
					indent.setWineshop_Telephone(wineshop_Telephone);
					indent.setIndent_Status("����֧��");
					indent.setIndent_Type("֧����֧��");
					indent.setIndent_remark(Indent_Remark);
					indent.setIndent_TuiKuan("");
					indent.setIndent_Why("");
					indent.setIndent_PayID(orderMap.get("out_trade_no"));
					System.out.println("pp"+orderMap.get("out_trade_no"));
					indent.setIndent_PayType("Ԥ֧��");
					indent.setIndent_QY(QY);
					indent.setIndent_ZZZ(zzz);
					/*indent.setIndent_XXX("ʹ��" + xxx + "Ԫ�Żݾ�");
					indent.setIndent_Coupon(asd);
					indent.setIndent_Red(ad);
					dao3.add1000(indent);*/
					dao3.add100(indent);
					
					
					PointDao daos = new PointDao();
					Point p = new Point();
					int as = daos.count(Wineshop_ID);
					if(as==0){
						p.setWineshop_ID(Wineshop_ID);
						p.setPoint_num(0);
						p.setPoint_last(Double.valueOf(aa).intValue());
						p.setPoint_Status("Ԥ֧��");
						daos.add(p);
					}else{
						p.setPoint_last(Double.valueOf(aa).intValue());
						p.setPoint_Status("Ԥ֧��");
						p.setWineshop_ID(Wineshop_ID);
						daos.updatefinishes(p);
					}
					
					
					  int Indent_ID = dao3.findID(Wineshop_ID);
					  TotalDao dao5 = new TotalDao();
					  Total total = new Total();
					  total.setIndent_ID(Indent_ID);
					  total.setTotal(Float.parseFloat(aa));
					  total.setFare(Fare);
					  total.setGreens(Greens_Price);
					  total.setTotal_QY(QY);
					  dao5.add(total);
					  FZDao dao7 = new FZDao();
					  FZ fz = new FZ();
					  fz.setIndent_ID(Indent_ID);
					  fz.setCG_Name(null);
					  fz.setFJ_Name(null);
					  fz.setCourier_Name(null);
					  fz.setXD_Time(df1.format(new Date()));
					  fz.setCG_Time(null);
					  fz.setFJ_Time(null);
					  fz.setPS_Time(null);
					  dao7.add(fz);
					  GreensDao dao10 = new GreensDao();
					  CartDao dao11 = new CartDao();
					  int cart_ID = 0;
					  List<Cart> list11 = dao11.findUserByID(Wineshop_ID);
					  for(Cart cart : list11){
						  cart_ID = cart.getCart_ID();
						  int greens_ID = cart.getGreens_ID();
						  int number = cart.getNumber();
						  String order_Remark = cart.getRemark();
						  List<Greens> list10 = dao10.findUserByID(greens_ID);
						  for(Greens greens :list10){
							  String greens_Name = greens.getGreens_Name();
							  String greens_Unit = greens.getGreens_Unit();
							  float greens_price = greens.getGreens_Price();
							  String Greens_Type_Name = greens.getGreens_Type_Name();
					 Order order = new Order();
					 OrderDao dao9 = new OrderDao(); 
					 order.setIndent_ID(Indent_ID);
					 order.setGreens_ID(greens_ID);
					 order.setNumber(number);
					 order.setOrder_Requirement("");
					 order.setIndent_Status("���ڴ���");
					 order.setOrder_Remark(order_Remark);
					 order.setGreens_Name(greens_Name);
					 order.setGreens_Unit(greens_Unit);
					 order.setIndent_Time(df1.format(new Date()));
					 order.setWineshop_ID(Wineshop_ID);
					 order.setGreens_Price(greens_price);
					 order.setGreens_BiaoJi(0);
					 order.setGreens_Type_Name(Greens_Type_Name);
					 //order.setOrder_Text(Order_Text);
					 dao9.add(order);
					 
					 
					  }
						List<Greens> list12 = dao10.findUserByID(greens_ID);
						System.out.println("list12="+list12);
						/*for(Greens green : list12){
							int Number = number1-number;
							green.setGreens_Number(Number);
							green.setGreens_ID(greens_ID);
							dao10.update1(green);
						}*/
					  }  
					  
						//dao11.delete1(Wineshop_ID);
					  }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	         PrintWriter out = response.getWriter();
	         out.print(orderStr);
	 		out.flush();
	 		out.close();
		}else{
		if(op.contains("�Ż�ȯ")){
		int xxx = Integer.parseInt(request.getParameter("xxx"));
		float zzz = 0;
		if(request.getParameter("zzz")==null){
			
		}else{
			 zzz = Float.parseFloat(request.getParameter("zzz"));
		}
		
		String name = request.getParameter("Wineshop_Name");
		WineshopDao dao8 = new WineshopDao();
		String Wineshop_Name = dao8.findUserByID8(name);
		float Greens_Price = Float.parseFloat(request.getParameter("SC"));
		float Fare = Float.parseFloat(request.getParameter("Fare"));
		String Indent_Remark = request.getParameter("Indent_Remark");//�������Ķ�����ע
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
                orderMap.put("subject",Wineshop_Name);
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
                bizModel.put("return_url", AlipayConfig.notify_url);
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
                ali_request.setNotifyUrl(AlipayConfig.notify_url); // �ص���ַ
                AlipayTradeAppPayResponse responses = client.sdkExecute(ali_request);
                 orderStr = responses.getBody();
                System.err.println(orderStr); // ����orderString ����ֱ�Ӹ��ͻ�������������������
                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				//System.out.println("name="+name);
				WineshopDao dao1 = new WineshopDao();
				int Wineshop_ID = dao1.findUserByID2(name);
				System.out.println("Wineshop_id="+Wineshop_ID);
				int number1 = 0;
				
				CouponDao da = new CouponDao();
				int asd = da.find(xxx);
				RedDao daoss = new RedDao();
				Red r = new Red();
				r.setRed_Status("Ԥʹ��");
				r.setWineshop_ID(Wineshop_ID);
				r.setCoupon_ID(asd);
				daoss.updatefinish(r);
				int ad = daoss.findNumberss(asd);
				
				List<Wineshop> list4 = dao1.findUserByID(Wineshop_ID);
				for(Wineshop wineshop : list4){
					String wineshop_Address = wineshop.getWineshop_Address();
					String wineshop_Telephone = wineshop.getWineshop_Telephone();
					String QY = wineshop.getWineshop_QY();
				IndentDao dao3 = new IndentDao();
				Indent indent = new Indent();
				indent.setIndent_Time(df1.format(new Date()));
				indent.setIndent_Distribution_Time("");
				indent.setWineshop_ID(Wineshop_ID);
				indent.setWineshop_Address(wineshop_Address);
				indent.setIndent_Fare("");
				indent.setIndent_Check_Type("");
				indent.setWineshop_Telephone(wineshop_Telephone);
				indent.setIndent_Status("����֧��");
				indent.setIndent_Type("֧����֧��");
				indent.setIndent_remark(Indent_Remark);
				indent.setIndent_TuiKuan("");
				indent.setIndent_Why("");
				indent.setIndent_PayID(orderMap.get("out_trade_no"));
				System.out.println("pp"+orderMap.get("out_trade_no"));
				indent.setIndent_PayType("Ԥ֧��");
				indent.setIndent_XXX("ʹ��" + xxx + "Ԫ�Żݾ�");
				indent.setIndent_Coupon(asd);
				indent.setIndent_Red(ad);
				indent.setIndent_QY(QY);
				indent.setIndent_ZZZ(zzz);
				dao3.add1000(indent);
				
				//dao3.add100(indent);
				
				
				PointDao daos = new PointDao();
				Point p = new Point();
				int as = daos.count(Wineshop_ID);
				if(as==0){
					p.setWineshop_ID(Wineshop_ID);
					p.setPoint_num(0);
					p.setPoint_last(Double.valueOf(aa).intValue());
					p.setPoint_Status("Ԥ֧��");
					daos.add(p);
				}else{
					p.setPoint_last(Double.valueOf(aa).intValue());
					p.setPoint_Status("Ԥ֧��");
					p.setWineshop_ID(Wineshop_ID);
					daos.updatefinishes(p);
				}
				
				
				  int Indent_ID = dao3.findID(Wineshop_ID);
				  TotalDao dao5 = new TotalDao();
				  Total total = new Total();
				  total.setIndent_ID(Indent_ID);
				  total.setTotal(Float.parseFloat(aa));
				  total.setFare(Fare);
				  total.setGreens(Greens_Price);
				  total.setTotal_QY(QY);
				  dao5.add(total);
				  FZDao dao7 = new FZDao();
				  FZ fz = new FZ();
				  fz.setIndent_ID(Indent_ID);
				  fz.setCG_Name(null);
				  fz.setFJ_Name(null);
				  fz.setCourier_Name(null);
				  fz.setXD_Time(df1.format(new Date()));
				  fz.setCG_Time(null);
				  fz.setFJ_Time(null);
				  fz.setPS_Time(null);
				  dao7.add(fz);
				  GreensDao dao10 = new GreensDao();
				  CartDao dao11 = new CartDao();
				  int cart_ID = 0;
				  List<Cart> list11 = dao11.findUserByID(Wineshop_ID);
				  for(Cart cart : list11){
					  cart_ID = cart.getCart_ID();
					  int greens_ID = cart.getGreens_ID();
					  int number = cart.getNumber();
					  String order_Remark = cart.getRemark();
					  List<Greens> list10 = dao10.findUserByID(greens_ID);
					  for(Greens greens :list10){
						  String greens_Name = greens.getGreens_Name();
						  String greens_Unit = greens.getGreens_Unit();
						  float greens_price = greens.getGreens_Price();
						  String Greens_Type_Name = greens.getGreens_Type_Name();
				 Order order = new Order();
				 OrderDao dao9 = new OrderDao(); 
				 order.setIndent_ID(Indent_ID);
				 order.setGreens_ID(greens_ID);
				 order.setNumber(number);
				 order.setOrder_Requirement("");
				 order.setIndent_Status("���ڴ���");
				 order.setOrder_Remark(order_Remark);
				 order.setGreens_Name(greens_Name);
				 order.setGreens_Unit(greens_Unit);
				 order.setIndent_Time(df1.format(new Date()));
				 order.setWineshop_ID(Wineshop_ID);
				 order.setGreens_Price(greens_price);
				 //order.setOrder_Text(Order_Text);
				 order.setGreens_Type_Name(Greens_Type_Name);
				 dao9.add(order);
				 
				 
				  }
					List<Greens> list12 = dao10.findUserByID(greens_ID);
					System.out.println("list12="+list12);
					/*for(Greens green : list12){
						int Number = number1-number;
						green.setGreens_Number(Number);
						green.setGreens_ID(greens_ID);
						dao10.update1(green);
					}*/
				  }  
				  
					//dao11.delete1(Wineshop_ID);
				  }
        } catch (Exception e) {
            e.printStackTrace();
        }
         PrintWriter out = response.getWriter();
         out.print(orderStr);
 		out.flush();
 		out.close();
 	
	}else{
		float zzz = 0;
		if(request.getParameter("zzz")==null){
			
		}else{
			 zzz = Float.parseFloat(request.getParameter("zzz"));
		}
		String name = request.getParameter("Wineshop_Name");
		WineshopDao dao8 = new WineshopDao();
		String Wineshop_Name = dao8.findUserByID8(name);
		float Greens_Price = Float.parseFloat(request.getParameter("SC"));
		float Fare = Float.parseFloat(request.getParameter("Fare"));
		String Indent_Remark = request.getParameter("Indent_Remark");//�������Ķ�����ע
		String aa = request.getParameter("total");
		Date time  = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = df.format(time);
		 String orderStr="";
         try {
             Map<String, String> orderMap = new LinkedHashMap<String, String>(); // ����ʵ��
                Map<String, String> bizModel = new LinkedHashMap<String, String>(); // ����ʵ��
                orderMap.put("out_trade_no", String.valueOf(UUID.next())+date);
                // �������ƣ�����
                orderMap.put("subject",Wineshop_Name);
                // ���������
                orderMap.put("total_amount", String.valueOf(aa));
                // ���۲�Ʒ�� ����
                orderMap.put("product_code", "QUICK_WAP_PAY");
                // 1.�̻�appid
                bizModel.put("app_id", AlipayConfig.APPID);
                // 2.�������ص�ַ
                bizModel.put("method", AlipayConfig.URL);
                // 3.�����ʽ
                bizModel.put("format", AlipayConfig.FORMAT);
                // 4.�ص���ַ
                bizModel.put("return_url", AlipayConfig.notify_url);
                // 5.˽Կ
                bizModel.put("private_key", AlipayConfig.private_key);
                // 6.�̼�id
                bizModel.put("seller_id", AlipayConfig.partner);
                // 7.���ܸ�ʽ
                bizModel.put("sign_type", AlipayConfig.sign_type);
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
                ali_request.setNotifyUrl(AlipayConfig.notify_url); // �ص���ַ
                AlipayTradeAppPayResponse responses = client.sdkExecute(ali_request);
                 orderStr = responses.getBody();
                System.err.println(orderStr); // ����orderString ����ֱ�Ӹ��ͻ�������������������
                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				//System.out.println("name="+name);
				WineshopDao dao1 = new WineshopDao();
				int Wineshop_ID = dao1.findUserByID2(name);
				System.out.println("Wineshop_id="+Wineshop_ID);
				int number1 = 0;
				
				CouponDao da = new CouponDao();
						RedDao daoss = new RedDao();
						Red r = new Red();
						r.setRed_Status("Ԥʹ��");
						r.setRed_ID(yyy);
						daoss.update(r);
						List<Red> list = daoss.findas(yyy);
						int oa = 0;
						int ob = 0;
						for(Red pl : list){
							oa = pl.getGive_Money();
							ob = pl.getGive_Num();
						}
				
				List<Wineshop> list4 = dao1.findUserByID(Wineshop_ID);
				for(Wineshop wineshop : list4){
					String wineshop_Address = wineshop.getWineshop_Address();
					String wineshop_Telephone = wineshop.getWineshop_Telephone();
					String QY = wineshop.getWineshop_QY();
				IndentDao dao3 = new IndentDao();
				Indent indent = new Indent();
				indent.setIndent_Time(df1.format(new Date()));
				indent.setIndent_Distribution_Time("");
				indent.setWineshop_ID(Wineshop_ID);
				indent.setWineshop_Address(wineshop_Address);
				indent.setIndent_Fare("");
				indent.setIndent_Check_Type("");
				indent.setWineshop_Telephone(wineshop_Telephone);
				indent.setIndent_Status("����֧��");
				indent.setIndent_Type("֧����֧��");
				indent.setIndent_remark(Indent_Remark);
				indent.setIndent_TuiKuan("");
				indent.setIndent_Why("");
				indent.setIndent_PayID(orderMap.get("out_trade_no"));
				System.out.println("pp"+orderMap.get("out_trade_no"));
				indent.setIndent_PayType("Ԥ֧��");
				indent.setIndent_XXX("ʹ����" + oa + "��" + ob + "Ԫ���;�");
				indent.setIndent_Coupon(0);
				indent.setIndent_Red(yyy);
				indent.setIndent_QY(QY);
				indent.setIndent_ZZZ(zzz);
				dao3.add1000(indent);
				
				
				PointDao daos = new PointDao();
				Point p = new Point();
				int as = daos.count(Wineshop_ID);
				if(as==0){
					p.setWineshop_ID(Wineshop_ID);
					p.setPoint_num(0);
					p.setPoint_last(Double.valueOf(aa).intValue());
					p.setPoint_Status("Ԥ֧��");
					daos.add(p);
				}else{
					p.setPoint_last(Double.valueOf(aa).intValue());
					p.setPoint_Status("Ԥ֧��");
					p.setWineshop_ID(Wineshop_ID);
					daos.updatefinishes(p);
				}
				
				
				  int Indent_ID = dao3.findID(Wineshop_ID);
				  TotalDao dao5 = new TotalDao();
				  Total total = new Total();
				  total.setIndent_ID(Indent_ID);
				  total.setTotal(Float.parseFloat(aa));
				  total.setFare(Fare);
				  total.setGreens(Greens_Price);
				  dao5.add(total);
				  FZDao dao7 = new FZDao();
				  FZ fz = new FZ();
				  fz.setIndent_ID(Indent_ID);
				  fz.setCG_Name(null);
				  fz.setFJ_Name(null);
				  fz.setCourier_Name(null);
				  fz.setXD_Time(df1.format(new Date()));
				  fz.setCG_Time(null);
				  fz.setFJ_Time(null);
				  fz.setPS_Time(null);
				  dao7.add(fz);
				  GreensDao dao10 = new GreensDao();
				  CartDao dao11 = new CartDao();
				  int cart_ID = 0;
				  List<Cart> list11 = dao11.findUserByID(Wineshop_ID);
				  for(Cart cart : list11){
					  cart_ID = cart.getCart_ID();
					  int greens_ID = cart.getGreens_ID();
					  int number = cart.getNumber();
					  String order_Remark = cart.getRemark();
					  List<Greens> list10 = dao10.findUserByID(greens_ID);
					  for(Greens greens :list10){
						  String greens_Name = greens.getGreens_Name();
						  String greens_Unit = greens.getGreens_Unit();
						  float greens_price = greens.getGreens_Price();
						  String Greens_Type_Name = greens.getGreens_Type_Name();
				 Order order = new Order();
				 OrderDao dao9 = new OrderDao(); 
				 order.setIndent_ID(Indent_ID);
				 order.setGreens_ID(greens_ID);
				 order.setNumber(number);
				 order.setOrder_Requirement("");
				 order.setIndent_Status("���ڴ���");
				 order.setOrder_Remark(order_Remark);
				 order.setGreens_Name(greens_Name);
				 order.setGreens_Unit(greens_Unit);
				 order.setIndent_Time(df1.format(new Date()));
				 order.setWineshop_ID(Wineshop_ID);
				 order.setGreens_Price(greens_price);
				 //order.setOrder_Text(Order_Text);
				 order.setGreens_Type_Name(Greens_Type_Name);
				 dao9.add(order);
				 
				 
				  }
					List<Greens> list12 = dao10.findUserByID(greens_ID);
					System.out.println("list12="+list12);
					/*for(Greens green : list12){
						
						int Number = number1-number;
						green.setGreens_Number(Number);
						green.setGreens_ID(greens_ID);
						dao10.update1(green);
					}*/
				  }  
				  
					//dao11.delete1(Wineshop_ID);
				  }
        } catch (Exception e) {
            e.printStackTrace();
        }
         PrintWriter out = response.getWriter();
         out.print(orderStr);
 		out.flush();
 		out.close();
	}
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
