package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itsource.pay.servlet.EntCoordSyncJob;

import com.sec.dao.Fare_PriceDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Fare_Price;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class GG3Servlet
 */
@WebServlet("/GG3Servlet")
public class GG3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GG3Servlet() {
        super();
        // TODO Auto-generated constructor stub
	    }
    EntCoordSyncJob a1 = new EntCoordSyncJob();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Float aa = Float.parseFloat(request.getParameter("zl"));//总重量
		String bb = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		int cc = dao.findUserByID2(bb);
		List<Wineshop> list = dao.findUserByID(cc);
		for(Wineshop wineshop : list){
			String dd = wineshop.getWineshop_Address();
			String ee = a1.getCoordinate(dd);
			String ff = a1.getCoordinate("甘肃省兰州市城关区雁滩路159号");
			Long gg = a1.getDistance(ee, ff);
			Long hh = gg/1000;//公里数
			float a1 = 0;
			Fare_PriceDao daos = new Fare_PriceDao();
		 	List<Fare_Price> lists = daos.findAll();
		 	for(Fare_Price b : lists){
		 		if(b.getBb()>=aa){
		 			a1 = b.getAa();
		 		}else{
		 			float b1 = aa - b.getBb();
		 			float b2 = b1/b.getFf();
		 			float b3 = b2*b.getGg();
		 			a1 = b3 + b.getAa();
		 		}
		 		if(b.getCc()>=hh){
		 			
		 		}else{
		 			float a5 = hh-b.getCc();
		 			float a6 = a5/b.getDd();
		 			float a7 = a6*b.getEe();
		 			a1 = a1 + a7;
		 		}
		 	}
		 	float b1 = (float)(Math.round(a1*100))/100;
		 	PrintWriter out = response.getWriter();
			out.print(b1);
			out.flush();
			out.close();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
