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
	 * �����ж��Ƿ��ϴ���ʱӪҵִ��
	 * @param number ���ô���
	 * @param unitName ��λ����
	 * @param faName ����
	 * @param addr ע���ַ
	 * @param typeL ��Ӫ����
	 * @param startTime ����ʱ��
	 * @param endTime ��Ч��
	 * @return
	 */
	public int ifElse(String number,String unitName,String faName,String addr,String typeL,String startTime,String endTime){
		int msg = 0;
		if(number.equals("��") && unitName.equals("��") && faName.equals("��") && addr.equals("��") && typeL.equals("��")
				&& startTime.equals("��") && endTime.equals("��")){
			msg = 500;
		}else if(number.equals("��")){
			msg = 500;
		}else if(unitName.equals("��")){
			msg = 500;
		}else if(faName.equals("��")){
			msg = 500;
		}else if(addr.equals("��")){
			msg = 500;
		}else if(typeL.equals("��")){
			msg = 500;
		}else if(startTime.equals("��")){
			msg = 500;
		}else if(endTime.equals("��")){
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
		//��������
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory ();
		//����������
		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = df.format(new Date());
		int code = 0;
		try {
			//�����ϴ���
			List<FileItem> fileItemList = upload.parseRequest(request);
			Iterator<FileItem> iterator = fileItemList.iterator();
			String fuzename = "";
			//�Ƶ��¼����
			String username = "";
			while(iterator.hasNext()){
				FileItem fileItem = (FileItem)iterator.next();
				//�ж��Ƿ�����ͨ����
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
						//����json������
						JsonParser parse =new JsonParser();
						//���õ���resoultת��Ϊjson����
						JsonObject json=(JsonObject) parse.parse(resoult);
						//��json�����еõ�Words_result
						JsonObject result=json.get("words_result").getAsJsonObject();
						//�õ�������ô������
						JsonObject totalNumbnerObject=result.get("������ô���").getAsJsonObject();
						//�õ���λ���ɶ���
						JsonObject unitUserName=result.get("��λ����").getAsJsonObject();
						//�õ����˶���
						JsonObject faRen=result.get("����").getAsJsonObject();
						//�õ���ַ����
						JsonObject address=result.get("��ַ").getAsJsonObject();
						//�õ����Ͷ���
						JsonObject type=result.get("����").getAsJsonObject();
						//�õ��������ڶ���
						JsonObject startDate=result.get("��������").getAsJsonObject();
						//�õ���Ч�ڶ���
						JsonObject endDate=result.get("��Ч��").getAsJsonObject();
						
						//��������ô�������еõ�������ô���
						String number = totalNumbnerObject.get("words").getAsString();
						//�ӵ�λ���ƶ����еõ���λ����
						String unitName = unitUserName.get("words").getAsString();
						//�ӷ��˶����еõ���������
						String faName = faRen.get("words").getAsString();
						//�ӵ�ַ�����еõ�Ӫҵִ�յ�ַ
						String addr = address.get("words").getAsString();
						//�����Ͷ����еõ��Ƶ�����
						String typeL = type.get("words").getAsString();
						//�ӳ������ڶ����еõ���������
						String startTime = startDate.get("words").getAsString();
						//����Ч�ڶ����еõ���Ч��
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
//							System.out.println("���ô���==="+number);
//							System.out.println("��λ����===="+unitName);
//							System.out.println("����===="+faName);
//							System.out.println("��ַ===="+addr);
//							System.out.println("����===="+typeL);
//							System.out.println("����ʱ��===="+startTime);
//							System.out.println("��Ч��===="+endTime);
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
