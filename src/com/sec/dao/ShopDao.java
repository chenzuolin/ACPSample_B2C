package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Shop;

public class ShopDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(Shop s) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Shop_table(Shop_Name,Wineshop_ID,Shop_Time,Shop_Status) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getShop_Name());
			pstmt.setInt(2, s.getWineshop_ID());
			pstmt.setString(3, s.getShop_Time());
			pstmt.setString(4, s.getShop_Status());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
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
	}
	
	
	
	public List<Shop> findNumber(int Wineshop_ID) {// 根据编号查询信息
		List<Shop> list = new ArrayList<Shop>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Shop_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Shop s = new Shop();
				s.setShop_ID(rs.getInt(1));
				s.setShop_Name(rs.getString(2));
				s.setWineshop_ID(rs.getInt(3));
				s.setShop_Time(rs.getString(4));
				s.setShop_Status(rs.getString(5));
				list.add(s);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8，关闭资源
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list;
	}
	
	
	
	
	
	public List<Shop> findAll(){//查询表的所有信息
        List<Shop> list2 = new ArrayList<Shop>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Shop_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Shop s = new Shop();
				s.setShop_ID(rs.getInt(1));
				s.setShop_Name(rs.getString(2));
				s.setWineshop_ID(rs.getInt(3));
				s.setShop_Time(rs.getString(4));
				s.setShop_Status(rs.getString(5));
				list2.add(s);
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
        return list2;
    }
	
	
	public int update(Shop s){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Shop_table set Shop_Status = ? where Shop_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getShop_Status());
			pstmt.setInt(2, s.getShop_ID());
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
	
	
	
	
}
