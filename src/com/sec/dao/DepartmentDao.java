package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Department;



public class DepartmentDao {
		String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
		String username="green";
		String pwd = "12345678";
		
public void add(Department department) {//�������
	Connection conn=null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
		conn = DriverManager.getConnection(url,username,pwd);//����
		String sql = "insert into Department_table (Department_Name,Department_Remark) values(?,?)";//SQL���
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, department.getDepartment_Name());
		pstmt.setString(2, department.getDepartment_Remark());
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

public Department findUserByID(int Department_ID){//���ݱ�Ų�ѯ��Ϣ
	Department department = new Department();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Department_table where Department_ID=?");
		pstmt.setInt(1,Department_ID);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		if(rs.next()!=false){
			department.setDepartment_ID(rs.getInt(1));
			department.setDepartment_Name(rs.getString(2));
			department.setDepartment_Remark(rs.getString(3));
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
    return department;
}	

public void update(Department department){//����
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Department_table set Department_Name=?,Department_Remark=? where Department_ID=?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, department.getDepartment_Name());
		pstmt.setString(2, department.getDepartment_Remark());
		pstmt.setInt(3, department.getDepartment_ID());
		
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


public Department delete(int Department_ID){//ɾ��
	Department department=new Department();
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "delete * from  Department_table where Department_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, department.getDepartment_ID());
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
	return department;
}


public List<Department> findAll(){//��ѯ���������Ϣ
    List<Department> departments = new ArrayList<Department>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Department_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Department department=new Department();
			department.setDepartment_ID(rs.getInt(1));
			department.setDepartment_Name(rs.getString(2));
			department.setDepartment_Remark(rs.getString(3));
			departments.add(department);
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
    return departments;
}
}
