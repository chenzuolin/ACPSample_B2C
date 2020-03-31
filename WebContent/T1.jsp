<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function text(){
		$.ajax({
			type:Post;
			url:"T1";
			cache:false;
			dataType:"json";
			success:function(json){
				alret(json[0].Greens_Password);
			}
	});
	}
</script>
<body>
<input type="button" name="b" value="测试" onclick=text()>
</body>
</html>