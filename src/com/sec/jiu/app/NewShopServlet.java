package com.sec.jiu.app;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.NewDao;
import com.sec.entity.New;

/**
 * Servlet implementation class NewShopServlet
 */
@WebServlet("/NewShopServlet")
public class NewShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewShopServlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String wineshop_UserName = request.getParameter("username");
		String greens_name = request.getParameter("gname");
		String gmiaoshu = request.getParameter("gmiaoshu");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		New news = new New();
		news.setWineshop_UserName(wineshop_UserName);
		news.setGreens_Name(greens_name);
		news.setGreens_miaoshu(gmiaoshu);
		news.setNew_date(df.format(new Date()));
		NewDao dao = new NewDao();
		dao.add(news);
	}

}
