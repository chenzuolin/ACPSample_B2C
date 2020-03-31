package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sec.entity.CG;

public class CGDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	
	public void add(CG cg) {//�������
		Connection conn=null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into CG_table(CG_UserName,CG_PassWord,CG_Name,CG_Telephone) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cg.getCG_UserName());
			pstmt.setString(2, cg.getCG_PassWord());
			pstmt.setString(3, cg.getCG_Name());
			pstmt.setString(4, cg.getCG_Telephone());
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
	
	public int checkCG(String CG_UserName,String CG_Password){//����������û���ѯ
		
		int a=0;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection(url,username,pwd);
					pstmt = conn.prepareStatement("select * from CG_table where CG_UserName=? and CG_Password=?");
					pstmt.setString(1, CG_UserName);
					pstmt.setString(2, CG_Password);
					rs = pstmt.executeQuery();
					if(rs.next()){
						a=2;
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
		        return a;
		    }
public int checkCGs(String CG_UserName,String CG_Password){//����������û���ѯ
		
		int a=0;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection(url,username,pwd);
					pstmt = conn.prepareStatement("select * from CG_table where CG_UserName=? and CG_Password=?");
					pstmt.setString(1, CG_UserName);
					pstmt.setString(2, CG_Password);
					rs = pstmt.executeQuery();
					if(rs.next()){
						a=rs.getInt("CG_ID");
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
		        return a;
		    }
	
	public List<CG> findAll(){//��ѯ���������Ϣ
        List<CG> list2 = new ArrayList<CG>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from CG_table");
			rs = pstmt.executeQuery();
			while(rs.next()){
				CG cg = new CG();
				cg.setCG_ID(rs.getInt(1));
				cg.setCG_UserName(rs.getString(2));
				cg.setCG_PassWord(rs.getString(3));
				cg.setCG_Name(rs.getString(4));
				cg.setCG_Telephone(rs.getString(5));
				list2.add(cg);
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
	
	public List<CG> findUserByID(String CG_Name){//���ݱ�Ų�ѯ��Ϣ
		List<CG> list1 = new ArrayList<CG>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from CG_table where CG_Name = ?");
			pstmt.setString(1,CG_Name);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()){
				CG cg = new CG();
				cg.setCG_ID(rs.getInt(1));
				cg.setCG_UserName(rs.getString(2));
				cg.setCG_PassWord(rs.getString(3));
				cg.setCG_Name(rs.getString(4));
				cg.setCG_Telephone(rs.getString(5));
				list1.add(cg);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
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
	    return list1;
	}
	
	public String findUserByIDs(int aa){//���ݱ�Ų�ѯ��Ϣ
		String bb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from CG_table where CG_ID = ?");
			pstmt.setInt(1,aa);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()){
				bb = rs.getString("CG_UserName");
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
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
	    return bb;
	}
	
	/*public int update1(CG cg){//����
		int a = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update CG_table set Number=? where Cart_ID=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cart.getNumber());
			
			pstmt.setInt(2, cart.getCart_ID());
			
			
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
	}*/
	
	public int delete(String CG_Name){//ɾ��

		Connection conn = null;
		PreparedStatement pstmt = null;
		int a= 0;
		String sql = "delete from CG_table where CG_Name = ?";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CG_Name);
			a=pstmt.executeUpdate();
			if(a>0){
				System.out.println("�ɹ�");
			}else{
				System.out.println("ʧ��");
			}
	}catch(Exception e){
		e.printStackTrace();
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

	public List<CG> findUserByIDss(int CG_ID){//���ݱ�Ų�ѯ��Ϣ
		List<CG> list1 = new ArrayList<CG>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from CG_table where CG_ID = ?");
			pstmt.setInt(1,CG_ID);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()){
				CG cg = new CG();
				cg.setCG_ID(rs.getInt(1));
				cg.setCG_UserName(rs.getString(2));
				cg.setCG_PassWord(rs.getString(3));
				cg.setCG_Name(rs.getString(4));
				cg.setCG_Telephone(rs.getString(5));
				list1.add(cg);
			}
	    }catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (Exception e) {
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
	    return list1;
	}
	


}
