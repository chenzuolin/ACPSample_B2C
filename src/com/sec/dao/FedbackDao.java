package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Fedback;

public class FedbackDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Fedback fedback){//增加
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Fedback_table (Fedback_Content,Wineshop_ID,Fedback_Time) values(?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fedback.getFedback_Content());
			pstmt.setInt(2, fedback.getWineshop_ID());
			pstmt.setString(3, fedback.getFedback_Time());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
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
		
	}
	
public void update(Fedback fedback){//更新
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Fedback_table set Fedback_Content=?,Wineshop_ID=?,Fedback_Time=? where Fedback_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fedback.getFedback_Content());
			pstmt.setInt(2, fedback.getWineshop_ID());
			pstmt.setString(3, fedback.getFedback_Time());
			pstmt.setInt(4, fedback.getFedback_ID());
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

public int delete(int Fedback_ID){//删除

	Connection conn = null;
	PreparedStatement pstmt = null;
	int a= 0;
	String sql = "delete from Fedback_table where Fedback_ID=?";
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Fedback_ID);
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

public Fedback findUserByID(int Fedback_ID){//根据编号查询用户和密码
	Fedback fedback = new Fedback();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Fedback_table where Fedback_ID=?");
		pstmt.setInt(1,Fedback_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			fedback.setFedback_ID(rs.getInt(1));
			fedback.setFedback_Content(rs.getString(2));
			fedback.setWineshop_ID(rs.getInt(3));
			fedback.setFedback_Time(rs.getString(4));
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
    return fedback;
}



public List<Fedback> findUserByID1(int Wineshop_ID){//根据编号查询用户和密码
	Fedback fedback = new Fedback();
     List<Fedback> list = new ArrayList<Fedback>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Fedback_table where Wineshop_ID=?");
		pstmt.setInt(1,Wineshop_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			fedback.setFedback_ID(rs.getInt(1));
			fedback.setFedback_Content(rs.getString(2));
			fedback.setWineshop_ID(rs.getInt(3));
			fedback.setFedback_Time(rs.getString(4));
			list.add(fedback);
			
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
    return list;
}

public List<Fedback> findUserByID9(int Wineshop_ID){//根据编号查询信息
	List<Fedback> list = new ArrayList<Fedback>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Fedback_table where Wineshop_ID=?");
		pstmt.setInt(1,Wineshop_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()) {
			Fedback cc = new Fedback();
				cc.setFedback_ID(rs.getInt(1));
				cc.setFedback_Content(rs.getString(2));
				cc.setWineshop_ID(rs.getInt(3));
				cc.setFedback_Time(rs.getString(4));
				list.add(cc);
		}
    }catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (Exception e) {
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
    return list;
}




public List<Fedback> findAll(){//查询表的所有信息
    List<Fedback> fedbacks = new ArrayList<Fedback>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Fedback_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Fedback fedback = new Fedback();
			fedback.setFedback_ID(rs.getInt(1));
			fedback.setFedback_Content(rs.getString(2));
			fedback.setWineshop_ID(rs.getInt(3));
			fedback.setFedback_Time(rs.getString(4));
			fedbacks.add(fedback);
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
    return fedbacks;
}
}
