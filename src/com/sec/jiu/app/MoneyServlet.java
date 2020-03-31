package com.sec.jiu.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sec.Activity.Activity;
import com.sec.Activity.SB;
import com.sumeng.web.MoneyDao;

/**
 * Servlet implementation class MoneyServlet
 */
@WebServlet("/money")
public class MoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		Integer wid = Integer.parseInt(request.getParameter("id"));
		MoneyDao money = new MoneyDao();
		SB queryAll = money.queryAll(wid);
		String total=null;
		if(queryAll==null){
			total = "0.00";
		}else{
			total = queryAll.getSB_Num();
		}
		List<Activity> queryMoney = money.queryMoney(wid);
		List<Map<String, Object>> queryXiaofei = money.queryXiaofei(wid);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", total);
		map.put("czjl", queryMoney);
		map.put("xfjl", queryXiaofei);
		Object json = JSON.toJSON(map);
		response.getWriter().print(json);
		
	}

}
