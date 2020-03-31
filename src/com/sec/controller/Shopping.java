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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

/**
 * Servlet implementation class Shopping
 */
@WebServlet("/Shopping")
public class Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path = "D:\\Program Files (x86)\\webapps\\app\\GreensShop\\";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shopping() {
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
				response.setContentType("text/html;charset=utf-8");
				request.setCharacterEncoding("utf-8");
				//创建工厂
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory ();
				//创建解析器
				ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
				List<FileItem> fileItemList;
				try {
					fileItemList = upload.parseRequest(request);
					Iterator<FileItem> iterator = fileItemList.iterator();
					String greensName = "";
					String bigTypeName = "";
					String typeName= "";
					String unit = "";
					String price = "";
					String markPrice = "";
					String pinzhi = "";
					String pinxiang = "";
					String minNumber = "";
					String weight = "";
					String kucun = "";
					String addr = "";
					String tuijian = "";
					String jijie = "";
					String remark = "";
					String day = "";
					String up = "";
					while(iterator.hasNext()){
						FileItem fileItem = (FileItem)iterator.next();
						if(fileItem.isFormField()){
							String name = fileItem.getFieldName();
							String value = fileItem.getString();
							if("greensName".equals(name)){
								greensName =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("bigTypeName".equals(name)){
								bigTypeName =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("typeName".equals(name)){
								typeName =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("unit".equals(name)){
								unit =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("price".equals(name)){
								price =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("markPrice".equals(name)){
								markPrice =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("pinzhi".equals(name)){
								pinzhi =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("pinxiang".equals(name)){
								pinxiang =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("minNumber".equals(name)){
								minNumber =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("weight".equals(name)){
								weight =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("kucun".equals(name)){
								kucun =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("addr".equals(name)){
								addr =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("tuijian".equals(name)){
								tuijian =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("jijie".equals(name)){
								jijie =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("remark".equals(name)){
								remark =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("day".equals(name)){
								day =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
							if("up".equals(name)){
								up =new String(value.getBytes("iso-8859-1"),"utf-8");
		                    }
						}else{
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							float priceOne = Float.parseFloat(price);
							float priceTwo = Float.parseFloat(markPrice);
							System.out.println(priceOne+priceTwo);
							int Greens_KuCun = Integer.parseInt(kucun);
							int Greens_MinNumber = Integer.parseInt(minNumber);
							int Greens_Stop = Integer.parseInt(up);
							String name = fileItem.getName();
							String filePath = path + greensName + name.substring(name.lastIndexOf("."));
							String tupianName = greensName + name.substring(name.lastIndexOf("."));
							java.io.File file = new java.io.File(filePath);
							fileItem.write(file);
							Greens greens=new Greens();
							greens.setGreens_Type_Name(typeName);
							greens.setGreens_Name(greensName);
							greens.setGreens_Unit(unit);
							greens.setGreens_Character(pinzhi);
							greens.setGreens_Preiod(day);
							greens.setGreens_Norms(weight);
							greens.setGreens_Number(Greens_KuCun);
							greens.setGreens_Price(priceOne);
							greens.setGreens_Market_Price(priceTwo);
							greens.setGreens_Condition(pinxiang);
							greens.setGreens_Minnumber(Greens_MinNumber);
							greens.setGreens_Class(addr);
							greens.setGreens_Grade(1);
							greens.setGreens_characteristics(jijie);
							greens.setGreens_Recommend(tuijian);
							greens.setGreens_Remark(remark);
							greens.setGreens_tupian(tupianName);
							greens.setGreens_Stop(Greens_Stop);
							greens.setBigName(bigTypeName);
							greens.setGreens_Date(df.format(new Date()));
							
							GreensDao dao=new GreensDao();
							int code = dao.addAll(greens);
							response.getWriter().print(code);
							
						}
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	}

}
