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
 * Servlet implementation class Success3
 */
@WebServlet("/Success3")
public class Success3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Success3() {
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
		//float a = Float.parseFloat(request.getParameter("total"));
		//System.out.println("a="+a);
		//float b = Float.parseFloat(request.getParameter("fare"));
		//System.out.println("b="+b);
		//float c = Float.parseFloat(request.getParameter("SC"));	
		//System.out.println("c="+c);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String name = request.getParameter("Wineshop_Name");
		System.out.println("name="+name);
		WineshopDao dao1 = new WineshopDao();
		int Wineshop_ID = dao1.findUserByID2(name);
		//System.out.println("Wineshop_id="+Wineshop_ID);
		CartDao dao = new CartDao();
		int number1 = 0;
		List<Cart> list = dao.findUserByID(Wineshop_ID);
		System.out.println("list="+list);
		for(Cart cart : list){
			int greens_ID = cart.getGreens_ID();
			System.out.println("Greens_ID="+greens_ID);
			int number = cart.getNumber();
			System.out.println("number="+number);
			GreensDao dao2 = new GreensDao();
			List<Greens> list2 = dao2.findUserByID(greens_ID);
			System.out.println("list2="+list2);
			for(Greens greens : list2){
				 number1 = greens.getGreens_Number();
				 System.out.println("number1="+number1);
				
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
