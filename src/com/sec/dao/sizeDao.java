package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Indent;
import com.sec.entity.TKtype;
import com.sec.entity.TimeIndent;
import com.sumeng.page.Page;

public class sizeDao {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username = "green";
	String pwd = "12345678";
	
	
	
	public int checkWineshop(String size_Name,String size_Password){//根据密码和用户查询

		int id = 0 ;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection(url,username,pwd);
					pstmt = conn.prepareStatement("select * from size_table where size_Name=? and size_Password=?");
					pstmt.setString(1, size_Name);
					pstmt.setString(2, size_Password);
					rs = pstmt.executeQuery();
					if(rs.next()){
						id = rs.getInt("size_ID");
						
					
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
	
	
	
	public List<TimeIndent> findAll() {// 老唐看的退款

		List<TimeIndent> list = new ArrayList<TimeIndent>();
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select Wineshop_table.Wineshop_ID,Wineshop_table.Wineshop_Name,Wineshop_table.Wineshop_Telephone,Wineshop_table.Wineshop_Address, Wineshop_table.Wineshop_TuiJian,Indent_table.Indent_TKprice, Indent_table.Refund_Time, Indent_table.Indent_ID,Indent_table.Indent_Why,Indent_table.Indent_Time,Indent_table.Indent_Type,Indent_table.Indent_PayID from Indent_table inner join Wineshop_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID and Refund_Status='正在审核'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				TimeIndent d = new TimeIndent();
				d.setIndent_ID(rs.getInt("Indent_ID"));
				d.setIndent_Time(rs.getString("Indent_Time"));
				d.setWineshop_ID(rs.getInt("wineshop_ID"));
				d.setWineshop_Address(rs.getString("Wineshop_Address"));
				d.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				d.setWineshop_Name(rs.getString("Wineshop_Name"));
				d.setIndent_Why(rs.getString("Indent_Why"));
				d.setIndent_PayID(rs.getString("Indent_PayID"));
				d.setIndent_Type(rs.getString("Indent_Type"));
				d.setIndent_TKprice(rs.getFloat("Indent_TKprice"));
				d.setRefund_Time(rs.getString("Refund_Time"));
				d.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
				list.add(d);
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
	
	
	public void update1(TimeIndent t) {// 老唐点击确定的点击事件
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Refund_Status=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getRefund_Status());
			pstmt.setInt(2, t.getIndent_ID());
			boolean y = pstmt.execute();
			if (!y) {
				System.out.println("操作成功");
			} else
				System.out.println("操作失败");

		} catch (ClassNotFoundException e) {
			System.out.println("注册驱动失败！");
		} catch (SQLException e) {
			System.out.println("dddd");
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
	
	
	public List<TimeIndent> findAll1() {// 老赵看的退款

		List<TimeIndent> list = new ArrayList<TimeIndent>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select Wineshop_table.Wineshop_ID,Wineshop_table.Wineshop_Name,Wineshop_table.Wineshop_Telephone,Wineshop_table.Wineshop_Address, Wineshop_table.Wineshop_TuiJian,Indent_table.Indent_TKprice, Indent_table.Indent_ID,Indent_table.Refund_Time, Indent_table.Indent_Why,Indent_table.Indent_Time,Indent_table.Indent_Type,Indent_table.Indent_PayID from Indent_table inner join Wineshop_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID and Refund_Status='审核中'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				TimeIndent t= new TimeIndent();
				t.setIndent_ID(rs.getInt("Indent_ID"));
				t.setIndent_Time(rs.getString("Indent_Time"));
				t.setWineshop_ID(rs.getInt("wineshop_ID"));
				t.setWineshop_Address(rs.getString("Wineshop_Address"));
				t.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				t.setWineshop_Name(rs.getString("Wineshop_Name"));
				t.setIndent_Why(rs.getString("Indent_Why"));
				t.setIndent_PayID(rs.getString("Indent_PayID"));
				t.setIndent_Type(rs.getString("Indent_Type"));
				t.setIndent_TKprice(rs.getFloat("Indent_TKprice"));
				t.setRefund_Time(rs.getString("Refund_Time"));
				t.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
				list.add(t);
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
	public void update2(TimeIndent t) {// 老赵点击确定的点击事件
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Refund_Status=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getRefund_Status());
			pstmt.setInt(2, t.getIndent_ID());
			boolean y = pstmt.execute();
			if (!y) {
				System.out.println("操作成功");
			} else
				System.out.println("操作失败");

		} catch (ClassNotFoundException e) {
			System.out.println("注册驱动失败！");
		} catch (SQLException e) {
			System.out.println("dddd");
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
	
	public List<TimeIndent> findAll3() {// 销售部看的退款

		List<TimeIndent> list = new ArrayList<TimeIndent>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select Wineshop_table.Wineshop_ID,Wineshop_table.Wineshop_Name,Wineshop_table.Wineshop_Telephone,Wineshop_table.Wineshop_Address, Wineshop_table.Wineshop_TuiJian,Indent_table.Indent_ID, Indent_table.Indent_Why,Indent_table.Indent_Time,Indent_table.Indent_Type,Indent_table.Indent_PayID from Indent_table inner join Wineshop_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID and Refund_Status='申请退款'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				TimeIndent t= new TimeIndent();
				t.setIndent_ID(rs.getInt("Indent_ID"));
				t.setIndent_Time(rs.getString("Indent_Time"));
				t.setWineshop_ID(rs.getInt("wineshop_ID"));
				t.setWineshop_Address(rs.getString("Wineshop_Address"));
				t.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				t.setWineshop_Name(rs.getString("Wineshop_Name"));
				t.setIndent_Why(rs.getString("Indent_Why"));
				t.setIndent_PayID(rs.getString("Indent_PayID"));
				t.setIndent_Type(rs.getString("Indent_Type"));
				t.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
				list.add(t);
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
	public void update3(TimeIndent t) {// 销售部点击确定的点击事件
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Refund_Status=?,Refund_Time=?,Indent_TKprice=? where Indent_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getRefund_Status());
			
			pstmt.setString(2, t.getRefund_Time());
			pstmt.setFloat(3, t.getIndent_TKprice());
			pstmt.setInt(4, t.getIndent_ID());
			boolean y = pstmt.execute();
			if (!y) {
				System.out.println("操作成功");
			} else
				System.out.println("操作失败");

		} catch (ClassNotFoundException e) {
			System.out.println("注册驱动失败！");
		} catch (SQLException e) {
			System.out.println("dddd");
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
	
	/**
	 * author 呆萌的欧尼酱
	 * @param currentPage
	 * @param size
	 * @param Wineshop_Name
	 * @param Time1
	 * @param Time2
	 * @return
	 */
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
			pstmt1 = conn.prepareStatement("select COUNT(Indent_table.Refund_Status) from Indent_table where Refund_Status='审核完毕' ");
			
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
	
	public Page getSun(int currentPage,Page dd,int size) {
		System.out.println("88");
		Connection conn = null;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		System.out.println("88");
		List<TimeIndent> list = new ArrayList<TimeIndent>();   
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Indent_Time desc) as rownumber, Wineshop_table.Wineshop_ID,Wineshop_table.Wineshop_Name,Wineshop_table.Wineshop_Telephone,Wineshop_table.Wineshop_Address, Wineshop_table.Wineshop_TuiJian,Indent_table.Indent_ID,Indent_table.Indent_TKprice, Indent_table.Indent_Why,Indent_table.Refund_Status,Indent_table.Refund_Time,  Indent_table.Indent_Time,Indent_table.Indent_Type,Indent_table.Indent_PayID,Total_table.total from Total_table left join Indent_table on Total_table.Indent_ID=Indent_table.Indent_ID inner join Wineshop_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID and Refund_Status='审核完毕') temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			
			
			System.out.println("55");
			rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
			while(rs.next()) {
				TimeIndent t = new TimeIndent();
				System.out.println("99");
				
				t.setIndent_ID(rs.getInt("Indent_ID"));
				t.setIndent_Time(rs.getString("Indent_Time"));
				t.setWineshop_ID(rs.getInt("wineshop_ID"));
				t.setWineshop_Address(rs.getString("Wineshop_Address"));
				t.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				t.setWineshop_Name(rs.getString("Wineshop_Name"));
				t.setIndent_Why(rs.getString("Indent_Why"));
				t.setIndent_PayID(rs.getString("Indent_PayID"));
				t.setIndent_Type(rs.getString("Indent_Type"));
				t.setRefund_Status(rs.getString("Refund_Status"));
				t.setRefund_Time(rs.getString("Refund_Time"));
				t.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
				t.setIndent_TKprice(rs.getFloat("Indent_TKprice"));
				t.setTotal(rs.getFloat("total"));
				System.out.println(t+"55");
				list.add(t);
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
	
	public void update4(TimeIndent t) {// 会计点击确定的点击事件
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			String sql = "update Indent_table set Refund_Status=? where Indent_PayID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getRefund_Status());
			pstmt.setString(2, t.getIndent_PayID());
			boolean y = pstmt.execute();
			if (!y) {
				System.out.println("操作成功");
			} else
				System.out.println("操作失败");

		} catch (ClassNotFoundException e) {
			System.out.println("注册驱动失败！");
		} catch (SQLException e) {
			System.out.println("dddd");
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
	


public List<TKtype> findAll8() {// 查询退款类型表的所有信息

		List<TKtype> t = new ArrayList<TKtype>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select * from TKtype_table");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TKtype p = new TKtype();

				p.setTK_Type(rs.getString("TK_Type"));
				t.add(p);
				
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
	return t;
	}
public List<TimeIndent> Select(int Indent_ID) {
	System.out.println("88");
	Connection conn = null;
	
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	System.out.println("88");
	List<TimeIndent> list = new ArrayList<TimeIndent>();   
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		
		pstmt1 = conn.prepareStatement("select Wineshop_table.Wineshop_ID,Wineshop_table.Wineshop_Name,Wineshop_table.Wineshop_Telephone,Wineshop_table.Wineshop_Address, Wineshop_table.Wineshop_TuiJian,Indent_table.Indent_ID,Indent_table.Indent_TKprice, Indent_table.Indent_Why,Indent_table.Refund_Status,Indent_table.Refund_Time,  Indent_table.Indent_Time,Indent_table.Indent_Type,Indent_table.Indent_PayID,Total_table.total from Total_table left join Indent_table on Total_table.Indent_ID=Indent_table.Indent_ID inner join Wineshop_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID and Refund_Status='审核完毕' where Indent_table.Indent_ID=?");
		pstmt1.setInt(1, Indent_ID);
		
		System.out.println("55");
		rs = pstmt1.executeQuery();// 执行SQL语句，并返回结果集
		while(rs.next()) {
			TimeIndent t = new TimeIndent();
			System.out.println("99");
			
			t.setIndent_ID(rs.getInt("Indent_ID"));
			t.setIndent_Time(rs.getString("Indent_Time"));
			t.setWineshop_ID(rs.getInt("wineshop_ID"));
			t.setWineshop_Address(rs.getString("Wineshop_Address"));
			t.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
			t.setWineshop_Name(rs.getString("Wineshop_Name"));
			t.setIndent_Why(rs.getString("Indent_Why"));
			t.setIndent_PayID(rs.getString("Indent_PayID"));
			t.setIndent_Type(rs.getString("Indent_Type"));
			t.setRefund_Status(rs.getString("Refund_Status"));
			t.setRefund_Time(rs.getString("Refund_Time"));
			t.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
			t.setIndent_TKprice(rs.getFloat("Indent_TKprice"));
			t.setTotal(rs.getFloat("total"));
			System.out.println(t+"55");
			list.add(t);
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
	return list;
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


	

}
