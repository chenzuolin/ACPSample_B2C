package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.entity.User;
import com.sumeng.web.UserDao;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String birthday = request.getParameter("birthday");
		int rolePower = Integer.parseInt(request.getParameter("rolePower"));
		String proFile = request.getParameter("proFile");
		int uid = Integer.parseInt(request.getParameter("uid"));
		User user = new User();
		user.setUser_Name(userName);
		user.setUser_Password(pwd);
		user.setBirthday(birthday);
		user.setRole_ID(rolePower);
		user.setProfile(proFile);
		user.setUser_ID(uid);
		UserDao dao = new UserDao();
		int code = dao.updateUser(user);
		response.getWriter().print(code);
	}

}
