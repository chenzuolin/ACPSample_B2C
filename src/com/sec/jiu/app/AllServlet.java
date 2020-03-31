package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class AllServlet
 */
@WebServlet("/AllServlet")
public class AllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		
		String name = request.getParameter("a");
		String name1 = request.getParameter("b");
		int ee =0;//查询蔬菜的历史总记录
		GreensDao dao2 = new GreensDao();
		int aa = dao2.findUserByID2(name1);//根据蔬菜名查询蔬菜编号
		WineshopDao dao =new WineshopDao();
		int a = dao.findUserByID3(name);//根据酒店名查询酒店编号
		IndentDao dao1 = new IndentDao();
		List<Indent> list = dao1.findUserByID10(a);//根据酒店编号查询订单
		for(Indent indent : list){//循环该酒店的所有订单
			int c = indent.getIndent_ID();
			OrderDao dao3 = new OrderDao();
			List<Order> list1 = dao3.findUserByID1(c);//根据订单查询详细订单
			for(Order order : list1){  
				int d = order.getGreens_ID();
				if(aa==d){
					int e = order.getNumber();  
					System.out.println(e);
					ee+=e;
				}
			}
		}
		PrintWriter out = response.getWriter();
		out.print(ee);
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
