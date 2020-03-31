package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.FJ;


public class FJDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(FJ fj) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into FJ_table(FJ_UserName,FJ_PassWord,FJ_Name,FJ_Telephone) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fj.getFJ_UserName());
			pstmt.setString(2, fj.getFJ_PassWord());
			pstmt.setString(3, fj.getFJ_Name());
			pstmt.setString(4, fj.getFJ_Telephone());
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
	
	public List<FJ> findAll(){//查询表的所有信息
        List<FJ> list2 = new ArrayList<FJ>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from FJ_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				FJ fj = new FJ();
				fj.setFJ_ID(rs.getInt(1));
				fj.setFJ_UserName(rs.getString(2));
				fj.setFJ_PassWord(rs.getString(3));
				fj.setFJ_Name(rs.getString(4));
				fj.setFJ_Telephone(rs.getString(5));
				list2.add(fj);
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
	
	public List<FJ> findUserByID(String FJ_Name){//根据编号查询信息
		List<FJ> list1 = new ArrayList<FJ>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from FJ_table where FJ_Name = ?");
			pstmt.setString(1,FJ_Name);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				FJ fj = new FJ();
				fj.setFJ_ID(rs.getInt(1));
				fj.setFJ_UserName(rs.getString(2));
				fj.setFJ_PassWord(rs.getString(3));
				fj.setFJ_Name(rs.getString(4));
				fj.setFJ_Telephone(rs.getString(5));
				list1.add(fj);
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
	
	/*public int update1(CG cg){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update CG_table set Number=? where Cart_ID=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cart.getNumber());
			
			pstmt.setInt(2, cart.getCart_ID());
			
			
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
	}*/
	
	public int delete(String FJ_Name){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from FJ_table where FJ_Name = ?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, FJ_Name);
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
	
	public int checkFJ(String FJ_UserName,String FJ_Password){//根据密码和用户查询
		
		int a=0;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection(url,username,pwd);
					pstmt = conn.prepareStatement("select * from FJ_table where FJ_UserName=? and FJ_Password=?");
					pstmt.setString(1, FJ_UserName);
					pstmt.setString(2, FJ_Password);
					rs = pstmt.executeQuery();
					if(rs.next()){
						a=3;
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
		        return a;
		    }
	
	public List<FJ> findUserByID1(String FJ_UserName){//根据编号查询信息
		List<FJ> list1 = new ArrayList<FJ>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from FJ_table where FJ_UserName = ?");
			pstmt.setString(1,FJ_UserName);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				FJ fj = new FJ();
				fj.setFJ_ID(rs.getInt(1));
				fj.setFJ_UserName(rs.getString(2));
				fj.setFJ_PassWord(rs.getString(3));
				fj.setFJ_Name(rs.getString(4));
				fj.setFJ_Telephone(rs.getString(5));
				list1.add(fj);
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
	

	

}
