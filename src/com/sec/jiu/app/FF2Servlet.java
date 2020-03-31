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

import com.sec.dao.CommonlyDao;
import com.sec.dao.GreensDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Commonly;
import com.sec.entity.Greens;
import com.sec.entity.PPP2;

/**
 * Servlet implementation class FF2Servlet
 */
@WebServlet("/FF2Servlet")
public class FF2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FF2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String aa = request.getParameter("name");
		List<PPP2> lists1 = new ArrayList<PPP2>();
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		CommonlyDao dao1 = new CommonlyDao();
		List<Commonly> list = dao1.findUserByID(bb);
		for(Commonly nnn : list) {
			int cc = nnn.getGreens_ID();
			GreensDao dao2 = new GreensDao();
			List<Greens> list1 = dao2.findUserByID(cc);
			for(Greens green : list1){
				String greens_Character = green.getGreens_Character();
				String greens_Class = green.getGreens_Class();
				String greens_Condition = green.getGreens_Condition();
				int greens_Grade = green.getGreens_Grade();
				int greens_ID = green.getGreens_ID();
				float greens_Market_Price = green.getGreens_Market_Price();
				int greens_Minnumber = green.getGreens_Minnumber();
				String greens_Name = green.getGreens_Name();
				String greens_Norms = green.getGreens_Norms();
				int greens_Numbe = green.getGreens_Number();
				String greens_Preiod = green.getGreens_Preiod();
				float greens_Price = green.getGreens_Price();
				String greens_Recommend = green.getGreens_Recommend();
				String greens_Remark = green.getGreens_Remark();
				String greens_Time = green.getGreens_Time();
				String greens_Type_Name = green.getGreens_Type_Name();
				String greens_Unit = green.getGreens_Unit();
				String greens_characteristics = green.getGreens_characteristics();
				String greens_tupian = green.getGreens_tupian();
				PPP2 p = new PPP2();
				p.setAa(greens_Character);
				p.setBb(greens_Class);;
				p.setCc(greens_Condition);;
				p.setDd(greens_Grade);
				p.setEe(greens_ID);
				p.setFf(greens_Market_Price);
				p.setGg(greens_Minnumber);
				p.setHh(greens_Name);
				p.setIi(greens_Norms);
				p.setJj(greens_Numbe);
				p.setKk(greens_Preiod);
				p.setLl(greens_Price);
				p.setMm(greens_Recommend);
				p.setNn(greens_Remark);
				p.setOo(greens_Time);
				p.setQq(greens_Type_Name);
				p.setXx(greens_Unit);
				p.setYy(greens_characteristics);
				p.setZz(greens_tupian);
				lists1.add(p);
			}
			
		}
		JSONArray json = JSONArray.fromObject(lists1);
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
	}

}
