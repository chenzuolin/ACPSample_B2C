package com.sec.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.WC;
import com.sec.entity.Wineshop;

public class WCDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public String add(WC wc) throws IOException{//增加
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into WC_table (Courier_ID,Indent_ID) values(?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,wc.getCourier_ID());
			pstmt.setInt(2, wc.getIndent_ID());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
				c = "成功";
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
	public List<WC> findUserByID(int Indent_ID){//根据编号查询信息
		List<WC> list1 = new ArrayList<WC>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from WC_table where Indent_ID=?");
			pstmt.setInt(1,Indent_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			if(rs.next()!=false){
				WC wc = new WC();
				wc.setCourier_ID(rs.getInt(2));
				list1.add(wc);
			
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
