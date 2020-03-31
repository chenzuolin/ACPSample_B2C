package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sec.entity.FZ;
import com.sec.entity.Indent;
import com.sec.entity.TimeIndent;
import com.sec.util.StaticFinal;
import com.sumeng.kuai.object.Fenjianwanbi;
import com.sumeng.page.*;

public class IndentDao {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username = "green";
	String pwd = "12345678";
	public static final int NUM_PER_PAGE = 14;
	
	public Float oo1(int aa) {// 根据编号查询信息
		float sum = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select sum(Order_table.Greens_Price*Number) from Order_table join Indent_table on Order_table.Indent_ID = Indent_table.Indent_ID join Greens_table on Greens_table.Greens_ID = Order_table.Greens_ID where Greens_Sore = 1 and Indent_table.Wineshop_ID = ? and Indent_table.Indent_Status != '正在支付' and Indent_table.Indent_ID in (select Indent_ID from Indent_table where(Indent_table.Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ' 18:00:00' )AND CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00')+1))");
			pstmt.setInt(1, aa);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sum = rs.getFloat(1);
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
		return sum;
	}
	
	public Float oo2(int aa) {// 根据编号查询信息
		float sum = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select sum(Order_table.Greens_Price*Number) from Order_table join Indent_table on Order_table.Indent_ID = Indent_table.Indent_ID  join Greens_table on Greens_table.Greens_ID = Order_table.Greens_ID  where Greens_Sore = 1 and Indent_table.Wineshop_ID = ? and Indent_table.Indent_Status != '正在支付' and Indent_table.Indent_ID in (select Indent_ID from Indent_table where(Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00')AND CONVERT(datetime, LEFT(GETDATE(), 10) + ' 14:30:00')) or (Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ' 18:00:00')-1 AND CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00')))");
			pstmt.setInt(1, aa);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sum = rs.getFloat(1);
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
		return sum;
	}
	
	
	public List<Indent> o2(String time1,String time2,String cg_name,String qy,String currentPage,int size) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select top " + size + " * FROM (select row_number() over(order by Indent_table.Indent_ID asc) as rownumber,Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Wineshop_Telephone,Indent_table.Wineshop_Address,Wineshop_table.Wineshop_Name,Indent_table.Indent_GH from Indent_table join Order_table on Indent_table.Indent_ID=Order_table.Indent_ID join XLFP_table on Order_table.Greens_Type_Name=XLFP_table.Greens_Type_Name join Wineshop_table ON Wineshop_table.Wineshop_ID = Indent_table.Wineshop_ID where  XLFP_table.CG_Name=?  and Indent_table.Indent_QY = ? and Indent_table.Indent_GH != '配送成功'  and Indent_table.Indent_ID in (select Indent_ID from Indent_table where(Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ? )AND CONVERT(datetime, LEFT(GETDATE(), 10) + ?)) ) and (Indent_table.Indent_Status = '正在处理' or Indent_table.Indent_Status = '正在分拣')  ) group by Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Wineshop_Telephone,Indent_table.Wineshop_Address,Wineshop_table.Wineshop_Name,Indent_table.Indent_GH)temp_row where rownumber>((?-1)*?)");
			pstmt.setString(1,cg_name);
			pstmt.setString(2,qy);
			pstmt.setString(3,time1);
			pstmt.setString(4,time2);
			pstmt.setString(5,currentPage);
			pstmt.setInt(6, size);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt("Indent_ID"));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Status(rs.getString(3));
				indent.setWineshop_Telephone(rs.getString(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setCourier_Name(rs.getString(6));
				indents.add(indent);
				
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
		return indents;
	}
	
	
	public List<Indent> findallGHS2(String cc) {// 根据编号查询信息
		List<Indent> lists = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select Wineshop_Name from Indent_table join Wineshop_table on Indent_table.Wineshop_ID = Wineshop_table.Wineshop_ID where  Indent_QY = '速盟快线'  and Indent_Status != '正在支付' and Indent_ID in (  select distinct Indent_ID from Order_table where Greens_ID in (SELECT Greens_ID from Greens_table join XLFP_table on Greens_table.Greens_Type_Name = XLFP_table.Greens_Type_Name join CG_table on XLFP_table.CG_Name = CG_table.CG_UserName where CG_UserName = ?))");
			pstmt.setString(1,cc);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_Fare(rs.getString("Wineshop_Name"));
				lists.add(indent);
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
		return lists;
	}
	
	
	
	
	public List<Indent> findallGHS(String aa,int bb,String cc) {// 根据编号查询信息
		List<Indent> lists = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement(" select top "+bb+" * from (select row_number() over(order by Indent_table.Indent_ID asc) as rownumber,Indent_table.*,Wineshop_Name from Indent_table join Wineshop_table on Indent_table.Wineshop_ID = Wineshop_table.Wineshop_ID where  Indent_QY = '速盟快线'  and Indent_Status != '正在支付' and Indent_ID in (  select distinct Indent_ID from Order_table where Greens_ID in (SELECT Greens_ID from Greens_table join XLFP_table on Greens_table.Greens_Type_Name = XLFP_table.Greens_Type_Name join CG_table on XLFP_table.CG_Name = CG_table.CG_UserName where CG_UserName = ?))) temp_row where rownumber>((?-1)*?)");
			pstmt.setString(1,cc);
			pstmt.setString(2,aa);
			pstmt.setInt(3,bb);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt("Indent_ID"));
				indent.setIndent_Time(rs.getString("Indent_Time"));
				indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
				indent.setWineshop_Address(rs.getString("Wineshop_Address"));
				indent.setIndent_Fare(rs.getString("Wineshop_Name"));
				indent.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				indent.setIndent_Status(rs.getString("Indent_Status"));
				lists.add(indent);
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
		return lists;
	}
	
	
	public int olmou(String cc) {// 根据编号查询信息
		int aa = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select count(*) from Indent_table join Order_table on Indent_table.Indent_ID = Order_table.Indent_ID where Order_table.Greens_Name = ? and DATEDIFF(m, Indent_table.Indent_Time, GETDATE()) =1 and Indent_table.Indent_Status != '正在支付'");
			pstmt.setString(1,cc);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				aa = rs.getInt(1);
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
		return aa;
	}
	
	public int olyear(String cc) {// 根据编号查询信息
		int aa = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select count(*) from Indent_table join Order_table on Indent_table.Indent_ID = Order_table.Indent_ID where Order_table.Greens_Name = ?  and Indent_table.Indent_Status != '正在支付'");
			pstmt.setString(1,cc);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				aa = rs.getInt(1);
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
		return aa;
	}
	
	
	public List<Indent> findGHfindall(String cc) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table");
			//pstmt.setString(1,Indent_Status);
			
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				if(rs.getString("Indent_QY").contains(cc)){
					String xx = rs.getString("Indent_GH");
					if(xx==null){
						
					}else{
						if( xx.equals("配送完成")){
							indent.setIndent_ID(rs.getInt(1));
							indent.setIndent_Time(rs.getString(2));
							indent.setIndent_Distribution_Time(rs.getString(3));
							indent.setWineshop_ID(rs.getInt(4));
							indent.setWineshop_Address(rs.getString(5));
							indent.setIndent_Fare(rs.getString(6));
							indent.setIndent_Check_Type(rs.getString(7));
							indent.setWineshop_Telephone(rs.getString(8));
							indent.setIndent_Status(rs.getString(9));
							indents.add(indent);
						}else{
					
				}
					}
					
					
					
					
				}
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
		return indents;
	}
	
	public List<Indent> findGH1(String aa,String bb,String cc) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where(Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ? )AND CONVERT(datetime, LEFT(GETDATE(), 10) + ?))");
			//pstmt.setString(1,Indent_Status);
			pstmt.setString(1,aa);
			pstmt.setString(2,bb);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				System.out.println(1);
				Indent indent = new Indent();
				if(rs.getString("Indent_QY").contains(cc)){
					
					String xx = rs.getString("Indent_GH");
					System.out.println(xx);
					if(xx==null){
						if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
							indent.setIndent_ID(rs.getInt(1));
							System.out.println(1);
							indent.setIndent_Time(rs.getString(2));
							indent.setIndent_Distribution_Time(rs.getString(3));
							indent.setWineshop_ID(rs.getInt(4));
							indent.setWineshop_Address(rs.getString(5));
							indent.setIndent_Fare(rs.getString(6));
							indent.setIndent_Check_Type(rs.getString(7));
							indent.setWineshop_Telephone(rs.getString(8));
							indent.setIndent_Status(rs.getString(9));
							indents.add(indent);
							}
					}else{
						if( xx.equals("配送完成")){
						}else{
					if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					indents.add(indent);
					}
				}
					}
					
					
					
					
				}
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
		return indents;
	}
	
	public List<Indent> findGH(String aa,String bb,String cc) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where(Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ? )AND CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00')+1) or (Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00')AND CONVERT(datetime, LEFT(GETDATE(), 10) + ?)) or (Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ?)-1 AND CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00') )   ");
			//pstmt.setString(1,Indent_Status);
			pstmt.setString(1,aa);
			pstmt.setString(2,bb);
			pstmt.setString(3,aa);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				Indent indent = new Indent();
				if(rs.getString("Indent_QY").contains(cc)){
					String xx = rs.getString("Indent_GH");
					if(xx==null){
						if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
							indent.setIndent_ID(rs.getInt(1));
							System.out.println(1);
							indent.setIndent_Time(rs.getString(2));
							indent.setIndent_Distribution_Time(rs.getString(3));
							indent.setWineshop_ID(rs.getInt(4));
							indent.setWineshop_Address(rs.getString(5));
							indent.setIndent_Fare(rs.getString(6));
							indent.setIndent_Check_Type(rs.getString(7));
							indent.setWineshop_Telephone(rs.getString(8));
							indent.setIndent_Status(rs.getString(9));
							indents.add(indent);
							}
					}else{
						if( xx.equals("配送完成")){
						}else{
					if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					indents.add(indent);
					}
				}
					}
					
					
					
					
				}
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
		return indents;
	}
	
	
	public Page getSum44(int currentPage,int size) {
		// TODO 自动生成的方法存根
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select COUNT(*) from Indent_table  where Indent_Status!='正在支付' and Indent_ZZZ != '0'");
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
	public Page getSun44(int currentPage,Page dd,int size) {
		System.out.println("88");
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		System.out.println("88");
		List<TimeIndent> list = new ArrayList<TimeIndent>();   
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Indent_Time desc) as rownumber, Wineshop_table.Wineshop_Name,Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_XXX,Indent_table.Indent_ZZZ,Indent_table.Indent_Status,Indent_table.Indent_Type,Indent_table.Indent_PayID,Indent_table.Wineshop_Address,Indent_table.Wineshop_Telephone,Indent_table.Indent_remark from Wineshop_table inner join Indent_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID where Indent_Status!='正在支付' and Indent_ZZZ != '0') temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			
			System.out.println("55");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while(rs.next()) {
				System.out.println("99");
				TimeIndent ti = new TimeIndent();
				ti.setWineshop_Name(rs.getString("Wineshop_Name"));
				ti.setIndent_ID(rs.getInt("Indent_ID"));
				ti.setIndent_Time(rs.getString("Indent_Time"));
				ti.setIndent_Status(rs.getString("Indent_Status"));
				ti.setIndent_Type(rs.getString("Indent_Type"));
				ti.setIndent_PayID(rs.getString("Indent_PayID"));
				ti.setWineshop_Address(rs.getString("Wineshop_Address"));
				ti.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				ti.setIndent_remark(rs.getString("Indent_remark"));
				ti.setIndent_XXX(rs.getString("Indent_ZZZ"));
				System.out.println(ti+"55");
				list.add(ti);
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
	
	public int zzz(int Wineshop_ID) {
		int aa = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select COUNT(*) from Indent_table where DateDiff(dd,Indent_Time,getdate())=0 and Indent_ZZZ != '0' and Wineshop_ID = ? and Indent_Status!= '正在支付' ");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();
			if(rs.next()!=false) {
				aa = rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return aa;
		
		
	}
	
	public int sum(int Wineshop_ID) {
		int aa = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select SUM(Indent_ZZZ) from Indent_table where Wineshop_ID = ? and Indent_Status != '正在支付' and  DATEDIFF(m, Indent_Time, GETDATE()) =0");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();
			if(rs.next()!=false) {
				aa = rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return aa;
		
		
	}
	
	
	public void add1000(Indent indent) {// 添加信息
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 加载驱动
			conn = DriverManager.getConnection(url, username, pwd);// 连接
			String sql = "insert into Indent_table (Indent_Time,Indent_Distribution_Time,"
					+ "Wineshop_ID,Wineshop_Address,Indent_Fare,Indent_Check_Type,"
					+ "Wineshop_Telephone,Indent_Status,Indent_Type,Indent_PayID,Indent_TuiKuan,Indent_Why,Indent_remark,Indent_PayType,Indent_XXX,Indent_Coupon,Indent_Red,Indent_QY,Indent_ZZZ,Indent_GH) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";// SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getIndent_Time());
			pstmt.setString(2, indent.getIndent_Distribution_Time());
			pstmt.setInt(3, indent.getWineshop_ID());
			pstmt.setString(4, indent.getWineshop_Address());
			pstmt.setString(5, indent.getIndent_Fare());
			pstmt.setString(6, indent.getIndent_Check_Type());
			pstmt.setString(7, indent.getWineshop_Telephone());
			pstmt.setString(8, indent.getIndent_Status());
			pstmt.setString(9, indent.getIndent_Type());
			pstmt.setString(10, indent.getIndent_PayID());
			pstmt.setString(11, indent.getIndent_TuiKuan());
			pstmt.setString(12, indent.getIndent_Why());
			pstmt.setString(13, indent.getIndent_remark());
			pstmt.setString(14, indent.getIndent_PayType());
			pstmt.setString(15, indent.getIndent_XXX());
			pstmt.setInt(16, indent.getIndent_Coupon());
			pstmt.setInt(17, indent.getIndent_Red());
			pstmt.setString(18, indent.getIndent_QY());
			pstmt.setFloat(19, indent.getIndent_ZZZ());
			pstmt.setString(20, indent.getIndent_GH());
			boolean a = pstmt.execute();
			if (!a) {
				System.out.println("添加成功");
			} else
				System.out.println("添加失败");

		} catch (ClassNotFoundException e) {
			System.out.println("注册驱动失败！");
		} catch (SQLException e) {
			System.out.println("连接创建失败！！");// 异常抛出
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

	}
	
	public int Select2(String Indent_PayID) {
		int Wineshop_ID = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_PayID=?");
			pstmt.setString(1, Indent_PayID);
			rs = pstmt.executeQuery();
			if(rs.next()!=false) {
				Wineshop_ID = rs.getInt("Indent_Coupon");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return Wineshop_ID;
		
		
	}
	
	public int Selects(int Wineshop_ID) {
		int aa = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select COUNT(*) from Indent_table where DateDiff(dd,Indent_Time,getdate())=0 and Indent_XXX != 'null' and Wineshop_ID = ? and Indent_Status != '正在支付' ");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();
			if(rs.next()!=false) {
				aa = rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return aa;
		
		
	}
	
	
	public int Select3(String Indent_PayID) {
		int Wineshop_ID = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_PayID=?");
			pstmt.setString(1, Indent_PayID);
			rs = pstmt.executeQuery();
			if(rs.next()!=false) {
				Wineshop_ID = rs.getInt("Indent_Red");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return Wineshop_ID;
		
		
	}

	public int ZZ(int Wineshop_ID) {//查询给酒店的订单数目
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select count(*) from Indent_table where Wineshop_ID = ? and Indent_Status!='正在支付'");
			pstmt1.setInt(1, Wineshop_ID);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				totalNum = rs.getInt(1);
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
		return totalNum;
	}
	
	
	public int ifones(int Wineshop_ID) {// 根据编号查询信息
		int aa = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select count(*) from Indent_table where Wineshop_ID=? and Indent_Status != '正在支付' and DateDiff(dd,Indent_Time,getdate())=0");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
					aa = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return aa;
	}
	
	
	public List<Indent> getUserByCurrentPageapp1(int cc) throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select  * from Indent_table");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int bb = rs.getInt("Wineshop_ID");
				String aa = rs.getString("Indent_Status");
				if (bb == cc) {
					if (aa.contains("已完成")) {

						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Distribution_Time(rs
								.getString("Indent_Distribution_Time"));
						indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
						indent.setWineshop_Address(rs
								.getString("Wineshop_Address"));
						indent.setIndent_Fare(rs.getString("Indent_Fare"));
						indent.setIndent_Check_Type(rs
								.getString("Indent_Check_Type"));
						indent.setWineshop_Telephone(rs
								.getString("Wineshop_Telephone"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						/*
						 * String Indent_ID = rs.getString("Indent_ID"); String
						 * Indent_Time = rs.getString("Indent_Time"); String
						 * Indent_Distribution_Time =
						 * rs.getString("Indent_Distribution_Time"); String
						 * Wineshop_ID = rs.getString("Wineshop_ID"); String
						 * Wineshop_Address = rs.getString("Wineshop_Address");
						 * String Indent_Fare = rs.getString("Indent_Fare");
						 * String Indent_Check_Type =
						 * rs.getString("Indent_Check_Type"); String
						 * Wineshop_Telephone =
						 * rs.getString("Wineshop_Telephone"); String
						 * Indent_Status = rs.getString("Indent_Status");
						 * System.out.println(Indent_ID+Indent_Time);
						 */
						list.add(indent);
					}
				}
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
		return list;
	}
	
	public List<Indent> getUserByCurrentPage() throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select  * from Indent_table");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String aa = rs.getString("Indent_Status");
					if (aa.contains("正在处理")) {
						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Distribution_Time(rs
								.getString("Indent_Distribution_Time"));
						indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
						indent.setWineshop_Address(rs
								.getString("Wineshop_Address"));
						indent.setIndent_Fare(rs.getString("Indent_Fare"));
						indent.setIndent_Check_Type(rs
								.getString("Indent_Check_Type"));
						indent.setWineshop_Telephone(rs
								.getString("Wineshop_Telephone"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						/*
						 * String Indent_ID = rs.getString("Indent_ID"); String
						 * Indent_Time = rs.getString("Indent_Time"); String
						 * Indent_Distribution_Time =
						 * rs.getString("Indent_Distribution_Time"); String
						 * Wineshop_ID = rs.getString("Wineshop_ID"); String
						 * Wineshop_Address = rs.getString("Wineshop_Address");
						 * String Indent_Fare = rs.getString("Indent_Fare");
						 * String Indent_Check_Type =
						 * rs.getString("Indent_Check_Type"); String
						 * Wineshop_Telephone =
						 * rs.getString("Wineshop_Telephone"); String
						 * Indent_Status = rs.getString("Indent_Status");
						 * System.out.println(Indent_ID+Indent_Time);
						 */
						list.add(indent);
					}
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
		return list;
	}
	
	public List<Fenjianwanbi> indentStatuss1(String status) {// 根据编号查询信息
		List<Fenjianwanbi> list = new ArrayList<Fenjianwanbi>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select w.Wineshop_ID,w.Wineshop_Name,w.Wineshop_Address,w.Wineshop_Time,w.Wineshop_Shift_Name,w.Wineshop_Telephone,w.Wineshop_TimeNight,i.Indent_ID,i.Indent_Status,i.Indent_Time from Indent_table i,Wineshop_table w where i.Indent_Status=?");
			pstmt.setString(1, status);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Fenjianwanbi type = new Fenjianwanbi();
				type.setWineshop_ID(rs.getInt("Wineshop_ID"));
				type.setWineshop_Name(rs.getString("Wineshop_Name"));
				type.setWineshop_Address(rs.getString("Wineshop_Address"));
				type.setWineshop_Time(rs.getString("Wineshop_Time"));
				type.setWineshop_Shift_Name(rs.getString("Wineshop_Shift_Name"));
				type.setWIneshop_Telephone(rs.getString("WIneshop_Telephone"));
				type.setWineshop_TimeNight(rs.getString("Wineshop_TimeNight"));
				type.setIndent_ID(rs.getInt("Indent_ID"));
				type.setIndent_Status(rs.getString("Indent_Status"));
				type.setIndent_Time(rs.getString("Indent_Time"));
				list.add(type);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	public List<Fenjianwanbi> indentStatuss3(String Courier_Name,int Courier_BS) {// 根据编号查询信息
		List<Fenjianwanbi> list = new ArrayList<Fenjianwanbi>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select w.Wineshop_ID,w.Wineshop_Name,w.Wineshop_Address,w.Wineshop_Time,w.Wineshop_Shift_Name,w.Wineshop_Telephone,w.Wineshop_TimeNight,i.Indent_ID,i.Indent_Status,i.Indent_Time from Wineshop_table w,Indent_table i where i.Courier_Name =? and i.Courier_BS = ?");
			pstmt.setString(1, Courier_Name);
			pstmt.setInt(2, Courier_BS);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Fenjianwanbi type = new Fenjianwanbi();
				type.setWineshop_ID(rs.getInt("Wineshop_ID"));
				type.setWineshop_Name(rs.getString("Wineshop_Name"));
				type.setWineshop_Address(rs.getString("Wineshop_Address"));
				type.setWineshop_Time(rs.getString("Wineshop_Time"));
				type.setWineshop_Shift_Name(rs.getString("Wineshop_Shift_Name"));
				type.setWIneshop_Telephone(rs.getString("WIneshop_Telephone"));
				type.setWineshop_TimeNight(rs.getString("Wineshop_TimeNight"));
				type.setIndent_ID(rs.getInt("Indent_ID"));
				type.setIndent_Status(rs.getString("Indent_Status"));
				type.setIndent_Time(rs.getString("Indent_Time"));
				list.add(type);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	public List<Fenjianwanbi> indentStatuss2(String status,String Courier_Name,int Courier_BS) {// 根据编号查询信息
		List<Fenjianwanbi> list = new ArrayList<Fenjianwanbi>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select w.Wineshop_ID,w.Wineshop_Name,w.Wineshop_Address,w.Wineshop_Time,w.Wineshop_Shift_Name,w.Wineshop_Telephone,w.Wineshop_TimeNight,i.Indent_ID,i.Indent_Status,i.Indent_Time from Wineshop_table w,Indent_table i where i.Indent_Status=? and i.Courier_Name=? and i.Courier_BS = ?");
			pstmt.setString(1, status);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Fenjianwanbi type = new Fenjianwanbi();
				type.setWineshop_ID(rs.getInt("Wineshop_ID"));
				type.setWineshop_Name(rs.getString("Wineshop_Name"));
				type.setWineshop_Address(rs.getString("Wineshop_Address"));
				type.setWineshop_Time(rs.getString("Wineshop_Time"));
				type.setWineshop_Shift_Name(rs.getString("Wineshop_Shift_Name"));
				type.setWIneshop_Telephone(rs.getString("WIneshop_Telephone"));
				type.setWineshop_TimeNight(rs.getString("Wineshop_TimeNight"));
				type.setIndent_ID(rs.getInt("Indent_ID"));
				type.setIndent_Status(rs.getString("Indent_Status"));
				type.setIndent_Time(rs.getString("Indent_Time"));
				list.add(type);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	
	
	public List<Fenjianwanbi> indentStatus(int cid) {// 根据编号查询信息
		List<Fenjianwanbi> list = new ArrayList<Fenjianwanbi>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String status = StaticFinal.FENJIANWANBI;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select c.Courier_ID,c.Courier_Name,w.Wineshop_ID,w.Wineshop_Name,w.Wineshop_Address,w.Wineshop_Time,w.Wineshop_Shift_Name,w.Wineshop_Telephone,w.Wineshop_TimeNight,i.Indent_ID,i.Indent_Status,i.Indent_Time from Courier_table c,Courier_Wineshop_table cw,Wineshop_table w,Indent_table i where c.Courier_ID=cw.Courier_ID and c.Courier_ID=? and cw.Allot=w.Wineshop_Name and w.Wineshop_ID=i.Wineshop_ID and i.Indent_Status=?");
			pstmt.setInt(1, cid);
			pstmt.setString(2, status);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Fenjianwanbi type = new Fenjianwanbi();
				type.setCourier_ID(rs.getInt("Courier_ID"));
				type.setCourier_Name(rs.getString("Courier_Name"));
				type.setWineshop_ID(rs.getInt("Wineshop_ID"));
				type.setWineshop_Name(rs.getString("Wineshop_Name"));
				type.setWineshop_Address(rs.getString("Wineshop_Address"));
				type.setWineshop_Time(rs.getString("Wineshop_Time"));
				type.setWineshop_Shift_Name(rs.getString("Wineshop_Shift_Name"));
				type.setWIneshop_Telephone(rs.getString("WIneshop_Telephone"));
				type.setWineshop_TimeNight(rs.getString("Wineshop_TimeNight"));
				type.setIndent_ID(rs.getInt("Indent_ID"));
				type.setIndent_Status(rs.getString("Indent_Status"));
				type.setIndent_Time(rs.getString("Indent_Time"));
				list.add(type);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	public List<Indent> findNumber(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("正在处理")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	public List<Indent> findNumber1(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("正在分拣")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	public List<Indent> findNumber2(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("分拣完毕等待快递员接收")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	public int updatess1(Indent indent){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Indent_table set FJ_Name=?,FJ_BS=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getFZ_Name());
			pstmt.setInt(2, indent.getFZ_BS());
			pstmt.setInt(3, indent.getIndent_ID());
			
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
	
	public int updateGH(int Indent_ID){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("update Indent_table set Indent_GH=? where Indent_ID=?");
			pstmt.setInt(2, Indent_ID);
			pstmt.setString(1, "配送完成");
			System.out.println(Indent_ID);
			boolean b=pstmt.execute();
			System.out.println(b);
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
	
	public int updatessZZ(Indent indent){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Indent_table set Courier_Name=?,Courier_BS=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getCourier_Name());
			pstmt.setInt(2, indent.getCourier_BS());
			pstmt.setInt(3, indent.getIndent_ID());
			
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
	
	public int updatess2(Indent indent){//更新
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Indent_table set FJ_BS=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, indent.getFZ_BS());
			pstmt.setInt(2, indent.getIndent_ID());
			
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
	
	
	public List<Indent> findNumber3(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("配送中")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	public int findFZ1(String FZ_Name) {// 根据编号查询信息
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int a = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where FJ_Name=?");
			pstmt.setString(1, FZ_Name);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				String type = rs.getString(9);
				if (type.contains("正在分拣")) {
				a = rs.getInt("Indent_ID");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return a;
	}
	
	public String findFZ0(int Indent_ID) {// 根据编号查询信息
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String a = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_ID=?");
			pstmt.setInt(1, Indent_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				a = rs.getString("FJ_Name");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return a;
	}
	
	public float za(int Indent_ID) {// 根据编号查询信息
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		float a = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_ID=?");
			pstmt.setInt(1, Indent_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				a = rs.getFloat("Indent_ZZZ");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return a;
	}
	
	public String findZZ0(int Indent_ID) {// 根据编号查询信息
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String a = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_ID=?");
			pstmt.setInt(1, Indent_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				a = rs.getString("Courier_Name");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return a;
	}
	
	
	public List<Indent> findFZ2(String FJ_Name) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where FJ_Name=?");
			pstmt.setString(1, FJ_Name);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				String type = rs.getString(9);
				if (type.contains("正在分拣")) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indent.setFZ_Name(rs.getString(10));
				indent.setFZ_BS(rs.getInt(11));
				list.add(indent);
			}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	public List<Indent> findZZ2(String Courier_Name) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Courier_Name=?");
			pstmt.setString(1, Courier_Name);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				String type = rs.getString(9);
				if (type.contains("分拣完毕等待快递员接收")) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indent.setFZ_Name(rs.getString(10));
				indent.setFZ_BS(rs.getInt(11));
				list.add(indent);
			}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	public List<Indent> findFZ3(String FZ_Name) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where FJ_Name=?");
			pstmt.setString(1, FZ_Name);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indent.setFZ_Name(rs.getString(10));
				indent.setFZ_BS(rs.getInt(11));
				list.add(indent);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	public List<Indent> findUserByIDtype() {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("正在处理")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	public List<Indent> findUserByIDtype1() {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("正在分拣")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	public List<Indent> findUserByID11(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=? order by Indent_Time desc");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("分拣完毕等待快递员接收")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID12() {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table");

			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("正在分拣")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID66(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("配送中")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> I_Numberfindall() {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("配送中")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID1(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Wineshop_ID=? order by Indent_Time desc");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("已完成")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID67(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("已完成")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID12(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("配送中")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public void update(Indent indent) {// 更新
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set "
					+ "Indent_Distribution_Time=?,Wineshop_ID=?,Wineshop_Address=?,"
					+ "Wineshop_Telephone=?,"
					+ "Indent_Status=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, indent.getIndent_Distribution_Time());
			pstmt.setInt(2, indent.getWineshop_ID());
			pstmt.setString(3, indent.getWineshop_Address());

			pstmt.setString(4, indent.getWineshop_Telephone());
			pstmt.setString(5, indent.getIndent_Status());
			pstmt.setInt(6, indent.getIndent_ID());

			boolean y = pstmt.execute();
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
	}

	public Integer getAllRowsAmount() throws Exception {
		// TODO 自动生成的方法存根

		// 查询表的所有信息

		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Indent indent = new Indent();

				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indents.add(indent);
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
		return indents.size();

	}
	public Integer getAllRowsAmountss(int Wineshop_ID) throws Exception {
		// TODO 自动生成的方法存根

		// 查询表的所有信息
		int aa = 0;
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select count(*) from Indent_table where Wineshop_ID = ? ");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				aa = rs.getInt(1);
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
		return aa;
	}

	public List<Indent> getUserByCurrentPage(Integer currentPageStartRow,// 从多少行到多少行
			Integer pageSize) throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select top (?-?+1) * from Indent_table where Indent_ID not in (select top (?-1) Indent_ID from Indent_table)");
			pstmt1.setInt(1, pageSize);
			pstmt1.setInt(2, currentPageStartRow);
			pstmt1.setInt(3, currentPageStartRow);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt("Indent_ID"));
				indent.setIndent_Time(rs.getString("Indent_Time"));
				indent.setIndent_Distribution_Time(rs
						.getString("Indent_Distribution_Time"));
				indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
				indent.setWineshop_Address(rs.getString("Wineshop_Address"));
				indent.setIndent_Fare(rs.getString("Indent_Fare"));
				indent.setIndent_Check_Type(rs.getString("Indent_Check_Type"));
				indent.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				indent.setIndent_Status(rs.getString("Indent_Status"));
				/*
				 * String Indent_ID = rs.getString("Indent_ID"); String
				 * Indent_Time = rs.getString("Indent_Time"); String
				 * Indent_Distribution_Time =
				 * rs.getString("Indent_Distribution_Time"); String Wineshop_ID
				 * = rs.getString("Wineshop_ID"); String Wineshop_Address =
				 * rs.getString("Wineshop_Address"); String Indent_Fare =
				 * rs.getString("Indent_Fare"); String Indent_Check_Type =
				 * rs.getString("Indent_Check_Type"); String Wineshop_Telephone
				 * = rs.getString("Wineshop_Telephone"); String Indent_Status =
				 * rs.getString("Indent_Status");
				 * System.out.println(Indent_ID+Indent_Time);
				 */
				list.add(indent);
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
		return list;
	}

	public List<Indent> getUserByCurrentPage1(int aa) throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select  * from Indent_table ");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int bb = rs.getInt("Wineshop_ID");
				String cc = rs.getString("Indent_Status");
				if (aa == bb) {
					if (cc.contains("配送中")) {
						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Distribution_Time(rs
								.getString("Indent_Distribution_Time"));
						indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
						indent.setWineshop_Address(rs
								.getString("Wineshop_Address"));
						indent.setIndent_Fare(rs.getString("Indent_Fare"));
						indent.setIndent_Check_Type(rs
								.getString("Indent_Check_Type"));
						indent.setWineshop_Telephone(rs
								.getString("Wineshop_Telephone"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						/*
						 * String Indent_ID = rs.getString("Indent_ID"); String
						 * Indent_Time = rs.getString("Indent_Time"); String
						 * Indent_Distribution_Time =
						 * rs.getString("Indent_Distribution_Time"); String
						 * Wineshop_ID = rs.getString("Wineshop_ID"); String
						 * Wineshop_Address = rs.getString("Wineshop_Address");
						 * String Indent_Fare = rs.getString("Indent_Fare");
						 * String Indent_Check_Type =
						 * rs.getString("Indent_Check_Type"); String
						 * Wineshop_Telephone =
						 * rs.getString("Wineshop_Telephone"); String
						 * Indent_Status = rs.getString("Indent_Status");
						 * System.out.println(Indent_ID+Indent_Time);
						 */
						list.add(indent);
					}
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage2(String zz, String xx, int aa)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int bb = rs.getInt("Wineshop_ID");
				String cc = rs.getString("Indent_Status");
				if (aa == bb) {
					if (cc.contains("配送中")) {
						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Distribution_Time(rs
								.getString("Indent_Distribution_Time"));
						indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
						indent.setWineshop_Address(rs
								.getString("Wineshop_Address"));
						indent.setIndent_Fare(rs.getString("Indent_Fare"));
						indent.setIndent_Check_Type(rs
								.getString("Indent_Check_Type"));
						indent.setWineshop_Telephone(rs
								.getString("Wineshop_Telephone"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						/*
						 * String Indent_ID = rs.getString("Indent_ID"); String
						 * Indent_Time = rs.getString("Indent_Time"); String
						 * Indent_Distribution_Time =
						 * rs.getString("Indent_Distribution_Time"); String
						 * Wineshop_ID = rs.getString("Wineshop_ID"); String
						 * Wineshop_Address = rs.getString("Wineshop_Address");
						 * String Indent_Fare = rs.getString("Indent_Fare");
						 * String Indent_Check_Type =
						 * rs.getString("Indent_Check_Type"); String
						 * Wineshop_Telephone =
						 * rs.getString("Wineshop_Telephone"); String
						 * Indent_Status = rs.getString("Indent_Status");
						 * System.out.println(Indent_ID+Indent_Time);
						 */
						list.add(indent);
					}
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage3(String zz, String xx, int aa)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int bb = rs.getInt("Wineshop_ID");
				String cc = rs.getString("Indent_Status");
				if (aa == bb) {
					if (cc.contains("正在处理")) {

						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Distribution_Time(rs
								.getString("Indent_Distribution_Time"));
						indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
						indent.setWineshop_Address(rs
								.getString("Wineshop_Address"));
						indent.setIndent_Fare(rs.getString("Indent_Fare"));
						indent.setIndent_Check_Type(rs
								.getString("Indent_Check_Type"));
						indent.setWineshop_Telephone(rs
								.getString("Wineshop_Telephone"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						/*
						 * String Indent_ID = rs.getString("Indent_ID"); String
						 * Indent_Time = rs.getString("Indent_Time"); String
						 * Indent_Distribution_Time =
						 * rs.getString("Indent_Distribution_Time"); String
						 * Wineshop_ID = rs.getString("Wineshop_ID"); String
						 * Wineshop_Address = rs.getString("Wineshop_Address");
						 * String Indent_Fare = rs.getString("Indent_Fare");
						 * String Indent_Check_Type =
						 * rs.getString("Indent_Check_Type"); String
						 * Wineshop_Telephone =
						 * rs.getString("Wineshop_Telephone"); String
						 * Indent_Status = rs.getString("Indent_Status");
						 * System.out.println(Indent_ID+Indent_Time);
						 */
						list.add(indent);
					}
				}
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
		return list;
	}

	public Indent delete(int Indent_ID) {// 删除
		Indent indent = new Indent();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "delete * from  Indent_table where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, indent.getIndent_ID());
			pstmt.executeUpdate(sql);
			boolean o = pstmt.execute();
			if (!o) {
				System.out.println("输出成功");
			} else
				System.out.println("输出失败");
		} catch (ClassNotFoundException e) {
			System.out.println("注册驱动失败！");
		} catch (SQLException e) {
			System.out.println("连接创建失败！！");
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
		return indent;
	}

	public List<Indent> findUserByID(int Indent_ID) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Indent_ID=?");
			pstmt.setInt(1, Indent_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			if (rs.next() != false) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indent.setCourier_Name(rs.getString("Courier_Name"));
				indent.setIndent_remark(rs.getString("Indent_remark"));
				indent.setIndent_PayType(rs.getString("Indent_PayType"));
				indent.setIndent_PayID(rs.getString("Indent_PayID"));
				indents.add(indent);
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
		return indents;
	}

	public void add(Indent indent) {// 添加信息
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 加载驱动
			conn = DriverManager.getConnection(url, username, pwd);// 连接
			String sql = "insert into Indent_table (Indent_Time,Indent_Distribution_Time,"
					+ "Wineshop_ID,Wineshop_Address,Indent_Fare,Indent_Check_Type,"
					+ "Wineshop_Telephone,Indent_Status) values(?,?,?,?,?,?,?,?)";// SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getIndent_Time());
			pstmt.setString(2, indent.getIndent_Distribution_Time());
			pstmt.setInt(3, indent.getWineshop_ID());
			pstmt.setString(4, indent.getWineshop_Address());
			pstmt.setString(5, indent.getIndent_Fare());
			pstmt.setString(6, indent.getIndent_Check_Type());
			pstmt.setString(7, indent.getWineshop_Telephone());
			pstmt.setString(8, indent.getIndent_Status());

			boolean a = pstmt.execute();
			if (!a) {
				System.out.println("添加成功");
			} else
				System.out.println("添加失败");

		} catch (ClassNotFoundException e) {
			System.out.println("注册驱动失败！");
		} catch (SQLException e) {
			System.out.println("连接创建失败！！");// 异常抛出
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

	}

	public int findID(int id) {
		int c = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select top 1 * from Indent_table where Wineshop_ID=? order by Indent_ID desc");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				c = rs.getInt(1);
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
		return c;
	}

	public List<Indent> findAll() {// 查询表的所有信息

		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Indent indent = new Indent();

				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indents.add(indent);
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
		return indents;
	}

	public void update1(Indent indent) {// 更新
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Indent_Status=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, indent.getIndent_Status());
			pstmt.setInt(2, indent.getIndent_ID());

			boolean y = pstmt.execute();
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
	}
	public void update2(Indent indent) {// 更新
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Indent_Check_Type=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getIndent_Check_Type());
			pstmt.setInt(2, indent.getIndent_ID());
			boolean y = pstmt.execute();
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
	}
	public void update3(Indent indent) {// 更新
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Indent_Check_Type=? where Indent_ID=? and Wineshop_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getIndent_Check_Type());
			pstmt.setInt(2, indent.getIndent_ID());
			pstmt.setInt(3, indent.getWineshop_ID());
			boolean y = pstmt.execute();
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
	}
	public List<Indent> findUserByID2(String Indent_Status) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Indent_Status=?");
			pstmt.setString(1, Indent_Status);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indents.add(indent);
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
		return indents;
	}
	
	public List<Indent> findUserByIDsss(String Indent_Status,String aa,String bb) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where(Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ? )AND CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00')+1) or (Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00')AND CONVERT(datetime, LEFT(GETDATE(), 10) + ?)) or (Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ?)-1 AND CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00'))  ");
			//pstmt.setString(1,Indent_Status);
			pstmt.setString(1,aa);
			pstmt.setString(2,bb);
			pstmt.setString(3,aa);
			
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				if(rs.getString("Indent_Status").contains(Indent_Status)){
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indents.add(indent);
				}
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
		return indents;
	}
	
	public List<Indent> findUserByID22(String Indent_Status) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Indent_Status=?");
			pstmt.setString(1, Indent_Status);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indent.setFZ_Name(rs.getString(10));
				indent.setFZ_BS(rs.getInt(11));
				indents.add(indent);
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
		return indents;
	}
	
	

	public List<Indent> findUserByID20(int a, int b, int c) {// 代表从a到吧的数据：a=c
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select top (?-?+1) * from Indent_table where Indent_ID not in (select top (?-1) Indent_ID from Indent_table)");
			pstmt.setInt(1, b);
			pstmt.setInt(2, a);
			pstmt.setInt(3, c);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt("Indent_ID"));
				indent.setIndent_Time(rs.getString("Indent_Time"));
				indent.setIndent_Distribution_Time(rs
						.getString("Indent_Distribution_Time"));
				indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
				indent.setWineshop_Address(rs.getString("Wineshop_Address"));
				indent.setIndent_Fare(rs.getString("Indent_Fare"));
				indent.setIndent_Check_Type(rs.getString("Indent_Check_Type"));
				indent.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				indent.setIndent_Status(rs.getString("Indent_Status"));
				/*
				 * String Indent_ID = rs.getString("Indent_ID"); String
				 * Indent_Time = rs.getString("Indent_Time"); String
				 * Indent_Distribution_Time =
				 * rs.getString("Indent_Distribution_Time"); String Wineshop_ID
				 * = rs.getString("Wineshop_ID"); String Wineshop_Address =
				 * rs.getString("Wineshop_Address"); String Indent_Fare =
				 * rs.getString("Indent_Fare"); String Indent_Check_Type =
				 * rs.getString("Indent_Check_Type"); String Wineshop_Telephone
				 * = rs.getString("Wineshop_Telephone"); String Indent_Status =
				 * rs.getString("Indent_Status");
				 * System.out.println(Indent_ID+Indent_Time);
				 */
				list.add(indent);
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
		return list;
	}
	
	public List<Indent> findUserByID5(String a, String b) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Indent_Time between ? and ?");
			pstmt.setString(1, a);
			pstmt.setString(2, b);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				indents.add(indent);
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
		return indents;
	}

	public List<Indent> findUserByID666(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("正在处理")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID667(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("正在分拣")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID10(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=?  order by Indent_Time desc");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				if(rs.getString("Indent_Status").contains("正在支付")){
					
				}else{
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID668(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("分拣完毕等待快递员接收")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID669(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("配送中")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID670(int Wineshop_ID) {// 根据编号查询信息
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=?");
			pstmt.setInt(1, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String type = rs.getString(9);
				if (type.contains("已完成")) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	public List<Indent> findNumberJiaobiao(int Wineshop_ID,String Indent_Check_Type,String Indent_Status) {
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where Wineshop_ID=? and Indent_Check_Type=? and Indent_Status=?");
			pstmt.setInt(1, Wineshop_ID);
			pstmt.setString(2, Indent_Check_Type);
			pstmt.setString(3, Indent_Status);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				list.add(indent);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	public List<Indent> findUserByID0() {// 查询当天记录
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where DateDiff(dd,Indent_Time,getdate())=0");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				list.add(indent);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID00(int aa) {// 查询当天记录
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where DateDiff(dd,Indent_Time,getdate())=0 and Indent_table.Indent_Status!='正在支付'");
			
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int cc = rs.getInt(4);
				if (aa == cc) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByIDweek() {// 周查询
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where DateDiff(week,Indent_Time,getdate())=0");
			
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();

				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				list.add(indent);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByIDmonth() {// 月查询
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where DateDiff(month,Indent_Time,getdate())=0");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();

				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				list.add(indent);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByIDyear() {// 周查询
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where DateDiff(year,Indent_Time,getdate())=0");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();

				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				list.add(indent);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByIDweek1(int aa) {// 周查询
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where DateDiff(week,Indent_Time,getdate())=0 and Indent_table.Indent_Status!='正在支付'");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int cc = rs.getInt(4);
				if (aa == cc) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByIDmonth1(int aa) {// 月查询
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where DateDiff(month,Indent_Time,getdate())=0 and Indent_table.Indent_Status!='正在支付'");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int cc = rs.getInt(4);
				if (aa == cc) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByIDyear1(int aa) {// 年查询
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn
					.prepareStatement("select * from Indent_table where DateDiff(year,Indent_Time,getdate())=0 and Indent_table.Indent_Status!='正在支付'");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int cc = rs.getInt(4);
				if (aa == cc) {
					indent.setIndent_ID(rs.getInt(1));
					indent.setIndent_Time(rs.getString(2));
					indent.setWineshop_ID(rs.getInt(4));
					indent.setIndent_Distribution_Time(rs.getString(3));
					indent.setWineshop_Address(rs.getString(5));
					indent.setIndent_Fare(rs.getString(6));
					indent.setIndent_Check_Type(rs.getString(7));
					indent.setWineshop_Telephone(rs.getString(8));
					indent.setIndent_Status(rs.getString(9));
					list.add(indent);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> findUserByID100() {// 周查询
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where ");
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				list.add(indent);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

	public List<Indent> getUserByCurrentPage4(String zz, String xx, int aa)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int bb = rs.getInt("Wineshop_ID");
				String cc = rs.getString("Indent_Status");
				if (aa == bb) {
					if (cc.contains("正在分拣")) {

						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Distribution_Time(rs
								.getString("Indent_Distribution_Time"));
						indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
						indent.setWineshop_Address(rs
								.getString("Wineshop_Address"));
						indent.setIndent_Fare(rs.getString("Indent_Fare"));
						indent.setIndent_Check_Type(rs
								.getString("Indent_Check_Type"));
						indent.setWineshop_Telephone(rs
								.getString("Wineshop_Telephone"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						/*
						 * String Indent_ID = rs.getString("Indent_ID"); String
						 * Indent_Time = rs.getString("Indent_Time"); String
						 * Indent_Distribution_Time =
						 * rs.getString("Indent_Distribution_Time"); String
						 * Wineshop_ID = rs.getString("Wineshop_ID"); String
						 * Wineshop_Address = rs.getString("Wineshop_Address");
						 * String Indent_Fare = rs.getString("Indent_Fare");
						 * String Indent_Check_Type =
						 * rs.getString("Indent_Check_Type"); String
						 * Wineshop_Telephone =
						 * rs.getString("Wineshop_Telephone"); String
						 * Indent_Status = rs.getString("Indent_Status");
						 * System.out.println(Indent_ID+Indent_Time);
						 */
						list.add(indent);
					}
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage5(String zz, String xx, int aa)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int bb = rs.getInt("Wineshop_ID");
				String cc = rs.getString("Indent_Status");
				if (aa == bb) {
					if (cc.contains("已完成")) {

						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Distribution_Time(rs
								.getString("Indent_Distribution_Time"));
						indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
						indent.setWineshop_Address(rs
								.getString("Wineshop_Address"));
						indent.setIndent_Fare(rs.getString("Indent_Fare"));
						indent.setIndent_Check_Type(rs
								.getString("Indent_Check_Type"));
						indent.setWineshop_Telephone(rs
								.getString("Wineshop_Telephone"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						/*
						 * String Indent_ID = rs.getString("Indent_ID"); String
						 * Indent_Time = rs.getString("Indent_Time"); String
						 * Indent_Distribution_Time =
						 * rs.getString("Indent_Distribution_Time"); String
						 * Wineshop_ID = rs.getString("Wineshop_ID"); String
						 * Wineshop_Address = rs.getString("Wineshop_Address");
						 * String Indent_Fare = rs.getString("Indent_Fare");
						 * String Indent_Check_Type =
						 * rs.getString("Indent_Check_Type"); String
						 * Wineshop_Telephone =
						 * rs.getString("Wineshop_Telephone"); String
						 * Indent_Status = rs.getString("Indent_Status");
						 * System.out.println(Indent_ID+Indent_Time);
						 */
						list.add(indent);
					}
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage6(String zz, String xx, int aa)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int bb = rs.getInt("Wineshop_ID");
				String cc = rs.getString("Indent_Status");
				if (aa == bb) {
					if (cc.contains("分拣完毕等待快递员接收")) {

						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Distribution_Time(rs
								.getString("Indent_Distribution_Time"));
						indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
						indent.setWineshop_Address(rs
								.getString("Wineshop_Address"));
						indent.setIndent_Fare(rs.getString("Indent_Fare"));
						indent.setIndent_Check_Type(rs
								.getString("Indent_Check_Type"));
						indent.setWineshop_Telephone(rs
								.getString("Wineshop_Telephone"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						/*
						 * String Indent_ID = rs.getString("Indent_ID"); String
						 * Indent_Time = rs.getString("Indent_Time"); String
						 * Indent_Distribution_Time =
						 * rs.getString("Indent_Distribution_Time"); String
						 * Wineshop_ID = rs.getString("Wineshop_ID"); String
						 * Wineshop_Address = rs.getString("Wineshop_Address");
						 * String Indent_Fare = rs.getString("Indent_Fare");
						 * String Indent_Check_Type =
						 * rs.getString("Indent_Check_Type"); String
						 * Wineshop_Telephone =
						 * rs.getString("Wineshop_Telephone"); String
						 * Indent_Status = rs.getString("Indent_Status");
						 * System.out.println(Indent_ID+Indent_Time);
						 */
						list.add(indent);
					}
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage10(String zz, String xx)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String cc = rs.getString("Indent_Status");
				if (cc.contains("正在处理")) {

					indent.setIndent_ID(rs.getInt("Indent_ID"));
					indent.setIndent_Time(rs.getString("Indent_Time"));
					indent.setIndent_Distribution_Time(rs
							.getString("Indent_Distribution_Time"));
					indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
					indent.setWineshop_Address(rs.getString("Wineshop_Address"));
					indent.setIndent_Fare(rs.getString("Indent_Fare"));
					indent.setIndent_Check_Type(rs
							.getString("Indent_Check_Type"));
					indent.setWineshop_Telephone(rs
							.getString("Wineshop_Telephone"));
					indent.setIndent_Status(rs.getString("Indent_Status"));
					/*
					 * String Indent_ID = rs.getString("Indent_ID"); String
					 * Indent_Time = rs.getString("Indent_Time"); String
					 * Indent_Distribution_Time =
					 * rs.getString("Indent_Distribution_Time"); String
					 * Wineshop_ID = rs.getString("Wineshop_ID"); String
					 * Wineshop_Address = rs.getString("Wineshop_Address");
					 * String Indent_Fare = rs.getString("Indent_Fare"); String
					 * Indent_Check_Type = rs.getString("Indent_Check_Type");
					 * String Wineshop_Telephone =
					 * rs.getString("Wineshop_Telephone"); String Indent_Status
					 * = rs.getString("Indent_Status");
					 * System.out.println(Indent_ID+Indent_Time);
					 */
					list.add(indent);
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage11(String zz, String xx)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String cc = rs.getString("Indent_Status");
				if (cc.contains("正在分拣")) {

					indent.setIndent_ID(rs.getInt("Indent_ID"));
					indent.setIndent_Time(rs.getString("Indent_Time"));
					indent.setIndent_Distribution_Time(rs
							.getString("Indent_Distribution_Time"));
					indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
					indent.setWineshop_Address(rs.getString("Wineshop_Address"));
					indent.setIndent_Fare(rs.getString("Indent_Fare"));
					indent.setIndent_Check_Type(rs
							.getString("Indent_Check_Type"));
					indent.setWineshop_Telephone(rs
							.getString("Wineshop_Telephone"));
					indent.setIndent_Status(rs.getString("Indent_Status"));
					/*
					 * String Indent_ID = rs.getString("Indent_ID"); String
					 * Indent_Time = rs.getString("Indent_Time"); String
					 * Indent_Distribution_Time =
					 * rs.getString("Indent_Distribution_Time"); String
					 * Wineshop_ID = rs.getString("Wineshop_ID"); String
					 * Wineshop_Address = rs.getString("Wineshop_Address");
					 * String Indent_Fare = rs.getString("Indent_Fare"); String
					 * Indent_Check_Type = rs.getString("Indent_Check_Type");
					 * String Wineshop_Telephone =
					 * rs.getString("Wineshop_Telephone"); String Indent_Status
					 * = rs.getString("Indent_Status");
					 * System.out.println(Indent_ID+Indent_Time);
					 */
					list.add(indent);
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage12(String zz, String xx)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String cc = rs.getString("Indent_Status");
				if (cc.contains("配送中")) {

					indent.setIndent_ID(rs.getInt("Indent_ID"));
					indent.setIndent_Time(rs.getString("Indent_Time"));
					indent.setIndent_Distribution_Time(rs
							.getString("Indent_Distribution_Time"));
					indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
					indent.setWineshop_Address(rs.getString("Wineshop_Address"));
					indent.setIndent_Fare(rs.getString("Indent_Fare"));
					indent.setIndent_Check_Type(rs
							.getString("Indent_Check_Type"));
					indent.setWineshop_Telephone(rs
							.getString("Wineshop_Telephone"));
					indent.setIndent_Status(rs.getString("Indent_Status"));
					/*
					 * String Indent_ID = rs.getString("Indent_ID"); String
					 * Indent_Time = rs.getString("Indent_Time"); String
					 * Indent_Distribution_Time =
					 * rs.getString("Indent_Distribution_Time"); String
					 * Wineshop_ID = rs.getString("Wineshop_ID"); String
					 * Wineshop_Address = rs.getString("Wineshop_Address");
					 * String Indent_Fare = rs.getString("Indent_Fare"); String
					 * Indent_Check_Type = rs.getString("Indent_Check_Type");
					 * String Wineshop_Telephone =
					 * rs.getString("Wineshop_Telephone"); String Indent_Status
					 * = rs.getString("Indent_Status");
					 * System.out.println(Indent_ID+Indent_Time);
					 */
					list.add(indent);
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage13(String zz, String xx)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String cc = rs.getString("Indent_Status");
				if (cc.contains("已完成")) {

					indent.setIndent_ID(rs.getInt("Indent_ID"));
					indent.setIndent_Time(rs.getString("Indent_Time"));
					indent.setIndent_Distribution_Time(rs
							.getString("Indent_Distribution_Time"));
					indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
					indent.setWineshop_Address(rs.getString("Wineshop_Address"));
					indent.setIndent_Fare(rs.getString("Indent_Fare"));
					indent.setIndent_Check_Type(rs
							.getString("Indent_Check_Type"));
					indent.setWineshop_Telephone(rs
							.getString("Wineshop_Telephone"));
					indent.setIndent_Status(rs.getString("Indent_Status"));
					/*
					 * String Indent_ID = rs.getString("Indent_ID"); String
					 * Indent_Time = rs.getString("Indent_Time"); String
					 * Indent_Distribution_Time =
					 * rs.getString("Indent_Distribution_Time"); String
					 * Wineshop_ID = rs.getString("Wineshop_ID"); String
					 * Wineshop_Address = rs.getString("Wineshop_Address");
					 * String Indent_Fare = rs.getString("Indent_Fare"); String
					 * Indent_Check_Type = rs.getString("Indent_Check_Type");
					 * String Wineshop_Telephone =
					 * rs.getString("Wineshop_Telephone"); String Indent_Status
					 * = rs.getString("Indent_Status");
					 * System.out.println(Indent_ID+Indent_Time);
					 */
					list.add(indent);
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage14(String zz, String xx)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String cc = rs.getString("Indent_Status");
				if (cc.contains("分拣完毕等待快递员接收")) {

					indent.setIndent_ID(rs.getInt("Indent_ID"));
					indent.setIndent_Time(rs.getString("Indent_Time"));
					indent.setIndent_Distribution_Time(rs
							.getString("Indent_Distribution_Time"));
					indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
					indent.setWineshop_Address(rs.getString("Wineshop_Address"));
					indent.setIndent_Fare(rs.getString("Indent_Fare"));
					indent.setIndent_Check_Type(rs
							.getString("Indent_Check_Type"));
					indent.setWineshop_Telephone(rs
							.getString("Wineshop_Telephone"));
					indent.setIndent_Status(rs.getString("Indent_Status"));
					/*
					 * String Indent_ID = rs.getString("Indent_ID"); String
					 * Indent_Time = rs.getString("Indent_Time"); String
					 * Indent_Distribution_Time =
					 * rs.getString("Indent_Distribution_Time"); String
					 * Wineshop_ID = rs.getString("Wineshop_ID"); String
					 * Wineshop_Address = rs.getString("Wineshop_Address");
					 * String Indent_Fare = rs.getString("Indent_Fare"); String
					 * Indent_Check_Type = rs.getString("Indent_Check_Type");
					 * String Wineshop_Telephone =
					 * rs.getString("Wineshop_Telephone"); String Indent_Status
					 * = rs.getString("Indent_Status");
					 * System.out.println(Indent_ID+Indent_Time);
					 */
					list.add(indent);
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage15() throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select  * from Indent_table ");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String cc = rs.getString("Indent_Status");
				if (cc.contains("正在处理")) {

					indent.setIndent_ID(rs.getInt("Indent_ID"));
					indent.setIndent_Time(rs.getString("Indent_Time"));
					indent.setIndent_Distribution_Time(rs
							.getString("Indent_Distribution_Time"));
					indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
					indent.setWineshop_Address(rs.getString("Wineshop_Address"));
					indent.setIndent_Fare(rs.getString("Indent_Fare"));
					indent.setIndent_Check_Type(rs
							.getString("Indent_Check_Type"));
					indent.setWineshop_Telephone(rs
							.getString("Wineshop_Telephone"));
					indent.setIndent_Status(rs.getString("Indent_Status"));
					/*
					 * String Indent_ID = rs.getString("Indent_ID"); String
					 * Indent_Time = rs.getString("Indent_Time"); String
					 * Indent_Distribution_Time =
					 * rs.getString("Indent_Distribution_Time"); String
					 * Wineshop_ID = rs.getString("Wineshop_ID"); String
					 * Wineshop_Address = rs.getString("Wineshop_Address");
					 * String Indent_Fare = rs.getString("Indent_Fare"); String
					 * Indent_Check_Type = rs.getString("Indent_Check_Type");
					 * String Wineshop_Telephone =
					 * rs.getString("Wineshop_Telephone"); String Indent_Status
					 * = rs.getString("Indent_Status");
					 * System.out.println(Indent_ID+Indent_Time);
					 */
					list.add(indent);
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage16() throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select  * from Indent_table ");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				String cc = rs.getString("Indent_Status");
				if (cc.contains("正在分拣")) {

					indent.setIndent_ID(rs.getInt("Indent_ID"));
					indent.setIndent_Time(rs.getString("Indent_Time"));
					indent.setIndent_Distribution_Time(rs
							.getString("Indent_Distribution_Time"));
					indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
					indent.setWineshop_Address(rs.getString("Wineshop_Address"));
					indent.setIndent_Fare(rs.getString("Indent_Fare"));
					indent.setIndent_Check_Type(rs
							.getString("Indent_Check_Type"));
					indent.setWineshop_Telephone(rs
							.getString("Wineshop_Telephone"));
					indent.setIndent_Status(rs.getString("Indent_Status"));
					/*
					 * String Indent_ID = rs.getString("Indent_ID"); String
					 * Indent_Time = rs.getString("Indent_Time"); String
					 * Indent_Distribution_Time =
					 * rs.getString("Indent_Distribution_Time"); String
					 * Wineshop_ID = rs.getString("Wineshop_ID"); String
					 * Wineshop_Address = rs.getString("Wineshop_Address");
					 * String Indent_Fare = rs.getString("Indent_Fare"); String
					 * Indent_Check_Type = rs.getString("Indent_Check_Type");
					 * String Wineshop_Telephone =
					 * rs.getString("Wineshop_Telephone"); String Indent_Status
					 * = rs.getString("Indent_Status");
					 * System.out.println(Indent_ID+Indent_Time);
					 */
					list.add(indent);
				}
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
		return list;
	}

	public List<Indent> getUserByCurrentPage99(String zz, String xx, int aa)
			throws Exception {
		// TODO 自动生成的方法存根
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn
					.prepareStatement("select  * from Indent_table where Indent_Time between ? and ?");
			pstmt1.setString(1, zz);
			pstmt1.setString(2, xx);
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();
				int bb = rs.getInt("Wineshop_ID");
				if (aa == bb) {
					indent.setIndent_ID(rs.getInt("Indent_ID"));
					indent.setIndent_Time(rs.getString("Indent_Time"));
					indent.setIndent_Distribution_Time(rs
							.getString("Indent_Distribution_Time"));
					indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
					indent.setWineshop_Address(rs.getString("Wineshop_Address"));
					indent.setIndent_Fare(rs.getString("Indent_Fare"));
					indent.setIndent_Check_Type(rs
							.getString("Indent_Check_Type"));
					indent.setWineshop_Telephone(rs
							.getString("Wineshop_Telephone"));
					indent.setIndent_Status(rs.getString("Indent_Status"));
					/*
					 * String Indent_ID = rs.getString("Indent_ID"); String
					 * Indent_Time = rs.getString("Indent_Time"); String
					 * Indent_Distribution_Time =
					 * rs.getString("Indent_Distribution_Time"); String
					 * Wineshop_ID = rs.getString("Wineshop_ID"); String
					 * Wineshop_Address = rs.getString("Wineshop_Address");
					 * String Indent_Fare = rs.getString("Indent_Fare"); String
					 * Indent_Check_Type = rs.getString("Indent_Check_Type");
					 * String Wineshop_Telephone =
					 * rs.getString("Wineshop_Telephone"); String Indent_Status
					 * = rs.getString("Indent_Status");
					 * System.out.println(Indent_ID+Indent_Time);
					 */
					list.add(indent);
				}
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
		return list;
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
			pstmt1 = conn.prepareStatement("select count(*) from Indent_table");
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
	
	
	
	public void add100(Indent indent) {// 添加信息
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 加载驱动
			conn = DriverManager.getConnection(url, username, pwd);// 连接
			String sql = "insert into Indent_table (Indent_Time,Indent_Distribution_Time,"
					+ "Wineshop_ID,Wineshop_Address,Indent_Fare,Indent_Check_Type,"
					+ "Wineshop_Telephone,Indent_Status,Indent_Type,Indent_PayID,Indent_TuiKuan,Indent_Why,Indent_remark,Indent_PayType,Indent_QY,Indent_ZZZ,Indent_GH) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";// SQL语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getIndent_Time());
			pstmt.setString(2, indent.getIndent_Distribution_Time());
			pstmt.setInt(3, indent.getWineshop_ID());
			pstmt.setString(4, indent.getWineshop_Address());
			pstmt.setString(5, indent.getIndent_Fare());
			pstmt.setString(6, indent.getIndent_Check_Type());
			pstmt.setString(7, indent.getWineshop_Telephone());
			pstmt.setString(8, indent.getIndent_Status());
			pstmt.setString(9, indent.getIndent_Type());
			pstmt.setString(10, indent.getIndent_PayID());
			pstmt.setString(11, indent.getIndent_TuiKuan());
			pstmt.setString(12, indent.getIndent_Why());
			pstmt.setString(13, indent.getIndent_remark());
			pstmt.setString(14, indent.getIndent_PayType());
			pstmt.setString(15, indent.getIndent_QY());
			pstmt.setFloat(16, indent.getIndent_ZZZ());
			pstmt.setString(17, indent.getIndent_GH());
			boolean a = pstmt.execute();
			if (!a) {
				System.out.println("添加成功");
			} else
				System.out.println("添加失败");

		} catch (ClassNotFoundException e) {
			System.out.println("注册驱动失败！");
		} catch (SQLException e) {
			System.out.println("连接创建失败！！");// 异常抛出
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

	}

	public String Select(int Indent_ID) {
		String Indent_remark = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_ID=?");
			pstmt.setInt(1, Indent_ID);
			rs = pstmt.executeQuery();
			if(rs.next()!=false) {
				Indent_remark = rs.getString("Indent_remark");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return Indent_remark;
		
		
	}
	
	
	public boolean update99(Indent indent) {// 更新
		boolean a = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Indent_remark=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getIndent_remark());
			pstmt.setInt(2, indent.getIndent_ID());

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
	
	
	public boolean update100(Indent indent) {// 更新微信支付转用
		boolean a = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Indent_PayType=?,Indent_Status=? where Indent_PayID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getIndent_PayType());
			pstmt.setString(2, indent.getIndent_Status());
			pstmt.setString(3, indent.getIndent_PayID());

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
	
	
	 
	
	public int Select1(String Indent_PayID) {
		int Wineshop_ID = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_PayID=?");
			pstmt.setString(1, Indent_PayID);
			rs = pstmt.executeQuery();
			if(rs.next()!=false) {
				Wineshop_ID = rs.getInt("Wineshop_ID");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return Wineshop_ID;
		
		
	}
	
	
	public float zzzz(String Indent_PayID) {
		float zzz = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_PayID=?");
			pstmt.setString(1, Indent_PayID);
			rs = pstmt.executeQuery();
			if(rs.next()!=false) {
				zzz = rs.getInt("Indent_ZZZ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return zzz;
		
		
	}
	/**
	 * 
	 * 配送中的订单
	 * @return 返回配送中订单的个数
	 */
	public int finIndentNumber(){
		int num = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select count(*) from Indent_table where Indent_Status=?");
			pstmt.setString(1,StaticFinal.INDENT_PEISONGZHONG);
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
	/**
	 * 查询近三日订单
	 * @return 订单个数
	 */
	public int findThreeIndent(){
		int num = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select COUNT(*) from Indent_table where Indent_Status!=? and DATEDIFF(DD,Indent_Time,GETDATE())<=2");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
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
	/**
	 * 查询本周订单个数
	 * @return 本周订单个数
	 */
	public int findWeekIndent(){
		int num = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select COUNT(*) from Indent_table where Indent_Status!=? and DATEDIFF(WEEK,Indent_Time,GETDATE())<=0");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
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
	/**
	 * 查询本月订单个数
	 * @return 本月订单个数
	 */
	public int findMonthIndent(){
		int num = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select COUNT(*) from Indent_table where Indent_Status!=? and DATEDIFF(MONTH,Indent_Time,GETDATE())<=0");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
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
	/**
	 * 查询本年订单个数
	 * @return 本年订单个数
	 */
	public int findYearIndent(){
		int num = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select COUNT(*) from Indent_table where Indent_Status!=? and DATEDIFF(YEAR,Indent_Time,GETDATE())<=0");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
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
	/**
	 * 查询近三日订单价格
	 * @return 近三日订单总价
	 */
	public double findMoneyDayIndent(){
		double num = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select SUM(Total) from Indent_table join Total_table on Indent_table.Indent_ID=Total_table.Indent_ID where Indent_table.Indent_Status!=? and DATEDIFF(DD,Indent_table.Indent_Time,GETDATE())<=2 ");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
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
	/**
	 * 查询本周订单价格
	 * @return 近本周订单总价
	 */
	public double findMoneyWeekIndent(){
		double num = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select SUM(Total) from Indent_table join Total_table on Indent_table.Indent_ID=Total_table.Indent_ID where Indent_table.Indent_Status!=? and DATEDIFF(WEEK,Indent_table.Indent_Time,GETDATE())=0 ");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
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
	/**
	 * 查询本月订单价格
	 * @return 近本月订单总价
	 */
	public double findMoneyMonthIndent(){
		double num = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select SUM(Total) from Indent_table join Total_table on Indent_table.Indent_ID=Total_table.Indent_ID where Indent_table.Indent_Status!=? and DATEDIFF(MONTH,Indent_table.Indent_Time,GETDATE())=0 ");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
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
	/**
	 * 查询本年订单价格
	 * @return 本年订单总价
	 */
	public double findMoneyYearIndent(){
		double num = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select SUM(Total) from Indent_table join Total_table on Indent_table.Indent_ID=Total_table.Indent_ID where Indent_table.Indent_Status!=? and DATEDIFF(YEAR,Indent_table.Indent_Time,GETDATE())=0 ");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
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
	
	public boolean update55(TimeIndent i) {// 用户发起退款填写退款原因
		boolean a = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Indent_Why=?,Refund_Status=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, i.getIndent_Why());
			pstmt.setString(2, i.getRefund_Status());
			pstmt.setInt(3, i.getIndent_ID());

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
	
	public boolean update88(Indent indent) {// 财务确定给酒店退款成功更新数据库退款状态
		boolean a = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Indent_TuiKuan=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, indent.getIndent_TuiKuan());
			pstmt.setInt(2, indent.getIndent_ID());

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
	
	public List<Indent> findAll8() throws SQLException{//查询出有退款原因的订单
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_Why!='' and Indent_Status!='正在支付'");
			rs = pstmt.executeQuery();
			while(rs.next()) {  
				Indent indent = new Indent(); 
				indent.setIndent_ID(rs.getInt("Indent_ID"));
				indent.setIndent_Time(rs.getString("Indent_Time"));
				indent.setWineshop_ID(rs.getInt("Wineshop_ID"));
				indent.setWineshop_Address(rs.getString("Wineshop_Address"));
				indent.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				indent.setIndent_Status(rs.getString("Indent_Status"));
				indent.setIndent_Type(rs.getString("Indent_Type"));
				indent.setIndent_PayID(rs.getString("Indent_PayID"));
				indent.setIndent_Why(rs.getString("Indent_Why"));
				list.add(indent);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
		
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
	public Page getSum2(int currentPage,int size,String Wineshop_Name,String Time1,String Time2) {
		// TODO 自动生成的方法存根
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select COUNT(Wineshop_table.Wineshop_Name) from Indent_table inner join Wineshop_table on Indent_table.Wineshop_ID=Wineshop_table.Wineshop_ID where Indent_Status!='正在支付' and Wineshop_Name=? and Indent_Time between ? and ?");
			pstmt1.setString(1, Wineshop_Name);
			pstmt1.setString(2, Time1);
			pstmt1.setString(3, Time2);
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
	
	public Page getSun2(int currentPage,Page dd,int size,String Wineshop_Name,String Time1,String Time2) {
		System.out.println("88");
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		System.out.println("88");
		List<TimeIndent> list = new ArrayList<TimeIndent>();   
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Indent_Time desc) as rownumber, Wineshop_table.Wineshop_Name,Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Indent_Type,Indent_table.Indent_PayID,Indent_table.Wineshop_Address,Indent_table.Wineshop_Telephone,Indent_table.Indent_remark from Wineshop_table inner join Indent_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID where Indent_Status!='正在支付' and Indent_Time between ? and ? and Wineshop_Name=?) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			
			pstmt1.setString(1, Time1);
			pstmt1.setString(2, Time2);
			pstmt1.setString(3, Wineshop_Name);
			System.out.println(Wineshop_Name+"vv");
			System.out.println(Time1+"yy");
			System.out.println(Time2+"oo");
			System.out.println("55");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while(rs.next()) {
				System.out.println("99");
				TimeIndent ti = new TimeIndent();
				ti.setWineshop_Name(rs.getString("Wineshop_Name"));
				ti.setIndent_ID(rs.getInt("Indent_ID"));
				ti.setIndent_Time(rs.getString("Indent_Time"));
				ti.setIndent_Status(rs.getString("Indent_Status"));
				ti.setIndent_Type(rs.getString("Indent_Type"));
				ti.setIndent_PayID(rs.getString("Indent_PayID"));
				ti.setWineshop_Address(rs.getString("Wineshop_Address"));
				ti.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				ti.setIndent_remark(rs.getString("Indent_remark"));
				System.out.println(ti+"55");
				list.add(ti);
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
	
	
	public Page getSum3(int currentPage,int size) {
		// TODO 自动生成的方法存根
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select COUNT(*) from Indent_table  where Indent_Status!='正在支付'");
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
	
	public Page getSun3(int currentPage,Page dd,int size) {
		System.out.println("88");
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		System.out.println("88");
		List<TimeIndent> list = new ArrayList<TimeIndent>();   
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Indent_Time desc) as rownumber, Wineshop_table.Wineshop_Name,Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Indent_Type,Indent_table.Indent_PayID,Indent_table.Wineshop_Address,Indent_table.Wineshop_Telephone,Indent_table.Indent_remark from Wineshop_table inner join Indent_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID where Indent_Status!='正在支付') temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			
			System.out.println("55");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while(rs.next()) {
				System.out.println("99");
				TimeIndent ti = new TimeIndent();
				ti.setWineshop_Name(rs.getString("Wineshop_Name"));
				ti.setIndent_ID(rs.getInt("Indent_ID"));
				ti.setIndent_Time(rs.getString("Indent_Time"));
				ti.setIndent_Status(rs.getString("Indent_Status"));
				ti.setIndent_Type(rs.getString("Indent_Type"));
				ti.setIndent_PayID(rs.getString("Indent_PayID"));
				ti.setWineshop_Address(rs.getString("Wineshop_Address"));
				ti.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				ti.setIndent_remark(rs.getString("Indent_remark"));
				System.out.println(ti+"55");
				list.add(ti);
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
	
	public Page getSun4(int currentPage,Page dd,int size) {
		System.out.println("88");
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		System.out.println("88");
		List<TimeIndent> list = new ArrayList<TimeIndent>();   
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Indent_Time desc) as rownumber, Wineshop_table.Wineshop_Name,Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_XXX,Indent_table.Indent_Status,Indent_table.Indent_Type,Indent_table.Indent_PayID,Indent_table.Wineshop_Address,Indent_table.Wineshop_Telephone,Indent_table.Indent_remark from Wineshop_table inner join Indent_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID where Indent_Status!='正在支付' and Indent_XXX != 'null') temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			
			System.out.println("55");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while(rs.next()) {
				System.out.println("99");
				TimeIndent ti = new TimeIndent();
				ti.setWineshop_Name(rs.getString("Wineshop_Name"));
				ti.setIndent_ID(rs.getInt("Indent_ID"));
				ti.setIndent_Time(rs.getString("Indent_Time"));
				ti.setIndent_Status(rs.getString("Indent_Status"));
				ti.setIndent_Type(rs.getString("Indent_Type"));
				ti.setIndent_PayID(rs.getString("Indent_PayID"));
				ti.setWineshop_Address(rs.getString("Wineshop_Address"));
				ti.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				ti.setIndent_remark(rs.getString("Indent_remark"));
				ti.setIndent_XXX(rs.getString("Indent_XXX"));
				System.out.println(ti+"55");
				list.add(ti);
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
	
	public Page getSum4(int currentPage,int size) {
		// TODO 自动生成的方法存根
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select COUNT(*) from Indent_table  where Indent_Status!='正在支付' and Indent_XXX != 'null'");
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
	
	public String Select21(String Indent_PayID) {
		String Indent_Status=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_PayID=?");
			pstmt.setString(1, Indent_PayID);
			rs = pstmt.executeQuery();
			if(rs.next()!=false) {
				Indent_Status = rs.getString("Indent_Status");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return Indent_Status;
		
		
	}
	
	public List<Indent> PL(String Time1,String Time2) {// 批量打印
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_Time between ? and ? and Indent_Status!='正在支付'");
			pstmt.setString(1, Time1);
			pstmt.setString(2, Time2);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();

				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				list.add(indent);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	
	public List<Indent> PL1(String Time1,String Time2,int Wineshop_ID) {// 批量打印
		List<Indent> list = new ArrayList<Indent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from Indent_table where Indent_Time between ? and ? and Wineshop_ID=? and Indent_Status!='正在支付'");
			pstmt.setString(1, Time1);
			pstmt.setString(2, Time2);
			pstmt.setInt(3, Wineshop_ID);
			rs = pstmt.executeQuery();// 执行SQL语句，并返回结果集
			while (rs.next()) {
				Indent indent = new Indent();

				indent.setIndent_ID(rs.getInt(1));
				indent.setIndent_Time(rs.getString(2));
				indent.setWineshop_ID(rs.getInt(4));
				indent.setIndent_Distribution_Time(rs.getString(3));
				indent.setWineshop_Address(rs.getString(5));
				indent.setIndent_Fare(rs.getString(6));
				indent.setIndent_Check_Type(rs.getString(7));
				indent.setWineshop_Telephone(rs.getString(8));
				indent.setIndent_Status(rs.getString(9));
				list.add(indent);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}
	
	public float QuYu(String Indent_QY,String Time1,String Time2){//根据密码和用户查询

		float total = 0 ;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection(url,username,pwd);
					pstmt = conn.prepareStatement("select SUM(total) from Indent_table join Total_table on Indent_table.Indent_ID=Total_table.Indent_ID where Indent_table.Indent_QY=?  and Indent_table.Indent_Time between ? and ? and Indent_table.Indent_Status!='正在支付'");
					pstmt.setString(1, Indent_QY);
					pstmt.setString(2, Time1);
					pstmt.setString(3, Time2);
					rs = pstmt.executeQuery();
					if(rs.next()){
						total = rs.getInt(1);
						
					
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
		        return total;
		    }
	
	
	
	
	
	
	
	

}
