package com.sec.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.ConsultDao;
import com.sec.entity.Consult;

/**
 * Servlet implementation class UpdateConsultById
 */
@WebServlet("/UpdateConsultById")
public class UpdateConsultById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConsultById() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String content = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		int userId = (Integer)request.getSession().getAttribute("w");
		Consult conn = new Consult();
		conn.setConsult_ID(id);
		conn.setConsult_Time(time);
		conn.setContent(content);
		conn.setUser_ID(userId);
		ConsultDao dao = new ConsultDao();
		int code = dao.updateById(conn);
		response.getWriter().print(code);
	}

}
