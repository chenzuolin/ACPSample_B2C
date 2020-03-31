package com.sec.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Greens_Jobber;
import com.sec.entity.QunTui;
import com.sumeng.page.Page;

public class QunTuiDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	

	public String add(QunTui quntui) throws IOException{//增加部分字段
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			
			String sql = "insert into QunTui_table (Wineshop_UserName,Wineshop_CID) values(?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, quntui.getWineshop_UserName());
			pstmt.setString(2, quntui.getWineshop_CID());
			
			
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
				c = "dasd";
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
	
	
	public List<QunTui> findAll(){//查询全部
		List<QunTui> list = new ArrayList<QunTui>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from QunTui_table");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QunTui quntui = new QunTui();
				quntui.setQunTui_ID(rs.getInt(1));
				quntui.setWineshop_UserName(rs.getString(2));
				quntui.setWineshop_CID(rs.getString(3));
				quntui.setQunTui_Title(rs.getString(4));
				quntui.setQunTui_Text(rs.getString(5));
				quntui.setQunTui_Adress(rs.getString(6));
				list.add(quntui);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public int update(QunTui quntui){//根据CID更新
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update QunTui_table set QunTui_Title=?,QunTui_Text=?,QunTui_Adress=? where Wineshop_CID=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, quntui.getQunTui_Title());
			pstmt.setString(2, quntui.getQunTui_Text());
			pstmt.setString(3, quntui.getQunTui_Adress());
			pstmt.setString(4,quntui.getWineshop_CID());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("操作成功");
				c=1;
				
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！");
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
	
	
	
	public int Select(String Wineshop_CID){//根据Wineshop_CID查询集合的长度
		List<QunTui> list = new ArrayList<QunTui>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from QunTui_table where Wineshop_CID=?");
			pstmt.setString(1,Wineshop_CID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				QunTui quntui = new QunTui();
				quntui.setQunTui_ID(rs.getInt(1));
				quntui.setWineshop_UserName(rs.getString(2));
				quntui.setWineshop_CID(rs.getString(3));
				quntui.setQunTui_Title(rs.getString(4));
				quntui.setQunTui_Text(rs.getString(5));
				quntui.setQunTui_Adress(rs.getString(6));
				
				list.add(quntui);
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
	    return list.size();
	}
	
	
	
	
	public String findUserByID1(String Wineshop_CID){//根据Wineshop_CID查询Wineshop_UserName
		String Wineshop_UserName = null;
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from QunTui_table where Wineshop_CID=?");
			pstmt.setString(1,Wineshop_CID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			if(rs.next()!=false){
				Wineshop_UserName = rs.getString("Wineshop_UserName");
			
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
	    return Wineshop_UserName;
	}
	
	
	
	public String add1(QunTui quntui){//增加全部
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			
			String sql = "insert into QunTui_table (Wineshop_UserName,Wineshop_CID,QunTui_Title,QunTui_Text,QunTui_Adress) values(?,?,?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, quntui.getWineshop_UserName());
			pstmt.setString(2, quntui.getWineshop_CID());
			pstmt.setString(3, quntui.getQunTui_Title());
			pstmt.setString(4, quntui.getQunTui_Text());
			pstmt.setString(5, quntui.getQunTui_Adress());
			
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
				c = "dasd";
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
	
	
	
	public String Select1(String Wineshop_CID){//根据Wineshop_CID查询QunTui_Text检查这个列的长度是否大于1
		String a = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from QunTui_table where Wineshop_CID=?");
			pstmt.setString(1,Wineshop_CID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				QunTui quntui = new QunTui();
				a = rs.getString("QunTui_Text");
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
	
	
	
	public List<QunTui> findUserByID2(String Wineshop_CID){//根据编号查询信息
		List<QunTui> list = new ArrayList<QunTui>();
		QunTui quntui = new QunTui();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from QunTui_table where Wineshop_CID=?");
			pstmt.setString(1,Wineshop_CID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				quntui.setQunTui_ID(rs.getInt(1));
				quntui.setWineshop_UserName(rs.getString(2));
				quntui.setWineshop_CID(rs.getString(3));
				quntui.setQunTui_Title(rs.getString(4));
				quntui.setQunTui_Text(rs.getString(5));
				quntui.setQunTui_Adress(rs.getString(6));
				
				list.add(quntui);
				
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
	
	/**
	*作者：蒙思丞
	*getSum1  分页方法
	*查询出总条数
	*return page
	**/
	
	public Page getSum(int currentPage,int size) {
		// TODO 自动生成的方法存根
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select COUNT(*) from QunTui_table");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				totalNum = rs.getInt(1);
			}
			int totalPage = 0;
			if(totalNum%size==0) {
				totalPage = totalNum/size;
			}else {
				totalPage = totalNum/size+1;
			}
			page.setCount(totalNum);
			page.setTotalPage(totalPage);
			page.setCurrentPage(currentPage);
			page.setCode(0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8，关闭资源
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return page;
	}
	/**
	*作者：蒙思丞
	*getSun1  分页方法
	*根据伪列规定一页的条数
	*封装类：TuiKuan.java
	*return dd
	**/
	
	public Page getSun(int currentPage,Page dd,int size) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<QunTui> list = new ArrayList<QunTui>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by QunTui_ID desc) as rownumber,*from QunTui_table  ) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			rs = pstmt1.executeQuery();
			while(rs.next()) {
				QunTui qt = new QunTui();
				qt.setQunTui_ID(rs.getInt("QunTui_ID"));
				qt.setWineshop_UserName(rs.getString("Wineshop_UserName"));
				qt.setWineshop_CID(rs.getString("Wineshop_CID"));
				list.add(qt);
				dd.setData(list);
				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return dd;
		
	}
	
}
