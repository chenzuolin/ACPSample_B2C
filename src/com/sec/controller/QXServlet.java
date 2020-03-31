package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.PermissionDao;
import com.sec.dao.User_PermissionDao;
import com.sec.entity.User_Permission;

/**
 * Servlet implementation class QXServlet
 */
@WebServlet("/QXServlet")
public class QXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QXServlet() {
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
		PermissionDao dao = new PermissionDao();
		User_PermissionDao dao1 = new User_PermissionDao();
		User_Permission user_Permission = new User_Permission();
		String aa = request.getParameter("zz");//权限名称
		int bb = Integer.parseInt(request.getParameter("xx"));//userid
		int dd = dao1.findUserByID2(bb);
		int cc = dao.findUserByID1(aa);//权限ID
		if(dd==0) {	
		user_Permission.setUser_ID(bb);
		user_Permission.setPermission_ID(cc);
		dao1.add(user_Permission);
		}else {
			int ee = dao1.findUserByID1(bb);
			user_Permission.setUser_ID(bb);
			user_Permission.setPermission_ID(cc);
			user_Permission.setUser_Permission_ID(ee);
			dao1.update(user_Permission);
			
		}
		response.sendRedirect("QX.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
