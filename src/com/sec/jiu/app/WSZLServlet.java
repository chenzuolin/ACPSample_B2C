package com.sec.jiu.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class WSZLServlet
 */
@WebServlet("/WSZLServlet")
public class WSZLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WSZLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("xxxx");
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setContentType("text/html;charset=UTF-8");

	        //����һ������������
	        DiskFileItemFactory factory=new DiskFileItemFactory();
	        //���ù������ڴ滺������С��Ĭ����10K
	        factory.setSizeThreshold(1024*1024);
	        //���ù�������ʱ�ļ�Ŀ¼�����ϴ��ļ��Ĵ�С���ڻ�������Сʱ����ʹ����ʱ�ļ�Ŀ¼�����ϴ����ļ�
	        factory.setRepository(new File("D:/photo/Wineshop/"));
	       //�ļ��ϴ�������
	        ServletFileUpload upload=new ServletFileUpload(factory);
	       //���������ϴ����ݵ����ֵ����λ�ֽ�long  1M
	        upload.setSizeMax(1024*1024);
	        //���õ����ļ��ϴ������ֵ
	        upload.setFileSizeMax(1024*1024);
	        //���ñ����ʽ
	        upload.setHeaderEncoding("UTF-8");
	        try {
	            //�������󣬽�����ÿ���������װ��һ��FileItem����
	            List<FileItem> itemList=upload.parseRequest(request);
	            for(FileItem item:itemList){
	                //�ж������������ ��ͨ������ �����ļ�
	                if(item.isFormField()){
	                    //��ͨ������ ,�õ�input�е�name���Ե�ֵ
	                    String name=item.getFieldName();
	                    //�õ��������е�ֵ
	                    String value=item.getString("UTF-8");
	                    System.out.println("name="+name+"  value="+value);
	                   
	                }else{
	                    //�ϴ������ļ�������ļ��ϴ��ֶ��е��ļ���
	                    //ע��IE��FireFox�л�ȡ���ļ����ǲ�һ���ģ�IE���Ǿ���·����FireFox��ֻ���ļ�����
	                    String fileName=item.getName();
	                    System.out.println("fileName="+fileName);
	                    //���ر���ǩname���Ե�ֵ
	                    String namede=item.getFieldName();
	                    System.out.println("namede="+namede);
	                    
	                   //����һ�������ϴ��ļ���ָ�����ļ�·��`
	                    InputStream is=item.getInputStream();
	                    FileOutputStream fos=new FileOutputStream("D:/Program Files (x86)/webapps/app/jiudianzizhi/"+fileName);
	                    byte[] buff=new byte[1024];
	                    int len=0;
	                    while((len=is.read(buff))>0){
	                        fos.write(buff);
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       PrintWriter out = response.getWriter();
	       out.print(1);
	       out.flush();
	       out.close();
	}

	

}
