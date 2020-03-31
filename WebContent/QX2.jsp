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
<form action="QX2Servlet" method="get">

添加权限：<input type="text" name="zz">
<%
	PermissionDao dao = new PermissionDao();
	List<Permission> list = dao.findAll();
	for(Permission permission : list){
		String aa = permission.getPermission_Remark();
%>
已添加的权限：<%=aa %>
<%
	}
%>
</form>
</body>
</html>