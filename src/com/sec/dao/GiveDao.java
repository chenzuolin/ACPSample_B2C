package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Coupon;
import com.sec.entity.Give;

public class GiveDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(Give p) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Give_table(Wineshop_ID,Give_Time,Give_Money,Give_Num,Give_Shijian,Give_FZ) values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getWineshop_ID());
			pstmt.setString(2, p.getGive_Time());
			pstmt.setInt(3, p.getGive_Money());
			pstmt.setInt(4, p.getGive_Num());
			pstmt.setString(5, p.getGive_Shijian());
			pstmt.setString(6, p.getGive_FZ());
			
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
	
	public List<Give> findNumber(int Give_ID) {// 根据编号查询信息
		List<Give> list = new ArrayList<Give>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Give_table where Give_ID=?");
			pstmt.setInt(1, Give_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Give g = new Give();
				g.setGive_ID(rs.getInt(1));
				g.setGive_Time(rs.getString(2));
				g.setGive_Money(rs.getInt(3));
				g.setGive_Num(rs.getInt(4));
				list.add(g);
				
				
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
	
	
	
	
	public List<Give> findAll(){//查询表的所有信息
        List<Give> list2 = new ArrayList<Give>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Give_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Give g = new Give();
				g.setGive_ID(rs.getInt(1));
				g.setWineshop_ID(rs.getInt(2));
				g.setGive_Time(rs.getString(3));
				g.setGive_Money(rs.getInt(4));
				g.setGive_Num(rs.getInt(5));
				g.setGive_Shijian(rs.getString(6));
				g.setGive_FZ(rs.getString(7));
				list2.add(g);
				
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
	public int delete(int Give_ID){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Coupon_table where Give_ID = ?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Give_ID);
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
	
		


}
