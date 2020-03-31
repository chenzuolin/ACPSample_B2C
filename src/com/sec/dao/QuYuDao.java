package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.QuYu;

public class QuYuDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	
	public List <QuYu> findAll(){//根据密码和用户查询
               
                List<QuYu> list = new ArrayList<QuYu>();
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection(url,username,pwd);
					pstmt = conn.prepareStatement("select * from QY_table ");
					
					rs = pstmt.executeQuery();
					
					while(rs.next()){
						QuYu q = new QuYu();
						q.setQY_ID(rs.getInt("QY_ID"));
						q.setQY_Name(rs.getString("QY_Name"));
						list.add(q);
						
						
					
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
	
	

}
