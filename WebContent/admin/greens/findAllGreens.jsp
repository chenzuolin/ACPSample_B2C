<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>蔬菜信息</title>
  <meta name="renderer" content="webkit">
  <link rel="shortcut icon" href="../../index.ico" type="image/x-icon" />
   <link rel="shortcut icon" href="${pageContext.request.contextPath}/index.ico" type="image/x-icon" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/layui.css" rel="stylesheet" media="all">
  <link href="${pageContext.request.contextPath}/layui-v2.4.5/layui/css/modules/layer/default/layer.css" rel="stylesheet" media="all">
   <style>
        #tableTbImg + .layui-table-view .layui-table-body tbody > tr > td {
            padding: 0;
        }

        #tableTbImg + .layui-table-view .layui-table-body tbody > tr > td > .layui-table-cell {
            height: 60px;
            line-height: 60px;
        }

        .tdImg {
            width: 50px;
            height: 50px;
            max-width: none;
            cursor: zoom-in;
        }

        .layui-table-view {
            margin: 0;
        }
    </style>

</head>
<body>
<form class="layui-form" id="tp" action="${pageContext.request.contextPath}/FindByGreensNameLike" method="post">
<div class="demoTable" style="margin:10px 10px;">
  蔬菜名称：
  <div class="layui-inline">
    <input class="layui-input" name="name" id="demoReload" placeholder="请输入蔬菜名称" autocomplete="off">
  </div>
 <div class="layui-btn layui-btn-primary layui-btn-radius" data-type="reload"  lay-filter="rechar_btn" id="rechar_btn" ><i class="layui-icon">&#xe615;</i></div>
</div>
</form>
<!-- 正文开始 -->
<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-card-body" id="layPhotosTbImg">
           <table class="layui-hide" id="test" lay-filter="test"></table>
        </div>
    </div>
</div>



<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">是否全选</button>
  </div>
</script>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>
<script type="text/html" id="xuhao">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script type="text/html" id="switchTpl">
  <input type="checkbox" name="Greens_Stop" data-id="{{d.greens_ID}}" lay-skin="switch" lay-text="已上架|未上架" lay-filter="sexDemo" {{ d.greens_Stop == 0 ? 'checked' : '' }}>
</script>
<script type="text/html" id="soreSwitchTpl">
  <input type="checkbox" name="greens_Sore" data-id="{{d.greens_ID}}" lay-skin="switch" lay-text="是|否" lay-filter="sore" {{ d.greens_Sore == 1 ? 'checked' : '' }}>
