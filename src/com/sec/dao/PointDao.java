package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.FZ;
import com.sec.entity.Indent;
import com.sec.entity.Point;


public class PointDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(Point p) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Point_table(Wineshop_ID,Point_num,Point_last,Point_Status) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getWineshop_ID());
			pstmt.setInt(2, p.getPoint_num());
			pstmt.setInt(3, p.getPoint_last());
			pstmt.setString(4, p.getPoint_Status());
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
	
	public List<Point> findAll(){//查询表的所有信息
        List<Point> list2 = new ArrayList<Point>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Point_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Point p = new Point();
				p.setPoint_ID(rs.getInt(1));
				p.setWineshop_ID(rs.getInt(2));
				p.setPoint_num(rs.getInt(3));
				p.setPoint_last(rs.getInt(4));
				p.setPoint_Status(rs.getString(5));
				list2.add(p);
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
	public int updatefinish(Point p){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Point_table set Point_num=?,point_last=?,Point_Status=? where Wineshop_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getPoint_num());
			pstmt.setInt(2, p.getPoint_last());
			pstmt.setString(3, p.getPoint_Status());
			pstmt.setInt(4, p.getWineshop_ID());
			
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
	
	public int update(Point p){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Point_table set Point_num=? where Wineshop_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getPoint_num());
			pstmt.setInt(2, p.getWineshop_ID());
			
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
	
	public int updatefinishes(Point p){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Point_table set Point_last=?,Point_Status=? where Wineshop_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getPoint_last());
			pstmt.setString(2, p.getPoint_Status());
			pstmt.setInt(3, p.getWineshop_ID());
			
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
	
	public List<Point> findNumber(int Wineshop_ID) {// 根据编号查询信息
		List<Point> list = new ArrayList<Point>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Point_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Point p = new Point();
				p.setPoint_ID(rs.getInt(1));
				p.setWineshop_ID(rs.getInt(2));
				p.setPoint_num(rs.getInt(3));
				p.setPoint_last(rs.getInt(4));
				p.setPoint_Status(rs.getString(5));
				list.add(p);
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
	
	public int count(int Wineshop_ID) {// 根据编号查询信息
		int aa = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select count(*) from Point_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				aa = rs.getInt(1);
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
		return aa;
	}

}
