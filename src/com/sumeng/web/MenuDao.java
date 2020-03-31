package com.sumeng.web;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sec.entity.Role;
import com.sec.util.C3p0Utils;
import com.sumeng.service.MenuPath;
import com.sumeng.service.PareMenu;

/**
 * 该类用于权限分配
 * @author 陈作麟
 * @Date 07/23
 *
 */
public class MenuDao {
	/**
	 *该方法得到角色编号,权限分栏id,分栏名称，分栏状态
	 * @param uid 用户编号
	 * @return
	 */
	public List<MenuPath> getPath(int uid){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		List<MenuPath> list = null;
		String sql = "select User_Role_table.Role_ID,Menu_table.id,Menu_table.menuName,Menu_table.starts "
				+ "from User_Role_table , RoleMenu_table , Menu_table "
				+ "where User_Role_table.Role_ID = RoleMenu_table.Role_ID "
				+ "and RoleMenu_table.mid = Menu_table.id "
				+ "and User_Role_table.User_ID=?";
		try {
			list = qr.query(sql, new BeanListHandler<MenuPath>(MenuPath.class),uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 同过资源id得到资源路径
	 * @param mid 资源id
	 * @return
	 */
	public List<PareMenu> getPareMenu(int mid,int roleId){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select PareMenu_table.pare_menu_name,PareMenu_table.pare_menu_path,PareMenu_table.starts,RolePareMenu_table.code "
				+ "from PareMenu_table join RolePareMenu_table on PareMenu_table.pareMenuId=RolePareMenu_table.pareMenuId "
				+ "and PareMenu_table.mId="+mid+" and RolePareMenu_table.Role_ID ="+roleId+"";
		List<PareMenu> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<PareMenu>(PareMenu.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 通过UID得到角色权限
	 * @param uid
	 * @return
	 */
	public Role getUid(int uid){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select r.Role_Name from User_Role_table ur join Role_table r on ur.Role_ID = r.Role_ID where ur.User_ID="+uid+"";
		Role role = new Role();
		try {
			role = qr.query(sql, new BeanHandler<Role>(Role.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

}
