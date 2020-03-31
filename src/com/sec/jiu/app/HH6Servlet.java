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

import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;

/**
 * Servlet implementation class HH6Servlet
 */
@WebServlet("/HH6Servlet")
public class HH6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HH6Servlet() {
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
		String bb = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		int cc = dao.findUserByID2(bb);
		IndentDao daos = new IndentDao();
		SimpleDateFormat df = new SimpleDateFormat("HHmm");
		String time = df.format(new Date());
    	if(Integer.parseInt(time) > 1800 && Integer.parseInt(time) < 2400){
    		float dd = daos.oo1(cc);
    			PrintWriter out = response.getWriter();
    			out.print(dd);
    			out.flush();
    			out.close();
    	}else{
    		float ee = daos.oo2(cc);
    			PrintWriter out = response.getWriter();
    			out.print(ee);
    			out.flush();
    			out.close();
    		
    	}
		
		
	}

}
