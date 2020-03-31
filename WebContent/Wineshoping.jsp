<%@page language="java" contentType="text/html; charset=GBK" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购蔬菜界面</title>
</head>
<body>
<form  action="DEservlet" method="post">

<%    
  
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载数据库引擎
    String connectDB="jdbc:sqlserver://localhost:1433;DatabaseName=green express";//数据源
    String user="sa";  String password="12345678";
     conn=DriverManager.getConnection(connectDB,user,password);//连接数据库对象
   // pstmt=conn.createStatement();//创建SQL命令对象


    pstmt = conn.prepareStatement("SELECT * FROM Greens_table ");
    //返回SQL语句查询结果集
   
    //pstmt=conn.prepareStatement(sql);
    rs=pstmt.executeQuery();
   %>
   <table  id="tab" border="1px" bordercolor="#000000" cellspacing="0px" style="border-collapse:collapse">
   <tr >
    <th width="168">编号</th>
    <th width="168">蔬菜名称</th>
    <th width="168">蔬菜单位</th>
    <th width="168">蔬菜品质</th>
    <th width="168">保质期</th>
    <th width="168">规格</th>
    <th width="168">库存量</th>
    <th width="168">蔬菜单价</th>
    <th width="168">市场价</th>
    <th width="168">品向</th>
    <th width="168">最少采购数量</th>
    <th width="168">蔬菜产地</th>
    <th width="168">蔬菜等级</th>
    <th width="168">季节性蔬菜</th>
    <th width="168">是否推荐</th>
    <th width="168">备注</th>
    </tr>


     <% 
    while(rs.next())
      {
    
    
    	%>
    	<tr >
    	  <td><input type="text" name="Greens_ID" value="<%=rs.getInt("Greens_ID") %>"></td>
    	  <td><input type="text" name="Greens_Name" value="<%=rs.getString("Greens_Name") %>"></td>
    	  <td><input type="text" name="Greens_Unit" value="<%=rs.getString("Greens_Unit") %>"></td>
    	  <td><input type="text" name="Greens_Character" value="<%=rs.getString("Greens_Character") %>"></td>
    	  <td><input type="text" name="Greens_Preiod" value="<%=rs.getString("Greens_Preiod") %>"></td>
    	  <td><input type="text" name="Greens_Norms" value="<%=rs.getString("Greens_Norms") %>"></td>
    	  <td><input type="text" name="Greens_Number" value="<%=rs.getInt("Greens_Number") %>"></td>
    	  <td><input type="text" name="Greens_Price" value="<%=rs.getFloat("Greens_Price") %>"></td>
    	  <td><input type="text" name="Greens_Market_Price" value="<%=rs.getFloat("Greens_Market_Price") %>"></td>
    	  <td><input type="text" name="Greens_Condition" value="<%=rs.getString("Greens_Condition") %>"></td>
    	  <td><input type="text" name="Greens_Minnumber" value="<%=rs.getInt("Greens_Minnumber") %>"></td>
    	  <td><input type="text" name="Greens_Class" value="<%=rs.getString("Greens_Class") %>"></td>
    	  <td><input type="text" name="Greens_Grade" value="<%=rs.getInt("Greens_Grade") %>"></td>
    	  <td><input type="text" name="Greens_characteristics" value="<%=rs.getInt("Greens_characteristics") %>"></td>
    	  <td><input type="text" name="Greens_Recommend" value="<%=rs.getString("Greens_Recommend") %>"></td>
    	  <td><input type="text" name="Greens_Remark" value="<%=rs.getString("Greens_Remark") %>"></td>
    	   <td><input type="submit" value="更新" onclick="this.form.action = 'GreensUPServlet?id=<%=rs.getInt("Greens_ID")%>'"/></td>
    	  <td><input type="submit" value="删除" onclick="this.form.action = 'DEservlet?id=<%=rs.getInt("Greens_ID")%>&util=<%=rs.getString("Greens_Unit") %> '"/></td>
    	  
    	</tr>
    	<% 
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

</table>


  <!--  <input type="submit" value="修改" id="sub2" onClick="this.form.action = 'GreensUPServlet'" />
  <input type="submit" value="删除" id="sub" onClick="this.form.action = 'GreensDEServlet'" /> -->
  
</form>
</body>
</html>