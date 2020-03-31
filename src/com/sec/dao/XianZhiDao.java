package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.QunTui;
import com.sec.entity.XianZhi;

public class XianZhiDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	
	public int update(XianZhi xianzhi){
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update XianZhi_table set Time_Star=?,Time_End=?,Price_Money=? where Time_ID=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, xianzhi.getTime_Star());
			pstmt.setString(2, xianzhi.getTime_End());
			pstmt.setFloat(3, xianzhi.getPrice_Money());
			pstmt.setInt(4,xianzhi.getTime_ID());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("�����ɹ�");
				c=1;
				
			}else
				System.out.println("����ʧ��");
			
	}catch(ClassNotFoundException e){
		System.out.println("ע������ʧ�ܣ�");
	}catch(SQLException e){
		System.out.println("���Ӵ���ʧ�ܣ�");
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
	
	public int updatebucai(XianZhi xianzhi){
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update XianZhi_table set TimeOne=?,TimeTwo=? where Time_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, xianzhi.getTimeOne());
			pstmt.setString(2, xianzhi.getTimeTwo());
			pstmt.setInt(3,xianzhi.getTime_ID());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("�����ɹ�");
				c=1;
				
			}else
				System.out.println("����ʧ��");
			
	}catch(ClassNotFoundException e){
		System.out.println("ע������ʧ�ܣ�");
	}catch(SQLException e){
		System.out.println("���Ӵ���ʧ�ܣ�");
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
	
	public List<XianZhi> findAll(){//��ѯȫ��
		List<XianZhi> list = new ArrayList<XianZhi>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from XianZhi_table");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				XianZhi xianzhi = new XianZhi();
				xianzhi.setTime_ID(rs.getInt(1));
				xianzhi.setTime_Star(rs.getString(2));
				xianzhi.setTime_End(rs.getString(3));
				xianzhi.setPrice_Money(rs.getFloat(4));
				xianzhi.setTimeOne(rs.getString(5));
				xianzhi.setTimeTwo(rs.getString(6));
				xianzhi.setNoTime(rs.getString(7));
				xianzhi.setNoTime1(rs.getString(8));
				list.add(xianzhi);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
