<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="POPS1Servlet" method="post" >
	<%
		String name = request.getParameter("name");
	%>
	<input type="text" value="<%=name %>" readonly="readonly" name="Greens_Type_Name" >
	<select  name="CG_Name" class="layui-input">
					<option value="">请选择</option>
					<%
						CGDao dao = new CGDao();
						List<CG> list = dao.findAll();
						for(CG c: list){
							String aa = c.getCG_Name();
					
					%>
       				<option value="<%=aa %>"><%=aa %></option>
       				<%
						}
	       			%>
			</select>
			<input type="submit" value="提交">
			</form>
</body>
</html>