package com.sec.kuai.app;

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
import com.sec.dao.IndentDao;
import com.sec.entity.Courier;
import com.sumeng.kuai.object.Fenjianwanbi;

/**
 * Servlet implementation class IndentStatusServlet
 */
@WebServlet("/IndentStatusServlet")
public class IndentStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndentStatusServlet() {
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
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		String cname = request.getParameter("username");
		CourierDao dao = new CourierDao();
		List<Courier> list = dao.findUserByID3(cname);
		int cid = 0;
		for (Courier courier : list) {
			cid = courier.getCourier_ID();
		}
		IndentDao indent = new IndentDao();
		List<Fenjianwanbi> indentList = indent.indentStatus(cid);
		JSONArray json = JSONArray.fromObject(indentList);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
	}

}
