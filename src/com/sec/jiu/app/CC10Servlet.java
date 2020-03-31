package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CartDao;
import com.sec.dao.GreensDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;

/**
 * Servlet implementation class CC10Servlet
 */
@WebServlet("/CC10Servlet")
public class CC10Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CC10Servlet() {
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
		String aa =request.getParameter("name");//greens_name
		int bb = Integer.parseInt(request.getParameter("num"));
		String cc = request.getParameter("id");
		WineshopDao dao = new WineshopDao();
		int dd = dao.findUserByID2(cc);//JD_ID
		GreensDao dao1 = new GreensDao();
		int ee = dao1.findUserByID2(aa);//Greens_ID
		CartDao dao2 = new CartDao();
		int ff = dao2.findUserByID1(dd,ee);//Cart_ID
		Cart cart = new Cart();
		if(bb==0){
			dao2.delete(ff);
		}else{
			cart.setNumber(bb);
			cart.setCart_ID(ff);
			dao2.update1(cart);
		}
		PrintWriter out = response.getWriter();
		out.print(1);
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
