package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Regionality;



public class RegionalityDao{
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
public void update(Regionality regionality){//����
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Regionality_table set Regionality_Name=?,"
					+ "Regionality_Custom=?,Regionality_Market=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, regionality.getRegionality_Name());
			pstmt.setString(2, regionality.getRegionality_Custom());
			pstmt.setString(3, regionality.getRegionality_Market());
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


public Regionality delete(int Regionality_ID){//ɾ��
	Regionality regionality=new Regionality();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "delete * from  Regionality_table where Regionality_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, regionality.getRegionality_ID());
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
	return regionality;	
	}
public Regionality findUserByID(int Regionality_ID){//���ݱ�Ų�ѯ��Ϣ
	Regionality regionality = new Regionality();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Regionality_table where Regionality_ID=?");
		pstmt.setInt(1,Regionality_ID);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		if(rs.next()!=false){
			regionality.setRegionality_ID(rs.getInt(1));
			regionality.setRegionality_Name(rs.getString(2));
			regionality.setRegionality_Custom(rs.getString(3));
			regionality.setRegionality_Market(rs.getString(4));
			
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
    return regionality;
}	
public void add(Regionality regionality){//�����Ϣ
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
		conn = DriverManager.getConnection(url,username,pwd);//����
		String sql = "insert into Regionality_table (Regionality_Name,Regionality_Custom,Regionality_Market) values(?,?,?)";//SQL���
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, regionality.getRegionality_Name());
		pstmt.setString(1, regionality.getRegionality_Custom());
		pstmt.setString(1, regionality.getRegionality_Market());
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


public List<Regionality> findAll(){//��ѯ���������Ϣ
	        List<Regionality> regionalitys = new ArrayList<Regionality>();
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from Regionality_table");
				rs = pstmt.executeQuery();
				while(rs.next()){
					Regionality regionality = new Regionality();
					regionality.setRegionality_ID(rs.getInt(1));
					regionality.setRegionality_Name(rs.getString(2));
					regionality.setRegionality_Custom(rs.getString(3));
					regionality.setRegionality_Market(rs.getString(4));
					regionalitys.add(regionality);
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
	        return regionalitys;
	    }
}

	 
		        
