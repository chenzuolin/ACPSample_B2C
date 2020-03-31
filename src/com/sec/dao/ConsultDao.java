package com.sec.dao;

import java.io.IOException;
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

import com.sec.entity.Consult;
import com.sec.entity.Indent;
import com.sec.entity.Wineshop;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;
import com.sumeng.service.Message;

/**
 * 速盟快线通知方法
 * @author 陈作麟
 * @time 10/18
 *
 */
public class ConsultDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public String add(Consult consult) throws IOException{
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			
			String sql = "insert into Consult_table (User_ID,Content,Consult_Time) values(?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, consult.getUser_ID());
			pstmt.setString(2, consult.getContent());
			pstmt.setString(3, consult.getConsult_Time());
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
	public List<Consult> findUserByID99(int User_ID){//根据编号查询信息
		List<Consult> list1 = new ArrayList<Consult>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Consult_table where User_ID=?");
			pstmt.setInt(1,User_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				Consult consult = new Consult();
				consult.setConsult_ID(rs.getInt(1));
				consult.setUser_ID(rs.getInt(2));
				consult.setContent(rs.getString(3));
				consult.setConsult_Time(rs.getString(4));
				list1.add(consult);
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
	public List<Consult> findUserByID(int Consult_ID){//根据编号查询信息
		List<Consult> list1 = new ArrayList<Consult>();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Consult_table where Consult_ID=?");
			pstmt.setInt(1,Consult_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				Consult consult = new Consult();
				consult.setConsult_ID(rs.getInt(1));
				consult.setUser_ID(rs.getInt(2));
				consult.setContent(rs.getString(3));
				consult.setConsult_Time(rs.getString(4));
				list1.add(consult);
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
	public int delete(int Consult_ID){//删除

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Consult_table where Consult_ID=?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Consult_ID);
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
	public List<Consult> findAll1(){
	    List<Consult> consult = new ArrayList<Consult>();
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Consult_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Consult cc = new Consult();
				cc.setConsult_ID(rs.getInt(1));
				cc.setUser_ID(rs.getInt(2));
				cc.setContent(rs.getString(3));
				cc.setConsult_Time(rs.getString(4));
				consult.add(cc);
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
	    return consult;
	}
	public int C_Number(){
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int num = 0;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select count(*) from Consult_table where 1=1");
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
	/**
	 * 速盟公告
	 * @param currentPage
	 * @param size
	 * @return
	 */
	public Page check(int currentPage,int size){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		Page page = new Page();
		String sqlTotalCount = "select COUNT(1) from Consult_table c join User_table u on c.User_ID=u.User_ID";
		String sqlData = "select top "+size+" * from (select row_number() "
				+ "over(order by Consult_ID asc) as"
				+ " rownumber,c.Consult_ID,c.Consult_Time,c.Content,u.User_Name from Consult_table c "
				+ "join User_table u on c.User_ID=u.User_ID"
				+ ")temp_row where rownumber>(("+currentPage+"-1)*"+size+")";
		Object count = null;
		List<Message> list = null;
		try {
			count = qr.query(sqlTotalCount,new ScalarHandler());
			list = qr.query(sqlData, new BeanListHandler<Message>(Message.class));
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
	public int updateById(Consult conn){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update Consult_table set Content=?, Consult_Time=?, User_ID=? where Consult_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,conn.getContent(),conn.getConsult_Time(),conn.getUser_ID(),conn.getConsult_ID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code > 0? 200 : -1;
	}
}
