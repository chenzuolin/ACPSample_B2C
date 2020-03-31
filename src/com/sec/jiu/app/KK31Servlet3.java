package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.DynamicDao;
import com.sec.dao.GreensDao;
import com.sec.entity.Dynamic;
import com.sec.entity.Greens;

/**
 * Servlet implementation class KK31Servlet3
 */
@WebServlet("/KK31Servlet3")
public class KK31Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KK31Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GreensDao dao = new GreensDao();
		DynamicDao dao1 = new DynamicDao();
		boolean aaa = dao1.findUserByIDday1();
		Dynamic dynamic = new Dynamic();
		if(aaa==false){
		List<Greens> list = dao.findAll();
		for(Greens greens : list){
			int aa = greens.getGreens_ID();
			float bb = greens.getGreens_Price();
			float cc = greens.getGreens_Market_Price();
			
			dynamic.setGreens_ID(aa);
			dynamic.setDynamic_Price(bb);
			dynamic.setDynamic_Time(df.format(new Date()));
			dynamic.setDynamic_Market_Price(cc);
			dao1.add(dynamic);
		}
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();
		}
	}

}
