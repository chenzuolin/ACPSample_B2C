package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Logistics;

public class LogisticsDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Logistics logistics){//增加
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Logistics_table (Indent_ID,Courier_ID,Logistics_Distribution_Time,Logistics_Delivery_Time,Logistics_Score) values(?,?,?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, logistics.getIndent_ID());
			pstmt.setInt(2, logistics.getCourier_ID());
			pstmt.setDate(3, logistics.getLogistics_Distribution_Time());
			pstmt.setDate(4, logistics.getLogistics_Delivery_Time());
			pstmt.setFloat(5, logistics.getLogistics_Score());
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
	
public void update(Logistics logistics){//更新
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Courier_table set Indent_ID=?,Courier_ID=?,Logistics_Distribution_Time=?,Logistics_Delivery_Time=?,Logistics_Score=? where Logistics_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, logistics.getIndent_ID());
			pstmt.setInt(2, logistics.getCourier_ID());
			pstmt.setDate(3, logistics.getLogistics_Distribution_Time());
			pstmt.setDate(4, logistics.getLogistics_Delivery_Time());
			pstmt.setFloat(5, logistics.getLogistics_Score());
			pstmt.setInt(6, logistics.getLogistics_ID());
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

public Logistics delete(int Logistics_ID){//删除
	Logistics logistics = new Logistics();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "delete * from Logistics_table where Logistics_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, logistics.getLogistics_ID());
			pstmt.executeUpdate(sql);
			boolean p=pstmt.execute();
			if(!p){
				System.out.println("删除成功");
			}else
				System.out.println("删除失败");
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！");
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
		return logistics;
	}

public Logistics findUserByID(int Logistics_ID){//根据编号查询用户和密码
	Logistics logistics = new Logistics();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Logistics_table where Logistics_ID=?");
		pstmt.setInt(1,Logistics_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			logistics.setLogistics_ID(rs.getInt(1));
			logistics.setIndent_ID(rs.getInt(2));
			logistics.setCourier_ID(rs.getInt(3));
			logistics.setLogistics_Distribution_Time(rs.getDate(4));
			logistics.setLogistics_Delivery_Time(rs.getDate(5));
			logistics.setLogistics_Score(rs.getFloat(6));
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
    return logistics;
}

public List<Logistics> findAll(){//查询表的所有信息
    List<Logistics> logisticss = new ArrayList<Logistics>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Logistics_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Logistics logistics = new Logistics();
			logistics.setLogistics_ID(rs.getInt(1));
			logistics.setIndent_ID(rs.getInt(2));
			logistics.setCourier_ID(rs.getInt(3));
			logistics.setLogistics_Distribution_Time(rs.getDate(4));
			logistics.setLogistics_Delivery_Time(rs.getDate(5));
			logistics.setLogistics_Score(rs.getFloat(6));
			logisticss.add(logistics);
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
    return logisticss;
}
}
