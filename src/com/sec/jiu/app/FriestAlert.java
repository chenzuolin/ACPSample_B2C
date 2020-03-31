package com.sec.jiu.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.entity.Alert;
import com.sumeng.web.AlertDao;

/**
 * Servlet implementation class FriestAlert
 */
@WebServlet("/FriestAlert")
public class FriestAlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriestAlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub]
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String userName = request.getParameter("name");
		AlertDao dao = new AlertDao();
		List<Alert> list = dao.queryId(userName);
	
		if(list.size()==0){
			Alert al = new Alert();
			al.setUserName(userName);
			al.setAlertPath(0);
	 		dao.add(al);
		}else{
			for(Alert dd : list){
				int path = dd.getAlertPath();
				response.getWriter().print(path);
			}
			
		}
	}

}
