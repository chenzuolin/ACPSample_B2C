<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sec.dao.*" %>
<%@ page import="com.sec.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="js/echarts.min.js"></script>
</head>
<body>
<%
	List<Dynamic> list = (List<Dynamic>)request.getAttribute("list");//周查询
			int i=0;
			int o=i;
%>
	<div id="main" style="width: 100%;height:560px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '本周日蔬菜价格变化'
            },
            tooltip : {
            	          trigger: 'axis'
            	      },
            
            toolbox: {
            	         show : true,
            	         feature : {
            	             mark : {show: true},
            	             dataView : {show: true, readOnly: false},
            	             magicType : {show: true, type: ['line', 'bar']},
            	             restore : {show: true},
            	             saveAsImage : {show: true}
            	         }
            	     },
            	     calculable : true,
        
            legend: {
                data:['绿盟价','市场价']
            },
            xAxis: {
            	type: 'category',
	            axisTick: {show: false},
                data: ["星期一","星期二","星期三","星期四","星期五","星期六","星期日"]
            },
           
            yAxis: {type: 'value',
            	axisLabel: {                   
            		                 formatter: function (value, index) {           
            		                  return value.toFixed(1);      
            		                   }                
            		             }	
            },
            series: [{
                name: '绿盟价',
                type: 'bar',
                data: [<%=list.get(i).getDynamic_Price() %>,
                <%i++;%><%=list.get(i).getDynamic_Price() %>,
                <%i++;%><%=list.get(i).getDynamic_Price() %>,
                <%i++;%><%=list.get(i).getDynamic_Price() %>,
                <%i++;%><%=list.get(i).getDynamic_Price() %>,
                <%i++;%><%=list.get(i).getDynamic_Price() %>,
                <%i++;%><%=list.get(i).getDynamic_Price() %>,],
                itemStyle: {
					normal: {
						color:'#04bf7c'
					}
                },
						label: {
							show: true, //开启显示
							position: 'top', //在上方显示
							textStyle: { //数值样式
								color: 'black',
								fontSize: 16
							}
						}
            },
            {
                name: '市场价',
                type: 'bar',
                data: [<%=list.get(o).getDynamic_Market_Price() %>,
                <%o++;%><%=list.get(o).getDynamic_Market_Price() %>,
                <%o++;%><%=list.get(o).getDynamic_Market_Price() %>,
                <%o++;%><%=list.get(o).getDynamic_Market_Price() %>,
                <%o++;%><%=list.get(o).getDynamic_Market_Price() %>,
                <%o++;%><%=list.get(o).getDynamic_Market_Price() %>,
                <%o++;%><%=list.get(o).getDynamic_Market_Price() %>,],
                itemStyle: {
					normal: {
						color:'orange'
					}
                },
						label: {
							show: true, //开启显示
							position: 'top', //在上方显示
							textStyle: { //数值样式
								color: 'black',
								fontSize: 16
							}
						}
                
            }
            ]
              };
        
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>

</body>
</html>