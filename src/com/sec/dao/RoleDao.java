package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sec.entity.Role;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;


public class RoleDao {
		String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
		String username="green";
		String pwd = "12345678";
		
public void add(Role role) {//�������
	Connection conn=null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
		conn = DriverManager.getConnection(url,username,pwd);//����
		String sql = "insert into Role_table (Role_Name,Role_Remark) values(?,?)";//SQL���
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, role.getRole_Name());
		pstmt.setString(2, role.getRole_Remark());
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
public Role findUserByID(int Role_ID){//���ݱ�Ų�ѯ��Ϣ
	Role role = new Role();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Role_table where Role_ID=?");
		pstmt.setInt(1,Role_ID);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		if(rs.next()!=false){
			role.setRole_ID(rs.getInt(1));
			role.setRole_Name(rs.getString(2));
			role.setRole_Remark(rs.getString(3));
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
    return role;
}


public void update(Role role){//����
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Role_table set Role_Name=?,Role_Remark=? where Role_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, role.getRole_Name());
		pstmt.setString(2, role.getRole_Remark());
		
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


public Role delete(int Role_ID){//ɾ��
	Role role=new Role();
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "delete * from  Role_table where Role_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,Role_ID);
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
	return role;
}


public List<Role> findAll(){//��ѯ���������Ϣ
    List<Role> roles = new ArrayList<Role>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Role_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Role role=new Role();
			role.setRole_ID(rs.getInt(1));
			role.setRole_Name(rs.getString(2));
			role.setRole_Remark(rs.getString(3));
			roles.add(role);
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
    return roles;
}
/**
 * ��ѯ���н�ɫ
 * @return
 */
public Page getFindAll(){
	QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
	List<Role> list = null;
	Page page = new Page();
	String sql = "select Role_ID,Role_Name,Role_Remark from Role_table";
	try {
		list = qr.query(sql, new BeanListHandler<Role>(Role.class));
	} catch (SQLException e) {
		e.printStackTrace();
	}
	page.setData(list);
	return page;
}
}
