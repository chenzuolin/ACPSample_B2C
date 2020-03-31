package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sec.dao.OrderDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Order;
import com.sec.entity.shuliang;

/**
 * Servlet implementation class SS5Servlet3
 */
@WebServlet("/SS5Servlet3")
public class SS5Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SS5Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		
		String name1 = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		int a = dao.findUserByID2(name1);
		OrderDao dao1 = new OrderDao(); 
		List<shuliang> list = dao1.findAll12(a);
	        
		
		JSONArray json = JSONArray.fromObject(list);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		//System.out.println(map);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
