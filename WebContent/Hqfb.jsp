<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.wrapper{width:500px; height:300px; margin-left:100px}
</style>
<script src="js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script src="js/jquery.jqChart.min.js" type="text/javascript"></script>
<!--[if IE]><script lang="javascript" type="text/javascript" src="js/excanvas.js"></script>
<![endif]-->
<script lang="javascript" type="text/javascript">
$(document).ready(function () {
	$('#jqChart').jqChart({
		title: { text: '柱形图示例' },
		axes: [
			{
				location: 'left',//y轴位置，取值：left,right
				minimum: 10,//y轴刻度最小值
				maximum: 100,//y轴刻度最大值
				interval: 10//刻度间距
			}
		],
		series: [
			//数据1开始
			{
				type: 'column',//图表类型，取值：column 柱形图，line 线形图
				title:'蔬菜',//标题
				data: [['日', 70], ['周', 40], ['月', 55],]//数据内容，格式[[x轴标题,数值1],[x轴标题,数值2],......]
			},
			//数据1结束
			//数据2
			{
				type: 'column',
				title:'生鲜',
				data: [['日', 40], ['周', 50], ['月', 95], ]
			},
			//数据2结束
			//数据3
			{
			type: 'column',
			title:'生冷',
			data: [['日', 70], ['周', 40], ['月', 10
			], ]
			},
			//数据3结束		
			//数据3
			{
			type: 'column',
			title:'调料',
			data: [['日', 70], ['周', 40], ['月', 55], ]
			},
			//数据3结束		
		]
	});
});
</script>
</head>
<body>
<div class="wrapper">
<!-- 代码 开始 -->
    <div>
        <div id="jqChart" style="width:1200px; height: 650px;"></div>
    </div>
<!-- 代码 结束 -->
</div>
<div style="text-align:center;clear:both">

</div>
</body>
</html>