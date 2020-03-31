package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProvinceServlet
 */
@javax.servlet.annotation.WebServlet(name = "ProvinceServlet",urlPatterns = "/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        String province = request.getParameter("province");

        //这里是返回的是XML，因此指定XML数据！
        response.setContentType("text/xml;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        /****************返回XML文件给前台**************/
        printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
        printWriter.write("<root>");
        if("广东".equals(province)){
            printWriter.write("<city>广州</city>");
            printWriter.write("<city>深圳</city>");
            printWriter.write("<city>中山</city>");
        }else if("湖南".equals(province)){
            printWriter.write("<city>长沙</city>");
            printWriter.write("<city>株洲</city>");
            printWriter.write("<city>湘潭</city>");
            printWriter.write("<city>岳阳</city>");
        }
        printWriter.write("</root>");

        System.out.println("1111");


        /*******事后操作*******/
        printWriter.flush();
        printWriter.close();
	}

}
