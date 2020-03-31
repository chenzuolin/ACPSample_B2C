package com.sumeng.web;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.sec.Activity.Activity;
import com.sec.Activity.SB;
import com.sec.util.C3p0Utils;

public class MoneyDao {
	/**
	 * ��ѯ��ֵ�ܽ��
	 * @param id
	 * @return
	 */
	public SB queryAll(Integer id){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from SB_table where Wineshop_ID=?";
		SB  sb = new SB();
		try {
			sb = qr.query(sql, new BeanHandler<SB>(SB.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sb;
	}
	/**
	 * ��ֵ��¼
	 * @param id
	 * @return
	 */
	public List<Activity> queryMoney(Integer id){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Activity_table where Wineshop_ID=? and Activity_Status!='Ԥ��ֵ'";
		List<Activity>  list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Activity>(Activity.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * ���Ѽ�¼
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> queryXiaofei(Integer id){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Indent_table where Wineshop_ID=? and Indent_ZZZ != '' and Indent_Status!='����֧��'";
		List<Map<String,Object>>  list = null;
		try {
			list = qr.query(sql, new MapListHandler(),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