</script>
<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/lay/modules/layer.js"></script>
<script src="${pageContext.request.contextPath}/layui-v2.4.5/layui/layui.all.js"></script>
<script>
layui.use(['table','layer','jquery','form'], function(){
  var table = layui.table;
  var $ = layui.jquery;
  var form = layui.form;
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/FindAllGreens'
    ,toolbar: '#toolbarDemo'
    ,title: '蔬菜信息表'
    ,height: 700
    ,id: 'green'
    ,totalRow: true 
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
   	  ,{field:'rownum', fixed: 'xuhao',title:'序号',templet: '#xuhao',width:80, align:'center', totalRowText: '合计：'}
      ,{field:'greens_ID', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'greens_Name', title:'蔬菜名称', width:180}
      ,{align: 'center', templet: function (d) {
          		var url = 'http://www.sumengkx.com/app/GreensShop/'+d.greens_tupian;
          		return '<img src="' + url + '" alt="加载中..." class="tdImg" />';
      		}, title: '蔬菜头像', width: 100, unresize: true
	   }
      ,{field:'bigName', title:'大类名称', width:200}
      ,{field:'greens_Type_Name', title:'小类名称', width:150, sort: true}
      ,{field:'greens_Price', title:'速盟价格', width:100, sort: true, align:'center' ,totalRow: true,templet: function(d){
    	  return d.greens_Price+'元/'+d.greens_Unit;    
    	  }
      }
      ,{field:'greens_Market_Price', title:'市场单价', sort: true,width:100, align:'center', totalRow: true,templet: function(d){
    	  return d.greens_Market_Price+'元/'+d.greens_Unit;
      	}
      }
      ,{field:'greens_Number', title:'库存', sort: true, totalRow: true,align:'center',width:125}
      ,{field:'greens_Remark', title:'描述', align:'center'}
      ,{field:'greens_Stop', title:'商品状态',templet: '#switchTpl',align:'center',width:125, fixed: 'right'}
      ,{field:'greens_Sore', title:'活动商品',templet: '#soreSwitchTpl',align:'center',width:100, fixed: 'right'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150, align:'center'}
    ]]
    ,page: {
    	limit: 20,
    	layout:['prev','page','next','skip','limit','count',],
    	limits:[10,20,40,60,80,100,500,1000,5000],curr:1,groups:10,first:'首页',last:'尾页'
    	},request:{
    	pageName:'currentPage',
    	limitName:'size'
    },
    done: function () {
        layer.photos({
            photos: '#layPhotosTbImg',
            shade: .1,
            closeBtn: true
        });
    }

  });
  
  form.on('switch(sexDemo)', function(obj){
		var greensId = $(this).attr('data-id');
		var greensStop = this.checked ? '0' : '1' ;
	  	$.ajax({
	  		type:'POST',
	  		url: '${pageContext.request.contextPath}/UpdateGreensStop',
	  		data:{id: greensId,stop: greensStop},
	  		dataType:'json',
	  		success:function(data){
	  			var code = parseInt(data);
	  			if(code == 200){
	  				layer.msg('修改成功了哦！',{icon:6, time:2000});
	  			}
	  		},
	  		error:function(data){
	  			layur.msg('修改失败了哦！',{icon:5,time:3000});
	  		}
	  	});
	  });
  form.on('switch(sore)', function(obj){
		var greensId = $(this).attr('data-id');
		var greensSore = this.checked ? '1' : '0' ;
		$.ajax({
	  		type:'get',
	  		url: '${pageContext.request.contextPath}/sore',
	  		data:{id: greensId,sore: greensSore},
	  		dataType:'json',
	  		success:function(data){
	  			var code = parseInt(data);
	  			if(code == 200){
	  				layer.msg('修改成功了哦！',{icon:6, time:2000});
	  			}
	  		},
	  		error:function(data){
	  			layur.msg('修改失败了哦！',{icon:5,time:3000});
	  		}
	  	});
	  
	  });
  
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        console.log(data);
        layer.alert(JSON.stringify(data));
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
    var data = obj.data
    ,layEvent = obj.event;
    var wName = obj.data.greens_Name;
    var id = obj.data.greens_ID;
    if(layEvent === 'detail'){
    	layer.open({
  	      type: 2,
  	      title: wName,
  	      shadeClose: true,
  	      shade: 0.4,
  	      area: ['90%', '90%'],
  	      content: "${pageContext.request.contextPath}/admin/greens/greensdetail.jsp?id="+id 
  	  });
      }
    else if(obj.event === 'edit'){
    	layer.open({
    	      type: 2,
    	      title: wName,
    	      shadeClose: true,
    	      shade: 0.4,
    	      area: ['90%', '90%'],
    	      content: "${pageContext.request.contextPath}/admin/greens/editgreens.jsp?id="+id ,
  	     	  btn: ['确定'],
  	      	  yes: function(index,layero){
  	      		 
  	    	    var arr=$(layero).find('iframe')[0].contentWindow.callbackdata();
  	    	  	var greenName = arr.gname;
  	    	  	var bigTypeName = arr.gbigName;
  	    	  	var typeName = arr.gTypeName;
  	    	  	var unit = arr.gUnit;
  	    	  	var price = arr.gPrice;
  	    	  	var mprice = arr.gmPrice;
  	    	  	var pinzhi = arr.gpinzhi;
  	    	  	var pinxiang = arr.gpinxiang;
  	    	  	var minNumber = arr.gminNumber;
  	    	  	var weight = arr.gweight;
  	    	  	var kucun = arr.gkucun;
  	    	  	var addr = arr.gaddr;
  	    	  	var tuijian = arr.gtuijian;
  	    	  	var jijie = arr.gjijie;
  	    	  	var remark = arr.gremark;
  	    	  	var day = arr.gday;
  	    	  	var up = arr.gup;
  	    	  	var id = arr.gid;
  	    		var gRemark = arr.gRemark;
  	    	    $.ajax({
  	  			  type:"post",
  	  			  url:"${pageContext.request.contextPath}/EditByIdGreensSubmit",
  	  			  data:{
  	  				  "greensName": greenName,
  	  				  "bigType": bigTypeName,
  	  				  "typeName": typeName,
  	  				  "unit": unit,
  	  				  "price": price,
  	  				  "mPrice": mprice,
  	  				  "pinzhi": pinzhi,
  	  				  "pinxiang": pinxiang,
  	  				  "minNumber": minNumber,
  	  				  "weight": weight,
  	  				  "kucun": kucun,
  	  				  "addr": addr,
  	  				  "tuijian": tuijian,
  	  				  "jijie": jijie,
  	  				  "remark": remark,
  	  				  "day": day,
  	  				  "up": up,
  	  				  "id": id,
  	  				 "gRemark":gRemark
  	  			  },
  	  			  success:function(data){
  	  				  if(data == 200){
  	  					layer.msg('修改成功了哦！');
  	  				  }
  	  				  
  	  			  }
  	  			
  	  		  });
  	            layer.close(index);
  	        },
	  	      end:function(){
	          	$('.layui-laypage-btn').click();
	          }
    	  });
    	
    }
  });
  var active = {
	      reload: function(){
	          var gname = $('#demoReload').val(); 
	          table.reload('green', {
	              url : '${pageContext.request.contextPath}/FindByGreensNameLike',
	              method:'post',
	              page: {
	                  curr: 1 
	              }
	              ,where: { 
	            	  name: gname
	              }
	          });
	      }
	  };
  $('#rechar_btn').on('click', function(){
      var type = $(this).data('type');
      
      if($('#demoReload').val()==""){
          layer.msg('查询条件不能为空');
          return false;
      }
      
      active[type] ? active[type].call(this) : '';
  });
});
</script>

</body>
</html>