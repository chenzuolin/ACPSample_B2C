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

import com.sec.dao.ComplainantDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Complainant;
import com.sec.entity.aaaa;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CSFKServlet
 */
@WebServlet("/CSFKServlet")
public class CSFKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSFKServlet() {
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
		List<aaaa> list = new ArrayList<aaaa>();
		ComplainantDao dao = new ComplainantDao();
		List<Complainant> a = dao.findAll();
		for(Complainant complainant :a){
			String b = complainant.getComplainant_Type();
			
			if(b.contains("…Ã∆∑")){
				int aa= complainant.getComplainant_ID();
				int ee = complainant.getWineshop_ID();
				
				String bb = complainant.getComplainant_Content();
				String cc = complainant.getComplainant_Type();
				String dd = complainant.getComplainant_Time();
				WineshopDao dao1 = new WineshopDao();
				
				String ff=dao1.findUserByID111(ee);
				aaaa bbbb = new aaaa();
				bbbb.setAa(aa);
				bbbb.setBb(bb);
				bbbb.setCc(cc);
				bbbb.setDd(dd);
				bbbb.setFf(ff);
				bbbb.setEe(ee);
				list.add(bbbb);		
				System.out.println(list);
			}
		}
	
		
		
		
		 JSONArray json = JSONArray.fromObject(list);
		 PrintWriter out = response.getWriter();
			
			out.print(json);
			
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
