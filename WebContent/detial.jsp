<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
<link href="layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
<title>酒店详情</title>
<style>
.layui-form-label{width:100px;}
</style>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>酒店信息</legend>
</fieldset>
<form class="layui-form" id="tp" action="${pageContext.request.contextPath}/UpdateWineshopServlet" method="post">
 <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">用户名</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_UserName" value='${m.wineshop_UserName }' lay-verify="title" placeholder="请输入用户名" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">密码</label>
      <div class="layui-input-inline">
        <input type="password" name="wineshop_Password" value="${m.wineshop_Password }" lay-verify="pass" autocomplete="off" placeholder="请输入密码" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">酒店名称</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_Name" value="${m.wineshop_Name }" lay-verify="required" autocomplete="off" placeholder="请输入酒店名称" class="layui-input">
      </div>
    </div>
  </div>
  
   <div class="layui-form-item">
   <div class="layui-inline">
      <label class="layui-form-label">负责人</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_Shift_Name" value="${m.wineshop_Shift_Name }" lay-verify="required" placeholder="请输入酒店负责人" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">联系电话</label>
      <div class="layui-input-inline">
        <input type="tel" name="wineshop_Telephone" value="${m.wineshop_Telephone }" lay-verify="required|phone" autocomplete="off" placeholder="请输入联系电话" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">酒店性质</label>
      <div class="layui-input-inline">
	      <select name="wineshop_Nature">
	        <option value="${m.wineshop_Nature }" selected="">${m.wineshop_Nature }</option>
	        <option value="周结记帐">周结记帐</option>
	         <option value="普通酒店">普通酒店</option>
	      </select>
      </div>
    </div>
</div>
    
<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">酒店QQ</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_QQ" value="${m.wineshop_QQ }" lay-verify="required" placeholder="请输入酒店QQ" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">酒店微信</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_WeChat" value="${m.wineshop_WeChat }" lay-verify="required" autocomplete="off" placeholder="请输入酒店微信" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">证件编号</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_Number" value="${m.wineshop_Number }" lay-verify="required" autocomplete="off" placeholder="请输入证件编号" class="layui-input">
      </div>
    </div>
</div>

 <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">最早收货时间</label>
      <div class="layui-input-inline">
        <input type="text" id="test1" name="wineshop_Time" value="${m.wineshop_Time }" lay-verify="required" placeholder="请输入最早收货时间" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">最晚收货时间</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_TimeNight" value="${m.wineshop_TimeNight }" lay-verify="required" autocomplete="off" placeholder="请输入最晚收货时间" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">推荐人</label>
      <div class="layui-input-inline">
        <input type="text" name="wineshop_TuiJian" value="${m.wineshop_TuiJian }" lay-verify="required" autocomplete="off" placeholder="请输入推荐人" class="layui-input">
      </div>
    </div>
</div>

<div class="layui-form-item">
	    <div class="layui-inline">
	      <label class="layui-form-label">ID</label>
	      <div class="layui-input-inline">
	        <input type="text" name="wineshop_ID" value="${m.wineshop_ID }" readonly="readonly" lay-verify="required" placeholder="请输入最早收货时间" autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
		    <label class="layui-form-label">地址</label>
		    <div class="layui-input-inline">
		      <input type="text" name="addr" value="${m.wineshop_Address }"  lay-verify="title" autocomplete="off" placeholder="请输入酒店地址" class="layui-input" style="width:534px;">
		    </div>
  		</div>
</div>
  	
  <div class="layui-form-item">
    <div class="layui-input-block">
      <input class="layui-btn" type="submit" value="立即提交" /> 
      <input type="reset" class="layui-btn value="重置" />
    </div>
  </div>
</form>
<script src="layui-v2.4.5/layui/layui.all.js"></script>
<script src="layui-v2.4.5/layui/lay/modules/layer.js"></script>
<script src="layui-v2.4.5/layui/lay/modules/laydate.js"></script>
<script>
layui.use(['form', 'layedit', 'laydate','jquery'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  var $ = layui.jquery;
 
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '用户名至少得5个字符啊';
      }
    }
    ,pass: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ]
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
});
</script>
</body>
</html>