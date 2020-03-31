 package com.sec.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.*;
import com.sumeng.page.fenye;

public class TouSuDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public String add(TouSu tousu) throws IOException{//增加部分字段
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			
			String sql = "insert into TouSu_table (Wineshop_ID,TouSu_Type,TouSu_Text,TouSu_Time) values(?,?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, tousu.getWineshop_ID());
			pstmt.setString(2, tousu.getTouSu_Type());
			pstmt.setString(3, tousu.getTouSu_Text());
			pstmt.setString(4, tousu.getTouSu_Time());
			
			
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
	
	
	public fenye findAll(){//查询全部
		List<TS> list = new ArrayList<TS>();
		fenye fy = new fenye();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Wineshop_table.Wineshop_Name,TouSu_table.TouSu_ID ,TouSu_table.TouSu_Type,TouSu_table.TouSu_Time,TouSu_table.TouSu_Text from Wineshop_table inner join TouSu_table on Wineshop_table.Wineshop_ID = TouSu_table.Wineshop_ID");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TS ts = new TS();
				ts.setTouSu_ID(rs.getInt("TouSu_ID"));
				ts.setWineshop_Name(rs.getString("Wineshop_Name"));
				ts.setTouSu_Type(rs.getString("TouSu_Type"));
				ts.setTouSu_Text(rs.getString("TouSu_Text"));
				ts.setTouSu_Time(rs.getString("TouSu_Time"));
				
				list.add(ts);
				fy.setCode(0);
				fy.setData(list);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return fy;
		
	}
	public int update(TouSu tousu){//根据Wineshop_ID更新
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update TouSu_table set FanKui_Text=? where TouSu_ID=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, tousu.getFanKui_Text());
			pstmt.setInt(2, tousu.getTouSu_ID());
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("操作成功");
				c=1;
				
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！");
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
	
	
	
	public List<TouSu> findUserByID(int Wineshop_ID){//根据编号查询信息
		List<TouSu> list = new ArrayList<TouSu>();
		
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from TouSu_table where Wineshop_ID=?");
			pstmt.setInt(1,Wineshop_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				TouSu tousu = new TouSu();
				tousu.setTouSu_ID(rs.getInt(1));
				tousu.setTouSu_Type(rs.getString(3));
				tousu.setTouSu_Text(rs.getString(4));
				tousu.setTouSu_Time(rs.getString(5));
				tousu.setFanKui_Text(rs.getString(6));
				list.add(tousu);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
	        //8，关闭资源
	        try {
	            if(rs!=null){
	               rs.close();
	            }
	            if(pstmt!=null){
	                pstmt.close();
	            }
	            if(conn!=null){
	                conn.close();
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	         
	    }
	    return list;
	}	

	
	
	public List<TouSu> findUserByID1(int TouSu_ID){//根据编号查询信息
		List<TouSu> list = new ArrayList<TouSu>();
		
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from TouSu_table where TouSu_ID=?");
			pstmt.setInt(1,TouSu_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				TouSu tousu = new TouSu();
				//tousu.setTouSu_ID(rs.getInt(2));
				tousu.setWineshop_ID(rs.getInt(2));
				tousu.setTouSu_Type(rs.getString(3));
				tousu.setTouSu_Text(rs.getString(4));
				tousu.setTouSu_Time(rs.getString(5));
				tousu.setFanKui_Text(rs.getString(6));
				list.add(tousu);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
	        //8，关闭资源
	        try {
	            if(rs!=null){
	               rs.close();
	            }
	            if(pstmt!=null){
	                pstmt.close();
	            }
	            if(conn!=null){
	                conn.close();
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	         
	    }
	    return list;
	}
}
