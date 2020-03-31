package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Role_Permission;

public class Role_PermissionDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
public void add(Role_Permission role_Permission) {//�������
Connection conn=null;
PreparedStatement pstmt = null;
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
	conn = DriverManager.getConnection(url,username,pwd);//����
	String sql = "insert into Role_Permission_table (Role_ID,Permission_ID) values(?,?)";//SQL���
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, role_Permission.getRole_ID());
	pstmt.setInt(2, role_Permission.getPermission_ID());
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
public Role_Permission findUserByID(int Role_Permission_ID){//���ݱ�Ų�ѯ��Ϣ
	Role_Permission role_Permission = new Role_Permission();
 
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	conn = DriverManager.getConnection(url,username,pwd);
	pstmt = conn.prepareStatement("select * from Role_Permission_table where Role_Permission_ID=?");
	pstmt.setInt(1,Role_Permission_ID);
	rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
	if(rs.next()!=false){
		role_Permission.setRole_ID(rs.getInt(1));
		role_Permission.setPermission_ID(rs.getInt(2));
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
return role_Permission;
}


public void update(Role_Permission role_Permission){//����

Connection conn = null;
PreparedStatement pstmt = null;
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	conn = DriverManager.getConnection(url,username,pwd);
	String sql = "update Role_Permission_table set Role_ID=?,Permission_ID=? where Role_ID=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, role_Permission.getRole_ID());
	pstmt.setInt(2, role_Permission.getPermission_ID());
	
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


public Role_Permission delete(int Role_Permission_ID){//ɾ��
	Role_Permission role_Permission=new Role_Permission();
Connection conn = null;
PreparedStatement pstmt = null;
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	conn = DriverManager.getConnection(url,username,pwd);
	String sql = "delete * from  Role_Permission_table where Role_Permission_ID=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, role_Permission.getRole_Permission_ID());
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
return role_Permission;
}


public List<Role_Permission> findAll(){//��ѯ���������Ϣ
List<Role_Permission> role_Permissions = new ArrayList<Role_Permission>();

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	conn = DriverManager.getConnection(url,username,pwd);
	pstmt = conn.prepareStatement("select * from Role_Permission_table");
	rs = pstmt.executeQuery();
	while(rs.next()){
		Role_Permission role_Permission=new Role_Permission();
		role_Permission.setRole_ID(rs.getInt(1));
		role_Permission.setPermission_ID(rs.getInt(2));
		role_Permissions.add(role_Permission);
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
return role_Permissions;
}

}
