package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CartDao;
import com.sec.entity.Cart;

/**
 * Servlet implementation class JoincartServlet6
 */
@WebServlet("/JoincartServlet6")
public class JoincartServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoincartServlet6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String ll = request.getParameter("v");//��ƷҪ��
		int id = Integer.parseInt(request.getParameter("id"));//��Ʒ����
		int cc = Integer.parseInt(request.getParameter("x"));//��Ʒ���
		int xx = (Integer)request.getSession().getAttribute("id");//�Ƶ���
			Cart cart = new Cart();
			CartDao dao = new CartDao();
			cart.setWineshop_ID(xx);
			cart.setGreens_ID(cc);
			cart.setNumber(id);
			cart.setRemark(ll);
			dao.add(cart);
			
	}
	}


