package com.sec.jiu.app;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.SumDao;
import com.sec.entity.Sum;

/**
 * Servlet implementation class SumServlet
 */
@WebServlet("/SumServlet")
public class SumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-hh HH:mm:ss");
		String name = request.getParameter("gname");
		SumDao sum = new SumDao();
		int check = sum.check(name);
		int number = 1;
		if(check!=0){
			int count = sum.count(name);
			count += +1;
			Sum ss = new Sum();
			ss.setGreens_Name(name);
			ss.setSum_number(count);
			sum.update(ss);
			response.sendRedirect("NewPageServlet");
			
		}else{
			SumDao sum1 = new SumDao();
			Sum ss = new Sum();
			ss.setGreens_Name(name);
			ss.setSum_date(df.format(new Date()));
			ss.setSum_number(number);
			sum1.add(ss);
			response.sendRedirect("NewPageServlet");
		}
	}

}
