
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd

">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>蔬菜上传界面</title>
 <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="jqueryui/style.css">
</head>
<body>

<script language="JavaScript" type="text/javascript">
function check(aaa)
{
if(aaa.Greens_Unit.value ==""||aaa.Greens_Name.value ==""||aaa.Greens_Price.value ==""||aaa.Greens_Market_Price.value ==""||aaa.Greens_Character.value ==""||aaa.Greens_Period.value ==""||aaa.Greens_Condition.value ==""||aaa.Greens_Minnumber.value ==""||aaa.Greens_Norms.value ==""||aaa.Greens_Number.value ==""||aaa.Greens_Class.value =="")
{
alert("内容不能为空！");
return false;
}
else return true;
}
</script>
 <script>
$(document).ready(function(){
    $("#Greens_characteristics_0").click(function(){
    	   $("#div1").show();
    });
 
});


</script> <script>
$(document).ready(function(){
    $("#Greens_characteristics_1").click(function(){
    	   $("#div1").hide();
    });
 
});


</script>

 <script>
  $(function() {
    $( "#datepicker1" ).datepicker();
  });
  </script>
   <script>
  $(function() {
    $( "#datepicker2" ).datepicker();
  });
  </script>

<form name="form1" method="post" action="GreensServlet" onsubmit="return check(this)">
  <table width="100%" height="174" border="1">
    <tr>
      <td width="10%" align="center">名称</td>
      <td width="21%" align="center"><label for="Greens_Name"></label>
      <input type="text" name="Greens_Name" id="Greens_Name"></td>
      <td width="11%" align="center">单位</td>
      <td width="13%" align="center"><label for="Greens_Unit"></label>
      <input type="text" name="Greens_Unit" id="Greens_Unit"></td>
    
      <td width="4%" align="center">单价</td>
      <td width="15%" align="center"><label for="Greens_Price"></label>
      <input type="text" name="Greens_Price" id="Greens_Price"></td>
      <td width="9%" align="center">市场价</td>
   
      <td width="17%" align="center"><label for="Greens_Market_Price"></label>
      <input type="text" name="Greens_Market_Price" id="Greens_Market_Price"></td>
    </tr>
    <tr>
      <td align="center">品质</td>
      <td align="center"><label for="Greens_Character"></label>
      <input type="text" name="Greens_Character" id="Greens_Character"></td>
      <td align="center">保质期</td>
      <td align="center"><label for="Greens_Period"></label>
      <input type="text" name="Greens_Period" id="Greens_Period"></td>
    
      <td align="center">品向</td>
      <td align="center"><input type="text" name="Greens_Condition" id="Greens_Condition"></td>
      <td align="center">最少采购数量</td>
      <td align="center"><input type="text" name="Greens_Minnumber" id="Greens_Minnumber"></td>
    </tr>
    <tr>
      <td align="center">规格</td>
      <td align="center"><input type="text" name="Greens_Norms" id="Greens_Norms"></td>
      <td align="center">库存量</td>
      <td align="center"><input type="text" name="Greens_Number" id="Greens_Number"></td>
   
      <td align="center">产地</td>
      <td align="center"><input type="text" name="Greens_Class" id="Greens_Class"></td>
   
    </tr>
      <tr>
      <td align="center">季节性</td>
      <td align="center"><p>
        
          <input type="radio"  name="Greens_characteristics" value="0" id="Greens_characteristics_0">
          是
        
  
          <input type="radio" name="Greens_characteristics" value="1" id="Greens_characteristics_1">
          否
      (必填)</td>
      <td align="center">是否推荐</td>
      <td align="center"><p>
       
          <input type="radio" name="Greens_Recommend" value="0" id="Greens_Recommend_0">
          是
        <br>
     
          <input type="radio" name="Greens_Recommend" value="1" id="Greens_Recommend_1">
          否
        <br>
      </p>(必填)</td>
    
      <td align="center">备注</td>
      <td align="center"><input type="text" name="Greens_Remark" id="Greens_Remark"></td>
      
    </tr>
  </table>
  <div id="div1" style=" display:none">
    提醒周期：
    <p>日期：<input type="text" id="datepicker1" name="datepicker1"></p>
    --
    <p>日期：<input type="text" id="datepicker2"></p>
</div>
 
  <input type="submit" name="button" id="button" value="提交" >
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
</form>
</body>
</html>
