<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="tp" enctype="multipart/form-data" method="post">
	登录名称：<input type="text" name="username" value=""/><br/>
	负责人：<input type="text" name="fuzename" value=""/><br/>
    选择附件：<input type="file" name="uploadFile"/><br/>
    <input type="submit" id="btn"/>
</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js" ></script>
	<script type="text/javascript">
		$("#btn").click(function(){
			var from = new FormData(document.getElementById("tp"));
			var code;
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath }/File",
				data:from,
				async : false,
				processData:false,
	            contentType:false,
	            success:function(data){
	            	code = data;
	            	alert(data);
	            }
			});
			if(code == 200){
				alert("上传成功！！！")
			}else if(code == 0){
				alert("上传失败！！！");
			}else if(code == 500){
				alert("非营业执照,请重新上传哦！！！");
			}else{
				alert("上传失败！！！");
			}
		})
		
	</script>
</html>