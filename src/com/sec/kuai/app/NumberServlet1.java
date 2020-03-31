package com.sec.kuai.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sec.dao.CourierDao;
import com.sec.dao.Courier_WineshopDao;
import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Courier;
import com.sec.entity.Courier_Wineshop;
import com.sec.entity.Indent;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class NumberServlet1
 */
@WebServlet("/NumberServlet1")
public class NumberServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberServlet1() {
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
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		int size = 0;
		String name = request.getParameter("name");
		System.out.println("name="+name);
		CourierDao dao1 = new CourierDao();
		java.util.List<Courier> lsit1 = dao1.findUserByID4(name);
		System.out.println("lsit1="+lsit1);
		for(Courier courier : lsit1) {
			int Courier_ID = courier.getCourier_ID();
			Courier_WineshopDao dao2 = new Courier_WineshopDao();
			java.util.List<Courier_Wineshop> list2 = dao2.findUserByID(Courier_ID);
			System.out.println("list2="+list2);
			for(Courier_Wineshop cc : list2) {
				String wineshop_Name = cc.getAllot();
				WineshopDao dao3 = new WineshopDao();
				java.util.List<Wineshop> list3 = dao3.findUserByID5(wineshop_Name);
				System.out.println("list3="+list3);
				for(Wineshop wineshop : list3) {
					int Wineshop_ID = wineshop.getWineshop_ID();
					System.out.println("Wineshop_ID="+Wineshop_ID);
					IndentDao dao4 = new IndentDao();
					java.util.List<Indent> list4 = dao4.findUserByID66(Wineshop_ID);
					System.out.println("list4="+list4);
					size += list4.size();
					System.out.println("listµÄ´óÐ¡£º"+size);
				}
				
			}
		}
		JSONArray json = JSONArray.fromObject(size);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
