package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Complainant;

public class ComplainantDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public String add(Complainant complainant){//增加
		String c = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Complainant_table (Complainant_Content,Complainant_Type,Complainant_Time,Wineshop_ID) values(?,?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, complainant.getComplainant_Content());
			pstmt.setString(2, complainant.getComplainant_Type());
			pstmt.setString(3, complainant.getComplainant_Time());
			pstmt.setInt(4, complainant.getWineshop_ID());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
				c = "sda";
			}else
				System.out.println("添加失败");
				
		}catch(ClassNotFoundException e){
			System.out.println("注册驱动失败！");
		}catch(SQLException e){
			System.out.println("连接创建失败！！");//异常抛出
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
	
public void update(Complainant complainant){//更新
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Complainant_table set Complainant_Content=?,Complainant_Type=?,Complainant_Time=?,Wineshop_ID=? where Complainant_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, complainant.getComplainant_Content());
			pstmt.setString(2, complainant.getComplainant_Type());
			pstmt.setString(3, complainant.getComplainant_Time());
			pstmt.setInt(4, complainant.getWineshop_ID());
			pstmt.setInt(5, complainant.getComplainant_ID());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("操作成功");
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
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

public int delete(int Complainant_ID){//删除
	int a= 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete  from Complainant_table where Complainant_ID=?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Complainant_ID);
			a=pstmt.executeUpdate();
			if(a>0){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
			
		}catch(Exception e){
			e.printStackTrace();
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

public Complainant findUserByID(int Complainant_ID){//根据编号查询用户和密码
	Complainant complainant = new Complainant();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Complainant_table where Complainant_ID=?");
		pstmt.setInt(1,Complainant_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			complainant.setComplainant_ID(rs.getInt(1));
			complainant.setComplainant_Content(rs.getString(2));
			complainant.setComplainant_Type(rs.getString(3));
			complainant.setComplainant_Time(rs.getString(4));
			complainant.setWineshop_ID(rs.getInt(5));
		}
    }catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        //8，关闭资源
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
    return complainant;
}

public List<Complainant> findAll(){//查询表的所有信息
    List<Complainant> complainants = new ArrayList<Complainant>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Complainant_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Complainant complainant = new Complainant();
			complainant.setComplainant_ID(rs.getInt(1));
			complainant.setComplainant_Content(rs.getString(2));
			complainant.setComplainant_Type(rs.getString(3));
			complainant.setComplainant_Time(rs.getString(4));
			complainant.setWineshop_ID(rs.getInt(5));
			complainants.add(complainant);
		}
    }catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        //8，关闭资源
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
    return complainants;
}
}
