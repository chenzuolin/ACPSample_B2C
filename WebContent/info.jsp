<%@page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<% request.setCharacterEncoding("GBK");%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"></head>
<body>
<%    
    int c =(Integer)request.getSession().getAttribute("a");

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
    try{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//�������ݿ�����
    String connectDB="jdbc:sqlserver://localhost:1433;DatabaseName=green express";//����Դ
    String user="sa";  String password="12345678";
     conn=DriverManager.getConnection(connectDB,user,password);//�������ݿ����
   // pstmt=conn.createStatement();//����SQL�������


    pstmt = conn.prepareStatement("SELECT * FROM Greens_Jobber_table where Greens_Jobber_ID=?");
    //����SQL����ѯ�����
    pstmt.setInt(1, c);
    //pstmt=conn.prepareStatement(sql);
    rs=pstmt.executeQuery();
   
    out.println("<table border=2 bordercolor=#000066 >");
    out.println("<tr><td>����</td><td>��ַ</td><td>������</td><td>�绰</td><td>΢�ź�</td><td>QQ��</td><td>ע��ʱ��</td></tr>");//��ʾ��ҳ�������
      while(rs.next())
      {
      	
      out.println("<TR>");
      out.print("<TD >"+rs.getString("Greens_Jobber_UserName")+"</TD>");
     // out.print("<TD >"+rs.getString("Greens_Jobber_Aptitude")+"</TD>");
      out.print("<TD >"+rs.getString("Greens_Jobber_Address")+"</TD>");
      out.print("<TD >"+rs.getString("Greens_Jobber_Shift_Name")+"</TD>");
      out.print("<TD >"+rs.getString("Greens_Jobber_Telephone")+"</TD>");
      out.print("<TD >"+rs.getString("Greens_Jobber_WeChat")+"</TD>");
      out.print("<TD >"+rs.getInt("Greens_Jobber_QQ")+"</TD>");
      out.print("<TD >"+rs.getString("Greens_Jobber_Time")+"</TD>");
      out.print("<input type='button' value='�޸�' onclick=window.location.href='UserInfo.jsp' id='updata'> ");

      
      out.println("</TR>") ;
      }
      out.println("</table>") ;
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
%>   
    
</body>   


<span style="font-size:24px;color: rgb(255, 0, 0);">   

</span> 
</html>