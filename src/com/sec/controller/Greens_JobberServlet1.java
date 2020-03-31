package com.sec.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.sec.dao.Greens_JobberDao;
import com.sec.entity.Greens_Jobber;

/**
 * Servlet implementation class Greens_JobberServlet
 * @param <span>
 */
@WebServlet("/Greens_JobberServlet1")
public class Greens_JobberServlet1<span> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greens_JobberServlet1() {
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
		
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html,GBK");
		
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
						su.save("D:/photo/Greens_jobber/");
						
		   } catch (SmartUploadException e) {
						e.printStackTrace();
		   }      
        
        
        //获取文件名
        Files      files=su.getFiles();   //获取全部的上传文件
        File        fe=files.getFile(0);  //获取第一个文件   注意：File不是io包里面的，
        String     fileName=fe.getFileName(); //获取文件名
        
        System.out.println("fileName="+fileName);
        Request y=su.getRequest();
        String one=y.getParameter("Greens_Jobber_UserName");
        System.out.println("one="+one);
        String two=y.getParameter("Greens_Jobber_Password");
        System.out.println("two="+two);
        String three=y.getParameter("Greens_Jobber_Name");
        System.out.println("three="+three);
        String four=y.getParameter("Greens_Jobber_QQ");
        System.out.println("four="+four);
        String five=y.getParameter("Greens_Jobber_WeChat");
        System.out.println("five="+five);
        String six=y.getParameter("Greens_Jobber_Shift_Name");
        System.out.println("six="+six);
        String seven=y.getParameter("Greens_Jobber_Address");
        System.out.println("seven="+seven);
        String eight=y.getParameter("Greens_Jobber_Telephone");
        System.out.println("eight="+eight);
       
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	
		Greens_Jobber greens_Jobber=new Greens_Jobber();
		greens_Jobber.setGreens_Jobber_UserName(one);
		greens_Jobber.setGreens_Jobber_Password(two);
		greens_Jobber.setRole_ID(1);
		greens_Jobber.setGreens_Jobber_Name(three);
		greens_Jobber.setGreens_Jobber_Aptitude(fileName);
		greens_Jobber.setGreens_Jobber_Address(seven);
		greens_Jobber.setGreens_Jobber_Shift_Name(six);
		greens_Jobber.setGreens_Jobber_Telephone(eight);
	    greens_Jobber.setGreens_Jobber_Time(df.format(new Date()));
	    greens_Jobber.setRegionality_ID(3);
	    greens_Jobber.setGreens_Jobber_QQ(four);
	    greens_Jobber.setGreens_Jobber_WeChat(five);
	    greens_Jobber.setGreens_Jobber_Grade("1");
		Greens_JobberDao dao=new Greens_JobberDao();
		dao.add(greens_Jobber);
		request.getRequestDispatcher("login1.jsp").forward(request, response);
	}

}
