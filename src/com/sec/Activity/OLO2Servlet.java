package com.sec.Activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CGDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.WineshopDao;
import com.sec.dao.XLFPDao;
import com.sec.entity.CG;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.PPP;
import com.sec.entity.Wineshop;
import com.sec.entity.XLFP;

/**
 * Servlet implementation class OLO2Servlet
 */
@WebServlet("/OLO2Servlet")
public class OLO2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OLO2Servlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		IndentDao dao = new IndentDao();
		List<Indent> list = dao.findUserByID(id);
		int aa = (Integer)request.getSession().getAttribute("GHS");
		CGDao daoq = new CGDao();
		List<CG> list2 = daoq.findUserByIDss(aa);
		String Name = null;
		for(CG w : list2){ 
			Name = w.getCG_UserName();
		}
		XLFPDao daos = new XLFPDao();
		List<String> lists = new ArrayList<String>(); 
		List<PPP> listss = new ArrayList<PPP>();
		
		List<XLFP> list1 = daos.findUserByID1(Name);
		for(XLFP x : list1){
			String Greens_Type_Name = x.getGreens_Type_Name();
			lists.add(Greens_Type_Name);
		}
		OrderDao daoss = new OrderDao();
		List<Order> listsss = daoss.findUserByID1(id);
		for(Order order : listsss){
			String lp = order.getGreens_Type_Name();
			if(lists.contains(lp)){
				PPP p = new PPP();
				String bb = order.getGreens_Name();
				String dd = order.getGreens_Unit();
				int cc = order.getNumber();
				p.setBb(bb);
				p.setAa(cc);
				p.setCc(dd);
				listss.add(p);
			}
		}
		
		request.setAttribute("d", list);
		request.setAttribute("gr", listss);
		request.getRequestDispatcher("GHS22.jsp").forward(request, response);
		
		
	}

}
