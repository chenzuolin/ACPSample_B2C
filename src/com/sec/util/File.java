package com.sec.util;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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

import com.gexin.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sec.entity.Wineshop;
import com.sumeng.web.WineshopDao;


/**
 * Servlet implementation class File
 */
@WebServlet("/File")
public class File extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path = "D:\\Program Files (x86)\\webapps\\app\\jiudianzizhi\\";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public File() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * 用来判断是否上传的时营业执照
	 * @param number 信用代码
	 * @param unitName 单位名称
	 * @param faName 法人
	 * @param addr 注册地址
	 * @param typeL 经营类型
	 * @param startTime 成立时间
	 * @param endTime 有效期
	 * @return
	 */
	public int ifElse(String number,String unitName,String faName,String addr,String typeL,String startTime,String endTime){
		int msg = 0;
		if(number.equals("无") && unitName.equals("无") && faName.equals("无") && addr.equals("无") && typeL.equals("无")
				&& startTime.equals("无") && endTime.equals("无")){
			msg = 500;
		}else if(number.equals("无")){
			msg = 500;
		}else if(unitName.equals("无")){
			msg = 500;
		}else if(faName.equals("无")){
			msg = 500;
		}else if(addr.equals("无")){
			msg = 500;
		}else if(typeL.equals("无")){
			msg = 500;
		}else if(startTime.equals("无")){
			msg = 500;
		}else if(endTime.equals("无")){
			msg = 500;
		}else{
			
		}
		return msg;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		//创建工厂
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory ();
		//创建解析器
		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = df.format(new Date());
		int code = 0;
		try {
			//解析上传表单
			List<FileItem> fileItemList = upload.parseRequest(request);
			Iterator<FileItem> iterator = fileItemList.iterator();
			String fuzename = "";
			//酒店登录名称
			String username = "";
			while(iterator.hasNext()){
				FileItem fileItem = (FileItem)iterator.next();
				//判断是否是普通表单项
				if(fileItem.isFormField()){
					String name = fileItem.getFieldName();
					String value = fileItem.getString();
					if("fuzename".equals(name)){
						fuzename =new String(value.getBytes("iso-8859-1"),"utf-8");
                    }
					if("username".equals(name)){
						username =new String(value.getBytes("iso-8859-1"),"utf-8");
                    }
				}else{
					WineshopDao dao = new WineshopDao();
					Wineshop wineshop = dao.byId(username);
					int id = wineshop.getWineshop_ID();
					String wineshop_Aptitude = wineshop.getWineshop_Aptitude();
					if(wineshop_Aptitude.equals("")){
						String name = fileItem.getName();
						String filePath = path + time + name.substring(name.lastIndexOf("."));
						String url = request.getScheme()+"://"+ request.getServerName()+"/app/jiudianzizhi/";
						String photo = url +time + name.substring(name.lastIndexOf("."));
						java.io.File file = new java.io.File(filePath);
						fileItem.write(file);
//						OutputStream outputStream = new FileOutputStream(file);
//						InputStream inputStream = fileItem.getInputStream();
//						int length = 0;
//						byte[] buf = new byte[1024];
//							while((length = inputStream.read(buf)) != -1){
//								System.out.println(buf);
//							 	outputStream.write(buf, 0, length);
//							}
//						inputStream.close();
//						outputStream.close();
						
						String resoult = Yingyezhizhao.getAuth(filePath);
						//创建json解析器
						JsonParser parse =new JsonParser();
						//将得到的resoult转换为json对象
						JsonObject json=(JsonObject) parse.parse(resoult);
						//从json对象中得到Words_result
						JsonObject result=json.get("words_result").getAsJsonObject();
						//得到社会信用代码对象
						JsonObject totalNumbnerObject=result.get("社会信用代码").getAsJsonObject();
						//得到单位名成对象
						JsonObject unitUserName=result.get("单位名称").getAsJsonObject();
						//得到法人对象
						JsonObject faRen=result.get("法人").getAsJsonObject();
						//得到地址对象
						JsonObject address=result.get("地址").getAsJsonObject();
						//得到类型对象
						JsonObject type=result.get("类型").getAsJsonObject();
						//得到成立日期对象
						JsonObject startDate=result.get("成立日期").getAsJsonObject();
						//得到有效期对象
						JsonObject endDate=result.get("有效期").getAsJsonObject();
						
						//从社会信用代码对象中得到社会信用代码
						String number = totalNumbnerObject.get("words").getAsString();
						//从单位名称对象中得到单位名称
						String unitName = unitUserName.get("words").getAsString();
						//从法人对象中得到法人名称
						String faName = faRen.get("words").getAsString();
						//从地址对象中得到营业执照地址
						String addr = address.get("words").getAsString();
						//从类型对象中得到酒店类型
						String typeL = type.get("words").getAsString();
						//从成立日期对象中得到成立日期
						String startTime = startDate.get("words").getAsString();
						//从有效期对象中得到有效期
						String endTime = endDate.get("words").getAsString();
						int isElse = ifElse(number,unitName,faName,addr,typeL,startTime,endTime);
						if(isElse != 500){
							Wineshop ws = new Wineshop();
							ws.setWineshop_Aptitude(photo);
							ws.setWineshop_Shift_Name(fuzename);
							ws.setWineshop_Number(number);
							ws.setWineshop_danwei_name(unitName);
							ws.setWineshop_faren(faName);
							ws.setWineshop_addr(addr);
							ws.setWineshop_wtype(typeL);
							ws.setStartTime(startTime);
							ws.setEndTime(endTime);
							ws.setWineshop_ID(id);
							code = dao.updataITstart(ws);
//							System.out.println("code="+code);
//							System.out.println("信用代码==="+number);
//							System.out.println("单位名成===="+unitName);
//							System.out.println("法人===="+faName);
//							System.out.println("地址===="+addr);
//							System.out.println("类型===="+typeL);
//							System.out.println("成立时间===="+startTime);
//							System.out.println("有效期===="+endTime);
						}else{
							code = isElse;
						}
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(code);
		out.print(code);
		out.close();
	}

}
