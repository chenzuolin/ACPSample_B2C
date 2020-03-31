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

import com.sec.dao.CartDao;
import com.sec.dao.GreensDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.Greens;

/**
 * Servlet implementation class CC8Servlet
 */
@WebServlet("/CC8Servlet")
public class CC8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CC8Servlet() {
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
		List<Integer> lists = new ArrayList<Integer>();
		String name = "ÀîËÄ";
		WineshopDao dao = new WineshopDao();
		int a = dao.findUserByID2(name);
		System.out.println(a);
		CartDao dao1 = new CartDao();
		List<Cart> list = dao1.findUserByID(a);
		System.out.println(list);
		for(Cart cart:list){
			int aa = cart.getGreens_ID();
			int bb = cart.getNumber();
			GreensDao dao2 = new GreensDao();
			List<Greens> list1 = dao2.findUserByID(aa);
			for(Greens greens:list1){
				int cc = greens.getGreens_Number();
				if(bb>cc){
					lists.add(0);
					
				}else{
					lists.add(1);
					
				}
			}
		}
		System.out.println(lists);
		if(lists.contains(0)) {
			PrintWriter out = response.getWriter();
			out.print(0);
			out.flush();
			out.close();
		}else {
			PrintWriter out = response.getWriter();
			out.print(1);
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
