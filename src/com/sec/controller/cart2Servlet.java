package com.sec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import com.sec.entity.Wineshop;

import cn.itsource.pay.servlet.EntCoordSyncJob;

/**
 * Servlet implementation class cart2Servlet
 */
@WebServlet("/cart2Servlet")
public class cart2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    EntCoordSyncJob aa = new EntCoordSyncJob();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int xx = (Integer)request.getSession().getAttribute("id");
		WineshopDao dao3 = new WineshopDao();
		String c = null;
		List<Wineshop> lists = dao3.findUserByID(xx);
		for(Wineshop wineshop : lists) {
			c = wineshop.getWineshop_Address();
			System.out.println(c);
		}
		String cc = aa.getCoordinate(c);
		System.out.println(cc);
		String dd = "甘肃省兰州市城关区绿色市场";
		String hh = aa.getCoordinate(dd);
		System.out.println(hh);
		Long ee = aa.getDistance(cc,hh);
		System.out.println(ee);
		Long ff = ee/1000;
		System.out.println(ff);
		GreensDao dao = new GreensDao();
		CartDao dao1 = new CartDao();
		List<Cart> list2 = dao1.findAll();
		//得到购物车的所有信息
		for(Cart cart : list2) {
			
			if(cart.getWineshop_ID()==xx) {
			//判断订单是否为当前酒店下的单
			List<Greens> list1 = dao.findUserByID(cart.getGreens_ID());
			/*JSONArray json = JSONArray.fromObject(list1);
			response.getWriter().write(json.toString()); */
			
				request.setAttribute("list2", list2);
				request.setAttribute("list1", list1);
			

		}
		}
		RequestDispatcher tr=request.getRequestDispatcher("cart.jsp?fare="+ff+"");
		try{
			tr.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
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
