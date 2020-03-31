package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

/**
 * Servlet implementation class SCCXServlet
 */
@WebServlet("/SCCXServlet")
public class SCCXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SCCXServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		GreensDao dao = new GreensDao();
		List<Greens> a=dao.findAll();
		System.out.println(a);
		if(a != null){
			request.getSession().setAttribute("greens1", a);
			request.getRequestDispatcher("GreensSelect.jsp").forward(request, response);
			//for(Greens greens : a){
			//	out.println(greens.getGreens_ID()+"-"+greens.getGreens_Name()+"-"+greens.getGreens_Unit()+"-"+greens.getGreens_Character()+"-"+greens.getGreens_Preiod()+"-"+greens.getGreens_Norms()+"-"+greens.getGreens_Number()+"-"+greens.getGreens_Price()+"-"+greens.getGreens_Market_Price()+"-"+greens.getGreens_Condition()+"-"+greens.getGreens_Minnumber()+"-"+greens.getGreens_Class()+"-"+greens.getGreens_Grade()+"-"+greens.getGreens_characteristics()+"-"+greens.getGreens_Recommend()+"-"+greens.getGreens_Remark()+";");
			//}
		}
		//out.flush();
		//out.close();
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
}
