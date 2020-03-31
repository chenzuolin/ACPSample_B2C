package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class SS8Servlet
 */
@WebServlet("/SS8Servlet")
public class SS8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SS8Servlet() {
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
		Map<Integer,String> map = new HashMap<Integer,String>();
		String util = null;

		List<Integer> lists = new ArrayList<Integer>();
		List<String> list99 = new ArrayList<String>();

		String name = request.getParameter("name");
		WineshopDao dao8 = new WineshopDao();
		int a = dao8.findUserByID2(name);
		IndentDao dao = new IndentDao();
		List<Indent> list = dao.findUserByIDyear1(a);
		for(Indent  indent : list ){
			int b = indent.getIndent_ID();
			OrderDao dao2 = new OrderDao();
			List<Order> list2 = dao2.findUserByID1(b);
			for(Order order : list2){
				int c = order.getGreens_ID();
				int d = order.getNumber();
				GreensDao dao9 = new GreensDao();
				List<Greens> list9 = dao9.findUserByID(c);
				for(Greens green : list9){
					 util = green.getGreens_Unit();
					
						if(map.get(c)!=null){  
							String str = map.get(c);
							str=str.trim();
							String str2="";
							if(str != null && !"".equals(str)){
							for(int i=0;i<str.length();i++){
							if(str.charAt(i)>=48 && str.charAt(i)<=57){
							str2+=str.charAt(i);
							}
							}
							}
							
							int f = Integer.parseInt(str2);
							int ff = f+d;
							map.put(c, ff+util);	  
						}else{
							map.put(c, d+util);  
						}
						
						
						
						
						}  
				}
			
				}


				
		Set<Integer> Ckey = map.keySet();
		for(Integer key : Ckey){
			lists.add(key);
			String value = map.get(key);
			list99.add(value);
		}


		PrintWriter out = response.getWriter();
		out.print(list99);
		out.flush();
		

		PrintWriter out1 = response.getWriter();
		out1.print(lists);
		out1.flush();
		out1.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
