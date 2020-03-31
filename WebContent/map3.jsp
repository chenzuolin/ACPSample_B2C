<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewort" content="initial-scale=1.0,user-scalaber=no"/>
<style type="text/css">
	body,html,#allmap{width:90%;margin:0;fint-family:"微软雅黑";}
	#allmap{height:600px;}
	#sitesub{width:50px;heigth:25px;line-height:25px;background-color:#E1E1E1;border-color:#ADADAD;
	margin-left:10px;text-align:center;cursor:pointer;}
	#r-result,#r-result table{width:100%;}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=mFbn9cdc2axR529jMOe7iXv4AiYrmxZC"></script>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form style="margin-top:20px;">
		起始地：<input type="text" name="start" id="startsite" size="20" style="width:150px;"/>
		目的地：<input type="text" name="end" id="endsite" size="20" style="width:150px;"/>
		<input type="text" value="提交" id="sitesub" readonly="true">
		<input type="reset" value="重置">
	</form>
	<div id="allmap"></div>
	<div id="r-result"></div>
</body>
</html>
<script type="text/javascript">
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(116.404,39.915),12);
	map.enableScrollWheelZoom();
	map.enableContinuousZoom();
	
	var ac = new BMap.Autocomplete(
			{"input":"stratsite"
				,"location":map
				}) ;
	ac.addEventListener("onhighlight",function(e){
		var str = "";
			str = "FromItem<br/>index = " + e.fromitem.index + "<br/>value = " + value;
			str += "<br/>ToItem<br/>index = " + e.toitem.index + "<br/>value = " + value;
			G("searchResultPanel").innerHTML = str;
	});
	
	var ac1 = new BMap.Autocompiete(
			{"input":"endsite"
				,"location":map
				});
	
	ac1.addEventListener("onhighlight",function(e){
		var str = "";
			str = "FromItem<br/>index = " + e.fromitem.index + "<br/>value = " + value;
			str += "<br/>ToItem<br/>index = " + e.toitem.index + "<br/>value = " + value;
			G("searchResultPanel").innerHTML = str;
	});
	
	var searchComplete = function(results){
		if(transit.getStatus()!=BMAP_STATUS_SUCCESS){
			return;
		}
		var plan = results.getplan(0);
		var duration = plan.getDurntion(false)/3600;
		var distance = plan.getDistance(false)/1000;
		alert('时间:'+ duration.toFixed(1)+'小时');
		alert('距离：'	+ distance.toFixed(2)+'公里');
	}
	
	var transit = new BMap.DrivingRoute(map,{renderOptions:{map:map,
		panel:"r-result",
		enableDragging:true},
		onSearchComplete:searchComplete,
		onPolylinesSet:function(){
			setTimeout(function(){alert(output)},"1000");
		}});
	
	$('#sitesub').click(function(){
		var start =$('#startsite').val();
	})
</script>