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
	 * ��ѯ��¼��־
	 * @param currentPage ��ǰҳ
	 * @param size ÿҳ��ʾ������
	 * @return ����
	 */
	public Page getSum(int currentPage,int size) {
		// TODO �Զ����ɵķ������
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select count(*) from Log_table");
			rs = pstmt1.executeQuery();// ִ��SQL��䣬�����ؽ����
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
			// 8���ر���Դ
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
	 * ��ѯ��¼��־
	 * @param currentPage ��ǰҳ
	 * @param dd page����
	 * @param size ÿҳ��ʾ������
	 * @return ����
	 */
	public Page getSun(int currentPage,Page dd,int size) {
		// TODO �Զ����ɵķ������
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
			// 8���ر���Դ
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
