package com.sumeng.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Log;
import com.sumeng.page.Page;

public class LogDao {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username = "green";
	String pwd = "12345678";
	/**
	 * 查询登录日志
	 * @param currentPage 当前页
	 * @param size 每页显示的条数
	 * @return 对象
	 */
	public Page getSum(int currentPage,int size) {
		// TODO 自动生成的方法存根
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select count(*) from Log_table");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				totalNum = rs.getInt(1);
			}
			int totalPage = 0;
			if(totalNum%size==0) {
				totalPage = totalNum/size;
			}else {
				totalPage = totalNum/size+1;
			}
			page.setCount(totalNum);
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
	/**
	 * 查询登录日志
	 * @param currentPage 当前页
	 * @param dd page对象
	 * @param size 每页显示的条数
	 * @return 对象
	 */
	public Page getSun(int currentPage,Page dd,int size) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<Log> list = new ArrayList<Log>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Log_Time desc) as rownumber,* from Log_table) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				Log log = new Log();
				log.setLog_Id(rs.getString("Log_Id"));
				log.setLog_Time(rs.getString("Log_Time"));
				log.setLog_Name(rs.getString("Log_Name"));
				log.setLog_Ip(rs.getString("Log_Ip"));
				log.setLog_Ip_Name(rs.getString("Log_Ip_Name"));
				log.setLog_Type(rs.getString("Log_Type"));
				log.setLog_Content(rs.getString("Log_Content"));
				list.add(log);
				dd.setData(list);
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
}
