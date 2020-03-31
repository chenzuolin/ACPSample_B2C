<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.9.0.js" type="text/javascript" language="javascript"></script>
<script language="javascript" type="text/javascript" src="js/area.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2" language="javascript"></script>
</head>
<body>
  <div>
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="w1000">
 <tr>
 <td>
  <td valign="top">
  <table width="1000px" border="0" cellspacing="0" cellpadding="0">
   <tr>
<td>
  <table width="1000px" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="19"><span style="padding-top: 2px;"></span></td>                      
                        <td width="60" style="font-size: 12px;">
                          出发城市                        </td>
                        <td>
                          <select id="AreaDept1_Province" style="width: 65px" onChange="changearea(this.value,document.getElementById('AreaDept1_Prefecture'));"
                            name="Area">
                            <option value="">-省份-</option>
                          </select>
                          <select id="AreaDept1_Prefecture" style="width: 65px" name="City" onchange="changecity(document.getElementById('AreaDept1_Province').value,document.getElementById('AreaDept1_Prefecture').value,document.getElementById('AreaDept1_Xian'))">
                            <option value="">-城市-</option>
                          </select>
                           <select id="AreaDept1_Xian" style="width: 65px" name="City">
                            <option value="">-县-</option>
                          </select>
                          <script language="JavaScript" type="text/javascript">
                            setup(document.getElementById("AreaDept1_Province"));
                            //$("#AreaDept1_Province").find("option[text='"+DProvice+"']").attr("selected",true);
                            //changearea(DProvice,document.getElementById('AreaDept1_Prefecture'));
                            //$("#AreaDept1_Prefecture").find("option[text='"+DCity+"']").attr("selected",true);
                          </script>                       </td>
                        <td width="26" align="center" style="font-size: 12px;">
                          到                        </td>
                        <td>
                          <select name="mdd" id="mdd" style="width: 65px" onChange="changearea(this.value,document.getElementById('cdd'));">
                            <option value='' selected="selected">-省份-</option>
                          </select>
                          <select name="cdd" id="cdd" style="width: 65px" onchange="changecity(document.getElementById('mdd').value,document.getElementById('cdd').value,document.getElementById('xian'))">
                            <option value="" selected="selected">-城市-</option>
                          </select>
                          <select name="xian" id="xian" style="width: 65px">
                            <option value="" selected="selected">-县-</option>
                          </select>
                          <script language="JavaScript" type="text/javascript">
                            setup(document.getElementById("mdd"));
                          </script>                       </td>
                        <td>
                            <div onclick="SetMap(); return false;" style="cursor: pointer; width:81px;">
                        <img src="images/search.gif" alt="中国公路里程查询" width="81" height="26" style="vertical-align: middle;" /></div></td>                        
                        <td><table width="380" border="0" cellspacing="0" cellpadding="0">
                         <tr>
                          <td width="50"> </td>
                          <td width="19"><span style="padding-top: 2px;"></span></td>
                          <td width="90" style="font-size: 12px;"> 出发城市 </td>
                          <td>
                            <input name="farea" type="text" id="farea" size="10" /></td>
                          <td width="26" align="center" style="font-size: 12px;"> 到 </td>
                          <td width="110"><input name="tarea" type="text" id="tarea" size="10" />
                          </td>
                          <td><div onclick="SetMap2(); return false;" style="cursor: pointer; width:81px;"> <img src="images/search.gif" alt="中国公路里程查询" width="81" height="26" style="vertical-align: middle;" /></div></td>
                         </tr>
                        </table></td>
                      </tr>
      </table>   
      </div>  </td>
   </tr>
   <tr>
    <td><div style="border: #cccccc 1px solid; padding:5px;"></div></td>
   </tr>   
   <tr>
    <td> </td>
   </tr>
   <tr>
    <td valign="top">
    <div style="float: left; width: 670px; vertical-align: top;">
      <div style="height: 500px; border: 1px solid gray" id="container">      </div>
    </div>
    <div style="float: right; width: 300px; vertical-align: top;">
      <div style="border: #cccccc 1px solid;">
        <div class="content_title" style="color:Red; background-image:url();border-bottom:solid 1px #ccc; height:30px; text-align:center; font-weight:bold; line-height:30px;" id="div_title">查询结果</div>
        <div id="div_gongli" style="color:#336600; font-weight:bold; padding-left:5px; line-height:35px; font-size:14px;"></div>
        <div id="results" style="font-size: 12px;">        </div>
      </div>
    </div>    </td>
   </tr>
  </table></td>
 </tr>
</table>
  </div>
</body>
</html>
<script language="javascript" type="text/javascript">
  var map = new BMap.Map("container");
  //var mapStyle = { style: "mapbox" }
  //map.setMapStyle(mapStyle);
  map.centerAndZoom(new BMap.Point(116.404, 39.915), 14);
  //map.centerAndZoom(point, 11);
  map.addControl(new BMap.NavigationControl()); // 添加平移缩放控件
  map.addControl(new BMap.OverviewMapControl()); //添加缩略地图控件
  map.enableScrollWheelZoom(); //启用滚轮放大缩小
  map.setMapStyle({ style: "mapbox" });
  function SetMap() {
    var oGl = document.getElementById("div_gongli");
    var ofprovince = document.getElementById("AreaDept1_Province")
    var ofname = document.getElementById("AreaDept1_Prefecture")
    var ofxian = document.getElementById("AreaDept1_Xian")
    var otprovince = document.getElementById("mdd")
    var otname = document.getElementById("cdd");
    var otxian = document.getElementById("xian")
    var output = "全程：";
    if (ofname.value == "") {
      alert('请输入出发地！');
      return;
    }
    if (otname.value == "") {
      alert('请输入到达地!');
      return;
    }
    var title = document.getElementById("div_title");
    title.innerText = "'" + ofprovince.value + ofname.value + ofxian.value + "到" + otprovince.value + otname.value + otxian.value + "' 查询结果";
    var searchComplete = function(results) {
      if (transit.getStatus() != BMAP_STATUS_SUCCESS) { return; }
      var plan = results.getPlan(0);
      output += plan.getDistance(true);       //获取距离
      output += "/";
      output += plan.getDuration(true);        //获取时间
    }
    var transit = new BMap.DrivingRoute(map, { renderOptions: { map: map, panel: "results", autoViewport: true },
      onSearchComplete: searchComplete,
      onPolylinesSet: function() { oGl.innerText = output; }
    });
    transit.search(ofprovince.value + ofname.value + ofxian.value, otprovince.value + otname.value + otxian.value);
  }
  function SetMap2() {
    var oGl = document.getElementById("div_gongli");
    var ofname = document.getElementById("farea");
    var otname = document.getElementById("tarea");
    var output = "全程：";
    if (ofname.value == "") {
      alert('请输入出发地！');
      return;
    }
    if (otname.value == "") {
      alert('请输入到达地!');
      return;
    }
    var title = document.getElementById("div_title");
    title.innerText = "'" + ofname.value + "到" + otname.value + "' 查询结果";
    var searchComplete = function(results) {
      if (transit.getStatus() != BMAP_STATUS_SUCCESS) { return; }
      var plan = results.getPlan(0);
      output += plan.getDistance(true);       //获取距离
      output += "/";
      output += plan.getDuration(true);        //获取时间
    }
    var transit = new BMap.DrivingRoute(map, { renderOptions: { map: map, panel: "results", autoViewport: true },
      onSearchComplete: searchComplete,
      onPolylinesSet: function() { oGl.innerText = output; }
    });
    transit.search(ofname.value, otname.value);
  }
</script>