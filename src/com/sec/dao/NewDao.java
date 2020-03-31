package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.New;
import com.sec.entity.Page;

public class NewDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public static final int NUM_PER_PAGE = 10;
	public void add(New news) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into New_table(Wineshop_UserName,Greens_Name,greens_miaoshu,new_date) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,news.getWineshop_UserName());
			pstmt.setString(2,news.getGreens_Name());
			pstmt.setString(3,news.getGreens_miaoshu());
			pstmt.setString(4,news.getNew_date());
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
	public Page getSum(int currentPage) {
		// TODO 自动生成的方法存根
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select count(*) from New_table");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				totalNum = rs.getInt(1);
			}
			int totalPage = 0;
			if(totalNum%NUM_PER_PAGE==0) {
				totalPage = totalNum/NUM_PER_PAGE;
			}else {
				totalPage = totalNum/NUM_PER_PAGE+1;
			}
			page.setTotalPage(totalPage);
			page.setCurrentPage(currentPage);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8，关闭资源
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return page;
	}
	public Page getSun(int currentPage,Page dd) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<New> list = new ArrayList<New>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+NUM_PER_PAGE+" * from (select row_number() over(order by new_id asc) as rownumber,* from New_table) temp_row where rownumber>(("+currentPage+"-1)*"+NUM_PER_PAGE+");");
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				New news = new New();
				news.setNew_id(rs.getInt("new_id"));
				news.setWineshop_UserName(rs.getString("Wineshop_UserName"));
				news.setGreens_Name(rs.getString("Greens_Name"));
				news.setGreens_miaoshu(rs.getString("greens_miaoshu"));
				news.setNew_date(rs.getString("new_date"));
				list.add(news);
				dd.setList(list);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8，关闭资源
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return dd;
	}
	public int check(String Greens_Name) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "select count(*) from Sum_table where Greens_Name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,Greens_Name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
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
		return count;
	}
	public int delete(int new_id){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from New_table where new_id=?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, new_id);
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
