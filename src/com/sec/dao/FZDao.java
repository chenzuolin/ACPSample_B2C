package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.sec.entity.FZ;
import com.sec.util.C3p0Utils;


public class FZDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(FZ fz) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into FZ_table(Indent_ID,CG_Name,FJ_Name,Courier_Name,XD_Time,CG_Time,FJ_Time,PS_Time,FenPei_UserName,FenPei_Time) values (?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fz.getIndent_ID());
			pstmt.setString(2, fz.getCG_Name());
			pstmt.setString(3, fz.getFJ_Name());
			pstmt.setString(4, fz.getCourier_Name());
			pstmt.setString(5, fz.getXD_Time());
			pstmt.setString(6, fz.getCG_Time());
			pstmt.setString(7, fz.getFJ_Time());
			pstmt.setString(8, fz.getPS_Time());
			pstmt.setString(9, fz.getFenPei_UserName());
			pstmt.setString(10, fz.getFenPei_Time());
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
	
	public List<FZ> findAll(){//查询表的所有信息
        List<FZ> list2 = new ArrayList<FZ>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from FZ_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				FZ fz = new FZ();
				fz.setFZ_ID(rs.getInt(1));
				fz.setIndent_ID(rs.getInt(2));
				fz.setCG_Name(rs.getString(3));
				fz.setFJ_Name(rs.getString(4));
				fz.setCourier_Name(rs.getString(5));
				fz.setXD_Time(rs.getString(6));
				fz.setCG_Time(rs.getString(7));
				fz.setFJ_Time(rs.getString(8));
				fz.setPS_Time(rs.getString(9));
				list2.add(fz);
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
        return list2;
    }
	public int getOrFinish(int indentID){//查询表的所有信息
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select finish_time,address from FZ_table where Indent_ID=? ");
			pstmt.setInt(1,indentID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String time = rs.getString("finish_time");
				System.out.println(time);
				String addr = rs.getString("address");
				if(time==null||addr==null){
					count = 1;
				}
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
        return count;
    }
	
	public List<FZ> findUserByID(int Indent_ID){//根据编号查询信息
		List<FZ> list1 = new ArrayList<FZ>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from FZ_table where Indent_ID = ?");
			pstmt.setInt(1,Indent_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				FZ fz = new FZ();
				fz.setFZ_ID(rs.getInt(1));
				fz.setIndent_ID(rs.getInt(2));
				fz.setCG_Name(rs.getString(3));
				fz.setFJ_Name(rs.getString(4));
				fz.setCourier_Name(rs.getString(5));
				fz.setXD_Time(rs.getString(6));
				fz.setCG_Time(rs.getString(7));
				fz.setFJ_Time(rs.getString(8));
				fz.setPS_Time(rs.getString(9));
				list1.add(fz);
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
	    return list1;
	}
	public int updatefinish(FZ fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update FZ_table set finish_time=?,address=? where Indent_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fz.getFinish_time());
			pstmt.setString(2, fz.getAddress());
			pstmt.setInt(3, fz.getIndent_ID());
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
	
	public int updateCG(FZ fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update FZ_table set CG_Name=? where Indent_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fz.getCG_Name());
			
			pstmt.setInt(2, fz.getIndent_ID());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
	
	public int updateFJ(FZ fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update FZ_table set FJ_Name=? where Indent_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fz.getFJ_Name());
			
			pstmt.setInt(2, fz.getIndent_ID());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
	
	public int updateCourier(FZ fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update FZ_table set Courier_Name=? where Indent_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fz.getCourier_Name());
			
			pstmt.setInt(2, fz.getIndent_ID());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
	
	public int updateXDTIME(FZ fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update FZ_table set XD_Time=? where Indent_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fz.getXD_Time());
			
			pstmt.setInt(2, fz.getIndent_ID());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
	
	public int updateCGTIME(FZ fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update FZ_table set CG_Time=? where Indent_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fz.getCG_Time());
			
			pstmt.setInt(2, fz.getIndent_ID());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
	
	public int updateFJTIME(FZ fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update FZ_table set FJ_Time=? where Indent_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fz.getFJ_Time());
			
			pstmt.setInt(2, fz.getIndent_ID());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
	
	public int updatePSTIME(FZ fz){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update FZ_table set PS_Time=? where Indent_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fz.getPS_Time());
			
			pstmt.setInt(2, fz.getIndent_ID());
			
			
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("更新成功");
				a = 1;
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！！！");
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
	
	public int delete(int Indent_ID){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from FZ_table where Indent_ID = ?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Indent_ID);
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
	
	
	
public void update100(FZ fz){//更新
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update FZ_table set FenPei_UserName=?,FenPei_Time=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fz.getFenPei_UserName());
			pstmt.setString(2, fz.getFenPei_Time());
			pstmt.setInt(3, fz.getIndent_ID());
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
	/**
	 * 根据订单编号进行删除
	 * @param indentById
	 * @return
	 */
	public int delIndentById(int indentById){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from FZ_table where Indent_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,indentById);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code > 0 ? 200 : -1;
	}

}
