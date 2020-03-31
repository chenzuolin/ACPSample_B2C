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

import com.sec.dao.CartDao;
import com.sec.dao.GreensDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;
import com.sec.entity.Greens;
import com.sec.entity.KK;

/**
 * Servlet implementation class KK1Servlet
 */
@WebServlet("/KK1Servlet")
public class KK1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KK1Servlet() {
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
		String aa = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		List<KK> lists = new ArrayList<KK>();
		int bb = dao.findUserByID2(aa);
		CartDao dao2 = new CartDao();
		List<Cart> list = dao2.findUserByID(bb);
		for(Cart cart : list){
			int cc = cart.getGreens_ID();
			int dd = cart.getNumber();
			GreensDao dao3 = new GreensDao();
			List<Greens> list2 = dao3.findUserByID(cc);
			for(Greens greens : list2){
				String ee = greens.getGreens_Name();//名称
				Float ff = greens.getGreens_Price();//单价
				String gg = greens.getGreens_Unit();//单位
				String hh = greens.getGreens_Character();//品质
				String ii = greens.getGreens_Preiod();//保质期
				String jj = greens.getGreens_Norms();//规格
				int kk = greens.getGreens_Number();//库存量
				String ll = greens.getGreens_Condition();//品相
				int mm = greens.getGreens_Minnumber();//最少采购量
				String nn = greens.getGreens_Class();//产地
				String oo = greens.getGreens_Remark();//备注
				String pp =  greens.getGreens_tupian();//图片
				Float qq = greens.getGreens_Market_Price();//市场价
				int rr = greens.getGreens_ID();//ID
				KK k = new KK();
				k.setAa(ee);//蔬菜名称
				k.setBb(dd);//购物车数量
				k.setCc(ff);//单价
				k.setDd(gg);//单位
				k.setEe(qq);//市场价
				k.setFf(pp);//图片
				k.setGg(hh);//品质
				k.setHh(ii);//保质期
				k.setKk(jj);//规格
				k.setIi(kk);//库存量
				k.setJj(ll);//品相
				k.setLl(mm);//最少采购量
				k.setMm(nn);//产地
				k.setNn(oo);//备注
				k.setOo(rr);
				lists.add(k);
			}
		}
		JSONArray json = JSONArray.fromObject(lists);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

}
