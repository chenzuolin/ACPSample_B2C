package com.sumeng.web;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sec.entity.User;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;
import com.sumeng.service.UserInfo;

public class UserDao {
	/**
	 * 查询全部用户
	 * @return
	 */
	public Page findAll(){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "select u.User_ID,u.User_Name,u.User_Password,u.sex,u.birthday,u.profile,u.User_Date,r.Role_ID,r.Role_Name,r.Role_Remark from User_table u join User_Role_table ur on u.User_ID = ur.User_ID join Role_table r on ur.Role_ID=r.Role_ID";
		Page page = new Page();
		List<UserInfo> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<UserInfo>(UserInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		page.setData(list);
		return page;
	}
	/**
	 * 添加用户信息0
	 * @param user
	 * @return
	 */
	public int addUserInfo(User user){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "insert into User_table (User_Name,User_Password,Role_ID,Department_ID,sex,birthday,profile,User_Date) values (?,?,?,?,?,?,?,?)";
		String sqlData = "select * from User_table where User_Name=?";
		String userRole = "insert into User_Role_table (User_ID,Role_ID) values (?,?)";
		User uu = new User();
		int code = 0;
		int msg = 0;
		try {
			code = qr.update(sql, user.getUser_Name(),user.getUser_Password(),user.getRole_ID(),user.getDepartment_ID(),user.getSex(),user.getBirthday(),user.getProfile(),user.getUser_Date());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(code >0){
			try {
				uu = qr.query(sqlData, new BeanHandler<User>(User.class),user.getUser_Name());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(uu.getUser_ID()!=0){
			try {
				msg = qr.update(userRole,user.getRole_ID(),uu.getUser_ID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return msg > 0?200:-1;
	}
	public int updateUser(User user){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update User_table set User_Name=? , User_Password=? , birthday=? , Role_ID=? , profile=? where User_ID=? ";
		int code = 0;
		try {
			code = qr.update(sql, user.getUser_Name(),user.getUser_Password(),user.getBirthday(),user.getRole_ID(),user.getProfile(),user.getUser_ID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code > 0? 200:-1;
	}

}
