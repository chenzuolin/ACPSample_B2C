package com.sec.Activity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Cart;

public class SBDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	
	
	
	
	public String add(SB x) {//����
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			
			String sql = "insert into SB_table (Wineshop_ID,LJ_Num,SB_Num,Num_one,Num_Two,Num_BS,Num_OFF) values(?,?,?,?,?,?,?)";//SQL���
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, x.getWineshop_ID());
			pstmt.setString(2, x.getLJ_Num());
			pstmt.setString(3, x.getSB_Num());
			pstmt.setString(4, x.getNum_one());
			pstmt.setString(5, x.getNum_Two());
			pstmt.setInt(6, x.getNum_BS());
			pstmt.setInt(7, x.getNum_OFF());
			
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
	public List<SB> findAll(int aa){//��ѯ���������Ϣ
        List<SB> list2 = new ArrayList<SB>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from SB_table where Wineshop_ID = ?");
			pstmt.setInt(1,aa);
			rs = pstmt.executeQuery();
			while(rs.next()){
				SB c = new SB();
				c.setSB_ID(rs.getInt(1));
				c.setWineshop_ID(rs.getInt("Wineshop_ID"));
				c.setSB_Num(rs.getString("SB_Num"));
				c.setLJ_Num(rs.getString("LJ_Num"));
				c.setNum_one(rs.getString("Num_one"));
				c.setNum_Two(rs.getString("Num_Two"));
				c.setNum_Three(rs.getFloat("Num_Three"));
				list2.add(c);
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
	
	public List<SB> findAlls(){//��ѯ���������Ϣ
        List<SB> list2 = new ArrayList<SB>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from SB_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				SB c = new SB();
				c.setSB_ID(rs.getInt(1));
				c.setWineshop_ID(rs.getInt("Wineshop_ID"));
				c.setSB_Num(rs.getString("SB_Num"));
				c.setLJ_Num(rs.getString("LJ_Num"));
				c.setNum_one(rs.getString("Num_one"));
				c.setNum_Two(rs.getString("Num_Two"));
				c.setNum_BS(rs.getInt("Num_BS"));
				c.setNum_OFF(rs.getInt("Num_OFF"));
				list2.add(c);
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
	
	public int update1(SB s){//����
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update SB_table set SB_Num=? where Wineshop_ID=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, s.getSB_Num());
			
			pstmt.setInt(2, s.getWineshop_ID());
			
			
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
	
	public int update(SB s){//����
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update SB_table set LJ_Num=?,SB_Num=? where Wineshop_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getLJ_Num());
			pstmt.setString(2, s.getSB_Num());
			pstmt.setInt(3, s.getWineshop_ID());
			
			
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

	
	public int updates(String s,int w){//����
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update SB_table set SB_Num=?,Num_BS = 1 where Wineshop_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s);
			pstmt.setInt(2, w);
			
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
	
	public int updates1(){//����
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update SB_table set Num_BS = 0 ";
			pstmt = conn.prepareStatement(sql);
			
			
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

	public int up(String aa){//����
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update SB_table set Num_Two=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aa);
			
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
