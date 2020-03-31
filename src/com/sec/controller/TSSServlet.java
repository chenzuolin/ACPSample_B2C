package com.sec.controller;

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
import com.sec.entity.Complainant;

/**
 * Servlet implementation class TSSServlet
 */
@WebServlet("/TSSServlet")
public class TSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TSSServlet() {
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
		String bb = request.getParameter("remarks");
		int cc = (Integer)request.getSession().getAttribute("id");
		ComplainantDao dao = new ComplainantDao();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Complainant complainant = new Complainant();
		complainant.setComplainant_Content(bb);
		complainant.setComplainant_Type(aa);
		complainant.setComplainant_Time(df.format(new Date()));
		complainant.setWineshop_ID(cc);
		dao.add(complainant);
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>alert('投诉成功！');window.location.href='tousu.jsp'</script>");
		//request.getRequestDispatcher("ts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
