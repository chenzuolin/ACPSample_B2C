package com.sec.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sec.dao.WineshopDao;
import com.sec.entity.Wineshop;

@WebServlet("/ServletFileUpLoad")
public class ServletFileUpLoad extends HttpServlet {
	public ServletFileUpLoad() {
	}
	public void destroy() {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   
		   request.setCharacterEncoding("gbk");
		   response.setContentType("text/html,gbk");
		   
           
           //该类用于实现文件的上传于下载操作
           SmartUpload     su=new  SmartUpload();
           
           //获取JspFactory对象
           JspFactory      jf=JspFactory.getDefaultFactory();
           //获取PageContext对象
           PageContext   pageContext=jf.getPageContext(this, request, response, "", true, 8192, true);
           
           //实现initialize方法，需要pageContext对象
           su.initialize(pageContext);
           
           
           try {
						su.upload(); //读取文件数据，完成一些准备工作
						
						//文件保存的目录
						su.save("D:/Program Files (x86)/webapps/app/jiudianzizhi");
						
		   } catch (SmartUploadException e) {
						e.printStackTrace();
		   }      
           
           
           //获取文件名
           Files      files=su.getFiles();   //获取全部的上传文件
           File        fe=files.getFile(0);  //获取第一个文件   注意：File不是io包里面的，
           String     fileName=fe.getFileName(); //获取文件名
           
           System.out.println("fileName="+fileName);
           //剩下的是不是往数据库里面存
           //获取账号，获取数据都需要用jar包中的Request。
           Request x=su.getRequest();
           String one=x.getParameter("Wineshop_UserName");
           System.out.println("one="+one);
           String two=x.getParameter("Wineshop_Password");
           System.out.println("two="+two);
           String three=x.getParameter("Wineshop_Name");
           System.out.println("three="+three);
           String Wineshop_Number=x.getParameter("Wineshop_Number");
           System.out.println(Wineshop_Number);
           String five=x.getParameter("Wineshop_Telephone");
           System.out.println("five="+five);
           String six=x.getParameter("Wineshop_Nature");
           System.out.println("six="+six);
           String server=x.getParameter("Wineshop_Address");
           System.out.println("server="+server);
           String Wineshop_QQ=x.getParameter("Wineshop_QQ");
           System.out.println(Wineshop_QQ);
           String ten=x.getParameter("Wineshop_WeChat");
           System.out.println("ten="+ten);
           String ten11=x.getParameter("Wineshop_Shift_Name");
           System.out.println("ten11="+ten11);
           
           
           
           WineshopDao dao=new WineshopDao();
           Wineshop wineshop=new Wineshop();
           wineshop.setWineshop_UserName(one);
   		   wineshop.setWineshop_Password(two);
   		   wineshop.setRole_ID(2);
   		   wineshop.setWineshop_Name(three);
   		   wineshop.setRegionality_ID(3);
   		   wineshop.setWineshop_Aptitude(fileName);
   		   wineshop.setWineshop_Condition(1);
   		   wineshop.setWineshop_Address(server);
   		   wineshop.setWineshop_Shift_Name(ten11);
   		   wineshop.setWineshop_Telephone(five);
   		   wineshop.setWineshop_Class(1);
   		   wineshop.setWineshop_Nature(six);
   		   wineshop.setWineshop_QQ(Wineshop_QQ);
   		   wineshop.setWineshop_WeChat(ten);
   		   wineshop.setWineshop_Number(Wineshop_Number);
   		   dao.add(wineshop);
   		
   		request.getRequestDispatcher("login1.jsp").forward(request, response);
           
           
	        
           
	}
	public void init() throws ServletException {
	}
}










