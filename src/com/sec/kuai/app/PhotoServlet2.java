package com.sec.kuai.app;

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
import com.sec.dao.CourierDao;
import com.sec.entity.Courier;

/**
 * Servlet implementation class PhotoServlet2
 */
@WebServlet("/PhotoServlet2")
public class PhotoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoServlet2() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("gbk");
		 response.setContentType("text/html,gbk");
       //��������ʵ���ļ����ϴ������ز���
       SmartUpload     su=new  SmartUpload();
      
       //��ȡJspFactory����
       JspFactory      jf=JspFactory.getDefaultFactory();
       //��ȡPageContext����
       PageContext   pageContext=jf.getPageContext(this, request, response, "", true, 8192, true);
       
       //ʵ��initialize��������ҪpageContext����
       su.initialize(pageContext);
       String path = "D:\\Program Files (x86)\\webapps\\app\\courier";
       
       try {
						su.upload(); //��ȡ�ļ����ݣ����һЩ׼������
						
						//�ļ������Ŀ¼
						su.save(path);
						
		   } catch (SmartUploadException e) {
						e.printStackTrace();
		   }      
       //��ȡ�ļ���
       Files      files=su.getFiles();   //��ȡȫ�����ϴ��ļ�
       File        fe=files.getFile(0);  //��ȡ��һ���ļ�   ע�⣺File����io������ģ�
       String     fileName=fe.getFileName(); //��ȡ�ļ���
       System.out.println("fileName="+fileName);
       Request x=su.getRequest();
       String name = x.getParameter("courier_name");
       System.out.println("name="+name);
       Courier cc = new Courier();
       cc.setCourier_Photo(fileName);
       cc.setCourier_Name(name);
       CourierDao dao = new CourierDao();
       dao.update3(cc);
       PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>window.location.href='Photo1.jsp'</script>");
	}

}
