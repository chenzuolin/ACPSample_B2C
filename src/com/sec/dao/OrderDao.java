package com.sec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sec.entity.GreensXiaoJi;
import com.sec.entity.Order;
import com.sec.entity.shuliang;
import com.sec.util.C3p0Utils;
import com.sumeng.page.Page;

public class OrderDao {
	String url="jdbc:sqlserver://localhost:1433;databaseName=Green express";
	String username="green";
	String pwd = "12345678";
	public void add(Order order){//����
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			conn = DriverManager.getConnection(url,username,pwd);//����
			String sql = "insert into Order_table (Indent_ID,Greens_ID,Number,Order_Requirement,Indent_Status,Order_Remark,Greens_Name,Greens_Unit,Indent_Time,Wineshop_ID,Greens_Price,Greens_BiaoJi,Greens_Type_Name) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";//SQL���
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getIndent_ID());
			pstmt.setInt(2, order.getGreens_ID());
			pstmt.setInt(3, order.getNumber());
			pstmt.setString(4, order.getOrder_Requirement());
			pstmt.setString(5, order.getIndent_Status());
			pstmt.setString(6, order.getOrder_Remark());
			pstmt.setString(7, order.getGreens_Name());
			pstmt.setString(8, order.getGreens_Unit());
			pstmt.setString(9, order.getIndent_Time());
			pstmt.setInt(10, order.getWineshop_ID());
			pstmt.setFloat(11, order.getGreens_Price());
			pstmt.setInt(12, order.getGreens_BiaoJi());
			pstmt.setString(13, order.getGreens_Type_Name());
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
	public int count(int greens_ID){//���ݱ�Ų�ѯ�û�������
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int count = 0;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select count(*) from Order_table where Greens_ID=?");
			pstmt.setInt(1,greens_ID);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()){
				count = rs.getInt(1);
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
	    return count;
	}
	
	
public void update(Order order){//����
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Order_table set Indent_ID=?,Greens_ID=?,Order_Number=?,Order_Requirement=?,Indent_Status=?,Order_Remark=?,Greens_Name=?,Greens_Unit=?,Indent_Time=?,Wineshop_ID=? where Order_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getIndent_ID());
			pstmt.setInt(2, order.getGreens_ID());
			pstmt.setInt(3, order.getNumber());
			pstmt.setString(4, order.getOrder_Requirement());
			pstmt.setString(5, order.getIndent_Status());
			pstmt.setString(6, order.getOrder_Remark());
			pstmt.setString(7, order.getGreens_Name());
			pstmt.setString(8, order.getGreens_Unit());
			pstmt.setString(9, order.getIndent_Time());
			pstmt.setInt(10, order.getWineshop_ID());
			pstmt.setInt(11, order.getOrder_ID());
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

public Order delete(int Order_ID){//ɾ��
	Order order = new Order();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "delete * from Order_table where Order_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getOrder_ID());
			pstmt.executeUpdate(sql);
			boolean p=pstmt.execute();
			if(!p){
				System.out.println("ɾ���ɹ�");
			}else
				System.out.println("ɾ��ʧ��");
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
		return order;
	}

public Order findUserByID(int Order_ID){//���ݱ�Ų�ѯ�û�������
	Order order = new Order();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Order_table where Order_ID=?");
		pstmt.setInt(1,Order_ID);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		if(rs.next()!=false){
			order.setOrder_ID(rs.getInt(1));
			order.setIndent_ID(rs.getInt(2));
			order.setGreens_ID(rs.getInt(3));
			order.setNumber(rs.getInt(4));
			order.setOrder_Requirement(rs.getString(5));
			order.setIndent_Status(rs.getString(6));
			order.setOrder_Remark(rs.getString(7));
			order.setGreens_Name(rs.getString(8));
			order.setGreens_Unit(rs.getString(9));
			order.setIndent_Time(rs.getString(10));
			order.setWineshop_ID(rs.getInt(11));
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
    return order;
}

public List<Order> findAll(){//��ѯ���������Ϣ
    List<Order> orders = new ArrayList<Order>();
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Order_table");
		rs = pstmt.executeQuery();
		while(rs.next()){
			Order order = new Order();
			order.setOrder_ID(rs.getInt(1));
			order.setIndent_ID(rs.getInt(2));
			order.setGreens_ID(rs.getInt(3));
			order.setNumber(rs.getInt(4));
			order.setOrder_Requirement(rs.getString(5));
			order.setIndent_Status(rs.getString(6));
			order.setOrder_Remark(rs.getString(7));
			order.setGreens_Name(rs.getString(8));
			order.setGreens_Unit(rs.getString(9));
			order.setIndent_Time(rs.getString(10));
			order.setWineshop_ID(rs.getInt(11));
			orders.add(order);
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
    return orders;
}


public List<Order> findUserByID1(int Indent_ID){
	List<Order> list = new ArrayList<Order>();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Order_table where Indent_ID=?");
		pstmt.setInt(1,Indent_ID);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		while(rs.next()){
			Order order = new Order();
			order.setOrder_ID(rs.getInt(1));
			order.setIndent_ID(rs.getInt(2));
			order.setGreens_ID(rs.getInt(3));
			order.setNumber(rs.getInt(4));
			order.setOrder_Requirement(rs.getString(5));
			order.setIndent_Status(rs.getString(6));
			order.setOrder_Remark(rs.getString(7));
			order.setGreens_Name(rs.getString(8));
			order.setGreens_Unit(rs.getString(9));
			order.setIndent_Time(rs.getString(10));
			order.setWineshop_ID(rs.getInt(11));
			order.setGreens_Price(rs.getFloat("Greens_Price"));
			order.setGreens_Type_Name(rs.getString("Greens_Type_Name"));
			list.add(order);
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

public void update1(Order order){//����
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		String sql = "update Order_table set Indent_Status=? where Indent_ID=?";
		pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setString(1, order.getIndent_Status());
		pstmt.setInt(2, order.getIndent_ID());
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


public Map<String, Object> findAll8(int Indent_ID){//�ϲ���ͬ��������
	  Map<String, Object> map = new HashMap<String,Object>();
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_ID, sum(Number) as Greens_Num from Order_table where Indent_ID=? group by Greens_ID ");
			pstmt.setInt(1, Indent_ID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String aa = String.valueOf(rs.getInt(1));
				String bb = String.valueOf(rs.getInt(2));
				map.put(aa, bb);	
				
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
	    return map;
	}






public List<Order> find1(){//�ϲ���ͬ��������ֵ����   һ�������
	List<Order> list = new ArrayList<Order>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_ID, sum(Number) as Number,Greens_Name,Greens_Unit from Order_table where DateDiff(dd,Indent_Time,getdate())=0 group by Greens_ID,Greens_Name,Greens_Unit");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				  Order order = new Order();
				System.out.println("1"+rs.getString("Greens_Name"));
				
					order.setGreens_ID(rs.getInt("Greens_ID"));
					order.setGreens_Name(rs.getString("Greens_Name"));
					System.out.println("2"+rs.getString("Greens_Name"));
					order.setNumber(rs.getInt("Number"));
					order.setGreens_Unit(rs.getString("Greens_Unit"));
					System.out.println("4"+order.getGreens_Name());
					list.add(order);
					
				
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



public List<Order> find2(){//�ϲ���ͬ��������ֵ����   һ�ܵ�����
	List<Order> list = new ArrayList<Order>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_ID, sum(Number) as Number,Greens_Name,Greens_Unit from Order_table where DateDiff(WEEK,Indent_Time,getdate())=0 group by Greens_ID,Greens_Name,Greens_Unit");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				  Order order = new Order();
				System.out.println("1"+rs.getString("Greens_Name"));
				
					order.setGreens_ID(rs.getInt("Greens_ID"));
					order.setGreens_Name(rs.getString("Greens_Name"));
					System.out.println("2"+rs.getString("Greens_Name"));
					order.setNumber(rs.getInt("Number"));
					order.setGreens_Unit(rs.getString("Greens_Unit"));
					System.out.println("4"+order.getGreens_Name());
					list.add(order);
					
				
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

public List<Order> find3(){//�ϲ���ͬ��������ֵ����       ���µ�����
	List<Order> list = new ArrayList<Order>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_ID, sum(Number) as Number,Greens_Name,Greens_Unit,Wineshop_ID from Order_table where DateDiff(month,Indent_Time,getdate())=0 group by Greens_ID,Greens_Name,Greens_Unit,Wineshop_ID");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				  Order order = new Order();
				System.out.println("1"+rs.getString("Greens_Name"));
				
					order.setGreens_ID(rs.getInt("Greens_ID"));
					order.setGreens_Name(rs.getString("Greens_Name"));
					System.out.println("2"+rs.getString("Greens_Name"));
					order.setNumber(rs.getInt("Number"));
					order.setGreens_Unit(rs.getString("Greens_Unit"));
					System.out.println("4"+order.getGreens_Name());
					list.add(order);
					
				
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

public List<Order> find4(){//�ϲ���ͬ��������ֵ����
	List<Order> list = new ArrayList<Order>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_ID, sum(Number) as Number,Greens_Name,Greens_Unit from Order_table where DateDiff(YEAR,Indent_Time,getdate())=0 group by Greens_ID,Greens_Name,Greens_Unit");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				  Order order = new Order();
				System.out.println("1"+rs.getString("Greens_Name"));
				
					order.setGreens_ID(rs.getInt("Greens_ID"));
					order.setGreens_Name(rs.getString("Greens_Name"));
					System.out.println("2"+rs.getString("Greens_Name"));
					order.setNumber(rs.getInt("Number"));
					order.setGreens_Unit(rs.getString("Greens_Unit"));
					System.out.println("4"+order.getGreens_Name());
					list.add(order);
					
				
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



public List<Order> findAll13(int Indent_ID){//�ϲ���ͬ��������
	  List<Order> list = new ArrayList<Order>();
	  Order order = new Order();
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_ID, sum(Number) as Greens_Num from Order_table where Indent_ID=? group by Greens_ID ");
			pstmt.setInt(1, Indent_ID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				order.setGreens_Name(rs.getString(3));
				order.setNumber(rs.getInt(2));
				order.setGreens_Unit(rs.getString(4));
				list.add(order);
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


public List<Order> findAll15(String a ,String b){//�ϲ���ͬ��������ֵ����     �����ڷֶβ�ѯ(����)
	List<Order> list = new ArrayList<Order>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_ID, sum(Number) as Number,Greens_Name,Greens_Unit,Wineshop_ID from Order_table where Indent_Time between ? and ? group by Greens_ID,Greens_Name,Greens_Unit,Wineshop_ID");
			pstmt.setString(1, a);
			pstmt.setString(2, b);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				  Order order = new Order();
				System.out.println("1"+rs.getString("Greens_Name"));
				
					order.setGreens_ID(rs.getInt("Greens_ID"));
					order.setGreens_Name(rs.getString("Greens_Name"));
					System.out.println("2"+rs.getString("Greens_Name"));
					order.setNumber(rs.getInt("Number"));
					order.setGreens_Unit(rs.getString("Greens_Unit"));
					System.out.println("4"+order.getGreens_Name());
					list.add(order);
					
				
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


public List<Order> findtime(String a ,String b,int Wineshop_ID){//�ϲ���ͬ��������ֵ����     �����ڷֶβ�ѯ(�Ƶ�)
	List<Order> list = new ArrayList<Order>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_ID, sum(Number) as Number,Greens_Name,Greens_Unit,Wineshop_ID from Order_table where Indent_Time between ? and ? group by Greens_ID,Greens_Name,Greens_Unit,Wineshop_ID");
			pstmt.setString(1, a);
			pstmt.setString(2, b);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getInt("Wineshop_ID")==Wineshop_ID){
				  Order order = new Order();
				System.out.println("1"+rs.getString("Greens_Name"));
				
					order.setGreens_ID(rs.getInt("Greens_ID"));
					order.setGreens_Name(rs.getString("Greens_Name"));
					System.out.println("2"+rs.getString("Greens_Name"));
					order.setNumber(rs.getInt("Number"));
					order.setGreens_Unit(rs.getString("Greens_Unit"));
					System.out.println("4"+order.getGreens_Name());
					list.add(order);
				}
				
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






public List<Order> findtime1(String a ,String b,String Wineshop_Name){//�ϲ���ͬ��������ֵ����     �����ڷֶβ�ѯ(�Ƶ�)
	List<Order> list = new ArrayList<Order>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select Greens_ID, sum(Number) as Number,Greens_Name,Greens_Unit,Wineshop_ID from Order_table where Indent_Time between ? and ? group by Greens_ID,Greens_Name,Greens_Unit,Wineshop_ID");
			pstmt.setString(1, a);
			pstmt.setString(2, b);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getString("Wineshop_Name")==Wineshop_Name){
				  Order order = new Order();
				System.out.println("1"+rs.getString("Greens_Name"));
				
					order.setGreens_ID(rs.getInt("Greens_ID"));
					order.setGreens_Name(rs.getString("Greens_Name"));
					System.out.println("2"+rs.getString("Greens_Name"));
					order.setNumber(rs.getInt("Number"));
					order.setGreens_Unit(rs.getString("Greens_Unit"));
					System.out.println("4"+order.getGreens_Name());
					list.add(order);
				}
				
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

public List<shuliang> findAll9(int Wineshop_ID){//�ϲ���ͬ��������ֵ����
	List<shuliang> list = new ArrayList<shuliang>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select SUM(Number) Number,Greens_Name,Greens_ID,Greens_Unit from Order_table where Wineshop_ID=? and DateDiff(day,Indent_Time,getdate())=0 group by Greens_Name,Greens_ID,Greens_Unit");
			pstmt.setInt(1,Wineshop_ID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				shuliang s = new shuliang();
					s.setGreens_ID(rs.getInt("Greens_ID"));
					s.setGreens_Name(rs.getString("Greens_Name"));
					s.setNumber(rs.getInt("Number"));
					s.setGreens_Unit(rs.getString("Greens_Unit"));
					list.add(s);
					
				
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


public List<shuliang> findAll10(int Wineshop_ID){//�ϲ���ͬ��������ֵ����
	List<shuliang> list = new ArrayList<shuliang>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select SUM(Number) Number,Greens_Name,Greens_ID,Greens_Unit from Order_table where Wineshop_ID=? and DateDiff(week,Indent_Time,getdate())=0 group by Greens_Name,Greens_ID,Greens_Unit");
			pstmt.setInt(1,Wineshop_ID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				shuliang s = new shuliang();
					s.setGreens_ID(rs.getInt("Greens_ID"));
					s.setGreens_Name(rs.getString("Greens_Name"));
					s.setNumber(rs.getInt("Number"));
					s.setGreens_Unit(rs.getString("Greens_Unit"));
					list.add(s);
					
				
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


public List<shuliang> findAll11(int Wineshop_ID){//�ϲ���ͬ��������ֵ����
	List<shuliang> list = new ArrayList<shuliang>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select SUM(Number) Number,Greens_Name,Greens_ID,Greens_Unit from Order_table where Wineshop_ID=? and DateDiff(month,Indent_Time,getdate())=0 group by Greens_Name,Greens_ID,Greens_Unit");
			pstmt.setInt(1,Wineshop_ID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				shuliang s = new shuliang();
					s.setGreens_ID(rs.getInt("Greens_ID"));
					s.setGreens_Name(rs.getString("Greens_Name"));
					s.setNumber(rs.getInt("Number"));
					s.setGreens_Unit(rs.getString("Greens_Unit"));
					list.add(s);
					
				
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


public List<shuliang> findAll12(int Wineshop_ID){//�ϲ���ͬ��������ֵ����
	List<shuliang> list = new ArrayList<shuliang>();
	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select SUM(Number) Number,Greens_Name,Greens_ID,Greens_Unit from Order_table where Wineshop_ID=? and DateDiff(YEAR,Indent_Time,getdate())=0 group by Greens_Name,Greens_ID,Greens_Unit");
			pstmt.setInt(1,Wineshop_ID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				shuliang s = new shuliang();
					s.setGreens_ID(rs.getInt("Greens_ID"));
					s.setGreens_Name(rs.getString("Greens_Name"));
					s.setNumber(rs.getInt("Number"));
					s.setGreens_Unit(rs.getString("Greens_Unit"));
					list.add(s);
					
				
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

public List<Order> findUserByID88(int Indent_ID){
	List<Order> list = new ArrayList<Order>();
     
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Order_table where Indent_ID=?");
		pstmt.setInt(1,Indent_ID);
		rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
		while(rs.next()){
			Order order = new Order();
			order.setOrder_ID(rs.getInt(1));
			order.setIndent_ID(rs.getInt(2));
			order.setGreens_ID(rs.getInt(3));
			order.setNumber(rs.getInt(4));
			order.setOrder_Requirement(rs.getString(5));
			order.setIndent_Status(rs.getString(6));
			order.setOrder_Remark(rs.getString(7));
			order.setGreens_Name(rs.getString(8));
			order.setGreens_Unit(rs.getString(9));
			order.setIndent_Time(rs.getString(10));
			order.setWineshop_ID(rs.getInt(11));
			list.add(order);
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




public List<Order> findAllDay(int Wineshop_ID) throws SQLException{//���ּ��߲�С�ư����߲˷����ѯȫ���߲˵ĺ�
	List<Order> list = new ArrayList<Order>();
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username,pwd);
		pstmt = conn.prepareStatement("select * from Order_table where Order_table.Indent_ID in (select Indent_table.Indent_ID from Indent_table where Indent_Status!='����֧��'and Indent_Status='�����'and Indent_table.Wineshop_ID=? and datediff(month,Indent_table.Indent_Time,getdate())=0)");
		pstmt.setInt(1, Wineshop_ID);
		rs = pstmt.executeQuery();
		while(rs.next()) {  
			
			Order order = new Order();
			order.setOrder_ID(rs.getInt("Order_ID"));
			order.setIndent_ID(rs.getInt("Indent_ID"));
			order.setGreens_ID(rs.getInt("Greens_ID"));
			order.setNumber(rs.getInt("Number"));
			order.setGreens_Name(rs.getString("Greens_Name"));
			order.setGreens_Price(rs.getFloat("Greens_Price"));
			list.add(order);
		}
	} catch (ClassNotFoundException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	
	return list;
	
}
	/**
	 * ���ݶ�����Ž���ɾ��
	 * @param indentById
	 * @return
	 */
	public int delIndentById(int indentById){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "delete from Order_table where Indent_ID=?";
		int code = 0;
		try {
			code = qr.update(sql,indentById);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code > 0? 200: -1;
	}
	/**
	 * ͨ��������Ų�ѯ����
	 * @param id
	 * @return ��������
	 */
	public Page byIndentId(int id){
		QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
		Page page = new Page();
		String sql = "  select * from Order_table where Indent_ID=?";
		List<Order> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Order>(Order.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		page.setData(list);
		return page;
	}
	/**
	 * �߲�����
	 * @param Indent_ID ����ID
	 * @return
	 */
	public Page findShuCaiXiangQing(int Indent_ID){
		List<Order> list = new ArrayList<Order>();
	     Page page = new Page();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			pstmt = conn.prepareStatement("select * from Order_table where Indent_ID=?");
			pstmt.setInt(1,Indent_ID);
			rs = pstmt.executeQuery();//ִ��SQL��䣬�����ؽ����
			while(rs.next()){
				Order order = new Order();
				order.setOrder_ID(rs.getInt(1));
				order.setIndent_ID(rs.getInt(2));
				order.setGreens_ID(rs.getInt(3));
				order.setNumber(rs.getInt(4));
				order.setOrder_Requirement(rs.getString(5));
				order.setIndent_Status(rs.getString(6));
				order.setOrder_Remark(rs.getString(7));
				order.setGreens_Name(rs.getString(8));
				order.setGreens_Unit(rs.getString(9));
				order.setIndent_Time(rs.getString(10));
				order.setWineshop_ID(rs.getInt(11));
				order.setGreens_Price(rs.getFloat("Greens_Price"));
				list.add(order);
				page.setData(list);
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
	    return page;
	}
	
	public void update100(Order order){//����
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username,pwd);
			String sql = "update Order_table set Greens_BiaoJi=? where Order_ID=?";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, order.getGreens_BiaoJi());
			pstmt.setInt(2, order.getOrder_ID());
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



}
