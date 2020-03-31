package com.sec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BeanDao {
	// JDBC �����������ݿ� URL
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=Green express";
	// ���ݿ���û���������
	private static String name = "green";
	private static String password = "12345678";
	
	static {
		try {
			 // ע�� JDBC ����
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		 // ������
        System.out.println("�������ݿ�...");
		return DriverManager.getConnection(url,name,password);
		
	} 
	
	public static void closeAll(Connection conn,Statement stm,ResultSet rs) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(stm!=null){
			stm.close();
		}
		if(conn!=null){
			conn.close();
		}
		System.out.println("�ر����ݿ�...");
	}
	
	public int executeSQL(String sql,Object[] parma){
		Connection conn = null;
		PreparedStatement pstmt = null;
	     /* ����SQL,ִ��SQL */
		try {
			conn = getConnection();// �õ����ݿ�����
			pstmt = conn.prepareStatement(sql);// �õ�PreparedStatement����
			if (parma != null) {
                for (int i = 0; i < parma.length; i++) {
                    pstmt.setObject(i + 1, parma[i]); // ΪԤ����sql���ò���
                }
            }
			ResultSet executeUpdate = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			try {
				BeanDao.closeAll(conn, pstmt, null);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		return 0;
		
	}


}
