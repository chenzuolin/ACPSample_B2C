package com.sec.kuai.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sec.dao.CourierDao;
import com.sec.dao.Courier_WineshopDao;
import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Courier;
import com.sec.entity.Courier_Wineshop;
import com.sec.entity.Indent;
import com.sec.entity.JD;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class JSServlet
 */
@WebServlet("/JSServlet")
public class JSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSServlet() {
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
		java.util.List<JD> lists=new ArrayList<JD>();
		String name = request.getParameter("username");
		System.out.println("name="+name);
		CourierDao dao1 = new CourierDao();
		java.util.List<Courier> lsit1 = dao1.findUserByID4(name);
		System.out.println("lsit1="+lsit1);
		for(Courier courier : lsit1) {
			int Courier_ID = courier.getCourier_ID();
			Courier_WineshopDao dao2 = new Courier_WineshopDao();
			java.util.List<Courier_Wineshop> list2 = dao2.findUserByID(Courier_ID);
			System.out.println("list2="+list2);
			for(Courier_Wineshop cc : list2) {
				String wineshop_Name = cc.getAllot();
				WineshopDao dao3 = new WineshopDao();
				java.util.List<Wineshop> list3 = dao3.findUserByID5(wineshop_Name);
				System.out.println("list3="+list3);
				for(Wineshop wineshop : list3) {
					int Wineshop_ID = wineshop.getWineshop_ID();
					System.out.println("Wineshop_ID="+Wineshop_ID);
					String wineshop_NameString = wineshop.getWineshop_Name();
					System.out.println("wineshop_NameString="+wineshop_NameString);
					String addString = wineshop.getWineshop_Address();
					System.out.println("addString="+addString);
					String telString = wineshop.getWineshop_Telephone();
					System.out.println("telString="+telString);
					String date1 = wineshop.getWineshop_Time();
					String date2 = wineshop.getWineshop_TimeNight();
					IndentDao dao4 = new IndentDao();
					java.util.List<Indent> list4 = dao4.findUserByID11(Wineshop_ID);
					System.out.println("list4="+list4);
					for(Indent indent : list4) {
						String time = indent.getIndent_Time();
						System.out.println("time="+time);
						String type = indent.getIndent_Status();
						System.out.println("type="+type);
						int Indent_ID = indent.getIndent_ID();
						System.out.println("Indent_ID="+Indent_ID);
						JD jd=new JD();
						jd.setAa(Indent_ID);
						jd.setBb(wineshop_NameString);
						jd.setCc(type);
						jd.setDd(date1);
						jd.setEe(date2);
						jd.setFf(time);
						jd.setGg(addString);
						jd.setHh(telString);
						lists.add(jd);
					}
					
				}
				
			}
		}
		JSONArray json = JSONArray.fromObject(lists);
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
		doGet(request, response);
	}

}
