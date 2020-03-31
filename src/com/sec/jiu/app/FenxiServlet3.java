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
import com.sec.dao.ooDao;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.oo;
import com.sec.entity.zzzz;

/**
 * Servlet implementation class FenxiServlet3
 */
@WebServlet("/FenxiServlet3")
public class FenxiServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenxiServlet3() {
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
		String name = request.getParameter("name");
		List<String> listss = new ArrayList<String>();
		System.out.println(name);
		oo o = new oo();
		ooDao dao5 = new ooDao();
		WineshopDao dao = new WineshopDao();
		int a = dao.findUserByID2(name);
		System.out.println(a);
		IndentDao dao1 = new IndentDao();
		List<Indent> list = dao1.findUserByIDmonth1(a);
		System.out.println(list+"1");
		OrderDao dao3 = new OrderDao();
		for(Indent indent : list) {
			int b = indent.getIndent_ID();
			List<Order> list1=dao3.findUserByID1(b);
			System.out.print(list1+"2");
			for(Order order:list1){
				int c=order.getGreens_ID();
				int d = order.getNumber();
				System.out.println(d+"3");
				GreensDao dao4 = new GreensDao();
				List<Greens> list2 = dao4.findUserByID(c);
				System.out.println(list2+"4");
				for(Greens greens:list2){
					String Greens_Name = greens.getGreens_Name();
					System.out.println(Greens_Name);
					List<oo> list3 = dao5.findAll();
					if(list3==null){
						
					}else{
					for(oo o3 : list3) {
						String p = o3.getOo_Name();
						listss.add(p);
					}
					}
					System.out.println(list3+"5");
					if(listss.contains(Greens_Name)){
						o.setOo_Name(Greens_Name);
						int f = dao5.findUserByID2(Greens_Name);
						int g = f+d;
						o.setOo_Number(g);
						dao5.update1(o);
						
					}else{
						o.setOo_Name(Greens_Name);
						o.setOo_Number(d);
						dao5.add(o);
					}
				}
		}
		}
		List<zzzz> lists1 = new ArrayList<zzzz>();
		List<oo> lists = dao5.findAll();	
		for(oo o1 : lists){
			String uu = o1.getOo_Name();
			int kkk = o1.getOo_Number();
			GreensDao dao15 = new GreensDao();
			int tt = dao15.findUserByID2(uu);
			List<Greens> list15 = dao15.findUserByID(tt);
			for(Greens green : list15){
				String greens_Name = green.getGreens_Name();
				//int greens_Numbe = green.getGreens_Number();
				String greens_Unit = green.getGreens_Unit();
				zzzz zzz = new zzzz();
				zzz.setAa(greens_Name);
				zzz.setBb(kkk);
				zzz.setCc(greens_Unit);
				lists1.add(zzz);
				
			}
		}
		JSONArray json = JSONArray.fromObject(lists1);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		dao5.delete();

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
