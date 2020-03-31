<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<%
int Indent_ID = Integer.parseInt(request.getParameter("id"));	
	sizeDao dao = new sizeDao();
	List<TimeIndent> list = dao.Select(Indent_ID);
	for(TimeIndent t : list){
		String Wineshop_Name = t.getWineshop_Name();
		String Wineshop_Telephone = t.getWineshop_Telephone();
		String IndentPayID = t.getIndent_PayID();
		String Indent_Time = t.getIndent_Time();
		String Rufund_Status = t.getRefund_Status();
		String Rufund_Time = t.getRefund_Time();
		String Indent_Type = t.getIndent_Type();
		String Indent_Why = t.getIndent_Why();
		float total = t.getTotal();
		float TK_Total = t.getIndent_TKprice();
		String Wineshop_TuiJian = t.getWineshop_TuiJian();
		
	TKDao dao1 = new TKDao();
	List<TimeIndent> list1 = dao.Select(Indent_ID);
	for(TimeIndent k : list1){
		
		
	
	
	
%>
<table border="1"width="50%" height="50%">
   
    <tr>
        <th>商家名称</th><td><%=Wineshop_Name %></td>
        <th>联系电话</th><td><%=Wineshop_Telephone %></td>
    </tr>
    <tr>
        <th>下单ID</th><td><%=Indent_ID %></td>
        <th>商户订单号/支付单号</th><td><%=IndentPayID %></td>
    </tr>
    <tr>
        <th>交易日期</th><td><%=Indent_Time %></td>
        <th>申请退款日期</th><td><%=Rufund_Time %></td>
    </tr>
    <tr>
    <th>支付类型</th><td><%=Indent_Type %></td>
    <th>操作类型</th><td>退款</td>
    </tr>
    
    <tr>
    <th>退款原因</th><td colspan="3"><%=Indent_Why %></td>
    </tr>
    <tr>
    <th>退款详情</th><td colspan="3">**************************************</td>
    </tr>
     <tr>
    <th>订单总金额</th><td><%=total %></td>
    <th>退款金额</th><td><%=TK_Total %></td>
    </tr>
    <tr>
    <th>备注</th><td colspan="3">**************************************</td>
    </tr>
     <tr>
    <th>经办人</th><td colspan="3"><%=Wineshop_TuiJian %></td>
    </tr>
    
    <tr>
    <th>部门负责人</th><td colspan="3">唐松哲已确认</td>
    </tr>
    <tr>
    <th>单位负责人</th><td colspan="3">赵剑锋已确认</td>
    </tr>
</table>
<%
	}
	}
%>


</body>
</html>