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

import com.sec.dao.CartDao;
import com.sec.dao.GreensDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.Greens;
import com.sec.entity.UUU;

/**
 * Servlet implementation class CC11Servlet
 */
@WebServlet("/CC11Servlet")
public class CC11Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CC11Servlet() {
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
		String aa = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		List<UUU> lists = new ArrayList<UUU>();
		int bb = dao.findUserByID2(aa);
		CartDao dao2 = new CartDao();
		List<Cart> list = dao2.findUserByID(bb);
		for(Cart cart : list){
			int cc = cart.getGreens_ID();
			int dd = cart.getNumber();
			GreensDao dao3 = new GreensDao();
			List<Greens> list2 = dao3.findUserByID(cc);
			for(Greens greens : list2){
				String ee = greens.getGreens_Name();
				Float ff = greens.getGreens_Price();
				String gg = greens.getGreens_Unit();
				UUU uu = new UUU();
				uu.setAa(ee);
				uu.setBb(dd);
				uu.setCc(ff);
				uu.setDd(gg);
				lists.add(uu);
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
	}

}
