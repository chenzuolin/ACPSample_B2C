package com.sumeng.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.Wineshop;
import com.sec.util.C3p0Utils;
import com.sec.util.StaticFinal;
import com.sumeng.page.Page;
import com.sumeng.page.QueryRunnerSelect;
import com.sumeng.service.AllIndent;
import com.sumeng.service.AllMessage;
import com.sumeng.service.MonthCount;
import com.sumeng.service.WeekDateIndent;
import com.sumeng.service.YearCount;
import com.sumeng.service.greensCount;

public class IndentDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	/**
	 * 
	 * 通过酒店ID查询订单的全部信息
	 * @param id 酒店ID
	 * @return 对象
	 * 
	 * 
	 */
	
	
	public List<Indent> o1(String time1,String time2,String cg_name,String qy) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Wineshop_Telephone,Indent_table.Wineshop_Address,Wineshop_table.Wineshop_Name,Indent_table.Indent_GH from Indent_table join Order_table on Indent_table.Indent_ID=Order_table.Indent_ID join XLFP_table on Order_table.Greens_Type_Name=XLFP_table.Greens_Type_Name join Wineshop_table ON Wineshop_table.Wineshop_ID = Indent_table.Wineshop_ID where  XLFP_table.CG_Name=?  and Indent_table.Indent_QY = ? and Indent_table.Indent_Status!= '正在支付'  and Indent_table.Indent_ID in (select Indent_ID from Indent_table where(Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ? )AND CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00')+1) or (Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00')AND CONVERT(datetime, LEFT(GETDATE(), 10) + ?)) or (Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ?)-1 AND CONVERT(datetime, LEFT(GETDATE(), 10) + ' 00:00:00') )  ) group by Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Wineshop_Telephone,Indent_table.Wineshop_Address,Wineshop_table.Wineshop_Name,Indent_table.Indent_GH");
			pstmt.setString(1,cg_name);
			pstmt.setString(2,qy);
			pstmt.setString(3,time1);
			pstmt.setString(4,time2);
			pstmt.setString(5,time1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String xx = rs.getString("Indent_GH");
				if(xx==null){
					if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt("Indent_ID"));
				indent.setIndent_Time(rs.getString("Indent_Time"));
				indent.setIndent_Status(rs.getString("Indent_Status"));
				indent.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				indent.setWineshop_Address(rs.getString("Wineshop_Address"));
				indent.setCourier_Name(rs.getString("Wineshop_Name"));
				indents.add(indent);
				}
				}else{
					if( xx.equals("配送完成")){
					}else{
				if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
						Indent indent = new Indent();
						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						indent.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
						indent.setWineshop_Address(rs.getString("Wineshop_Address"));
						indent.setCourier_Name(rs.getString("Wineshop_Name"));
						indents.add(indent);
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
	
	
	public List<Indent> o2(String time1,String time2,String cg_name,String qy) {// 根据编号查询信息
		List<Indent> indents = new ArrayList<Indent>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt = conn.prepareStatement("select Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Wineshop_Telephone,Indent_table.Wineshop_Address,Wineshop_table.Wineshop_Name,Indent_table.Indent_GH from Indent_table join Order_table on Indent_table.Indent_ID=Order_table.Indent_ID join XLFP_table on Order_table.Greens_Type_Name=XLFP_table.Greens_Type_Name join Wineshop_table ON Wineshop_table.Wineshop_ID = Indent_table.Wineshop_ID where  XLFP_table.CG_Name=?  and Indent_table.Indent_QY = ? and Indent_table.Indent_Status!= '正在支付'  and Indent_table.Indent_ID in (select Indent_ID from Indent_table where(Indent_Time BETWEEN CONVERT(datetime, LEFT(GETDATE(), 10) + ? )AND CONVERT(datetime, LEFT(GETDATE(), 10) + ?) )  ) group by Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Wineshop_Telephone,Indent_table.Wineshop_Address,Wineshop_table.Wineshop_Name,Indent_table.Indent_GH");
			pstmt.setString(1,cg_name);
			pstmt.setString(2,qy);
			pstmt.setString(3,time1);
			pstmt.setString(4,time2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String xx = rs.getString("Indent_GH");
				if(xx==null){
					if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
				Indent indent = new Indent();
				indent.setIndent_ID(rs.getInt("Indent_ID"));
				indent.setIndent_Time(rs.getString("Indent_Time"));
				indent.setIndent_Status(rs.getString("Indent_Status"));
				indent.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				indent.setWineshop_Address(rs.getString("Wineshop_Address"));
				indent.setCourier_Name(rs.getString("Wineshop_Name"));
				indents.add(indent);
				}
				}else{
					if( xx.equals("配送完成")){
					}else{
				if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
						Indent indent = new Indent();
						indent.setIndent_ID(rs.getInt("Indent_ID"));
						indent.setIndent_Time(rs.getString("Indent_Time"));
						indent.setIndent_Status(rs.getString("Indent_Status"));
						indent.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
						indent.setWineshop_Address(rs.getString("Wineshop_Address"));
						indent.setCourier_Name(rs.getString("Wineshop_Name"));
						indents.add(indent);
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
						//if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
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
							//}
					}else{
						if( xx.equals("配送完成")){
						}else{
					//if(rs.getString("Indent_Status").contains("正在处理") || rs.getString("Indent_Status").contains("正在分拣")){
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
				//	}
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
	
	
	public AllIndent findAllIndent(int id){//根据编号查询信息
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    AllIndent all = new AllIndent();
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Indent_Type,Indent_table.Indent_PayID,Indent_table.Indent_remark,Wineshop_table.Wineshop_Name,Wineshop_table.Wineshop_Address,Wineshop_table.Wineshop_Shift_Name,Wineshop_table.Wineshop_Telephone,Wineshop_table.Wineshop_Time,Wineshop_table.Wineshop_TimeNight,Wineshop_table.Wineshop_TuiJian,FZ_table.CG_Name,FZ_table.CG_Time,FZ_table.FJ_Name,FZ_table.FJ_Time,FZ_table.Courier_Name,FZ_table.PS_Time,Total_table.total from Indent_table inner join Wineshop_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID inner join Total_table on Indent_table.Indent_ID=Total_table.Indent_ID Inner join FZ_table on Indent_table.Indent_ID=FZ_table.Indent_ID and Indent_table.Indent_ID=? order by Indent_table.Indent_Time desc");
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				all.setIndent_ID(rs.getInt("Indent_ID"));
				all.setIndent_Time(rs.getString("Indent_Time"));
				all.setIndent_Status(rs.getString("Indent_Status"));
				all.setIndent_Type(rs.getString("Indent_Type"));
				all.setIndent_PayID(rs.getString("Indent_PayID"));
				all.setIndent_remark(rs.getString("Indent_remark"));
				all.setWineshop_Name(rs.getString("Wineshop_Name"));
				all.setWineshop_address(rs.getString("Wineshop_Address"));
				all.setWineshop_shift_name(rs.getString("Wineshop_Shift_Name"));
				all.setWienshop_telephone(rs.getString("Wineshop_Telephone"));
				all.setWienshop_Time(rs.getString("Wineshop_Time"));
				all.setWienshop_nightTime(rs.getString("Wineshop_TimeNight"));
				all.setWienshop_tuijian(rs.getString("Wineshop_TuiJian"));
				all.setCg_Name(rs.getString("CG_Name"));
				all.setCg_time(rs.getString("CG_Time"));
				all.setFj_Name(rs.getString("FJ_Name"));
				all.setFj_Time(rs.getString("FJ_Time"));
				all.setCourier_Name(rs.getString("Courier_Name"));
				all.setPs_time(rs.getString("PS_Time"));
				all.setTotalPrice(rs.getString("total"));
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
	    return all;
	}
	/**
	 * 通过酒店ID查询订单的全部流程
	 * @param id 酒店ID
	 * @return 返回集合对象
	 */
	public List<AllIndent> findAllListIndent(int id){//根据编号查询信息
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<AllIndent> list = new ArrayList<AllIndent>();
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Indent_table.Indent_ID,Indent_table.Indent_Time,Indent_table.Indent_Status,Indent_table.Indent_Type,Indent_table.Indent_PayID,Indent_table.Indent_remark,Wineshop_table.Wineshop_Name,Wineshop_table.Wineshop_Address,Wineshop_table.Wineshop_Shift_Name,Wineshop_table.Wineshop_Telephone,Wineshop_table.Wineshop_Time,Wineshop_table.Wineshop_TimeNight,Wineshop_table.Wineshop_TuiJian,FZ_table.CG_Name,FZ_table.CG_Time,FZ_table.FJ_Name,FZ_table.FJ_Time,FZ_table.Courier_Name,FZ_table.PS_Time,Total_table.total from Indent_table inner join Wineshop_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID inner join Total_table on Indent_table.Indent_ID=Total_table.Indent_ID Inner join FZ_table on Indent_table.Indent_ID=FZ_table.Indent_ID and Indent_table.Indent_ID=? order by Indent_table.Indent_Time desc");
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				AllIndent all = new AllIndent();
				all.setIndent_ID(rs.getInt("Indent_ID"));
				all.setIndent_Time(rs.getString("Indent_Time"));
				all.setIndent_Status(rs.getString("Indent_Status"));
				all.setIndent_Type(rs.getString("Indent_Type"));
				all.setIndent_PayID(rs.getString("Indent_PayID"));
				all.setIndent_remark(rs.getString("Indent_remark"));
				all.setWineshop_Name(rs.getString("Wineshop_Name"));
				all.setWineshop_address(rs.getString("Wineshop_Address"));
				all.setWineshop_shift_name(rs.getString("Wineshop_Shift_Name"));
				all.setWienshop_telephone(rs.getString("Wineshop_Telephone"));
				all.setWienshop_Time(rs.getString("Wineshop_Time"));
				all.setWienshop_nightTime(rs.getString("Wineshop_TimeNight"));
				all.setWienshop_tuijian(rs.getString("Wineshop_TuiJian"));
				all.setCg_Name(rs.getString("CG_Name"));
				all.setCg_time(rs.getString("CG_Time"));
				all.setFj_Name(rs.getString("FJ_Name"));
				all.setFj_Time(rs.getString("FJ_Time"));
				all.setCourier_Name(rs.getString("Courier_Name"));
				all.setPs_time(rs.getString("PS_Time"));
				all.setTotalPrice(rs.getString("total"));
				list.add(all);
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
	/**
	 * 查询全部订单的数量
	 * @param currentPage 当前页
	 * @param size 每页显示的条数
	 * @return 对象
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
			pstmt1 = conn.prepareStatement("select COUNT(*) from Indent_table inner join Wineshop_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID inner join Total_table on Indent_table.Indent_ID=Total_table.Indent_ID Inner join FZ_table on Indent_table.Indent_ID=FZ_table.Indent_ID and Indent_table.Indent_Status!=?");
			pstmt1.setString(1,StaticFinal.INDENT_ZHIFU);
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
	/**
	 * 分页查询
	 * @param currentPage 当前页
	 * @param dd page对象
	 * @param size 每页显示的条数
	 * @return 对象
	 */
	public Page getSun(int currentPage,Page dd,int size) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<AllIndent> list = new ArrayList<AllIndent>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Indent_Time desc) as rownumber,i.Indent_ID,i.Indent_Time,i.Indent_Status,i.Indent_Type,i.Indent_PayID,i.Indent_remark,w.Wineshop_Name,w.Wineshop_Address,w.Wineshop_Shift_Name,w.Wineshop_Telephone,w.Wineshop_Time,w.Wineshop_TimeNight,w.Wineshop_TuiJian,f.CG_Name,f.CG_Time,f.FJ_Name,f.FJ_Time,f.Courier_Name,f.PS_Time,t.total from Indent_table i,Wineshop_table w,FZ_table f,Total_table t where i.Wineshop_ID=w.Wineshop_ID and i.Indent_ID=f.Indent_ID and i.Indent_ID=t.Indent_ID and i.Indent_Status!='正在支付') temp_row where rownumber>(("+currentPage+"-1)*"+size+")");
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				AllIndent all = new AllIndent();
				all.setIndent_ID(rs.getInt("Indent_ID"));
				all.setIndent_Time(rs.getString("Indent_Time"));
				all.setIndent_Status(rs.getString("Indent_Status"));
				all.setIndent_Type(rs.getString("Indent_Type"));
				all.setIndent_PayID(rs.getString("Indent_PayID"));
				all.setIndent_remark(rs.getString("Indent_remark"));
				all.setWineshop_Name(rs.getString("Wineshop_Name"));
				all.setWineshop_address(rs.getString("Wineshop_Address"));
				all.setWineshop_shift_name(rs.getString("Wineshop_Shift_Name"));
				all.setWienshop_telephone(rs.getString("Wineshop_Telephone"));
				all.setWienshop_Time(rs.getString("Wineshop_Time"));
				all.setWienshop_nightTime(rs.getString("Wineshop_TimeNight"));
				all.setWienshop_tuijian(rs.getString("Wineshop_TuiJian"));
				all.setCg_Name(rs.getString("CG_Name"));
				all.setCg_time(rs.getString("CG_Time"));
				all.setFj_Name(rs.getString("FJ_Name"));
				all.setFj_Time(rs.getString("FJ_Time"));
				all.setCourier_Name(rs.getString("Courier_Name"));
				all.setPs_time(rs.getString("PS_Time"));
				all.setTotalPrice(rs.getString("total"));
				list.add(all);
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
	/**
	 * 通过订单编号删除订单
	 * @param id  订单编号
	 * @return a大于0删除
	 */
	public int delete(int id){//删除
		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Indent_table where Indent_ID=?";
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
	/**
	 * 通过订单编号查询详情
	 * @param Indent_ID 订单编号
	 * @return 对象
	 */
	public List<Order> findUserByID(int Indent_ID){
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Order> list = new ArrayList<Order>();
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Order_table where Indent_ID=?");
			pstmt.setInt(1,Indent_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()!=false){
				Order order = new Order();
				order.setOrder_ID(rs.getInt(1));
				order.setIndent_ID(rs.getInt(2));
				order.setGreens_ID(rs.getInt(3));
				order.setNumber(rs.getInt(4));
				order.setOrder_Requirement(rs.getString(5));
				order.setIndent_Status(rs.getString(6));
				order.setOrder_Remark(rs.getString(7));
				order.setGreens_Name(rs.getString(8));
				order.setGreens_Unit(rs.getString(9));
				order.setIndent_Time(rs.getString(10));
				order.setWineshop_ID(rs.getInt(11));
				list.add(order);
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
	 * 查询本周每天的订单数量
	 * @return 对象
	 */
	public List<WeekDateIndent> weekCountIndent(){//根据编号查询信息
		List<WeekDateIndent> list = new ArrayList<WeekDateIndent>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("SELECT  LEFT(t.Indent_Time, 10) AS Indent_Time , COUNT(1) AS Num FROM    Indent_table t WHERE   DATEDIFF(WEEK, t.Indent_Time, GETDATE()) = 0 and Indent_Status!=? GROUP BY LEFT(t.Indent_Time, 10); ");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				WeekDateIndent all = new WeekDateIndent();
				all.setWdate(rs.getString("Indent_Time"));
				all.setCount(rs.getInt("Num"));
				list.add(all);
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
	/**
	 * 
	 * 查询本月每天的订单数量
	 * @return 对象
	 */
	public List<MonthCount> monthCountIndent(){//根据编号查询信息
		List<MonthCount> list = new ArrayList<MonthCount>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("SELECT  subString(t.Indent_Time, 9,2) AS Indent_Time , COUNT(1) AS Num FROM    Indent_table t WHERE   DATEDIFF(MONTH, t.Indent_Time, GETDATE()) = 0 and Indent_Status!=? GROUP BY subString(t.Indent_Time, 9,2) order by Indent_Time asc");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				MonthCount all = new MonthCount();
				all.setMdate(rs.getInt("Indent_Time"));
				all.setCount(rs.getInt("Num"));
				list.add(all);
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
	/**
	 * 查询每个月订单总数
	 * @return 对象
	 */
	public List<YearCount> yearCountIndent(){//根据编号查询信息
		List<YearCount> list = new ArrayList<YearCount>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("SELECT  subString(t.Indent_Time, 6,2) AS Indent_Time ,COUNT(1) AS Num FROM    Indent_table t WHERE   DATEDIFF(YEAR, t.Indent_Time, GETDATE()) = 0 and Indent_Status!=? GROUP BY subString(t.Indent_Time, 6,2) order by Indent_Time asc");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				YearCount all = new YearCount();
				all.setYdate(rs.getInt("Indent_Time"));
				all.setCount(rs.getInt("Num"));
				list.add(all);
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
	/**
	 * 单个商品消息后数据
	 * @return 对象
	 */
	public List<greensCount> greenCount(){//根据编号查询信息
		List<greensCount> list = new ArrayList<greensCount>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select o.Greens_Name,SUM(o.Number) rows from Order_table o join Indent_table i on o.Indent_ID=i.Indent_ID where i.Indent_Status!=? group by o.Greens_Name");
			pstmt.setString(1,StaticFinal.INDENT_ZHIFU);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				greensCount all = new greensCount();
				all.setName(rs.getString("Greens_Name"));
				all.setValue(rs.getInt("rows"));
				list.add(all);
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
	/**
	 * 通过支付类型查询总条数
	 * @param currentPage 当前页
	 * @param size 每页显示的条数
	 * @param type 支付类型
	 * @return 对象
	 */
	public Page getTypeCount(int currentPage,int size,String type) {
		// TODO 自动生成的方法存根
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select COUNT(*) from Indent_table i inner join Wineshop_table w on w.Wineshop_ID=i.Wineshop_ID inner join Total_table t on i.Indent_ID=t.Indent_ID Inner join FZ_table f on i.Indent_ID=f.Indent_ID where i.Indent_Status!=? and i.Indent_Type=?");
			pstmt1.setString(1,StaticFinal.INDENT_ZHIFU);
			pstmt1.setString(2,type);
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
	/**
	 * 通过支付类型查询到的数据
	 * @param currentPage 当前页
	 * @param dd 对象
	 * @param size 每页显示的大小
	 * @param type 支付类型
	 * @return 对象
	 */
	public Page getTypeContent(int currentPage,Page dd,int size,String type) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<AllIndent> list = new ArrayList<AllIndent>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Indent_Time desc) as rownumber,i.Indent_ID,i.Indent_Time,i.Indent_Status,i.Indent_Type,i.Indent_PayID,i.Indent_remark,w.Wineshop_Name,w.Wineshop_Address,w.Wineshop_Shift_Name,w.Wineshop_Telephone,w.Wineshop_Time,w.Wineshop_TimeNight,w.Wineshop_TuiJian,f.CG_Name,f.CG_Time,f.FJ_Name,f.FJ_Time,f.Courier_Name,f.PS_Time,t.total from Indent_table i,Wineshop_table w,FZ_table f,Total_table t where i.Wineshop_ID=w.Wineshop_ID and i.Indent_ID=f.Indent_ID and i.Indent_ID=t.Indent_ID and i.Indent_Status!=? and i.Indent_Type=? ) temp_row where rownumber>(("+currentPage+"-1)*"+size+")");
			pstmt1.setString(1,StaticFinal.INDENT_ZHIFU);
			pstmt1.setString(2,type);
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				AllIndent all = new AllIndent();
				all.setIndent_ID(rs.getInt("Indent_ID"));
				all.setIndent_Time(rs.getString("Indent_Time"));
				all.setIndent_Status(rs.getString("Indent_Status"));
				all.setIndent_Type(rs.getString("Indent_Type"));
				all.setIndent_PayID(rs.getString("Indent_PayID"));
				all.setIndent_remark(rs.getString("Indent_remark"));
				all.setFj_Name(rs.getString("FJ_Name"));
				all.setCg_Name(rs.getString("CG_Name"));
				all.setCourier_Name(rs.getString("Courier_Name"));
				all.setCg_time(rs.getString("CG_Time"));
				all.setPs_time(rs.getString("PS_Time"));
				all.setWineshop_Name(rs.getString("Wineshop_Name"));
				all.setWineshop_address(rs.getString("Wineshop_Address"));
				all.setWineshop_shift_name(rs.getString("Wineshop_Shift_Name"));
				all.setWienshop_telephone(rs.getString("Wineshop_Telephone"));
				all.setWienshop_Time(rs.getString("Wineshop_Time"));
				all.setWienshop_nightTime(rs.getString("Wineshop_TimeNight"));
				all.setWienshop_tuijian(rs.getString("Wineshop_TuiJian"));
				all.setTotalPrice(rs.getString("total"));
				list.add(all);
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
	/**
	 * 
	 * @param currentPage
	 * @param size
	 * @return
	 */
	public Page getIndentCount(int currentPage,int size) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select COUNT(*) from Indent_table inner "
				+ "join Wineshop_table on Wineshop_table.Wineshop_ID=Indent_table.Wineshop_ID "
				+ "inner join Total_table on Indent_table.Indent_ID=Total_table.Indent_ID "
				+ "Inner join FZ_table on Indent_table.Indent_ID=FZ_table.Indent_ID "
				+ "and Indent_table.Indent_Status!="+"'"+StaticFinal.INDENT_ZHIFU+"'";
		Page page = new Page();
		Object query = null;
		try {
			query = qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String numberTotal = query.toString();
		int totalNum = Integer.parseInt(numberTotal);
		int totalPage = 0;
		if(totalNum%size==0) {
			totalPage = totalNum/size;
		}else {
			totalPage = totalNum/size+1;
		}
		page.setCount(totalNum);
		page.setTotalPage(totalPage);
		page.setCurrentPage(currentPage);
		return page;
	}
	/**
	 * 分页查询
	 * @param currentPage 当前页
	 * @param dd page对象
	 * @param size 每页显示的条数
	 * @return 对象
	 */
	public Page getIndentData(int currentPage,Page dd,int size) {
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select top "+size+" * from (select row_number()"
				+ " over(order by Indent_Time desc) as rownumber,"
				+ "i.Indent_ID,i.Indent_Time,i.Indent_Status,i.Indent_Type,i.Indent_PayID,"
				+ "i.Indent_remark,w.Wineshop_Name,w.Wineshop_Address,w.Wineshop_Shift_Name"
				+ ",w.Wineshop_Telephone,w.Wineshop_Time,w.Wineshop_TimeNight,w.Wineshop_TuiJian,"
				+ "f.CG_Name,f.CG_Time,f.FJ_Name,f.FJ_Time,f.Courier_Name,f.PS_Time,"
				+ "t.total from Indent_table i,Wineshop_table w,FZ_table f,Total_table t "
				+ "where i.Wineshop_ID=w.Wineshop_ID and i.Indent_ID=f.Indent_ID and"
				+ " i.Indent_ID=t.Indent_ID and i.Indent_Status!='正在支付') temp_row where "
				+ "rownumber>(("+currentPage+"-1)*"+size+")";
		List<AllMessage> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<AllMessage>(AllMessage.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		dd.setData(list);
		return dd;
	}
	/**
	 * 多条件总条数
	 * @param qrs 条件对象
	 * @param currentPage 当前页
	 * @param size 每页显示的大小
	 * @return 对象
	 */
	public Page numberCount(QueryRunnerSelect qrs,int currentPage,int size){
		try{
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			Page page = new Page();
			String sql ="select COUNT(1) from Indent_table i,Wineshop_table w,FZ_table f,"
					+ "Total_table t where i.Wineshop_ID=w.Wineshop_ID and"
					+ " i.Indent_ID=f.Indent_ID and i.Indent_ID=t.Indent_ID "
					+ "and i.Indent_Status!='正在支付'";
			String wineshopName = qrs.getWineshopName();
			if(wineshopName != null && !wineshopName.trim().isEmpty()){
				sql += " and w.Wineshop_Name like '%"+wineshopName+"%'";
			}
			String indent_Type = qrs.getIndentType();
			System.out.println("indent_Type="+indent_Type);
			if(indent_Type != null && !indent_Type.trim().isEmpty()){
				sql += " and i.Indent_Type="+"'"+indent_Type+"'";
			}
			String start = qrs.getStartTime();
			String timeOne = " 00:00:00";
			String startTime = start + timeOne;
			if(start != null && !start.trim().isEmpty()){
				sql += " and i.Indent_Time between "+"'"+startTime+"'";
			}
			String end = qrs.getEndTime();
			String timeTwo = " 24:00:00";
			String endTime = end + timeTwo;
			if(end != null && !end.trim().isEmpty()){
				sql += "and " + "'"+endTime+"'";
			}
			int minPrice = qrs.getMinPrice();
			if(minPrice != 0){
				sql += "and t.total >" + minPrice;
			}
			int maxPrice = qrs.getMaxPrice();
			if(maxPrice != 0 ){
				sql += "and t.total <=" + maxPrice;
			}
			System.out.println(sql);
			Object countNumberCount = qr.query(sql.toString(),new ScalarHandler());
			String numberOne = countNumberCount.toString();
			int totalNum = Integer.parseInt(numberOne);
			System.out.println("totalNum=="+totalNum);
			int totalPage = 0;
			if(totalNum%size==0){
				totalPage = totalNum/size;
			}else{
				totalPage = totalNum/size+1;
			}
			page.setCount(totalNum);
			page.setCurrentPage(currentPage);
			page.setTotalPage(totalPage);
		    return page;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 多条件订单查询
	 * @param qrs 查询对象
	 * @param currentPage 
	 * @param dd
	 * @param size
	 * @return
	 */
	public Page numberSelect(QueryRunnerSelect qrs,int currentPage,Page pageDate,int size){
		try{
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql ="select top "+size+" * from (select row_number() over(order by Indent_Time asc) as rownumber,"
					+ "i.Indent_ID,i.Indent_Time,i.Indent_Status,i.Indent_Type,i.Indent_PayID,i.Indent_remark,"
					+ "w.Wineshop_Name,w.Wineshop_Address,w.Wineshop_Shift_Name,w.Wineshop_Telephone,w.Wineshop_Time,"
					+ "w.Wineshop_TimeNight,w.Wineshop_TuiJian,f.CG_Name,f.CG_Time,f.FJ_Name,f.FJ_Time,f.Courier_Name,"
					+ "f.PS_Time,t.total from Indent_table i,Wineshop_table w,FZ_table f,Total_table t  "
					+ "where i.Wineshop_ID=w.Wineshop_ID and i.Indent_ID=f.Indent_ID and "
					+ "i.Indent_ID=t.Indent_ID and i.Indent_Status!='正在支付'";
			String wineshopName = qrs.getWineshopName();
			if(wineshopName != null && !wineshopName.trim().isEmpty()){
				sql += " and w.Wineshop_Name like '%"+wineshopName+"%'";
			}
			String indent_Type = qrs.getIndentType();
			if(indent_Type != null && !indent_Type.trim().isEmpty()){
				sql += " and i.Indent_Type="+"'"+indent_Type+"'";
			}
			String start = qrs.getStartTime();
			String timeOne = " 00:00:00";
			String startTime = start + timeOne;
			if(start != null && !start.trim().isEmpty()){
				sql += " and i.Indent_Time between "+"'"+startTime+"'";
			}
			String end = qrs.getEndTime();
			String timeTwo = " 24:00:00";
			String endTime = end + timeTwo;
			if(end != null && !end.trim().isEmpty()){
				sql += "and " + "'"+endTime+"'";
			}
			int minPrice = qrs.getMinPrice();
			if(minPrice != 0){
				sql += "and t.total >" + minPrice;
			}
			int maxPrice = qrs.getMaxPrice();
			if(maxPrice != 0){
				sql += "and t.total <=" + maxPrice;
			}
			sql += ")temp_row where rownumber>(("+currentPage+"-1)*"+size+") ";
			System.out.println(sql);
			List<AllMessage> all = qr.query(sql.toString() , new BeanListHandler<AllMessage>(AllMessage.class));
			pageDate.setData(all);
		    return pageDate;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
