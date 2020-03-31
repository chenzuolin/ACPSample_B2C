package com.sec.Activity;

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

import com.sec.dao.CartDao;
import com.sec.dao.GreensDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.Greens;
import com.sec.entity.PPP2;

/**
 * Servlet implementation class LOL8Servlet
 */
@WebServlet("/LOL8Servlet")
public class LOL8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LOL8Servlet() {
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
		String aa = request.getParameter("id");
		float gg = 0;
		float num = 0;
		List<PPP2> lists = new ArrayList<PPP2>();
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		CartDao dao1 = new CartDao();
		List<Cart> list = dao1.findUserByID(bb);
		for(Cart cart : list){
			int cc = cart.getGreens_ID();
			int ff = cart.getNumber();
			GreensDao dao2 = new GreensDao();
			List<Greens> list1 = dao2.findUserByID(cc);
			for(Greens greens : list1){
				String dd = greens.getGreens_Name();
				float ee = greens.getGreens_Price();
				String zz = greens.getGreens_Norms();
				String hh = greens.getGreens_tupian();
				String oo = greens.getGreens_Unit();
				int kl = greens.getGreens_Sore();
				gg = ff*ee;
				num = (float)(Math.round(gg*100))/100;//小计小数点后面保留一位
				PPP2 pp = new PPP2();
				pp.setAa(dd);
				pp.setDd(ff);
				pp.setFf(num);
				pp.setLl(ee);
				pp.setBb(zz);
				pp.setHh(hh);
				pp.setMm(oo);
				pp.setJj(kl);
				lists.add(pp);
				
			}
		}
		
		JSONArray json = JSONArray.fromObject(lists);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		

		
		
		
		
		
	}

}
