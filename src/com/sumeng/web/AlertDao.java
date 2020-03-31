package com.sumeng.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sec.entity.AA1;
import com.sec.entity.Alert;
import com.sec.entity.BigType;
import com.sec.util.C3p0Utils;

public class AlertDao {
	
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Alert aa) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into Alert_table(userName,alertPath) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aa.getUserName());
			pstmt.setInt(2, aa.getAlertPath());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("��ӳɹ�");
			}else
				System.out.println("���ʧ��");
				
		}catch(ClassNotFoundException e){
			System.out.println("ע������ʧ�ܣ�");
		}catch(SQLException e){
			System.out.println("���Ӵ���ʧ�ܣ���");//�쳣�׳�
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
	public List<Alert> queryId(String userName){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Alert_table where userName=?";
		List<Alert> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Alert>(Alert.class),userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void update(String userName){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update Alert_table set alertPath=1 where userName=?";
		try {
			qr.update(sql,userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
