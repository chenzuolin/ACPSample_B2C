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
 * Servlet implementation class GreensServlet1
 */
@WebServlet("/GreensServlet1")
public class GreensServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreensServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html,GBK");
		
		//��������ʵ���ļ����ϴ������ز���
        SmartUpload     su=new  SmartUpload();
        
        //��ȡJspFactory����
        JspFactory      jf=JspFactory.getDefaultFactory();
        //��ȡPageContext����
        PageContext   pageContext=jf.getPageContext(this, request, response, "", true, 8192, true);
      //ʵ��initialize��������ҪpageContext����
        su.initialize(pageContext);
        
        
        try {
						su.upload(); //��ȡ�ļ����ݣ����һЩ׼������
						
						//�ļ������Ŀ¼
						su.save("D://tomcat8.0//webapps//ACPSample_B2C//upload2");
						
		   } catch (SmartUploadException e) {
						e.printStackTrace();
		   }      
        
        
        //��ȡ�ļ���
        Files      files=su.getFiles();   //��ȡȫ�����ϴ��ļ�
        File        fe=files.getFile(0);  //��ȡ��һ���ļ�   ע�⣺File����io������ģ�
        String     fileName=fe.getFileName(); //��ȡ�ļ���
        
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
        int Greens_Jobber_QQ=Integer.parseInt(four);
        String five=y.getParameter("Greens_Jobber_WeChat");
        System.out.println("five="+five);
        String six=y.getParameter("Greens_Jobber_Shift_Name");
        System.out.println("six="+six);
        String seven=y.getParameter("Greens_Jobber_Address");
        System.out.println("seven="+seven);
        String eight=y.getParameter("Greens_Jobber_Telephone");
        System.out.println("eight="+eight);
       
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	
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
	    greens_Jobber.setGreens_Jobber_WeChat(four);
	    greens_Jobber.setGreens_Jobber_Grade("1");
		Greens_JobberDao dao=new Greens_JobberDao();
		dao.add(greens_Jobber);
	}
	

}
