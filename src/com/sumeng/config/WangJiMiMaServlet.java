package com.sumeng.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.sumeng.web.WineshopDao;

/**
 * Servlet implementation class WangJiMiMaServlet
 */
@WebServlet("/WangJiMiMaServlet")
public class WangJiMiMaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WangJiMiMaServlet() {
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
		
		String tel = request.getParameter("tel");
		HashMap<String, Object> result = null;
		WineshopDao dao = new WineshopDao();
		String number = dao.checkTel(tel);
		String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
		PrintWriter writer = response.getWriter();
		if(number.equals("0")){
			writer.print("No");
			writer.close();
		}else if(number.equals("1")){
			CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
			restAPI.init("app.cloopen.com", "8883");
			restAPI.setAccount(Config.ACOUNT_SID, Config.AUTH_TOKEN);
			restAPI.setAppId(Config.APP_ID);
			result = restAPI.sendTemplateSMS(tel,Config.UPDATE_PWD ,new String[]{verifyCode});
			writer.print(verifyCode);
			writer.close();
		}else{
			writer.print("twoNo");
			writer.close();
		}
	}

}
