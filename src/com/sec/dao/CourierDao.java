package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sec.entity.Courier;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;

public class CourierDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public List<Courier> findUserByID3(String Courier_Name){//根据编号查询用户和密码
		List<Courier> list = new ArrayList<Courier>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Courier_table where Courier_Name=?");
			pstmt.setString(1,Courier_Name);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				Courier courier = new Courier();
				courier.setCourier_ID(rs.getInt(1));
				courier.setCourier_Password(rs.getString(2));
				courier.setCourier_Name(rs.getString(3));
				courier.setCourier_Telephone(rs.getString(4));
				courier.setCourier_Time(rs.getString(5));
				courier.setRegionality_ID(rs.getInt(6));
				courier.setCourier_Vehicle(rs.getString(7));
				list.add(courier);
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
	public int C_Number(){//查询表的所有信息
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int num = 0;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select count(*) from Courier_table where 1=1");
			rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getInt(1);
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
	    return num;
	}
	public int AlterPassWord(String userName){//登陆忘记密码验证
			int n = 0 ;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from Courier_table where Courier_Name=?");
				pstmt.setString(1, userName);
				rs = pstmt.executeQuery();
				if(rs.next()){
					n = rs.getInt("Courier_ID");
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
	        return n;
	    }
	public List<Courier> findUserByID4(String Courier_Name){      
		List<Courier> list=new ArrayList<Courier>();
		 
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Courier_table where Courier_Name=?");
			pstmt.setString(1, Courier_Name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Courier courier = new Courier();
				courier.setCourier_ID(rs.getInt(1));
				courier.setCourier_Password(rs.getString(2));
				courier.setCourier_Name(rs.getString(3));
				courier.setCourier_Telephone(rs.getString(4));
				courier.setCourier_Time(rs.getString(5));
				courier.setRegionality_ID(rs.getInt(6));
				courier.setCourier_Vehicle(rs.getString(7));
				list.add(courier);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
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
	public List<Courier> findUserByID1(String Courier_Name){      
		List<Courier> list=new ArrayList<Courier>();
		 
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Courier_table where Courier_Name=?");
			pstmt.setString(1, Courier_Name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Courier courier = new Courier();
				courier.setCourier_ID(rs.getInt(1));
				courier.setCourier_Password(rs.getString(2));
				courier.setCourier_Name(rs.getString(3));
				courier.setCourier_Telephone(rs.getString(4));
				courier.setCourier_Time(rs.getString(5));
				courier.setRegionality_ID(rs.getInt(6));
				courier.setCourier_Vehicle(rs.getString(7));
				courier.setCourier_Photo(rs.getString(8));
				list.add(courier);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
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
	public int add(Courier courier){//增加
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Courier_table (Courier_Password,Courier_Name,Courier_Telephone,Courier_Time,Regionality_ID,Courier_Vehicle) values(?,?,?,?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, courier.getCourier_Password());
			pstmt.setString(2, courier.getCourier_Name());
			pstmt.setString(3, courier.getCourier_Telephone());
			pstmt.setString(4, courier.getCourier_Time());
			pstmt.setInt(5, courier.getRegionality_ID());
			pstmt.setString(6, courier.getCourier_Vehicle());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
				c = 1;
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
	public int  update1(Courier courier){//更新
		int w=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Courier_table set Courier_Password=? where Courier_Name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, courier.getCourier_Password());
			pstmt.setString(2, courier.getCourier_Name());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("操作成功");
				w=1;
			}else {
				System.out.println("操作失败");
			}
			
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
		return w;
	}
	public int  update3(Courier courier){//更新
		int w=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Courier_table set Courier_Photo=? where Courier_Name=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, courier.getCourier_Photo());
			pstmt.setString(2, courier.getCourier_Name());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("操作成功");
				w=1;
			}else {
				System.out.println("操作失败");
			}
			
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
		return w;
	}
	public List<Courier> findUserByID2(int Courier_ID){      
		List<Courier> list=new ArrayList<Courier>();
		 
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Courier_table where Courier_ID=?");
			pstmt.setInt(1, Courier_ID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				Courier courier = new Courier();
				courier.setCourier_ID(rs.getInt(1));
				courier.setCourier_Password(rs.getString(2));
				courier.setCourier_Name(rs.getString(3));
				courier.setCourier_Telephone(rs.getString(4));
				courier.setCourier_Time(rs.getString(5));
				courier.setRegionality_ID(rs.getInt(6));
				courier.setCourier_Vehicle(rs.getString(7));
				list.add(courier);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
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
	public int checkName(String cname){     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int rows = 0;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select count(*) from Courier_table where Courier_Name=?");
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				rows = rs.getInt(1);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
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
	    return rows;
	}

	
public void update(Courier courier){//更新
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Courier_table set Courier_Name=?,Courier_Telephone=?,Courier_Time=?,Regionality_ID=?,Courier_Vehicle=? where Courier_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, courier.getCourier_Name());
			pstmt.setString(2, courier.getCourier_Telephone());
			pstmt.setString(3, courier.getCourier_Time());
			pstmt.setInt(4, courier.getRegionality_ID());
			pstmt.setString(5, courier.getCourier_Vehicle());
			pstmt.setInt(6, courier.getCourier_ID());
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
public Courier findUserByID(int Courier_ID){//根据编号查询用户和密码
	Courier courier = new Courier();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Courier_table where Courier_ID=?");
		pstmt.setInt(1,Courier_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			courier.setCourier_ID(rs.getInt(1));
			courier.setCourier_Name(rs.getString(2));
			courier.setCourier_Telephone(rs.getString(3));
			courier.setCourier_Time(rs.getString(4));
			courier.setRegionality_ID(rs.getInt(5));
			courier.setCourier_Vehicle(rs.getString(6));
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
    return courier;
}

public List<Courier> findAll(){//查询表的所有信息
    List<Courier> couriers = new ArrayList<Courier>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Courier_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Courier courier = new Courier();
			courier.setCourier_ID(rs.getInt(1));
			courier.setCourier_Password(rs.getString(2));
			courier.setCourier_Name(rs.getString(3));
			courier.setCourier_Telephone(rs.getString(4));
			courier.setCourier_Time(rs.getString(5));
			courier.setRegionality_ID(rs.getInt(6));
			courier.setCourier_Vehicle(rs.getString(7));
			couriers.add(courier);
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
    return couriers;
}


public int checkCourier(String userName,String pass){//根据密码和用户查询

int n = 0 ;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Courier_table where Courier_Name=? and Courier_Password=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()){
				n = rs.getInt("Courier_ID");
				
			
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
        return n;
    }
	/**
	 * 通过编号进行删除
	 * @param cid
	 * @return
	 */
	public int delete(int cid){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from Courier_table where Courier_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code > 0 ? 200 : -1;
	}
	/**
	 * 快递员显示
	 * @param currentPage
	 * @param size
	 * @return
	 */
	public Page check(int currentPage,int size){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		Page page = new Page();
		String sqlTotalCount = "select COUNT(1) from Courier_table";
		String sqlData = "select top "+size+" * from (select row_number() "
				+ "over(order by Courier_ID asc) as"
				+ " rownumber,* from Courier_table"
				+ ")temp_row where rownumber>(("+currentPage+"-1)*"+size+")";
		Object count = null;
		List<Courier> list = null;
		try {
			count = qr.query(sqlTotalCount,new ScalarHandler());
			list = qr.query(sqlData, new BeanListHandler<Courier>(Courier.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String total = count.toString();
		int totalNum = Integer.parseInt(total);
		int totalPage = 0;
		if(totalNum%size==0){
			totalPage = totalNum/size;
		}else{
			totalPage = totalNum/size+1;
		}
		page.setCount(totalNum);
		page.setCurrentPage(currentPage);
		page.setTotalPage(totalPage);
		page.setData(list);
		return page;
	}
	/**
	 * 根据编号进行修改
	 * @param con
	 * @return
	 */
	public int updateById(Courier con){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update Courier_table set Courier_Name=?, Courier_Password=?, Courier_Telephone=?, "
				+ "Courier_Time=?, Courier_Vehicle=? where Courier_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,con.getCourier_Name(),con.getCourier_Password(),con.getCourier_Telephone(),con.getCourier_Time(),con.getCourier_Vehicle(),con.getCourier_ID());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return code > 0 ? 200 : -1;
	}
}
