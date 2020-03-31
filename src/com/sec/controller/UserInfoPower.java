package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.entity.User;
import com.sec.util.StaticFinal;
import com.sumeng.web.UserDao;

/**
 * Servlet implementation class UserInfoPower
 */
@WebServlet("/UserInfoPower")
public class UserInfoPower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoPower() {
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
	 * 
	 * @param userName
	 * @param pwd
	 * @param brithday
	 * @param sex
	 * @param roleId
	 * @param proFile
	 * @return
	 */
	public int addUser(String userName,String pwd,String brithday,int sex,int roleId,String proFile){
		String time = new StaticFinal().getTime();
		User user = new User();
		user.setUser_Name(userName);
		user.setUser_Password(pwd);
		user.setRole_ID(roleId);
		user.setDepartment_ID(1);
		user.setSex(sex);
		user.setBirthday(brithday);
		user.setProfile(proFile);
		user.setUser_Date(time);
		UserDao dao = new UserDao();
		int uId = dao.addUserInfo(user);
		return uId;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwdOne");
		String birthday = request.getParameter("birthday");
		int sex = Integer.parseInt(request.getParameter("sex"));
		int roleId =  Integer.parseInt(request.getParameter("rolePower"));
		String proFile = request.getParameter("proFile");
		int msg = this.addUser(userName, pwd, birthday, sex, roleId, proFile);
		response.getWriter().print(msg);
	}

}
