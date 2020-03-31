package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.FJDao;
import com.sec.dao.IndentDao;
import com.sec.entity.FJ;
import com.sec.entity.Indent;

/**
 * Servlet implementation class FF4Servlet
 */
@WebServlet("/FF4Servlet")
public class FF4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FF4Servlet() {
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
		int bb = Integer.parseInt(request.getParameter("id"));
		FJDao dao = new FJDao();
		IndentDao dao1 = new IndentDao();
		List<FJ> list = dao.findUserByID1(aa);
		for(FJ fj : list){
			String cc = fj.getFJ_Name();
			String dd = dao1.findFZ0(bb);
			if(dd==null){
				Indent indent  = new Indent();
				indent.setFZ_Name(cc);
				indent.setFZ_BS(0);
				indent.setIndent_ID(bb);
				dao1.updatess1(indent);
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
	}
}
