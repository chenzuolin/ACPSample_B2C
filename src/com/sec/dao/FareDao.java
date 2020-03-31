package com.sec.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sec.entity.*;



public class FareDao {
	String url="jdbc:sqlserver://lostlhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";

public void update(Fare fare){//����
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Fare_table set Fare_Axiom_Price=?,Fare_Type=? where Fare_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, fare.getFare_Axiom_Price());
			pstmt.setString(2, fare.getFare_Type());
			pstmt.setInt(3, fare.getFare_ID());
			boolean y=pstmt.execute();
			if(!y){
				System.out.println("�����ɹ�");
			}else
				System.out.println("����ʧ��");
			
	}catch(ClassNotFoundException e){
		System.out.println("ע������ʧ�ܣ�");
	}catch(SQLException e){
		System.out.println("");
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

public Fare delete(int Fare_ID){//ɾ��
		Fare fare=new Fare();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "delete * from  Fare_table where Fare_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fare.getFare_ID());
			pstmt.executeUpdate(sql);
			boolean o=pstmt.execute();
			if(!o){
				System.out.println("����ɹ�");
			}else
				System.out.println("���ʧ��");
	}catch(ClassNotFoundException e){
		System.out.println("ע������ʧ�ܣ�");
	}catch(SQLException e){
		System.out.println("���Ӵ���ʧ�ܣ���");
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
	return fare;	
	}
	
public void add(Fare fare){//�����Ϣ
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
		conn = DriverManager.getConnection(url,username,pwd);//����
		String sql = "insert into Fare_table (Fare_Axiom_Price,Fare_Type) values(?,?)";//SQL���
		pstmt = conn.prepareStatement(sql);
		pstmt.setFloat(1, fare.getFare_Axiom_Price());
		pstmt.setString(2, fare.getFare_Type());
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


public List<Fare> findAll(){//��ѯ���������Ϣ
	        List<Fare> users = new ArrayList<Fare>();
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from Fare_table");
				rs = pstmt.executeQuery();
				while(rs.next()){
					Fare fare = new Fare();
					fare.setFare_ID(rs.getInt(1));
					fare.setFare_Axiom_Price(rs.getFloat(2));
					fare.setFare_Type(rs.getString(3));
					users.add(fare);
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
	        return users;
	    }
}

	 
		        
