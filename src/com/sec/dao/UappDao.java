package com.sec.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Consult;
import com.sec.entity.Page;
import com.sec.entity.Uapp;

public class UappDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	private final  static int NUM_PER_PAGE = 20;
	public List<Uapp> check(String appusername,String uname){//���ݱ�Ų�ѯ��Ϣ
		List<Uapp> list = new ArrayList<Uapp>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Uapp_table where appusername=? and uname=?");
			pstmt.setString(1,appusername);
			pstmt.setString(2,uname);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()){
				Uapp app = new Uapp();
				app.setUid(rs.getInt(1));
				app.setAppusername(rs.getString(2));
				app.setUname(rs.getString(3));
				app.setUdate(rs.getString(4));
				app.setUtype(rs.getString(5));
				list.add(app);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
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
	    return list;
	}
	public int checkName(String appusername){//���ݱ�Ų�ѯ��Ϣ
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int size = 0;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Uapp_table where appusername=?");
			pstmt.setString(1,appusername);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()){
				size = 1;
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
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
	    return size;
	}
	public void addAPP(Uapp uapp){//�����Ϣ
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into Uapp_table (appusername,uname,udate,utype) values(?,?,?,?)";//SQL���
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uapp.getAppusername());
			pstmt.setString(2, uapp.getUname());
			pstmt.setString(3, uapp.getUdate());
			pstmt.setString(4, uapp.getUtype());
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
	public int update(Uapp uapp){//����
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Uapp_table set utype=?,udate=? where appusername=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uapp.getUtype());
			pstmt.setString(2, uapp.getUdate());
			pstmt.setString(3, uapp.getAppusername());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("�����ɹ�");
				c=1;
				
			}else
				System.out.println("����ʧ��");
			
	}catch(ClassNotFoundException e){
		System.out.println("ע������ʧ�ܣ�");
	}catch(SQLException e){
		System.out.println("���Ӵ���ʧ�ܣ�");
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
		return c;
	}
	public int updateUname(Uapp uapp){//����
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Uapp_table set utype=? where uname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uapp.getUtype());
			pstmt.setString(2, uapp.getUname());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("�����ɹ�");
				c=1;
			}else
				System.out.println("����ʧ��");
			
	}catch(ClassNotFoundException e){
		System.out.println("ע������ʧ�ܣ�");
	}catch(SQLException e){
		System.out.println("���Ӵ���ʧ�ܣ�");
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
		return c;
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
			pstmt1 = conn.prepareStatement("select count(*) from Uapp_table");
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
		List<Uapp> list = new ArrayList<Uapp>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+NUM_PER_PAGE+" * from (select row_number() over(order by udate desc) as rownumber,* from Uapp_table) temp_row where rownumber>(("+currentPage+"-1)*"+NUM_PER_PAGE+");");
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				Uapp app = new Uapp();
				app.setUid(rs.getInt("uid"));
				app.setAppusername(rs.getString("appusername"));
				app.setUname(rs.getString("uname"));
				app.setUdate(rs.getString("udate"));
				app.setUtype(rs.getString("utype"));
				list.add(app);
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
