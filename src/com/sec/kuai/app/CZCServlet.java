package com.sec.kuai.app;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class CZCServlet
 */
@WebServlet("/CZCServlet")
public class CZCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CZCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
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
			su.save("D:\\Program Files (x86)\\webapps\\ACPSample_B2C\\upload2");
        		} catch (SmartUploadException e) {
        			e.printStackTrace();
        		} 
        //获取文件名
        Files      files=su.getFiles();   //获取全部的上传文件
        File        fe=files.getFile(0);  //获取第一个文件   注意：File不是io包里面的，
        String     fileName=fe.getFileName(); //获取文件名
        Request x=su.getRequest();
		String Greens_Jobber_UserName=x.getParameter("Greens_Jobber_UserName");
		System.out.println("Greens_Jobber_UserName="+Greens_Jobber_UserName);
		String userconfirmpassword=x.getParameter("userconfirmpassword"); 
		System.out.println("userconfirmpassword="+userconfirmpassword);
		String Greens_Jobber_Telephone=x.getParameter("Greens_Jobber_Telephone");
		System.out.println("Greens_Jobber_Telephone="+Greens_Jobber_Telephone);
		String Greens_Jobber_Address=x.getParameter("Greens_Jobber_Address");
		System.out.println("Greens_Jobber_Address="+Greens_Jobber_Address);
		String Greens_Jobber_QQ=x.getParameter("Greens_Jobber_QQ");
		System.out.println("Greens_Jobber_QQ="+Greens_Jobber_QQ);
		String Greens_Jobber_WeChat=x.getParameter("Greens_Jobber_WeChat");
		System.out.println("Greens_Jobber_WeChat="+Greens_Jobber_WeChat);
		String Greens_Jobber_Name=x.getParameter("Greens_Jobber_Name");
		System.out.println("Greens_Jobber_Name="+Greens_Jobber_Name);
		String Greens_Jobber_Shift_Name=x.getParameter("Greens_Jobber_Shift_Name");
		System.out.println("Greens_Jobber_Shift_Name="+Greens_Jobber_Shift_Name);
		System.out.println("fileName="+fileName);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		Greens_Jobber greens_Jobber=new Greens_Jobber();
		greens_Jobber.setGreens_Jobber_UserName(Greens_Jobber_UserName);
		greens_Jobber.setGreens_Jobber_Password(userconfirmpassword);
		greens_Jobber.setRole_ID(1);
		greens_Jobber.setGreens_Jobber_Name(Greens_Jobber_Name);
		greens_Jobber.setGreens_Jobber_Aptitude(fileName);
		greens_Jobber.setGreens_Jobber_Address(Greens_Jobber_Address);
		greens_Jobber.setGreens_Jobber_Shift_Name(Greens_Jobber_Shift_Name);
		greens_Jobber.setGreens_Jobber_Telephone(Greens_Jobber_Telephone);
	    greens_Jobber.setGreens_Jobber_Time(df.format(new Date()));
	    greens_Jobber.setRegionality_ID(3);
	    greens_Jobber.setGreens_Jobber_QQ(Greens_Jobber_QQ);
	    greens_Jobber.setGreens_Jobber_WeChat(Greens_Jobber_WeChat);
	    greens_Jobber.setGreens_Jobber_Grade("1");
		Greens_JobberDao dao=new Greens_JobberDao();
		dao.add(greens_Jobber);
		PrintWriter out=response.getWriter();
		out.print(1);
		out.close();
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
