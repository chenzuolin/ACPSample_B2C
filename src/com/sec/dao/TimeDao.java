package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Greens;
import com.sec.entity.Time;

public class TimeDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void update(Time time){//����
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Time_table set Time1=?,Time2=? where Time_ID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, time.getTime1());
			pstmt.setString(2, time.getTime2());
			pstmt.setInt(3, time.getTime_ID());
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("�����ɹ�");
			}else
				System.out.println("����ʧ��");
			
	}catch(ClassNotFoundException e){
		System.out.println("ע������ʧ�ܣ�");
	}catch(SQLException e){
		System.out.println("���Ӵ���ʧ�ܣ�����");
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

	public List<Time> findAll(){//��ѯ���������Ϣ
		
		List<Time> list = new ArrayList<Time>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Time_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Time time = new Time();
				time.setTime_ID(rs.getInt(1));
				time.setTime1(rs.getString(2));
				time.setTime2(rs.getString(3));
				list.add(time);
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


}
