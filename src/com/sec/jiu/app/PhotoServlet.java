package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sec.dao.PhotoDao;
import com.sec.entity.Photo;
/**
 * Servlet implementation class PhotoServlet
 */
@WebServlet("/PhotoServlet")
public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoServlet() {
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
   String path = "D:\\Program Files (x86)\\webapps\\app\\jiudianphoto";
   
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
   
   SimpleDateFormat df = new SimpleDateFormat("mmhhss");
   Date date = new Date(System.currentTimeMillis());
   String time = df.format(date);
   System.out.println("time="+time);
   int i = (int)(Math.random()*900)+100;
   System.out.println("i="+i);
   String aa = Integer.parseInt(time) + "" + i;
   System.out.println("aa1="+aa);
   int sum = Integer.parseInt(aa);
   DateFormat cc = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
   String dd = cc.format(date);
   int id = (Integer)request.getSession().getAttribute("w");
		 Photo photo = new Photo();
		 photo.setPhoto_ID(sum);
		 photo.setPhoto_time(dd);
		 photo.setPhoto_path(path);
		 photo.setUser_ID(id);
		 photo.setPhoto_name(fileName);
		 PhotoDao dao = new PhotoDao();
		 dao.add(photo);
		 PrintWriter out = response.getWriter();
		 out.print("<script language='javascript'>window.location.href='Photo.jsp'</script>");
	}

}
