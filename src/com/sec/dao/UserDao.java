package com.sec.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.*;

public class UserDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
public void add(User user){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into User_table (User_Name,User_Password,Role_ID,Department_ID) values(?,?,?,?)";//SQL���
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_Name());
			pstmt.setString(2, user.getUser_Password());
			pstmt.setInt(3, user.getRole_ID());
			pstmt.setInt(4, user.getDepartment_ID());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("��ӳɹ�");
			}else
				System.out.println("���ʧ��");
				
		}catch(ClassNotFoundException e){
			System.out.println("ע������ʧ�ܣ�");
		}catch(SQLException e){
			System.out.println("���Ӵ���ʧ�ܣ���");//�쳣�׳�
		}finally{
			try{
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
		
	}
public List<User> findUserByID1(int User_ID){
	List<User> list = new ArrayList<User>();
    User user = new User();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from User_table where User_ID=?");
		pstmt.setInt(1,User_ID);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		if(rs.next()!=false){
			user.setUser_ID(rs.getInt(1));
			user.setUser_Name(rs.getString(2));
			user.setUser_Password(rs.getString(3));
			user.setRole_ID(rs.getInt(4));
			user.setDepartment_ID(rs.getInt(5));
			list.add(user);
		}
    }catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        //8���ر���Դ
        try {
            if(rs!=null){
               rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
    return list;
}
public List<User> findUserByID33(int User_ID){//�����û���ģ����ѯ��Ϣ

    List<User> users = new ArrayList<User>();
    //��ѯ
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from User_table where User_ID=?");
		pstmt.setInt(1, User_ID);
		rs = pstmt.executeQuery();
		while(rs.next()){
			User user = new User();
			user.setUser_ID(rs.getInt("User_ID"));
			user.setUser_Name(rs.getString("User_Name"));
			user.setUser_Password(rs.getString("User_Password"));
			user.setRole_ID(rs.getInt("Role_ID"));
			user.setDepartment_ID(rs.getInt("Department_ID"));
			users.add(user);
		}
    }catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        //8���ر���Դ
        try {
            if(rs!=null){
               rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
    return users;
}
public void update5(User user){//����
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update User_table set User_Password=? where User_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUser_Password());
		pstmt.setInt(2, user.getUser_ID());
		boolean b=pstmt.execute();
		if(!b){
			System.out.println("�����ɹ�");
		}else
			System.out.println("����ʧ��");
		
}catch(ClassNotFoundException e){
	System.out.println("ע������ʧ�ܣ�");
}catch(SQLException e){
	System.out.println("���Ӵ���ʧ�ܣ�");
}finally{
	try{
	if(pstmt != null){
		pstmt.close();
	}
	if(conn != null){
		conn.close();
	}
}catch(SQLException e){
	e.printStackTrace();
}
}
}

public void update(User user){//����
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update User_table set User_Name=?,User_Password=?,Role_ID=?,Department_ID=? where User_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_Name());
			pstmt.setString(2, user.getUser_Password());
			pstmt.setInt(3, user.getRole_ID());
			pstmt.setInt(4, user.getDepartment_ID());
			pstmt.setInt(5, user.getUser_ID());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("�����ɹ�");
			}else
				System.out.println("����ʧ��");
			
	}catch(ClassNotFoundException e){
		System.out.println("ע������ʧ�ܣ�");
	}catch(SQLException e){
		System.out.println("");
	}finally{
		try{
		if(pstmt != null){
			pstmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	}
	}

public  void delete(int User_ID){//ɾ��
	
		User user=new User();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "delete * from  User_table where User_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, User_ID);
			pstmt.executeUpdate(sql);
			pstmt.execute();
			
		}catch(ClassNotFoundException e){
		System.out.println("ע������ʧ�ܣ�");
	}catch(SQLException e){
		System.out.println("���Ӵ���ʧ�ܣ���");
	}finally{
		try{
		if(pstmt != null){
			pstmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	}
		
	}

	
public int checkUser(String usename,String pass){//����������û���ѯ
		int k=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from User_table where User_Name=? and User_Password=?");
			pstmt.setString(1, usename);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()){
				k = rs.getInt("User_ID");
			}
		}catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //8���ر���Դ
            try {
                if(rs!=null){
                   rs.close();
                }
                if(pstmt!=null){
                    pstmt.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
             
        }
        return k;
    }
	
public User findUserByID(int User_ID){//���ݱ�Ų�ѯ�û�������
	        User user = new User();
	         
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from User_table where User_ID=?");
				pstmt.setInt(1,User_ID);
				rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
				if(rs.next()!=false){
					user.setUser_ID(rs.getInt(1));
					user.setUser_Name(rs.getString(2));
					user.setUser_Password(rs.getString(3));
					user.setRole_ID(rs.getInt(4));
					user.setDepartment_ID(rs.getInt(5));
				}
	        }catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            //8���ر���Դ
	            try {
	                if(rs!=null){
	                   rs.close();
	                }
	                if(pstmt!=null){
	                    pstmt.close();
	                }
	                if(conn!=null){
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	             
	        }
	        return user;
	 }

public List<User> findAll(){//��ѯ���������Ϣ
	        List<User> users = new ArrayList<User>();
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from User_table");
				rs = pstmt.executeQuery();
				while(rs.next()){
					User user = new User();
					user.setUser_ID(rs.getInt(1));
					user.setUser_Name(rs.getString(2));
					user.setUser_Password(rs.getString(3));
					user.setRole_ID(rs.getInt(4));
					user.setDepartment_ID(rs.getInt(5));
					users.add(user);
				}
	        }catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            //8���ر���Դ
	            try {
	                if(rs!=null){
	                   rs.close();
	                }
	                if(pstmt!=null){
	                    pstmt.close();
	                }
	                if(conn!=null){
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	             
	        }
	        return users;
	    }
	 
public List<User> findUserByNames(String name){//�����û���ģ����ѯ��Ϣ

	        List<User> users = new ArrayList<User>();
	        //��ѯ
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from User_table where User_Name like ?");
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				while(rs.next()){
					User user = new User();
					user.setUser_ID(rs.getInt("User_ID"));
					user.setUser_Name(rs.getString("User_Name"));
					user.setUser_Password(rs.getString("User_Password"));
					user.setRole_ID(rs.getInt("Role_ID"));
					user.setDepartment_ID(rs.getInt("Department_ID"));
					users.add(user);
				}
	        }catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            //8���ر���Դ
	            try {
	                if(rs!=null){
	                   rs.close();
	                }
	                if(pstmt!=null){
	                    pstmt.close();
	                }
	                if(conn!=null){
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	             
	        }
	        return users;
	    }

public int findRole_ID(String userName){
	User user = new User();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from User_table where User_Name=?");
		pstmt.setString(1,userName);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		while(rs.next()){
			
			user.setRole_ID(rs.getInt("Role_ID"));
		}
    }catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        //8���ر���Դ
        try {
            if(rs!=null){
               rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
    return user.getRole_ID();
}
}

	 
		        
