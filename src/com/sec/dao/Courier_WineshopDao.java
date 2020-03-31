package com.sec.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Courier_Wineshop;

public class Courier_WineshopDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Courier_Wineshop courier_wineshop) throws IOException{
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "insert into Courier_Wineshop_table(Courier_ID,Allot) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courier_wineshop.getCourier_ID());
			pstmt.setString(2, courier_wineshop.getAllot());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
			}else
				System.out.println("添加失败");
				
		}catch(ClassNotFoundException e){
			System.out.println("驱动异常");
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
		
	}
	public int check(String WSname){
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int id = 0;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Courier_Wineshop_table where Allot=?");
			pstmt.setString(1,WSname);
			rs = pstmt.executeQuery();
			while(rs.next()){
				id = rs.getInt("Courier_ID");
			
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
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
	            
	            e.printStackTrace();
	        }
	         
	    }
	    return id;
	}

	public List<Courier_Wineshop> findUserByID(int Courier_ID){
		List<Courier_Wineshop> list1 = new ArrayList<Courier_Wineshop>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Courier_Wineshop_table where Courier_ID=?");
			pstmt.setInt(1,Courier_ID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Courier_Wineshop courier_wineshop = new Courier_Wineshop();
				courier_wineshop.setCourier_Wineshop_ID(rs.getInt(1));
				courier_wineshop.setCourier_ID(rs.getInt(2));
				courier_wineshop.setAllot(rs.getString(3));
				list1.add(courier_wineshop);
			
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
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
	            
	            e.printStackTrace();
	        }
	         
	    }
	    return list1;
	}
	public int delete(int Courier_Wineshop_ID){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Courier_Wineshop_table where Courier_Wineshop_ID=?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Courier_Wineshop_ID);
			a=pstmt.executeUpdate();
			if(a>0){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
	}catch(Exception e){
		e.printStackTrace();
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

	public List<Courier_Wineshop> findAll(){
	    List<Courier_Wineshop> list2 = new ArrayList<Courier_Wineshop>();
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Courier_Wineshop_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Courier_Wineshop courier_wineshop1 = new Courier_Wineshop();
				courier_wineshop1.setCourier_ID(rs.getInt(1));;
				courier_wineshop1.setAllot(rs.getString(2));
				list2.add(courier_wineshop1);
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
	            
	            e.printStackTrace();
	        }
	         
	    }
	    return list2;
	}

}
