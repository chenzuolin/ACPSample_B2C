package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.entity.Indent;

/**
 * Servlet implementation class HH2Servlet
 */
@WebServlet("/HH2Servlet")
public class HH2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HH2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();//定义了一个存map的List集合
		IndentDao dao1 = new IndentDao();
		List<Indent> list = dao1.findUserByIDweek();
		for(Indent indent : list){
			int b = indent.getIndent_ID();
			OrderDao dao2 = new OrderDao();
			Map<String, Object> map = dao2.findAll8(b);
			lists.add(map);
		}
		 Map<String,Object> mapAll = new HashMap<String,Object>();//定义一个新的mapAll
	        for(Map<String,Object> map1:lists){//循环定义的List
	            for(Map.Entry<String, Object> entry:map1.entrySet()){//循环查出来的map集合
	                String name = entry.getKey();//取键
	                Object score = entry.getValue();//取值
	                Object scoreAll = mapAll.get(entry.getKey());//取当前键所对应的值
	                if(scoreAll == null){//判断当前的键有这个值
	                    mapAll.put(name, score);
	                }else{
	                	String b1 = score.toString();
	                	int b2 = Integer.parseInt(b1);
	                	String b3 = scoreAll.toString();
	                	int b4 = Integer.parseInt(b3);
	                	int b5 = b2 + b4;
	                    mapAll.put(name, b5);
	                }
	            }
	        }
		
	        JSONObject jj = JSONObject.fromObject(mapAll);
			PrintWriter out = response.getWriter();
			out.print(jj);
			out.flush();
			out.close();
		//System.out.println(map);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
