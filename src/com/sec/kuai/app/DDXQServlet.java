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

import com.sec.dao.FZDao;
import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.DDXQ;
import com.sec.entity.FZ;
import com.sec.entity.Indent;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class DDXQServlet
 */
@WebServlet("/DDXQServlet")
public class DDXQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DDXQServlet() {
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
		int ID = Integer.parseInt(request.getParameter("id"));
		//int ID = Integer.parseInt(request.getParameter("id"));
		IndentDao dao1 = new IndentDao();
		List<DDXQ> lists = new ArrayList<DDXQ>();
		List<Indent> list1 = dao1.findUserByID(ID);
		System.out.println("list1="+list1);
		FZDao ddd = new FZDao();
		List<FZ> fz = ddd.findUserByID(ID);
		for (FZ fz2 : fz) {
			String cgname = fz2.getCG_Name();
			String cgtime = fz2.getCG_Time();
			String fjname = fz2.getFJ_Name();
			String fjtime = fz2.getFJ_Time();
		for(Indent indent : list1) {
			int Wineshop_ID = indent.getWineshop_ID();
			System.out.println("Wineshop_ID+"+Wineshop_ID);
			String type = indent.getIndent_Status();
			System.out.println("type="+type);
			String time = indent.getIndent_Time();
			System.out.println("time="+time);
			WineshopDao dao2 = new WineshopDao();
			List<Wineshop> list2 = dao2.findUserByID(Wineshop_ID);
			System.out.println("list2="+list2);
			for(Wineshop wineshop : list2) {
				String name = wineshop.getWineshop_Name();
				System.out.println("name="+name);
				String dizhi = wineshop.getWineshop_Address();
				System.out.println("dizhi="+dizhi);
				String tel = wineshop.getWineshop_Telephone();
				System.out.println("tel="+tel);
				DDXQ cc = new DDXQ();
				cc.setID(ID);
				cc.setName(name);
				cc.setType(type);
				cc.setTime(time);
				cc.setAddress(dizhi);
				cc.setTel(tel);
				cc.setCgname(cgname);
				cc.setCgtime(cgtime);
				cc.setFjname(fjname);
				cc.setFjtime(fjtime);
				lists.add(cc);
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
