package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CartDao;
import com.sec.dao.GreensDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.Greens;

/**
 * Servlet implementation class CC9Servlet
 */
@WebServlet("/CC9Servlet")
public class CC9Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CC9Servlet() {
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
		String aa =request.getParameter("name");//Wineshop_Name
		int bb = Integer.parseInt(request.getParameter("num"));
		String cc = request.getParameter("id");
		WineshopDao dao = new WineshopDao();
		int dd = dao.findUserByID2(cc);//JD_ID
		GreensDao dao1 = new GreensDao();
		int ee = dao1.findUserByID2(aa);//Greens_ID
		List<Greens> list = dao1.findUserByID(ee);
		int af = 0;
		for(Greens g : list){
			af = g.getGreens_Number();
		}
		if(af>0){
			
		
		CartDao dao2 = new CartDao();
		int ff = dao2.findUserByID1(dd,ee);
		Cart cart = new Cart();
		if(ff==0){
			cart.setWineshop_ID(dd);
			cart.setGreens_ID(ee);
			cart.setNumber(bb);
			cart.setRemark(null);
			dao2.add(cart);
		}else{
			cart.setNumber(bb);
			cart.setCart_ID(ff);
			dao2.update1(cart);
		}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
