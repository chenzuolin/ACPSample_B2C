package com.sec.getui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import com.sec.dao.QunTuiDao;
import com.sec.entity.QunTui;

/**
 * Servlet implementation class getuiServelt1
 */
@WebServlet("/getuiServelt1")
public class getuiServelt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static String   appId = "cw0SK1P5l1AZjYuS0QnVa8";
	    private static String appKey = "6twIx84uVu92cK7PU2Hj36";
	    private static String masterSecret = "41B6Ad8oDy5BslFyOxT9g7";
	    String host = "http://sdk.open.api.igexin.com/apiex.htm";
	    static String CID = null;
	    static String Title = null;
	    static String Text = null;
	    static String Adress = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getuiServelt1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		  CID = request.getParameter("Wineshop_CID");//传过来的CID
		  System.out.println(CID+"CID");
		  
		   Title = request.getParameter("GeTuiTitle");
		      Text = request.getParameter("GeTuiText");
		      Adress = request.getParameter("GeTuiAdress");
		  
		 IGtPush push = new IGtPush(host, appKey, masterSecret);
	        LinkTemplate template = linkTemplateDemo();
	        SingleMessage message = new SingleMessage();
	        message.setOffline(true);
	        // 离线有效时间，单位为毫秒，可选
	        message.setOfflineExpireTime(24 * 3600 * 1000);
	        message.setData(template);
	        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
	        message.setPushNetWorkType(0);
	        Target target = new Target();
	        target.setAppId(appId);
	        target.setClientId(CID);
	        //target.setAlias(Alias);
	        IPushResult ret = null;
	        try {
	            ret = push.pushMessageToSingle(message, target);
	        } catch (RequestException e) {
	            e.printStackTrace();
	            ret = push.pushMessageToSingle(message, target, e.getRequestId());
	        }
	        if (ret != null) {
	            System.out.println(ret.getResponse().toString());
	        } else {
	            System.out.println("服务器响应异常");
	        }
	        PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('推送成功');window.location.href='QunTui.jsp'</script>");
	        System.out.println(ret.getResponse().toString());
	}
	
	 public static LinkTemplate linkTemplateDemo() {
		 
	        LinkTemplate template = new LinkTemplate();
	        // 设置APPID与APPKEY
	        template.setAppId(appId);
	        template.setAppkey(appKey);

	        Style0 style = new Style0();
	        // 设置通知栏标题与内容
	        style.setTitle(Title);
	        style.setText(Text);
	        // 配置通知栏图标
	        style.setLogo("icon.png");
	        // 配置通知栏网络图标
	        style.setLogoUrl("");
	        // 设置通知是否响铃，震动，或者可清除
	        style.setRing(true);
	        style.setVibrate(true);
	        style.setClearable(true);
	        template.setStyle(style);

	        // 设置打开的网址地址
	        template.setUrl(Adress);
	        
	        QunTuiDao dao = new QunTuiDao();
	        QunTui quntui = new QunTui();
	       int c = dao.Select(CID);//集合的长度
	       System.out.println(c+"=c");
	       String d = dao.findUserByID1(CID);//查处Wineshop_UserName
	       System.out.println(d+"d");
	       if(c==1) {
	    	    String aa = dao.Select1(CID);
	    	    if(aa==null) {
	    	    	
	    	    
	    	    quntui.setWineshop_CID(CID);
	   	        quntui.setQunTui_Title(Title);
	   	        quntui.setQunTui_Text(Text);
	   	        quntui.setQunTui_Adress(Adress);
	   	        dao.update(quntui); 
	    	    }else {
	    	    	quntui.setWineshop_UserName(d);
	  	    	   quntui.setWineshop_CID(CID);
	  	    	   quntui.setQunTui_Title(Title);
	  	    	   quntui.setQunTui_Text(Text);
	  	    	   quntui.setQunTui_Adress(Adress);
	  	    	   dao.add1(quntui);
	    	    }
	       }else {
	    	   
	    	   quntui.setWineshop_UserName(d);
	    	   quntui.setWineshop_CID(CID);
	    	   quntui.setQunTui_Title(Title);
	    	   quntui.setQunTui_Text(Text);
	    	   quntui.setQunTui_Adress(Adress);
	    	   dao.add1(quntui);
	       }
	      
	        
	        return template;
	    } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
