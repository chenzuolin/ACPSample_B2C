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

import net.sf.json.JSONArray;

import com.sec.dao.CourierDao;
import com.sec.dao.IndentDao;
import com.sec.dao.TotalDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Courier;
import com.sec.entity.Indent;
import com.sec.entity.KK;
import com.sec.entity.Total;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class quanbudingdanServlet2
 */
@WebServlet("/quanbudingdanServlet2")
public class quanbudingdanServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanbudingdanServlet2() {
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
		TotalDao dao = new TotalDao();
		List<KK> lists = new ArrayList<KK>();
		int a = Integer.parseInt(request.getParameter("id"));
		IndentDao dao1 = new IndentDao();
		List<Total> list = dao.findUserByID1(a);
		for(Total total : list){
			float aa = total.getTotal();
			List<Indent> list1 = dao1.findUserByID(a);
			for(Indent indent : list1){
				String bb = indent.getIndent_Time();
				String cc = indent.getIndent_Status();
				int dd = indent.getWineshop_ID();
				String af = indent.getCourier_Name();
				CourierDao c = new CourierDao();
				List<Courier> list3 = c.findUserByID1(af);
				String ag = null;
				for(Courier cs : list3){
					 ag = cs.getCourier_Telephone();
				}
				WineshopDao da = new WineshopDao();
				List<Wineshop> list2 = da.findUserByID(dd);
				String as = null;
				String ad = null;
				for(Wineshop w : list2){
					 as = w.getWineshop_Time();
					 ad = w.getWineshop_TimeNight();
				}
				KK  k = new KK();
				k.setBb(a);
				k.setCc(aa);
				k.setAa(bb);
				k.setDd(cc);
				k.setFf(ag);
				k.setGg(as);
				k.setHh(ad);
				lists.add(k);
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
