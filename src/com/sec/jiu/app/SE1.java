package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.WineshopDao;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class SE1
 */
@WebServlet("/SE1")
public class SE1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SE1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest x, HttpServletResponse response)
			throws ServletException, IOException {
		
		   
		   x.setCharacterEncoding("gbk");
		   response.setContentType("text/html,gbk");
		   response.setHeader("Access-Control-Allow-Origin", "*");  
			  
			response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
	  
			response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
	  
			response.setHeader("X-Powered-By","Jetty");  
			response.setHeader("Access-Control-Allow-Origin", "*");
           String one=x.getParameter("Wineshop_UserName");
           System.out.println("one="+one);
           String two=x.getParameter("Wineshop_Password");
           System.out.println("two="+two);
           String three=x.getParameter("Wineshop_Name");
           System.out.println("three="+three);
           String five=x.getParameter("Wineshop_Telephone");
           System.out.println("five="+five);
           String server=x.getParameter("Wineshop_Address");
           System.out.println("server="+server);
           String Wineshop_QQ=x.getParameter("Wineshop_QQ");
           System.out.println(Wineshop_QQ);
           String ten=x.getParameter("Wineshop_WeChat");
           System.out.println("ten="+ten);
           String ten11=x.getParameter("Wineshop_Shift_Name");
           System.out.println("ten11="+ten11);
           
           
           
           WineshopDao dao=new WineshopDao();
           Wineshop wineshop=new Wineshop();
           wineshop.setWineshop_UserName(one);
   		   wineshop.setWineshop_Password(two);
   		   wineshop.setRole_ID(2);
   		   wineshop.setWineshop_Name(three);
   		   wineshop.setRegionality_ID(3);
   		   wineshop.setWineshop_Aptitude(null);
   		   wineshop.setWineshop_Condition(1);
   		   wineshop.setWineshop_Address(server);
   		   wineshop.setWineshop_Shift_Name(ten11);
   		   wineshop.setWineshop_Telephone(five);
   		   wineshop.setWineshop_Class(1);
   		   wineshop.setWineshop_Nature("∆’Õ®æ∆µÍ");
   		   wineshop.setWineshop_QQ(Wineshop_QQ);
   		   wineshop.setWineshop_WeChat(ten);
   		   wineshop.setWineshop_Number("865352653");
   		   String b = dao.add(wineshop);
           
   		PrintWriter out = response.getWriter();
		out.print(b);
		out.flush();
		out.close();
	        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void Post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
