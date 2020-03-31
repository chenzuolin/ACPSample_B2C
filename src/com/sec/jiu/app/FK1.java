package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.FedbackDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Fedback;

/**
 * Servlet implementation class FK1
 */
@WebServlet("/FK1")
public class FK1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FK1() {
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
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		String a = request.getParameter("wineshop_ID");//酒店名称
		WineshopDao dao1 = new WineshopDao();
		int c =dao1.findUserByID3(a);//酒店ID
		String b = request.getParameter("Fedback_Content");
		System.out.println(a);
		System.out.println(b);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Fedback fedback = new Fedback();
		FedbackDao dao = new FedbackDao();
		fedback.setFedback_Content(b);
		fedback.setWineshop_ID(c);
		
		fedback.setFedback_Time(df.format(new Date()));
		dao.add(fedback);
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
