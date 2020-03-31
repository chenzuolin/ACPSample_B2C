package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Cart;
import com.sec.entity.Permission;
import com.sec.entity.User;
import com.sec.entity.User_Permission;

public class User_PermissionDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(User_Permission user_Permission) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into User_Permission_table(User_ID,Permission_ID) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_Permission.getUser_ID());
			pstmt.setInt(2, user_Permission.getPermission_ID());
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
	
	public List<User_Permission> findAll(){//查询表的所有信息
        List<User_Permission> list2 = new ArrayList<User_Permission>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from User_Permission_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				User_Permission user_Permission = new User_Permission();
				user_Permission.setUser_Permission_ID(rs.getInt(1));
				user_Permission.setUser_ID(rs.getInt(2));
				user_Permission.setPermission_ID(rs.getInt(3));
				list2.add(user_Permission);
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
	public int findUserByID1(int User_ID){//根据编号查询信息
		Permission permission = new Permission();
	     int a = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from User_Permission_table where User_ID=?");
			pstmt.setInt(1,User_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
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


	public int delete(int User_Permission_ID){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from User_Permission_table where User_Permission_ID=?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, User_Permission_ID);
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

	public List<User_Permission> findUserByID(int User_Permission_ID){//根据编号查询信息
		List<User_Permission> list1 = new ArrayList<User_Permission>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from User_Permission_table where User_Permission_ID=?");
			pstmt.setInt(1,User_Permission_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				User_Permission User_Permission = new User_Permission();
				User_Permission user_Permission = new User_Permission();
				user_Permission.setUser_Permission_ID(rs.getInt(1));
				user_Permission.setUser_ID(rs.getInt(2));
				user_Permission.setPermission_ID(rs.getInt(3));
				list1.add(User_Permission);
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
	public int findUserByID2(int User_ID){//根据编号查询信息
		List<User_Permission> list1 = new ArrayList<User_Permission>();
	     int a = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from User_Permission_table where User_ID=?");
			pstmt.setInt(1,User_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				a=rs.getInt(1);
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
	    return a;
	}
	public void update(User_Permission user_Permission){//更新
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update User_Permission_table set User_ID=?,Permission_ID=? where User_Permission_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_Permission.getUser_ID());
			pstmt.setInt(2, user_Permission.getPermission_ID());
			pstmt.setInt(3, user_Permission.getUser_Permission_ID());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("操作成功");
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
	}
	
	public int findUserByID3(int User_ID){//根据编号查询信息
		Permission permission = new Permission();
	     int a = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from User_Permission_table where User_ID=?");
			pstmt.setInt(1,User_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			if(rs.next()!=false){
				a=rs.getInt(3);
				
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

}
