
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银联全渠道PC/WAP跳转银联页面支付产品示例</title>

<style type="text/css">
<!--
html,body  
{
    width:100%;  
    height:100%;  
}
a {
  text-decoration: none;
  font-weight:normal;
}
a:link {
	color: #003399;
}
a:visited {
	color: #003399;
}
a:hover {
	color: #FF6600;
}
.px14 {
	font-size: 14px;
}
.STYLE2 {font-size: 14px; font-weight: bold; }

#toptable td {
 border-top-width: 0px;
 border-right-width: 0px;
 border-bottom-width: 0px;
 border-left-width: 0px;
 border-top-style: solid;
 border-right-style: solid;
 border-bottom-style: solid;
 border-left-style: solid;
 border-top-color: #0000ff;
 border-right-color: #0000ff;
 border-bottom-color: #0000ff;
 border-left-color: #0000ff;
 text-align: left;
 font-size: 14px;
 font-weight: normal;
 word-break:   break-all;

}
.btn{
    background-color: #0055AA;
	color: #FFFFFF;
    font-weight: bold;
	border: medium none;
	width:120px;
	height:28px;
}
.btn:hover{
    background-color: #00CC00;
	width: 120px;
	color: #FFFFFF;
    font-weight: bold;
    height: 28px;
}
-->
</style>

<script type="text/javascript">  
    function onPayForm(){
       document.all.payForm.submit();
    }
    function onPayUndoForm(){
    	document.all.payUndoForm.submit();
    }
    function onRefundForm(){
    	document.all.refundForm.submit();
    }
    function onQueryForm(){
    	document.all.queryForm.submit();
    }
    
    function onfileTransferForm(){
    	document.all.fileTransferForm.submit();
    }
    
    function displayConsumeDiv(){
    	document.getElementById("consumeDiv").style.display = "block";
    	document.getElementById("consumeRefundDiv").style.display = "none";
    	document.getElementById("consumeUndoDiv").style.display = "none";
    	document.getElementById("queryDiv").style.display ="none";
    	document.getElementById("fileTransferDiv").style.display = "none";
    }
    
    function displayConsumeUndoDiv(){
    	document.getElementById("consumeUndoDiv").style.display = "block";
    	document.getElementById("consumeDiv").style.display = "none";
    	document.getElementById("consumeRefundDiv").style.display = "none";
    	document.getElementById("queryDiv").style.display ="none";
    	document.getElementById("fileTransferDiv").style.display = "none";
    }
    function displayRefundDiv(){
    	document.getElementById("consumeRefundDiv").style.display = "block";
    	document.getElementById("consumeDiv").style.display = "none";
    	document.getElementById("consumeUndoDiv").style.display = "none";
    	document.getElementById("queryDiv").style.display ="none";
    	document.getElementById("fileTransferDiv").style.display = "none";
    }
    
    function displayQueryDiv(){
    	document.getElementById("queryDiv").style.display = "block";
    	document.getElementById("consumeRefundDiv").style.display = "none";
    	document.getElementById("consumeDiv").style.display = "none";
    	document.getElementById("consumeUndoDiv").style.display = "none";
    	document.getElementById("fileTransferDiv").style.display = "none";
    }
    function displayfileTransferDiv(){
    	
    	document.getElementById("fileTransferDiv").style.display = "block";
    	document.getElementById("queryDiv").style.display = "none";
    	document.getElementById("consumeRefundDiv").style.display = "none";
    	document.getElementById("consumeDiv").style.display = "none";
    	document.getElementById("consumeUndoDiv").style.display = "none";
    }
    
</script>

</head>
<body>

<table width="80%" height="40%" id="toptable" align="center"  cellpadding="3" cellspacing="1"  bgcolor="#99CC59;" >
<tr>
<td align="left" width="100%" colspan="2" bgcolor="#FFFFEE">
<span>联调集成前请仔细阅读:</span><a href="<%request.getContextPath();%>/ACPSample_B2C/other/readme.txt" target="_blank">&nbsp;readme.txt</a> 
<br><br>接口规范(请求报文，同步应答，异步应答报文字段)参考：<a href="https://open.unionpay.com/ajweb/help/file" target="_blank">产品接口规范->《网关支付产品接口规范》</a>&nbsp;
<br><br>应答码规范(同步应答，异步应答中respCode的值)参考：<a href="https://open.unionpay.com/ajweb/help/file" target="_blank">产品接口规范->《平台接入接口规范-第5部分-附录》</a>&nbsp;
<br><br>对账文件格式参考：<a href="https://open.unionpay.com/ajweb/help/file" target="_blank">产品接口规范->《全渠道平台接入接口规范 第3部分 文件接口》</a>&nbsp;
</td>
</tr>

