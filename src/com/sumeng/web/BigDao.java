package com.sumeng.web;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sec.entity.BigType;
import com.sec.entity.Greens;
import com.sec.entity.Greens_Type;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;

/**
 * 
 * @author Administrator
 *
 */
public class BigDao {
	/**
	 * �����ѯ
	 * @return
	 */
	public List<BigType> queryAll(){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from BigType_table order by sore asc";
		List<BigType>  big = null;
		try {
			big = qr.query(sql, new BeanListHandler<BigType>(BigType.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return big;
	}
	/**
	 * ͨ�������ѯС��
	 * @param bigName ��������
	 * @return
	 */
	public List<Greens_Type> queryType(String bigName){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Greens_Type_table where bigTypeName = ? order by LEN(Greens_Type_Name) asc";
		List<Greens_Type> type = null;
		try {
			type = qr.query(sql, new BeanListHandler<Greens_Type>(Greens_Type.class),bigName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}
	/**
	 * ͨ���������Ʋ�ѯ�߲˱�
	 * @param bigName
	 * @return
	 */
	public List<Greens> findByBigName(String bigName){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Greens_table where Greens_BigName=?";
		List<Greens> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Greens>(Greens.class),bigName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * ���д���
	 * @return
	 */
	public List<BigType> getFindAll(){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from BigType_table";
		List<BigType> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<BigType>(BigType.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * ��������Ӧ��С��
	 * @param bigName
	 * @return
	 */
	public Page getType(String bigName){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from Greens_Type_table where BigTypeName=?";
		Page page = new Page();
		List<Greens_Type> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Greens_Type>(Greens_Type.class),bigName);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		page.setData(list);
		return page;
	}
	/**
	 * ��ѯȫ������
	 * @return
	 */
	public Page getBigTypeName(){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select * from BigType_table";
		Page page = new Page();
		List<BigType> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<BigType>(BigType.class));
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		page.setData(list);
		return page;
	}
	/**
	 * 
	 * @param bigName
	 * @return
	 */
	public int add(String bigName){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into BigType_table ( bigTypeName ) values(?)";
		int code = 0;
		try {
			code = qr.update(sql,bigName);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return code > 0? 200 : -1;
	}
	

}
