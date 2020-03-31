package com.sumeng.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sec.Activity.SB;
import com.sec.util.C3p0Utils;

public class SbDao {
	public Map<String,Object> queryAll(int currentPage,int size){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sqlDate = "select top "+size+" * from (select row_number() over(order by w.Wineshop_Date desc) as rownumber,"
				+ "w.Wineshop_Name,w.Wineshop_Telephone,w.Wineshop_TuiJian,s.* "
				+ "from Wineshop_table w join SB_table s  "
				+ "on w.Wineshop_ID= s.Wineshop_ID) temp_row where rownumber>(("+currentPage+"-1)*"+size+")";
		String sqlCount = "select COUNT(1) from Wineshop_table w join SB_table s on w.Wineshop_ID=s.Wineshop_ID";
		Map<String,Object> getDate = new HashMap<String, Object>();
		List<Map<String,Object>> map = null;
		Object obj = null;
		try {
			map = qr.query(sqlDate, new MapListHandler());
			obj = qr.query(sqlCount, new ScalarHandler());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int totalCount = Integer.parseInt(obj.toString());
		int totalPage = 0;
		if(totalCount%size==0){
			totalPage = totalCount/size;
		}else{
			totalPage = totalCount/size+1;
		}
		getDate.put("code", 0);
		getDate.put("count", totalCount);
		getDate.put("data", map);
		getDate.put("currentPage", currentPage);
		getDate.put("totalPage", totalPage);
		return getDate;
	}
	public int updateOff(int wid,int off){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update SB_table set Num_OFF=? where Wineshop_ID=?";
		int row = 0;
		try {
			row = qr.update(sql,off,wid);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return row>0?200:0;
	}

}