<tr>
<td align="left" width="30%"  bgcolor="#FFFFEE" >
<h3>全渠道PC网关/WAP支付产品<font color="red" size="6">消费</font>示例</h3>
<h4>前台跳转消费</h4>
<ul>
<li><a href="#" target="_self" onclick="displayConsumeDiv();">跳转网关页面支付</a>&nbsp;&nbsp;点击查看&nbsp;<a href="<%request.getContextPath();%>/ACPSample_B2C/other/consumeFieldSpecal.txt" target="_blank">报文特殊用法.txt</a></li>
</ul>

<!--
<h4>前台跳转预授权</h4>
<ul>
<li><a href="<%request.getContextPath();%>/ACPSample_B2C/form_6_7_1_AuthDeal_Front" target="blank">跳转页面预授权</a></li>
</ul>
-->
<h4>后续交易（根据商户需求自行选择是否测试）</h4>
<ul>
<li><a href="#" onclick="displayConsumeUndoDiv();" target="_self">消费撤销</a></li>
</br>
<li><a href="#"  onclick="displayRefundDiv();" target="_self">退货</a></li>
</br>
<li><a href="#"  onclick="displayQueryDiv();" target="_self">交易状态查询</a></li>
</br>
<li><a href="#"  onclick="displayfileTransferDiv();" target="_self">对账文件下载（文件传输类交易）</a></li>
</ul>
</br></br></br></br></br></br></br></br></br></br></br></br>
</td>

<td align="center" valign="top" width="70%" bgcolor="#FFFFEE">
<div id="consumeDiv" style="display:block">

<form action="<%request.getContextPath();%>/ACPSample_B2C/form_6_2_FrontConsume" method="post" name="payForm" id="payForm" target="_blank">
<table width="100%" height="100%"  border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#AACC00">
                  
                  <tr bgcolor="#FFFFEE"><td height="26" align="right" valign="middle"><b>跳转银联页面支付，填写订单信息（只提供了商户号，交易金额，其他字段请具体参考代码）</td></tr>
                  <tr>
                    
                    <td align="center" valign="top" bgcolor="#FFFFEE">
                    <table width="100%" height="100%"  border="0" cellpadding="3" cellspacing="0"  class="px14">
                      <tr>
                        <td align="left" valign="middle">商户号merId：</td>
                        <td valign="middle">
                          <input name="merId" type="text" value="777290058161537" >（默认商户号仅作为联调测试使用，正式上线还请使用正式申请的商户号）
                        </td>
                      </tr>
                    <tr>
                        <td align="right" valign="middle">交易金额txnAmt：</td>
                        <td valign="middle"><input type="text" name="txnAmt" value="${total }">（单位为分）</td>
                        
                      </tr>
						<tr>
                        <td valign="middle"><b>
                          <input name="button" type="button" value="跳转银联页面支付" class="btn" onClick="onPayForm();" />
                         </td>
                        <td valign="middle">&nbsp;</td>
                      </tr>
                    </table>
					<jsp:include  page="/other/consume_faq.jsp"/>
                    </td>
                  </tr>      
              </table>
</form>
</div>

<div id="consumeUndoDiv" style="display:none">
<form action="<%request.getContextPath();%>/ACPSample_B2C/form_6_3_ConsumeUndo" method="post" name="payUndoForm"  id="payUndoForm" target="_blank">
<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#FFCC00">
                  <tr bgcolor="#FFFFEE"><td width="102" height="26" align="right" valign="middle"><b>填写消费撤销交易关键要素</td></tr>
                  <tr>
                    <td align="center" valign="top"  bgcolor="#FFFFEE">
                    <table width="100%" height="100%"  border="0" cellpadding="3" cellspacing="0"  class="px14">
                        <tr>
                        <td align="right" valign="middle">原消费交易的queryId：</td>
                        <td valign="middle"><input name="origQryId" value="">（从原交易的后台通知报文或者交易状态查询返回的queryId中获取）</td>
                        </tr>
                        <tr>
                        <td align="right" valign="middle">撤销金额txnAmt：</td>
                        <td valign="middle"><input type="text" name="txnAmt" value="10000">分（必须与原消费金额相同）</td>
                        </tr>
                        <tr>
                        <td valign="top" height="26">
                          <input name="button" type="button" value="消费撤销" class="btn" onClick="onPayUndoForm();" />
                        </td>
                        <td valign="top">&nbsp;</td>
                      </tr>
                    </table>
                     <jsp:include  page="/other/consumeUndo_faq.jsp"/>
                    </td>
                  </tr>
                  
 </table>
