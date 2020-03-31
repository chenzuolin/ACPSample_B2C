package com.sec.dao;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Greens_Jobber;
import com.sec.entity.User;
import com.sec.util.ImageUtil;




public class Greens_JobberDao{
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void update1(Greens_Jobber greens_Jobber){//更新所选择的字段
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Greens_Jobber_table set Greens_Jobber_UserName=?,Greens_Jobber_Password=?,Greens_Jobber_Address=?,Greens_Jobber_Shift_Name=?,Greens_Jobber_Telephone=?,Greens_Jobber_QQ=?,Greens_Jobber_WeChat=? where Greens_Jobber_ID=?";
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, greens_Jobber.getGreens_Jobber_UserName());
			pstmt.setString(2, greens_Jobber.getGreens_Jobber_Password());
			
			
			pstmt.setString(3, greens_Jobber.getGreens_Jobber_Address());
			pstmt.setString(4, greens_Jobber.getGreens_Jobber_Shift_Name());
			pstmt.setString(5, greens_Jobber.getGreens_Jobber_Telephone());
			
			
			pstmt.setString(6, greens_Jobber.getGreens_Jobber_QQ());
			pstmt.setString(7, greens_Jobber.getGreens_Jobber_WeChat());
			pstmt.setInt(8, greens_Jobber.getGreens_Jobber_ID());
			
