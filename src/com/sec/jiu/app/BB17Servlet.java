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

import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.hhh;

/**
 * Servlet implementation class BB17Servlet
 */
@WebServlet("/BB17Servlet")
public class BB17Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BB17Servlet() {
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
		List<hhh> lists = new ArrayList<hhh>();
		String aa = request.getParameter("id");
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		IndentDao dao1 = new IndentDao();
		List<Indent> list = dao1.findUserByID00(bb);
		for(Indent indent : list) {
			int cc = indent.getIndent_ID();
			OrderDao dao2 = new OrderDao();
			List<Order> list1 = dao2.findUserByID1(cc);
			for(Order order : list1){
				int dd = order.getGreens_ID();
				int ee = order.getNumber();
				GreensDao dao3 = new GreensDao();
				List<Greens> list2 = dao3.findUserByID(dd);
				for(Greens greens : list2){
					String ff = greens.getGreens_Name();
					hhh hh = new hhh();
					hh.setDd(dd);
					hh.setEe(ee);
					hh.setFf(ff);
					lists.add(hh);
					
				}
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
