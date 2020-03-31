<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
</style>
<SCRIPT type=text/javascript src="js/jquery.js"></SCRIPT>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=mFbn9cdc2axR529jMOe7iXv4AiYrmxZC"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/AreaRestriction/1.2/src/AreaRestriction_min.js"></script>
<title>IP定位获取当前城市</title>
</head>
<body>
<div id="allmap">
<div id="r-result"></div>
</div>
</body>
<script type="text/javascript">




//利用ip定位当前城市
function myFun(result){
var cityName = result.name;
map.setCenter(cityName);
//alert("当前定位城市:"+cityName);
}
var myCity = new BMap.LocalCity();
myCity.get(myFun);

// 百度地图API功能
var map = new BMap.Map("allmap");
var point = new BMap.Point(116.331398,39.897445);
map.centerAndZoom(point,12);
map.enableScrollWheelZoom();


// 定义一个控件类,即function
function ZoomControl(){
// 默认停靠位置和偏移量
this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;
this.defaultOffset = new BMap.Size(10, 10);
}
// 通过JavaScript的prototype属性继承于BMap.Control
ZoomControl.prototype = new BMap.Control();
// 自定义控件必须实现自己的initialize方法,并且将控件的DOM元素返回
// 在本方法中创建个div元素作为控件的容器,并将其添加到地图容器中
ZoomControl.prototype.initialize = function(map){
// 创建一个DOM元素
var div = document.createElement("div");
// 添加文字说明
div.appendChild(document.createTextNode("周边资源搜索"));
div.appendChild(document.createElement("br")); 
div.appendChild(document.createElement("br")); 
div.appendChild(document.createTextNode("关键字 ")); 
var input = document.createElement('input'); //创建input节点
input.setAttribute('type', 'text'); //定义类型是文本输入
input.setAttribute('size', '15px'); //定义类型是文本输入
input.setAttribute('id','keyword');
div.appendChild(input ); 
div.appendChild(document.createElement("br")); 
div.appendChild(document.createTextNode("搜索范围 ")); 
var input1 = document.createElement('input'); //创建input节点
input1.setAttribute('type', 'text'); //定义类型是文本输入
input1.setAttribute('size', '15px'); //定义类型是文本输入
input1.setAttribute('id', 'searchscope'); //定义类型是文本输入
div.appendChild(input1 ); 

div.appendChild(document.createElement("br")); 
div.appendChild(document.createTextNode("搜索内容 ")); 
var input2 = document.createElement('input'); //创建input节点
input2.setAttribute('type', 'text'); //定义类型是文本输入
input2.setAttribute('size', '15px'); //定义类型是文本输入
input2.setAttribute('id', 'searchcontent');
div.appendChild(input2 ); 
div.appendChild(document.createElement("br")); 
div.appendChild(document.createElement("br")); 
var button = document.createElement('input'); //创建input节点
button.setAttribute('type', 'button'); //定义类型是文本输入
button.value="搜索"; //定义类型是文本输入
button.id='search1';
div.appendChild(button ); 
// 设置样式
div.setAttribute('align','center');
div.style.cursor = "pointer";
div.style.border = "1px solid gray";
div.style.backgroundColor = "white";
div.style.width="250px"; 
div.style.height="200px"; 
// 绑定事件,点击一次放大两级
div.onclick = function(e){
map.setZoom(map.getZoom() + 2);
}
// 添加DOM元素到地图中
map.getContainer().appendChild(div); 
// 将DOM元素返回
return div;
}
// 创建控件
var myZoomCtrl = new ZoomControl();
// 添加到地图当中
map.addControl(myZoomCtrl);

//周边搜索
$("#search1").click(function(){
var searchN=document.getElementById("keyword").value;
var searchscope=document.getElementById("searchscope").value;
var searchcontent=document.getElementById("searchcontent").value;
var myKeys = [searchN, searchcontent];
var local = new BMap.LocalSearch(map, {
renderOptions:{map: map, panel:"r-result"},
pageCapacity:5
});
local.searchInBounds(myKeys, map.getBounds());
//local.searchNearby(myKeys,point,searchscope);
}); 
</script>
</html>