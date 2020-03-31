package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Fare_Price;

public class Fare_PriceDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void update(Fare_Price fare_Price){//更新
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Fare_Price_table set aa=?,bb=?,cc=?,dd=?,ee=?,ff=?,gg=? where Fare_Price_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, fare_Price.getAa());
			pstmt.setFloat(2, fare_Price.getBb());
			pstmt.setFloat(3, fare_Price.getCc());
			pstmt.setFloat(4, fare_Price.getDd());
			pstmt.setFloat(5, fare_Price.getEe());
			pstmt.setFloat(6, fare_Price.getFf());
			pstmt.setFloat(7, fare_Price.getGg());
			pstmt.setInt(8, fare_Price.getFare_Price_ID());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("操作成功");
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
	}


public List<Fare_Price> findAll(){//查询表的所有信息
		
		List<Fare_Price> list = new ArrayList<Fare_Price>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Fare_Price_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				
				Fare_Price fare_Price = new Fare_Price();
				fare_Price.setFare_Price_ID(rs.getInt(1));
				fare_Price.setAa(rs.getFloat(2));
				fare_Price.setBb(rs.getFloat(3));
				fare_Price.setCc(rs.getFloat(4));
				fare_Price.setDd(rs.getFloat(5));
				fare_Price.setEe(rs.getFloat(6));
				fare_Price.setFf(rs.getFloat(7));
				fare_Price.setGg(rs.getFloat(8));
				list.add(fare_Price);
				
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
	    return list;
	}

	
	
	

}
