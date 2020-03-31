package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CommonlyDao;
import com.sec.entity.Commonly;

/**
 * Servlet implementation class CYServlet
 */
@WebServlet("/CYServlet")
public class CYServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CYServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bb = Integer.parseInt(request.getParameter("bb"));//¾Æµê±àºÅ
		int aa = Integer.parseInt(request.getParameter("aa"));//Êß²Ë±àºÅ
		Commonly commonly = new Commonly();
		commonly.setGreens_ID(bb);
		commonly.setWineshop_ID(aa);
		CommonlyDao dao = new CommonlyDao();
		dao.add(commonly);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
