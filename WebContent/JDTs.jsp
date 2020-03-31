<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言投诉系统</title>

</head>
<body>
<form name="form1" method="post" action="TSSrevlet">
  <p>留言投诉</p>
  <p>类型：
    <label for="select"></label>
    <select name="Complainant_Type" id="Complainant_Type">
      <option value="商品">商品</option>
      <option value="软件">软件</option>
    </select>
  </p>
  <p>内容：
    <label for="textarea"></label>
    <textarea name="Complainant_Content" id="Complainant_Content" cols="45" rows="5"></textarea>
  </p>
  <p>
    <input type="submit" name="button" id="button" value="提交">
  </p>
</form>
</body>
</html>