package com.sec.jiu.app;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Back_Money;
import com.sec.dao.Back_MoneyDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class LLL1Servlet
 */
@WebServlet("/LLL1Servlet")
public class LLL1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LLL1Servlet() {
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String aa = request.getParameter("name");//æ∆µÍ√˚≥∆
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);//æ∆µÍID
		List<Wineshop> list = dao.findUserByID(bb);
		String cc = null;
		for(Wineshop wineshop : list){
			cc = wineshop.getWineshop_Name();
		}
		Back_MoneyDao daoo = new Back_MoneyDao();
		Back_Money bm = new Back_Money();
		bm.setWineshop_Name(cc);
		bm.setBack_Money(0);
		bm.setBack_Money_Time(df.format(new Date()));
		
	}

}
