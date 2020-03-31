package com.sumeng.web;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sec.entity.PareMenuPath;
import com.sec.entity.RolePower;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;
import com.sumeng.service.MenuPath;

public class RolePowerDao {
	/**
	 * ��ѯ��ɫ����Ӧ��Ȩ��
	 * @return
	 */
	public List<RolePower> getRolePower(int roleId){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		List<RolePower> list = null;
		Page page = new Page();
		String sql = "select rm.Role_ID , m.id , m.menuName , m.starts from RoleMenu_table rm join Menu_table m on rm.mid = m.id where rm.Role_ID="+roleId+"";
		try {
			list = qr.query(sql, new BeanListHandler<RolePower>(RolePower.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * ͨ��Ȩ�޷����õ���ӦȨ��
	 * @param mid
	 * @param roleId
	 * @return
	 */
	public Page getRolePowerPare(int mid,int roleId){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		List<PareMenuPath> list = null;
		Page page = new Page();
		String sql = "select pm.pare_menu_name,pm.pare_menu_path,pm.starts from  RolePareMenu_table rpm join PareMenu_table pm on rpm.pareMenuId=pm.pareMenuId where pm.mId="+mid+" and rpm.Role_ID="+roleId+" and pm.starts=1";
		try {
			list = qr.query(sql, new BeanListHandler<PareMenuPath>(PareMenuPath.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		page.setData(list);
		return page;
	}
	/**
	 * ͨ���������Ƶõ�id
	 * 
	 * @param menuName
	 * @return
	 */
	public MenuPath getByMenuId(String menuName){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		MenuPath menu = new MenuPath();
		String sql = "select id from Menu_table where menuName=?";
		try {
			menu = qr.query(sql, new BeanHandler<MenuPath>(MenuPath.class),menuName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

}
