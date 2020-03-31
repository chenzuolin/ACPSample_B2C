package com.sec.controller;

import java.io.IOException;
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
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		float total = Float.parseFloat(request.getParameter("total"));//蔬菜价格
		request.getSession().setAttribute("total", total);
		float alltotal = Float.parseFloat(request.getParameter("alltotal"));//总价
		request.getSession().setAttribute("alltotal", alltotal);
		float fare = Float.parseFloat(request.getParameter("fare"));
		request.getSession().setAttribute("fare", fare);
		int aa = (Integer)request.getSession().getAttribute("id");
		String Indent_remark = request.getParameter("Indent_remark");//订单备注
		request.getSession().setAttribute("Indent_remark", Indent_remark);
		System.out.println(aa);
		WineshopDao dao = new WineshopDao();
		List<Wineshop> list = dao.findUserByID(aa);
		for(Wineshop wineshop : list) {
			String bb = wineshop.getWineshop_Nature();
			if(bb.contains("周结记帐")) {
				request.getRequestDispatcher("zhifu1.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("zhifu.jsp").forward(request, response);
			}
		}
		
	
	}
}
