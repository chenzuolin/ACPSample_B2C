package com.sec.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Indent;
import com.sec.entity.Page;
import com.sec.entity.Wineshop;
import com.sec.util.ImageUtil;
import com.sec.util.ORMTest;
import com.sumeng.page.fenye;

public class WineshopDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public static final int NUM_PER_PAGE = 10;
	public Wineshop getOneById(Integer wId){
		if(wId==null){
			return new Wineshop();
		}
		String sql = "select * from Wineshop_table where Wineshop_ID="+wId;
		List<Object> list = new ArrayList<>();
		try {
			list = ORMTest.getObjects(sql,Wineshop.class);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(list.size()>0){
			return (Wineshop) list.get(0);	
		}else{
			return new Wineshop();
		}
		
	}
	public void updateAll(Wineshop wineshop) throws IOException{//更新
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Wineshop_table set Wineshop_UserName=?,Wineshop_Password=?,Wineshop_Name=?,Wineshop_Shift_Name=?,Wineshop_Telephone=?,Wineshop_Nature=?,Wineshop_QQ=?,Wineshop_WeChat=?,Wineshop_Number=?,Wineshop_Time=?,Wineshop_TimeNight=?,Wineshop_TuiJian=?,Wineshop_Address=? where Wineshop_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,wineshop.getWineshop_UserName());
			pstmt.setString(2, wineshop.getWineshop_Password());
			pstmt.setString(3, wineshop.getWineshop_Name());
			pstmt.setString(4, wineshop.getWineshop_Shift_Name());
			pstmt.setString(5, wineshop.getWineshop_Telephone());
			pstmt.setString(6, wineshop.getWineshop_Nature());
			pstmt.setString(7, wineshop.getWineshop_QQ());
			pstmt.setString(8, wineshop.getWineshop_WeChat());
			pstmt.setString(9, wineshop.getWineshop_Number());
			pstmt.setString(10, wineshop.getWineshop_Time());
			pstmt.setString(11, wineshop.getWineshop_TimeNight());
			pstmt.setString(12, wineshop.getWineshop_TuiJian());
			pstmt.setString(13, wineshop.getWineshop_addr());
			pstmt.setInt(14, wineshop.getWineshop_ID());
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
	
	public String add(Wineshop wineshop) throws IOException{//增加
		String c= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			
			String sql = "insert into Wineshop_table (Wineshop_UserName,Wineshop_Password,Role_ID,Wineshop_Name,Regionality_ID,Wineshop_Aptitude,Wineshop_Condition,Wineshop_Address,Wineshop_Shift_Name,Wineshop_Telephone,Wineshop_Class,Wineshop_Nature,Wineshop_QQ,Wineshop_WeChat,Wineshop_Number,Wineshop_Time,Wineshop_TimeNight,Wineshop_TuiJian,Wineshop_Date,Wineshop_QY) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wineshop.getWineshop_UserName());
			pstmt.setString(2, wineshop.getWineshop_Password());
			pstmt.setInt(3, wineshop.getRole_ID());
			pstmt.setString(4, wineshop.getWineshop_Name());
			pstmt.setInt(5, wineshop.getRegionality_ID());
			pstmt.setString(6, wineshop.getWineshop_Aptitude());	
			pstmt.setInt(7, wineshop.getWineshop_Condition());
			pstmt.setString(8, wineshop.getWineshop_Address());
			pstmt.setString(9, wineshop.getWineshop_Shift_Name());
			pstmt.setString(10, wineshop.getWineshop_Telephone());
			pstmt.setInt(11, wineshop.getWineshop_Class());
			pstmt.setString(12, wineshop.getWineshop_Nature());
			pstmt.setString(13, wineshop.getWineshop_QQ());
			pstmt.setString(14, wineshop.getWineshop_WeChat());
			pstmt.setString(15, wineshop.getWineshop_Number());
			pstmt.setString(16, wineshop.getWineshop_Time());
			pstmt.setString(17, wineshop.getWineshop_TimeNight());
			pstmt.setString(18, wineshop.getWineshop_TuiJian());
			pstmt.setString(19, wineshop.getWineshop_Date());
			pstmt.setString(20, wineshop.getWineshop_QY());
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
	public int updateTime(Wineshop wineshop){//更新
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Wineshop_table set Wineshop_Time=?,Wineshop_TimeNight=? where Wineshop_UserName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wineshop.getWineshop_Time());
			pstmt.setString(2, wineshop.getWineshop_TimeNight());
			pstmt.setString(3, wineshop.getWineshop_Name());
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
	public int updataITstart(Wineshop wineshop){
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Wineshop_table set Wineshop_Aptitude=?,Wineshop_Shift_Name=?,Wineshop_QQ=?,Wineshop_WeChat=?,Wineshop_danwei_name=?,Wineshop_faren=?,Wineshop_addr=?,Wineshop_wtype=? where Wineshop_UserName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wineshop.getWineshop_Aptitude());
			pstmt.setString(2, wineshop.getWineshop_Shift_Name());
			pstmt.setString(3, wineshop.getWineshop_QQ());
			pstmt.setString(4, wineshop.getWineshop_WeChat());
			pstmt.setString(5, wineshop.getWineshop_danwei_name());
			pstmt.setString(6, wineshop.getWineshop_faren());
			pstmt.setString(7, wineshop.getWineshop_addr());
			pstmt.setString(8, wineshop.getWineshop_wtype());
			pstmt.setString(9, wineshop.getWineshop_UserName());
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
public void update88(Wineshop wineshop) throws IOException{//更新
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		//InputStream in=ImageUtil.getImageByte(wineshop.getWineshop_Aptitude());
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Wineshop_table set Wineshop_Shift_Name=?,Wineshop_QQ=?,Wineshop_WeChat=?,Wineshop_Number=? where Wineshop_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wineshop.getWineshop_Shift_Name());
			//pstmt.setString(2, wineshop.getWineshop_Nature());
			pstmt.setString(2, wineshop.getWineshop_QQ());
			pstmt.setString(3, wineshop.getWineshop_WeChat());
			pstmt.setString(4, wineshop.getWineshop_Number());
			//pstmt.setString(6, wineshop.getWineshop_Time());
			//pstmt.setString(7, wineshop.getWineshop_TimeNight());
			pstmt.setInt(5, wineshop.getWineshop_ID());
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
	public List<Wineshop> Select(String Wineshop_UserName){//根据编号查询信息
		List<Wineshop> list = new ArrayList<Wineshop>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_UserName=?");
			pstmt.setString(1,Wineshop_UserName);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				Wineshop wineshop = new Wineshop();
				wineshop.setWineshop_ID(rs.getInt(1));
				wineshop.setWineshop_UserName(rs.getString(2));
				wineshop.setWineshop_Password(rs.getString(3));
				wineshop.setRole_ID(rs.getInt(4));
				wineshop.setWineshop_Name(rs.getString(5));
				wineshop.setRegionality_ID(rs.getInt(6));
				wineshop.setWineshop_Aptitude(rs.getString(7));
				wineshop.setWineshop_Condition(rs.getInt(8));
				wineshop.setWineshop_Address(rs.getString(9));
				wineshop.setWineshop_Shift_Name(rs.getString(10));
				wineshop.setWineshop_Telephone(rs.getString(11));
				wineshop.setWineshop_Class(rs.getInt(12));
				wineshop.setWineshop_Nature(rs.getString(13));
				wineshop.setWineshop_QQ(rs.getString(14));
				wineshop.setWineshop_WeChat(rs.getString(15));
				wineshop.setWineshop_Number(rs.getString(16));
				list.add(wineshop);
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
	
	public int W_Number(){
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int num = 0;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select count(*) from Wineshop_table where 1=1");
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
	public List<Wineshop> findUserByID5(String Wineshop_UserName){//根据编号查询信息
		List<Wineshop> list1 = new ArrayList<Wineshop>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_UserName=?");
			pstmt.setString(1,Wineshop_UserName);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()!=false){
				Wineshop wineshop = new Wineshop();
				wineshop.setWineshop_ID(rs.getInt(1));
				wineshop.setWineshop_UserName(rs.getString(2));
				wineshop.setWineshop_Password(rs.getString(3));
				wineshop.setRole_ID(rs.getInt(4));
				wineshop.setWineshop_Name(rs.getString(5));
				wineshop.setRegionality_ID(rs.getInt(6));
				wineshop.setWineshop_Aptitude(rs.getString(7));
				wineshop.setWineshop_Condition(rs.getInt(8));
				wineshop.setWineshop_Address(rs.getString(9));
				wineshop.setWineshop_Shift_Name(rs.getString(10));
				wineshop.setWineshop_Telephone(rs.getString(11));
				wineshop.setWineshop_Class(rs.getInt(12));
				wineshop.setWineshop_Nature(rs.getString(13));
				wineshop.setWineshop_QQ(rs.getString(14));
				wineshop.setWineshop_WeChat(rs.getString(15));
				wineshop.setWineshop_Number(rs.getString(16));
				wineshop.setWineshop_Time(rs.getString(17));
				wineshop.setWineshop_TimeNight(rs.getString(18));
				list1.add(wineshop);
			
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
	public int update5(Wineshop wineshop){//更新
		int c = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Wineshop_table set Wineshop_Password=? where Wineshop_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wineshop.getWineshop_Password());
			pstmt.setInt(2, wineshop.getWineshop_ID());
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

public void update(Wineshop wineshop) throws IOException{//更新
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		InputStream in=ImageUtil.getImageByte(wineshop.getWineshop_Aptitude());
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Wineshop_table set Wineshop_UserName=?,Wineshop_Password=?,Role_ID=?,Wineshop_Name=?,Regionality_ID=?,Wineshop_Aptitude=?,Wineshop_Condition=?,Wineshop_Address=?,Wineshop_Shift_Name=?,Wineshop_Telephone=?,Wineshop_Class=?,Wineshop_Nature=?,Wineshop_QQ=?,Wineshop_WeChat=?,Wineshop_Number where Wineshop_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wineshop.getWineshop_UserName());
			pstmt.setString(2, wineshop.getWineshop_Password());
			pstmt.setInt(3, wineshop.getRole_ID());
			pstmt.setString(4, wineshop.getWineshop_Name());
			pstmt.setInt(5, wineshop.getRegionality_ID());
			pstmt.setBinaryStream(6, in,in.available());		
			pstmt.setInt(7, wineshop.getWineshop_Condition());
			pstmt.setString(8, wineshop.getWineshop_Address());
			pstmt.setString(9, wineshop.getWineshop_Shift_Name());
			pstmt.setString(10, wineshop.getWineshop_Telephone());
			pstmt.setInt(11, wineshop.getWineshop_Class());
			pstmt.setString(12, wineshop.getWineshop_Nature());
			pstmt.setString(13, wineshop.getWineshop_QQ());
			pstmt.setString(14, wineshop.getWineshop_WeChat());
			pstmt.setString(15, wineshop.getWineshop_Number());
			pstmt.setInt(16, wineshop.getWineshop_ID());
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
public void update2(Wineshop wineshop){//更新
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Wineshop_table set Wineshop_Address=?,Wineshop_Nature=? where Wineshop_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, wineshop.getWineshop_Address());
		pstmt.setString(2, wineshop.getWineshop_Nature());
		pstmt.setInt(3, wineshop.getWineshop_ID());
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

public Wineshop delete(int Wineshop_ID){//删除
	Wineshop wineshop = new Wineshop();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "delete * from Wineshop_table where Wineshop_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wineshop.getWineshop_ID());
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
		return wineshop;
	}

public List<Wineshop> findUserByID(int Wineshop_ID){//根据编号查询信息
	List<Wineshop> list1 = new ArrayList<Wineshop>();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_ID=?");
		pstmt.setInt(1,Wineshop_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			Wineshop wineshop = new Wineshop();
			wineshop.setWineshop_UserName(rs.getString(2));
			wineshop.setWineshop_Password(rs.getString(3));
			wineshop.setRole_ID(rs.getInt(4));
			wineshop.setWineshop_Name(rs.getString(5));
			wineshop.setRegionality_ID(rs.getInt(6));
			wineshop.setWineshop_Aptitude(rs.getString(7));
			wineshop.setWineshop_Condition(rs.getInt(8));
			wineshop.setWineshop_Address(rs.getString(9));
			wineshop.setWineshop_Shift_Name(rs.getString(10));
			wineshop.setWineshop_Telephone(rs.getString(11));
			wineshop.setWineshop_Class(rs.getInt(12));
			wineshop.setWineshop_Nature(rs.getString(13));
			wineshop.setWineshop_QQ(rs.getString(14));
			wineshop.setWineshop_WeChat(rs.getString(15));
			wineshop.setWineshop_Number(rs.getString(16));
			wineshop.setWineshop_Time(rs.getString("Wineshop_Time"));
			wineshop.setWineshop_TimeNight(rs.getString("Wineshop_TimeNight"));
			wineshop.setWineshop_QY(rs.getString("Wineshop_QY"));
			list1.add(wineshop);
		
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
public void update1(Wineshop wineshop){//更新
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Wineshop_table set Wineshop_Password=? where Wineshop_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, wineshop.getWineshop_Password());
		
		pstmt.setInt(2, wineshop.getWineshop_ID());
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


public String findWineshop_UserName(String Wineshop_UserName){
	Wineshop wineshop=new Wineshop();
	 Connection conn = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     try{
     	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt=conn.prepareStatement("select * Wineshop_table where Wineshop_UserName=?");
			pstmt.setString(1, Wineshop_UserName);
			rs=pstmt.executeQuery();
			while(rs.next()){
				wineshop.setWineshop_UserName(rs.getString("Wineshop_UserName"));
				wineshop.setWineshop_Password(rs.getString("Wineshop_Password"));
				wineshop.setRole_ID(rs.getInt("Role_ID"));
				wineshop.setWineshop_Name(rs.getString("Wineshop_Name"));
				wineshop.setRegionality_ID(rs.getInt("Regionality_ID"));
				wineshop.setWineshop_Aptitude(rs.getString("Wineshop_Aptitude"));
				wineshop.setWineshop_Condition(rs.getInt("Wineshop_Condition"));
				wineshop.setWineshop_Address(rs.getString("Wineshop_Address"));
				wineshop.setWineshop_Shift_Name(rs.getString("Wineshop_Shift_Name"));
				wineshop.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				wineshop.setWineshop_Class(rs.getInt("Wineshop_Class"));
				wineshop.setWineshop_Nature(rs.getString("Wineshop_Nature"));
				wineshop.setWineshop_QQ(rs.getString("Wineshop_QQ"));
				wineshop.setWineshop_WeChat(rs.getString("Wineshop_WeChat"));
				wineshop.setWineshop_Number(rs.getString("Wineshop_Number"));
				
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
return wineshop.getWineshop_QQ();
}
public int checkWineshop(String userName,String pass){//根据密码和用户查询

int id = 0 ;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_UserName=? and Wineshop_Password=? and Logout=0 ");
			pstmt.setString(1, userName);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()){
				id = rs.getInt("Wineshop_ID");
				
			
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
        return id;
    }
public void add1(Wineshop wineshop) throws IOException{//增加
	Connection conn = null;
	PreparedStatement pstmt = null;
	InputStream in=ImageUtil.getImageByte(wineshop.getWineshop_Aptitude());
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
		conn = DriverManager.getConnection(url,username,pwd);//连接
		String sql = "insert into Wineshop_table (Wineshop_UserName,Wineshop_Password,Role_ID,Wineshop_Name,Regionality_ID,Wineshop_Aptitude,Wineshop_Condition,Wineshop_Address,Wineshop_Shift_Name,Wineshop_Telephone,Wineshop_Class,Wineshop_Nature,Wineshop_QQ,Wineshop_WeChat,Wineshop_Number) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//SQL语句
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, wineshop.getWineshop_UserName());
		pstmt.setString(2, wineshop.getWineshop_Password());
		pstmt.setInt(3, wineshop.getRole_ID());
		pstmt.setString(4, wineshop.getWineshop_Name());
		pstmt.setInt(5, wineshop.getRegionality_ID());
		pstmt.setBinaryStream(6, in,in.available());		
		//pstmt.setString(6, wineshop.getWineshop_Aptitude());
		pstmt.setInt(7, wineshop.getWineshop_Condition());
		pstmt.setString(8, wineshop.getWineshop_Address());
		pstmt.setString(9, wineshop.getWineshop_Shift_Name());
		pstmt.setString(10, wineshop.getWineshop_Telephone());
		pstmt.setInt(11, wineshop.getWineshop_Class());
		pstmt.setString(12, wineshop.getWineshop_Nature());
		pstmt.setString(13, wineshop.getWineshop_QQ());
		pstmt.setString(14, wineshop.getWineshop_WeChat());
		pstmt.setString(15, wineshop.getWineshop_Number());
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

public String findUserByID1(int Wineshop_ID){//根据编号查询信息
	String name = null;
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_ID=?");
		pstmt.setInt(1,Wineshop_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			Wineshop wineshop = new Wineshop();
			name = rs.getString(2);
		
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
    return name;
}

public String findUserByID111(int Wineshop_ID){//根据编号查询信息
	String name = null;
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_ID=?");
		pstmt.setInt(1,Wineshop_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			Wineshop wineshop = new Wineshop();
			name = rs.getString(5);
		
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
    return name;
}
public List<Wineshop> findAll1(){
    List<Wineshop> wineshops = new ArrayList<Wineshop>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Wineshop_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Wineshop wineshop = new Wineshop();
			wineshop.setWineshop_ID(rs.getInt(1));
			wineshop.setWineshop_UserName(rs.getString(2));
			wineshop.setWineshop_Password(rs.getString(3));
			wineshop.setRole_ID(rs.getInt(4));
			wineshop.setWineshop_Name(rs.getString(5));
			wineshop.setRegionality_ID(rs.getInt(6));
			wineshop.setWineshop_Aptitude(rs.getString(7));
			wineshop.setWineshop_Condition(rs.getInt(8));
			wineshop.setWineshop_Address(rs.getString(9));
			wineshop.setWineshop_Shift_Name(rs.getString(10));
			wineshop.setWineshop_Telephone(rs.getString(11));
			wineshop.setWineshop_Class(rs.getInt(12));
			wineshop.setWineshop_Nature(rs.getString(13));
			wineshop.setWineshop_QQ(rs.getString(14));
			wineshop.setWineshop_WeChat(rs.getString(15));
			wineshop.setWineshop_Number(rs.getString(16));
			wineshops.add(wineshop);
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
    return wineshops;
}

public int findUserByID3(String Wineshop_Name){//根据编号查询信息
	int a = 0;
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_Name = ?");
		pstmt.setString(1, Wineshop_Name);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
	while(rs.next()) {
			a = rs.getInt(1);
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

public int findUserByID2(String Wineshop_Name){//根据编号查询信息
	int a = 0;
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_UserName=?");
		pstmt.setString(1, Wineshop_Name);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
	while(rs.next()) {
			a = rs.getInt(1);
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
public int update6(Wineshop wineshop){//更新
	int c = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Wineshop_table set Wineshop_Address=?,Wineshop_Shift_Name=?,Wineshop_Telephone=?  where Wineshop_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, wineshop.getWineshop_Address());
		pstmt.setString(2, wineshop.getWineshop_Shift_Name());
		pstmt.setString(3, wineshop.getWineshop_Telephone());
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
public Page getSum(int currentPage) {
	// TODO 自动生成的方法存根
	Page page = new Page();
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	int totalNum = 0;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url, username, pwd);
		pstmt1 = conn.prepareStatement("select count(*) from Wineshop_table");
		rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
		while (rs.next()) {
			totalNum = rs.getInt(1);
		}
		int totalPage = 0;
		if(totalNum%NUM_PER_PAGE==0) {
			totalPage = totalNum/NUM_PER_PAGE;
		}else {
			totalPage = totalNum/NUM_PER_PAGE+1;
		}
		page.setTotalPage(totalPage);
		page.setCurrentPage(currentPage);
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
public Page getSun(int currentPage,Page dd) {
	// TODO 自动生成的方法存根
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	List<Wineshop> list = new ArrayList<Wineshop>();
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url, username, pwd);
		pstmt1 = conn.prepareStatement("select top "+NUM_PER_PAGE+" * from (select row_number() over(order by Wineshop_ID desc) as rownumber,* from Wineshop_table) temp_row where rownumber>(("+currentPage+"-1)*"+NUM_PER_PAGE+");");
		rs = pstmt1.executeQuery();
		while (rs.next()) {
			Wineshop ww = new Wineshop();
			ww.setWineshop_ID(rs.getInt("Wineshop_ID"));
			ww.setWineshop_UserName(rs.getString("Wineshop_UserName"));
			ww.setWineshop_Name(rs.getString("Wineshop_Name"));
			ww.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
			ww.setWineshop_Address(rs.getString("Wineshop_Address"));
			ww.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
			list.add(ww);
			dd.setList(list);
		}
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
	return dd;
}
public int checkName(String Wineshop_UserName){
	 Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int rows = 0;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt=conn.prepareStatement("select count(*) from Wineshop_table where Wineshop_UserName=?");
			pstmt.setString(1, Wineshop_UserName);
			rs=pstmt.executeQuery();
			while(rs.next()){
				rows = rs.getInt(1);
				
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
return rows;
}
public int checkNumber(String Wineshop_Telphone){
	 Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   int rows = 0;
   try{
   	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt=conn.prepareStatement("select count(*) from Wineshop_table where Wineshop_Telephone=?");
			pstmt.setString(1, Wineshop_Telphone);
			rs=pstmt.executeQuery();
			while(rs.next()){
				rows = rs.getInt(1);
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
return rows;
}



public String findUserByID8(String Wineshop_UserName){//根据用户登录名查询酒店名
     String name = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select Wineshop_Name from Wineshop_table where Wineshop_UserName=?");
		pstmt.setString(1,Wineshop_UserName);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			 name = rs.getString("Wineshop_Name");
		
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
    return name;
}















public int findUserByID100(String Wineshop_Name){//根据酒店名称查询酒店编号
	int id = 0;
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_Name=?");
		pstmt.setString(1,Wineshop_Name);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			Wineshop wineshop = new Wineshop();
			id = rs.getInt("Wineshop_ID");
		
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
    return id;
}

/**
 *author 呆萌的欧尼酱
 * @param currentPage
 * @param size
 * @return
 * 分配酒店收货员分页方法
 */
/**
 * @param currentPage
 * @param size
 * @return
 */
public fenye getSum2(int currentPage,int size) {
	fenye fy = new fenye();
	
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	int totalNum = 0;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url, username, pwd);
		pstmt1 = conn.prepareStatement("select COUNT(*) from Wineshop_table");
		rs = pstmt1.executeQuery();
		while(rs.next()) {
			totalNum = rs.getInt(1);
		}
		int totalPage = 0;
		if(totalNum%size==0) {
			totalPage = totalNum/size;
		}else {
			totalPage = totalNum/size+1;
		}
		fy.setCount(totalNum);
		fy.setTotalPage(totalPage);
		fy.setCurrentPage(currentPage);
		fy.setCode(0);
		
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
	return fy;
}
public fenye getSun2(int currentPage,fenye dd,int size) {
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	List<Wineshop> list = new ArrayList<Wineshop>();
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Wineshop_ID desc) as rownumber,* from Wineshop_table) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
		rs = pstmt1.executeQuery();
		while(rs.next()) {  
			Wineshop ww = new Wineshop();
			ww.setWineshop_ID(rs.getInt("Wineshop_ID"));
			ww.setWineshop_UserName(rs.getString("Wineshop_UserName"));
			ww.setWineshop_Name(rs.getString("Wineshop_Name"));
			ww.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
			ww.setWineshop_Address(rs.getString("Wineshop_Address"));
			ww.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
			list.add(ww);
			dd.setData(list);
			
		}
	} catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	return dd;
	
}
public fenye getSun3(int currentPage,fenye dd,int size,int Wineshop_ID) {
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	List<Wineshop> list = new ArrayList<Wineshop>();
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Wineshop_ID desc) as rownumber,* from Wineshop_table where Wineshop_ID=?) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
		pstmt1.setInt(1, Wineshop_ID);
		rs = pstmt1.executeQuery();
		
		while(rs.next()) {  
			Wineshop ww = new Wineshop();
			ww.setWineshop_ID(rs.getInt("Wineshop_ID"));
			ww.setWineshop_UserName(rs.getString("Wineshop_UserName"));
			ww.setWineshop_Name(rs.getString("Wineshop_Name"));
			ww.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
			ww.setWineshop_Address(rs.getString("Wineshop_Address"));
			ww.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
			list.add(ww);
			dd.setData(list);
			
		}
	} catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	return dd;
	
}



public int findUserByID200(String Wineshop_Name){//根据编号查询信息
	int a = 0;
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Wineshop_table");
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
	while(rs.next()) {
		String aa = rs.getString(2);
		if(aa.contains(Wineshop_Name)) {
			Wineshop wineshop = new Wineshop();
			a = rs.getInt(1);
		}
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



public List<String> findUserByID8(){//根据编号查询信息
	String t = null;
	List<String> list = new ArrayList<String>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select Wineshop_table.Wineshop_Telephone from Wineshop_table where Wineshop_Date between '2019-06-27' and '2019-07-05'");
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()){
			
			
			t = rs.getString("Wineshop_Telephone");
			list.add(t);
		
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
public Float findTotal(Integer Id){//根据编号查询信息
	float a = 0;
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select SUM(t.total) from Wineshop_table w join Indent_table i on w.Wineshop_ID=i.Wineshop_ID join Total_table t on i.Indent_ID = t.Indent_ID where i.Indent_Status!='正在支付' and w.Wineshop_ID=?");
		pstmt.setInt(1, Id);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
	while(rs.next()) {
			a = rs.getInt(1);
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