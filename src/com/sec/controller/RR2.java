package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CommonlyDao;
import com.sec.entity.Commonly;

/**
 * Servlet implementation class RR2
 */
@WebServlet("/RR2")
public class RR2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RR2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int bbb = Integer.parseInt(request.getParameter("id1"));
		int aaa = (Integer)request.getSession().getAttribute("id");
		PrintWriter out = response.getWriter();
		List<Integer> list1 = new ArrayList<Integer>();
		CommonlyDao dao = new CommonlyDao();
		Commonly commonly = new Commonly();
		List<Commonly> list = dao.findUserByID(aaa);
		if(list == null){
			commonly.setGreens_ID(bbb);
			commonly.setWineshop_ID(aaa);
			dao.add(commonly);
			out.print("<script langage='javascript'>window.location.href='CY.jsp'</script>");
		}else{
	
		for(Commonly y : list){
			int aa = y.getGreens_ID();
			list1.add(aa);
			
		}
		if(list1.contains(bbb)){
			out.print("<script>alert('ÇëÎðÖØ¸´Ìí¼Ó!');</script>");
			out.print("<script langage='javascript'>window.location.href='CY.jsp'</script>");
		
		
		
		}else{
			commonly.setGreens_ID(bbb);
			commonly.setWineshop_ID(aaa);
			dao.add(commonly);
			out.print("<script langage='javascript'>window.location.href='CY.jsp'</script>");
		}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
