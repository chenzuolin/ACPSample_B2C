package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

/**
 * Servlet implementation class GreensServlet
 */
@WebServlet("/GreensServlet")
public class GreensServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreensServlet() {
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
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html,gbk");
   		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
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
			su.save("D://Program Files (x86)//webapps//app//GreensShop");
			
        } catch (SmartUploadException e) {
			e.printStackTrace();
        }    
        Files      files=su.getFiles();   //��ȡȫ�����ϴ��ļ�
        File        fe=files.getFile(0);  //��ȡ��һ���ļ�   ע�⣺File����io������ģ�
        String     fileName=fe.getFileName(); //��ȡ�ļ���
        
        System.out.println("fileName="+fileName);
        Request t=su.getRequest();
        String Greens_Period1 = t.getParameter("Greens_Period1");
        System.out.println(Greens_Period1);
        
        String Greens_Period2 = t.getParameter("Greens_Period2");
        System.out.println(Greens_Period2);
        
        String Greens_Period = Greens_Period2+Greens_Period1;
        System.out.println(Greens_Period);
        
        String Greens_Type_Name = t.getParameter("Greens_Type_Name");
		System.out.println(Greens_Type_Name);
		
		String Greens_Name=t.getParameter("Greens_Name");
		System.out.println(Greens_Name);
		
		String Greens_Unit=t.getParameter("Greens_Unit");
		System.out.println(Greens_Unit);
		
		String a=t.getParameter("Greens_Price");
		Float Greens_Price=Float.parseFloat(a);
		System.out.println(Greens_Price);
		
		String b=t.getParameter("Greens_Market_Price");
		Float Greens_Market_Price=Float.parseFloat(b);
		System.out.println(Greens_Market_Price);
		
		String Greens_Character=t.getParameter("Greens_Character");
		System.out.println(Greens_Character);
		
		String Greens_Condition=t.getParameter("Greens_Condition");
		System.out.println(Greens_Condition);
		
		String Greens_Minnumber=t.getParameter("Greens_Minnumber");
		int x=Integer.parseInt(Greens_Minnumber);
		System.out.println(x);
		
		String Greens_Norms=t.getParameter("Greens_Norms");
		System.out.println(Greens_Norms);
		
		String Greens_Number=t.getParameter("Greens_Number");
		int y=Integer.parseInt(Greens_Number);
		System.out.println(y);
		 
		String Greens_Class=t.getParameter("Greens_Class");
		System.out.println(Greens_Class);
		
		String Greens_characteristics=t.getParameter("Greens_characteristics");
		System.out.println(Greens_characteristics);
		
		String Greens_Recommend=t.getParameter("Greens_Recommend");
		System.out.println(Greens_Recommend);
		
		String Greens_Remark=t.getParameter("Greens_Remark");
		System.out.println(Greens_Remark);
		
		Greens greens=new Greens();
		greens.setGreens_Type_Name(Greens_Type_Name);
		greens.setGreens_Name(Greens_Name);
		greens.setGreens_Unit(Greens_Unit);
		greens.setGreens_Character(Greens_Character);
		greens.setGreens_Preiod(Greens_Period);
		greens.setGreens_Norms(Greens_Norms);
		greens.setGreens_Number(y);
		greens.setGreens_Price(Greens_Price);
		greens.setGreens_Market_Price(Greens_Market_Price);
		greens.setGreens_Condition(Greens_Condition);
		greens.setGreens_Minnumber(x);
		greens.setGreens_Class(Greens_Class);
		greens.setGreens_Grade(1);
		greens.setGreens_characteristics(Greens_characteristics);
		greens.setGreens_Recommend(Greens_Recommend);
		greens.setGreens_Remark(Greens_Remark);
		greens.setGreens_Time(df.format(new Date()));
		greens.setGreens_tupian(fileName);
		
		GreensDao dao=new GreensDao();
		dao.add(greens);
		request.getRequestDispatcher("shopup.jsp").forward(request, response);
		
		
	}

}
