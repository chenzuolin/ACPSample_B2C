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

import com.sec.dao.RedDao;
import com.sec.entity.Red;

/**
 * Servlet implementation class QWEServlet
 */
@WebServlet("/QWEServlet")
public class QWEServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QWEServlet() {
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
		int aa = Integer.parseInt(request.getParameter("id"));//w_id
		int bb = Integer.parseInt(request.getParameter("xzmoney"));//xz_id
		int cc = Integer.parseInt(request.getParameter("zsmoney"));//zs_id
		String dd = request.getParameter("time");
		int ee = Integer.parseInt(request.getParameter("num"));//
		String ff = request.getParameter("username");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		RedDao dao = new RedDao();
		Red r = new Red();
		r.setWineshop_ID(aa);
		r.setRed_Type("赠送券");
		r.setGive_Time(dd);
		r.setGive_Money(bb);
		r.setGive_Num(cc);
		r.setGive_Shijian(df1.format(new Date()));
		r.setGive_FZ(ff);
		for(int i=0;i<ee;i++){
		
		dao.adds(r);
		}
		PrintWriter out = response.getWriter();
		out.print("success");
		out.flush();
		out.close();
		
	}

}
