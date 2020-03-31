package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CartDao;
import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.TotalDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.Total;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class Success1
 */
@WebServlet("/Success1")
public class Success1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Success1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		int a0 = 0;
		float a = Float.parseFloat(request.getParameter("total"));
		//System.out.println("a="+a);
		float b = Float.parseFloat(request.getParameter("fare"));
		//System.out.println("b="+b);
		float c = Float.parseFloat(request.getParameter("SC"));	
		//System.out.println("c="+c);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String name = request.getParameter("Wineshop_Name");
		//System.out.println("name="+name);
		WineshopDao dao1 = new WineshopDao();
		int Wineshop_ID = dao1.findUserByID2(name);
		//System.out.println("Wineshop_id="+Wineshop_ID);
		CartDao dao = new CartDao();
		int number1 = 0;
		List<Cart> list = dao.findUserByID(Wineshop_ID);
		//System.out.println("list="+list);
		for(Cart cart : list){
			int greens_ID = cart.getGreens_ID();
			//System.out.println("Greens_ID="+greens_ID);
			int number = cart.getNumber();
			//System.out.println("number="+number);
			GreensDao dao2 = new GreensDao();
			List<Greens> list2 = dao2.findUserByID(greens_ID);
			//System.out.println("list2="+list2);
			for(Greens greens : list2){
				 number1 = greens.getGreens_Number();
				// System.out.println("number1="+number1);
				
			}
			if(number>number1){
				a0 = 1;
			}else{
				
			}
		}
		if(a0==1){
			PrintWriter out = response.getWriter();
			out.print(0);
			out.flush();
			out.close();
		}else{
		List<Wineshop> list4 = dao1.findUserByID(Wineshop_ID);
		for(Wineshop wineshop : list4){
			String wineshop_Address = wineshop.getWineshop_Address();
			String wineshop_Telephone = wineshop.getWineshop_Telephone();
		IndentDao dao3 = new IndentDao();
		Indent indent = new Indent();
		indent.setIndent_Time(df.format(new Date()));
		indent.setIndent_Distribution_Time("");
		indent.setWineshop_ID(Wineshop_ID);
		indent.setWineshop_Address(wineshop_Address);
		indent.setIndent_Fare("");
		indent.setIndent_Check_Type("0");
		indent.setWineshop_Telephone(wineshop_Telephone);
		indent.setIndent_Status("���ڴ���");
		dao3.add(indent);
		  int Indent_ID = dao3.findID();
		  TotalDao dao5 = new TotalDao();
		  Total total = new Total();
		  total.setIndent_ID(Indent_ID);
		  total.setTotal(a);
		  total.setFare(b);
		  total.setGreens(c);
		  dao5.add(total);
		  
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
				  float greeen_price = greens.getGreens_Price();
				  
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
		 order.setIndent_Time(df.format(new Date()));
		 order.setWineshop_ID(Wineshop_ID);
		 order.setGreens_Price(greeen_price);
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
		  }
		
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();
		}
		}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
