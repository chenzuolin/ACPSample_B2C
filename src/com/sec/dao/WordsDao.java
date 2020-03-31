package com.sec.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Words;

public class WordsDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public String add(Words words) throws IOException{//����
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into Words_table (Woneshop_ID,Words_Title,Words_Time,Words_Type,Words_Content) values(?,?,?,?,?)";//SQL���
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, words.getWineshop_id());
			pstmt.setString(2, words.getWords_title());
			pstmt.setString(3, words.getWords_time());
			pstmt.setString(4, words.getWords_type());
			pstmt.setString(5, words.getWords_content());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("��ӳɹ�");
				c = "�ɹ�";
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
	public List<Words> findUserByID5(String Wineshop_ID){//���ݱ�Ų�ѯ��Ϣ
		List<Words> list = new ArrayList<Words>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Words_table where Wineshop_ID=?");
			pstmt.setString(1,Wineshop_ID);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()){
				Words words = new Words();
				words.setWords_id(rs.getInt(1));
				words.setWineshop_id(rs.getInt(2));
				words.setWords_title(rs.getString(3));
				words.setWords_time(rs.getString(4));
				words.setWords_type(rs.getString(5));
				words.setWords_content(rs.getString(6));
				list.add(words);
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
