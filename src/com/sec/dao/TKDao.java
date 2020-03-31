package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Indent;
import com.sec.entity.TK;
import com.sec.entity.Wineshop;

public class TKDao {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Green express";
		String username = "green";
		String pwd = "12345678";
		public static final int NUM_PER_PAGE = 14;
		
		
		
		public void add(TK t) {// �����Ϣ
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// ��������
				conn = DriverManager.getConnection(url, username, pwd);// ����
				String sql = "insert into TK_table (Indent_ID,Wineshop_ID,Greens_Name,Greens_Number,Greens_Price,TK_Type) values(?,?,?,?,?,?)";// SQL���
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, t.getIndent_ID());
				pstmt.setInt(2, t.getWineshop_ID());
				pstmt.setString(3, t.getGreens_Name());
				pstmt.setInt(4, t.getGreens_Number());
				pstmt.setString(5, t.getGreens_Price());
				pstmt.setString(6, t.getTK_Type());
				
				boolean a = pstmt.execute();
				if (!a) {
					System.out.println("��ӳɹ�");
				} else
					System.out.println("���ʧ��");

			} catch (ClassNotFoundException e) {
				System.out.println("ע������ʧ�ܣ�");
			} catch (SQLException e) {
				System.out.println("���Ӵ���ʧ�ܣ���");// �쳣�׳�
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		
		public List<TK> Select(int Indent_ID){//���ݱ�Ų�ѯ��Ϣ
			List<TK> list = new ArrayList<TK>();
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from TK_table where Indent_ID=?");
				pstmt.setInt(1,Indent_ID);
				rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
				while(rs.next()){
					TK t = new TK();
					t.setGreens_Name(rs.getString("Greens_Name"));
					t.setGreens_Number(rs.getInt("Greens_Number"));
					t.setGreens_Price(rs.getString("Greens_Price"));
					t.setTK_ID(rs.getInt("TK_ID"));
					t.setTK_Type(rs.getString("TK_Type"));
					t.setWineshop_ID(rs.getInt("Wineshop_ID"));
					list.add(t);
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
