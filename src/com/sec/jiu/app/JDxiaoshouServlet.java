package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.TotalDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.Total;

/**
 * Servlet implementation class JDxiaoshouServlet
 */
@WebServlet("/JDxiaoshouServlet")
public class JDxiaoshouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDxiaoshouServlet() {
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
		
		String name = request.getParameter("Wineshop_Name");//根据酒店名称查询该酒店的当天营业额
	float ee = 0;
		WineshopDao dao = new WineshopDao();
		int a = dao.findUserByID3(name);
		IndentDao dao1 = new IndentDao();
		List<Indent> list = dao1.findUserByID0();
		
		for(Indent indent : list){
			int b = indent.getWineshop_ID();
			if(a==b){
				int c = indent.getIndent_ID();
				System.out.println(c);
				TotalDao dao2=new TotalDao();
				List<Total> list1 = dao2.findUserByID1(c);
				for(Total total :list1){
					float e = total.getTotal();
					ee+=e;
				}
				
			}
		}
		PrintWriter out = response.getWriter();
		out.print(ee);
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
