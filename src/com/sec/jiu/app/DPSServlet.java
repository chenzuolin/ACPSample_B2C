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

import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.PPP;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class DPSServlet
 */
@WebServlet("/DPSServlet")
public class DPSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DPSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
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
		IndentDao dao = new IndentDao();
		List<PPP> lists = new ArrayList<PPP>();
		WineshopDao dao1 = new WineshopDao();
		List<Indent> list = dao.findUserByID2("分拣完毕等待快递员接收");
		for(Indent indent : list){
			int aa = indent.getIndent_ID();
			String bb = indent.getIndent_Status();
			String cc = indent.getIndent_Time();
			int dd = indent.getWineshop_ID();
			List<Wineshop> list1 = dao1.findUserByID(dd);
			for(Wineshop zz : list1){
				String ee = zz.getWineshop_Name();
				String ff = zz.getWineshop_Address();
				String gg = zz.getWineshop_Telephone();
				PPP pp = new PPP();
				pp.setAa(aa);
				pp.setBb(bb);
				pp.setCc(cc);
				pp.setDd(ee);
				pp.setEe(ff);
				pp.setFf(gg);
				lists.add(pp);
			}
		
		}
		
		
		JSONArray json = JSONArray.fromObject(lists);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

}
