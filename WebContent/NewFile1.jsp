<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="io.goeasy.GoEasy" %>
<%@ page import="io.goeasy.publish.GoEasyError" %>
<%@ page import="io.goeasy.publish.PublishListener" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.1.1.min.js"></script>
 
<SCRIPT LANGUAGE="JavaScript">

    function sub(btn){
        var tds = btn.parentElement.parentElement.children;
        var td = (tds[0]).innerHTML ;
        window.location.href="JoincartServlet?id="+td;
    }
</SCRIPT>
</head>
<body>
<TABLE>
<TR>
    <TD>22222</TD>
    <TD>33333</TD>
    <TD>99999</TD>
    <TD><input type='button' name='btn' onclick="javascript:sub(this);" value="递 交"></TD>
</TR>
<TR>
    <TD>33333</TD>
    <TD>33333</TD>
    <TD>99999</TD>
    <TD><input type='button' name='btn' onclick="javascript:sub(this);" value="递 交"></TD>
</TR>
<TR>
    <TD>444444</TD>
    <TD>33333</TD>
    <TD>99999</TD>
    <TD><input type='button' name='btn' onclick="javascript:sub(this);" value="递 交"></TD>
</TR>
</TABLE>
</body>
</html>