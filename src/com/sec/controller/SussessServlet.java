package com.sec.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CartDao;
import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class SussessServlet
 */
@WebServlet("/SussessServlet")
public class SussessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SussessServlet() {
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
		float total = Float.parseFloat(request.getParameter("total"));
		request.getSession().setAttribute("total", total);
		int xx = (Integer)request.getSession().getAttribute("id");
		
		CartDao dao = new CartDao();
		List<Cart> list = dao.findAll();
		//得到购物车集合list
	
               IndentDao dao1 = new IndentDao(); 
               Indent indent = new Indent();
               WineshopDao dao2 = new WineshopDao();
       		   List<Wineshop> list1 = dao2.findUserByID(xx);
       		   for(int j =0;j<list1.size();j++){
       			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                indent.setIndent_Time(df.format(new Date()));
                indent.setIndent_Distribution_Time("");
                indent.setWineshop_ID(xx);
                indent.setWineshop_Address(list1.get(j).getWineshop_Address());
                indent.setIndent_Fare("");
                indent.setIndent_Check_Type("");
                indent.setWineshop_Telephone(list1.get(j).getWineshop_Telephone());
                indent.setIndent_Status("正在处理");
                dao1.add(indent);
               
               
               /*System.out.println(xx);
               System.out.println(wineshop.getWineshop_Address());
               System.out.println(wineshop.getWineshop_Telephone());*/
               
               int d = dao1.findID();
               request.getSession().setAttribute("d", d);
            
              // System.out.println(d);
               
           	  if(list!=null&&list.size()>0){
               for(int i=0;i<list.size();i++){
               	//对一条数据进行操作并进行循环
                  Cart cart = list.get(i);
               Order order = new Order();
               OrderDao dao3 = new OrderDao();
               order.setIndent_ID(d);
               order.setGreens_ID(cart.getGreens_ID());
               order.setNumber(cart.getNumber());
               order.setOrder_Requirement("");
               order.setIndent_Status("正在处理");
               /*System.out.println(d);
               System.out.println(cart.getGreens_ID());
               System.out.println(cart.getNumber());*/
               dao3.add(order);
               
               GreensDao dao5 = new GreensDao();
      			List<Greens> list5 = dao5.findUserByID(cart.getGreens_ID());
      			for(Greens greens : list5) {
   				int bb = cart.getNumber();
      				int aa = greens.getGreens_Number();
      				int dd = aa-bb;
      				greens.setGreens_Number(dd);
      	       		greens.setGreens_ID(cart.getGreens_ID());
      	       		dao5.update1(greens);
       		   }
       		   
       		   
               
               
               
           	  }
       		   
           
		}
		
		
		
		
		
		 int yy = (Integer)request.getSession().getAttribute("id");
		 //System.out.println(yy);
		dao.delete(yy);
		
		request.getRequestDispatcher("zhifu.jsp").forward(request, response);
		
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
