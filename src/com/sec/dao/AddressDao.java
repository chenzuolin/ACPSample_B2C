package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Address;

public class AddressDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Address address){//����
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into Address_table (Wineshop_ID,Address_Name) values(?,?)";//SQL���
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, address.getWineshop_ID());
			pstmt.setString(2, address.getAddress_Name());
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
	
public void update(Address address){//����
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Address_table set Wineshop_ID=?,Address_Name=? where Address_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, address.getWineshop_ID());
			pstmt.setString(2, address.getAddress_Name());
			pstmt.setInt(3, address.getAddress_ID());
			boolean b=pstmt.execute();
			if(!b){
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

public Address delete(int Address_ID){//ɾ��
		Address address = new Address();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "delete * from  Address_table where Address_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, address.getAddress_ID());
			pstmt.executeUpdate(sql);
			boolean p=pstmt.execute();
			if(!p){
				System.out.println("ɾ���ɹ�");
			}else
				System.out.println("ɾ��ʧ��");
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
		return address;
	}

public Address findUserByID(int Address_ID){//���ݱ�Ų�ѯ�û�������
	Address address = new Address();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Address_table where Address_ID=?");
		pstmt.setInt(1,Address_ID);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		if(rs.next()!=false){
			address.setAddress_ID(rs.getInt(1));
			address.setWineshop_ID(rs.getInt(2));
			address.setAddress_Name(rs.getString(3));
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
    return address;
}

public List<Address> findAll(){//��ѯ���������Ϣ
    List<Address> addresss = new ArrayList<Address>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Address_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Address address = new Address();
			address.setAddress_ID(rs.getInt(1));
			address.setWineshop_ID(rs.getInt(2));
			address.setAddress_Name(rs.getString(3));
			addresss.add(address);
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
    return addresss;
}


}
