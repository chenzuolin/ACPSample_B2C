package com.sumeng.web;

import com.sec.entity.Wineshop;
import com.sec.util.C3p0Utils;
import com.sec.util.StaticFinal;
import com.sumeng.page.Page;
import com.sumeng.service.BusinessData;
import com.sumeng.service.WineShopAllIndent;
import com.sumeng.service.WineshopIndentCount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class WineshopDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	/**
	 * ͨ���Ƶ����Ʋ�ѯ�Ƶ���Ϣ
	 * @param Wineshop_Name �Ƶ�����
	 * @return ����
	 */
	public List<Wineshop> findAllName(String Wineshop_Name){//���ݱ�Ų�ѯ��Ϣ
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Wineshop> list = new ArrayList<Wineshop>();
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_Name=?");
			pstmt.setString(1,Wineshop_Name);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
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
				wineshop.setWineshop_TuiJian(rs.getString(19));
				list.add(wineshop);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
	        //8���ر���Դ
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
	 * ��ѯ���ж��ټҾƵ�
	 * @param currentPage  ��ǰҳ
	 * @param size  ÿҳ��ʾ������
	 * @return  ����
	 */
	public Page getSum(int currentPage,int size) {
		// TODO �Զ����ɵķ������
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select count(*) from Wineshop_table");
			rs = pstmt1.executeQuery();// ִ��SQL��䣬�����ؽ����
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
			// 8���ر���Դ
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
	 *  ��ѯȫ���Ƶ�
	 * @param currentPage  ��ǰҳ
	 * @param dd  page����
	 * @param size ÿҳ��ʾ������
	 * @return ȫ���Ƶ���Ϣ
	 */
	public Page getSun(int currentPage,Page dd,int size) {
		// TODO �Զ����ɵķ������
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<Wineshop> list = new ArrayList<Wineshop>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Wineshop_ID desc) as rownumber,* from Wineshop_table) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				Wineshop ww = new Wineshop();
				ww.setWineshop_ID(rs.getInt("Wineshop_ID"));
				ww.setWineshop_UserName(rs.getString("Wineshop_UserName"));
				ww.setWineshop_Password(rs.getString("Wineshop_Password"));
				ww.setWineshop_Name(rs.getString("Wineshop_Name"));
				ww.setWineshop_Shift_Name(rs.getString("Wineshop_Shift_Name"));
				ww.setWineshop_Nature(rs.getString("Wineshop_Nature"));
				ww.setWineshop_QQ(rs.getString("Wineshop_QQ"));
				ww.setWineshop_WeChat(rs.getString("Wineshop_WeChat"));
				ww.setWineshop_Time(rs.getString("Wineshop_Time"));
				ww.setWineshop_TimeNight(rs.getString("Wineshop_TimeNight"));
				ww.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
				ww.setWineshop_Telephone(rs.getString("Wineshop_Telephone"));
				ww.setWineshop_Time(rs.getString("Wineshop_Time"));
				ww.setWineshop_TimeNight(rs.getString("Wineshop_TimeNight"));
				ww.setWineshop_Address(rs.getString("Wineshop_Address"));
				ww.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
				ww.setWineshop_Date(rs.getString("Wineshop_Date"));
				ww.setLogout(rs.getInt("Logout"));
				list.add(ww);
				dd.setData(list);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8���ر���Դ
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
	 * ͨ���Ƶ�IDɾ��
	 * @param id �Ƶ�ID
	 * @return a����0  ɾ���ɹ�
	 */
	public int delete(int id){//ɾ��
		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from Wineshop_table where Wineshop_ID=?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			a=pstmt.executeUpdate();
			if(a>0){
				System.out.println("�ɹ�");
			}else{
				System.out.println("ʧ��");
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
	 * ͨ���Ƶ�ID��ѯȫ����Ϣ
	 * @param id �Ƶ�ID
	 * @return ����
	 */
	public Wineshop findAllObjectById(int id){
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Wineshop wineshop = new Wineshop();
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_ID=?");
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()!=false){
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
				wineshop.setWineshop_TuiJian(rs.getString(19));
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
	        //8���ر���Դ
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
	    return wineshop;
	}
	
	/**
	 * ͨ���Ƶ�����ģ����ѯ
	 * @param Wineshop_Name  �Ƶ�����
	 * @return ����
	 */
	public List<Wineshop> findAllLikeListName(String Wineshop_Name){//���ݱ�Ų�ѯ��Ϣ
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Wineshop> list = new ArrayList<Wineshop>();
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Wineshop_table where Wineshop_Name like '%'+?+'%'");
			pstmt.setString(1,Wineshop_Name);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
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
				wineshop.setWineshop_TuiJian(rs.getString(19));
				list.add(wineshop);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
	        //8���ر���Դ
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
	 * ��ѯ���оƵ��µ�����
	 * @param currentPage ��ǰҳ
	 * @param dd page����
	 * @param size ÿҳ��ʾ������
	 * @return page����
	 */
	public Page getIndentCount(int currentPage,Page dd,int size) {
		// TODO �Զ����ɵķ������
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<WineshopIndentCount> list = new ArrayList<WineshopIndentCount>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Wineshop_ID asc) as rownumber,ISNULL((select COUNT(i.Wineshop_ID) from Indent_table i where i.Wineshop_ID=w.Wineshop_ID and i.Indent_Status!=? group by i.Wineshop_ID),0) as num,Wineshop_ID,Wineshop_UserName,Wineshop_Name,Wineshop_TuiJian,Wineshop_Telephone,Wineshop_Address,Wineshop_Nature,Wineshop_Shift_Name from Wineshop_table w ) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			pstmt1.setString(1,StaticFinal.INDENT_ZHIFU);
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				WineshopIndentCount count = new WineshopIndentCount();
				count.setSum(rs.getInt("num"));
				count.setWineshop_ID(rs.getInt("Wineshop_ID"));
				count.setWineshop_UserName(rs.getString("Wineshop_UserName"));
				count.setWineshop_Name(rs.getString("Wineshop_Name"));
				count.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
				count.setTelephone(rs.getString("Wineshop_Telephone"));
				count.setWineshop_Address(rs.getString("Wineshop_Address"));
				count.setWineshop_Native(rs.getString("Wineshop_Nature"));
				count.setWienshop_Shift_Name(rs.getString("Wineshop_Shift_Name"));
				list.add(count);
				dd.setData(list);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8���ر���Դ
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
	 * ��ѯҵ��������
	 * @param currentPage ��ǰҶ
	 * @param size ÿҳ�Ĵ�С
	 * @return ����
	 */
	public Page getTotal(int currentPage,int size) {
		// TODO �Զ����ɵķ������
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select count(distinct w.Wineshop_TuiJian) from Wineshop_table w");
			rs = pstmt1.executeQuery();// ִ��SQL��䣬�����ؽ����
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
			// 8���ر���Դ
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
	 * ��ѯҵ������
	 * @param currentPage ��ǰҵ
	 * @param dd page����
	 * @param size ÿҳ��ʾ
	 * @return ����
	 */
	public Page getWineshopTuijian(int currentPage,Page dd,int size) {
		// TODO �Զ����ɵķ������
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<BusinessData> list = new ArrayList<BusinessData>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by w.Wineshop_TuiJian desc) as rownumber, w.Wineshop_TuiJian,COUNT(w.Wineshop_TuiJian) num from Wineshop_table w group by w.Wineshop_TuiJian) temp_row where rownumber>(("+currentPage+"-1)*"+size+")");
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				BusinessData count = new BusinessData();
				count.setBname(rs.getString("Wineshop_TuiJian"));
				count.setNum(rs.getInt("num"));
				list.add(count);
				dd.setData(list);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8���ر���Դ
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
	 * ��ѯ�ض�ҵ��Ա������
	 * @param currentPage ��ǰҶ
	 * @param size ÿҳ�Ĵ�С
	 * @return ����
	 */
	public Page getTotalCount(int currentPage,int size,String name) {
		// TODO �Զ����ɵķ������
		Page page = new Page();
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select COUNT(1) from Wineshop_table where Wineshop_TuiJian=?");
			pstmt1.setString(1,name);
			rs = pstmt1.executeQuery();// ִ��SQL��䣬�����ؽ����
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
			// 8���ر���Դ
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
	 * ��ѯ�ض�ҵ��Ա�Ƶ��µ�����
	 * @param currentPage ��ǰҳ
	 * @param dd page����
	 * @param size ÿҳ��ʾ������
	 * @return page����
	 */
	public Page getCountData(int currentPage,Page dd,int size,String name) {
		// TODO �Զ����ɵķ������
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		List<WineshopIndentCount> list = new ArrayList<WineshopIndentCount>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, pwd);
			pstmt1 = conn.prepareStatement("select top "+size+" * from (select row_number() over(order by Wineshop_ID asc) as rownumber,ISNULL((select COUNT(i.Wineshop_ID) from Indent_table i where i.Wineshop_ID=w.Wineshop_ID and i.Indent_Status!=? group by i.Wineshop_ID),0) as num,Wineshop_ID,Wineshop_UserName,Wineshop_Name,Wineshop_TuiJian,Wineshop_Telephone,Wineshop_Address,Wineshop_Nature,Wineshop_Shift_Name from Wineshop_table w where w.Wineshop_TuiJian=? ) temp_row where rownumber>(("+currentPage+"-1)*"+size+");");
			pstmt1.setString(1,StaticFinal.INDENT_ZHIFU);
			pstmt1.setString(2,name);
			rs = pstmt1.executeQuery();
			while (rs.next()) {
				WineshopIndentCount count = new WineshopIndentCount();
				count.setSum(rs.getInt("num"));
				count.setWineshop_ID(rs.getInt("Wineshop_ID"));
				count.setWineshop_UserName(rs.getString("Wineshop_UserName"));
				count.setWineshop_Name(rs.getString("Wineshop_Name"));
				count.setWineshop_TuiJian(rs.getString("Wineshop_TuiJian"));
				count.setTelephone(rs.getString("Wineshop_Telephone"));
				count.setWineshop_Address(rs.getString("Wineshop_Address"));
				count.setWineshop_Native(rs.getString("Wineshop_Nature"));
				count.setWienshop_Shift_Name(rs.getString("Wineshop_Shift_Name"));
				list.add(count);
				dd.setData(list);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8���ر���Դ
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
	 * ָ���Ƶ�ȫ������
	 * @param wId
	 * @param currentPage
	 * @param size
	 * @return
	 */
	public Page findAllWineshopIndent(int wId,int currentPage,int size){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		Page page = new Page();
		String sqlCount = "select COUNT(1) from Indent_table where Wineshop_ID=? and Indent_Status!='����֧��'";
		String sqlData = "select top "+size+" * from (select row_number() over(order by i.Indent_ID desc) as rownumber,"
				+ "i.Indent_ID,i.Indent_Time,i.Indent_Status,i.Indent_Type,i.Indent_PayID,t.total,i.Indent_remark"
				+ " from Wineshop_table w join Indent_table i on w.Wineshop_ID=i.Wineshop_ID "
				+ "join Total_table t on i.Indent_ID=t.Indent_ID and i.Indent_Status!='����֧��' "
				+ "and w.Wineshop_ID="+wId+" )temp_row where rownumber>(("+currentPage+"-1)*"+size+")";
		Object count = null;
		List<WineShopAllIndent> list = null;
		try {
			count = qr.query(sqlCount, new ScalarHandler(),wId);
			list = qr.query(sqlData, new BeanListHandler<WineShopAllIndent>(WineShopAllIndent.class));
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
	 * ͨ��ʱ��β�ѯ�Ƶ궩��
	 * @param wId
	 * @param currentPage
	 * @param size
	 * @param satrtTime
	 * @param endTime
	 * @return
	 */
	public Page findTimeIndent(int wId,int currentPage,int size,String startTime,String endTime){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		Page page = new Page();
		String sqlCount = "select COUNT(1) from Indent_table "
				+ "where Wineshop_ID=? and Indent_Status!='����֧��' "
				+ "and Indent_Time between "+"'"+startTime+"'"+" and "+"'"+endTime+"'";
		String sqlData = "select top "+size+" * from (select row_number() over(order by i.Indent_ID desc) as rownumber,"
				+ "i.Indent_ID,i.Indent_Time,i.Indent_Status,i.Indent_Type,i.Indent_PayID,t.total,i.Indent_remark"
				+ " from Wineshop_table w join Indent_table i on w.Wineshop_ID=i.Wineshop_ID "
				+ "join Total_table t on i.Indent_ID=t.Indent_ID and i.Indent_Status!='����֧��' "
				+ "and w.Wineshop_ID="+wId+" and i.Indent_Time between "+"'"+startTime+"'"+" and "+"'"+endTime+"'"+" )temp_row "
						+ "where rownumber>(("+currentPage+"-1)*"+size+")";
		Object count = null;
		List<WineShopAllIndent> list = null;
		try {
			count = qr.query(sqlCount, new ScalarHandler(),wId);
			list = qr.query(sqlData, new BeanListHandler<WineShopAllIndent>(WineShopAllIndent.class));
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
	 * ͨ����¼���ƻ�ȡ�Ƶ�ID
	 * @param wineshop
	 * @return
	 */
	public Wineshop byId(String name){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Wineshop_table where Wineshop_UserName=?";
		Wineshop code = null;
		try {
			code = qr.query(sql, new BeanHandler<Wineshop>(Wineshop.class),name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
		
	}
	/**
	 * Ӫҵִ��ʶ��
	 * @param wineshop
	 * @return
	 */
	public int updataITstart(Wineshop wineshop){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update Wineshop_table set Wineshop_Aptitude=? , Wineshop_Shift_Name=? ,"
				+ " Wineshop_Number=? , Wineshop_danwei_name=? , Wineshop_faren=? , Wineshop_addr=? ,"
				+ " Wineshop_wtype=? , startTime=? , endTime=? where Wineshop_ID=?";
		int code = 0;
		try {
			code = qr.update(sql, wineshop.getWineshop_Aptitude(),wineshop.getWineshop_Shift_Name(),wineshop.getWineshop_Number(),
					wineshop.getWineshop_danwei_name(),wineshop.getWineshop_faren(),wineshop.getWineshop_addr(),
					wineshop.getWineshop_wtype(),wineshop.getStartTime(),wineshop.getEndTime(),wineshop.getWineshop_ID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code > 0 ? 200 : -1;
		
	}
	/**
	 * �Ƶ�����Ψһ
	 * @param name
	 * @return
	 */
	public int checkName(String name){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select COUNT(*) from Wineshop_table where Wineshop_Name=?";
		Object code = null ;
		try {
			code = qr.query(sql, new ScalarHandler(),name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Integer.parseInt(code.toString());
		
	}
	/**
	 * �Ƶ��û���Ψһ
	 * @param username
	 * @return
	 */
	public int checkUserName(String username){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select count(*) from Wineshop_table where Wineshop_UserName=?";
		Object code = null ;
		try {
			code = qr.query(sql, new ScalarHandler(),username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Integer.parseInt(code.toString());
		
	}
	/**
	 * �绰Ψһ
	 * @param tel
	 * @return
	 */
	public String checkTel(String tel){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select COUNT(1) from Wineshop_table where Wineshop_Telephone=?";
		Object code = null;
		try {
			code = (Object) qr.query(sql, new ScalarHandler(),tel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(code.toString());
		
	}
	/**
	 * �û�����
	 * @param tel
	 * @return
	 */
	public Wineshop checkTelObject(String tel){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Wineshop_table where Wineshop_Telephone=?";
		Wineshop wine = null;
		try {
			wine = qr.query(sql, new BeanHandler<Wineshop>(Wineshop.class),tel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wine;
	}
	/**
	 * ͨ���绰���������
	 * @param pwd
	 * @param tel
	 * @return
	 */
		public String updatePwd(String pwd ,String tel){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update Wineshop_table set Wineshop_Password=? where Wineshop_Telephone=?";
		String code = null;
		try {
			int staus = qr.update(sql,pwd,tel);
			if(staus > 0){
				code = "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
		/**
		 * ע��
		 * @param username
		 * @param pwd
		 * @param tel
		 * @return
		 */
		public String addUser(String username,String pwd){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(new Date());
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "insert into Wineshop_table (Wineshop_UserName,Wineshop_Password,Role_ID,Regionality_ID,Wineshop_Condition,Wineshop_Class,Wineshop_Nature,Wineshop_Date,Wineshop_QY,Logout) values(?,?,?,?,?,?,?,?,?,?)";
			String code = null;
			try {
				int staus = qr.update(sql,username,pwd,2,3,1,1,"��ͨ�Ƶ�",time,"���˿���",0);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * �޸��ŵ���Ϣ
		 * @param username
		 * @param wineshopName
		 * @return
		 */
		public String updateWineshopName(String username,String wineshopName){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "update Wineshop_table set Wineshop_Name=? where Wineshop_UserName=?";
			String code = null;
			try {
				int staus = qr.update(sql,wineshopName,username);
				System.out.println(staus);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * �޸ĵ�ַ
		 * @param username
		 * @param wineshopAddr
		 * @return
		 */
		public String updateWineshopAddr(String username,String wineshopAddr){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "update Wineshop_table set Wineshop_Address=? where Wineshop_UserName=?";
			String code = null;
			try {
				int staus = qr.update(sql,wineshopAddr,username);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * �޸ĵ绰����
		 * @param username
		 * @param wineshopTel
		 * @return
		 */
		public String updateWineshopTel(String username,String wineshopTel){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "update Wineshop_table set Wineshop_Telephone=? where Wineshop_UserName=?";
			String code = null;
			try {
				int staus = qr.update(sql,wineshopTel,username);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * �޸��Ƽ���
		 * @param username
		 * @param wineshopTuiJian
		 * @return
		 */
		public String updateWineshopTuiJian(String username,String wineshopTuiJian){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "update Wineshop_table set Wineshop_TuiJian=? where Wineshop_UserName=?";
			String code = null;
			try {
				int staus = qr.update(sql,wineshopTuiJian,username);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * �޸��ջ�ʱ��
		 * @param username
		 * @param wineshopStart
		 * @param wineshopEnd
		 * @return
		 */
		public String updateWineshopTime(String wineshopStart,String wineshopEnd,String username){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "update Wineshop_table set Wineshop_Time=? , Wineshop_TimeNight=? where Wineshop_UserName=?";
			String code = null;
			try {
				int staus = qr.update(sql,wineshopStart,wineshopEnd,username);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * ������Ϣ
		 * @param name
		 * @param addr
		 * @param tel
		 * @param time1
		 * @param time2
		 * @param tuijian
		 * @param username
		 * @return
		 */
		public String wangshang(String name,String addr,String tel,String time1,String time2,String tuijian,String username){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "update Wineshop_table set Wineshop_Name=? , Wineshop_Address=? , Wineshop_Telephone=? , Wineshop_Time=? , Wineshop_TimeNight=? , Wineshop_TuiJian=? where Wineshop_UserName=?";
			String code = null;
			try {
				int staus = qr.update(sql,name,addr,tel,time1,time2,tuijian,username);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * �����޸��û���
		 * @param wineshopUserName
		 * @param username
		 * @return
		 */
		public String updateUserName(String wineshopUserName,String username){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "update Wineshop_table set Wineshop_UserName=? where Wineshop_UserName=?";
			String code = null;
			try {
				int staus = qr.update(sql,wineshopUserName,username);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * ע���û�
		 * @param logout
		 * @param username
		 * @return
		 */
		public String logOut(int logout,String username){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "update Wineshop_table set Logout=? where Wineshop_UserName=?";
			String code = null;
			try {
				int staus = qr.update(sql,logout,username);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * С�����¼
		 * @param openid
		 * @param petName
		 * @param sex
		 * @param image
		 * @return
		 */
		public String addWXLogin(String openid,String petName,int sex,String image){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(new Date());
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "insert into Wineshop_table (Wineshop_UserName,Role_ID,Regionality_ID,Wineshop_Condition,Wineshop_Class,Wineshop_Nature,Wineshop_Date,Wineshop_QY,Logout,image,sex,petName,openId) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String code = null;
			try {
				int staus = qr.update(sql,petName,2,3,1,1,"��ͨ�Ƶ�",time,"���˿���",0,image,sex,petName,openid);
				if(staus > 0){
					code = "success";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return code;
		}
		/**
		 * openId�Ƿ����
		 * @param openid
		 * @return
		 */
		public Wineshop checkOpenId(String openid){
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			String sql = "select * from Wineshop_table where openId= ? ";
			Wineshop wine = null;
			try {
				wine = qr.query(sql, new BeanHandler<Wineshop>(Wineshop.class),openid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return wine;
		}
		
}
