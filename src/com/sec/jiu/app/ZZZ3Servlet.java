package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.entity.Indent;

/**
 * Servlet implementation class ZZZ3Servlet
 */
@WebServlet("/ZZZ3Servlet")
public class ZZZ3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZZZ3Servlet() {
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
		int bb = Integer.parseInt(request.getParameter("id"));
		IndentDao dao = new IndentDao();
		String cc = dao.findZZ0(bb);
		if(cc==null){
			Indent indent = new Indent();
			indent.setCourier_Name(aa);
			indent.setCourier_BS(0);
			dao.updatessZZ(indent);
			PrintWriter out = response.getWriter();
			out.print(1);
			out.flush();
			out.close();
		}else{
			PrintWriter out = response.getWriter();
			out.print(2);
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
