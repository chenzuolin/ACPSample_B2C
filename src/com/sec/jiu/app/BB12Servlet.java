package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class BB12Servlet
 */
@WebServlet("/BB12Servlet")
public class BB12Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BB12Servlet() {
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
		int zz = 0;
		String aa = request.getParameter("id");
		GreensDao dao = new GreensDao();
		String unit = null;
		int bb = dao.findUserByID2(aa);
		List<Greens> lists = dao.findUserByID(bb);
		for(Greens greens : lists){
			unit = greens.getGreens_Unit();
		}
		if(bb!=0) {
			IndentDao dao1 = new IndentDao();
			List<Indent> list = dao1.findUserByIDweek();
			System.out.println(list);
			for(Indent indent : list) {
				int cc = indent.getIndent_ID();
				OrderDao dao2 = new OrderDao();
				List<Order> list2 = dao2.findUserByID1(cc);
				for(Order order : list2) {
					int ee = order.getGreens_ID();
					if(ee==bb){
					int dd = order.getNumber();
					zz +=dd;
					}
				}
				
			}
			PrintWriter out = response.getWriter();
			out.print(zz + unit);
			out.flush();
			out.close();
		}else {
			PrintWriter out = response.getWriter();
			out.print("´íÎó");
			out.flush();
			out.close();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
