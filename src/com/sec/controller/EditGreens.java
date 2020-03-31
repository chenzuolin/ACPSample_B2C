package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_TypeDao;
import com.sec.entity.Greens_Type;

/**
 * Servlet implementation class EditGreens
 */
@WebServlet("/EditGreens")
public class EditGreens extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGreens() {
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
		int parameter =Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String bigType = request.getParameter("bigName");
		Greens_Type cc = new Greens_Type();
		cc.setGreens_BigTypeName(bigType);
		cc.setGreens_Type_Name(name);
		cc.setGreens_Type_ID(parameter);
		Greens_TypeDao dao = new Greens_TypeDao();
		dao.updateGreensType(cc);
	}

}
