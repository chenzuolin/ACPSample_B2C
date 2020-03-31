package com.sec.util;
 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
/**
 * ����Java���似������ѯ�����װΪ����
 */
public class ORMTest {
	/**
	 * ���Է�װ�������
	 * @param sql
	 * @param clazz
	 * @return
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static List<Object> getObjects(String sql, @SuppressWarnings("rawtypes") Class clazz) 
			throws SQLException, InstantiationException, 
			IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = GetConn.get();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			String[] colNames = getColNames(rs);
			
			List<Object> objects = new ArrayList<Object>();
			//��ȡ���еĹ�������
			Method[] ms = clazz.getMethods();
			while(rs.next()) {
				//����һ���¶���
				Object object = clazz.newInstance();
				for(int i = 0; i < colNames.length; i ++) {
					String colName = colNames[i];
					//��ȡset�����ķ�����
					String methodName = "set" + colName;
					for(Method m : ms) {
						if(methodName.equals(m.getName())) {
							m.invoke(object, rs.getObject(colName));
							break;
						}
					}
					objects.add(object);
				}
			}
			return objects;
		} finally {
			GetConn.close(conn, ps, rs);
		}
	}
 
	/**
	 * ���ݽ������ȡ��ѯ����ı���
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static String[] getColNames(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		//��ȡ��ѯ������
		int count = rsmd.getColumnCount();
		String[] colNames = new String[count];
		for(int i = 1; i <= count; i ++) {
			//��ȡ��ѯ��ı���
			colNames[i - 1] = rsmd.getColumnLabel(i);
		}
		return colNames;
	}
	
	/**
	 * ��װ��������
	 * @param sql
	 * @param clazz
	 * @return
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	static Object getObject(String sql, @SuppressWarnings("rawtypes") Class clazz) 
			throws SQLException, InstantiationException, 
			IllegalAccessException, NoSuchMethodException, 
			SecurityException, IllegalArgumentException, 
			InvocationTargetException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = GetConn.get();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			String[] colNames = getColNames(rs);
			
			Object object = null;
			Method[] ms = clazz.getMethods();
			if(rs.next()) {
				object = clazz.newInstance();
				for(int i = 0; i < colNames.length; i ++) {
					String colName = colNames[i];
					String methodName = "set" + colName;
					
					//ֱ�Ӹ��ݷ�������ȡ��Ӧ��Method����
					/*Object value = rs.getObject(colName);
					@SuppressWarnings("unchecked")
					Method m = clazz.getMethod(methodName, value.getClass());
					if(m != null) {
						m.invoke(object, value);
					}*/
					
					for(Method md : ms) {
						if(methodName.equals(md.getName())) {
							md.invoke(object, rs.getObject(colName));
							break;
						}
					}
				}
			}
			return object;
		} finally {
			GetConn.close(conn,ps,rs);
		}
	}
	
}
