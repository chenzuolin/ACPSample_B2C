package com.sumeng.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sec.entity.Uapp;
import com.sec.util.BeanDao;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;

public class UappDao {
	public Page getTotalCount(int currentPage,int size){
		Page page = new Page();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		int totalNum = 0;
		try {
			connection = BeanDao.getConnection();
			String sql = "select count(*) from Uapp_table";
			prepareStatement = connection.prepareStatement(sql);
			rs = prepareStatement.executeQuery();
			while(rs.next()){
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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				BeanDao.closeAll(connection, prepareStatement, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return page;
		
	}
	public Page getTotalData(int currentPage,int size,Page dd){
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		List<Uapp> list = new ArrayList<Uapp>();
		try { 
			connection = BeanDao.getConnection();
			String sql = "select top "+size+" * from (select row_number() over(order by udate desc) as rownumber,* from Uapp_table) temp_row where rownumber>(("+currentPage+"-1)*"+size+");";
			prepareStatement = connection.prepareStatement(sql);
			rs = prepareStatement.executeQuery();
			while(rs.next()){
				Uapp app = new Uapp();
				app.setUid(rs.getInt("uid"));
				app.setAppusername(rs.getString("appusername"));
				app.setUname(rs.getString("uname"));
				app.setUdate(rs.getString("udate"));
				app.setUtype(rs.getString("utype"));
				list.add(app);
				dd.setData(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				BeanDao.closeAll(connection, prepareStatement, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dd;
		
	}
	public int update(Uapp app){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int updateType = 0;
		try{
			conn = BeanDao.getConnection();
			String sql = "update Uapp_table set utype = ? where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, app.getUtype());
			ps.setInt(2, app.getUid());
			boolean execute = ps.execute();
			if(!execute){
				updateType = 200;
			}else{
				updateType = 500;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				BeanDao.closeAll(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateType;
		
	}
	public int delete(int uid){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int code = 0;
		try{
			conn = BeanDao.getConnection();
			String sql = "delete from Uapp_table where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			boolean execute = ps.execute();
			if(!execute){
				code = 200;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				BeanDao.closeAll(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return code;
	}
	/**
	 * 
	 * @param currentPage
	 * @param size
	 * @param name
	 * @return
	 */
	public Page logLike(int currentPage,int size,String name){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		Page page = new Page();
		String sqlTotalCount = "select COUNT(*) from Uapp_table where appusername like "+"'%"+""+name+""+"%'"+"";
		String sqlData = "select top "+size+" * from (select row_number() "
				+ "over(order by udate desc) as"
				+ " rownumber,* from Uapp_table where appusername like "+"'%"+""+name+""+"%'"+")temp_row where rownumber>(("+currentPage+"-1)*"+size+")";
		Object count = null;
		List<Uapp> list = null;
		try {
			count = qr.query(sqlTotalCount,new ScalarHandler());
			list = qr.query(sqlData, new BeanListHandler<Uapp>(Uapp.class));
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



}
