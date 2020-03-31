package com.sec.kuai.app;

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
 * Servlet implementation class CSWSZLServlet
 */
@WebServlet("/CSWSZLServlet")
public class CSWSZLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSWSZLServlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setContentType("text/html;charset=UTF-8");

	        //创建一个解析器工厂
	        DiskFileItemFactory factory=new DiskFileItemFactory();
	        //设置工厂的内存缓冲区大小，默认是10K
	        factory.setSizeThreshold(1024*1024);
	        //设置工厂的临时文件目录：当上传文件的大小大于缓冲区大小时，将使用临时文件目录缓存上传的文件
	        factory.setRepository(new File("D:/photo/Greens_jobber/"));
	       //文件上传解析器
	        ServletFileUpload upload=new ServletFileUpload(factory);
	       //设置所有上传数据的最大值，单位字节long  1M
	        upload.setSizeMax(1024*1024);
	        //设置单个文件上传的最大值
	        upload.setFileSizeMax(1024*1024);
	        //设置编码格式
	        upload.setHeaderEncoding("UTF-8");
	        try {
	            //解析请求，将表单中每个输入项封装成一个FileItem对象
	            List<FileItem> itemList=upload.parseRequest(request);
	            for(FileItem item:itemList){
	                //判断输入的类型是 普通输入项 还是文件
	                if(item.isFormField()){
	                    //普通输入项 ,得到input中的name属性的值
	                    String name=item.getFieldName();
	                    //得到输入项中的值
	                    String value=item.getString("UTF-8");
	                    System.out.println("name="+name+"  value="+value);
	                   
	                }else{
	                    //上传的是文件，获得文件上传字段中的文件名
	                    //注意IE或FireFox中获取的文件名是不一样的，IE中是绝对路径，FireFox中只是文件名。
	                    String fileName=item.getName();
	                    System.out.println("fileName="+fileName);
	                    //返回表单标签name属性的值
	                    String namede=item.getFieldName();
	                    System.out.println("namede="+namede);
	                    
	                   //方法一：保存上传文件到指定的文件路径`
	                    InputStream is=item.getInputStream();
	                    FileOutputStream fos=new FileOutputStream("D:/photo/Greens_jobber/"+fileName);
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
