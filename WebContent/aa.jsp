<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

	<head>
		
		<meta charset="utf-8">
		<meta http-equiv="Access-Control-Allow-Origin" content="*">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link href="css/app.css" rel="stylesheet" />
		<link href="css/mui.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		
		<style type="text/css">
			#test{
				width: 100%;
				padding: 10px;
				height: 1000px;
				border: 1px solid gainsboro;
				border-radius: 8px;
			}
			.inner {
				display: inline-block;
				padding: 20px;
				border: 1px solid gainsboro;
				text-align: center;
				margin-left: 20px;
				margin-bottom: 20px;
				border-radius: 8px;
			}
			.inner:hover{
				border: 1px solid deeppink;
			}
			.inner:hover h3{
				color: deeppink;
			}
			.inner img {
				width: 20px;
				height: 20px;
				font-size: 0;
			}
			
			h3,
			span {
				font-size: 20px;
			}
		</style>

	</head>


	<body>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">推荐菜品表</h1>
		</header>
		<div id="test">
				
				
		
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script src="js/GreensURL.js"></script>
		<script src="js/mui.min.js"></script>
		<script src="js/app.js"></script>
		<script src="js/mui.js"></script>
		<script src="js/mui.jsonp.js"></script>
		<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
		<script>
			
			mui.plusReady(function(){
					var a = plus.storage.getItem("loginName");
					$.ajax("http://211.149.232.210/ACPSample_B2C/bb00",{
					dataType:"json",
					type:"get",
					data:{
						"name":a
					},
					
					error:function(data){
						mui.alert("失败2");
					},
					success:function(data){
						//mui.alert(data);
						//mui.alert(data);
						var html = "";
						for(var i=0;i<data.length;i++){
							//console.log(data);
						//mui.alert(data);
						html +='<div class="inner">';
						html +='<h3>'+'推荐菜品:'+data[i].TJ_Name+'</h3>';
						
						html +='</div>';
						
						//console.log(data[i].oo_Number);
						
						
					};
					$("#test").append(html);
					},
				});
				
			});

		</script>
	</body>  

</html>