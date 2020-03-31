package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sumeng.page.Page;
import com.sumeng.service.MenuPath;
import com.sumeng.web.RolePowerDao;

/**
 * Servlet implementation class RolePower
 */
@WebServlet("/RolePower")
public class RolePower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolePower() {
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
		String menuName = request.getParameter("name");
		int roleId = Integer.parseInt(request.getParameter("roleId"));
//		String menuName = "消息管理";
//		int roleId = 5;
		RolePowerDao dao = new RolePowerDao();
		MenuPath byMenuId = dao.getByMenuId(menuName);
		int mId = byMenuId.getId();
		Page list = dao.getRolePowerPare(mId, roleId);
		Object json = JSON.toJSON(list);
		response.getWriter().print(json);
	}

}
