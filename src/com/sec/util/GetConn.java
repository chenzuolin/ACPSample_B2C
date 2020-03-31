package com.sec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetConn {
		private static  String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
		private static String username="green";
		private static String pwd = "12345678";
		public static Connection get() {//添加数据
			Connection conn=null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
				conn = DriverManager.getConnection(url,username,pwd);//连接
			}catch (Exception e) {
				// TODO: handle exception
			}
			return conn;
		}
		public static void close(Connection conn ,PreparedStatement ps ,ResultSet rs ) throws SQLException  {
			if(rs != null){
				rs.close();
			}
			if( ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}

}