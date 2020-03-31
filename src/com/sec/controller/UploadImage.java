package com.sec.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
 * Servlet implementation class UploadImage
 */
@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path = "D:\\5\\";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImage() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		//创建工厂
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory ();
		//创建解析器
		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
		List<FileItem> fileItemList;
		try {
			fileItemList = upload.parseRequest(request);
			Iterator<FileItem> iterator = fileItemList.iterator();
			while(iterator.hasNext()){
				FileItem fileItem = (FileItem)iterator.next();
				if(fileItem.isFormField()){
					String name = fileItem.getFieldName();
					String value = fileItem.getString();
				}else{
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					String name = fileItem.getName();
					String filePath = path + df.format(new Date()) + name.substring(name.lastIndexOf("."));
					java.io.File file = new java.io.File(filePath);
					fileItem.write(file);
				}
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
