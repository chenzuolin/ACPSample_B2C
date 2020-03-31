package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SousuoServlet
 */
@WebServlet("/SousuoServlet")
public class SousuoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static boolean isChineseChar(String str){
         boolean temp = false;
         Pattern p=Pattern.compile("[\u4e00-\u9fa5]"); 
         Matcher m=p.matcher(str); 
         if(m.find()){ 
             temp =  true;
         }
         return temp;
     }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SousuoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String name = request.getParameter("name");
		GreensDao greens = new GreensDao();
		List<Greens> list1 = greens.findUserByIDlike2(name);
		PrintWriter out = response.getWriter();
		if(list1.size()==0){
			 StringBuffer letter = new StringBuffer();
		        StringBuffer number = new StringBuffer();
			 char[] strArr = name.toCharArray();
		        System.out.println(strArr);
		        for (char string : strArr) {
		            // ÅÐ¶ÏÊÇ·ñÎª×ÖÄ¸
		            if ((string+"").matches("[a-z]") || (string+"").matches("[A-Z]")){
		                letter.append(string+"  ");
		                out.print(0);
	            		out.flush();
	            		out.close();
		            }
		            // ÅÐ¶ÏÊÇ·ñÎªÊý×Ö
		            if ((string+"").matches("[0-9]")){
		                number.append(string+"  ");
		                out.print(0);
	            		out.flush();
	            		out.close();
		            }
		            // ÅÐ¶ÏÊÇ·ñÎªºº×Ö
		            if (isChineseChar(string+"")){
		            	List<Greens> list2 = greens.findUserByIDlike2(Character.toString(string));
		            	if(list2.size()==0){
		            		out.print(0);
		            		out.flush();
		            		out.close();
		            	}else{
		            		JSONArray json = JSONArray.fromObject(list2);
		            		out.print(json);
		            		out.flush();
		            		out.close();
		            	}
		            }
		        }
		}else{
		
		JSONArray json = JSONArray.fromObject(list1);
		out.print(json);
		out.flush();
		out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
