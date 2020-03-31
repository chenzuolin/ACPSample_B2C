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

import com.sec.dao.ComplainantDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Complainant;

/**
 * Servlet implementation class TSSServlet11
 */
@WebServlet("/TSSServlet11")
public class TSSServlet11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TSSServlet11() {
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
		String aa = request.getParameter("Complainant_Type");
		String bb = request.getParameter("question");
		String cc =request.getParameter("a");
		WineshopDao dao = new WineshopDao();
		int a=dao.findUserByID2(cc);
		ComplainantDao dao1 = new ComplainantDao();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Complainant complainant = new Complainant();
		complainant.setComplainant_Content(bb);
		complainant.setComplainant_Type(aa);
		complainant.setComplainant_Time(df.format(new Date()));
		complainant.setWineshop_ID(a);
		String m=dao1.add(complainant);
		PrintWriter out = response.getWriter();
		out.print(m);
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
