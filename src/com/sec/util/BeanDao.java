package com.sec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BeanDao {
	// JDBC 驱动名及数据库 URL
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=Green express";
	// 数据库的用户名与密码
	private static String name = "green";
	private static String password = "12345678";
	
	static {
		try {
			 // 注册 JDBC 驱动
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		 // 打开链接
        System.out.println("连接数据库...");
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
		System.out.println("关闭数据库...");
	}
	
	public int executeSQL(String sql,Object[] parma){
		Connection conn = null;
		PreparedStatement pstmt = null;
	     /* 处理SQL,执行SQL */
		try {
			conn = getConnection();// 得到数据库连接
			pstmt = conn.prepareStatement(sql);// 得到PreparedStatement对象
			if (parma != null) {
                for (int i = 0; i < parma.length; i++) {
                    pstmt.setObject(i + 1, parma[i]); // 为预编译sql设置参数
                }
            }
			ResultSet executeUpdate = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				BeanDao.closeAll(conn, pstmt, null);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		return 0;
		
	}


}
