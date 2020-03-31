package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Permission;

public class PermissionDao {
		String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
		String username="green";
		String pwd = "12345678";
		
public void add(Permission permission) {//�������
	Connection conn=null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
		conn = DriverManager.getConnection(url,username,pwd);//����
		String sql = "insert into Permission_table (Permission_Remark) values(?)";//SQL���
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, permission.getPermission_Remark());
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

public String findUserByID(int permission_ID){//���ݱ�Ų�ѯ��Ϣ
	Permission permission = new Permission();
	String a = null;
      Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Permission_table where Permission_ID=?");
		pstmt.setInt(1,permission_ID);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		if(rs.next()!=false){
			a=rs.getString(3);
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
    return a;
}

public int findUserByID1(String permission_Remark){//���ݱ�Ų�ѯ��Ϣ
	Permission permission = new Permission();
     int a = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Permission_table where Permission_Remark=?");
		pstmt.setString(1,permission_Remark);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		if(rs.next()!=false){
			a=rs.getInt(1);
			
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
    return a;
}


public void update(Permission permission){//����
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Permission_table set Permission_Func_No=?,Permission_Remark=? where Permission_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, permission.getPermission_Func_No());
		pstmt.setString(2, permission.getPermission_Remark());
		pstmt.setInt(3, permission.getPermission_ID());
		
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


public Permission delete(int permission_ID){//ɾ��
	Permission permission=new Permission();
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "delete * from  Permission_table where Permission_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, permission.getPermission_ID());
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
	return permission;
}


public List<Permission> findAll(){//��ѯ���������Ϣ
    List<Permission> permissions = new ArrayList<Permission>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Permission_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Permission permission=new Permission();
			permission.setPermission_ID(rs.getInt(1));
			permission.setPermission_Func_No(rs.getInt(2));
			permission.setPermission_Remark(rs.getString(3));
			permissions.add(permission);
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
    return permissions;
}
}
