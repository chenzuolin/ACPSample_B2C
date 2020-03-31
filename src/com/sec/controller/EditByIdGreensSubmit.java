package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

/**
 * Servlet implementation class EditByIdGreensSubmit
 */
@WebServlet("/EditByIdGreensSubmit")
public class EditByIdGreensSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditByIdGreensSubmit() {
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
		String name = request.getParameter("greensName");
		String bigName = request.getParameter("bigType");
		String typeName = request.getParameter("typeName");
		String unit = request.getParameter("unit");
		int minnumber = Integer.parseInt(request.getParameter("minNumber"));
		String weight = request.getParameter("weight");
		int stop = Integer.parseInt(request.getParameter("up"));
		int number = Integer.parseInt(request.getParameter("kucun"));
		float price = Float.parseFloat(request.getParameter("price"));
		float mprice = Float.parseFloat(request.getParameter("mPrice"));
		String address = request.getParameter("addr");
		String tuijian = request.getParameter("tuijian");
		String jijie = request.getParameter("jijie");
		String priod = request.getParameter("day");
		String pinxiang = request.getParameter("pinxiang");
		String pinzhi = request.getParameter("pinzhi");
		int id = Integer.parseInt(request.getParameter("id"));
		//String remark = request.getParameter("remark");
		String gRemark = request.getParameter("gRemark");
		
		Greens green = new Greens();
		green.setBigName(bigName);
		green.setGreens_Type_Name(typeName);
		green.setGreens_Name(name);
		
		green.setGreens_Unit(unit);
		green.setGreens_Price(price);
		green.setGreens_Market_Price(mprice);
		
		green.setGreens_Character(pinzhi);
		green.setGreens_Condition(pinxiang);
		green.setGreens_Minnumber(minnumber);
		
		green.setGreens_Norms(weight);
		green.setGreens_Number(number);
		green.setGreens_Class(address);
		
		green.setGreens_characteristics(jijie);
		green.setGreens_Recommend(tuijian);
		green.setGreens_Remark(gRemark);
		green.setGreens_Preiod(priod);
		green.setGreens_Stop(stop);
		green.setGreens_ID(id);
	
		GreensDao dao = new GreensDao();
		int code = dao.updateDateail(green);
		response.getWriter().print(code);
	}

}
