package com.sec.jiu.app;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.UappDao;
import com.sec.entity.Uapp;

/**
 * Servlet implementation class UpdateAppServlet
 */
@WebServlet("/UpdateAppServlet")
public class UpdateAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAppServlet() {
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
		SimpleDateFormat sd  =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sd.format(new Date());
		String appusername = request.getParameter("appusername");
		Uapp app = new Uapp();
		UappDao dao = new UappDao();
		app.setUtype("0");
		app.setUdate(time);
		app.setAppusername(appusername);
		dao.update(app);
	}

}
