package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class rifenxiServlet
 */
@WebServlet("/rifenxiServlet")
public class rifenxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rifenxiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("textml,utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String name = request.getParameter("name");
		float total = 0;
		float z = 0;
		WineshopDao dao1 = new WineshopDao();
		OrderDao dao3 = new OrderDao();
		int a = dao1.findUserByID2(name);
		IndentDao dao = new IndentDao();
		List<Indent> list = dao.findUserByID00(a);
		for(Indent indent : list) {
			int aa = indent.getIndent_ID();
			List<Order> list1=dao3.findUserByID1(aa);
			System.out.print(list1);
			for(Order order:list1){
				int Greens_ID=order.getGreens_ID();
				int Number=order.getNumber();
				System.out.print(Greens_ID);
				GreensDao dao2=new GreensDao();
				List<Greens> list2=dao2.findUserByID(Greens_ID);
				System.out.print(list2);
				for(Greens greens:list2){
					float Greens_Market_Price=greens.getGreens_Market_Price();
					float aaa=Greens_Market_Price*Number;
					float Greens_Price=greens.getGreens_Price();
					float bb=Greens_Price*Number;
					float totle=aaa-bb;
					total+=totle;
					z = (float)(Math.round(total*100))/100;
				}
			}
			
		}
		//System.out.println(total);
		
		
		
		
		PrintWriter out = response.getWriter();
		out.print(z);
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