			boolean y=pstmt.execute();
			if(!y){
				System.out.println("操作成功");
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
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
	public List<Greens_Jobber> findUserByID1(int Greens_Jobber_ID){//根据编号查询信息
		List<Greens_Jobber> list = new ArrayList<Greens_Jobber>();
		Greens_Jobber greens_Jobber = new Greens_Jobber();
	     
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Greens_Jobber_table where Greens_Jobber_ID=?");
			pstmt.setInt(1,Greens_Jobber_ID);
			rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
			while(rs.next()){
				greens_Jobber.setGreens_Jobber_ID(rs.getInt(1));
				greens_Jobber.setGreens_Jobber_UserName(rs.getString(2));
				greens_Jobber.setGreens_Jobber_Password(rs.getString(3));
				greens_Jobber.setRole_ID(rs.getInt(4));
				greens_Jobber.setGreens_Jobber_Name(rs.getString(5));
				greens_Jobber.setGreens_Jobber_Aptitude(rs.getString(6));
				greens_Jobber.setGreens_Jobber_Address(rs.getString(7));
				greens_Jobber.setGreens_Jobber_Shift_Name(rs.getString(8));
				greens_Jobber.setGreens_Jobber_Telephone(rs.getString(9));
				greens_Jobber.setGreens_Jobber_Time(rs.getString(10));
				greens_Jobber.setRegionality_ID(rs.getInt(11));
				greens_Jobber.setGreens_Jobber_QQ(rs.getString(12));
				greens_Jobber.setGreens_Jobber_WeChat(rs.getString(13));
				greens_Jobber.setGreens_Jobber_Grade(rs.getString(14));
				list.add(greens_Jobber);
				
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally{
	        //8，关闭资源
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
public void update5(Greens_Jobber greens_Jobber){//更新
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Greens_Jobber_table set Greens_Jobber_Password=? where Greens_Jobber_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, greens_Jobber.getGreens_Jobber_Password());
			pstmt.setInt(2, greens_Jobber.getGreens_Jobber_ID());
			boolean b=pstmt.execute();
			if(!b){
				System.out.println("操作成功");
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		System.out.println("连接创建失败！");
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

	public void add(Greens_Jobber greens_Jobber) throws IOException {//添加数据
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			conn = DriverManager.getConnection(url,username,pwd);//连接 
			String sql = "insert into Greens_Jobber_table (Greens_Jobber_UserName,Greens_Jobber_Password,Role_ID,Greens_Jobber_Name,Greens_Jobber_Aptitude,Greens_Jobber_Address,Greens_Jobber_Shift_Name,Greens_Jobber_Telephone,Greens_Jobber_Time,Regionality_ID,Greens_Jobber_QQ,Greens_Jobber_WeChat,Greens_Jobber_Grade) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, greens_Jobber.getGreens_Jobber_UserName());
			pstmt.setString(2, greens_Jobber.getGreens_Jobber_Password());
			pstmt.setInt(3, greens_Jobber.getRole_ID());
			pstmt.setString(4, greens_Jobber.getGreens_Jobber_Name());
			
			pstmt.setString(5, greens_Jobber.getGreens_Jobber_Aptitude());
			pstmt.setString(6, greens_Jobber.getGreens_Jobber_Address());
			pstmt.setString(7, greens_Jobber.getGreens_Jobber_Shift_Name());
			pstmt.setString(8, greens_Jobber.getGreens_Jobber_Telephone());
			pstmt.setString(9, greens_Jobber.getGreens_Jobber_Time());
			pstmt.setInt(10, greens_Jobber.getRegionality_ID());
			pstmt.setString(11, greens_Jobber.getGreens_Jobber_QQ());
			pstmt.setString(12, greens_Jobber.getGreens_Jobber_WeChat());
			pstmt.setString(13, greens_Jobber.getGreens_Jobber_Grade());
			boolean a=pstmt.execute();
			if(!a){
				System.out.println("添加成功");
			}else
				System.out.println("添加失败");		
		}catch(ClassNotFoundException e){
			System.out.println("注册驱动失败！");
		}catch(SQLException e){
			System.out.println("连接创建失败！！");//异常抛出
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

public void update(Greens_Jobber greens_Jobber){//更新
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Greens_Jobber_table set Greens_Jobber_Name=?,Greens_Jobber_Aptitude=?,Greens_Jobber_Address=?,Greens_Jobber_Shift_Name=?,Greens_Jobber_Telephone=?,Greens_Jobber_Time=?,Regionality_ID=?,Greens_Jobber_QQ=?,Greens_Jobber_WeChat=?,Greens_Jobber_Grade=? where Greens_Jobber_ID=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, greens_Jobber.getGreens_Jobber_Name());
			pstmt.setString(2, greens_Jobber.getGreens_Jobber_Aptitude());
			pstmt.setString(3, greens_Jobber.getGreens_Jobber_Address());
			pstmt.setString(4, greens_Jobber.getGreens_Jobber_Shift_Name());
			pstmt.setString(5, greens_Jobber.getGreens_Jobber_Telephone());
			pstmt.setString(6, greens_Jobber.getGreens_Jobber_Time());
			pstmt.setInt(7, greens_Jobber.getRegionality_ID());
			pstmt.setString(8, greens_Jobber.getGreens_Jobber_QQ());
			pstmt.setString(9, greens_Jobber.getGreens_Jobber_WeChat());
			pstmt.setString(10, greens_Jobber.getGreens_Jobber_Grade());
			pstmt.setInt(11, greens_Jobber.getGreens_Jobber_ID());
			
			boolean y=pstmt.execute();
			if(!y){
				System.out.println("操作成功");
			}else
				System.out.println("操作失败");
			
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
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


public Greens_Jobber delete(int Greens_Jobber_ID){//删除
	Greens_Jobber greens_Jobber=new Greens_Jobber();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "delete * from  Greens_Jobber_table where Greens_Jobber_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, greens_Jobber.getGreens_Jobber_ID());
			pstmt.executeUpdate(sql);
			boolean o=pstmt.execute();
			if(!o){
				System.out.println("输出成功");
			}else
				System.out.println("输出失败");
	}catch(ClassNotFoundException e){
		System.out.println("注册驱动失败！");
	}catch(SQLException e){
		
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
	return greens_Jobber;	
	}
public Greens_Jobber findUserByID(int Greens_Jobber_ID){//根据编号查询信息
	Greens_Jobber greens_Jobber = new Greens_Jobber();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_Jobber_table where Greens_Jobber_ID=?");
		pstmt.setInt(1,Greens_Jobber_ID);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		if(rs.next()!=false){
			greens_Jobber.setGreens_Jobber_ID(rs.getInt(1));
			greens_Jobber.setGreens_Jobber_Name(rs.getString(2));
			greens_Jobber.setGreens_Jobber_Aptitude(rs.getString(3));
			greens_Jobber.setGreens_Jobber_Address(rs.getString(4));
			greens_Jobber.setGreens_Jobber_Shift_Name(rs.getString(5));
			greens_Jobber.setGreens_Jobber_Telephone(rs.getString(6));
			greens_Jobber.setGreens_Jobber_Time(rs.getString(7));
			greens_Jobber.setRegionality_ID(rs.getInt(8));
			greens_Jobber.setGreens_Jobber_QQ(rs.getString(9));
			greens_Jobber.setGreens_Jobber_WeChat(rs.getString(10));
			greens_Jobber.setGreens_Jobber_Grade(rs.getString(11));
			
			
		}
    }catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        //8，关闭资源
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
    return greens_Jobber;
}	


public List<Greens_Jobber> findAll(){//查询表的所有信息
	        List<Greens_Jobber> greens_Jobbers = new ArrayList<Greens_Jobber>();
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from Greens_Jobber_table");
				rs = pstmt.executeQuery();
				while(rs.next()){
					Greens_Jobber greens_Jobber = new Greens_Jobber();
					greens_Jobber.setGreens_Jobber_ID(rs.getInt(1));
					greens_Jobber.setGreens_Jobber_Name(rs.getString(2));
					greens_Jobber.setGreens_Jobber_Aptitude(rs.getString(3));
					greens_Jobber.setGreens_Jobber_Address(rs.getString(4));
					greens_Jobber.setGreens_Jobber_Shift_Name(rs.getString(5));
					greens_Jobber.setGreens_Jobber_Telephone(rs.getString(6));
					greens_Jobber.setGreens_Jobber_Time(rs.getString(7));
					greens_Jobber.setRegionality_ID(rs.getInt(8));
					greens_Jobber.setGreens_Jobber_QQ(rs.getString(9));
					greens_Jobber.setGreens_Jobber_WeChat(rs.getString(10));
					greens_Jobber.setGreens_Jobber_Grade(rs.getString(11));
					
					
					greens_Jobbers.add(greens_Jobber);
				}
	        }catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            //8，关闭资源
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
	        return greens_Jobbers;
	    }

public int findGreens_Type_ID(String userName){
	Greens_Jobber gg = new Greens_Jobber();
    int aa = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Greens_Jobber_table where Greens_Jobber_UserName=?");
		pstmt.setString(1,userName);
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
		while(rs.next()){
			aa = rs.getInt("Greens_Jobber_ID");
		}
    }catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        //8，关闭资源
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
    return aa;
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
		rs = pstmt.executeQuery();//执行SQL语句，并返回结果集
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
        //8，关闭资源
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
public int checkGreen_Jobber(String usename,String pass){//根据密码和用户查询
	
int a=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Greens_Jobber_table where Greens_Jobber_UserName=? and Greens_Jobber_Password=?");
			pstmt.setString(1, usename);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()){
				a=rs.getInt("Greens_Jobber_ID");
			}
		}catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //8，关闭资源
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
        return a;
    }

public int checkGreen_Jobber1(String usename,String pass){//根据密码和用户查询
	
int a=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Greens_Jobber_table where Greens_Jobber_UserName=? and Greens_Jobber_Password=?");
			pstmt.setString(1, usename);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()){
				a=1;
			}
		}catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //8，关闭资源
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
        return a;
    }

}

		        

		        
