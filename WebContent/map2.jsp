<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
 <style type="text/css">
        body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";font-size:14px;}
        #l-map{height:300px;width:100%;}
        #r-result{width:100%;}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=MvgKw7wYnN2EkfQ6iHDD29MBwiP1xeWs"></script>
<title>Insert title here</title>
</head>
<body>
<div id="l-map"></div>
    <div id="r-result">起始位置:<input type="text" id="suggestId" size="20" value="起点" style="width:350px;" /></div>
    <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
    <div style="height:20px;"></div>
    <div id="r-result2">终点位置:<input type="text" id="suggestId2" size="20" value="终点" style="width:350px;" /></div>
    <div id="searchResultPanel2" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>

    <div style="color:red;">根据输入提示,从下拉框中选择所需要的地址,如果没有你所需要的地址,则选择离你最近的下拉框中的地址</div>
    <div id="result" style="color:black;padding:10px"></div>
    <div id="dist" style="color:blue;padding:10px"></div>
    <div id="output" style="color:green;padding:10px"></div>

</body>
</html>
<script type="text/javascript">
    // 百度地图API功能
    function G(id) {
        return document.getElementById(id);
    }

    var map = new BMap.Map("l-map");
    map.centerAndZoom("兰州",12);                   // 初始化地图,设置城市和地图级别。
    var startaddPonit;
    var endaddPonit;
    var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
        {"input" : "suggestId"
        ,"location" : map
    });

    var ac2 = new BMap.Autocomplete(    //建立一个自动完成的对象
        {"input" : "suggestId2"
        ,"location" : map
    });

    ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
    var str = "";
        var _value = e.fromitem.value;
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }    
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }    
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G("searchResultPanel").innerHTML = str;
    });

    ac2.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
    var str = "";
        var _value = e.fromitem.value;
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }    
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }    
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G("searchResultPanel2").innerHTML = str;
    });

    var myValue;
    ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
    var _value = e.item.value;
        myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

        //setPlace();
    });

    var myValue2;
    ac2.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
    var _value = e.item.value;
        myValue2 = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel2").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue2;

        //setPlace2();
          getPoint();
        //getduration();
    });

    function setPlace(){
        map.clearOverlays();    //清除地图上所有覆盖物
        function myFun(){
            var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
            startaddPonit = pp;
            map.centerAndZoom(pp, 18);
            map.addOverlay(new BMap.Marker(pp));    //添加标注
        }
        var local = new BMap.LocalSearch(map, { //智能搜索
          onSearchComplete: myFun
        });
        local.search(myValue);
    }

    function geocodeSearch(add,i){

    }
    function getPoint(){
        var myGeo = new BMap.Geocoder();
        var points = [];
        myGeo.getPoint(myValue, function(point){
            if (point) {
                document.getElementById("result").innerHTML +=  myValue + ":" + point.lng + "," + point.lat + "</br>";
                var address = new BMap.Point(point.lng, point.lat);
                var marker = new BMap.Marker(address);
                map.addOverlay(marker);
                marker.setLabel(new BMap.Label("1:"+myValue,{offset:new BMap.Size(20,-10)}));
                points[0] = address;
                //console.log(address);
                //console.log(i);
                myGeo.getPoint(myValue2, function(point){
                    if (point) {
                        document.getElementById("result").innerHTML +=  myValue2 + ":" + point.lng + "," + point.lat + "</br>";
                        var address = new BMap.Point(point.lng, point.lat);
                        var marker = new BMap.Marker(address);
                        points[1] = address;
                        map.addOverlay(marker);
                        marker.setLabel(new BMap.Label("2:"+myValue2,{offset:new BMap.Size(20,-10)}));
                        console.log(points);
                        getduration(points[0],points[1]);
                    }
                }, "兰州市");
            }
        }, "兰州市");
    }
    function getdist(pointA,pointB){
        //var pointA = new BMap.Point(106.486654,29.490295);  // 创建点坐标A--大渡口区
        //var pointB = new BMap.Point(106.581515,29.615467);  // 创建点坐标B--江北区
        //alert((map.getDistance(pointA,pointB)));  //获取两点距离,保留小数点后两位
        G("dist").innerHTML = "直线距离"+map.getDistance(pointA,pointB) + "米";
        var polyline = new BMap.Polyline([pointA,pointB], {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5});  //定义折线
        map.addOverlay(polyline);     //添加折线到地图上
    }

    function getduration(point1,point2){
        //var startdm = G("suggestId").innerHTML;
        //var enddm = G("suggestId2").innerHTML;
        var output = "驾车需要";
        var searchComplete = function (results){
            if (transit.getStatus() != BMAP_STATUS_SUCCESS){
                return ;
            }
            var plan = results.getPlan(0);
            output += plan.getDuration(true) + "\n";                //获取时间
            output += "总路程为：" ;
            output += plan.getDistance(true) + "\n";             //获取距离
            G("output").innerHTML =output;
        }
        var transit = new BMap.DrivingRoute(map, {renderOptions: {map: map},
            onSearchComplete: searchComplete,
            onPolylinesSet: function(){        
                setTimeout(function(){alert(output)},"1000");
        }});
        transit.search(point1, point2);
    }


</script>
