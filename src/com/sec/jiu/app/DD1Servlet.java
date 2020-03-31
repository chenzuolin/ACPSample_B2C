package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
 * Servlet implementation class DD1Servlet
 */
@WebServlet("/DD1Servlet")
public class DD1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DD1Servlet() {
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
		float total = 0;
		float total1 = 0;
		float num2 = 0;
		String aa = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		CartDao dao1 = new CartDao();
		List<Cart> list = dao1.findUserByID(bb);
		for(Cart cart : list) {
			float ff = 0;
			int cc = cart.getNumber();
			int dd = cart.getGreens_ID();
			GreensDao dao2 = new GreensDao();
			List<Greens> list1 = dao2.findUserByID(dd);
			for(Greens greens : list1) {
				float ee = greens.getGreens_Price();
				ff = cc*ee;
				num2 = (float)(Math.round(ff*100))/100;//小计小数点后面保留一位
			}
			total += num2;
			total1 = (float)(Math.round(total*100))/100;
		}
		PrintWriter out = response.getWriter();
		out.print(total1);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
