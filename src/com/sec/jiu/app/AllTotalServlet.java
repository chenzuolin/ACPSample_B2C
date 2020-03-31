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
import com.sec.entity.Indent;
import com.sec.entity.Total;

/**
 * Servlet implementation class AllTotalServlet
 */
@WebServlet("/AllTotalServlet")
public class AllTotalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllTotalServlet() {
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
		
		
		float z = 0;//查新所有酒店今天的总销售额
		IndentDao dao = new IndentDao();
		List<Indent> list = dao.findUserByID0();
		for(Indent indent : list){
			int a = indent.getIndent_ID();
			TotalDao dao1 = new TotalDao();
			List<Total> list1 = dao1.findUserByID1(a);
			for(Total total : list1){
				float b = total.getTotal();
				System.out.println(b);
				z+=b;
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
		doGet(request,response);
	}

}
