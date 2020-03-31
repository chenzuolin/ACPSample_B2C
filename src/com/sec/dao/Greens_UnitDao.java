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

import com.sec.entity.Greens_Character;
import com.sec.entity.Greens_Unit;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;

public class Greens_UnitDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Greens_Unit greens_Unit) {//添加数据
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接
			String sql = "insert into Greens_Unit_table(Greens_Unit) values (?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, greens_Unit.getGreens_Unit());
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
	
	public List<Greens_Unit> findAll(){//查询表的所有信息
        List<Greens_Unit> list2 = new ArrayList<Greens_Unit>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Greens_Unit_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				Greens_Unit greens_Unit = new Greens_Unit();
				greens_Unit.setGreens_Unit(rs.getString(2));
				list2.add(greens_Unit);
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
        return list2;
    }


	public List<Greens_Unit> findleixin(String Class_Name){//查询表的所有信息
        List<Greens_Unit> list2 = new ArrayList<Greens_Unit>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Greens_Unit_table where Class_Name = ?");
			pstmt.setString(1,Class_Name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Greens_Unit greens_Unit = new Greens_Unit();
				greens_Unit.setGreens_Unit(rs.getString(2));
				list2.add(greens_Unit);
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
        return list2;
    }
	/**
	 * 蔬菜单位显示
	 * @param currentPage
	 * @param size
	 * @return
	 */
	public Page checkGreensUnit(int currentPage,int size){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		Page page = new Page();
		String sqlTotalCount = "select COUNT(1) from Greens_Unit_table";
		String sqlData = "select top "+size+" * from (select row_number() "
				+ "over(order by Greens_Unit_ID asc) as"
				+ " rownumber,* from Greens_Unit_table)temp_row where rownumber>(("+currentPage+"-1)*"+size+")";
		Object count = null;
		List<Greens_Unit> list = null;
		try {
			count = qr.query(sqlTotalCount,new ScalarHandler());
			list = qr.query(sqlData, new BeanListHandler<Greens_Unit>(Greens_Unit.class));
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
	 * 蔬菜单位修改
	 * @param greens
	 * @return
	 */
	public int updateGreensUnit(Greens_Unit greens){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update Greens_Unit_table set Greens_Unit=? where Greens_Unit_ID=?";
		int rows = 0;
		try {
			rows = qr.update(sql, greens.getGreens_Unit(),greens.getGreens_Unit_ID());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rows > 0? 200 : -1;
	}
	/**
	 * 通过蔬菜单位id删除蔬菜单位
	 * @param unitId
	 * @return
	 */
	public int delUnitById(int unitId){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from Greens_Unit_table where Greens_Unit_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,unitId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code > 0? 200 : -1;
	}
	/**
	 * 根据编号修改单位
	 * @param unit
	 * @return
	 */
	public int updateUnitById(Greens_Unit unit){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update Greens_Unit_table set Greens_Unit=? where Greens_Unit_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,unit.getGreens_Unit(),unit.getGreens_Unit_ID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code > 0? 200 : -1;
	}



}
