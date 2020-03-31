<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%
request.setCharacterEncoding("utf-8");
Integer id = (Integer)session.getAttribute("id");
if(id != null){
	WineshopDao dao = new WineshopDao();
	List<Wineshop> list = dao.findUserByID(id);
	for(Wineshop cc : list){
		String username = cc.getWineshop_UserName();
		String name = cc.getWineshop_Name();
		String address = cc.getWineshop_Address();
		String tel = cc.getWineshop_Telephone();
		String xingzhi = cc.getWineshop_Nature();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>
</head>
<body>

  <div class="layui-form-item">
    <label class="layui-form-label">登录名称</label>
    <div class="layui-input-block">
      <input type="text" name="title" value="<%=username %>" required  lay-verify="required" readonly="readonly" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">酒店名称</label>
    <div class="layui-input-block">
      <input type="text" name="title" value="<%=name %>" required  lay-verify="required" readonly="readonly" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">酒店地址</label>
    <div class="layui-input-block">
      <input type="text" name="title" value="<%=address %>" required  lay-verify="required" readonly="readonly" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block">
      <input type="text" name="title" value="<%=tel %>" required  lay-verify="required" readonly="readonly" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">酒店性质</label>
    <div class="layui-input-block">
      <input type="text" name="title" value="<%=xingzhi %>" required  lay-verify="required" readonly="readonly" autocomplete="off" class="layui-input">
    </div>
  </div>
  	<%
					}   
				}
				else{
						response.sendRedirect("login1.jsp");
					}
   			 %>
  <form  action="${pageContext.request.contextPath }/WordsServlet" method="post" class="layui-form">
   <div class="layui-form-item">
    <label class="layui-form-label">留言标题</label>
    <div class="layui-input-block">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">留言内容</label>
    <div class="layui-input-block">
      <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <input class="layui-btn" type="submit" value="立即提交">
      <input type="reset" class="layui-btn layui-btn-primary" value="重置">
    </div>
  </div>
</form>
</body>
</html>