package com.sec.Activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sec.dao.CGDao;
import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.entity.CG;
import com.sec.entity.Greens;
import com.sumeng.page.Page;

/**
 * Servlet implementation class OLO8Servlet
 */
@WebServlet("/OLO8Servlet")
public class OLO8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OLO8Servlet() {
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
		String currentPage = request.getParameter("currentPage");
		int size = Integer.parseInt(request.getParameter("size"));
		int aa = 1;
		CGDao dao = new CGDao();
		List<CG> list = dao.findUserByIDss(aa);
		String bb = null;
		for(CG c : list){
			bb = c.getCG_UserName();
		}
		GreensDao daos = new GreensDao();
		List<Greens> list1 = daos.olss(currentPage,size,bb);
		Collections.sort(list1);
		
		
		int currPage = 1;
		if(currentPage != null) {
			currPage = Integer.parseInt(currentPage);
		}
		int ds = list1.size();
		int totalPage = 0;
		if(ds%size==0) {
			totalPage = ds/size;
		}else {
			totalPage = ds/size+1;
		}
		Page page = new Page();
		page.setCount(ds);
		page.setTotalPage(totalPage);
		page.setCurrentPage(currPage);
		page.setData(list1);
		Object json2 = JSON.toJSON(page);
		PrintWriter out = response.getWriter();
		out.print(json2);
		out.flush();
		out.close();
		
	}

}
