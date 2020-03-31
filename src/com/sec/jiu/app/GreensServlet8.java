package com.sec.jiu.app;

import java.awt.image.SampleModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

/**
 * Servlet implementation class GreensServlet8
 */
@WebServlet("/GreensServlet8")
public class GreensServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreensServlet8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest t, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		t.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
   		
        String Greens_Period1 = t.getParameter("Greens_Period1");
        System.out.println(Greens_Period1);
        
        String Greens_Period2 = t.getParameter("Greens_Period");
        System.out.println(Greens_Period2);
        
        String Greens_Period = Greens_Period2+Greens_Period1;
        System.out.println(Greens_Period);
        
        String Greens_Type_Name = t.getParameter("Greens_Type_Name");
		System.out.println(Greens_Type_Name);
		
		String Greens_Name=t.getParameter("Greens_Name");
		System.out.println(Greens_Name);
		
		String Greens_Unit=t.getParameter("Greens_Unit");
		System.out.println(Greens_Unit);
		
		String a=t.getParameter("Greens_Price");
		Float Greens_Price=Float.parseFloat(a);
		System.out.println(Greens_Price);
		
		String b=t.getParameter("Greens_Market_Price");
		Float Greens_Market_Price=Float.parseFloat(b);
		System.out.println(Greens_Market_Price);
		
		String Greens_Character=t.getParameter("Greens_Character");
		System.out.println(Greens_Character);
		
		String Greens_Condition=t.getParameter("Greens_Condition");
		System.out.println(Greens_Condition);
		
		String Greens_Minnumber=t.getParameter("Greens_Minnumber");
		int x=Integer.parseInt(Greens_Minnumber);
		System.out.println(x);
		
		String Greens_Norms=t.getParameter("Greens_Norms");
		System.out.println(Greens_Norms);
		
		String Greens_Number=t.getParameter("Greens_Number");
		int y=Integer.parseInt(Greens_Number);
		System.out.println(y);
		 
		String Greens_Class=t.getParameter("Greens_Class");
		System.out.println(Greens_Class);
		
		String Greens_characteristics=t.getParameter("Greens_characteristics");
		System.out.println(Greens_characteristics);
		
		String Greens_Recommend=t.getParameter("Greens_Recommend");
		System.out.println(Greens_Recommend);
		
		String Greens_Remark=t.getParameter("Greens_Remark");
		//System.out.println(Greens_Remark);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

		
	//	http://211.149.232.210/ACPSample_B2C/GreensServlet8?Greens_Period1=1&Greens_Period=2&Greens_Type_Name=55&Greens_Name=%E6%9D%A8%E9%B9%8F&Greens_Unit=%E5%85%8BGreens_Price=5&Greens_Market_Price=8&Greens_Character=55&Greens_Condition=99&Greens_Minnumber=88&Greens_Norms=%E6%9A%82%E6%97%A0&Greens_Number=800&Greens_Class=1&Greens_characteristics=88&Greens_Recommend&Greens_Remark=99
		
		Greens greens=new Greens();
		greens.setGreens_Type_Name(Greens_Type_Name);
		greens.setGreens_Name(Greens_Name);
		greens.setGreens_Unit(Greens_Unit);
		greens.setGreens_Character(Greens_Character);
		greens.setGreens_Preiod(Greens_Period2);
		greens.setGreens_Norms(Greens_Norms);
		greens.setGreens_Number(y);
		greens.setGreens_Price(Greens_Price);
		greens.setGreens_Market_Price(Greens_Market_Price);
		greens.setGreens_Condition(Greens_Condition);
		greens.setGreens_Minnumber(x);
		greens.setGreens_Class(Greens_Class);
		greens.setGreens_Grade(1);
		greens.setGreens_characteristics(Greens_characteristics);
		greens.setGreens_Recommend(Greens_Recommend);
		greens.setGreens_Remark(Greens_Remark);
		greens.setGreens_Time(df.format(new Date()));
		//greens.setGreens_tupian(null);
		
		GreensDao dao=new GreensDao();
		dao.add(greens);
		//int aa=1;
		
		PrintWriter out = response.getWriter();
		out.println(1);
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
