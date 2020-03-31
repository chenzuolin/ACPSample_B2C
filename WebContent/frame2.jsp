<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="layui/css/layui.css">
 <link rel="stylesheet" type="text/css" href="tubiao/iconfont.css">
 <style type="text/css">
	.item{
		font-size:15px;
	}
	.layui-icon{
		margin-left:20px;
	}
 </style>
</head>
<body>
<div class="layui-side layui-bg-black">
     <div class="layui-side-scroll">
          <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
          <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
              <span class="layui-nav-item">
          <a href="caishangshouye.jsp" target="fc" class="item iconfont icon-shouye-1"><span style="margin-left:10px;font-size:15px;">我的首页</span></a> </span>
              <li class="layui-nav-item">
              <a href="#" class="item iconfont icon-shangpinshangchuan"><span style="margin-left:10px;font-size:15px;">商品上传</span></a>
              <dl class="layui-nav-child">
                <dd><a href="404.jsp"target="fc" class="layui-icon iconfont icon-shengxian"><span style="margin-left:10px;font-size:14px;">生鲜</span></a></dd>
                <dd><a href="404.jsp"target="fc" class="layui-icon iconfont icon-lengdong"><span style="margin-left:10px;font-size:14px;">冷鲜</span></a></dd>
                <dd><a href="404.jsp"target="fc" class="layui-icon iconfont icon-tiaoliao"><span style="margin-left:10px;font-size:14px;">调料</span></a></dd>
              </dl>
            </li>
            <li class="layui-nav-item">
              <a href="#" class="item iconfont icon-dingdan"><span style="margin-left:10px;font-size:15px;">我的订单</span></a>
              <dl class="layui-nav-child">
                <dd><a href="UserControllers6" target="fc" class="layui-icon iconfont icon-dingdan1" style="margin-left:13px;"><span style="margin-left:5px;font-size:14px;">待接收的订单</span></a></dd>
                <dd><a href="UserControllers7"target="fc" class="layui-icon iconfont icon-daijieshoudingdan"><span style="margin-left:10px;font-size:14px;">已接收的订单</span></a></dd>
                <dd><a href="Greens_JobberIndent3.jsp" target="fc" class="layui-icon iconfont icon-wanchengdingdan"><span style="margin-left:10px;font-size:14px;">查询订单</span></a></dd>
                <dd><a href="KKK.jsp" target="fc" class="layui-icon iconfont icon-nian"><span style="margin-left:10px;font-size:14px;">待分拣蔬菜小计</span></a></dd>
              </dl>
              
              
            
             <li class="layui-nav-item">
              <a href="#" class="item iconfont icon-xiaoliang"><span style="margin-left:10px;font-size:15px;">蔬菜销售量</span></a>
              <dl class="layui-nav-child">
              <dd><a href="Q8.jsp" target="fc" class="layui-icon iconfont icon-day"><span style="margin-left:10px;font-size:14px;">日销量</span></a></dd>
                <dd><a href="Q1.jsp" target="fc" class="layui-icon iconfont icon-zhou"><span style="margin-left:10px;font-size:14px;">周销量</span></a></dd>
                <dd><a href="Q3.jsp" target="fc" class="layui-icon iconfont icon-yue-copy"><span style="margin-left:10px;font-size:14px;">月销量</span></a></dd>
                <dd><a href="Q5.jsp" target="fc" class="layui-icon iconfont icon-nian"><span style="margin-left:10px;font-size:14px;">年销量</span></a></dd>
                <dd><a href="Time5.jsp" target="fc" class="layui-icon iconfont icon-nian"><span style="margin-left:10px;font-size:14px;">按时间段查询酒店采购量</span></a></dd>
              </dl>
            </li>
              <li class="layui-nav-item">
            <a href="L1.jsp" target="fc" class="item iconfont icon-yue-copy"><span style="margin-left:10px;font-size:15px;">蔬菜月销量</span></a></li>
                   <li class="layui-nav-item">
            <a href="P1.jsp" target="fc" class="item iconfont icon-purchase_volume"><span style="margin-left:10px;font-size:15px;">查询酒店采购量</span></a></li>
            
           <li class="layui-nav-item">
              <a href="javascript:;" target="fc" class="item iconfont icon-shichanghangqing"><span style="margin-left:10px;font-size:15px;">市场行情</span></a>
              <dl class="layui-nav-child">
                <dd><a href="V1.jsp"target="fc" class="layui-icon iconfont icon-zhou"><span style="margin-left:10px;font-size:14px;">周行情</span></a></dd>
                <dd><a href="V3.jsp"target="fc" class="layui-icon iconfont icon-yue-copy"><span style="margin-left:10px;font-size:14px;">月行情</span> </a></dd>
                
              </dl>
            </li>
            
                 <li class="layui-nav-item">
              <a href="#" class="item iconfont icon-caiwushuju"><span style="margin-left:10px;font-size:15px;">查询财务数据</span></a>
              <dl class="layui-nav-child">
                <dd><a href="T3.jsp"target="fc" class="layui-icon iconfont icon-rilidangtian"><span style="margin-left:10px;font-size:14px;">当天酒店销售额</span></a><dd>
                <dd><a href="T5.jsp"target="fc" class="layui-icon iconfont icon-rilidangtian"><span style="margin-left:10px;font-size:14px;">当天总销售额</span></a></dd>
                <dd><a href="T6.jsp"target="fc" class="layui-icon iconfont icon-shijianchaxunshili"><span style="margin-left:10px;font-size:14px;">按时间查询酒店销售额</span></a></dd>
                <dd><a href="T8.jsp"target="fc" class="layui-icon iconfont icon-shijianchaxunshili"><span style="margin-left:10px;font-size:14px;">按时间查询总销售额</span></a></dd>
              </dl>
            </li>
            
 
            <li class="layui-nav-item">
            <a href="CSFK.jsp" target="fc" class="item iconfont icon-tousuliuyanjianyi"><span style="margin-left:10px;font-size:15px;">查看投诉</span></a></li>
             <li class="layui-nav-item">
            <a href="Z2.jsp" target="fc" class="item iconfont icon-rilidangtian"><span style="margin-left:10px;font-size:15px;">查看推送消息</span></a></li>
                      <li class="layui-nav-item">
              <a href="ListServlet" target="fc" class="item iconfont icon-wodeshangpin"><span style="margin-left:10px;font-size:15px;">我的商品</span></a>
              <li class="layui-nav-item">
              <a href="FindAllGreens.jsp" target="fc" class="item iconfont icon-wodeshangpin"><span style="margin-left:10px;font-size:15px;">价格修改</span></a>
              <li class="layui-nav-item">
              <a href="#" class="item iconfont icon-set"><span style="margin-left:10px;font-size:15px;">系统设置</span></a>
              <dl class="layui-nav-child">
                <dd><a href="uerinfo.jsp" target="fc" class="layui-icon iconfont icon-jibenziliao"><span style="margin-left:10px;font-size:14px;">基本资料</span></a></dd>
                 
              </dl>
             
         
        </div>
      </div> 
 
  
	<script src="layui/layui.all.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>