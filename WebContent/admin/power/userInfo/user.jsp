<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户信息</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.5.2/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
</head>
<body>
<form class="layui-form" id="tp" action="" style="margin-top:15px;margin-left:15px;">
	<button type="button" class="layui-btn layui-btn-lg layui-btn-primary layui-btn-radius" id="add"><i class="layui-icon">&#xe654;</i>添加用户</button>
</form>
<table class="layui-hide" id="test" lay-filter="test"></table>


<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="detail">编辑</a>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-radius layui-btn-normal" lay-event="getCheckData"><i class="layui-icon">&#xe601;</i>导出</button>
    <button class="layui-btn layui-btn-radius layui-btn-warm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-radius layui-btn-danger" lay-event="isAll">是否全选</button>
  </div>
</script>
          
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/layer.js"></script>   
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.5.2/layui/lay/modules/form.js"></script>
 <script type="text/html" id="switchTpl">
  <input type="checkbox" name="sex" value="{{d.sex}}" lay-skin="switch" lay-text="女|男" lay-filter="sexDemo" {{ d.sex == 1 ? 'checked' : '' }}>
</script>
<script>
layui.use(['table','layer','jquery','laydate','form'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var laydate = layui.laydate;
  var layer = layui.layer;
  var form = layui.form;
  table.render({
	    elem: '#test'
	    ,url:'${pageContext.request.contextPath}/FindAllUser'
	    ,title: '用户信息'
	    ,even: true
	    ,height: 500
	    ,cols: [[
	      {type: 'checkbox', fixed: 'left'}
	   	  ,{field:'user_Name', title:'用户名',align:'center'}
	      ,{field:'user_Password', title:'密码', align:'center'}
	      ,{field:'sex', title:'性别',templet: '#switchTpl',align:'center'}
	      ,{field:'birthday', title:'生日'}
	      ,{field:'user_Date', title:'注册时间'}
	      ,{field:'profile', title:'描述'}
	      ,{field:'role_Name', title:'角色权限'}
	      ,{field:'role_Remark', title:'角色描述'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo',align:'center'}
	    ]]
	  });
   table.on('toolbar(test)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    switch(obj.event){
	      case 'getCheckData':
	        var data = checkStatus.data;
	        if(data.length == 0){
	        	layer.msg('请选择需要打印的数据！');
	        	return false;
	        }
	        table.exportFile(ins1.config.id,data, 'xls');
	      break;
	      case 'getCheckLength':
	        var data = checkStatus.data;
	        layer.msg('选中了：'+ data.length + ' 个');
	      break;
	      case 'isAll':
	        layer.msg(checkStatus.isAll ? '全选': '未全选');
	      break;
	    };
	  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var uid = obj.data.user_ID;
    var userName = obj.data.user_Name;
    var pwd = obj.data.user_Password;
    var sex = obj.data.sex;
    var birthday = obj.data.birthday;
    var profile = obj.data.profile;
    var data = {
    		userName : userName,
    		pwd : pwd,
    		birthday : birthday,
    		profile : profile
    }
    if(obj.event === 'detail'){
    	layer.open({
  	      type: 2,
  	      title: userName,
  	      shadeClose: true,
  	      shade: 0.4,
  	      area: ['50%', '90%'],
  	      content: "${pageContext.request.contextPath}/admin/power/userInfo/editUser.jsp" ,
  	      success: function (layero, index) {
  	    	var body = layer.getChildFrame('body', index);
            result = JSON.stringify(data);
            result = $.parseJSON(result);
            $.each(result, function (item) {
                body.find('#form-data' + item).val(result[item]);
                if (item == 'userName') {
                    body.find('#userName').val(result[item]);
                } 
                if (item == 'pwd') {
                    body.find('#pwdOne').val(result[item]);
                } 
                if (item == 'pwd') {
                    body.find('#pwdTwo').val(result[item]);
                } 
                if (item == 'birthday') {
                    body.find('#date1').val(result[item]);
                } 
                if (item == 'profile') {
                    body.find('#proFile').val(result[item]);
                } 
            });
  	        },
	  	    btn: ['确定'],
		      yes: function(index,layero){
		    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
		    	  var userName1 = arr.userName1;
		    	  var pwdOne1 = arr.pwdOne1;
		    	  var pwdTwo1 = arr.pwdTwo1;
		    	  var birthday1 = arr.birthday1;
		    	  var rolePower1 = arr.rolePower1;
		    	  var proFile1 = arr.proFile1;
		    	  if(pwdOne1 != pwdTwo1){
		    		  layer.msg('密码输入不一致哦！');
		    		  return false;
		    	  }
		    	  $.ajax({
		  			type:"post",
		  			url:"${pageContext.request.contextPath}/UpdateUser",
		  			data:{
		  				"userName":userName1,
		  				"pwd":pwdOne1,
		  				"birthday":birthday1,
		  				"rolePower":rolePower1,
		  				"proFile":proFile1,
		  				"uid":uid
		  			},
		  			success:function(data){
		  				if(data == 200){
		  					layer.msg('修改成功了哦！');
		  				}
		  				
		  			}
		  			
		  		});
		          layer.close(index);
		      },
  	  });
    } 
  });
  
  $('#add').on('click', function(){
	  layer.open({
	      type: 2,
	      title: "添加用户",
	      shadeClose: true,
	      shade: 0.4,
	      area: ['50%', '90%'],
	      content: "${pageContext.request.contextPath}/admin/power/userInfo/addUserInfo.jsp" ,
	      btn: ['确定'],
	      yes: function(index,layero){
	    	  var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
	    	  var userName = arr.userName1;
	    	  var pwdOne = arr.pwdOne1;
	    	  var pwdTwo = arr.pwdTwo1;
	    	  var birthday = arr.birthday1;
	    	  var sex = arr.sex1;
	    	  var rolePower = arr.rolePower1;
	    	  var proFile = arr.proFile1;
	    	  if(userName == '' || rolePower == '' || sex == '' || birthday == ''){
	    		  layer.msg('用户信息不能为空哦！');
	    		  return false;
	    	  }
	    	  if(pwdOne != pwdTwo){
	    		  layer.msg('密码输入不一致哦！');
	    		  return false;
	    	  }
	    	  var userInfoData = {
	    			  userName:userName,
	    			  pwdOne:pwdOne,
	    			  birthday:birthday,
	    			  sex:sex,
	    			  rolePower:rolePower,
	    			  proFile:proFile
	    	  }
	    	  $.ajax({
	  			type:"post",
	  			url:"${pageContext.request.contextPath}/UserInfoPower",
	  			data:userInfoData,
	  			success:function(data){
	  				if(data == 200){
	  					layer.msg('添加成功了哦！');
	  				}
	  			}
	  			
	  		});
	          layer.close(index);
	      },
  	      end:function(){
	          	$('.layui-laypage-btn').click();
	          }
          
	  });
  });

});
</script>
</body>
</html>