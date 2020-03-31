package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sec.dao.CourierDao;
import com.sec.dao.WCDao;
import com.sec.entity.Courier;
import com.sec.entity.WC;
import com.sec.entity.WCdemo;

/**
 * Servlet implementation class WCServlet
 */
@WebServlet("/WCServlet")
public class WCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<WCdemo> lists = new ArrayList<WCdemo>();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id="+id);
		WCDao dao = new WCDao();
		List<WC> list = dao.findUserByID(id);
		System.out.println("list="+list);
		for(WC wc : list) {
			int aa = wc.getCourier_ID();
			System.out.println("aa="+aa);
			CourierDao dao2 = new CourierDao();
			List<Courier> list1 = dao2.findUserByID2(aa);
			for(Courier courier : list1) {
				String name = courier.getCourier_Name();
				String tel = courier.getCourier_Telephone();
				String type = courier.getCourier_Vehicle();
				WCdemo demo = new WCdemo();
				demo.setName(name);
				demo.setTel(tel);
				demo.setType(type);
				lists.add(demo);
			}
		}
		JSONArray json = JSONArray.fromObject(lists);
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
		doGet(request,response);
	}

}
