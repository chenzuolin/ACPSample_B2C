<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="js/jquery.js"></script>
 <script type="text/javascript">
	 setInterval(function() {

		var myselect = document.getElementById("d");
		var index=myselect.selectedIndex ;
		var aa = myselect.options[index].value;
	
	
},1000)

	
	
</script>


<body>
<form action="">
	<select name="c" id="d">
		<option value="a">a</option>
		<option value="b">b</option>
	</select>
	<input type="text" value="5555" name="e">
</form>
<%
	String c = request.getParameter("e");
	System.out.print(c);
%>
</body>
</html>