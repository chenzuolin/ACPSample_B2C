package com.sec.jiu.app;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.FZDao;
import com.sec.dao.IndentDao;
import com.sec.entity.FZ;
import com.sec.entity.Indent;

/**
 * Servlet implementation class PeiSongWanCheng1Servlet
 */
@WebServlet("/PeiSongWanCheng1Servlet")
public class PeiSongWanCheng1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeiSongWanCheng1Servlet() {
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
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		int id = Integer.parseInt(request.getParameter("id"));
		String address = request.getParameter("address");
		String name = request.getParameter("username");
		IndentDao dao1 = new IndentDao();
		Indent indent = new Indent();
		indent.setCourier_BS(1);
		indent.setIndent_ID(id);
		dao1.updatess2(indent);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		FZ dd = new FZ();
		dd.setFinish_time(time);
		dd.setAddress(address);
		dd.setIndent_ID(id);
		FZDao dao = new FZDao();
		dao.updatefinish(dd);
	}

}
