package com.sec.kuai.app;

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
import com.sec.dao.Courier_WineshopDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Courier;
import com.sec.entity.Courier_Wineshop;
import com.sec.entity.SSJD1;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class SSJDServlet
 */
@WebServlet("/SSJDServlet")
public class SSJDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSJDServlet() {
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
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		String username=request.getParameter("username");
		System.out.println(username);
		List<SSJD1> lists = new ArrayList<SSJD1>();
		CourierDao dao=new CourierDao();
		List<Courier> list=dao.findUserByID3(username);
		for(int i=0;i<list.size();i++) {
			Courier courier=new Courier();
			int ID=list.get(i).getCourier_ID();
			System.out.println(ID);
			Courier_WineshopDao dao2=new Courier_WineshopDao();
			List<Courier_Wineshop> list2=dao2.findUserByID(ID);
			System.out.println(list2);
			for(Courier_Wineshop cc : list2) {
				String name = cc.getAllot();
				System.out.println("name="+name);
				WineshopDao dao3 = new WineshopDao();
				List<Wineshop> list3 = dao3.findUserByID5(name);
				System.out.println("list3="+list3);
				for(Wineshop wineshop : list3) {
					int wineshop_ID = wineshop.getWineshop_ID();
					System.out.println("Wineshop_ID="+wineshop_ID);
					String address = wineshop.getWineshop_Address();
					SSJD1 ss = new SSJD1();
					ss.setId(wineshop_ID);
					ss.setName(name);
					lists.add(ss);
				}
			}
			
		}
		JSONArray json=JSONArray.fromObject(lists);
		PrintWriter out=response.getWriter();
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
