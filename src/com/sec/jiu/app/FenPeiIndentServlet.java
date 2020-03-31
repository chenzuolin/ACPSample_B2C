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
import com.sec.dao.FenPeiDao;
import com.sec.dao.IndentDao;
import com.sec.dao.WCDao;
import com.sec.entity.Courier;
import com.sec.entity.Indent;
import com.sec.entity.WC;
import com.sec.entity.WCdemo;

/**
 * Servlet implementation class FenPeiIndentServlet
 */
@WebServlet("/FenPeiIndentServlet")
public class FenPeiIndentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenPeiIndentServlet() {
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
		String bb = request.getParameter("FenPei_UserName");
		FenPeiDao dao8 = new FenPeiDao();
		int a = dao8.findUserByID(bb);
		List<WCdemo> list9=new ArrayList<WCdemo>();
		
		System.out.println(a);
		IndentDao dao = new IndentDao();
		try {
			List<Indent> list = dao.getUserByCurrentPage1(a);//得到所有订单状态为配送中的订单
			for(Indent indent : list) {
				int id = indent.getIndent_ID();
				String time = indent.getIndent_Time();
				String zt = indent.getIndent_Status();
				WCDao dao2 = new WCDao();
				List<WC> lists = dao2.findUserByID(id);
				for(WC wc : lists) {
					int kid = wc.getCourier_ID();
					CourierDao dao3 = new CourierDao();
					List<Courier> list2 = dao3.findUserByID2(kid);
					for(Courier courier : list2) {
						String Name = courier.getCourier_Name();
						String tel = courier.getCourier_Telephone();
						String type = courier.getCourier_Vehicle();
						WCdemo demo = new WCdemo();
						demo.setId(id);
						demo.setTime(time);
						demo.setZT(zt);
						demo.setName(Name);
						demo.setTel(tel);
						demo.setType(type);
						list9.add(demo);
					}
				}
			}
			JSONArray json = JSONArray.fromObject(list9);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
