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
				String ee = greens.getGreens_Name();//����
				Float ff = greens.getGreens_Price();//����
				String gg = greens.getGreens_Unit();//��λ
				String hh = greens.getGreens_Character();//Ʒ��
				String ii = greens.getGreens_Preiod();//������
				String jj = greens.getGreens_Norms();//���
				int kk = greens.getGreens_Number();//�����
				String ll = greens.getGreens_Condition();//Ʒ��
				int mm = greens.getGreens_Minnumber();//���ٲɹ���
				String nn = greens.getGreens_Class();//����
				String oo = greens.getGreens_Remark();//��ע
				String pp =  greens.getGreens_tupian();//ͼƬ
				Float qq = greens.getGreens_Market_Price();//�г���
				int rr = greens.getGreens_ID();//ID
				KK k = new KK();
				k.setAa(ee);//�߲�����
				k.setBb(dd);//���ﳵ����
				k.setCc(ff);//����
				k.setDd(gg);//��λ
				k.setEe(qq);//�г���
				k.setFf(pp);//ͼƬ
				k.setGg(hh);//Ʒ��
				k.setHh(ii);//������
				k.setKk(jj);//���
				k.setIi(kk);//�����
				k.setJj(ll);//Ʒ��
				k.setLl(mm);//���ٲɹ���
				k.setMm(nn);//����
				k.setNn(oo);//��ע
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
