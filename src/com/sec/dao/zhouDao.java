package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.sec.entity.zhou;

public class zhouDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(zhou z) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into BaoBiao_table(zhou_Name,zhou_Number) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, z.getZhou_Name());
			pstmt.setInt(2, z.getZhou_Number());
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
	
	public List<zhou> findAll(){//��ѯ���������Ϣ
        List<zhou> list2 = new ArrayList<zhou>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from BaoBiao_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				zhou z= new zhou();
				z.setZhou_ID(rs.getInt(1));
				z.setZhou_Name(rs.getString(2));
				z.setZhou_Number(rs.getInt(3));
				list2.add(z);
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

	public int delete(){//ɾ��

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from BaoBiao_table ";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
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
	
	
	public int findUserByID2(String zhou_Name){//���ݱ�Ų�ѯ��Ϣ
		int a = 0;
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from BaoBiao_table");
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		while(rs.next()) {
			String aa = rs.getString(2);
			if(aa.contains(zhou_Name)) {
				zhou z =new zhou();
				a = rs.getInt(3);
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

	
	
	public int update1(zhou z){//����
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update BaoBiao_table set zhou_Number=? where zhou_Name=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, z.getZhou_Number());
			
			pstmt.setString(2, z.getZhou_Name());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("���³ɹ�");
				a = 1;
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
		return a;
	}
}
