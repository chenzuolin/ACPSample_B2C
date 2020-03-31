package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.GreensXiaoJi;
import com.sumeng.page.Page;

public class XiaoJiDao {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username = "green";
	String pwd = "12345678";
	
	public List<GreensXiaoJi> findAll(String Indent_Type_Name) throws SQLException{//待分拣蔬菜小计按照蔬菜分类查询全部蔬菜的和
		List<GreensXiaoJi> list = new ArrayList<GreensXiaoJi>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select  Greens_table.Greens_Type_Name,Order_table.Greens_ID,Greens_table.Greens_Name,Greens_table.Greens_Unit, sum(Number) as number from Order_table INNER JOIN Greens_table on Order_table.Greens_ID = Greens_table.Greens_ID  where Greens_table.Greens_Type_Name=? and Indent_ID in (select Indent_ID from Indent_table where Indent_Status = '正在分拣')group by Order_table.Greens_ID, Greens_table.Greens_Type_Name,Greens_table.Greens_Name,Greens_table.Greens_Unit");
			pstmt.setString(1, Indent_Type_Name);
			rs = pstmt.executeQuery();
			while(rs.next()) {  
				GreensXiaoJi xj = new GreensXiaoJi();
				xj.setGreens_Type_Name(rs.getString("Greens_Type_Name"));
				xj.setGreens_ID(rs.getInt("Greens_ID"));
				xj.setGreens_Name(rs.getString("Greens_Name"));
				xj.setGreens_Unit(rs.getString("Greens_Unit"));
				xj.setNumber(rs.getInt("number"));
				
						
				
				
				
				list.add(xj);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	
	public List<GreensXiaoJi> findAll1() throws SQLException{//待分拣蔬菜小计按照蔬菜分类查询全部蔬菜的和
		List<GreensXiaoJi> list = new ArrayList<GreensXiaoJi>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_table.Greens_Type_Name,Order_table.Greens_ID,Greens_table.Greens_Name,Greens_table.Greens_Unit, sum(Order_table.Number) as Number from Order_table INNER JOIN Greens_table  on Order_table.Greens_ID = Greens_table.Greens_ID where Indent_ID in (select Indent_ID from Indent_table where Indent_Status = '正在分拣')group by Order_table.Greens_ID, Greens_table.Greens_Type_Name,Greens_table.Greens_Name,Greens_table.Greens_Unit");
			rs = pstmt.executeQuery();
			while(rs.next()) {  
				GreensXiaoJi xj = new GreensXiaoJi();
				xj.setGreens_Type_Name(rs.getString("Greens_Type_Name"));
				xj.setGreens_ID(rs.getInt("Greens_ID"));
				xj.setGreens_Name(rs.getString("Greens_Name"));     
				xj.setGreens_Unit(rs.getString("Greens_Unit"));
				xj.setNumber(rs.getInt(5));
				
						
				
				
				
				list.add(xj);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
		
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
			pstmt1 = conn.prepareStatement("select COUNT(distinct Greens_table.Greens_Name) from Greens_table join Order_table right join Indent_table right join Wineshop_table on Indent_table.Wineshop_ID=Wineshop_table.Wineshop_ID on Order_table.Indent_ID=Indent_table.Indent_ID on Greens_table.Greens_ID=Order_table.Greens_ID where Indent_table.Indent_Status!='正在支付' and Wineshop_table.Wineshop_ID!=200 ");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			
			while (rs.next()) {
				totalNum = rs.getInt(1);
				System.out.println(totalNum);
			}
			int totalPage = 0;
			if(totalNum%size==0) {
				totalPage = totalNum/size;
			}else {
				totalPage = totalNum/size+1;
			}
			System.out.println(totalNum+"aa");
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
	 * author:呆萌的欧尼酱
	 * @param currentPage
	 * @param dd
	 * @param size
	 * @param Wineshop_Name
	 * @param Time1
	 * @param Time2
	 * @return
	 */
	
	public Page getSun(int currentPage,Page dd,int size) {
		System.out.println("88");
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		System.out.println("88");
		List<GreensXiaoJi> list = new ArrayList<GreensXiaoJi>();   
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Greens_table.Greens_Name desc) as rownumber, Greens_table.Greens_Name,Greens_table.Greens_Type_Name,Greens_table.Greens_Unit , SUM(Order_table.Number) as NN from Greens_table join Order_table right join Indent_table right join Wineshop_table on Indent_table.Wineshop_ID=Wineshop_table.Wineshop_ID on Order_table.Indent_ID=Indent_table.Indent_ID on Greens_table.Greens_ID=Order_table.Greens_ID where Indent_table.Indent_Status!='正在支付' and Wineshop_table.Wineshop_ID!=200 group by Greens_table.Greens_Name,Greens_table.Greens_Type_Name,Greens_table.Greens_Unit) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while(rs.next()) {
				System.out.println("99");
				GreensXiaoJi g = new GreensXiaoJi();
				g.setGreens_Name(rs.getString(2));
				g.setGreens_Type_Name(rs.getString(3));
				g.setGreens_Unit(rs.getString(4));
				g.setNN(rs.getInt(5));
				
				list.add(g);
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
	
	
	
	
	/**
	 * author 呆萌的欧尼酱
	 * @param currentPage
	 * @param size
	 * @param Wineshop_Name
	 * @param Time1
	 * @param Time2
	 * @return
	 */
	public Page getSum8(int currentPage,int size,String Time1,String Time2,String Greens_Name,String Greens_Type_Name) {
		// TODO 自动生成的方法存根
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			
			String sql = "select COUNT(distinct Greens_table.Greens_Name) "
					+ "from Greens_table join Order_table right join"
					+ " Indent_table right join Wineshop_table on"
					+ " Indent_table.Wineshop_ID=Wineshop_table.Wineshop_ID"
					+ " on Order_table.Indent_ID=Indent_table.Indent_ID on"
					+ " Greens_table.Greens_ID=Order_table.Greens_ID where"
					+ " Indent_table.Indent_Status!='正在支付'"
					+ " and Wineshop_table.Wineshop_ID!=200 and 1=1 ";
			if(Time1!=null&&Time1!=""&&Time2!=""&&Time2!=null) {
				sql +=" and Indent_table.Indent_Time between '"+Time1+"' and '"+Time2+"' ";
			}
			if(Time1!=null&&Time1!=""&&Time2!=null&&Time2!=""&&Greens_Name!=null&&Greens_Name!=""){
				sql +=" and Indent_table.Indent_Time between '"+Time1+"' and '"+Time2+"' and Greens_table.Greens_Name like '%"+Greens_Name+"%' ";
			}
			if(Time1!=null&&Time1!=""&&Time2!=null&&Time2!=""&&Greens_Type_Name!=null&&Greens_Type_Name!=""){
				sql +=" and Indent_table.Indent_Time between '"+Time1+"' and '"+Time2+"' and Greens_table.Greens_Type_Name='"+Greens_Type_Name+"' ";
			}
			
			
			pstmt1 = conn.prepareStatement(sql);
			//pstmt1.setString(1, Time1);
			//pstmt1.setString(2, Time2);
			System.out.println(sql+"第一条");
			
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
	 * author:呆萌的欧尼酱
	 * @param currentPage
	 * @param dd
	 * @param size
	 * @param Wineshop_Name
	 * @param Time1
	 * @param Time2
	 * @return
	 */
	
	public Page getSun8(int currentPage,Page dd,int size,String Time1,String Time2,String Greens_Name,String Greens_Type_Name) {
		System.out.println("88");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("88");
		List<GreensXiaoJi> list = new ArrayList<GreensXiaoJi>();   
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "select top "+size+" * from (select row_number()"
					+ " over(order by Greens_table.Greens_Name desc) as rownumber,"
					+ " Greens_table.Greens_Name,Greens_table.Greens_Type_Name,"
					+ "Greens_table.Greens_Unit , SUM(Order_table.Number)"
					+ " as NN from Greens_table join Order_table right join"
					+ " Indent_table right join Wineshop_table on "
					+ "Indent_table.Wineshop_ID=Wineshop_table.Wineshop_ID"
					+ " on Order_table.Indent_ID=Indent_table.Indent_ID on"
					+ " Greens_table.Greens_ID=Order_table.Greens_ID where"
					+ " Indent_table.Indent_Status!='正在支付' and"
					+ " Wineshop_table.Wineshop_ID!=200 ";
			if(Time1!=null&&Time1!=""&&Time2!=""&&Time2!=null) {//条件只有两个时间
				sql+=" and Indent_table.Indent_Time between '"+Time1+"' and '"+Time2+"' ";
			}
			if(Time1!=null&&Time1!=""&&Time2!=null&&Time2!=""&&Greens_Name!=null&&Greens_Name!=""){//条件为两个时间和蔬菜的名称
				sql +=" and Indent_table.Indent_Time between '"+Time1+"' and '"+Time2+"' and Greens_table.Greens_Name like '%"+Greens_Name+"%' ";
			}
			if(Time1!=null&&Time1!=""&&Time2!=null&&Time2!=""&&Greens_Type_Name!=null&&Greens_Type_Name!=""){
				sql +=" and Indent_table.Indent_Time between '"+Time1+"' and '"+Time2+"' and Greens_table.Greens_Type_Name='"+Greens_Type_Name+"' ";
			}
			sql+=(" group by Greens_table.Greens_Name,Greens_table.Greens_Type_Name,"
					+ "Greens_table.Greens_Unit) temp_row"
					+ " where rownumber>(("+currentPage+"-1)*"+size+")");
			pstmt = conn.prepareStatement(sql);
			System.out.println(Time1+"Time1");
			System.out.println(Time2+"Time2");
			System.out.println(sql+"第二条");
			
			
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while(rs.next()) {
				System.out.println("99");
				GreensXiaoJi g = new GreensXiaoJi();
				g.setGreens_Name(rs.getString(2));
				g.setGreens_Type_Name(rs.getString(3));
				g.setGreens_Unit(rs.getString(4));
				g.setNN(rs.getInt(5));
				
				list.add(g);
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
				if (pstmt != null) {
					pstmt.close();
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
	
	
	
	
	
	
	
}