</form>
</div>

<div id="consumeRefundDiv" style="display:none">
<form action="<%request.getContextPath();%>/ACPSample_B2C/form_6_4_Refund" method="post" name="refundForm"  id="refundForm" target="_blank">
<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#FFCC00">
                  <tr bgcolor="#FFFFEE"><td width="102" height="26" align="right" valign="middle"><b>填写退货交易关键要素</td></tr>
                  <tr>
                    <td align="center" valign="top" bgcolor="#FFFFEE">
                    <table width="100%" height="100%"  border="0" cellpadding="3" cellspacing="0"  class="px14">
                        <tr>
                        <td align="right" valign="middle" >原消费交易的queryId：</td>
                        <td valign="middle" ><input name="origQryId" value="">（从原交易的后台通知报文或者交易状态查询返回的queryId中获取）</td>
                        </tr>
                        <tr>
                        <td align="right" valign="middle">退货金额txnAmt：</td>
                        <td valign="middle"><input type="text" name="txnAmt" value="10000">分（支持部分金额多次退货）</td>
                        </tr>
                        <tr>
                        <td valign="top" height="26">
                          <input name="button" type="button" value="退货" class="btn" onClick="onRefundForm();" />
                        </td>
                        <td valign="top">&nbsp;</td>
                      </tr>
                    </table>
                    <jsp:include  page="/other/refund_faq.jsp"/>
                    </td>
                  </tr>
                   
 </table>
</form>
</div>


<div id="queryDiv" style="display:none">
<form action="<%request.getContextPath();%>/ACPSample_B2C/form_6_5_Query" method="post" name="queryForm"  id="queryForm" target="_blank">
<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#FFCC00">
                  <tr bgcolor="#FFFFEE"><td width="102" height="26" align="right" valign="middle"><b>填写交易状态查询关键要素</td></tr>
                  <tr>
                    <td align="center" valign="top"  bgcolor="#FFFFEE">
                    <table width="100%" height="100%"  border="0" cellpadding="3" cellspacing="0"  class="px14">
                        <tr>
                        <td align="right" valign="middle" >被查询交易的orderId：</td>
                        <td valign="middle" ><span style="color:#000000;font-size:12px;"><input name="orderId" value=""></span></td>
                        </tr>
                        <tr>
                        <td align="right" valign="middle">被查询交易的订单发送时间txnTime：</td>
                        <td valign="middle"><input type="text" name="txnTime" value="">格式（YYYYMMDDhhmmss）</td>
                        </tr>
                        <tr>
                        <td valign="top" height="26">
                          <input name="button" type="button" value="交易状态查询" class="btn" onClick="onQueryForm();" />
                        </td>
                        <td valign="top">&nbsp;</td>
                      </tr>
                    </table>
                     <jsp:include  page="/other/query_faq.jsp"/>
                    </td>
                  </tr>
 </table>
</form>
</div>

<div id="fileTransferDiv" style="display:none">
<form action="<%request.getContextPath();%>/ACPSample_B2C/form_6_6_FileTransfer" method="post" name="fileTransferForm"  id="fileTransferForm" target="_blank">
<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#FFCC00">
                  <tr bgcolor="#FFCC00"><td width="102" height="26" align="right" valign="middle"><b>填写对账文件下载关键要素</td></tr>
                  <tr>
                    <td align="center" valign="top"  bgcolor="#FFFFEE">
                    <table width="100%" height="100%"  border="0" cellpadding="3" cellspacing="0"  class="px14">
                    <tr>
                        <td align="left" valign="middle">商户号merId：</td>
                        <td valign="middle"><span style="color:#000000;font-size:12px;">
                          <input name="merId" type="text" value="700000000000001" >此商户号下载的对账文件仅为样例文件，如果使用此商户号清算日期固定为0119（如果使用正式商户号下载商户号对应的对账文件，测试环境下载不到请连到银联生产环境下载测试）
                        </span></td>
                      </tr>
                        <tr>
                        <td align="right" valign="middle" >清算日期settleDate：</td>
                        <td valign="middle" ><span style="color:#000000;font-size:12px;"><input name="settleDate" value="0119"></span>格式（MMDD）</td>
                        </tr>
                        <tr>
                        <td valign="top" height="26">
                          <input name="button" type="button" value="下载对账文件" class="btn" onClick="onfileTransferForm();" />
                        </td>
                        <td valign="top">&nbsp;</td>
                      </tr>
                    </table>
                     <jsp:include  page="/other/fileTransfer_faq.jsp"/>
                    </td>
                  </tr>
                  
 </table>
</form>
</div>


</td>
</tr>
</table>
</body>
</html>