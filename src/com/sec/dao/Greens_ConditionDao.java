package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Greens_Character;
import com.sec.entity.Greens_Condition;

public class Greens_ConditionDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Greens_Condition greens_Condition) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into Greens_Condition_table(Greens_Condition) values (?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, greens_Condition.getGreens_Condition());
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
	
	public List<Greens_Condition> findAll(){//��ѯ���������Ϣ
        List<Greens_Condition> list2 = new ArrayList<Greens_Condition>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Greens_Condition_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Greens_Condition greens_Condition = new Greens_Condition();
				greens_Condition.setGreens_Condition(rs.getString(2));
				list2.add(greens_Condition);
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

	public List<Greens_Condition> findleixin(String Class_Name){//��ѯ���������Ϣ
        List<Greens_Condition> list2 = new ArrayList<Greens_Condition>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Greens_Condition_table where Class_Name=?");
			pstmt.setString(1,Class_Name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Greens_Condition greens_Condition = new Greens_Condition();
				greens_Condition.setGreens_Condition(rs.getString(2));
				list2.add(greens_Condition);
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


}
