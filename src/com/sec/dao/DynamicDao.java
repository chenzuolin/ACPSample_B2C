package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Dynamic;
import com.sec.entity.Indent;



public class DynamicDao{
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
public void update(Dynamic dynamic){//更新
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Dynamic_table set Greens_ID=?,Dynamic_Price=?,Dynamic_Time=?,Dynamic_Market_Price=? where Dynamic_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dynamic.getGreens_ID());
			pstmt.setFloat(2, dynamic.getDynamic_Price());
			pstmt.setString(3, dynamic.getDynamic_Time());
			pstmt.setFloat(4, dynamic.getDynamic_Market_Price());
			pstmt.setInt(5, dynamic.getDynamic_ID());
			boolean y=pstmt.execute();
			if(!y){
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

public List<Dynamic> findUserByIDMouthnew(int Greens_ID){//周查询
	List<Dynamic> list = new ArrayList<Dynamic>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Dynamic_table where DATEDIFF(month,Dynamic_Time,GETDATE())=1 and Greens_ID = ?");
		pstmt.setInt(1,Greens_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()) {
			Dynamic dynamic = new Dynamic();
			dynamic.setDynamic_ID(rs.getInt(1));
			dynamic.setGreens_ID(rs.getInt(2));
			dynamic.setDynamic_Price(rs.getFloat(3));
			dynamic.setDynamic_Time(rs.getString(4));
			dynamic.setDynamic_Market_Price(rs.getFloat(5));
			list.add(dynamic);
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



public Dynamic delete(int Dynamic_ID){//删除
	Dynamic dynamic=new Dynamic();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "delete * from  Dynamic_table where Dynamic_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dynamic.getDynamic_ID());
			pstmt.executeUpdate(sql);
			boolean o=pstmt.execute();
			if(!o){
				System.out.println("输出成功");
			}else
				System.out.println("输出失败");
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
	return dynamic;	
	}
public Dynamic findUserByID(int Dynamic_ID){//根据编号查询信息
	Dynamic dynamic = new Dynamic();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Dynamic_table where Dynamic_ID=?");
		pstmt.setInt(1,Dynamic_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			dynamic.setDynamic_ID(rs.getInt(1));
			dynamic.setGreens_ID(rs.getInt(2));
			dynamic.setDynamic_Price(rs.getFloat(3));
			dynamic.setDynamic_Time(rs.getString(4));
			dynamic.setDynamic_Market_Price(rs.getFloat(5));
			
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
    return dynamic;
}	
public void add(Dynamic dynamic){//添加信息
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
		conn = DriverManager.getConnection(url,username,pwd);//连接
		String sql = "insert into Dynamic_table (Greens_ID,Dynamic_Price,Dynamic_Time,Dynamic_Market_price) values(?,?,?,?)";//SQL语句
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dynamic.getGreens_ID());
		pstmt.setFloat(2, dynamic.getDynamic_Price());
		pstmt.setString(3, dynamic.getDynamic_Time());
		pstmt.setFloat(4, dynamic.getDynamic_Market_Price());
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


public List<Dynamic> findAll(){//查询表的所有信息
	        List<Dynamic> dynamics = new ArrayList<Dynamic>();
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from Dynamic_table");
				rs = pstmt.executeQuery();
				while(rs.next()){
					Dynamic dynamic = new Dynamic();
					dynamic.setDynamic_ID(rs.getInt(1));
					dynamic.setGreens_ID(rs.getInt(2));
					dynamic.setDynamic_Price(rs.getFloat(3));
					dynamic.setDynamic_Time(rs.getString(4));
					dynamic.setDynamic_Market_Price(rs.getFloat(5));
					dynamics.add(dynamic);
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
	        return dynamics;
	    }


public List<Dynamic> findUserByID1(int Greens_ID){//根据编号查询信息
	Dynamic dynamic = new Dynamic();
     List<Dynamic> list = new ArrayList<Dynamic>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Dynamic_table where Greens_ID=? order by Dynamic_ID desc");
		pstmt.setInt(1,Greens_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			dynamic.setDynamic_ID(rs.getInt(1));
			dynamic.setGreens_ID(rs.getInt(2));
			dynamic.setDynamic_Price(rs.getFloat(3));
			dynamic.setDynamic_Time(rs.getString(4));
			dynamic.setDynamic_Market_Price(rs.getFloat(5));
			list.add(dynamic);
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


public List<Dynamic> findUserByIDweek(int Greens_ID){//周查询
	List<Dynamic> list = new ArrayList<Dynamic>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Dynamic_table where DateDiff(week,Dynamic_Time,getdate())=1 and Greens_ID = ?");
		pstmt.setInt(1,Greens_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()) {
			Dynamic dynamic = new Dynamic();
			dynamic.setDynamic_ID(rs.getInt(1));
			dynamic.setGreens_ID(rs.getInt(2));
			dynamic.setDynamic_Price(rs.getFloat(3));
			dynamic.setDynamic_Time(rs.getString(4));
			dynamic.setDynamic_Market_Price(rs.getFloat(5));
			list.add(dynamic);
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

public List<Dynamic> findUserByIDweekone(int Greens_ID){//周查询
	List<Dynamic> list = new ArrayList<Dynamic>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Dynamic_table where Dynamic_Time between dateadd(week,-1,DATEADD(week,DATEDIFF(week,0,getdate()),0)) and dateadd(week,-1,DATEADD(week,DATEDIFF(week,0,getdate()),7)) and Greens_ID = ?");
		pstmt.setInt(1,Greens_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()) {
			Dynamic dynamic = new Dynamic();
			dynamic.setDynamic_ID(rs.getInt(1));
			dynamic.setGreens_ID(rs.getInt(2));
			dynamic.setDynamic_Price(rs.getFloat(3));
			dynamic.setDynamic_Time(rs.getString(4));
			dynamic.setDynamic_Market_Price(rs.getFloat(5));
			list.add(dynamic);
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

public  List<Dynamic> findUserByID5(String a,String b){//根据编号查询信息
	List<Dynamic> indents = new ArrayList<Dynamic>();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Dynamic_table where Dynamic_Time between ? and ?");
		pstmt.setString(1, a);
		pstmt.setString(2, b);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()){
			Dynamic dynamic = new Dynamic();
			dynamic.setDynamic_ID(rs.getInt(1));
			dynamic.setGreens_ID(rs.getInt(2));
			dynamic.setDynamic_Price(rs.getFloat(3));
			dynamic.setDynamic_Time(rs.getString(4));
			dynamic.setDynamic_Market_Price(rs.getFloat(5));
			indents.add(dynamic);
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
    return indents;
}	

public List<Dynamic> findUserByIDmonth(){//周查询
	List<Dynamic> list = new ArrayList<Dynamic>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Dynamic_table where DateDiff(month,Dynamic_Time,getdate())=0");
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()) {
				Dynamic dynamic = new Dynamic();
				dynamic.setDynamic_ID(rs.getInt(1));
				dynamic.setGreens_ID(rs.getInt(2));
				dynamic.setDynamic_Price(rs.getFloat(3));
				dynamic.setDynamic_Time(rs.getString(4));
				dynamic.setDynamic_Market_Price(rs.getFloat(5));
				list.add(dynamic);
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

public boolean findUserByIDday1(){//周查询
	List<Dynamic> list = new ArrayList<Dynamic>();
	boolean a = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Dynamic_table where DateDiff(day,Dynamic_Time,getdate())=0");
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()) {
			a = true;
			Dynamic dynamic = new Dynamic();
			dynamic.setDynamic_ID(rs.getInt(1));
			dynamic.setGreens_ID(rs.getInt(2));
			dynamic.setDynamic_Price(rs.getFloat(3));
			dynamic.setDynamic_Time(rs.getString(4));
			dynamic.setDynamic_Market_Price(rs.getFloat(5));
			list.add(dynamic);
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
}

	 
		        
