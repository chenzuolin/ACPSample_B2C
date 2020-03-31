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
import com.sec.dao.TJDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.TJ;

/**
 * Servlet implementation class bb00
 */
@WebServlet("/bb00")
public class bb00 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bb00() {
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
		String a = request.getParameter("name");
		System.out.println(a);
		List<String> listss = new ArrayList<String>();
		WineshopDao dao = new WineshopDao();
		IndentDao dao1 = new IndentDao();
		int b = dao.findUserByID2(a);
		OrderDao dao2 = new OrderDao();
		TJDao dao4 = new TJDao();
		TJ tj = new TJ();
		
		List<Indent> list = dao1.findUserByID10(b);
		for(Indent indent1 : list){
			int c = indent1.getIndent_ID();
			List<Order> list1 = dao2.findUserByID1(c);
			for(Order order1 : list1){
				int d = order1.getGreens_ID();
				GreensDao dao3 = new GreensDao();
				List<Greens> list2 = dao3.findUserByID(d);
				for(Greens greens : list2){
					String e = greens.getGreens_Name();
					
					List<TJ> list3 = dao4.findAll();
					for(TJ t : list3){
						String f = t.getTJ_Name();
						listss.add(f);
					}
					if(listss.contains(e)){
						
					}else{
						tj.setTJ_Name(e);
						tj.setWineshop_ID(b);
						dao4.add(tj);
					}
				}
			}
		}
		List<TJ> lists = dao4.findAll();
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
