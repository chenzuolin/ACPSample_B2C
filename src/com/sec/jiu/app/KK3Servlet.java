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

import com.sec.dao.DynamicDao;
import com.sec.dao.GreensDao;
import com.sec.entity.Dynamic;

/**
 * Servlet implementation class KK3Servlet
 */
@WebServlet("/KK3Servlet")
public class KK3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KK3Servlet() {
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
		int a00 =Integer.parseInt(request.getParameter("aa"));
		int aa = 0;
		if(request.getParameter("aa")==null){
			aa = 1;
		}else{
			aa = a00;
		}
		DynamicDao dao = new DynamicDao(); 
		float a = 0;
		float a1 = 0;
		float cc1 = 0;
		float dd1 = 0;
		List<Dynamic> list111 = dao.findUserByID5("2019-01-01", "2019-02-01");
		for(Dynamic dynamic : list111){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc1 = dynamic.getDynamic_Price();
				 dd1 = dynamic.getDynamic_Market_Price();
				a += cc1;
				a1 += dd1;
				
			}
			
		}
		a = a/31;
		a1 = a1/31;
		float b = 0;
		float b1 = 0;
		float cc2 = 0;
		float dd2 = 0;
		List<Dynamic> list112 = dao.findUserByID5("2019-02-01", "2019-03-01");
		for(Dynamic dynamic : list112){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc2 = dynamic.getDynamic_Price();
				 dd2 = dynamic.getDynamic_Market_Price();
				b += cc2;
				b1 += dd2;
			}
			
		}
		b = b/28;
		b1 = b1/28;
		
		float c = 0;
		float c1 = 0;
		float cc3 = 0;
		float dd3 = 0;
		List<Dynamic> list13 = dao.findUserByID5("2019-03-01", "2019-04-01");
		for(Dynamic dynamic : list13){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				cc3 = dynamic.getDynamic_Price();
				dd3 = dynamic.getDynamic_Market_Price();
				c += cc3;
				c1 += dd3;
			}
			
		}
		c = c/31;
		c1 = c1/31;
		float d = 0;
		float d1 = 0;
		float cc4 = 0;
		float dd4 = 0;
		List<Dynamic> list14 = dao.findUserByID5("2019-04-01", "2019-05-01");
		for(Dynamic dynamic : list14){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc4 = dynamic.getDynamic_Price();
				 dd4 = dynamic.getDynamic_Market_Price();
				d += cc4;
				d1 += dd4;
			}
			
		}
		d = d/30;
		d1 = d1/30;
		float e = 0;
		float e1 = 0;
		float cc5 = 0;
		float dd5 = 0;
		List<Dynamic> list15 = dao.findUserByID5("2019-05-01", "2019-06-01");
		for(Dynamic dynamic : list15){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc5 = dynamic.getDynamic_Price();
				 dd5 = dynamic.getDynamic_Market_Price();
				e += cc5;
				e1 += dd5;
			}
			
		}
		e = e/31;
		e1 = e1/31;
		
		float f = 0;
		float f1 = 0;
		float cc6 = 0;
		float dd6 = 0;
		List<Dynamic> list6 = dao.findUserByID5("2019-06-01", "2019-07-01");
		for(Dynamic dynamic : list6){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc6 = dynamic.getDynamic_Price();
				 dd6 = dynamic.getDynamic_Market_Price();
				f += cc6;
				f1 += dd6;
			}
			
		}
		f = f/30;
		f1 = f1/30;
		float g = 0;
		float g1 = 0;
		float cc7 = 0;
		float dd7 = 0;
		List<Dynamic> list7 = dao.findUserByID5("2019-07-01", "2019-08-01");
		for(Dynamic dynamic : list7){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc7 = dynamic.getDynamic_Price();
				 dd7 = dynamic.getDynamic_Market_Price();
				g += cc7;
				g1 += dd7;
			}
				}
		g = g/31;
		g1 = g1/31;

		float h = 0;
		float h1 = 0;
		float cc8 = 0;
		float dd8 = 0;
		List<Dynamic> list8 = dao.findUserByID5("2019-08-01", "2019-09-01");
		for(Dynamic dynamic : list8){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc8 = dynamic.getDynamic_Price();
				 dd8 = dynamic.getDynamic_Market_Price();
				System.out.println(cc8);
				h += cc8;
				h1 += dd8;
			}
			
			
		}
		h = h/31;
		h1 = h1/31;
		System.out.print(h);
		float i = 0;
		float i1 = 0;
		float cc9 = 0;
		float dd9 = 0;
		List<Dynamic> list9 = dao.findUserByID5("2019-09-01", "2019-10-01");
		for(Dynamic dynamic : list9){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc9 = dynamic.getDynamic_Price();
				 dd9 = dynamic.getDynamic_Market_Price();
				i += cc9;
				i1 += dd9;
			}
			
		}
		i = i/30;
		i1 = i1/30;
		float j = 0;
		float j1 = 0;
		float cc10 = 0;
		float dd10 = 0;
		List<Dynamic> list10 = dao.findUserByID5("2019-10-01", "2019-11-01");
		for(Dynamic dynamic : list10){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc10 = dynamic.getDynamic_Price();
				 dd10 = dynamic.getDynamic_Market_Price();
				j += cc10;
				j1 += dd10;
			}
			
		}
		j = j/31;
		j1 = j1/31;
		float k = 0;
		float k1 = 0;
		float cc11 = 0;
		float dd11 = 0;
		List<Dynamic> list11 = dao.findUserByID5("2019-11-01", "2019-12-01");
		for(Dynamic dynamic : list11){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc11 = dynamic.getDynamic_Price();
				 dd11 = dynamic.getDynamic_Market_Price();
				k += cc11;
				k1 += dd11;
			}
			
		}
		k = k/30;
		k1 = k1/30;
		float l = 0;
		float l1 = 0;
		float cc12 = 0;
		float dd12 = 0;
		List<Dynamic> list12 = dao.findUserByID5("2019-12-01", "2020-01-01");
		for(Dynamic dynamic : list12){
			int bb = dynamic.getGreens_ID();
			if(aa==bb){
				 cc12 = dynamic.getDynamic_Price();
				 dd12 = dynamic.getDynamic_Market_Price();
				l += cc12;
				l1 += dd12;
			}
				}
		l = l/31;
		l1 = l1/31;
		float a2 = (float)(Math.round(a*100))/100;
		float b2 = (float)(Math.round(b*100))/100;
		float c2 = (float)(Math.round(c*100))/100;
		float d2 = (float)(Math.round(d*100))/100;
		float e2 = (float)(Math.round(e*100))/100;
		float f2 = (float)(Math.round(f*100))/100;
		float g2 = (float)(Math.round(g*100))/100;
		float h2 = (float)(Math.round(h*100))/100;
		float i2 = (float)(Math.round(i*100))/100;
		float j2 = (float)(Math.round(j*100))/100;
		float k2 = (float)(Math.round(k*100))/100;
		float l2 = (float)(Math.round(l*100))/100;
		
		List<Float> lists = new ArrayList<Float>();
		lists.add(a2);
		lists.add(b2);
		lists.add(c2);
		lists.add(d2);
		lists.add(e2);
		lists.add(f2);
		lists.add(g2);
		lists.add(h2);
		lists.add(i2);
		lists.add(j2);
		lists.add(k2);
		lists.add(l2);
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
