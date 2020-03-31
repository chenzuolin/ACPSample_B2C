package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CourierDao;
import com.sec.dao.Courier_WineshopDao;
import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Courier;
import com.sec.entity.Courier_Wineshop;
import com.sec.entity.Indent;

/**
 * Servlet implementation class CC12Servlet
 */
@WebServlet("/CC12Servlet")
public class CC12Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CC12Servlet() {
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
		String aa = request.getParameter("name");
		CourierDao dao1 = new CourierDao();
		java.util.List<Courier> list = dao1.findUserByID4(aa);
		for(Courier courier : list) {
			int bb = courier.getCourier_ID();
			Courier_WineshopDao dao = new Courier_WineshopDao();
			java.util.List<Courier_Wineshop> list1 = dao.findUserByID(bb);
			for(Courier_Wineshop courier_Wineshop : list1) {
				String zz = courier_Wineshop.getAllot();
				WineshopDao dao5 = new WineshopDao();
				int cc = dao5.findUserByID3(zz);
				IndentDao dao3 = new IndentDao();
				java.util.List<Indent> list3 = dao3.findUserByID11(cc);
				if(list3.size()>0) {
					PrintWriter out = response.getWriter();
					out.print(1);
					out.flush();
					out.close();	
				}else {
					PrintWriter out = response.getWriter();
					out.print(0);
					out.flush();
					out.close();	
				}
				
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
