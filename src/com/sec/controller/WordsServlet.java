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

import com.sec.dao.WordsDao;
import com.sec.entity.Words;

/**
 * Servlet implementation class WordsServlet
 */
@WebServlet("/WordsServlet")
public class WordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordsServlet() {
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
		response.setCharacterEncoding("utf-8");
		String type = "待处理";
		int Wineshop_ID = (Integer)request.getSession().getAttribute("id");
		System.out.println("Wineshop="+Wineshop_ID);
		String title = request.getParameter("title");
		String content = request.getParameter("desc");
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		String time = df.format(date);
		Words words = new Words();
		words.setWineshop_id(Wineshop_ID);
		words.setWords_title(title);
		words.setWords_time(time);
		words.setWords_type(type);
		words.setWords_content(content);
		WordsDao dao = new WordsDao();
		dao.add(words);
		PrintWriter out = response.getWriter();
		out.print("<script langage='javascript'>alert('留言成功！');window.location.href='lunbo.jsp'</script>");

	}

}
