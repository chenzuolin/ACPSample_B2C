package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Coupon;
import com.sec.entity.FZ;
import com.sec.entity.Point;
import com.sec.entity.Red;


public class CouponDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(Coupon p) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into Coupon_table(Coupon_Point,Coupon_num,Coupon_Type) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getCoupon_Point());
			pstmt.setInt(2, p.getCoupon_num());
			pstmt.setString(3, p.getCoupon_Type());
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
	
	public void adds(Coupon p) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into Coupon_table(Coupon_Point,Coupon_Type,Coupon_Mode,Coupon_Tupian) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getCoupon_Point());
			pstmt.setString(2, p.getCoupon_Type());
			pstmt.setString(3, p.getCoupon_Mode());
			pstmt.setString(4, p.getCoupon_Tupian());
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
	
	public List<Coupon> findNumber(int Coupon_ID) {// ���ݱ�Ų�ѯ��Ϣ
		List<Coupon> list = new ArrayList<Coupon>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Coupon_table where Coupon_ID=?");
			pstmt.setInt(1, Coupon_ID);
			rs = pstmt.executeQuery();// ִ��SQL��䣬�����ؽ����
			while (rs.next()) {
				Coupon p = new Coupon();
				p.setCoupon_ID(rs.getInt(1));
				p.setCoupon_Point(rs.getInt(2));
				p.setCoupon_num(rs.getInt(3));
				p.setCoupon_Type(rs.getString(4));
				p.setCoupon_Mode(rs.getString(5));
				list.add(p);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
	
	public int find(int Coupon_num) {// ���ݱ�Ų�ѯ��Ϣ
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Coupon_table where Coupon_num=?");
			pstmt.setInt(1, Coupon_num);
			rs = pstmt.executeQuery();// ִ��SQL��䣬�����ؽ����
			while (rs.next()) {
				a = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return a;
	}
	
	public List<Coupon> findAll(){//��ѯ���������Ϣ
        List<Coupon> list2 = new ArrayList<Coupon>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Coupon_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Coupon p = new Coupon();
				p.setCoupon_ID(rs.getInt(1));
				p.setCoupon_Point(rs.getInt(2));
				p.setCoupon_num(rs.getInt(3));
				p.setCoupon_Type(rs.getString(4));
				p.setCoupon_Mode(rs.getString(5));
				p.setCoupon_Tupian(rs.getString(6));
				list2.add(p);
			}
        }catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //8���ر���Դ
            try {
                if(rs!=null){
                   rs.close();
                }
                if(pstmt!=null){
                    pstmt.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
             
        }
        return list2;
    }
	public int delete(int Coupon_ID){//ɾ��

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Coupon_table where Coupon_ID = ?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Coupon_ID);
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
