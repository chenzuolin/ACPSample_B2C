package com.sec.Activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sec.dao.CGDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.WineshopDao;
import com.sec.dao.XLFPDao;
import com.sec.dao.XianZhiDao;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.PPP;
import com.sec.entity.Wineshop;
import com.sec.entity.XLFP;
import com.sumeng.page.Page;

/**
 * Servlet implementation class OLO5Servlet
 */
@WebServlet("/OLO5Servlet")
public class OLO5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OLO5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String currentPage = request.getParameter("currentPage");
		int size = Integer.parseInt(request.getParameter("size"));
		int sa = (Integer)request.getSession().getAttribute("GHS");
		CGDao daa = new CGDao();
		String db = daa.findUserByIDs(sa);
		IndentDao dao = new IndentDao();
		List<Indent> list = dao.findallGHS(currentPage, size, db);
		List<Indent> listss = dao.findallGHS2(db);
		int currPage = 1;
		if(currentPage != null) {
			currPage = Integer.parseInt(currentPage);
		}
		int ds = listss.size();
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
		page.setData(list);
		Object json2 = JSON.toJSON(page);
		PrintWriter out = response.getWriter();
		out.print(json2);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
