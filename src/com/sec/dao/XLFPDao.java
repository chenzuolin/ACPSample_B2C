package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Cart;
import com.sec.entity.Order;
import com.sec.entity.XLFP;

public class XLFPDao {
	
		String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
		String username="green";
		String pwd = "12345678";
		public void add(XLFP xlfp){//����
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
				conn = DriverManager.getConnection(url,username,pwd);//����
				String sql = "insert into XLFP_table (Greens_Type_Name,CG_Name) values(?,?)";//SQL���
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, xlfp.getGreens_Type_Name());
				pstmt.setString(2, xlfp.getCG_Name());
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
		
		public List<XLFP> findUserByID1(String CG_Name){//���ݱ�Ų�ѯ�û�������
			List<XLFP> list = new ArrayList<XLFP>();
		     
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from XLFP_table where CG_Name=?");
				pstmt.setString(1,CG_Name);
				rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
				while(rs.next()){
					XLFP x = new XLFP();
					x.setGreens_Type_Name(rs.getString("Greens_Type_Name"));
					list.add(x);
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
		
		public List<XLFP> findAll(){//��ѯ���������Ϣ
	        List<XLFP> list2 = new ArrayList<XLFP>();
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from XLFP_table");
				rs = pstmt.executeQuery();
				while(rs.next()){
					XLFP cart = new XLFP();
					cart.setXLFP_ID(rs.getInt(1));
					cart.setGreens_Type_Name(rs.getString(2));
					cart.setCG_Name(rs.getString(3));
					list2.add(cart);
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
	        return list2;
	    }
		public int update1(XLFP cart){//����
			int a = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				String sql = "update XLFP_table set CG_Name=? where Greens_Type_Name=?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, cart.getCG_Name());
				
				pstmt.setString(2, cart.getGreens_Type_Name());
				
				
				boolean b=pstmt.execute();
				if(!b){
					System.out.println("���³ɹ�");
					a = 1;
				}else
					System.out.println("����ʧ��");
				
		}catch(ClassNotFoundException e){
			System.out.println("ע������ʧ�ܣ�");
		}catch(SQLException e){
			System.out.println("���Ӵ���ʧ�ܣ�����");
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
			return a;
		}

		
		
		public int findAll8(){//��ѯÿ���߲�С���Ӧ���������
	        int aa =0;
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,username,pwd);
				pstmt = conn.prepareStatement("select * from XLFP_table");
				
				rs = pstmt.executeQuery();
				while(rs.next()){
					aa = rs.getInt("LiLv");
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
	        return aa;
	    }
}
