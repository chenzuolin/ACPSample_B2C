package com.sec.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.GeTui;
import com.sec.entity.Greens;

public class GeTuiDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	

	public String add(GeTui getui) throws IOException{//增加
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			
			String sql = "insert into GeTui_table (GeTui_Title,GeTui_Text,GeTui_Adress) values(?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, getui.getGeTui_Title());
			pstmt.setString(2, getui.getGeTui_Text());
			pstmt.setString(3, getui.getGeTui_Adress());
			
			
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
				c = "dasd";
			}else
				System.out.println("添加失败");
				
		}catch(ClassNotFoundException e){
			System.out.println("注册驱动失败！");
		}catch(SQLException e){
			System.out.println("连接创建失败！！");//异常抛出
		}finally{
			try{
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return c;	
	}
	
	public List<GeTui> findAll(){
		List<GeTui> list = new ArrayList<GeTui>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from GeTui_table");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GeTui getui = new GeTui();
				getui.setGeTui_ID(rs.getInt(1));
				getui.setGeTui_Title(rs.getString(2));
				getui.setGeTui_Text(rs.getString(3));
				getui.setGeTui_Adress(rs.getString(4));
				list.add(getui);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
