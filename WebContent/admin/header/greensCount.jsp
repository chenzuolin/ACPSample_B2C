<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售统计</title>
<style>
</style>
</head>
<body>
<script type="text/javascript" src="../js/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
 <div id="main" style="width: 100%;height:700px;"></div>
 <script>
 var myChart = echarts.init(document.getElementById('main'));

 $.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/GreensCoount",
		dataType:"json",
		success:function(obj){
			option = {
				    tooltip: {
				        trigger: 'item',
				        formatter: "{a} <br/>{b}: {c} ({d}%)"
				    },
// 				    legend: {
// 				        orient: 'vertical',
// 				        x: 'left',
// 				        y: 'top',
// 				        itemWidth: 20,   
// 			            itemHeight: 15,  
// 			            itemGap: 3,
// 				    	icon: "circle",
// 				        data:obj
// 				    },
				    series: [
				        {
				            name:'销售统计',
				            type:'pie',
				            radius: ['50%', '70%'],
				            avoidLabelOverlap: false,
				            label: {
				            	 normal: {
				                     formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
				                     backgroundColor: '#eee',
				                     borderColor: '#aaa',
				                     borderWidth: 1,
				                     borderRadius: 4,
				                     // shadowBlur:3,
				                     // shadowOffsetX: 2,
				                     // shadowOffsetY: 2,
				                     // shadowColor: '#999',
				                     // padding: [0, 7],
				                     rich: {
				                         a: {
				                             color: '#999',
				                             lineHeight: 22,
				                             align: 'center'
				                         },
				                         // abg: {
				                         //     backgroundColor: '#333',
				                         //     width: '100%',
				                         //     align: 'right',
				                         //     height: 22,
				                         //     borderRadius: [4, 4, 0, 0]
				                         // },
				                         hr: {
				                             borderColor: '#aaa',
				                             width: '100%',
				                             borderWidth: 0.5,
				                             height: 0
				                         },
				                         b: {
				                             fontSize: 16,
				                             lineHeight: 33
				                         },
				                         per: {
				                             color: '#eee',
				                             backgroundColor: '#334455',
				                             padding: [2, 4],
				                             borderRadius: 2
				                         }
				                     }
				                 },
				                emphasis: {
				                    show: true,
				                    textStyle: {
				                        fontSize: '30',
				                        fontWeight: 'bold'
				                    }
				                }
				            },
				            labelLine: {
				                normal: {
				                    show: false
				                }
				            },
				            data:obj
				        }
				    ]
				};
			 myChart.setOption(option);
		}
	});
 
 </script>
</body>
</html>