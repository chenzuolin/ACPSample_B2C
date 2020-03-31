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
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载数据库引擎
    String connectDB="jdbc:sqlserver://localhost:1433;DatabaseName=green express";//数据源
    String user="sa";  String password="12345678";
     conn=DriverManager.getConnection(connectDB,user,password);//连接数据库对象
   // pstmt=conn.createStatement();//创建SQL命令对象


    pstmt = conn.prepareStatement("SELECT * FROM Greens_Jobber_table where Greens_Jobber_ID=?");
    //返回SQL语句查询结果集
    pstmt.setInt(1, c);
    //pstmt=conn.prepareStatement(sql);
    rs=pstmt.executeQuery();
   
    out.println("<table border=2 bordercolor=#000066 >");
    out.println("<tr><td>名称</td><td>地址</td><td>负责人</td><td>电话</td><td>微信号</td><td>QQ号</td><td>注册时间</td></tr>");//显示在页面的列名
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
      out.print("<input type='button' value='修改' onclick=window.location.href='UserInfo.jsp' id='updata'> ");

      
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
%>   
    
</body>   


<span style="font-size:24px;color: rgb(255, 0, 0);">   

</span> 
</html>