package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Sum;

public class SumDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Sum sum) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into Sum_table(Greens_Name,sum_date,sum_number) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sum.getGreens_Name());
			pstmt.setString(2,sum.getSum_date());
			pstmt.setInt(3,sum.getSum_number());
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
	public int check(String Greens_Name) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "select count(*) from Sum_table where Greens_Name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,Greens_Name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
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
		return count;
	}
	public int count(String Greens_Name) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "select * from Sum_table where Greens_Name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,Greens_Name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("sum_number");
			}
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
		return count;
	}
	public int update(Sum sum) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "update Sum_table set sum_number=? where Greens_Name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,sum.getSum_number());
			pstmt.setString(2,sum.getGreens_Name());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("�����ɹ�");
				count=1;
			}else
				System.out.println("����ʧ��");
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
		return count;
	}
	public List<Sum> findAll() {//�������
		List<Sum> list = new ArrayList<Sum>();
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "select * from Sum_table";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Sum ss = new Sum();
				ss.setSum_id(rs.getInt(1));
				ss.setGreens_Name(rs.getString(2));
				ss.setSum_date(rs.getString(3));
				ss.setSum_number(rs.getInt(4));
				list.add(ss);
			}
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
		return list;
	}
	public int delete(int sum_id){//ɾ��

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Sum_table where sum_id=?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sum_id);
			a=pstmt.executeUpdate();
			if(a>0){
				System.out.println("�ɹ�");
			}else{
				System.out.println("ʧ��");
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
