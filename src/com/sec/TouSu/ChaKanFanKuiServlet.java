package com.sec.TouSu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sec.dao.TouSuDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.TouSu;

/**
 * Servlet implementation class ChaKanFanKuiServlet
 */
@WebServlet("/ChaKanFanKuiServlet")
public class ChaKanFanKuiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaKanFanKuiServlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String Wineshop_UserName = request.getParameter("Wineshop_UserName");
		WineshopDao dao2 = new WineshopDao();
		TouSuDao dao = new TouSuDao();
		
		int Wineshop_ID = dao2.findUserByID2(Wineshop_UserName);
		System.out.println(Wineshop_ID+"Wineshop_ID");
		List<TouSu> list = dao.findUserByID(Wineshop_ID);
		JSONArray json = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
