package com.sec.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.entity.Indent;

/**
 * Servlet implementation class CourierStatusServlet
 */
@WebServlet("/CourierStatusServlet")
public class CourierStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourierStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		IndentDao dao = new IndentDao();
		List<Indent> list = dao.findUserByID(id);
		
		for(Indent indents : list){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int b = indents.getWineshop_ID();
			String c = indents.getWineshop_Address();
			String d = indents.getWineshop_Telephone();
			String e = indents.getIndent_Status();
			Indent indent = new Indent();
			indent.setIndent_Distribution_Time(df.format(new Date()));
			indent.setWineshop_ID(b);
			indent.setWineshop_Address(c);
			indent.setWineshop_Telephone(d);
			indent.setIndent_Status("配送中");
			indent.setIndent_ID(id);
			dao.update(indent);
			
			
			}
		
		
		
		
		
		/*IndentDao dao=new IndentDao();
		Indent indent=new Indent();
		
		indent.setIndent_Distribution_Time(Indent_Distribution_Time);
		indent.setWineshop_ID(Wineshop_ID);
		indent.setWineshop_Address(Wineshop_Address);
		indent.setWineshop_Telephone(Wineshop_Telephone);
		indent.setIndent_Status("正在派送的");
		indent.setIndent_ID(id);
		
		
		
		dao.update(indent);*/
	}

	}

