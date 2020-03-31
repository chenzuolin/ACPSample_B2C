<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
   <script src="./laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script>
//执行一个laydate实例
laydate.render({
  elem: '#date1' //指定元素
});
laydate.render({
  elem: '#date2' //指定元素
});
</script>
</head>
<body>
<form action="T2Servlet" method="post">
	<div class="form-group"  id="start"  >
                <label for="dtp_input2" class="col-md-2 control-label" >开始日期</label>
               <div class="col-sm-10">
                    <input    style="width: 150px;text-align: center; name="Greens_characteristics" lay-verify="required" placeholder="请选择开始日期" autocomplete="off" class="form-control" type="text" id="date1">
 
                </div>
				</div>
          
            <div class="form-group"   id="stop" >
                <label for="dtp_input2" class="col-md-2 control-label" >结束日期</label>
              <div class="col-sm-10">
                    <input    style="width: 150px;text-align: center;    name="Greens_characteristics" lay-verify="required" placeholder="请选择结束日期" autocomplete="off" class="form-control" type="text" id="date2">
  </div>
				</div>
  </form>
</body>
</html>