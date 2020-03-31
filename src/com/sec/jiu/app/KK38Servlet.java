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

import com.sec.dao.CourierDao;
import com.sec.dao.Courier_WineshopDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Courier;
import com.sec.entity.Courier_Wineshop;

/**
 * Servlet implementation class KK38Servlet
 */
@WebServlet("/KK38Servlet")
public class KK38Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KK38Servlet() {
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
		String aa = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		System.out.println("Ws_id="+bb);
		String cc = dao.findUserByID111(bb);
		System.err.println("ws_name="+cc);
		Courier_WineshopDao dao1 = new Courier_WineshopDao();
		int id = dao1.check(cc);
		CourierDao dao2 = new CourierDao();
		List<Courier> lists = dao2.findUserByID2(id);
		JSONArray json = JSONArray.fromObject(lists);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

}
