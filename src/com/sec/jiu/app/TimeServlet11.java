package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.TotalDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.Total;

/**
 * Servlet implementation class TimeServlet11
 */
@WebServlet("/TimeServlet11")
public class TimeServlet11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeServlet11() {
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
		
		
		float z = 0;
		float o = 0;
		//按照时间查询所选择酒店的销售量
		String a =request.getParameter("demo4");
		String b = request.getParameter("demo5");
		String c = request.getParameter("Wineshop_Name");
		WineshopDao dao =new WineshopDao();
		int aa = dao.findUserByID3(c);
		IndentDao dao1 = new IndentDao();
		List<Indent> list = dao1.findUserByID5(a, b);
		for(Indent indent : list){
			int bb = indent.getWineshop_ID();
			if(aa==bb){
				TotalDao dao2 = new TotalDao();
				int dd = indent.getIndent_ID();
				List<Total> list2=dao2.findUserByID1(dd);
				for(Total total : list2){
					float zz = total.getTotal();
					z+=zz;
					 o = (float)(Math.round(z*100))/100;
					
				}
			}
		}
		PrintWriter out = response.getWriter();
		out.print(o);
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
