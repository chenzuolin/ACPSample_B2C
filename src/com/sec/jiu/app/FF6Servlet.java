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

import com.sec.dao.FJDao;
import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.FJ;
import com.sec.entity.Indent;
import com.sec.entity.PPP;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class FF6Servlet
 */
@WebServlet("/FF6Servlet")
public class FF6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FF6Servlet() {
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
		String aaa = request.getParameter("name");
		FJDao dao = new FJDao();
		IndentDao dao1 = new IndentDao();
		WineshopDao dao2 = new WineshopDao();
		List<PPP> listss = new ArrayList<PPP>();
		List<FJ> list = dao.findUserByID1(aaa);
		for(FJ fj : list){
			String ccc = fj.getFJ_Name();
			List<Indent> lists = dao1.findFZ2(ccc);
				for(Indent indent : lists){
					int hhh = indent.getFZ_BS();
					if(hhh==0){
					int aa = indent.getIndent_ID();
					String bb = indent.getIndent_Status();
					String cc = indent.getIndent_Time();
					String lll = indent.getWineshop_Telephone();
					int dd = indent.getWineshop_ID();
					List<Wineshop> list1 = dao2.findUserByID(dd);
					for(Wineshop zz : list1){
						String ee = zz.getWineshop_Name();
						String ff = zz.getWineshop_Address();
						PPP pp = new PPP();
						pp.setAa(aa);
						pp.setBb(bb);
						pp.setCc(cc);
						pp.setDd(ee);
						pp.setEe(ff);
						pp.setFf(lll);
						listss.add(pp);
					}
					}
					}
			}
			
		
		JSONArray json = JSONArray.fromObject(listss);
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
