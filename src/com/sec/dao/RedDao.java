package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Coupon;
import com.sec.entity.FZ;
import com.sec.entity.Point;
import com.sec.entity.Red;


public class RedDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(Red p) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Red_table(Wineshop_ID,Coupon_ID,Red_Type,Coupon_Num,Give_Money) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getWineshop_ID());
			pstmt.setInt(2, p.getCoupon_ID());
			pstmt.setString(3, p.getRed_Type());
			pstmt.setInt(4, p.getCoupon_Num());
			pstmt.setInt(5, p.getGive_Money());
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
	
	public void adds(Red p) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Red_table(Wineshop_ID,Red_Type,Give_Time,Give_Money,Give_Num,Give_Shijian,Give_FZ) values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getWineshop_ID());
			pstmt.setString(2, p.getRed_Type());
			pstmt.setString(3, p.getGive_Time());
			pstmt.setInt(4, p.getGive_Money());
			pstmt.setInt(5, p.getGive_Num());
			pstmt.setString(6, p.getGive_Shijian());
			pstmt.setString(7, p.getGive_FZ());
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
	
	public List<Red> findNumber(int Wineshop_ID) {// 根据编号查询信息
		List<Red> list = new ArrayList<Red>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Red_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Red p = new Red();
				p.setRed_ID(rs.getInt(1));
				p.setWineshop_ID(rs.getInt(2));
				p.setCoupon_ID(rs.getInt(3));
				p.setRed_Status(rs.getString(4));
				p.setRed_Type(rs.getString(5));
				p.setGive_Time(rs.getString(6));
				p.setGive_Money(rs.getInt(7));
				p.setGive_Num(rs.getInt(8));
				p.setGive_Shijian(rs.getString(9));
				p.setGive_FZ(rs.getString(10));
				p.setCoupon_Num(rs.getInt(11));
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
	
	public List<Red> findas(int Red_ID) {// 根据编号查询信息
		List<Red> list = new ArrayList<Red>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Red_table where Red_ID=?");
			pstmt.setInt(1, Red_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Red p = new Red();
				p.setRed_ID(rs.getInt(1));
				p.setWineshop_ID(rs.getInt(2));
				p.setCoupon_ID(rs.getInt(3));
				p.setRed_Status(rs.getString(4));
				p.setRed_Type(rs.getString(5));
				p.setGive_Time(rs.getString(6));
				p.setGive_Money(rs.getInt(7));
				p.setGive_Num(rs.getInt(8));
				p.setGive_Shijian(rs.getString(9));
				p.setGive_FZ(rs.getString(10));
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
	
	public int  findNumberss(int Coupon_ID) {// 根据编号查询信息
		int aa = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Red_table where Coupon_ID=?");
			pstmt.setInt(1, Coupon_ID);
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
	
	public String  find(int Red_ID) {// 根据编号查询信息
		String aa = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Red_table where Red_ID=?");
			pstmt.setInt(1, Red_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				aa = rs.getString("Red_Type");
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
	
	
	public List<Red> findAll(){//查询表的所有信息
        List<Red> list2 = new ArrayList<Red>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Red_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Red p = new Red();
				p.setRed_ID(rs.getInt(1));
				p.setWineshop_ID(rs.getInt(2));
				p.setCoupon_ID(rs.getInt(3));
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
	
	public int updatefinish(Red fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Red_table set Red_Status = ? where Wineshop_ID = ? and Coupon_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fz.getRed_Status());
			pstmt.setInt(2, fz.getWineshop_ID());
			pstmt.setInt(3, fz.getCoupon_ID());
			
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
	
	public int update(Red fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Red_table set Red_Status = ? where Red_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fz.getRed_Status());
			pstmt.setInt(2, fz.getRed_ID());
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
	
	
	
	public int delete(int Red_ID){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Red_table where Red_ID = ?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Red_ID);
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
	
	
	public int deletes(int Coupon_ID,int Wineshop_ID,String Red_Status){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Red_table where Coupon_ID=? and Wineshop_ID = ? and Red_Status =?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, Coupon_ID);
			pstmt.setInt(2, Wineshop_ID);
			pstmt.setString(3, Red_Status);
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
