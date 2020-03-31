package com.sec.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Greens;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class TextServlet
 */
@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*WineshopDao dao = new WineshopDao();
		List<Wineshop> wineshopList = dao.findAll();
		for(Wineshop s:wineshopList){
			System.out.println(s.getWineshop_Name());
		}
		
		request.setAttribute("wineshopList", wineshopList);
		System.out.println(wineshopList);
		request.getRequestDispatcher("jquery.jsp").forward(request, response);
		dao.findAll();*/
		String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
		String username="sa";
		String pwd = "12345678";
		List<Map> list =new ArrayList<Map>();
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Wineshop_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Wineshop wineshop = new Wineshop();
				/*wineshop.setWineshop_UserName(rs.getString(1));
				wineshop.setWineshop_Password(rs.getString(2));
				wineshop.setRole_ID(rs.getInt(3));
				wineshop.setWineshop_Name(rs.getString(4));
				wineshop.setRegionality_ID(rs.getInt(5));
				wineshop.setWineshop_Aptitude(rs.getString(6));
				wineshop.setWineshop_Condition(rs.getInt(7));
				wineshop.setWineshop_Address(rs.getString(8));
				wineshop.setWineshop_Shift_Name(rs.getString(9));
				wineshop.setWineshop_Telephone(rs.getString(10));
				wineshop.setWineshop_Class(rs.getInt(11));
				wineshop.setWineshop_Nature(rs.getString(12));
				wineshop.setWineshop_QQ(rs.getInt(13));
				wineshop.setWineshop_WeChat(rs.getString(14));
				wineshop.setWineshop_Number(rs.getInt(15));
				wineshops.add(wineshop);*/
				String Wineshop_UserName = rs.getString("Wineshop_UserName");
				String Wineshop_Password = rs.getString("Wineshop_Password");
				int Role_ID = rs.getInt("Role_ID");
				String Wineshop_Name = rs.getString("Wineshop_Name");
				int Regionality_ID = rs.getInt("Regionality_ID");
				String Wineshop_Aptitude = rs.getString("Wineshop_Aptitude");
				int Wineshop_Condition = rs.getInt("Wineshop_Condition");
				String Wineshop_Address = rs.getString("Wineshop_Address");
				String Wineshop_Shift_Name = rs.getString("Wineshop_Shift_Name");
				String Wineshop_Telephone = rs.getString("Wineshop_Telephone");
				int Wineshop_Class = rs.getInt("Wineshop_Class");
				String Wineshop_Nature = rs.getString("Wineshop_Nature");
				int Wineshop_QQ = rs.getInt("Wineshop_QQ");
				String Wineshop_WeChat = rs.getString("Wineshop_WeChat");
				int Wineshop_Number = rs.getInt("Wineshop_Number");
				Map map = new HashMap(); 
				map.put("Wineshop_UserName", Wineshop_UserName);
				map.put("Wineshop_Password", Wineshop_Password);
				map.put("Role_ID", Role_ID);
				map.put("Wineshop_Name", Wineshop_Name);
				map.put("Regionality_ID", Regionality_ID);
				map.put("Wineshop_Aptitude", Wineshop_Aptitude);
				map.put("Wineshop_Condition", Wineshop_Condition);
				map.put("Wineshop_Address", Wineshop_Address);
				map.put("Wineshop_Shift_Name", Wineshop_Shift_Name);
				map.put("Wineshop_Telephone", Wineshop_Telephone);
				map.put("Wineshop_Telephone", Wineshop_Telephone);
				map.put("Wineshop_Class", Wineshop_Class);
				map.put("Wineshop_Nature", Wineshop_Nature);
				map.put("Wineshop_QQ", Wineshop_QQ);
				map.put("Wineshop_WeChat", Wineshop_WeChat);		
				map.put("Wineshop_Number", Wineshop_Number);
				System.out.println(map);
				list.add(map);
				System.out.println("放入集合");
				for (Map map_1 :list) {
						System.out.println(map_1);
					}//在打印台遍历出数据查看是否有错误
			}//遍历结果集
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("跳转");
		request.setAttribute("key_list",list);//将list集合数据放入到request中共享
		request.getRequestDispatcher("jquery.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
