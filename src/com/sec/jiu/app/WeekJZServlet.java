package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.Activity.SB;
import com.sec.Activity.SBDao;
import com.sec.dao.CartDao;
import com.sec.dao.CouponDao;
import com.sec.dao.FZDao;
import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.PointDao;
import com.sec.dao.PriceDao;
import com.sec.dao.RedDao;
import com.sec.dao.TotalDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.FZ;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.Point;
import com.sec.entity.Price;
import com.sec.entity.Red;
import com.sec.entity.Total;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class WeekJZServlet
 */
@WebServlet("/WeekJZServlet")
public class WeekJZServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeekJZServlet() {
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
		float zzz = Float.parseFloat(request.getParameter("zzz"));
		int yyy = Integer.parseInt(request.getParameter("yyy"));
		RedDao daoa = new RedDao();
		String op = daoa.find(yyy);
		if(op==null){
			int xxx = Integer.parseInt(request.getParameter("xxx"));
			
			
			String name = request.getParameter("Wineshop_Name");
			float Greens_Price = Float.parseFloat(request.getParameter("SC"));
			float Fare = Float.parseFloat(request.getParameter("Fare"));
			String Indent_Remark = request.getParameter("Indent_Remark");//传过来的订单备注
			String aa = request.getParameter("total");
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			WineshopDao dao1 = new WineshopDao();
			int Wineshop_ID = dao1.findUserByID2(name);
			System.out.println("Wineshop_id="+Wineshop_ID);
			int number1 = 0;
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
			indent.setIndent_Status("正在处理");
			indent.setIndent_Type("记帐支付");
			indent.setIndent_remark(Indent_Remark);
			indent.setIndent_TuiKuan("");
			indent.setIndent_Why("");
			indent.setIndent_PayID("");
			indent.setIndent_PayType("支付成功");
			indent.setIndent_QY(QY);
			indent.setIndent_ZZZ(zzz);
			/*indent.setIndent_XXX("使用" + xxx + "元优惠卷");
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
				p.setPoint_Status("预支付");
				daos.add(p);
			}else{
				p.setPoint_last(Double.valueOf(aa).intValue());
				p.setPoint_Status("预支付");
				p.setWineshop_ID(Wineshop_ID);
				daos.updatefinishes(p);
			}
			PointDao daos1 = new PointDao();
			Point ps = new Point();
			List<Point> lists = daos1.findNumber(Wineshop_ID);
			int asss = 0;
			int ass = 0;
			for(Point p1 : lists){
				int as1 = p1.getPoint_num();
				ass = p1.getPoint_last();
				asss = as1+ass;
			}
			
			ps.setPoint_num(asss);
			ps.setPoint_last(ass);
			ps.setPoint_Status("支付完成");
			ps.setWineshop_ID(Wineshop_ID);
			daos.updatefinish(ps);
			
			PriceDao dao = new PriceDao();
			
			List<Price> list = dao.findUserByID2(Wineshop_ID);
			if(list.size()==1){
			for(Price price : list){
				int bb = price.getPrice_ID();
				float cc = price.getPrice_num();
				
				price.setPrice_num(Float.parseFloat(aa)+cc);
				price.setWineshop_ID(Wineshop_ID);
				price.setPrice_ID(bb);
				dao.update(price); 
			}
			}else{
				Price pp = new Price();
				pp.setPrice_num(Float.parseFloat(aa));
				pp.setWineshop_ID(Wineshop_ID);
				dao.add(pp);
			}

			
			
			  int Indent_ID = dao3.findID(Wineshop_ID);
			  float z = dao3.za(Indent_ID);
			  if(z<=0){
				  
			  }else{
				  SBDao da = new SBDao();
         		   List<SB> lis = da.findAll(Wineshop_ID);
         		   String rp = null;
         		   for(SB s : lis){
         			   rp = s.getSB_Num();
         		   }
         		   float opp = Float.valueOf(rp);
         		   float xx = opp - z;
         		   DecimalFormat fnum = new DecimalFormat("##0.00");
         		   String x = fnum.format(xx);
         		   SB ss = new SB();
         		   ss.setSB_Num(x);
         		   ss.setWineshop_ID(Wineshop_ID);
         		   da.update1(ss);
			  }
			  
			  
			  
			  
			  
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
					  number1 = greens.getGreens_Number();
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
			 order.setIndent_Status("正在处理");
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
				for(Greens green : list12){
					int Number = number1-number;
					green.setGreens_Number(Number);
					green.setGreens_ID(greens_ID);
					dao10.update1(green);
				}
			  }  
			  
				dao11.delete1(Wineshop_ID);
				if(list11.size()>0){
					PrintWriter out = response.getWriter();
					out.print(1);
					out.flush();
					out.close();
				}else{
					PrintWriter out = response.getWriter();
					out.print(0);
					out.flush();
					out.close();
				}
				
			  }

		}else{
		if(op.contains("优惠券")){
		int xxx = Integer.parseInt(request.getParameter("xxx"));
		
		
		String name = request.getParameter("Wineshop_Name");
		float Greens_Price = Float.parseFloat(request.getParameter("SC"));
		float Fare = Float.parseFloat(request.getParameter("Fare"));
		String Indent_Remark = request.getParameter("Indent_Remark");//传过来的订单备注
		String aa = request.getParameter("total");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		WineshopDao dao1 = new WineshopDao();
		int Wineshop_ID = dao1.findUserByID2(name);
		System.out.println("Wineshop_id="+Wineshop_ID);
		int number1 = 0;
		
		CouponDao da = new CouponDao();
		int asd = da.find(xxx);
		RedDao daoss = new RedDao();
		Red r = new Red();
		r.setRed_Status("预使用");
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
		indent.setIndent_Status("正在处理");
		indent.setIndent_Type("记帐支付");
		indent.setIndent_remark(Indent_Remark);
		indent.setIndent_TuiKuan("");
		indent.setIndent_Why("");
		indent.setIndent_PayID("");
		indent.setIndent_PayType("支付成功");
		indent.setIndent_XXX("使用" + xxx + "元优惠卷");
		indent.setIndent_Coupon(asd);
		indent.setIndent_Red(ad);
		indent.setIndent_QY(QY);
		indent.setIndent_ZZZ(zzz);
		dao3.add1000(indent);
		//dao3.add100(indent);
		RedDao daoss1 = new RedDao();
			daoss1.delete(ad);
		PointDao daos = new PointDao();
		Point p = new Point();
		int as = daos.count(Wineshop_ID);
		if(as==0){
			p.setWineshop_ID(Wineshop_ID);
			p.setPoint_num(0);
			p.setPoint_last(Double.valueOf(aa).intValue());
			p.setPoint_Status("预支付");
			daos.add(p);
		}else{
			p.setPoint_last(Double.valueOf(aa).intValue());
			p.setPoint_Status("预支付");
			p.setWineshop_ID(Wineshop_ID);
			daos.updatefinishes(p);
		}
		PointDao daos1 = new PointDao();
		Point ps = new Point();
		List<Point> lists = daos1.findNumber(Wineshop_ID);
		int asss = 0;
		int ass = 0;
		for(Point p1 : lists){
			int as1 = p1.getPoint_num();
			ass = p1.getPoint_last();
			asss = as1+ass;
		}
		
		ps.setPoint_num(asss);
		ps.setPoint_last(ass);
		ps.setPoint_Status("支付完成");
		ps.setWineshop_ID(Wineshop_ID);
		daos.updatefinish(ps);
		
		
		PriceDao dao = new PriceDao();
		
		List<Price> list = dao.findUserByID2(Wineshop_ID);
		if(list.size()==1){
		for(Price price : list){
			int bb = price.getPrice_ID();
			float cc = price.getPrice_num();
			
			price.setPrice_num(Float.parseFloat(aa)+cc);
			price.setWineshop_ID(Wineshop_ID);
			price.setPrice_ID(bb);
			dao.update(price); 
		}
		}else{
			Price pp = new Price();
			pp.setPrice_num(Float.parseFloat(aa));
			pp.setWineshop_ID(Wineshop_ID);
			dao.add(pp);
		}

		
		
		  int Indent_ID = dao3.findID(Wineshop_ID);
		  
		  float z = dao3.za(Indent_ID);
		  if(z<=0){
			  
		  }else{
			  SBDao daa = new SBDao();
     		   List<SB> lis = daa.findAll(Wineshop_ID);
     		   String rp = null;
     		   for(SB s : lis){
     			   rp = s.getSB_Num();
     		   }
     		   float opp = Float.valueOf(rp);
     		   float xx = opp - z;
     		   DecimalFormat fnum = new DecimalFormat("##0.00");
     		   String x = fnum.format(xx);
     		   SB ss = new SB();
     		   ss.setSB_Num(x);
     		   ss.setWineshop_ID(Wineshop_ID);
     		   daa.update1(ss);
		  }
		  
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
				  number1 = greens.getGreens_Number();
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
		 order.setIndent_Status("正在处理");
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
			for(Greens green : list12){
				int Number = number1-number;
				green.setGreens_Number(Number);
				green.setGreens_ID(greens_ID);
				dao10.update1(green);
			}
		  }  
		  
			dao11.delete1(Wineshop_ID);
			if(list11.size()>0){
				PrintWriter out = response.getWriter();
				out.print(1);
				out.flush();
				out.close();
			}else{
				PrintWriter out = response.getWriter();
				out.print(0);
				out.flush();
				out.close();
			}
			
		  }

		
	}else{
		String name = request.getParameter("Wineshop_Name");
		float Greens_Price = Float.parseFloat(request.getParameter("SC"));
		float Fare = Float.parseFloat(request.getParameter("Fare"));
		String Indent_Remark = request.getParameter("Indent_Remark");//传过来的订单备注
		String aa = request.getParameter("total");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		WineshopDao dao1 = new WineshopDao();
		int Wineshop_ID = dao1.findUserByID2(name);
		System.out.println("Wineshop_id="+Wineshop_ID);
		int number1 = 0;
		
		CouponDao da = new CouponDao();
		RedDao daoss = new RedDao();
		Red r = new Red();
		r.setRed_Status("预使用");
		r.setRed_ID(yyy);
		daoss.update(r);
		List<Red> listq = daoss.findas(yyy);
		int oa = 0;
		int ob = 0;
		for(Red pl : listq){
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
		indent.setIndent_Status("正在处理");
		indent.setIndent_Type("记帐支付");
		indent.setIndent_remark(Indent_Remark);
		indent.setIndent_TuiKuan("");
		indent.setIndent_Why("");
		indent.setIndent_PayID("");
		indent.setIndent_PayType("支付成功");
		indent.setIndent_XXX("使用满" + oa + "返" + ob + "元赠送卷");
		indent.setIndent_Coupon(0);
		indent.setIndent_Red(yyy);
		indent.setIndent_QY(QY);
		indent.setIndent_ZZZ(zzz);
		dao3.add1000(indent);
		RedDao daoss1 = new RedDao();
			daoss1.delete(yyy);
		PointDao daos = new PointDao();
		Point p = new Point();
		int as = daos.count(Wineshop_ID);
		if(as==0){
			p.setWineshop_ID(Wineshop_ID);
			p.setPoint_num(0);
			p.setPoint_last(Double.valueOf(aa).intValue());
			p.setPoint_Status("预支付");
			daos.add(p);
		}else{
			p.setPoint_last(Double.valueOf(aa).intValue());
			p.setPoint_Status("预支付");
			p.setWineshop_ID(Wineshop_ID);
			daos.updatefinishes(p);
		}
		PointDao daos1 = new PointDao();
		Point ps = new Point();
		List<Point> lists = daos1.findNumber(Wineshop_ID);
		int asss = 0;
		int ass = 0;
		for(Point p1 : lists){
			int as1 = p1.getPoint_num();
			ass = p1.getPoint_last();
			asss = as1+ass;
		}
		
		ps.setPoint_num(asss);
		ps.setPoint_last(ass);
		ps.setPoint_Status("支付完成");
		ps.setWineshop_ID(Wineshop_ID);
		daos.updatefinish(ps);
		
		
		PriceDao dao = new PriceDao();
		
		List<Price> list = dao.findUserByID2(Wineshop_ID);
		if(list.size()==1){
		for(Price price : list){
			int bb = price.getPrice_ID();
			float cc = price.getPrice_num();
			price.setPrice_num(Float.parseFloat(aa)+cc);
			price.setWineshop_ID(Wineshop_ID);
			price.setPrice_ID(bb);
			dao.update(price); 
		}
		}else{
			Price pp = new Price();
			pp.setPrice_num(Float.parseFloat(aa));
			pp.setWineshop_ID(Wineshop_ID);
			dao.add(pp);
		}

		
		
		  int Indent_ID = dao3.findID(Wineshop_ID);
		  float z = dao3.za(Indent_ID);
		  if(z<=0){
			  
		  }else{
			  SBDao dad = new SBDao();
     		   List<SB> lis = dad.findAll(Wineshop_ID);
     		   String rp = null;
     		   for(SB s : lis){
     			   rp = s.getSB_Num();
     		   }
     		   float opp = Float.valueOf(rp);
     		   float xx = opp - z;
     		   DecimalFormat fnum = new DecimalFormat("##0.00");
     		   String x = fnum.format(xx);
     		   SB ss = new SB();
     		   ss.setSB_Num(x);
     		   ss.setWineshop_ID(Wineshop_ID);
     		   dad.update1(ss);
		  }
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
				  number1 = greens.getGreens_Number();
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
		 order.setIndent_Status("正在处理");
		 order.setOrder_Remark(order_Remark);
		 order.setGreens_Name(greens_Name);
		 order.setGreens_Unit(greens_Unit);
		 order.setIndent_Time(df1.format(new Date()));
		 order.setWineshop_ID(Wineshop_ID);
		 order.setGreens_Price(greens_price);
		 order.setGreens_Type_Name(Greens_Type_Name);
		 //order.setOrder_Text(Order_Text);
		 dao9.add(order);
		 
		 
		  }
			List<Greens> list12 = dao10.findUserByID(greens_ID);
			System.out.println("list12="+list12);
			for(Greens green : list12){
				int Number = number1-number;
				green.setGreens_Number(Number);
				green.setGreens_ID(greens_ID);
				dao10.update1(green);
			}
		  }  
		  
			dao11.delete1(Wineshop_ID);
			if(list11.size()>0){
				PrintWriter out = response.getWriter();
				out.print(1);
				out.flush();
				out.close();
			}else{
				PrintWriter out = response.getWriter();
				out.print(0); 
				out.flush();
				out.close();
			}
			  
		  }	
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
