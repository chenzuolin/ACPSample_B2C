package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class DD3Servlet
 */
@WebServlet("/DD3Servlet")
public class DD3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DD3Servlet() {
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
				GreensDao  dao1 = new GreensDao();
				List<Greens> list1 = dao1.findAll();
				List<Greens> list2 = sortIntMethod(list1);
				JSONArray json = JSONArray.fromObject(list2);
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
				
	}

	@SuppressWarnings("unchecked")
	public static List sortIntMethod(List list){
	    Collections.sort(list, new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				Greens stu1=(Greens)o1;
				Greens stu2=(Greens)o2;
				if(stu1.getGreens_Grade()>stu2.getGreens_Grade()){
					return -1;
				}else if(stu1.getGreens_Grade()==stu2.getGreens_Grade()){
					return 0;
				}else{
					return 1;
				}
			}	    	
	    });
	    return list;
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
