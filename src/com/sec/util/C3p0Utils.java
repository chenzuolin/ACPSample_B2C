package com.sec.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	private static ComboPooledDataSource datasource = new ComboPooledDataSource();
	
	public static DataSource getDataSource(){
		return datasource;
		
	}
	public static Connection getConnection(){
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
		
	}

}
