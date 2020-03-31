package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.sec.entity.Cart;
import com.sec.entity.Total;
import com.sec.util.C3p0Utils;

public class TotalDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(Total total) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Total_table(Indent_ID,total,Fare,Greens,total_QY) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, total.getIndent_ID());
			pstmt.setFloat(2, total.getTotal());
			pstmt.setFloat(3, total.getFare());
			pstmt.setFloat(4, total.getGreens());
			pstmt.setString(5, total.getTotal_QY());
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
	public List<Total> findAll(){//查询表的所有信息
        List<Total> list2 = new ArrayList<Total>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Total_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Total total = new Total();
				total.setTotal_ID(rs.getInt(1));
				total.setIndent_ID(rs.getInt(2));
				total.setTotal(rs.getFloat(3));
				total.setFare(rs.getFloat(4));
				total.setGreens(rs.getFloat(5));
				list2.add(total);
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
	
	public List<Total> findAllcaiwu(){//查询当月财务报表
        List<Total> list2 = new ArrayList<Total>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select sum(Total_table.total),sum(Total_table.Greens),sum(Total_table.Fare) from Indent_table inner join Total_table on Indent_table.Indent_ID = Total_table.Indent_ID where DateDiff(MONTH,Indent_Time,getdate())=0 and Indent_Status != '正在支付'");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Total total = new Total();
				total.setTotal(rs.getFloat(1));
				total.setFare(rs.getFloat(3));
				total.setGreens(rs.getFloat(2));
				list2.add(total);
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

	public int delete(int Total_ID){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Total_table where Total_ID=?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Total_ID);
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

	public List<Total> findUserByID(int Total_ID){//根据编号查询信息
		List<Total> list1 = new ArrayList<Total>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Total_table where Total_ID=?");
			pstmt.setInt(1,Total_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				Total total = new Total();
				total.setTotal_ID(rs.getInt(1));
				total.setIndent_ID(rs.getInt(2));
				total.setTotal(rs.getFloat(3));
				total.setFare(rs.getFloat(4));
				total.setGreens(rs.getFloat(5));
				list1.add(total);
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
	
	public int ll(String Indent_QY,String Time1,String Time2){//根据编号查询信息
		List<Total> list1 = new ArrayList<Total>();
	    int aa = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select sum(Total) from Total_table where Indent_ID in ( select Indent_ID from Indent_table where Indent_Status != '正在支付' and Indent_QY = ? and Indent_Time between ? and ?)");
			pstmt.setString(1,Indent_QY);
			pstmt.setString(2,Time1);
			pstmt.setString(3,Time2);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				aa = rs.getInt(1);
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
	    return aa;
	}
	
	public List<Total> findUserByID1(int Indent_ID){//根据编号查询信息
		List<Total> list1 = new ArrayList<Total>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Total_table where Indent_ID=?");
			pstmt.setInt(1,Indent_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				Total total = new Total();
				total.setTotal_ID(rs.getInt(1));
				total.setIndent_ID(rs.getInt(2));
				total.setTotal(rs.getFloat(3));
				total.setFare(rs.getFloat(4));
				total.setGreens(rs.getFloat(5));
				list1.add(total);
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
	/**
	 * 根据订单编号进行删除
	 * @param indentById
	 * @return
	 */
	public int delIndentById(int indentById){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from Total_table where Indent_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,indentById);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code >0 ? 200 : -1;
		
	}
	
	
}
