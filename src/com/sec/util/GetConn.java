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
		public static Connection get() {//�������
			Connection conn=null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
				conn = DriverManager.getConnection(url,username,pwd);//����
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