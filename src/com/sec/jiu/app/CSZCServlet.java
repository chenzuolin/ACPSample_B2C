package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_JobberDao;
import com.sec.entity.Greens_Jobber;

/**
 * Servlet implementation class CSZCServlet
 */
@WebServlet("/CSZCServlet")
public class CSZCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSZCServlet() {
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
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		String Greens_Jobber_UserName = request.getParameter("Greens_Jobber_UserName");
		String Greens_Jobber_Password = request.getParameter("Greens_Jobber_Password");
		String Greens_Jobber_Name = request.getParameter("Greens_Jobber_Name");
		String Greens_Jobber_Telephone = request.getParameter("Greens_Jobber_Telephone");
		String Greens_Jobber_Address = request.getParameter("Greens_Jobber_Address");
		String Greens_Jobber_QQ = request.getParameter("Greens_Jobber_QQ");
		String Greens_Jobber_WeChat = request.getParameter("Greens_Jobber_WeChat");
		String Greens_Jobber_Shift_Name = request.getParameter("Greens_Jobber_Shift_Name");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Greens_Jobber green = new Greens_Jobber();
		green.setGreens_Jobber_UserName(Greens_Jobber_UserName);
		green.setGreens_Jobber_Password(Greens_Jobber_Password);
		green.setRole_ID(1);
		green.setGreens_Jobber_Name(Greens_Jobber_Name);
		green.setGreens_Jobber_Aptitude("");
		green.setGreens_Jobber_Address(Greens_Jobber_Address);
		green.setGreens_Jobber_Shift_Name(Greens_Jobber_Shift_Name);
		green.setGreens_Jobber_Telephone(Greens_Jobber_Telephone);
		green.setGreens_Jobber_Time(df.format(new Date()));
		green.setRegionality_ID(3);
		green.setGreens_Jobber_QQ(Greens_Jobber_QQ);
		green.setGreens_Jobber_WeChat(Greens_Jobber_WeChat);
		green.setGreens_Jobber_Grade("1");
		Greens_JobberDao dao=new Greens_JobberDao();
		dao.add(green);
		PrintWriter out = response.getWriter();
		out.print(1);
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
