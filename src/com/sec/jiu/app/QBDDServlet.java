package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sec.dao.GreensDao;
import com.sec.dao.OrderDao;
import com.sec.entity.AAA;
import com.sec.entity.Greens;
import com.sec.entity.Order;
import com.sec.entity.aa;

/**
 * Servlet implementation class QBDDServlet
 */
@WebServlet("/QBDDServlet")
public class QBDDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QBDDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		List<AAA> lists = new ArrayList<AAA>();
		OrderDao dao = new OrderDao();
		int a = Integer.parseInt(request.getParameter("id"));
		List<Order> list = dao.findUserByID1(a);
		for(Order order : list) {
			GreensDao dao1 = new GreensDao();
			int aa = order.getGreens_ID();
			int Order_ID =order.getOrder_ID();
			int bb = order.getNumber();
			float dd = order.getGreens_Price();
			List<Greens> list1 = dao1.findUserByID(aa);
			for(Greens greens : list1) {
				String cc = greens.getGreens_Name();
				//Float dd = greens.getGreens_Price();
				String ee = greens.getGreens_Unit();
				int pp = greens.getGreens_Price_Num();
				AAA text = new AAA();
				text.setAa(pp);
				text.setBb(cc);
				text.setCc(bb);
				text.setDd(ee);
				text.setOrder_ID(Order_ID);
				lists.add(text);
			}
		}
		 	JSONArray json = JSONArray.fromObject(lists);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
	
	}

}
