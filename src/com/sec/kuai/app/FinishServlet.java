package com.sec.kuai.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import com.sec.entity.Finish;
import com.sec.entity.Indent;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class FinishServlet
 */
@WebServlet("/FinishServlet")
public class FinishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinishServlet() {
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
		String name = request.getParameter("username");
		List<Finish> lists = new ArrayList<Finish>();
		CourierDao dao1 = new CourierDao();
		List<Courier> list1 = dao1.findUserByID4(name);
		System.out.println("list1="+list1);
		for(Courier courier : list1) {
			int Courier_ID = courier.getCourier_ID();
			System.out.println("Corier_ID="+Courier_ID);
			Courier_WineshopDao dao2 = new Courier_WineshopDao();
			List<Courier_Wineshop> list2 = dao2.findUserByID(Courier_ID);
			System.out.println("list2="+list2);
			for(Courier_Wineshop cc : list2) {
				String Wineshop_Name = cc.getAllot();
				System.out.println("Wineshop_Name="+Wineshop_Name);
				WineshopDao dao3 = new WineshopDao();
				List<Wineshop> list3 = dao3.findUserByID5(Wineshop_Name);
				System.out.println("list3="+list3);
				for(Wineshop wineshop : list3) {
					int Wineshop_ID = wineshop.getWineshop_ID();
					System.out.println("Wineshop_ID="+Wineshop_ID);
					String address = wineshop.getWineshop_Address();
					System.out.println("address="+address);
					String tel = wineshop.getWineshop_Telephone();
					System.out.println("tel="+tel);
					IndentDao dao4 = new IndentDao();
					String date1 = wineshop.getWineshop_Time();
					String date2 = wineshop.getWineshop_TimeNight();
					List<Indent> list4 = dao4.findUserByID12(Wineshop_ID);
					System.out.println("list4="+list4);
					for(Indent indent : list4) {
						int Indent_ID = indent.getIndent_ID();
						System.out.println("Indent_ID="+Indent_ID);
						String type = indent.getIndent_Status();
						System.out.println("type="+type);
						String time = indent.getIndent_Time();
						System.out.println("time="+time);
						Finish finish = new Finish();
						finish.setId(Indent_ID);
						finish.setName(Wineshop_Name);
						finish.setType(type);
						finish.setTime(time);
						finish.setAddress(address);
						finish.setTel(tel);
						finish.setQtime(date1);
						finish.setZtime(date2);
						lists.add(finish);
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
		doGet(request,response);
	}

}
