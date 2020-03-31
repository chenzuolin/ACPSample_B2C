package com.sec.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sec.entity.FindAllGreens;
import com.sec.entity.Greens;
import com.sec.entity.Greens_Jobber;
import com.sec.entity.Indent;
import com.sec.entity.Wineshop;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;
import com.sumeng.page.fenye;


public class GreensDao{
		String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
		String username="green";
		String pwd = "12345678";
		
		
		public List<Greens> ol(String bb,int cc,String aa){
			List<Greens> list = new ArrayList<Greens>();
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
			Greens greens = new Greens();
		    try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement(" select top " + cc + " * from (select row_number() over(order by Greens_Name desc) as rownumber,Greens_Name,count(*) as vv from Indent_table join Order_table on Indent_table.Indent_ID = Order_table.Indent_ID where Order_table.Greens_Name in(SELECT Greens_Name from Greens_table join XLFP_table on Greens_table.Greens_Type_Name = XLFP_table.Greens_Type_Name join CG_table on XLFP_table.CG_Name = CG_table.CG_UserName where CG_UserName = ?)and DATEDIFF(m, Indent_table.Indent_Time, GETDATE()) =1 and Indent_table.Indent_Status != '正在支付' group by Greens_Name) temp_row where rownumber>((?-1)*?)");
				pstmt.setString(1,aa);
				pstmt.setString(2,bb);
				pstmt.setInt(3,cc);
				rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
				while (rs.next()) {
					Greens g = new Greens();
					g.setGreens_Name(rs.getString("Greens_Name"));
					g.setGreens_Number(rs.getInt("vv"));
					list.add(g);
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
		
		public List<Greens> olss(String bb,int cc,String aa){
			List<Greens> list = new ArrayList<Greens>();
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
			Greens greens = new Greens();
		    try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement(" select top " + cc + " * from (select row_number() over(order by Greens_Name desc) as rownumber,Greens_Name,count(*) as vv from Indent_table join Order_table on Indent_table.Indent_ID = Order_table.Indent_ID where Order_table.Greens_Name in(SELECT Greens_Name from Greens_table join XLFP_table on Greens_table.Greens_Type_Name = XLFP_table.Greens_Type_Name join CG_table on XLFP_table.CG_Name = CG_table.CG_UserName where CG_UserName = ?) and Indent_table.Indent_Status != '正在支付' group by Greens_Name) temp_row where rownumber>((?-1)*?)");
				pstmt.setString(1,aa);
				pstmt.setString(2,bb);
				pstmt.setInt(3,cc);
				rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
				while (rs.next()) {
					Greens g = new Greens();
					g.setGreens_Name(rs.getString("Greens_Name"));
					g.setGreens_Number(rs.getInt("vv"));
					list.add(g);
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
		
		public List<Greens> findNewTop(){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "select top 20 * from Greens_table where Greens_Stop=0 order by Greens_Date desc";
			List<Greens> list = null;
			try {
				list =qr.query(sql, new BeanListHandler<Greens>(Greens.class));
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return list;
		}
		public List<Greens> findTuiTop(){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "select top 20 * from Greens_table where Greens_Stop = 0 and Greens_Recommend='是' order by Greens_Price asc";
			List<Greens> list = null;
			try {
				list =qr.query(sql, new BeanListHandler<Greens>(Greens.class));
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return list;
		}
		public void add(Greens greens) {//添加数据
			Connection conn=null;
			PreparedStatement pstmt = null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
				conn = DriverManager.getConnection(url,username,pwd);//连接
				String sql = "insert into Greens_table (Greens_Type_Name,Greens_Name,Greens_Unit,"
						+ "Greens_Character,Greens_Preiod,Greens_Norms,Greens_Number,Greens_Price,"
						+ "Greens_Market_Price,Greens_Condition,Greens_Minnumber,Greens_Class,"
						+ "Greens_Grade,Greens_characteristics,Greens_Recommend,Greens_Remark,Greens_Time,Greens_tupian)"
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//SQL语句
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, greens.getGreens_Type_Name());
				pstmt.setString(2, greens.getGreens_Name());
				pstmt.setString(3, greens.getGreens_Unit());
				pstmt.setString(4, greens.getGreens_Character());
				pstmt.setString(5, greens.getGreens_Preiod());
				pstmt.setString(6, greens.getGreens_Norms());
				pstmt.setInt(7, greens.getGreens_Number());
				pstmt.setFloat(8, greens.getGreens_Price());
				pstmt.setFloat(9, greens.getGreens_Market_Price());
				pstmt.setString(10, greens.getGreens_Condition());
				pstmt.setInt(11, greens.getGreens_Minnumber());
				pstmt.setString(12, greens.getGreens_Class());
				pstmt.setInt(13, greens.getGreens_Grade());
				pstmt.setString(14, greens.getGreens_characteristics());
				pstmt.setString(15, greens.getGreens_Recommend());
				pstmt.setString(16, greens.getGreens_Remark());
				pstmt.setString(17, greens.getGreens_Time());
				pstmt.setString(18, greens.getGreens_tupian());
				
				
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
		
		
		public int addAll(Greens greens) {//添加数据
			Connection conn=null;
			PreparedStatement pstmt = null;
			int code = 0;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
				conn = DriverManager.getConnection(url,username,pwd);//连接
				String sql = "insert into Greens_table (Greens_Type_Name,Greens_Name,Greens_Unit,"
						+ "Greens_Character,Greens_Preiod,Greens_Norms,Greens_Number,Greens_Price,"
						+ "Greens_Market_Price,Greens_Condition,Greens_Minnumber,Greens_Class,"
						+ "Greens_Grade,Greens_characteristics,Greens_Recommend,Greens_Remark,Greens_tupian,"
						+ "Greens_Stop,Greens_BigName,Greens_Date)"
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//SQL语句
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, greens.getGreens_Type_Name());
				pstmt.setString(2, greens.getGreens_Name());
				pstmt.setString(3, greens.getGreens_Unit());
				pstmt.setString(4, greens.getGreens_Character());
				pstmt.setString(5, greens.getGreens_Preiod());
				pstmt.setString(6, greens.getGreens_Norms());
				pstmt.setInt(7, greens.getGreens_Number());
				pstmt.setFloat(8, greens.getGreens_Price());
				pstmt.setFloat(9, greens.getGreens_Market_Price());
				pstmt.setString(10, greens.getGreens_Condition());
				pstmt.setInt(11, greens.getGreens_Minnumber());
				pstmt.setString(12, greens.getGreens_Class());
				pstmt.setInt(13, greens.getGreens_Grade());
				pstmt.setString(14, greens.getGreens_characteristics());
				pstmt.setString(15, greens.getGreens_Recommend());
				pstmt.setString(16, greens.getGreens_Remark());
				pstmt.setString(17, greens.getGreens_tupian());
				pstmt.setInt(18, greens.getGreens_Stop());
				pstmt.setString(19, greens.getBigName());
				pstmt.setString(20, greens.getGreens_Date());
				boolean a=pstmt.execute();
				if(!a){
					code = 200;
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
			return code;
			
		}

		/**
		 * 根据编号查询蔬菜
		 * @param Greens_ID 蔬菜编号
		 * @return
		 */
		public Greens findObjectByID(int Greens_ID){
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
			Greens greens = new Greens();
		    try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from Greens_table where Greens_ID=?");
				pstmt.setInt(1,Greens_ID);
				rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
				if(rs.next()){
					greens.setGreens_ID(rs.getInt(1));
					greens.setGreens_Type_Name(rs.getString(2));
					greens.setGreens_Name(rs.getString(3));
					greens.setGreens_Unit(rs.getString(4));
					greens.setGreens_Character(rs.getString(5));
					greens.setGreens_Preiod(rs.getString(6));
					greens.setGreens_Norms(rs.getString(7));
					greens.setGreens_Number(rs.getInt(8));
					greens.setGreens_Price(rs.getFloat(9));
					greens.setGreens_Market_Price(rs.getFloat(10));
					greens.setGreens_Condition(rs.getString(11));
					greens.setGreens_Minnumber(rs.getInt(12));
					greens.setGreens_Class(rs.getString(13));
					greens.setGreens_Grade(rs.getInt(14));
					greens.setGreens_characteristics(rs.getString(15));
					greens.setGreens_Recommend(rs.getString(16));
					greens.setGreens_Remark(rs.getString(17));
					greens.setGreens_Time(rs.getString(18));
					greens.setGreens_tupian(rs.getString(19));
					greens.setGreens_Stop(rs.getInt(22));
					greens.setBigName(rs.getString(23));
					
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
		    return greens;
		}
		
		
		
		/**
		 * 更新
		 * @param greens
		 */
		public void updateAll(Greens green) throws IOException{//更新
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				String sql = "update Greens_table set Greens_Type_Name=?,Greens_Name=?,Greens_Unit=?,Greens_Character=?,Greens_Preiod=?,Greens_Number=?,Greens_Price=?,Greens_Market_Price=?,Greens_Condition=?,Greens_Class=?,Greens_Grade=?,Greens_Recommend=?,Greens_Remark=? where Greens_ID=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,green.getGreens_Type_Name());
				pstmt.setString(2, green.getGreens_Name());
				pstmt.setString(3, green.getGreens_Unit());
				pstmt.setString(4, green.getGreens_Character());
				pstmt.setString(5, green.getGreens_Preiod());
				pstmt.setInt(6, green.getGreens_Number());
				pstmt.setFloat(7, green.getGreens_Price());
				pstmt.setFloat(8, green.getGreens_Market_Price());
				pstmt.setString(9, green.getGreens_Condition());
				pstmt.setString(10, green.getGreens_Class());
				pstmt.setInt(11, green.getGreens_Grade());
				pstmt.setString(12, green.getGreens_Recommend());
				pstmt.setString(13, green.getGreens_Remark());
				pstmt.setInt(14, green.getGreens_ID());
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

public void update(Greens greens){//更新
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Greens_table set Greens_Type_Name=?,Greens_Name=?,Greens_Unit=?,Greens_Character=?,Greens_Preiod=?,Greens_Norms=?,Greens_Number=?,Greens_Price=?,Greens_Market_Price=?,Greens_Condition=?,Greens_Minnumber=?,Greens_Class=?,Greens_Grade=?,Greens_characteristics=?,Greens_Recommend=?,Greens_Remark=?,Greens_Time=? where Greens_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, greens.getGreens_Type_Name());
		pstmt.setString(2, greens.getGreens_Name());
		pstmt.setString(3, greens.getGreens_Unit());
		pstmt.setString(4, greens.getGreens_Character());
		pstmt.setString(5, greens.getGreens_Preiod());
		pstmt.setString(6, greens.getGreens_Norms());
		pstmt.setInt(7, greens.getGreens_Number());
		pstmt.setFloat(8, greens.getGreens_Price());
		pstmt.setFloat(9, greens.getGreens_Market_Price());
		pstmt.setString(10, greens.getGreens_Condition());
		pstmt.setInt(11, greens.getGreens_Minnumber());
		pstmt.setString(12, greens.getGreens_Class());
		pstmt.setInt(13, greens.getGreens_Grade());
		pstmt.setString(14, greens.getGreens_characteristics());
		pstmt.setString(15, greens.getGreens_Recommend());
		pstmt.setString(16, greens.getGreens_Remark());
		pstmt.setString(17, greens.getGreens_Time());
		pstmt.setInt(18, greens.getGreens_ID());
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

public int findTuijianAllNum(){
	int num = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select count(*) from Greens_table where Greens_Recommend='是'");
		rs = pstmt.executeQuery();
		while(rs.next()){
			num = rs.getInt(1);
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
    return num;
}
public int findAllNum(){//查询表的所有信息
	int num = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select count(*) from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			num = rs.getInt(1);
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
    return num;
}

public int delete(int Greens_ID){//删除

	Connection conn = null;
	PreparedStatement pstmt = null;
	int a= 0;
	String sql = "delete from Greens_table where Greens_ID=?";
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Greens_ID);
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


public List<Greens> findAll(){//查询表的所有信息
	
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			
			
				Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			list.add(greens);
			
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

public List<Greens> findleixin(String Class_Name){//查询表的所有信息
	
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Class_Name=?");
		pstmt.setString(1, Class_Name);
		rs = pstmt.executeQuery();
		while(rs.next()){
			
			
				Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			list.add(greens);
			
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
public List<Greens> findAllshucai(){//查询表的所有信息
	
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			String aa = rs.getString(20);
			while(aa.contains("蔬菜")) {
			
				Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			list.add(greens);
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
    return list;
}

public List<Greens> findAlltiaoliao(){//查询表的所有信息
	
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			String aa = rs.getString(20);
			while(aa.contains("调料")) {
			
				Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			list.add(greens);
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
    return list;
}


public List<Greens> findAll99(){//查询表的所有信息
	
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString(16).contains("是")){
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			list.add(greens);
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
    return list;
}

public Integer getAllRowsAmount() throws Exception{//查询表的所有信息
	
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			
			
				Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			list.add(greens);
			
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

public List<Greens> getUserByCurrentPage(Integer currentPageStartRow,//从多少行到多少行
		Integer pageSize) throws Exception {
	// TODO 自动生成的方法存根
	    	List<Greens> list = new ArrayList<Greens>();
	        Connection conn = null;
	        PreparedStatement pstmt1 = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    		conn = DriverManager.getConnection(url,username,pwd);
	    		pstmt1 = conn.prepareStatement("select top (?-?+1) * from Greens_table where Greens_ID not in (select top (?-1) Greens_ID from Greens_table)");
	    		pstmt1.setInt(1,pageSize);
	    		pstmt1.setInt(2, currentPageStartRow);
	    		pstmt1.setInt(3, currentPageStartRow);
	    		rs = pstmt1.executeQuery();//执行SQL语句，并返回结果集
	    		while(rs.next()) {
	    			Greens greens = new Greens();
	    			greens.setGreens_ID(rs.getInt(1));
	    			greens.setGreens_Type_Name(rs.getString(2));
	    			greens.setGreens_Name(rs.getString(3));
	    			greens.setGreens_Unit(rs.getString(4));
	    			greens.setGreens_Character(rs.getString(5));
	    			greens.setGreens_Preiod(rs.getString(6));
	    			greens.setGreens_Norms(rs.getString(7));
	    			greens.setGreens_Number(rs.getInt(8));
	    			greens.setGreens_Price(rs.getFloat(9));
	    			greens.setGreens_Market_Price(rs.getFloat(10));
	    			greens.setGreens_Condition(rs.getString(11));
	    			greens.setGreens_Minnumber(rs.getInt(12));
	    			greens.setGreens_Class(rs.getString(13));
	    			greens.setGreens_Grade(rs.getInt(14));
	    			greens.setGreens_characteristics(rs.getString(15));
	    			greens.setGreens_Recommend(rs.getString(16));
	    			greens.setGreens_Remark(rs.getString(17));
	    			greens.setGreens_Time(rs.getString(18));
	    			list.add(greens);
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
	                if(pstmt1!=null){
	                    pstmt1.close();
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


public List<Greens> findUserByID(int Greens_ID){//根据编号查询信息
	List<Greens> list1 = new ArrayList<Greens>();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Greens_ID=?");
		pstmt.setInt(1,Greens_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			greens.setGreens_Price_Num(rs.getInt("Greens_Price_Num"));
			greens.setGreens_Sore(rs.getInt("Greens_Sore"));
			list1.add(greens);
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

public int  findUserByIDnum(int Greens_ID){//根据编号查询信息
     int aa = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select Greens_Minnumber from Greens_table where Greens_ID=?");
		pstmt.setInt(1,Greens_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			
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









public List<Greens> findUserByTY(String Greens_Type_Name){//根据编号查询信息
	List<Greens> list1 = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Greens_Type_Name=?");
		pstmt.setString(1,Greens_Type_Name);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()){
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			greens.setGreens_Stop(rs.getInt(22));
			greens.setBigName(rs.getString(23));
			list1.add(greens);
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

public String findUserByIDtype(int Greens_ID){//根据编号查询信息
	String a = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Greens_ID=?");
		pstmt.setInt(1,Greens_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			
			a = rs.getString(2);
			
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

public List<Greens> findUserByIDlike(String Greens_Name){//根据编号查询信息
	List<Greens> list1 = new ArrayList<Greens>();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Greens_Name like '%' + ? +'%' ");
		pstmt.setString(1,Greens_Name);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()){
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			list1.add(greens);
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
public List<Greens> findUserByIDlike2(String Greens_Name){//根据编号查询信息
	List<Greens> list1 = new ArrayList<Greens>();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Greens_Name like '%' + ? +'%' ");
		pstmt.setString(1,Greens_Name);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()!=false){
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			greens.setGreens_Stop(rs.getInt(22));
			greens.setBigName(rs.getString(23));
			list1.add(greens);
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
public String findGreens_Jobber_UserName(String Greens_Jobber_UserName){
	Greens_Jobber greens_Jobber=new Greens_Jobber();
	 Connection conn = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     try{
     	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt=conn.prepareStatement("select * Greens_Jobber_table where Greens_Jobber_UserName=?");
			pstmt.setString(1, Greens_Jobber_UserName);
			rs=pstmt.executeQuery();
			while(rs.next()){
				greens_Jobber.setGreens_Jobber_ID(rs.getInt("Greens_Jobber_ID"));
				greens_Jobber.setGreens_Jobber_Name(rs.getString("Greens_Jobber_Name"));
				greens_Jobber.setGreens_Jobber_Aptitude(rs.getString("Greens_Jobber_Aptitude"));
				greens_Jobber.setGreens_Jobber_Address(rs.getString("Greens_Jobber_Address"));
				greens_Jobber.setGreens_Jobber_Shift_Name(rs.getString("Greens_Jobber_Shift_Name"));
				greens_Jobber.setGreens_Jobber_Telephone(rs.getString("Greens_Jobber_Telephone"));
				greens_Jobber.setGreens_Jobber_Time(rs.getString("Greens_Jobber_Time"));
				greens_Jobber.setRegionality_ID(rs.getInt("Regionality_ID"));
				greens_Jobber.setGreens_Jobber_QQ(rs.getString("Greens_Jobber_QQ"));
				greens_Jobber.setGreens_Jobber_WeChat(rs.getString("Greens_Jobber_WeChat"));
				greens_Jobber.setGreens_Jobber_Grade(rs.getString("Greens_Jobber_Grade"));
				
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
return greens_Jobber.getGreens_Jobber_QQ();
}

public String findUserByID1(int Greens_ID){//根据编号查询信息
	String a = null;
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Greens_ID=?");
		pstmt.setInt(1,Greens_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			a = rs.getString("Greens_Name");
			
		
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


public int update1(Greens greens){//更新
	int a = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Greens_table set Greens_Number=? where Greens_ID=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, greens.getGreens_Number());
		
		pstmt.setInt(2, greens.getGreens_ID());
		
		
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


public int update2(Greens greens){//更新
	int a = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Greens_table set Greens_Grade=? where Greens_ID=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, greens.getGreens_Grade());
		
		pstmt.setInt(2, greens.getGreens_ID());
		
		
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
}catch(Exception e){
	e.printStackTrace();
}
}
	return a;
}


public int update3(Greens greens){//更新
	int a = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Greens_table set Greens_Recommend=? where Greens_ID=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, greens.getGreens_Recommend());
		
		pstmt.setInt(2, greens.getGreens_ID());
		
		
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
}catch(Exception e){
	e.printStackTrace();
}
}
	return a;
}



public int findUserByID2(String Greens_Name){//根据编号查询信息
	int a = 0;
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Greens_Name=?");
		pstmt.setString(1,Greens_Name);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			a = rs.getInt("Greens_ID");
			
		
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

public List<Greens> findUserByID0(){//查询当天记录
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where DateDiff(dd,Greens_Time,getdate())=0");
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()) {
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			list.add(greens);
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

public List<Greens> findUserByIDweek(){//查询当天记录
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where DateDiff(week,Greens_Time,getdate())=0");
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()) {
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			list.add(greens);
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

public List<Greens> findUserByIDmonth(){//查询当天记录
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where DateDiff(month,Greens_Time,getdate())=0");
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()) {
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			list.add(greens);
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




public List<Greens> getUserByCurrentPage1() {
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			
			
				Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			list.add(greens);
			
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




public List<Greens> getUserByCurrentPage2(String jjj) {
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			String aa = rs.getString(2);
			if(aa.contains(jjj)) {
			
				Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			list.add(greens);
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
    return list;
}




public List<Greens> getUserByCurrentPage3(String ggg) {
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			String aa = rs.getString(3);
			if(aa.contains(ggg)) {
			
				Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			list.add(greens);
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
    return list;

}

@SuppressWarnings("unchecked")
public static List sortIntMethod(List list){//按照编号进行排序
    Collections.sort(list, new Comparator(){
		@Override
		public int compare(Object o1, Object o2) {
			Greens stu1=(Greens)o1;
			Greens stu2=(Greens)o2;
			if(stu1.getGreens_Grade()>stu2.getGreens_Grade()){
				return -1;
			}else if(stu1.getGreens_Grade()==stu2.getGreens_Grade()){
				return 0;
			}else{
				return 1;
			}
		}	    	
    });
    return list;



}



public List<Greens> findAll1(){//查询表的所有信息
	
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			String dd = rs.getString(16);
			if(dd.contains("是")) {
				Greens greens = new Greens();
				greens.setGreens_ID(rs.getInt(1));
				greens.setGreens_Type_Name(rs.getString(2));
				greens.setGreens_Name(rs.getString(3));
				greens.setGreens_Unit(rs.getString(4));
				greens.setGreens_Character(rs.getString(5));
				greens.setGreens_Preiod(rs.getString(6));
				greens.setGreens_Norms(rs.getString(7));
				greens.setGreens_Number(rs.getInt(8));
				greens.setGreens_Price(rs.getFloat(9));
				greens.setGreens_Market_Price(rs.getFloat(10));
				greens.setGreens_Condition(rs.getString(11));
				greens.setGreens_Minnumber(rs.getInt(12));
				greens.setGreens_Class(rs.getString(13));
				greens.setGreens_Grade(rs.getInt(14));
				greens.setGreens_characteristics(rs.getString(15));
				greens.setGreens_Recommend(rs.getString(16));
				greens.setGreens_Remark(rs.getString(17));
				greens.setGreens_Time(rs.getString(18));
				greens.setGreens_tupian(rs.getString(19));
				list.add(greens);
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
    return list;
}
public String greensLike(int greensId){//查询表的所有信息
	
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String like = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select Greens_Like from Greens_table where Greens_ID=?");
		pstmt.setInt(1, greensId);
		rs = pstmt.executeQuery();
		while(rs.next()){
			like = rs.getString(1);
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
    return like;
}
public List<Greens> findLike(String like){//根据编号查询信息
	List<Greens> list = new ArrayList<Greens>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Greens_Like=?");
		pstmt.setString(1,like);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()){
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			greens.setGreens_Like(rs.getString(20));
			list.add(greens);
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


public List<Greens> findUserByID88(int Greens_ID){//根据编号查询信息
	List<Greens> list1 = new ArrayList<Greens>();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_table where Greens_ID=?");
		pstmt.setInt(1,Greens_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt(1));
			greens.setGreens_Type_Name(rs.getString(2));
			greens.setGreens_Name(rs.getString(3));
			greens.setGreens_Unit(rs.getString(4));
			greens.setGreens_Character(rs.getString(5));
			greens.setGreens_Preiod(rs.getString(6));
			greens.setGreens_Norms(rs.getString(7));
			greens.setGreens_Number(rs.getInt(8));
			greens.setGreens_Price(rs.getFloat(9));
			greens.setGreens_Market_Price(rs.getFloat(10));
			greens.setGreens_Condition(rs.getString(11));
			greens.setGreens_Minnumber(rs.getInt(12));
			greens.setGreens_Class(rs.getString(13));
			greens.setGreens_Grade(rs.getInt(14));
			greens.setGreens_characteristics(rs.getString(15));
			greens.setGreens_Recommend(rs.getString(16));
			greens.setGreens_Remark(rs.getString(17));
			greens.setGreens_Time(rs.getString(18));
			greens.setGreens_tupian(rs.getString(19));
			list1.add(greens);
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

public int deleteById(int id){//删除
	Connection conn = null;
	PreparedStatement pstmt = null;
	int a= 0;
	String sql = "delete from Greens_table where Greens_ID=?";
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
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
		pstmt1 = conn.prepareStatement("select COUNT(*) from Greens_table");
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
public Page getSun(int currentPage,Page dd,int size) {
	// TODO 自动生成的方法存根
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	List<Greens> list = new ArrayList<Greens>();
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url, username, pwd);
		pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Greens_Date desc) as rownumber,* from Greens_table  ) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
		rs = pstmt1.executeQuery();
		while (rs.next()) {
			Greens greens = new Greens();
			greens.setGreens_ID(rs.getInt("Greens_ID"));
			greens.setGreens_Type_Name(rs.getString("Greens_Type_Name"));
			greens.setGreens_Name(rs.getString("Greens_Name"));
			greens.setGreens_Unit(rs.getString("Greens_Unit"));
			greens.setGreens_Price(rs.getFloat("Greens_Price"));
			greens.setGreens_Market_Price(rs.getFloat("Greens_Market_Price"));
			greens.setGreens_Minnumber(rs.getInt("Greens_Minnumber"));
			greens.setGreens_tupian(rs.getString("Greens_tupian"));
			greens.setGreens_Number(rs.getInt("Greens_Number"));
			greens.setGreens_Stop(rs.getInt("Greens_Stop"));
			greens.setBigName(rs.getString("Greens_BigName"));
			greens.setGreens_Character(rs.getString("Greens_Character"));
			greens.setGreens_Minnumber(rs.getInt("Greens_Minnumber"));
			greens.setGreens_Grade(rs.getInt("Greens_Grade"));
			greens.setGreens_Remark(rs.getString("Greens_Remark"));
			greens.setGreens_tupian(rs.getString("Greens_tupian"));
			greens.setGreens_Grade(rs.getInt("Greens_Grade"));
			greens.setGreens_Sore(rs.getInt("Greens_Sore"));
			list.add(greens);
			dd.setData(list);
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
public fenye getSum8(int currentPage,int size) {
	// TODO 自动生成的方法存根
	fenye f = new fenye();
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	int totalNum = 0;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url, username, pwd);
		pstmt1 = conn.prepareStatement("select COUNT(*) from Greens_table");
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
		System.out.println(totalNum+"aa");
		f.setCount(totalNum);
		f.setTotalPage(totalPage);
		f.setCurrentPage(currentPage);
		f.setCode(0);
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
	return f;
}



/**
 * author:呆萌的欧尼酱
 * @param currentPage
 * @param dd
 * @param size
 * @param Wineshop_Name
 * @param Time1
 * @param Time2
 * @return
 */

public fenye getSun8(int currentPage,fenye dd,int size) {
	System.out.println("88");
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	System.out.println("88");
	List<FindAllGreens> list = new ArrayList<FindAllGreens>();   
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		
		pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Greens_ID asc) as rownumber,Greens_ID, Greens_Name,Greens_Unit,Greens_Price,Greens_Market_Price from Greens_table) temp_row where rownumber>(("+currentPage+"-1)*"+size+")");
		
		System.out.println("55");
		rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
		while(rs.next()) {
			System.out.println("99");
			FindAllGreens f = new FindAllGreens();
			f.setGreens_ID(rs.getInt("Greens_ID"));
			f.setGreens_Name(rs.getString("Greens_Name"));
			f.setGreens_Unit(rs.getString("Greens_Unit"));
			f.setGreens_Price(rs.getFloat("Greens_Price"));
			f.setGreens_Market_Price(rs.getFloat("Greens_Market_Price"));
			
			System.out.println(f+"55");
			list.add(f);
			dd.setData(list);
			System.out.println(list+"44");
		}  
		System.out.println("77");
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

public boolean update1001(FindAllGreens g) {// 更新菜价
	boolean a = false;
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url, username, pwd);
		String sql = "update Greens_table set Greens_Price=?,Greens_Market_Price=? where Greens_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setFloat(1, g.getGreens_Price());
		pstmt.setFloat(2, g.getGreens_Market_Price());
		pstmt.setInt(3, g.getGreens_ID());

		boolean y = pstmt.execute();
		System.out.println(y);
		a = y;
		if (!y) {
			System.out.println("操作成功");
		} else
			System.out.println("操作失败");

	} catch (ClassNotFoundException e) {
		System.out.println("注册驱动失败！");
	} catch (SQLException e) {
		System.out.println("");
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return a;
}
/**
 * 
 * @param stop
 * @param gid
 * @return
 */
public int updateStop(int stop,int gid){
	QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
	String sql = "update Greens_table set Greens_Stop=? where Greens_ID=?";
	int code = 0;
	try {
		code = qr.update(sql,stop,gid);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return code > 0? 200 : -1;
}
public int updateDateail(Greens green) throws IOException{//更新
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int code = 0;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Greens_table set Greens_Name=?,Greens_BigName=?,Greens_Type_Name=?,Greens_Unit=?,Greens_Price=?,Greens_Market_Price=?,Greens_Character=?,Greens_Condition=?,Greens_Minnumber=?,Greens_Norms=?,Greens_Number=?,Greens_Class=?,Greens_characteristics=?,Greens_Recommend=?,Greens_Remark=?,Greens_Preiod=?,Greens_Stop=? where Greens_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, green.getGreens_Name());
		pstmt.setString(2,green.getBigName());
		pstmt.setString(3, green.getGreens_Type_Name());
		pstmt.setString(4, green.getGreens_Unit());
		pstmt.setFloat(5, green.getGreens_Price());
		pstmt.setFloat(6, green.getGreens_Market_Price());
		pstmt.setString(7, green.getGreens_Character());
		pstmt.setString(8, green.getGreens_Condition());
		pstmt.setInt(9, green.getGreens_Minnumber());
		pstmt.setString(10, green.getGreens_Norms());
		pstmt.setInt(11, green.getGreens_Number());
		pstmt.setString(12, green.getGreens_Class());
		pstmt.setString(13, green.getGreens_characteristics());
		pstmt.setString(14, green.getGreens_Recommend());
		pstmt.setString(15, green.getGreens_Remark());
		pstmt.setString(16, green.getGreens_Preiod());
		pstmt.setInt(17, green.getGreens_Stop());
		pstmt.setInt(18, green.getGreens_ID());
		boolean b=pstmt.execute();
		if(!b){
			code = 200;
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
	return code;
}
public Page checkGreensNameLike(int currentPage,int size,String name){
	QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
	Page page = new Page();
	String sqlTotalCount = "select COUNT(*) from Greens_table where Greens_Name like "+"'%"+""+name+""+"%'"+"";
	String sqlData = "select top "+size+" * from (select row_number() "
			+ "over(order by Greens_ID asc) as"
			+ " rownumber,* from Greens_table where Greens_Name like "+"'%"+""+name+""+"%'"+")temp_row where rownumber>(("+currentPage+"-1)*"+size+")";
	Object count = null;
	List<Greens> list = null;
	try {
		count = qr.query(sqlTotalCount,new ScalarHandler());
		list = qr.query(sqlData, new BeanListHandler<Greens>(Greens.class));
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
public Page getSumCount(int currentPage,int size,String name) {
	// TODO 自动生成的方法存根
	Page page = new Page();
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	int totalNum = 0;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url, username, pwd);
		pstmt1 = conn.prepareStatement("select COUNT(*) from Greens_table where Greens_Name like "+"'%"+""+name+""+"%'"+"");
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
public Page getSunData(int currentPage,Page dd,int size,String name) {
	// TODO 自动生成的方法存根
	Connection conn = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	List<Greens> list = new ArrayList<Greens>();
	String sqlData = "select top "+size+" * from (select row_number() "
			+ "over(order by Greens_ID asc) as"
			+ " rownumber,* from Greens_table where Greens_Name like "+"'%"+""+name+""+"%'"+")temp_row where rownumber>(("+currentPage+"-1)*"+size+")";
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url, username, pwd);
		pstmt1 = conn.prepareStatement(sqlData);
		rs = pstmt1.executeQuery();
		while (rs.next()) {
			Greens greens = new Greens();
			greens.setGreens_Name(rs.getString("Greens_Name"));
			greens.setBigName(rs.getString("Greens_BigName"));
			greens.setGreens_Type_Name(rs.getString("Greens_Type_Name"));
			greens.setGreens_ID(rs.getInt("Greens_ID"));
			
			
			greens.setGreens_Unit(rs.getString("Greens_Unit"));
			greens.setGreens_Price(rs.getFloat("Greens_Price"));
			greens.setGreens_Market_Price(rs.getFloat("Greens_Market_Price"));
			greens.setGreens_Minnumber(rs.getInt("Greens_Minnumber"));
			greens.setGreens_tupian(rs.getString("Greens_tupian"));
			greens.setGreens_Number(rs.getInt("Greens_Number"));
			greens.setGreens_Stop(rs.getInt("Greens_Stop"));
			
			greens.setGreens_Character(rs.getString("Greens_Character"));
			greens.setGreens_Minnumber(rs.getInt("Greens_Minnumber"));
			greens.setGreens_Grade(rs.getInt("Greens_Grade"));
			greens.setGreens_Remark(rs.getString("Greens_Remark"));
			greens.setGreens_tupian(rs.getString("Greens_tupian"));
			greens.setGreens_Grade(rs.getInt("Greens_Grade"));
			greens.setGreens_Preiod(rs.getString("Greens_Preiod"));
			greens.setGreens_Norms(rs.getString("Greens_Norms"));
			
			list.add(greens);
			dd.setData(list);
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
	public int update (double ceil,int id){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update Greens_table set Greens_Price=? where Greens_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,ceil,id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return code > 0? 200 : -1;
	}
	public int updateSore (int id,int sore){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update Greens_table set Greens_Sore=? where Greens_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,sore,id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return code > 0? 200 : -1;
	}
}

