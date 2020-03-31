package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.FenPeiDao;
import com.sec.dao.LogDao;
import com.sec.dao.QunTuiDao;
import com.sec.dao.UappDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Log;
import com.sec.entity.QunTui;
import com.sec.entity.Uapp;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		WineshopDao dao = new WineshopDao();
		String loginName = request.getParameter("userName");
		String loginPwd = request.getParameter("password");
		System.out.println("loginName"+loginName);
		System.out.println("loginPwd"+loginPwd);
		int a = dao.checkWineshop(loginName , loginPwd );
		System.out.println("a"+a);
		
		
        PrintWriter out = response.getWriter();
        if(a !=0){
        	Log log = new Log();
    		UappDao app = new UappDao();
			Uapp appname = new Uapp();
			int size = app.checkName(loginName);
			if(size!=1){
				
			}
			out.print(a);
			out.flush();
			out.close();
        }else {
        	FenPeiDao dao2 = new FenPeiDao();
        	int b = dao2.checkFenPei(loginName, loginPwd);
        	
        	//PrintWriter out1= response.getWriter();
        	if(b!=0) {
        		UappDao app = new UappDao();
    			Uapp appname = new Uapp();
    			int size = app.checkName(loginName);
    			if(size!=1){
        	}
    			
    			out.print(20000);
    			out.flush();
    			out.close();
        }
		
        }
        out.print(0);
		out.flush();
		out.close();
	}

}
