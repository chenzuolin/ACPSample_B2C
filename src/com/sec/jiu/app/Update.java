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

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);

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
		response.setContentType("text/html;charset=utf-8");
		GreensDao dao = new GreensDao();
		String Greens_Preiod = request.getParameter("Greens_Preiod");
		String Greens_Type_Name = request.getParameter("Greens_Type_Name");
		String Greens_Name = request.getParameter("Greens_Name");
		String Greens_Unit = request.getParameter("Greens_Unit");
		String Greens_Character = request.getParameter("Greens_Character");
		
		String Greens_Norms = request.getParameter("Greens_Norms");
		int Greens_Number = Integer.parseInt(request.getParameter("Greens_Number"));
		String a=request.getParameter("Greens_Price");
		Float Greens_Price=Float.parseFloat(a);
		String b=request.getParameter("Greens_Market_Price");
		Float Greens_Market_Price=Float.parseFloat(b);
		String Greens_Condition=request.getParameter("Greens_Condition");
		int    Greens_Minnumber=Integer.parseInt(request.getParameter("Greens_Minnumber"));
		String Greens_Class=request.getParameter("Greens_Class");
		int Greens_Grade = Integer.parseInt(request.getParameter("Greens_Grade"));
		String Greens_characteristics=request.getParameter("Greens_characteristics");
		String Greens_Recommend=request.getParameter("Greens_Recommend");
		String Greens_Remark=request.getParameter("Greens_Remark");
		int Greens_ID = Integer.parseInt(request.getParameter("id"));
		System.out.println(Greens_ID);
		System.out.println(Greens_Name);
		System.out.println(Greens_Unit);
		System.out.println(Greens_Character);
		System.out.println(Greens_Preiod);
		System.out.println(Greens_Norms);
		System.out.println(Greens_Number);
		System.out.println(Greens_Price);
		System.out.println(Greens_Market_Price);
		System.out.println(Greens_Condition);
		System.out.println(Greens_Minnumber);
		System.out.println(Greens_Class);
		System.out.println(Greens_Grade);
		System.out.println(Greens_characteristics);
		System.out.println(Greens_Recommend);
		System.out.println(Greens_Remark);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Greens greens=new Greens();
		greens.setGreens_Type_Name(Greens_Type_Name);
		greens.setGreens_Name(Greens_Name);
		greens.setGreens_Unit(Greens_Unit);
		greens.setGreens_Character(Greens_Character);
		greens.setGreens_Preiod(Greens_Preiod);
		greens.setGreens_Norms(Greens_Norms);
		greens.setGreens_Number(Greens_Number);
		greens.setGreens_Price(Greens_Price);
		greens.setGreens_Market_Price(Greens_Market_Price);
		greens.setGreens_Condition(Greens_Condition);
		greens.setGreens_Minnumber(Greens_Minnumber);
		greens.setGreens_Class(Greens_Class);
		greens.setGreens_Grade(Greens_Grade);
		greens.setGreens_characteristics(Greens_characteristics);
		greens.setGreens_Recommend(Greens_Recommend);
		greens.setGreens_Remark(Greens_Remark);
		greens.setGreens_Time(df.format(new Date()));
		greens.setGreens_ID(Greens_ID);
		dao.update(greens);
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();
	}

}
