package com.sec.kuai.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CourierDao;
import com.sec.entity.Courier;

/**
 * Servlet implementation class ZCServlet
 */
@WebServlet("/ZCServlet")
public class ZCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String one=request.getParameter("username");
		System.out.println(one);
		String two=request.getParameter("password1");
		System.out.println(two);
		String three=request.getParameter("Courier_Telephone");
		System.out.println(three);
		String five=request.getParameter("Courier_Vehicle");
		System.out.println(five);
		Courier courier=new Courier();
		courier.setCourier_Password(two);
		courier.setCourier_Name(one);
		courier.setCourier_Telephone(three);
		courier.setCourier_Time(df.format(new Date()));
		courier.setRegionality_ID(3);
		courier.setCourier_Vehicle(five);
		CourierDao dao=new CourierDao();
		int x=dao.add(courier);
		PrintWriter out=response.getWriter();
		out.print(x);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
