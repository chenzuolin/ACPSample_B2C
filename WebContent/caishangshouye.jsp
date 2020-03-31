<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.sec.entity.*"%>
<%@page import="com.sec.dao.*"%>
<%@page import="java.sql.*"%>
<%
	GreensDao dao1 = new GreensDao();
	int shangpingNumber = dao1.findAllNum();
	IndentDao dao11 = new IndentDao();
	List<Indent> list2 = dao11.findUserByIDtype();
	int indentNumber = list2.size();
	List<Indent> list1 = dao11.findUserByIDtype1();
	int indentNumber1 = list1.size();
	ConsultDao dao2 = new ConsultDao();
	int number = dao2.C_Number();
	request.setCharacterEncoding("utf-8");
	Integer id = (Integer)session.getAttribute("id");
	if(id != null){
		Greens_JobberDao dao = new Greens_JobberDao();
		List<Greens_Jobber> list = dao.findUserByID1(id);
		for(Greens_Jobber cc : list){
			String name = cc.getGreens_Jobber_UserName();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title></title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="css/layui.css"  media="all">
<style type="text/css">
	.layui-form-mid {color: black !important;}
</style>
</head>
<body>
<div class="x-body layui-anim layui-anim-up">
        <blockquote class="layui-elem-quote">欢迎管理员：
            <span class="x-red"><%=name %></span></blockquote>
        <fieldset class="layui-elem-field" style="border-color: #009688;">
            <legend>数据统计</legend>
            <div class="layui-field-box">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body">
                            <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 90px;">
                                <div carousel-item="" style="border-color: #009688 ; ">
                                    <ul class="layui-row layui-col-space10 layui-this">
                                        <li class="layui-col-xs3" style="border-color: #009688 ; ">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3 style="margin-top: 15px;margin-left: 20px;">待接受订单</h3>
                                                <p style="margin-top: 15px !important;">
                                                    <cite style="margin-left: 20px;font-size: 30px;color: #009688;"><%=indentNumber %></cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3 style="margin-top: 15px;margin-left: 20px;">已接受订单</h3>
                                                <p style="margin-top: 15px !important;">
                                                    <cite style="margin-left: 20px;font-size: 30px;color: #009688;"><%=indentNumber1 %></cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3 style="margin-top: 15px;margin-left: 20px;">我的商品数量</h3>
                                                <p style="margin-top: 15px !important;">
                                                    <cite style="margin-left: 20px;font-size: 30px;color: #009688;"><%=shangpingNumber %></cite></p>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a href="javascript:;" class="x-admin-backlog-body">
                                                <h3 style="margin-top: 15px;margin-left: 20px;">速盟公告</h3>
                                                <p style="margin-top: 15px !important;">
                                                    <cite style="margin-left: 20px;font-size: 30px;color: #009688;"><%=number %></cite></p>
                                            </a>
                                        </li>
                                       
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </fieldset>
        <%
	}
	}else{
		response.sendRedirect("login1.jsp");
	}
%>
        <fieldset class="layui-elem-field" style="border-color: #009688;">
            <legend>功能板块</legend>
            <div class="layui-field-box">
                <table class="layui-table " lay-skin="line">
                    <tbody>
                        <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="javascript:;" target="_blank">商品上传</a>
                            </td>
                             <td >
                                <a style="color:#3F3F3F;" class="x-a" href="javascript:;" target="_blank">包含蔬菜、生鲜、生冷、调料的上传包含蔬菜、生鲜、生冷、调料的上传</a>
                            </td>
                            
                        </tr>
                        <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="javascript:;" target="_blank">我的订单</a>
                            </td>
                             <td >
                                <a style="color:#3F3F3F;" class="x-a" href="javascript:;" target="_blank">包含待接收订单、已接收订单、查询订单、带分拣蔬菜小计</a>
                            </td>
                        </tr>
                         <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="javascript:;" target="_blank">蔬菜销售量</a>
                            </td>
                             <td>
                                <a style="color:#3F3F3F;" class="x-a" href="javascript:;" target="_blank">包含查询：日、周、月、年的蔬菜销售量及按时间段查询</a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="javascript:;" target="_blank">蔬菜月销量</a>
                            </td>
                            <td>
                                <a style="color:#3F3F3F;" class="x-a" href="javascript:;" target="_blank">包含查询某年某月的蔬菜销售量</a>
                            </td>
                        </tr>
                         <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="/" target="_blank">查询酒店采购量</a>
                                
                            </td>
                             <td>
                                <a style="color:#3F3F3F;" class="x-a" href="/" target="_blank">包含查询某酒店某蔬菜的采购量</a>
                                
                            </td>
                            
                        </tr>
                        <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="/" target="_blank">市场行情</a>
                                
                            </td>
                             <td>
                                <a style="color:#3F3F3F;" class="x-a" href="/" target="_blank">包含商品的速盟价格及市场价格的波动</a>
                                
                            </td>
                            
                        </tr>
                         <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="/" target="_blank">查询财务数据</a>
                                
                            </td>
                            
                              <td>
                                <a style="color:#3F3F3F;" class="x-a" href="/" target="_blank">包含查询酒店当天及自由时间段的销售额和总销售额</a>
                                
                            </td>
                            
                        </tr>
                        <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="/" target="_blank">投诉反馈</a>
                                
                            </td>
                              <td>
                                <a style="color:#3F3F3F;" class="x-a" href="/" target="_blank">包含酒店的投诉反馈信息</a>
                                
                            </td>
                            
                        </tr>
                         <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="/" target="_blank">查看推送信息</a>
                                
                            </td>
                            <td>
                                <a style="color:#3F3F3F;" class="x-a" href="/" target="_blank">包含服务中心为菜商和酒店推送的公告</a>
                                
                            </td>
                            
                        </tr>
                         <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="/" target="_blank">我的商品</a>
                                
                            </td>
                             <td>
                                <a style="color:#3F3F3F;" class="x-a" href="/" target="_blank">包含查看菜商已上传的商品，及对商品的删改</a>
                                
                            </td>
                            
                        </tr>
                         <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="/" target="_blank">价格修改</a>
                                
                            </td>
                             <td>
                                <a style="color:#3F3F3F;" class="x-a" href="/" target="_blank">包含查看菜商已上传的商品，及对商品的删改</a>
                                
                            </td>
                            
                        </tr>
                        <tr>
                            <td>
                                <a style="color: #009688;" class="x-a" href="/" target="_blank">系统设置</a>
                                
                            </td>
                            
                             <td>
                                <a style="color:#3F3F3F;" class="x-a" href="/" target="_blank">包含个人资料及修改密码的操作</a>
                                
                            </td>
                            
                        </tr>
                    </tbody>
                </table>
            </div>
        </fieldset>
  
       
    </div>
<script src="js/layui.js" charset="utf-8"></script>


</body>
</html>