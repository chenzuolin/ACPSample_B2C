<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
</br><b>预授权撤销交易您可能会遇到...</b>
<ul style="font-size: 10px;font-weight: normal;">
<li>
  原交易状态不正确[2040004]:撤销交易报文origQryId上送错误，没有找到被撤销的交易
</li>
</br>
<li>
   原交易状态不正确[2040006]:撤销交易日期错（非当日），需在同一清算日（测试环境13:30-13:30,生产环境 23:00-23:00）发起
</li>
</br>
<li>
  与原交易信息不符[2050008]：撤销交易的金额必须与预授权交易相同 
</li>
</ul>
<jsp:include  page="/other/more_faq.jsp"/>