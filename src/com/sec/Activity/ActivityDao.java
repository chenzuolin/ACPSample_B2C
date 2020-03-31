package com.sec.Activity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.AA1;


public class ActivityDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	
	public String add(Activity x) throws IOException{//增加
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			
			String sql = "insert into Activity_table (Activity_Time,Activity_Num,Activity_Type,Wineshop_ID,Activity_PayID,Activity_Status) values(?,?,?,?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, x.getActivity_Time());
			pstmt.setFloat(2, x.getActivity_Num());
			pstmt.setString(3, x.getActivity_Type());
			pstmt.setInt(4, x.getWineshop_ID());
			pstmt.setString(5, x.getActivity_PayID());
			pstmt.setString(6, x.getActivity_Status());
			
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
	
	
	
	
	
	
	public int update(Activity A){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Activity_table set Activity_Status=? where Activity_PayID=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, A.getActivity_Status());
			
			pstmt.setString(2, A.getActivity_PayID());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
		return a;
	}
	
	
	
	
	
	
	public int update2(SB A){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update SB_table set LJ_Num=?,SB_Num=? where Wineshop_ID=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, A.getLJ_Num());
			
			pstmt.setString(2, A.getSB_Num());
			pstmt.setInt(3, A.getWineshop_ID());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
		return a;
	}
	
	
	
	public List<Activity> findUserByID(String Activity_PayID){//根据编号查询信息
		List<Activity> list1 = new ArrayList<Activity>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Activity_table where Activity_PayID=?");
			pstmt.setString(1,Activity_PayID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				Activity a = new Activity();
				a.setActivity_ID(rs.getInt("Activity_ID"));
				a.setActivity_Num(rs.getFloat("Activity_Num"));
				a.setWineshop_ID(rs.getInt("Wineshop_ID"));
				list1.add(a);
				
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
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
	    return list1;
	}
	

}
