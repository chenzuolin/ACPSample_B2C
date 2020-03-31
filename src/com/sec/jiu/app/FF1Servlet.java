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

import com.sec.dao.CommonlyDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Commonly;

/**
 * Servlet implementation class FF1Servlet
 */
@WebServlet("/FF1Servlet")
public class FF1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FF1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		int aa = Integer.parseInt(request.getParameter("id"));
		String bb = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		List<Integer> lists1 = new ArrayList<Integer>();
		int cc = dao.findUserByID2(bb);
		Commonly commonly = new Commonly();
		CommonlyDao dao2 = new CommonlyDao();
		List<Commonly> lists = dao2.findUserByID(cc);
		if(lists == null){
			commonly.setGreens_ID(aa);
			commonly.setWineshop_ID(cc);
			dao2.add(commonly);
			PrintWriter out = response.getWriter();
			out.print(1);
			out.flush();
			out.close();
		}else{
			for(Commonly xx : lists){
				int dd = xx.getGreens_ID();
				lists1.add(dd);
			}
			if(lists1.contains(aa)){
				PrintWriter out = response.getWriter();
				out.print(0);
				out.flush();
				out.close();
			}else{
				commonly.setGreens_ID(aa);
				commonly.setWineshop_ID(cc);
				dao2.add(commonly);
				PrintWriter out = response.getWriter();
				out.print(1);
				out.flush();
				out.close();
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
