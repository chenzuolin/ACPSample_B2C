<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回复反馈</title>
</head>
<script language="JavaScript" type="text/javascript">
function check(aaa)
{
if(aaa.Wineshop_ID.value ==""||aaa.Fedback_Content.value =="")
{
alert("内容不能为空！");
return false;
}
else return true;
}
</script>
<body>
<form name="form1" method="post" action="HFFKServlet" onsubmit="return check(this)">
  <p>投诉人编号：
    <label for="textfield"></label>
  <input type="text" name="Wineshop_ID" id="Wineshop_ID">
  </p>
  <p>回复内容：
    <label for="textfield2"></label>
    <input type="text" name="Fedback_Content" id="Fedback_Content">
  </p>
  <p>  
    
    <input type="submit" name="button" id="button" value="提交">
  </p>
</form>
</body>
</html>