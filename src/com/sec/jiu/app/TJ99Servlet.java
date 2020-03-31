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

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;
import com.sec.entity.TJ99;

/**
 * Servlet implementation class TJ99Servlet
 */
@WebServlet("/TJ99Servlet")
public class TJ99Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TJ99Servlet() {
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
		GreensDao dao = new GreensDao();
		List<Greens> list = dao.findAll1();
		List<Greens> list1 = dao.sortIntMethod(list);
		List<TJ99> lists1 = new ArrayList<TJ99>();
		for(Greens greens : list1){
			int aa = greens.getGreens_ID();
			String bb = greens.getGreens_Name();
			String cc = greens.getGreens_Unit();
			float dd = greens.getGreens_Price();
			float ee = greens.getGreens_Market_Price();
			String ff = greens.getGreens_Class();
			String gg = greens.getGreens_Preiod();
			String hh = greens.getGreens_Character();
			String ii = greens.getGreens_Condition();
			int jj = greens.getGreens_Minnumber();
			String kk = greens.getGreens_Norms();
			int ll = greens.getGreens_Number();
			String mm = greens.getGreens_Class();
			String nn = greens.getGreens_characteristics();
			int oo = greens.getGreens_Grade();
			String pp = greens.getGreens_Recommend();
			String qq = greens.getGreens_Remark();
			String zz = greens.getGreens_tupian();
			TJ99 tj = new TJ99();
			tj.setAa(aa);
			tj.setBb(bb);
			tj.setCc(cc);
			tj.setDd(dd);
			tj.setEe(ee);
			tj.setFf(ff);
			tj.setGg(gg);
			tj.setHh(hh);
			tj.setIi(ii);
			tj.setJj(jj);
			tj.setKk(kk);
			tj.setLl(ll);
			tj.setMm(mm);
			tj.setNn(nn);
			tj.setOo(oo);
			tj.setPp(pp);
			tj.setQq(qq);
			tj.setZz(zz);
			lists1.add(tj);
			
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
		doGet(request,response);
	}

}
