package com.sec.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.FenPei;
import com.sec.entity.Greens;
import com.sec.entity.Wineshop;

public class FenPeiDao {
	
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public String add(FenPei fenpei) throws IOException{//����
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			
			String sql = "insert into FenPei_table (Wineshop_ID,Wineshop_Name,FenPei_UserName,FenPei_Password,FenPei_Telephone) values(?,?,?,?,?)";//SQL���
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, fenpei.getWineshop_ID());
			pstmt.setString(2, fenpei.getWineshop_Name());
			pstmt.setString(3, fenpei.getFenPei_UserName());
			pstmt.setString(4, fenpei.getFenPei_Password());
			pstmt.setString(5, fenpei.getFenPei_Telephone());
			
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("��ӳɹ�");
				c = "dasd";
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
	return c;	
	}
	
	
	public List<FenPei> Select(int Wineshop_ID){//���ݱ�Ų�ѯ��Ϣ
		List<FenPei> list = new ArrayList<FenPei>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from FenPei_table where Wineshop_ID=?");
			pstmt.setInt(1,Wineshop_ID);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()){
				FenPei fenpei = new FenPei();
				fenpei.setFenPei_ID(rs.getInt(1));
				fenpei.setWineshop_ID(rs.getInt(2));
				fenpei.setWineshop_Name(rs.getString(3));
				fenpei.setFenPei_UserName(rs.getString(4));
				fenpei.setFenPei_Password(rs.getString(5));
				fenpei.setFenPei_Telephone(rs.getString(6));
				
				list.add(fenpei);
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
	
	public int checkFenPei(String FenPei_UserName,String FenPei_Password) {
		int Wineshop_ID = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from FenPei_table where FenPei_UserName=? and FenPei_Password=?");
			pstmt.setString(1, FenPei_UserName);
			pstmt.setString(2, FenPei_Password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Wineshop_ID = rs.getInt("Wineshop_ID");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return Wineshop_ID;
		
	}
	
	public int findUserByID(String FenPei_UserName){//���ݾƵ��ջ�Ա�ĵ�¼����ѯ�Ƶ���
		int a = 0;
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from FenPei_table");
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		while(rs.next()) {
			String aa = rs.getString(4);//�Ƶ��¼��
			if(aa.contains(FenPei_UserName)) {
				
				a = rs.getInt(2);//�Ƶ���
			}
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
	    return a;
	}
	
	
}
