package com.sumeng.web;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sec.entity.BigType;
import com.sec.entity.Url;
import com.sec.util.C3p0Utils;

public class UrlDao {
	public Url getQuery(){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from url_table where urlId=1";
		Url uu = new Url();
		try {
			uu = qr.query(sql, new BeanHandler<Url>(Url.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uu;
	}

}
