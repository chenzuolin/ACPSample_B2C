<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>酒店注册</title>
    <link href="layui-v2.3.0/layui/css/layui.css" rel="stylesheet" >
  
</head>
<body>
   
 <form name="frmlogin" method="post" action="JDZCServlet" class="layui-form layui-form-pane"  style="width:30%; padding-left: 30%;">
 
<h1 class="layui-header" style="font-size:30px; text-align: center;">绿盟快线酒店注册</h1> 
<div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      <input type="text" name="Wineshop_UserName"   lay-verify="required|title" required placeholder="请输入用户名" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">输入密码</label>
    <div class="layui-input-block">
      <input type="password" name="Wineshop_Password" id="pw1"  lay-verify="required|title" required placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-block">
      <input type="password" name="Wineshop_Password" id="pw2"  lay-verify="required|title" required placeholder="请确认您的密码" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">酒店名称</label>
    <div class="layui-input-block">
      <input type="text" name="Wineshop_Name"   lay-verify="required|title" required placeholder="请输入酒店名称" autocomplete="off" class="layui-input">
    </div>
</div>


<div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-block">
      <input type="text" name="Wineshop_Telephone"   lay-verify="required|title" required placeholder="请输入联系电话" autocomplete="off" class="layui-input">
    </div>
</div>
     	<div class="layui-form-item">
    <label class="layui-form-label">资质</label>
   <button type="button" class="layui-btn" id="test1">
  <i class="layui-icon">&#xe67c;</i>上传图片
</button>
</div>
  
<div class="layui-form-item">
    <label class="layui-form-label">选择框</label>
    <div class="layui-input-block">
      <select name="Wineshop_Nature" lay-filter="interest">
        <option value="0" selected>请选择</option>
       <option value="">私营酒店</option>
        <option value="0">企事业单位</option>
       
      </select>
    </div>
  </div>
       <div class="layui-form-inlin">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-block">
      <input type="text" name="Wineshop_Address"   lay-verify="required|title" required placeholder="请输入酒店地址" autocomplete="off" class="layui-input">
    </div>
</div>
  <div class="layui-form-item">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-block">
      <input type="text" name="Wineshop_QQ"   lay-verify="required|title" required placeholder="请输入QQ号" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">微信</label>
    <div class="layui-input-block">
      <input type="text" name="Wineshop_WeChat"   lay-verify="required|title" required placeholder="请输入微信号" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">负责人</label>
    <div class="layui-input-block">
      <input type="text" name="Wineshop_Shift_Name"   lay-verify="required|title" required placeholder="请输入负责人名称" autocomplete="off" class="layui-input">
    </div>
</div>
       	 <input style="margin-left: 50px;"  type="checkbox" checked/>我已看过并接受<a href="userxieyi.html">《用户协议》</a>
 <div class="layui-form-item" >

   
  
<input type="submit"  class="layui-btn layui-btn-small" value="立即注册" />

    
    </form>
<script src="../layui/layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
<script src="../layui/layui/layui.js"></script>
<script>
layui.use('upload', function(){
  var upload = layui.upload;
   
  //执行实例
  var uploadInst = upload.render({
    elem: '#test1' //绑定元素
    ,url: '/upload/' //上传接口
    ,done: function(res){
      //上传完毕回调
    }
    ,error: function(){
      //请求异常回调
    }
  });
});
</script>
</body>
</html>
