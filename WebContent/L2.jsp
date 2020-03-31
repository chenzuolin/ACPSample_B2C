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
		//2018-01
		OrderDao dao1 = new OrderDao();
		IndentDao dao = new IndentDao();
		int aa = (Integer)request.getSession().getAttribute("bb");
		System.out.print(aa);
		int a = 0;
		List<Indent> list1 = dao.findUserByID5("2018-01-01", "2018-02-01");
		for(Indent indent : list1){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					a += dd;
				}
			}
		}
		
		int b = 0;
		List<Indent> list2 = dao.findUserByID5("2018-02-01", "2018-03-01");
		for(Indent indent : list2){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					b += dd;
				}
			}
		}
		
		int c = 0;
		List<Indent> list3 = dao.findUserByID5("2018-03-01", "2018-04-01");
		for(Indent indent : list3){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					c += dd;
				}
			}
		}
		
		int d = 0;
		List<Indent> list4 = dao.findUserByID5("2018-04-01", "2018-05-01");
		for(Indent indent : list4){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					d += dd;
				}
			}
		}
		
		int e = 0;
		List<Indent> list5 = dao.findUserByID5("2018-05-01", "2018-06-01");
		for(Indent indent : list5){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					e += dd;
				}
			}
		}
		
		int f = 0;
		List<Indent> list6 = dao.findUserByID5("2018-06-01", "2018-07-01");
		for(Indent indent : list6){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					f += dd;
				}
			}
		}
		
		int g = 0;
		List<Indent> list7 = dao.findUserByID5("2018-07-01", "2018-08-01");
		for(Indent indent : list7){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					g += dd;
				}
			}
		}
		
		int h = 0;
		List<Indent> list8 = dao.findUserByID5("2018-08-01", "2018-09-01");
		
		for(Indent indent : list8){
			int bb = indent.getIndent_ID();
			System.out.print(bb);
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					h += dd;
				}
			}
		}
		
		int i = 0;
		List<Indent> list9 = dao.findUserByID5("2018-09-01", "2018-10-01");
		for(Indent indent : list9){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					i += dd;
				}
			}
		}
		
		int j = 0;
		List<Indent> list10 = dao.findUserByID5("2018-10-01", "2018-11-01");
		for(Indent indent : list10){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					j += dd;
				}
			}
		}
		
		int k = 0;
		List<Indent> list11 = dao.findUserByID5("2018-11-01", "2018-12-01");
		for(Indent indent : list11){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					k += dd;
				}
			}
		}
		
		int l = 0;
		List<Indent> list12 = dao.findUserByID5("2018-12-01", "2019-01-01");
		for(Indent indent : list12){
			int bb = indent.getIndent_ID();
			List<Order> ll1 = dao1.findUserByID1(bb);
			for(Order order : ll1){
				int cc = order.getGreens_ID();
				if(aa==cc){
					int dd = order.getNumber();
					l += dd;
				}
			}
		}
		
	%>
	  <div id="main" style="width: 100%;height:500px;margin-top:50px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '2018年蔬菜月销量'
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
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"]
            },
           
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [<%=a %>,<%=b %>,<%=c %>,<%=d %>,<%=e %>,<%=f %>,<%=g %>,<%=h %>,<%=i %>,<%=j %>,<%=k %>,<%=l %>]
            }]
              };
        
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>