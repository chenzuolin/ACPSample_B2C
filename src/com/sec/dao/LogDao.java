package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Log;
import com.sec.entity.Page;

/**
 * ���˿��ߵ�¼��־����
 * 
 * @author ����ս��
 * @time 2018/11/30.
 */

public class LogDao {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username = "green";
	String pwd = "12345678";
	public static final int NUM_PER_PAGE = 15;

	// ��ӷ���
	public void add(Log log) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// ��������
			conn = DriverManager.getConnection(url, username, pwd);// ����
			String sql = "insert into Log_table (Log_Id,Log_Time,Log_Name,Log_Ip,Log_Ip_Name,Log_Type,Log_Content) values(?,?,?,?,?,?,?)";// SQL���
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, log.getLog_Id());
			pstmt.setString(2, log.getLog_Time());
			pstmt.setString(3, log.getLog_Name());
			pstmt.setString(4, log.getLog_Ip());
			pstmt.setString(5, log.getLog_Ip_Name());
			pstmt.setString(6, log.getLog_Type());
			pstmt.setString(7, log.getLog_Content());
			boolean a = pstmt.execute();
			if (!a) {
				System.out.println("��ӳɹ�");
			} else
				System.out.println("���ʧ��");

		} catch (ClassNotFoundException e) {
			System.out.println("ע������ʧ�ܣ�");
		} catch (SQLException e) {
			System.out.println("���Ӵ���ʧ�ܣ���");// �쳣�׳�
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Log> findAll() {// ��ѯ���������Ϣ
		List<Log> list = new ArrayList<Log>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Log_table");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Log log = new Log();
				log.setLog_Id(rs.getString(1));
				log.setLog_Time(rs.getString(2));
				log.setLog_Name(rs.getString(3));
				log.setLog_Ip(rs.getString(4));
				log.setLog_Ip_Name(rs.getString(5));
				log.setLog_Type(rs.getString(6));
				log.setLog_Content(rs.getString(7));
				list.add(log);
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

	public int findAllName(String Log_Type, String Log_Content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int sum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select count(Log_Id) from Log_table where Log_Type=? and Log_Content=?");

			pstmt.setString(1, Log_Type);
			pstmt.setString(2, Log_Content);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sum = rs.getInt(1);
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
		return sum;
	}

	public int findAllNameContent(String Log_Content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int sum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select count(Log_Id) from Log_table where Log_Content=?");
			pstmt.setString(1, Log_Content);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sum = rs.getInt(1);
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
		return sum;
	}

	public List<Log> getcurrentPage(Integer currentPageStartRow,// �Ӷ����е�������
			Integer pageSize) throws Exception {
		// TODO �Զ����ɵķ������
		List<Log> list = new ArrayList<Log>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select top (?-?+1) * from Log_table where Log_Id not in (select top (?-1) Log_Id from Log_table)");
			pstmt1.setInt(1, pageSize);
			pstmt1.setInt(2, currentPageStartRow);
			pstmt1.setInt(3, currentPageStartRow);
			rs = pstmt1.executeQuery();// ִ��SQL��䣬�����ؽ����
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
		return list;
	}
	public Page getSum(int currentPage) {
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
	public Page getSun(int currentPage,Page dd) {
		// TODO �Զ����ɵķ������
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<Log> list = new ArrayList<Log>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+NUM_PER_PAGE+" * from (select row_number() over(order by Log_Time desc) as rownumber,* from Log_table) temp_row where rownumber>(("+currentPage+"-1)*"+NUM_PER_PAGE+");");
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
				dd.setList(list);
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
