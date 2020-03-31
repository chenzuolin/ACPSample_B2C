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

import com.sec.entity.Greens_Norms;
import com.sec.entity.Greens_Type;
import com.sec.entity.TypeBigName;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;

public class Greens_TypeDao{
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Greens_Type greens_Type) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Greens_Type_table(Greens_Type_Name,bigTypeName) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, greens_Type.getGreens_Type_Name());
			pstmt.setString(2, greens_Type.getGreens_BigTypeName());
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
public Greens_Type findUserByID(int Greens_Type_ID){//根据编号查询信息
	Greens_Type greens_Type = new Greens_Type();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_Type_table where Greens_Type_ID=?");
		pstmt.setInt(1,Greens_Type_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			greens_Type.setGreens_Type_ID(rs.getInt(1));
			greens_Type.setGreens_Type_Name(rs.getString(2));
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
    return greens_Type;
}	


public void update(Greens_Type greens_Type){//更新
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Greens_Type_table set Green_Type_Name=? where Greens_Type_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, greens_Type.getGreens_Type_Name());
		pstmt.setInt(2, greens_Type.getGreens_Type_ID());
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


public int delete(int Greens_Type_ID){//删除
	int a= 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete  from Greens_Type_table where Greens_Type_ID=?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Greens_Type_ID);
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


public List<Greens_Type> findAll(){//查询表的所有信息
    List<Greens_Type> greens_Types = new ArrayList<Greens_Type>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_Type_table order by LEN(Greens_Type_Name) asc");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Greens_Type greens_Type=new Greens_Type();
			greens_Type.setGreens_Type_ID(rs.getInt(1));
			greens_Type.setGreens_Type_Name(rs.getString(2));
			greens_Type.setGreens_BigTypeName(rs.getString(3));
			greens_Types.add(greens_Type);
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
    return greens_Types;
}

public List<Greens_Type> findleixin(String Class_Name){//查询表的所有信息
    List<Greens_Type> greens_Types = new ArrayList<Greens_Type>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_Type_table where Class_Name=?");
		pstmt.setString(1,Class_Name);
		rs = pstmt.executeQuery();
		while(rs.next()){
			Greens_Type greens_Type=new Greens_Type();
			greens_Type.setGreens_Type_ID(rs.getInt(1));
			greens_Type.setGreens_Type_Name(rs.getString(2));
			greens_Types.add(greens_Type);
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
    return greens_Types;
}
/**
 * 蔬菜类型进行分页显示
 * @param currentPage
 * @param size
 * @return
 */
public Page checkGreensType(int currentPage,int size){
	QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
	Page page = new Page();
	String sqlTotalCount = "select COUNT(1) from Greens_Type_table";
	String sqlData = "select top "+size+" * from (select row_number() "
			+ "over(order by Greens_Type_ID asc) as"
			+ " rownumber,* from Greens_Type_table)temp_row where rownumber>(("+currentPage+"-1)*"+size+")";
	Object count = null;
	List<TypeBigName> list = null;
	try {
		count = qr.query(sqlTotalCount,new ScalarHandler());
		list = qr.query(sqlData, new BeanListHandler<TypeBigName>(TypeBigName.class));
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
 * 蔬菜分类更新方法
 * @param greens
 * @return
 */
public int updateGreensType(Greens_Type greens){
	QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
	String sql = "update Greens_Type_table set Greens_Type_Name=? , bigTypeName=? where Greens_Type_ID=?";
	int rows = 0;
	try {
		rows = qr.update(sql, greens.getGreens_Type_Name(),greens.getGreens_BigTypeName(),greens.getGreens_Type_ID());
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return rows > 0? 200 : -1;
}
}



