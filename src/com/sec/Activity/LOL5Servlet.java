package com.sec.Activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.WineshopDao;

/**
 * Servlet implementation class LOL5Servlet
 */
@WebServlet("/LOL5Servlet")
public class LOL5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LOL5Servlet() {
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
		String aa = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		SBDao daos = new SBDao();
		List<SB> list = daos.findAll(bb);
		for(SB s :list){
			String cc = s.getSB_Num();
			String dd = s.getNum_one();
			if(Float.parseFloat(cc)>=Float.parseFloat(dd)){
				PrintWriter out = response.getWriter();
				out.print(0);
				out.flush();
				out.close();
			}else{
				PrintWriter out = response.getWriter();
				out.print(1);
				out.flush();
				out.close();
			}
		}
	}

}
