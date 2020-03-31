package com.sec.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.gexin.fastjson.JSON;
import com.sumeng.page.Page;
import com.sumeng.page.QueryRunnerSelect;
import com.sumeng.web.IndentDao;

/**
 * Servlet implementation class MaxWhereSelect
 */
@WebServlet("/MaxWhereSelect")
public class MaxWhereSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaxWhereSelect() {
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
		Map<String,String[]> map = request.getParameterMap();
//		Set<Entry<String, String[]>> set = map.entrySet(); 
//		Iterator<Entry<String, String[]>> it = set.iterator(); 
//		while (it.hasNext()) { 
//		Entry<String, String[]> entry = it.next(); 
//		System.out.println("KEY="+entry.getKey()); 
//		for (String i : entry.getValue()) { 
//		System.out.println("value="+i); 
//		} 
//		}
		String currentPage = request.getParameter("currentPage");
		int size = Integer.parseInt(request.getParameter("size"));
		int currPage = 1;
		if(currentPage != null) {
			currPage = Integer.parseInt(currentPage);
		}
		QueryRunnerSelect qr = new QueryRunnerSelect();
		try {
			BeanUtils.populate(qr, map);
			System.out.println(qr.toString());
			
			IndentDao dao = new IndentDao();
			Page pageCount = dao.numberCount(qr, currPage, size);
			Page pageData = dao.numberSelect(qr, currPage, pageCount, size);
			Object json = JSON.toJSON(pageData);
			response.getWriter().print(json);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
	}

}
