package com.sec.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Photo;

public class PhotoDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public int add(Photo photo){//增加
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Photo_table (Photo_ID,Photo_time,Photo_path,User_ID,Photo_name) values(?,?,?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, photo.getPhoto_ID());
			pstmt.setString(2, photo.getPhoto_time());
			pstmt.setString(3, photo.getPhoto_path());
			pstmt.setInt(4, photo.getUser_ID());
			pstmt.setString(5, photo.getPhoto_name());
			boolean a=pstmt.execute();
			System.out.println(a);
			if(!a){
				System.out.println("添加成功");
				c = 1;
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
	public List<Photo> findUserByID(int User_ID){ 
		List<Photo> list = new ArrayList<Photo>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Photo_table where User_ID=?");
			pstmt.setInt(1, User_ID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Photo photo = new Photo();
				photo.setPhoto_ID(rs.getInt(1));
				photo.setPhoto_time(rs.getString(2));
				photo.setPhoto_path(rs.getString(3));
				photo.setUser_ID(rs.getInt(4));
				photo.setPhoto_name(rs.getString(5));
				list.add(photo);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
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
	public List<Photo> findAll1(){
	    List<Photo> list = new ArrayList<Photo>();
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Photo_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Photo photo = new Photo();
				photo.setPhoto_ID(rs.getInt(1));
				photo.setPhoto_time(rs.getString(2));
				photo.setPhoto_path(rs.getString(3));
				photo.setUser_ID(rs.getInt(4));
				photo.setPhoto_name(rs.getString(5));
				list.add(photo);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
	        
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
