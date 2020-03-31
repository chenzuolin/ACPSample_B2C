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

        //�����Ƿ��ص���XML�����ָ��XML���ݣ�
        response.setContentType("text/xml;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        /****************����XML�ļ���ǰ̨**************/
        printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
        printWriter.write("<root>");
        if("�㶫".equals(province)){
            printWriter.write("<city>����</city>");
            printWriter.write("<city>����</city>");
            printWriter.write("<city>��ɽ</city>");
        }else if("����".equals(province)){
            printWriter.write("<city>��ɳ</city>");
            printWriter.write("<city>����</city>");
            printWriter.write("<city>��̶</city>");
            printWriter.write("<city>����</city>");
        }
        printWriter.write("</root>");

        System.out.println("1111");


        /*******�º����*******/
        printWriter.flush();
        printWriter.close();
	}

}
