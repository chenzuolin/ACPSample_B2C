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
 * Servlet implementation class SS1Servlet
 */
@WebServlet("/SS1Servlet")
public class SS1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SS1Servlet() {
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
		
		String b1 = request.getParameter("name");
		WineshopDao dao6 = new WineshopDao();
		int a = dao6.findUserByID2(b1);
		float cc = 0;
		float z = 0;
		IndentDao dao = new IndentDao();
		List<Indent> list = dao.findUserByID00(a);
		for(Indent indent : list){
			int b = indent.getIndent_ID();
			TotalDao dao1 = new TotalDao();
			List<Total> list1 = dao1.findUserByID1(b);
			//System.out.println(list1);
			for(Total  total : list1){
				float c = total.getTotal();
				cc+=c;
				z = (float)(Math.round(cc*100))/100;
			}
		}
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
	}

}
