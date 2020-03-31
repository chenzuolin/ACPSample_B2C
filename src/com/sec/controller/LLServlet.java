package com.sec.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.DynamicDao;
import com.sec.dao.GreensDao;
import com.sec.entity.Dynamic;
import com.sec.entity.Greens;

/**
 * Servlet implementation class LLServlet
 */
@WebServlet("/LLServlet")
public class LLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		DynamicDao dao1 = new DynamicDao();
		boolean aaa = dao1.findUserByIDday1();
		System.out.println(aaa);
		if(aaa==false) {
		String[] a  = request.getParameterValues("a");
		String[] b = request.getParameterValues("b");
		String[] c = request.getParameterValues("c");
		String[] d = request.getParameterValues("d");
		String[] e = request.getParameterValues("e");
		String[] f = request.getParameterValues("f");
		String[] g = request.getParameterValues("g");
		String[] h = request.getParameterValues("h");
		float[] hh = parseFloatArray(h);
		String[] i = request.getParameterValues("i");
		String[] j = request.getParameterValues("j");
		String[] k = request.getParameterValues("k");
		String[] l = request.getParameterValues("l");
		String[] m = request.getParameterValues("m");
		String[] n = request.getParameterValues("n");
		String[] o = request.getParameterValues("o");
		String[] p = request.getParameterValues("p");
		String[] q = request.getParameterValues("q");
		for(int z=0;z<a.length;z++) {
			String a1 = a[z];
			String q1 = q[z];
			String b1 = b[z];
			String c1 = c[z];
			String d1 = d[z];
			String e1 = e[z];
			String f1 = f[z];
			String g1 = g[z];
			Float h1 = hh[z];
			String i1 = i[z];
			String j1 = j[z];
			String k1 = k[z];
			String l1 = l[z];
			String m1 = m[z];
			String n1 = n[z];
			String o1 = o[z];
			String p1 = p[z];
			GreensDao dao = new GreensDao();
			Greens greens = new Greens();
			
			greens.setGreens_Type_Name(q1);
			greens.setGreens_Name(b1);
			greens.setGreens_Unit(c1);
			greens.setGreens_Character(d1);
			greens.setGreens_Preiod(e1);
			greens.setGreens_Norms(f1);
			greens.setGreens_Number(Integer.parseInt(g1));
			greens.setGreens_Price(h1);
			greens.setGreens_Market_Price(Float.parseFloat(i1));
			greens.setGreens_Condition(j1);
			greens.setGreens_Minnumber(Integer.parseInt(k1));
			greens.setGreens_Class(l1);
			greens.setGreens_Grade(Integer.parseInt(m1));
			greens.setGreens_characteristics(n1);
			greens.setGreens_Recommend(o1);
			greens.setGreens_Remark(p1);
			greens.setGreens_Time(df.format(new Date()));
			greens.setGreens_ID(Integer.parseInt(a1));
			dao.update(greens);
			
			/*System.out.println(a1);
			System.out.println(b1);
			System.out.println(c1);
			System.out.println(d1);
			System.out.println(e1);
			System.out.println(f1);
			System.out.println(g1);
			System.out.println(h1);
			System.out.println(i1);
			System.out.println(j1);
			System.out.println(k1);
			System.out.println(l1);
			System.out.println(m1);
			System.out.println(n1);
			System.out.println(o1);
			System.out.println(p1);
			System.out.println(q1);*/
			Dynamic dynamic = new Dynamic();
			dynamic.setGreens_ID(Integer.parseInt(a1));
			dynamic.setDynamic_Price(h1);
			dynamic.setDynamic_Time(df.format(new Date()));
			dynamic.setDynamic_Market_Price(Float.parseFloat(i1));
			dao1.add(dynamic);
			
		}
		}
		response.sendRedirect("ListServlet1");
	}
	 public static float[] parseFloatArray(String[] str_array) {
	        float[] flo_array = null;
	        if (str_array != null) {
	            flo_array = new float[str_array.length];
	            for (int i = 0; i < str_array.length; i++) {
	                try {
	                    flo_array[i] = Float.parseFloat(str_array[i]);
	                } catch(NumberFormatException e) {
	                    System.out.println(e.getMessage());
	                    // flo_array[i] = -1;
	                    continue;
	                }
	            }
	        }
	        return flo_array;
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
